package net.cd.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.igniterealtime.restclient.RestApiClient;
import org.igniterealtime.restclient.entity.AuthenticationToken;
import org.igniterealtime.restclient.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import net.cd.common.util.RandomString;
import net.cd.common.util.SMSServiceUtil;
import net.cd.common.util.StatusUtil;
import net.cd.common.util.UserUtil;
import net.cd.common.util.constant.UserConstant;
import net.cd.common.web.BaseEndpoint;
import net.cd.dto.kernal.CdKAuthDto;
import net.cd.dto.kernal.CdKMemberAuthDto;
import net.cd.dto.kernal.CdKMemberDto;
import net.cd.dto.kernal.CdKMemberRoleDto;
import net.cd.exception.CdErrors;
import net.cd.exception.CdException;
import net.cd.extern.sms.accessyou.CdSMSVendor;
import net.cd.extern.xmpp.openfire.CdXMPPInterface;
import net.cd.jpa.entity.kernal.CdKAuthEntity;
import net.cd.jpa.entity.kernal.CdKMemberRoleEntity.MemberRoleRelativeIdentity;
import net.cd.service.kernal.CdKAuthService;
import net.cd.service.kernal.CdKMemberAuthService;
import net.cd.service.kernal.CdKMemberRoleService;
import net.cd.service.kernal.CdKMemberService;

/**
 * Created by Vincent on 07/12/2017.
 */
@RestController
@RequestMapping("/member")
@Api(value = "Member Manipulation API Endpoint", description = "Manipulate Member Data Entities Endpoint")
public class CdMemberEndpoint extends BaseEndpoint {

	@Autowired
	private CdKMemberService cdKMemberService;

	@Autowired
	private CdKMemberRoleService cdKMemberRoleService;

	@Autowired
	private CdKAuthService cdKAuthService;

	@Autowired
	@Value("#{cdLengthResetPasswordTemporaryCode}")
	private Integer cdLengthResetPasswordTemporaryCode;

	@Autowired
	private CdKMemberAuthService cdKMemberAuthService;

	@Autowired
	UserUtil userUtil;
	
	@Autowired
	private SMSServiceUtil smsServiceUtil;
	
	@Autowired
	@Value("#{cdLengthResetPasswordTemporaryTTL}")
	private Integer cdLengthResetPasswordTemporaryTTL;

	@Autowired
	CdXMPPInterface xmppInterface;

	@RequestMapping(value = "/registration/{username}/{password}", method = RequestMethod.POST)
    @ApiOperation("Exec member registration")
    public @ResponseBody Object doMemberRegistration(@PathVariable String username, @PathVariable String password ) throws Exception {
    		
        CdKMemberDto cdKMemberDto = cdKMemberService.findByIdentifier(username);
        
        try {
            if (cdKMemberDto != null && cdKMemberDto.getActivated() == 1) {
                throw new CdException(CdErrors.CD_K_MEMBER_USERNAME_ALREADY_EXISTS);
            }
          //send sms to member for activation code first
            CdSMSVendor smsVendor = new CdSMSVendor();
             
        		String activateCode = userUtil.generateRandomActivationCode();
        		String fullSMSServiceURL = smsServiceUtil.getFullSMSServiceURL(activateCode, username);
        		
        		smsVendor.setURL(fullSMSServiceURL);
        		String resultSMSSend = smsVendor.send();
        		if(!resultSMSSend.equals(String.valueOf(StatusUtil.SUCCESS_STATUS))){
        			//set response status to 417
        			response.setStatus(HttpServletResponse.SC_EXPECTATION_FAILED);
        			return resultSMSSend+"|"+fullSMSServiceURL;
        		}
        		if(cdKMemberDto == null || cdKMemberDto.getId() == null) {
        			cdKMemberDto = new CdKMemberDto();
        		}
        		
        		cdKMemberDto.setIdentifier(username);
            cdKMemberDto.setActivateCode(activateCode);
            cdKMemberDto.setActivated(UserConstant.STATUS_INACTIVATED);
            //Insert into member tabld first
            cdKMemberDto = cdKMemberService.save(cdKMemberDto);
            
            List<CdKAuthDto> listAuths = cdKAuthService.findByMember(cdKMemberDto.getId());
            //Then insert into authen table
            if( listAuths == null || listAuths.size() == 0) {
	            CdKAuthDto oauth = new CdKAuthDto();
	            oauth.setMember(cdKMemberDto.getId());
	            oauth.setMethod(CdKAuthEntity.Method.OAUTH);
	            oauth.setSecret(new Md5PasswordEncoder().encodePassword(password,""));
	            cdKAuthService.save(oauth);
            
	            //Insert into member authen table
	            CdKMemberAuthDto memberOAuth = new CdKMemberAuthDto();
	            memberOAuth.setMember(cdKMemberDto);
	            memberOAuth.setAuth(oauth);
	            cdKMemberAuthService.save(memberOAuth);
        
	            //begin call to xmpp server for new jid and jid password
	            // TODO: switch to Bill service layer code for xmpp server invoking apis
	            AuthenticationToken authenticationToken = new AuthenticationToken(StatusUtil.XMPP_USER_NAME,
	                    StatusUtil.XMPP_PASSWORD);
	            RestApiClient restApiClient = new RestApiClient(StatusUtil.XMPP_DOMAIN, 9090, authenticationToken);
	            restApiClient.getRestClient();
	
	            RandomString randomString = new RandomString();
	            UserEntity userEntity;
	            String jid;
	            String passJid;
	            do {
	                jid = randomString.createUUID();
	                userEntity = restApiClient.getUser(jid);
	            } while (userEntity != null);
	            passJid = randomString.createUUID();
	
	            userEntity = new UserEntity(jid, null, null, passJid);
	            restApiClient.createUser(userEntity);
	            
	            //insert new row with xmpp method into auth table
	            CdKAuthDto authXMPP = new CdKAuthDto();
	            authXMPP.setMember(cdKMemberDto.getId());
	            authXMPP.setAccount(jid);
	            authXMPP.setSecret(passJid);
	            authXMPP.setMethod(CdKAuthEntity.Method.XMPP);
	            cdKAuthService.save(authXMPP);
	            //insert new row into member auth table
	            CdKMemberAuthDto memberAuthXMPP = new CdKMemberAuthDto();
	            memberAuthXMPP.setMember(cdKMemberDto);
	            memberAuthXMPP.setAuth(authXMPP);
	            cdKMemberAuthService.save(memberAuthXMPP);
	
	            //insert into member role table
	            CdKMemberRoleDto memberRole = new CdKMemberRoleDto();
	            memberRole.setMember(cdKMemberDto);
	            memberRole.setIdentity(MemberRoleRelativeIdentity.REGISTRANT);
	            memberRole.setIdentifier(1);
	            memberRole.setActive(UserConstant.STATUS_ACTIVATED);
	            cdKMemberRoleService.save(memberRole);
            }
            
        } catch (Exception e) {
        		response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            throw e;
        }

        response.setStatus(HttpServletResponse.SC_CREATED);

        return true;
	}
	
	@RequestMapping(value = "/registration/activate/{username}/{activateCode}", method = RequestMethod.POST)
    @ApiOperation("Exec member registration")
    public @ResponseBody Object doActivateMemberAfterRegistration(@PathVariable String username, @PathVariable String activateCode ) throws Exception {
		
		CdKMemberDto cdKMemberDto = cdKMemberService.findByIdentifierAndActivateCodeAndActivated(username, activateCode, 0);
       
		if (cdKMemberDto == null) {
			response.setStatus(HttpServletResponse.SC_EXPECTATION_FAILED);
			throw new CdException(CdErrors.CD_K_MEMBER_NOT_EXISTS);
		}
		
		cdKMemberDto.setActivated(UserConstant.STATUS_ACTIVATED);
		cdKMemberService.save(cdKMemberDto);
		
		response.setStatus(HttpServletResponse.SC_ACCEPTED); 
        return true;
	}
	

}

package net.cd.configuration;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.cd.jpa.entity.kernal.CdKAuthEntity;
import net.cd.jpa.entity.kernal.CdKAuthEntity.Method;
import net.cd.jpa.entity.kernal.CdKMemberEntity;
import net.cd.jpa.entity.kernal.CdKMemberRoleEntity;
import net.cd.jpa.entity.security.AuthenticationUser;
import net.cd.repository.kernal.CdKAuthRepository;
import net.cd.repository.kernal.CdKMemberRepository;
import net.cd.repository.kernal.CdKMemberRoleRepository;

@Service("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	CdKMemberRepository memberRepository;
	
	@Autowired
	CdKAuthRepository authRepository;
	
	@Autowired
	CdKMemberRoleRepository memberRoleRepository;
	

	@Transactional(readOnly = true)
	public AuthenticationUser loadUserByUsername(String identifier) throws UsernameNotFoundException {
		CdKMemberEntity member = memberRepository.findByIdentifier(identifier);
		if (member == null) {
			throw new UsernameNotFoundException("Username not found");
		}
		List<CdKAuthEntity> auths = authRepository.findByMember(member.getId());
		
		CdKAuthEntity auth = null;
		CdKAuthEntity xmppAuth = null;
		for(CdKAuthEntity a : auths) {
			if(a.getMethod() == Method.OAUTH) {
				auth = a;
			} else if(a.getMethod() == Method.XMPP) {
				xmppAuth = a;
			}
		}
		AuthenticationUser authenticationUser = new AuthenticationUser(member.getIdentifier(), auth.getSecret(),
				member.getActivated() == 1, true, true, true, getGrantedAuthorities(member));
		authenticationUser.setEmail(member.getEmail());
		authenticationUser.setId(member.getId());
		authenticationUser.setIdentifier(member.getIdentifier());
		authenticationUser.setMobile(member.getMobile());
		authenticationUser.setJid(xmppAuth.getAccount());
		authenticationUser.setXmppPassword(xmppAuth.getSecret());
		
		return authenticationUser;
	}

	private List<GrantedAuthority> getGrantedAuthorities(CdKMemberEntity member) {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		List<CdKMemberRoleEntity> memberRoles = memberRoleRepository.findByMember(member);
		
		for (CdKMemberRoleEntity memberRole : memberRoles) {
			authorities.add(new SimpleGrantedAuthority("CD_ROLE_" + memberRole.getIdentity()));
		}
		return authorities;
	}

}

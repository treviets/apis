package net.cd.controller;

import net.cd.service.security.CdOAuth2Service;
import net.cd.service.security.CdOAuth2TokenType;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * Created by Tree.Yip on 25/6/2017.
 */
@RestController
@RequestMapping("/oauth")
@Api(value = "OAuth2 Token Revocation API Endpoint", description = "Revoke OAuth2 Token Endpoint")
public class CdOAuth2RevokeEndpoint {

    @Autowired
    CdOAuth2Service cdOAuth2Service;

    @RequestMapping(value = "/revoke", method = RequestMethod.POST)
    public boolean revokeToken(@RequestParam("token") String token,
                            @RequestParam(value = "token_type", required = false) CdOAuth2TokenType cdOAuth2TokenType,
                            Principal principal) {
        cdOAuth2Service.revoke(token, cdOAuth2TokenType, principal);
        return true;
    }
}

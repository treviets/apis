package net.cd.service.security.impl;

import net.cd.service.security.CdOAuth2Service;
import net.cd.service.security.CdOAuth2TokenType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2RefreshToken;
import org.springframework.security.oauth2.common.exceptions.InvalidGrantException;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.stereotype.Service;

import java.security.Principal;

/**
 * Created by Vincent 01/12/2017
 */
@Service
public class CdOAuth2ServiceImpl implements CdOAuth2Service {

    @Autowired
    private TokenStore tokenStore;

    public boolean revoke(String token, CdOAuth2TokenType tokenType, Principal principal) {
        if (tokenType.equals(CdOAuth2TokenType.refresh_token)) {
            return revokeRefreshToken(token, principal) || revokeAccessToken(token, principal);
        } else {
            return revokeAccessToken(token, principal) || revokeRefreshToken(token, principal);
        }
    }

    private boolean revokeAccessToken(String token, Principal principal) {
        OAuth2AccessToken accessToken = tokenStore.readAccessToken(token);
        if (accessToken != null) {
            OAuth2Authentication auth2Authentication = tokenStore.readAuthentication(accessToken);
            if (!auth2Authentication.getOAuth2Request().getClientId().equals(principal.getName())) {
                throw new InvalidGrantException("Invalid client id");
            }
            tokenStore.removeAccessToken(accessToken);
            return true;
        }
        return false;
    }

    private boolean revokeRefreshToken(String token, Principal principal) {
        OAuth2RefreshToken refreshToken = tokenStore.readRefreshToken(token);
        if (refreshToken != null) {
            OAuth2Authentication auth2Authentication = tokenStore.readAuthenticationForRefreshToken(refreshToken);
            if (!auth2Authentication.getOAuth2Request().getClientId().equals(principal.getName())) {
                throw new InvalidGrantException("Invalid client id");
            }            tokenStore.removeAccessTokenUsingRefreshToken(refreshToken);
            tokenStore.removeRefreshToken(refreshToken);
            return true;
        } else {
            return false;
        }
    }
}

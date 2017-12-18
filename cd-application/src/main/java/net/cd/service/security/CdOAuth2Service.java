package net.cd.service.security;

import java.security.Principal;

/**
 * Created by Vincent 01/12/2017
 */
public interface CdOAuth2Service {

    boolean revoke(String token, CdOAuth2TokenType tokenType, Principal principal);
}

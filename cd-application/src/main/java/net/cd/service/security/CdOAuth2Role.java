package net.cd.service.security;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

/**
 * Created by Vincent 01/12/2017
 */
public enum CdOAuth2Role {
    OP_ROLE_REGISTRANT,
    OP_ROLE_ADMINISTRATOR;

    private SimpleGrantedAuthority authority;

    public SimpleGrantedAuthority getAuthority() {
        return authority;
    }

    CdOAuth2Role() {
        authority = new SimpleGrantedAuthority(this.name());
    }
}

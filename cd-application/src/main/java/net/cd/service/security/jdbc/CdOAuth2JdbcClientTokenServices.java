package net.cd.service.security.jdbc;

import org.springframework.security.oauth2.client.token.JdbcClientTokenServices;

import javax.sql.DataSource;

/**
 * Created by Vincent 01/12/2017
 */
public class CdOAuth2JdbcClientTokenServices extends JdbcClientTokenServices {

    private static final String cd_DEFAULT_ACCESS_TOKEN_INSERT_STATEMENT = "insert into cd_xOAuth2_client_token (token_id, token, authentication_id, user_name, client_id) values (?, ?, ?, ?, ?)";
    private static final String cd_DEFAULT_ACCESS_TOKEN_FROM_AUTHENTICATION_SELECT_STATEMENT = "select token_id, token from cd_xOAuth2_client_token where authentication_id = ?";
    private static final String cd_DEFAULT_ACCESS_TOKEN_DELETE_STATEMENT = "delete from cd_xOAuth2_client_token where authentication_id = ?";
    
    public CdOAuth2JdbcClientTokenServices(DataSource dataSource) {
        super(dataSource);
        this.setInsertAccessTokenSql(cd_DEFAULT_ACCESS_TOKEN_INSERT_STATEMENT);
        this.setSelectAccessTokenSql(cd_DEFAULT_ACCESS_TOKEN_FROM_AUTHENTICATION_SELECT_STATEMENT);
        this.setDeleteAccessTokenSql(cd_DEFAULT_ACCESS_TOKEN_DELETE_STATEMENT);
    }
}

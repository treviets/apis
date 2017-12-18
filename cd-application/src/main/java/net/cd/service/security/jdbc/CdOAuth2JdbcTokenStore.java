package net.cd.service.security.jdbc;

import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;

import javax.sql.DataSource;

/**
 * Created by Vincent 01/12/2017
 */
public class CdOAuth2JdbcTokenStore extends JdbcTokenStore {

    private static final String cd_DEFAULT_ACCESS_TOKEN_INSERT_STATEMENT = "insert into cd_xOAuth2_access_token (token_id, token, authentication_id, user_name, client_id, authentication, refresh_token) values (?, ?, ?, ?, ?, ?, ?)";
    private static final String cd_DEFAULT_ACCESS_TOKEN_SELECT_STATEMENT = "select token_id, token from cd_xOAuth2_access_token where token_id = ?";
    private static final String cd_DEFAULT_ACCESS_TOKEN_AUTHENTICATION_SELECT_STATEMENT = "select token_id, authentication from cd_xOAuth2_access_token where token_id = ?";
    private static final String cd_DEFAULT_ACCESS_TOKEN_FROM_AUTHENTICATION_SELECT_STATEMENT = "select token_id, token from cd_xOAuth2_access_token where authentication_id = ?";
    private static final String cd_DEFAULT_ACCESS_TOKENS_FROM_USERNAME_AND_CLIENT_SELECT_STATEMENT = "select token_id, token from cd_xOAuth2_access_token where user_name = ? and client_id = ?";
    private static final String cd_DEFAULT_ACCESS_TOKENS_FROM_USERNAME_SELECT_STATEMENT = "select token_id, token from cd_xOAuth2_access_token where user_name = ?";
    private static final String cd_DEFAULT_ACCESS_TOKENS_FROM_CLIENTID_SELECT_STATEMENT = "select token_id, token from cd_xOAuth2_access_token where client_id = ?";
    private static final String cd_DEFAULT_ACCESS_TOKEN_DELETE_STATEMENT = "delete from cd_xOAuth2_access_token where token_id = ?";
    private static final String cd_DEFAULT_ACCESS_TOKEN_DELETE_FROM_REFRESH_TOKEN_STATEMENT = "delete from cd_xOAuth2_access_token where refresh_token = ?";
    private static final String cd_DEFAULT_REFRESH_TOKEN_INSERT_STATEMENT = "insert into cd_xOAuth2_refresh_token (token_id, token, authentication) values (?, ?, ?)";
    private static final String cd_DEFAULT_REFRESH_TOKEN_SELECT_STATEMENT = "select token_id, token from cd_xOAuth2_refresh_token where token_id = ?";
    private static final String cd_DEFAULT_REFRESH_TOKEN_AUTHENTICATION_SELECT_STATEMENT = "select token_id, authentication from cd_xOAuth2_refresh_token where token_id = ?";
    private static final String cd_DEFAULT_REFRESH_TOKEN_DELETE_STATEMENT = "delete from cd_xOAuth2_refresh_token where token_id = ?";
    
    public CdOAuth2JdbcTokenStore(DataSource dataSource) {
        super(dataSource);
        this.setInsertAccessTokenSql(cd_DEFAULT_ACCESS_TOKEN_INSERT_STATEMENT);
        this.setSelectAccessTokenSql(cd_DEFAULT_ACCESS_TOKEN_SELECT_STATEMENT);
        this.setDeleteAccessTokenSql(cd_DEFAULT_ACCESS_TOKEN_DELETE_STATEMENT);
        this.setInsertRefreshTokenSql(cd_DEFAULT_REFRESH_TOKEN_INSERT_STATEMENT);
        this.setSelectRefreshTokenSql(cd_DEFAULT_REFRESH_TOKEN_SELECT_STATEMENT);
        this.setDeleteRefreshTokenSql(cd_DEFAULT_REFRESH_TOKEN_DELETE_STATEMENT);
        this.setSelectAccessTokenAuthenticationSql(cd_DEFAULT_ACCESS_TOKEN_AUTHENTICATION_SELECT_STATEMENT);
        this.setSelectRefreshTokenAuthenticationSql(cd_DEFAULT_REFRESH_TOKEN_AUTHENTICATION_SELECT_STATEMENT);
        this.setSelectAccessTokenFromAuthenticationSql(cd_DEFAULT_ACCESS_TOKEN_FROM_AUTHENTICATION_SELECT_STATEMENT);
        this.setDeleteAccessTokenFromRefreshTokenSql(cd_DEFAULT_ACCESS_TOKEN_DELETE_FROM_REFRESH_TOKEN_STATEMENT);
        this.setSelectAccessTokensFromUserNameSql(cd_DEFAULT_ACCESS_TOKENS_FROM_USERNAME_SELECT_STATEMENT);
        this.setSelectAccessTokensFromUserNameAndClientIdSql(cd_DEFAULT_ACCESS_TOKENS_FROM_USERNAME_AND_CLIENT_SELECT_STATEMENT);
        this.setSelectAccessTokensFromClientIdSql(cd_DEFAULT_ACCESS_TOKENS_FROM_CLIENTID_SELECT_STATEMENT);
    }
}

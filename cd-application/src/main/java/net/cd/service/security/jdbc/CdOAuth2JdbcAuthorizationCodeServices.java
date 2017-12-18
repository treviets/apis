package net.cd.service.security.jdbc;

import org.springframework.security.oauth2.provider.code.JdbcAuthorizationCodeServices;

import javax.sql.DataSource;

/**
 * Created by Vincent 01/12/2017
 */
public class CdOAuth2JdbcAuthorizationCodeServices extends JdbcAuthorizationCodeServices {

    private static final String cd_DEFAULT_SELECT_STATEMENT = "select code, authentication from cd_xOAuth2_code where code = ?";
    private static final String cd_DEFAULT_INSERT_STATEMENT = "insert into cd_xOAuth2_code (code, authentication) values (?, ?)";
    private static final String cd_DEFAULT_DELETE_STATEMENT = "delete from cd_xOAuth2_code where code = ?";

    public CdOAuth2JdbcAuthorizationCodeServices(DataSource dataSource) {
        super(dataSource);
        this.setSelectAuthenticationSql(cd_DEFAULT_SELECT_STATEMENT);
        this.setInsertAuthenticationSql(cd_DEFAULT_INSERT_STATEMENT);
        this.setDeleteAuthenticationSql(cd_DEFAULT_DELETE_STATEMENT);
    }

}

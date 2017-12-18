package net.cd.service.security.jdbc;

import org.springframework.security.oauth2.provider.client.JdbcClientDetailsService;

import javax.sql.DataSource;

/**
 * Created by Vincent 01/12/2017
 */
public class CdOAuth2JdbcClientDetailsService extends JdbcClientDetailsService {

    private static final String cd_CLIENT_FIELDS_FOR_UPDATE = "resource_ids, scope, "
            + "authorized_grant_types, web_server_redirect_uri, authorities, access_token_validity, "
            + "refresh_token_validity, additional_information, autoapprove";
    private static final String cd_CLIENT_FIELDS = "client_secret, " + cd_CLIENT_FIELDS_FOR_UPDATE;
    private static final String BASE_FIND_STATEMENT = "select client_id, " + cd_CLIENT_FIELDS
            + " from cd_xOAuth2_client_details";
    private static final String cd_DEFAULT_FIND_STATEMENT = BASE_FIND_STATEMENT + " order by client_id";
    private static final String cd_DEFAULT_SELECT_STATEMENT = BASE_FIND_STATEMENT + " where client_id = ?";
    private static final String cd_DEFAULT_INSERT_STATEMENT = "insert into cd_xOAuth2_client_details (" + cd_CLIENT_FIELDS
            + ", client_id) values (?,?,?,?,?,?,?,?,?,?,?)";
    private static final String cd_DEFAULT_UPDATE_STATEMENT = "update cd_xOAuth2_client_details " + "set "
            + cd_CLIENT_FIELDS_FOR_UPDATE.replaceAll(", ", "=?, ") + "=? where client_id = ?";
    private static final String cd_DEFAULT_UPDATE_SECRET_STATEMENT = "update cd_xOAuth2_client_details "
            + "set client_secret = ? where client_id = ?";
    private static final String cd_DEFAULT_DELETE_STATEMENT = "delete from cd_xOAuth2_client_details where client_id = ?";
    
    public CdOAuth2JdbcClientDetailsService(DataSource dataSource) {
        super(dataSource);
        this.setSelectClientDetailsSql(cd_DEFAULT_SELECT_STATEMENT);
        this.setDeleteClientDetailsSql(cd_DEFAULT_DELETE_STATEMENT);
        this.setUpdateClientDetailsSql(cd_DEFAULT_UPDATE_STATEMENT);
        this.setUpdateClientSecretSql(cd_DEFAULT_UPDATE_SECRET_STATEMENT);
        this.setInsertClientDetailsSql(cd_DEFAULT_INSERT_STATEMENT);
        this.setFindClientDetailsSql(cd_DEFAULT_FIND_STATEMENT);
    }
}

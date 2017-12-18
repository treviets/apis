package net.cd.service.security.jdbc;

import org.springframework.security.oauth2.provider.approval.JdbcApprovalStore;

import javax.sql.DataSource;

/**
 * Created by Vincent 01/12/2017
 */
public class CdOAuth2JdbcApprovalStore extends JdbcApprovalStore {

    private static final String cd_DEFAULT_ADD_APPROVAL_STATEMENT = String.format("insert into %s ( %s ) values (?,?,?,?,?,?)", new Object[]{"cd_xOAauth2_approvals", "expiresAt,status,lastModifiedAt,userId,clientId,sccde"});
    private static final String cd_DEFAULT_REFRESH_APPROVAL_STATEMENT = String.format("update %s set expiresAt=?, status=?, lastModifiedAt=? where userId=? and clientId=? and sccde=?", new Object[]{"cd_xOAauth2_approvals"});
    private static final String cd_DEFAULT_GET_APPROVAL_SQL = String.format("select %s from %s where userId=? and clientId=?", new Object[]{"expiresAt,status,lastModifiedAt,userId,clientId,sccde", "cd_xOAauth2_approvals"});
    private static final String cd_DEFAULT_DELETE_APPROVAL_SQL = String.format("delete from %s where userId=? and clientId=? and sccde=?", new Object[]{"cd_xOAauth2_approvals"});
    private static final String cd_DEFAULT_EXPIRE_APPROVAL_STATEMENT = String.format("update %s set expiresAt = ? where userId=? and clientId=? and sccde=?", new Object[]{"cd_xOAauth2_approvals"});

    public CdOAuth2JdbcApprovalStore(DataSource dataSource) {
        super(dataSource);
        this.setAddApprovalStatement(cd_DEFAULT_ADD_APPROVAL_STATEMENT);
        this.setFindApprovalStatement(cd_DEFAULT_GET_APPROVAL_SQL);
        this.setDeleteApprovalStatment(cd_DEFAULT_DELETE_APPROVAL_SQL);
        this.setExpireApprovalStatement(cd_DEFAULT_EXPIRE_APPROVAL_STATEMENT);
        this.setRefreshApprovalStatement(cd_DEFAULT_REFRESH_APPROVAL_STATEMENT);
    }
}

package net.cd.dto.kernal;

import javax.validation.constraints.NotNull;

/**
 * Created by Vincent 01/12/2017
 */
public class CdKMemberAuthDto {

    @NotNull
    private Integer id;
    private CdKMemberDto member;
    private CdKAuthDto auth;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public CdKMemberDto getMember() {
        return member;
    }

    public void setMember(CdKMemberDto member) {
        this.member = member;
    }

    public CdKAuthDto getAuth() {
        return auth;
    }

    public void setAuth(CdKAuthDto auth) {
        this.auth = auth;
    }
}

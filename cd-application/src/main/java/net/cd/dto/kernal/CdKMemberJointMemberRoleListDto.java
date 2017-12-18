package net.cd.dto.kernal;

import java.util.List;

/**
 * Created by Vincent 01/12/2017
 */
public class CdKMemberJointMemberRoleListDto {

    CdKMemberDto cdKMemberDto;
    List<CdKMemberRoleDto> cdKMemberRoleDtoList;

    public CdKMemberJointMemberRoleListDto() {
    }

    public CdKMemberJointMemberRoleListDto(CdKMemberDto cdKMemberDto, List<CdKMemberRoleDto> cdKMemberRoleDtoList) {
        this.cdKMemberDto = cdKMemberDto;
        this.cdKMemberRoleDtoList = cdKMemberRoleDtoList;
    }

    public CdKMemberDto getCdKMemberDto() {
        return cdKMemberDto;
    }

    public void setCdKMemberDto(CdKMemberDto cdKMemberDto) {
        this.cdKMemberDto = cdKMemberDto;
    }

    public List<CdKMemberRoleDto> getCdKMemberRoleDtoList() {
        return cdKMemberRoleDtoList;
    }

    public void setCdKMemberRoleDtoList(List<CdKMemberRoleDto> cdKMemberRoleDtoList) {
        this.cdKMemberRoleDtoList = cdKMemberRoleDtoList;
    }
}

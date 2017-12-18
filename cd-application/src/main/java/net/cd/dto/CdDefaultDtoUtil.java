package net.cd.dto;

import net.cd.dto.kernal.CdKAssetDto;
import net.cd.dto.kernal.CdKMemberDto;
import net.cd.dto.trace.CdTVerificationDto;
import net.cd.jpa.entity.trace.CdTVerificationEntity;

/**
 * Created by Vincent 01/12/2017
 */
public class CdDefaultDtoUtil {

    public static CdKMemberDto getVnKMemberDtoEmpty(Integer id, String reference) {
        CdKMemberDto cdKMemberDto = new CdKMemberDto();
        cdKMemberDto.setId(id);
        cdKMemberDto.setReference(reference);
        return cdKMemberDto;
    }

    public static CdTVerificationDto getVnTVerificationDto(Integer member, String code, int ttl) {
        CdTVerificationDto cdTVerificationDto = new CdTVerificationDto();
        cdTVerificationDto.setMember(getVnKMemberDtoEmpty(member, null));
        cdTVerificationDto.setCode(code);
        cdTVerificationDto.setChannel(CdTVerificationEntity.Channel.SMS);
        cdTVerificationDto.setType(CdTVerificationEntity.Type.REG);
        cdTVerificationDto.setTtl(ttl);
        cdTVerificationDto.setVerified(0);
        return cdTVerificationDto;
    }

    public static CdKAssetDto getVnKAssetDto() {
        CdKAssetDto cdKAssetDto = new CdKAssetDto();
        cdKAssetDto.setLink(0);
        cdKAssetDto.setPurgable(0);
        cdKAssetDto.setExtern("");
        return cdKAssetDto;
    }

}

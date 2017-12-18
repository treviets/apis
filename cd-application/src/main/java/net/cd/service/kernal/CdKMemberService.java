package net.cd.service.kernal;

import net.cd.dto.kernal.CdKMemberDto;
import net.cd.jpa.entity.kernal.CdKMemberEntity;

import java.util.List;

/**
 * Created by Vincent 01/12/2017
 */
public interface CdKMemberService {

    CdKMemberDto findByReference(String reference);

    List<CdKMemberDto> findByIdentifierLike(String identifier);

    CdKMemberDto findByIdentifier(String identifier);
    
    CdKMemberDto findByEmail(String email);

    CdKMemberDto findByMobile(String mobile);

    CdKMemberDto findByAccountOrEmailOrMobile(String account, String email, Long mobile);

    CdKMemberDto findOne(Integer id);
    
    CdKMemberDto findByIdentifierAndActivateCodeAndActivated(String indentifier, String activateCode, Integer activated);

    List<CdKMemberDto> findAll();

    List<CdKMemberDto> findAllByPurgedIsNull();

    CdKMemberDto save(CdKMemberDto cdKMemberDto);

    List<CdKMemberDto> map(List<CdKMemberEntity> source);

    List<CdKMemberEntity> mapReversed(List<CdKMemberDto> source);
}

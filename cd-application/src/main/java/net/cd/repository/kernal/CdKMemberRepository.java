package net.cd.repository.kernal;

import net.cd.jpa.entity.kernal.CdKMemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Vincent 01/12/2017
 */
public interface CdKMemberRepository extends JpaRepository<CdKMemberEntity, Integer> {

    CdKMemberEntity findByReference(String reference);
    
    List<CdKMemberEntity> findByIdentifierContaining(String identifier);

    CdKMemberEntity findByIdentifier(String identifier);
    
    CdKMemberEntity findByEmail(String email);

    CdKMemberEntity findByMobile(String mobile);

    CdKMemberEntity findByEmailOrMobile(String account, String email, Long mobile);

    List<CdKMemberEntity> findAllByPurgedIsNullOrderByMadeDesc();
    
    CdKMemberEntity findByIdentifierAndActivateCodeAndActivated(String identifier, String activiateCode, Integer activated);
    

}

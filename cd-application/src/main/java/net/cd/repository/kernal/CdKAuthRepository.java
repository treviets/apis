package net.cd.repository.kernal;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import net.cd.jpa.entity.kernal.CdKAuthEntity;

/**
 * Created by Vincent 01/12/2017
 */
public interface CdKAuthRepository extends JpaRepository<CdKAuthEntity, Integer> {

    List<CdKAuthEntity> findAllByAccountAndMethodIn(String account, List<CdKAuthEntity.Method> methodList);

    List<CdKAuthEntity> findAllByPurgedIsNull();
    
    List<CdKAuthEntity> findByMember(Integer memberId);

}

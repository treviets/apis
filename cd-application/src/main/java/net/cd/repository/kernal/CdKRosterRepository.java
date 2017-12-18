package net.cd.repository.kernal;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import net.cd.jpa.entity.kernal.CdKMemberEntity;
import net.cd.jpa.entity.kernal.CdKRosterEntity;

/**
 * Created by Vincent 01/12/2017
 */
public interface CdKRosterRepository extends JpaRepository<CdKRosterEntity, Integer> {

    CdKRosterEntity findByReference(String reference);
    List<CdKRosterEntity> findByMember(Integer member);
    CdKRosterEntity findByMemberAndContact(Integer member, CdKMemberEntity contact);
}

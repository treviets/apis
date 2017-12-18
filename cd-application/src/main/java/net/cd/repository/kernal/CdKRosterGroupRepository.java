package net.cd.repository.kernal;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import net.cd.jpa.entity.kernal.CdKRosterGroupEntity;

/**
 * Created by Vincent 01/12/2017
 */
public interface CdKRosterGroupRepository extends JpaRepository<CdKRosterGroupEntity, Integer> {

	CdKRosterGroupEntity findByReference(String reference);
    List<CdKRosterGroupEntity> findByMember(Integer member);
    CdKRosterGroupEntity findByName(String name);
    CdKRosterGroupEntity findByReferenceAndMember(String reference, Integer member);
}

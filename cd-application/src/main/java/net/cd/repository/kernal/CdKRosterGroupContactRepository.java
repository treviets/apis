package net.cd.repository.kernal;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import net.cd.jpa.entity.kernal.CdKRosterGroupContactEntity;

/**
 * Created by Vincent 01/12/2017
 */
public interface CdKRosterGroupContactRepository extends JpaRepository<CdKRosterGroupContactEntity, Integer> {

	CdKRosterGroupContactEntity findByReference(String reference);
    List<CdKRosterGroupContactEntity> findByRoster(Integer rosterGroupId);
    CdKRosterGroupContactEntity findByContact(Integer contact);
}

package net.cd.repository.xtras;

import net.cd.jpa.entity.xtras.CdXManageEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Vincent 01/12/2017
 */
public interface CdXManageRepository extends JpaRepository<CdXManageEntity, Long> {

    CdXManageEntity findByEmail(String email);
}

package net.cd.repository.xtras;

import net.cd.jpa.entity.xtras.CdXKvBLOBEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Vincent 01/12/2017
 */
public interface CdXKvBLOBRepository extends JpaRepository<CdXKvBLOBEntity, Long> {

    CdXKvBLOBEntity findOneByK(String key);
}

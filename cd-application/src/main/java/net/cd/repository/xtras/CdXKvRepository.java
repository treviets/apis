package net.cd.repository.xtras;

import net.cd.jpa.entity.xtras.CdXKvEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Vincent 01/12/2017
 */
public interface CdXKvRepository extends JpaRepository<CdXKvEntity, Long> {

    List<CdXKvEntity> findAllByPurgedIsNullAndEnableEquals(int v);
}

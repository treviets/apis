package net.cd.repository.lookup;

import net.cd.jpa.entity.lookup.CdLErrorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Vincent 01/12/2017
 */
public interface CdLErrorRepository extends JpaRepository<CdLErrorEntity, Integer> {

    List<CdLErrorEntity> findAllByPurgedIsNullAndEnableEquals(int v);

}

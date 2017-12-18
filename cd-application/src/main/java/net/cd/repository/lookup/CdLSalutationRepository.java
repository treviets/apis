package net.cd.repository.lookup;

import net.cd.jpa.entity.lookup.CdLSalutationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Vincent 01/12/2017
 */
public interface CdLSalutationRepository extends JpaRepository<CdLSalutationEntity, Long> {

    List<CdLSalutationEntity> findAllByPurgedIsNullAndEnableEquals(int v);

}

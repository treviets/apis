package net.cd.repository.lookup;

import net.cd.jpa.entity.lookup.CdLL10NEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Vincent 01/12/2017
 */
public interface CdLL10NRepository extends JpaRepository<CdLL10NEntity, Integer> {

    List<CdLL10NEntity> findAllByPurgedIsNull();

}

package net.cd.repository.lookup;

import net.cd.jpa.entity.lookup.CdLCountryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Vincent 01/12/2017
 */
public interface CdLCountryRepository extends JpaRepository<CdLCountryEntity, Long> {

    List<CdLCountryEntity> findAllByPurgedIsNullAndEnableEquals(int v);

}

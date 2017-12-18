package net.cd.repository.kernal;

import net.cd.jpa.entity.kernal.CdKAssetEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Vincent 01/12/2017
 */
public interface CdKAssetRepository extends JpaRepository<CdKAssetEntity, Integer> {

    CdKAssetEntity findFirstByReference(String reference);

    List<CdKAssetEntity> findAllByIdInAndPurgedIsNull(List<Integer> idList);

    List<CdKAssetEntity> findAllByPurgedIsNullOrderByMadeDesc();
}

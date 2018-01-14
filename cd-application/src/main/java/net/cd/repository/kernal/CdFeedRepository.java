package net.cd.repository.kernal;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import net.cd.jpa.entity.kernal.CdFeedEntity;
import net.cd.jpa.entity.kernal.CdFeedEntity.FeedType;
import net.cd.jpa.entity.kernal.CdKMemberEntity;

/**
 * Created by Vincent 07/12/2017
 */
public interface CdFeedRepository extends JpaRepository<CdFeedEntity, Integer> {

    List<CdFeedEntity> findAllByPurgedIsNullAndScope(CdFeedEntity.FeedScope scope);
    
    List<CdFeedEntity> findByAuthor(CdKMemberEntity author);
    
    List<CdFeedEntity> findByType(FeedType feedType);
    
    CdFeedEntity findByReference(String reference);
    

}

package net.cd.repository.lookup;

import net.cd.jpa.entity.lookup.CdLTemplateMessageEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Vincent 01/12/2017
 */
public interface CdLTemplateMessageRepository extends JpaRepository<CdLTemplateMessageEntity, Long> {

    CdLTemplateMessageEntity findOneByEntityEqualsAndActionEqualsAndChannelEqualsAndEnableEquals(
            CdLTemplateMessageEntity.EntityTypes entity, CdLTemplateMessageEntity.ActionTypes action, CdLTemplateMessageEntity.ChannelTypes channel, Integer enable);
}

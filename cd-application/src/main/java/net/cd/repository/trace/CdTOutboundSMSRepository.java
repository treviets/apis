package net.cd.repository.trace;

import net.cd.jpa.entity.trace.CdTOutboundSMSEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Vincent 01/12/2017.
 */
public interface CdTOutboundSMSRepository extends JpaRepository<CdTOutboundSMSEntity, Long> {

}

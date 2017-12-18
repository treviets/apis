package net.cd.service.xtras;

import net.cd.dto.xtras.CdXKvBLOBDto;

/**
 * Created by Vincent 01/12/2017
 */
public interface CdXKvBLOBService {

    CdXKvBLOBDto findByKey(String key);

    CdXKvBLOBDto save(CdXKvBLOBDto cdXKvBLOBDto);
}

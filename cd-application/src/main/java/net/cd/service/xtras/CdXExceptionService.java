package net.cd.service.xtras;

import net.cd.dto.xtras.CdXExceptionDto;

/**
 * Created by Vincent 01/12/2017
 */
public interface CdXExceptionService {

    CdXExceptionDto findOne(Integer id);

    CdXExceptionDto save(CdXExceptionDto opXExceptionDto);
}

package net.cd.service.xtras.impl;

import net.cd.dto.xtras.CdXExceptionDto;
import net.cd.jpa.entity.xtras.CdXExceptionEntity;
import net.cd.repository.xtras.CdXExceptionRepository;
import net.cd.service.xtras.CdXExceptionService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Vincent 01/12/2017
 */
@Service
public class CdXExceptionServiceImpl implements CdXExceptionService {

    @Autowired
    private CdXExceptionRepository cdXExceptionRepository;

    @Override
    public CdXExceptionDto findOne(Integer id) {
        ModelMapper mapper = new ModelMapper();
        CdXExceptionDto opXExceptionDto = new CdXExceptionDto();
        mapper.map(cdXExceptionRepository.findOne(id), opXExceptionDto);
        return opXExceptionDto;
    }

    @Override
    public CdXExceptionDto save(CdXExceptionDto opXExceptionDto) {
        ModelMapper mapper = new ModelMapper();
        CdXExceptionEntity cdXExceptionEntity = new CdXExceptionEntity();
        mapper.map(opXExceptionDto, cdXExceptionEntity);
        mapper.map(cdXExceptionRepository.save(cdXExceptionEntity), opXExceptionDto);
        return opXExceptionDto;
    }
}

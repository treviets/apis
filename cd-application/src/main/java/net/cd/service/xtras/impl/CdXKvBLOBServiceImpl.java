package net.cd.service.xtras.impl;

import net.cd.dto.xtras.CdXKvBLOBDto;
import net.cd.jpa.entity.xtras.CdXKvBLOBEntity;
import net.cd.repository.xtras.CdXKvBLOBRepository;
import net.cd.service.xtras.CdXKvBLOBService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Vincent 01/12/2017
 */
@Service
public class CdXKvBLOBServiceImpl implements CdXKvBLOBService {

    @Autowired
    private CdXKvBLOBRepository cdXKvBLOBRepository;

    @Override
    public CdXKvBLOBDto findByKey(String key) {
        CdXKvBLOBEntity cdXKvBLOBEntity = cdXKvBLOBRepository.findOneByK(key);
        if (cdXKvBLOBEntity != null) {
            CdXKvBLOBDto cdXKvBLOBDto = new CdXKvBLOBDto();
            new ModelMapper().map(cdXKvBLOBEntity, cdXKvBLOBDto);
            return cdXKvBLOBDto;
        }
        return null;
    }

    @Override
    public CdXKvBLOBDto save(CdXKvBLOBDto cdXKvBLOBDto) {
        CdXKvBLOBEntity cdXKvBLOBEntity = new CdXKvBLOBEntity();
        ModelMapper mapper = new ModelMapper();
        mapper.map(cdXKvBLOBDto, cdXKvBLOBEntity);
        mapper.map(cdXKvBLOBRepository.save(cdXKvBLOBEntity), cdXKvBLOBDto);
        return cdXKvBLOBDto;
    }
}

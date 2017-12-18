/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.cd.service.xtras.impl;

import java.util.ArrayList;
import java.util.List;
import net.cd.dto.xtras.CdXKvDto;
import net.cd.jpa.entity.xtras.CdXKvEntity;
import net.cd.repository.xtras.CdXKvRepository;
import net.cd.service.xtras.CdXKvService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Vincent 01/12/2017
 */
@Service
public class CdXKvServiceImpl implements CdXKvService {

    @Autowired
    private CdXKvRepository cdXKvRepository;

    @Override
    public List<CdXKvDto> findAll() {
        return map(cdXKvRepository.findAll());
    }

    @Override
    public List<CdXKvDto> findAllByPurgedIsNullAndEnableTrue() {
        return map(cdXKvRepository.findAllByPurgedIsNullAndEnableEquals(1));
    }

    private List<CdXKvDto> map(List<CdXKvEntity> source) {
        ModelMapper mapper = new ModelMapper();
        ArrayList<CdXKvDto> rtn = new ArrayList<>();
        source.stream().map((entity) -> {
            CdXKvDto dto = new CdXKvDto();
            mapper.map(entity, dto);
            return dto;
        }).forEachOrdered((dto) -> {
            rtn.add(dto);
        });
        return rtn;
    }

    @Override
    public CdXKvDto save(CdXKvDto cdXKvDto) {
        ModelMapper mapper = new ModelMapper();
        CdXKvEntity cdXKvEntity = new CdXKvEntity();
        mapper.map(cdXKvDto, cdXKvEntity);
        mapper.map(cdXKvRepository.save(cdXKvEntity), cdXKvDto);
        return cdXKvDto;
    }

    @Override
    @Transactional
    public List<CdXKvDto> saveAll(List<CdXKvDto> cdXKvDtoList) {
        return map(cdXKvRepository.save(mapReversed(cdXKvDtoList)));

    }

    private List<CdXKvEntity> mapReversed(List<CdXKvDto> source) {
        ModelMapper mapper = new ModelMapper();
        ArrayList<CdXKvEntity> rtn = new ArrayList<>();
        source.stream().map((dto) -> {
            CdXKvEntity entity = new CdXKvEntity();
            mapper.map(dto, entity);
            return entity;
        }).forEachOrdered((entity) -> {
            rtn.add(entity);
        });
        return rtn;
    }

}

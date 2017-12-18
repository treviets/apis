/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.cd.service.kernal.impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.cd.common.util.UserUtil;
import net.cd.dto.kernal.CdKMemberSecurityQuestionDto;
import net.cd.jpa.entity.kernal.CdKMemberSecurityQuestionEntity;
import net.cd.repository.kernal.CdKMemberSecurityQuestionRepository;
import net.cd.service.kernal.CdKMemberSecurityQuestionService;

/**
 *
 * @author phuongtrinh
 */
@Service
public class CdKMemberSecurityQuestionServiceImpl implements CdKMemberSecurityQuestionService {

    @Autowired
    private CdKMemberSecurityQuestionRepository cdKMemberSecurityQuestionRepository;
    
    @Autowired
    UserUtil userUtil;

    @Override
    public CdKMemberSecurityQuestionDto save(CdKMemberSecurityQuestionDto cdKMemberSecurityQuestionDto) {
        ModelMapper mapper = new ModelMapper();
        CdKMemberSecurityQuestionEntity cdKMemberSecurityQuestionEntity = new CdKMemberSecurityQuestionEntity();
        mapper.map(cdKMemberSecurityQuestionDto, cdKMemberSecurityQuestionEntity);
        mapper.map(cdKMemberSecurityQuestionRepository.save(cdKMemberSecurityQuestionEntity), cdKMemberSecurityQuestionDto);
        return cdKMemberSecurityQuestionDto;
    }

    @Override
    @Transactional
    public List<CdKMemberSecurityQuestionDto> saveAll(List<CdKMemberSecurityQuestionDto> cdKMemberSecurityQuestionDtoList) {
        return map(cdKMemberSecurityQuestionRepository.save(mapReversed(cdKMemberSecurityQuestionDtoList)));

    }

    private List<CdKMemberSecurityQuestionDto> map(List<CdKMemberSecurityQuestionEntity> source) {
        ModelMapper mapper = new ModelMapper();
        ArrayList<CdKMemberSecurityQuestionDto> rtn = new ArrayList<>();
        source.stream().map((entity) -> {
            CdKMemberSecurityQuestionDto dto = new CdKMemberSecurityQuestionDto();
            mapper.map(entity, dto);
            return dto;
        }).forEachOrdered((dto) -> {
            rtn.add(dto);
        });
        return rtn;
    }

    private List<CdKMemberSecurityQuestionEntity> mapReversed(List<CdKMemberSecurityQuestionDto> source) {
    
    		ModelMapper mapper = new ModelMapper();
        ArrayList<CdKMemberSecurityQuestionEntity> rtn = new ArrayList<>();
        source.stream().map((dto) -> {
            CdKMemberSecurityQuestionEntity entity = new CdKMemberSecurityQuestionEntity();
            mapper.map(dto, entity);
            try {
				entity.setMember(userUtil.getUserLoginId());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            return entity;
        }).forEachOrdered((entity) -> {
            rtn.add(entity);
        });
        return rtn;
    }

	@Override
	public List<CdKMemberSecurityQuestionDto> findByMember(Integer member) {
		List<CdKMemberSecurityQuestionEntity> memberQuestionEntities = cdKMemberSecurityQuestionRepository.findByMember(member);
		if(memberQuestionEntities != null) {
			return this.map(memberQuestionEntities);
		}
		return null;
	}

}

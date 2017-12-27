package net.cd.service.kernal.impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.cd.dto.kernal.CdCommentDto;
import net.cd.jpa.entity.kernal.CdCommentEntity;
import net.cd.repository.kernal.CdCommentRepository;
import net.cd.service.kernal.CdCommentService;

/**
 * Created by Vincent on /12/2017.
 */
@Service
public class CdCommentServiceImpl implements CdCommentService {

    @Autowired
    private CdCommentRepository cdCommentRepository;
    
	@Override
	public CdCommentDto save(CdCommentDto cdCommentDto) {
		ModelMapper mapper = new ModelMapper();
        CdCommentEntity cdCommentEntity = new CdCommentEntity();
        mapper.map(cdCommentDto, cdCommentEntity);
        
        mapper.map(cdCommentRepository.saveAndFlush(cdCommentEntity),cdCommentDto);
		return cdCommentDto;
	}

	
	@Override
	public List<CdCommentDto> findAll() {
		List<CdCommentEntity> cdCommentEntities = cdCommentRepository.findAll();
		List<CdCommentDto> cdCommentDto = this.map(cdCommentEntities);
		return cdCommentDto;
	}

	

	private List<CdCommentDto> map(List<CdCommentEntity> source) {
        ModelMapper mapper = new ModelMapper();
        ArrayList<CdCommentDto> rtn = new ArrayList<>();
        source.stream().map((entity) -> {
        	CdCommentDto dto = new CdCommentDto();
            mapper.map(entity, dto);
            return dto;
        }).forEachOrdered((dto) -> {
            rtn.add(dto);
        });
        return rtn;
    }


	@Override
	public boolean delete(CdCommentDto cdCommentDto) {
		CdCommentEntity cdCommentEntity = new CdCommentEntity();
		ModelMapper mapper = new ModelMapper();
		mapper.map(cdCommentDto, cdCommentEntity);
		cdCommentRepository.delete(cdCommentEntity);
		return true;
	}
   
}

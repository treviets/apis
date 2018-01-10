package net.cd.service.kernal.impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.cd.dto.kernal.CdArticleDto;
import net.cd.dto.kernal.CdKMemberDto;
import net.cd.dto.kernal.CdLikeDto;
import net.cd.jpa.entity.kernal.CdArticleEntity;
import net.cd.jpa.entity.kernal.CdKMemberEntity;
import net.cd.jpa.entity.kernal.CdLikeEntity;
import net.cd.repository.kernal.CdLikeRepository;
import net.cd.service.kernal.CdLikeService;

/**
 * Created by Vincent on /12/2017.
 */
@Service
public class CdLikeServiceImpl implements CdLikeService {

    @Autowired
    private CdLikeRepository cdLikeRepository;
    
	@Override
	public CdLikeDto save(CdLikeDto cdLikeDto) {
		ModelMapper mapper = new ModelMapper();
        CdLikeEntity cdLikeEntity = new CdLikeEntity();
        mapper.map(cdLikeDto, cdLikeEntity);
        
        mapper.map(cdLikeRepository.saveAndFlush(cdLikeEntity), cdLikeDto);
		return cdLikeDto;
	}

	
	@Override
	public List<CdLikeDto> findAll() {
		List<CdLikeEntity> cdLikeEntities = cdLikeRepository.findAll();
		List<CdLikeDto> cdLikeDto = this.map(cdLikeEntities);
		return cdLikeDto;
	}

	

	private List<CdLikeDto> map(List<CdLikeEntity> source) {
        ModelMapper mapper = new ModelMapper();
        ArrayList<CdLikeDto> rtn = new ArrayList<>();
        source.stream().map((entity) -> {
        	CdLikeDto dto = new CdLikeDto();
            mapper.map(entity, dto);
            return dto;
        }).forEachOrdered((dto) -> {
            rtn.add(dto);
        });
        return rtn;
    }

	private List<CdLikeEntity> reverseMap(List<CdLikeDto> source) {
        ModelMapper mapper = new ModelMapper();
        ArrayList<CdLikeEntity> rtn = new ArrayList<>();
        source.stream().map((dto) -> {
        	CdLikeEntity entity = new CdLikeEntity();
            mapper.map(dto, entity);
            return entity;
        }).forEachOrdered((entity) -> {
            rtn.add(entity);
        });
        return rtn;
    }

	@Override
	public boolean delete(CdLikeDto cdLikeDto) {
		CdLikeEntity cdLikeEntity = new CdLikeEntity();
		ModelMapper mapper = new ModelMapper();
		mapper.map(cdLikeDto, cdLikeEntity);
		cdLikeRepository.delete(cdLikeEntity);
		return true;
	}


	@Override
	public List<CdLikeDto> findByAuthorAndArticleId(CdKMemberDto author, CdArticleDto articleDto) {
		ModelMapper mapper = new ModelMapper();
	       
		CdKMemberEntity memberEntity = new CdKMemberEntity();
		CdArticleEntity articleEntity = new CdArticleEntity();
		mapper.map(author, memberEntity);
		mapper.map(articleDto, articleEntity);
		
		List<CdLikeEntity> cdLikeEntities = cdLikeRepository.findByAuthorAndArticleId(memberEntity, articleDto.getId());
		List<CdLikeDto> cdLikeDto = this.map(cdLikeEntities);
		return cdLikeDto;
	}


	@Override
	public boolean delete(List<CdLikeDto> cdLikeDto) {
		List<CdLikeEntity> cdLikeEntities = this.reverseMap(cdLikeDto);
		cdLikeRepository.delete(cdLikeEntities);
		return true;
	}
   
}

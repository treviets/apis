package net.cd.service.kernal.impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.cd.dto.kernal.CdArticleDto;
import net.cd.jpa.entity.kernal.CdArticleEntity;
import net.cd.repository.kernal.CdArticleRepository;
import net.cd.service.kernal.CdArticleService;

/**
 * Created by Vincent on 07/12/2017.
 */
@Service
public class CdArticleServiceImpl implements CdArticleService {

    @Autowired
    private CdArticleRepository cdKArtileRepository;

	@Override
	public CdArticleDto save(CdArticleDto cdFeedDto) {
		ModelMapper mapper = new ModelMapper();
        CdArticleEntity cdFeedEntity = new CdArticleEntity();
        mapper.map(cdFeedDto, cdFeedEntity);
        
        mapper.map(cdKArtileRepository.save(cdFeedEntity),cdFeedDto);
		return cdFeedDto;
	}

	
	@Override
	public List<CdArticleDto> findAll() {
		List<CdArticleEntity> cdFeedEntities = cdKArtileRepository.findAll();
		List<CdArticleDto> cdFeedDto = this.map(cdFeedEntities);
		return cdFeedDto;
	}

	@Override
	public List<CdArticleDto> findAllByPurgedIsNull() {
		List<CdArticleEntity> cdFeedEntities = cdKArtileRepository.findAllByPurgedIsNull();
		List<CdArticleDto> cdFeedDto = this.map(cdFeedEntities);
		return cdFeedDto;
	}

	
	@Override
	public CdArticleDto findOne(Integer feedId) {
		ModelMapper mapper = new ModelMapper();
        CdArticleEntity cdFeedEntity = cdKArtileRepository.findOne(feedId);
        CdArticleDto feedDto = new CdArticleDto();
        mapper.map(cdFeedEntity,feedDto);
		return feedDto;
	}

	private List<CdArticleDto> map(List<CdArticleEntity> source) {
        ModelMapper mapper = new ModelMapper();
        ArrayList<CdArticleDto> rtn = new ArrayList<>();
        source.stream().map((entity) -> {
        	CdArticleDto dto = new CdArticleDto();
            mapper.map(entity, dto);
            return dto;
        }).forEachOrdered((dto) -> {
            rtn.add(dto);
        });
        return rtn;
    }
   
}

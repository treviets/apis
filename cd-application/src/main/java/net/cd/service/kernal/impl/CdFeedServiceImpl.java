package net.cd.service.kernal.impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.cd.dto.kernal.CdFeedDto;
import net.cd.jpa.entity.kernal.CdFeedEntity;
import net.cd.jpa.entity.kernal.CdFeedEntity.FeedScope;
import net.cd.jpa.entity.kernal.CdKMemberEntity;
import net.cd.repository.kernal.CdFeedRepository;
import net.cd.repository.kernal.CdKMemberRepository;
import net.cd.service.kernal.CdFeedService;

/**
 * Created by Vincent on 07/12/2017.
 */
@Service
public class CdFeedServiceImpl implements CdFeedService {

    @Autowired
    private CdFeedRepository cdKFeedRepository;
    
    @Autowired
    private CdKMemberRepository memberRepo;

	@Override
	public CdFeedDto save(CdFeedDto cdFeedDto) {
		ModelMapper mapper = new ModelMapper();
        CdFeedEntity cdFeedEntity = new CdFeedEntity();
        mapper.map(cdFeedDto, cdFeedEntity);
        
        mapper.map(cdKFeedRepository.save(cdFeedEntity),cdFeedDto);
		return cdFeedDto;
	}

	
	@Override
	public List<CdFeedDto> findAll() {
		List<CdFeedEntity> cdFeedEntities = cdKFeedRepository.findAll();
		List<CdFeedDto> cdFeedDto = this.map(cdFeedEntities);
		return cdFeedDto;
	}

	@Override
	public List<CdFeedDto> findAllByPurgedIsNullAndScope(FeedScope scope) {
		List<CdFeedEntity> cdFeedEntities = cdKFeedRepository.findAllByPurgedIsNullAndScope(scope);
		List<CdFeedDto> cdFeedDto = this.map(cdFeedEntities);
		return cdFeedDto;
	}

	@Override
	public List<CdFeedDto> findByAuthor(Integer authorId) {
		CdKMemberEntity author = memberRepo.findOne(authorId);
		List<CdFeedEntity> cdFeedEntities = cdKFeedRepository.findByAuthor(author);
		List<CdFeedDto> cdFeedDto = this.map(cdFeedEntities);
		return cdFeedDto;
	}

	@Override
	public CdFeedDto findOne(Integer feedId) {
		ModelMapper mapper = new ModelMapper();
        CdFeedEntity cdFeedEntity = cdKFeedRepository.findOne(feedId);
        CdFeedDto feedDto = new CdFeedDto();
        mapper.map(cdFeedEntity,feedDto);
		return feedDto;
	}

	private List<CdFeedDto> map(List<CdFeedEntity> source) {
        ModelMapper mapper = new ModelMapper();
        ArrayList<CdFeedDto> rtn = new ArrayList<>();
        source.stream().map((entity) -> {
        	CdFeedDto dto = new CdFeedDto();
            mapper.map(entity, dto);
            return dto;
        }).forEachOrdered((dto) -> {
            rtn.add(dto);
        });
        return rtn;
    }


	@Override
	public boolean delete(CdFeedDto cdFeedDto) {
		CdFeedEntity cdFeedEntity = new CdFeedEntity();
		ModelMapper mapper = new ModelMapper();
		mapper.map(cdFeedDto, cdFeedEntity);
		cdKFeedRepository.delete(cdFeedEntity);
		return true;
	}


	@Override
	public CdFeedDto findByReference(String reference) {
		ModelMapper mapper = new ModelMapper();
        CdFeedEntity cdFeedEntity = cdKFeedRepository.findByReference(reference);
        CdFeedDto feedDto = new CdFeedDto();
        mapper.map(cdFeedEntity,feedDto);
		return feedDto;
	}
   
}

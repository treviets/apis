package net.cd.service.kernal.impl;

import net.cd.dto.kernal.CdKMemberDto;
import net.cd.jpa.entity.kernal.CdKMemberEntity;
import net.cd.repository.kernal.CdKMemberRepository;
import net.cd.service.kernal.CdKMemberService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tree.Yip on 25/6/2017.
 */
@Service
public class CdKMemberServiceImpl implements CdKMemberService {

	@Autowired
	private CdKMemberRepository cdKMemberRepository;

	@Override
	public CdKMemberDto findByReference(String reference) {
		CdKMemberDto dto = new CdKMemberDto();
		CdKMemberEntity opKMemberEntity = cdKMemberRepository.findByReference(reference);
		if (opKMemberEntity != null) {
			new ModelMapper().map(opKMemberEntity, dto);
			return dto;
		}
		return null;
	}

	@Override
	public List<CdKMemberDto> findByIdentifierLike(String identifier) {
		List<CdKMemberEntity> opKMemberEntities = cdKMemberRepository.findByIdentifierContaining(identifier);
		return this.map(opKMemberEntities);
	}
	
	@Override
	public CdKMemberDto findByIdentifier(String identifier) {
		CdKMemberEntity opKMemberEntity = cdKMemberRepository.findByIdentifier(identifier);
		if(opKMemberEntity == null) {
			return null;
		}
		CdKMemberDto dto = new CdKMemberDto();
		new ModelMapper().map(opKMemberEntity, dto);
		return dto;
	}

	@Override
	public CdKMemberDto findByEmail(String email) {
		CdKMemberDto dto = new CdKMemberDto();
		CdKMemberEntity opKMemberEntity = cdKMemberRepository.findByEmail(email);
		if (opKMemberEntity != null) {
			new ModelMapper().map(opKMemberEntity, dto);
			return dto;
		}
		return null;
	}

	@Override
	public CdKMemberDto findByMobile(String mobile) {
		CdKMemberDto dto = new CdKMemberDto();
		CdKMemberEntity opKMemberEntity = cdKMemberRepository.findByMobile(mobile);
		if (opKMemberEntity != null) {
			new ModelMapper().map(opKMemberEntity, dto);
			return dto;
		}
		return null;
	}

	@Override
	public CdKMemberDto findByAccountOrEmailOrMobile(String identifier, String email, Long mobile) {
		CdKMemberDto dto = new CdKMemberDto();
		CdKMemberEntity opKMemberEntity = cdKMemberRepository.findByEmailOrMobile(identifier, email, mobile);
		if (opKMemberEntity != null) {
			new ModelMapper().map(opKMemberEntity, dto);
			return dto;
		}
		return null;
	}

	@Override
	public CdKMemberDto findOne(Integer id) {
		CdKMemberDto dto = new CdKMemberDto();
		CdKMemberEntity opKMemberEntity = cdKMemberRepository.findOne(id);
		if (opKMemberEntity != null) {
			new ModelMapper().map(opKMemberEntity, dto);
			return dto;
		}
		return null;
	}
	
	@Override
	public CdKMemberDto findByIdentifierAndActivateCodeAndActivated(String indentifier, String activateCode, Integer activated) {
		CdKMemberDto dto = new CdKMemberDto();
		CdKMemberEntity opKMemberEntity = cdKMemberRepository.findByIdentifierAndActivateCodeAndActivated(indentifier, activateCode, activated);
		if (opKMemberEntity != null) {
			new ModelMapper().map(opKMemberEntity, dto);
			return dto;
		}
		return null;
	}

	@Override
	public List<CdKMemberDto> findAll() {
		return map(cdKMemberRepository.findAll());
	}

	@Override
	public List<CdKMemberDto> findAllByPurgedIsNull() {
		return map(cdKMemberRepository.findAllByPurgedIsNullOrderByMadeDesc());
	}

	@Override
	public CdKMemberDto save(CdKMemberDto cdKMemberDto) {
		ModelMapper mapper = new ModelMapper();
		CdKMemberEntity opKMemberEntity = new CdKMemberEntity();
		mapper.map(cdKMemberDto, opKMemberEntity);
		mapper.map(cdKMemberRepository.save(opKMemberEntity), cdKMemberDto);
		return cdKMemberDto;
	}

	@Override
	public List<CdKMemberDto> map(List<CdKMemberEntity> source) {
		ModelMapper mapper = new ModelMapper();
		ArrayList<CdKMemberDto> rtn = new ArrayList<>();
		source.stream().map((entity) -> {
			CdKMemberDto dto = new CdKMemberDto();
			mapper.map(entity, dto);
			return dto;
		}).forEachOrdered((dto) -> {
			rtn.add(dto);
		});
		return rtn;
	}

	@Override
	public List<CdKMemberEntity> mapReversed(List<CdKMemberDto> source) {
		ModelMapper mapper = new ModelMapper();
		ArrayList<CdKMemberEntity> rtn = new ArrayList<>();
		source.stream().map((dto) -> {
			CdKMemberEntity entity = new CdKMemberEntity();
			mapper.map(dto, entity);
			return entity;
		}).forEachOrdered((entity) -> {
			rtn.add(entity);
		});
		return rtn;
	}
}

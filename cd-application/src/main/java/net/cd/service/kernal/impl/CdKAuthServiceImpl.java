package net.cd.service.kernal.impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.cd.dto.kernal.CdKAuthDto;
import net.cd.jpa.entity.kernal.CdKAuthEntity;
import net.cd.repository.kernal.CdKAuthRepository;
import net.cd.service.kernal.CdKAuthService;

/**
 * Created by Vincent on 04/12/2017.
 */
@Service
public class CdKAuthServiceImpl implements CdKAuthService {

    @Autowired
    private CdKAuthRepository cdKAuthRepository;

    @Override
    public CdKAuthDto save(CdKAuthDto cdKAuthDto) {
        ModelMapper mapper = new ModelMapper();
        CdKAuthEntity cdKAuthEntity = new CdKAuthEntity();
        mapper.map(cdKAuthDto, cdKAuthEntity);
        mapper.map(cdKAuthRepository.save(cdKAuthEntity), cdKAuthDto);
        return cdKAuthDto;
    }

    @Override
    public List<CdKAuthDto> findAll() {
        return map(cdKAuthRepository.findAll());
    }

    @Override
    public List<CdKAuthDto> findAllByPurgedIsNull() {
        return map(cdKAuthRepository.findAllByPurgedIsNull());
    }

    private List<CdKAuthDto> map(List<CdKAuthEntity> source) {
        ModelMapper mapper = new ModelMapper();
        ArrayList<CdKAuthDto> rtn = new ArrayList<>();
        source.stream().map((entity) -> {
            CdKAuthDto dto = new CdKAuthDto();
            mapper.map(entity, dto);
            return dto;
        }).forEachOrdered((dto) -> {
            rtn.add(dto);
        });
        return rtn;
    }

	@Override
	public List<CdKAuthDto> findByMember(Integer memberId) {
		
		List<CdKAuthEntity> authEntities = cdKAuthRepository.findByMember(memberId);
		
		return map(authEntities);
	}
}

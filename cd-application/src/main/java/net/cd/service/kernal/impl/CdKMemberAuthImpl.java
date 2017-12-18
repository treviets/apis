package net.cd.service.kernal.impl;

import net.cd.dto.kernal.CdKMemberAuthDto;
import net.cd.jpa.entity.kernal.CdKMemberAuthEntity;
import net.cd.repository.kernal.CdKMemberAuthRepository;
import net.cd.service.kernal.CdKMemberAuthService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author phuongtrinh
 */
@Service
public class CdKMemberAuthImpl implements CdKMemberAuthService {

    @Autowired
    private CdKMemberAuthRepository cdKMemberAuthRepository;

    @Override
    public CdKMemberAuthDto save(CdKMemberAuthDto cdKMemberAuthDto) {

        ModelMapper mapper = new ModelMapper();
        CdKMemberAuthEntity cdKMemberAuthEntity = new CdKMemberAuthEntity();
        mapper.map(cdKMemberAuthDto, cdKMemberAuthEntity);
        mapper.map(cdKMemberAuthRepository.save(cdKMemberAuthEntity), cdKMemberAuthDto);
        return cdKMemberAuthDto;
    }

}

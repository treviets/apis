package net.cd.service.kernal.impl;

import net.cd.dto.kernal.*;
import net.cd.jpa.entity.kernal.CdKMemberEntity;
import net.cd.jpa.entity.kernal.CdKMemberRoleEntity;
import net.cd.repository.kernal.CdKMemberRoleRepository;
import net.cd.service.kernal.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tree.Yip on 25/6/2017.
 */
@Service
public class CdKMemberRoleServiceImpl implements CdKMemberRoleService {

    @Autowired
    private CdKMemberRoleRepository cdKMemberRoleRepository;

    @Override
    public List<CdKMemberRoleDto> findByMember(CdKMemberDto member) {
        ModelMapper mapper = new ModelMapper();
        CdKMemberEntity opKMemberEntity = new CdKMemberEntity();
        mapper.map(member, opKMemberEntity);
        return map(cdKMemberRoleRepository.findByMember(opKMemberEntity));
    }

    @Override
    public List<CdKMemberRoleDto> findByMemberAndIdentity(CdKMemberDto member, CdKMemberRoleEntity.MemberRoleRelativeIdentity identity) {
        ModelMapper mapper = new ModelMapper();
        CdKMemberEntity opKMemberEntity = new CdKMemberEntity();
        mapper.map(member, opKMemberEntity);
        return map(cdKMemberRoleRepository.findByMemberAndIdentity(opKMemberEntity, identity));
    }

    @Override
    public List<CdKMemberRoleDto> findByIdentifierAndIdentity(Integer identifier, CdKMemberRoleEntity.MemberRoleRelativeIdentity identity) {
        return map(cdKMemberRoleRepository.findByIdentifierEqualsAndIdentity(identifier, identity));
    }

    @Override
    public List<CdKMemberRoleDto> findAll() {
        return map(cdKMemberRoleRepository.findAll());
    }

    @Override
    public List<CdKMemberRoleDto> findAllByPurgedIsNull() {
        return map(cdKMemberRoleRepository.findAllByPurgedIsNull());
    }

    @Override
    public CdKMemberRoleDto save(CdKMemberRoleDto cdKMemberRoleDto) {
        ModelMapper mapper = new ModelMapper();
        CdKMemberRoleEntity cdKMemberRoleEntity = new CdKMemberRoleEntity();
        mapper.map(cdKMemberRoleDto, cdKMemberRoleEntity);
        mapper.map(cdKMemberRoleRepository.save(cdKMemberRoleEntity), cdKMemberRoleDto);
        return cdKMemberRoleDto;
    }

    private List<CdKMemberRoleDto> map(List<CdKMemberRoleEntity> source) {
        ModelMapper mapper = new ModelMapper();
        ArrayList<CdKMemberRoleDto> rtn = new ArrayList<>();
        source.stream().map((entity) -> {
            CdKMemberRoleDto dto = new CdKMemberRoleDto();
            mapper.map(entity, dto);
            return dto;
        }).forEachOrdered((dto) -> {
            rtn.add(dto);
        });
        return rtn;
    }
}

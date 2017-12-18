/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.cd.service.kernal;

import java.util.List;
import net.cd.dto.kernal.CdKMemberSecurityQuestionDto;

/**
 *
 * @author Vincent 01/12/2017
 */
public interface CdKMemberSecurityQuestionService {

    CdKMemberSecurityQuestionDto save(CdKMemberSecurityQuestionDto cdKMemberSecurityQuestionDto);

    List<CdKMemberSecurityQuestionDto> saveAll(List<CdKMemberSecurityQuestionDto> cdKMemberSecurityQuestionDtoList);
    List<CdKMemberSecurityQuestionDto> findByMember(Integer member);
}

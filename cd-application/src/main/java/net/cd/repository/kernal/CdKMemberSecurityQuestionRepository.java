/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.cd.repository.kernal;

import net.cd.jpa.entity.kernal.CdKMemberSecurityQuestionEntity;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Vincent 01/12/2017
 */
public interface CdKMemberSecurityQuestionRepository extends JpaRepository<CdKMemberSecurityQuestionEntity, Integer>{
    CdKMemberSecurityQuestionEntity findByReference(String reference);
    List<CdKMemberSecurityQuestionEntity> findByMember(Integer member);
}

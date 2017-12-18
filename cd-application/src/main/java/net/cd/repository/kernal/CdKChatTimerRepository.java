/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.cd.repository.kernal;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import net.cd.jpa.entity.kernal.CdKChatTimerEntity;

/**
 *
 * @author Vincent 01/12/2017
 */
public interface CdKChatTimerRepository extends JpaRepository<CdKChatTimerEntity, Integer> {

    List<CdKChatTimerEntity> findAllByPurgedIsNull();
}

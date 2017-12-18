/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.cd.repository.lookup;

import java.util.List;
import net.cd.jpa.entity.lookup.CdLSecurityQuestionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Vincent 01/12/2017
 */
public interface CdLSecurityQuestionRepository extends JpaRepository<CdLSecurityQuestionEntity, Integer> {

    CdLSecurityQuestionEntity findByL10N(String l10N);

    List<CdLSecurityQuestionEntity> findAllByPurgedIsNullAndEnabledEquals(int v);

}

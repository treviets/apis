/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.cd.dto;

import java.util.List;
import net.cd.dto.kernal.CdKMemberSecurityQuestionDto;
import net.cd.dto.xtras.CdXKvDto;

/**
 *
 * @author Vincent 01/12/2017
 */
public class CdMemberSecurityQuestion {

    List<CdKMemberSecurityQuestionDto> kMemberSecurityQuestionDtoList;
    List<CdXKvDto> cdXKvDtoList;

    public List<CdKMemberSecurityQuestionDto> getkMemberSecurityQuestionDtoList() {
        return kMemberSecurityQuestionDtoList;
    }

    public void setkMemberSecurityQuestionDtoList(List<CdKMemberSecurityQuestionDto> kMemberSecurityQuestionDtoList) {
        this.kMemberSecurityQuestionDtoList = kMemberSecurityQuestionDtoList;
    }

    public List<CdXKvDto> getCdXKvDtoList() {
        return cdXKvDtoList;
    }

    public void setCdXKvDtoList(List<CdXKvDto> cdXKvDtoList) {
        this.cdXKvDtoList = cdXKvDtoList;
    }

}

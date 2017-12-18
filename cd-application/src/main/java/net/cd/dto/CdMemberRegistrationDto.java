package net.cd.dto;

import java.util.List;

import net.cd.dto.kernal.CdKAuthDto;
import net.cd.dto.kernal.CdKMemberDto;
import net.cd.dto.kernal.CdKMemberSecurityQuestionDto;

/**
 *
 * @author Vincent 01/12/2017
 */
public class CdMemberRegistrationDto {

    private CdKMemberDto cdKMemberDto;
    private CdKAuthDto cdKAuthDto;
    private List<CdKMemberSecurityQuestionDto> securityQuestions;

    public CdKMemberDto getCdKMemberDto() {
        return cdKMemberDto;
    }

    public void setCdKMemberDto(CdKMemberDto cdKMemberDto) {
        this.cdKMemberDto = cdKMemberDto;
    }

    public CdKAuthDto getCdKAuthDto() {
        return cdKAuthDto;
    }

    public void setCdKAuthDto(CdKAuthDto cdKAuthDto) {
        this.cdKAuthDto = cdKAuthDto;
    }

	public List<CdKMemberSecurityQuestionDto> getSecurityQuestions() {
		return securityQuestions;
	}

	public void setSecurityQuestions(List<CdKMemberSecurityQuestionDto> securityQuestions) {
		this.securityQuestions = securityQuestions;
	}
    
    

}

package net.cd.common.util.constant;

/**
 * @author bill lee 
 * @version 11162017:222448 
 */
public enum CdMemberValidateError implements StatusError{
	ERROR_USERNAME_LESS_THAN_SIX_CHARACTERS("U001","Length of username must be more than 6 characters"),
	ERROR_USERNAME_CONTAINS_SPECIAL_CHARACTER("U002","Username contains special characters"),
	ERROR_USERNAME_ALREADY_IN_USE("U003","This username already in use"),
	ERROR_EMAIL_INVALID_FORMAT("E001","Invalid email format"),
	ERROR_EMAIL_CONTAINS_SPECIAL_CHARACTER("E002","email contains special characters"),
	ERROR_EMAIL_ALREADY_IN_USE("E003","This email is already in use"),
	;
	
	private String errorCode;
	private String description;
	
	private CdMemberValidateError(String errorCode, String description){
		this.errorCode = errorCode;
		this.description = description;
	}

	@Override
	public String getDescription() {
		return description;
	}
	@Override
	public String getErrorCode() {
		return errorCode;
	}
	
}

package net.cd.dto.kernal;

import java.sql.Date;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Vincent 01/12/2017
 */
public class CdKMemberDto {

    @NotNull
    private Integer id;
    @JsonProperty(value="avatar")
    private String reference;
    @JsonProperty(value="username")
    private String identifier;
    @JsonIgnore
    private Integer salutation;
    @JsonIgnore
    private String given;
    @JsonProperty(value="name")
    private String family;
    
    @JsonIgnore
    private String email;
    @JsonIgnore
    private String mobile;
    @JsonIgnore
    private Date birth;
    @JsonIgnore
    private String locale;
    @JsonIgnore
    private Integer activated;
    @JsonIgnore
    private String activateCode;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }
    
    @JsonProperty(value="avatarFullPath")
    public String getAvatarFullParth() {
	    return "http://150.95.104.147:8080/apis/kernel/asset/"+reference;
	}
    
    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public Integer getSalutation() {
        return salutation;
    }

    public void setSalutation(Integer salutation) {
        this.salutation = salutation;
    }

    public String getGiven() {
        return given;
    }

    public void setGiven(String given) {
        this.given = given;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    

    public Integer getActivated() {
        return activated;
    }

    public void setActivated(Integer activated) {
        this.activated = activated;
    }

   
	public String getActivateCode() {
		return activateCode;
	}

	public void setActivateCode(String activateCode) {
		this.activateCode = activateCode;
	}
    
    
}

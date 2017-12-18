package net.cd.jpa.entity.kernal;

import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by Vincent on 03/12/2017.
 */
@Entity
@Table(name = "cd_kMember")
public class CdKMemberEntity {

	public enum Identity {
		EMAIL, MOBILE
	}

	private Integer id;
	private String reference;
	private String identifier;
	private Integer salutation;
	private String given;
	private String family;
	private String email;
	private String mobile;
	private Date birth;
	private String locale;
	private Integer activated;
	private Timestamp made;
	private Timestamp revised;
	private Timestamp purged;
	private String activateCode;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Basic
	@Column(name = "reference")
	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	@Basic
	@Column(name = "identifier")
	public String getIdentifier() {
		return identifier;
	}

	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}

	@Basic
	@Column(name = "salutation")
	public Integer getSalutation() {
		return salutation;
	}

	public void setSalutation(Integer salutation) {
		this.salutation = salutation;
	}

	@Basic
	@Column(name = "given")
	public String getGiven() {
		return given;
	}

	public void setGiven(String given) {
		this.given = given;
	}

	@Basic
	@Column(name = "family")
	public String getFamily() {
		return family;
	}

	public void setFamily(String family) {
		this.family = family;
	}

	@Basic
	@Column(name = "email")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Basic
	@Column(name = "mobile")
	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	@Basic
	@Column(name = "birth")
	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	@Basic
	@Column(name = "locale")
	public String getLocale() {
		return locale;
	}

	public void setLocale(String locale) {
		this.locale = locale;
	}


	@Basic
	@Column(name = "activated")
	public Integer getActivated() {
		return activated;
	}

	public void setActivated(Integer activated) {
		this.activated = activated;
	}

	@Basic
	@Column(name = "activate_code")
	public String getActivateCode() {
		return activateCode;
	}

	public void setActivateCode(String activateCode) {
		this.activateCode = activateCode;
	}

	@Basic
	@Column(name = "made")
	public Timestamp getMade() {
		return made;
	}

	public void setMade(Timestamp made) {
		this.made = made;
	}

	@Basic
	@Column(name = "revised")
	public Timestamp getRevised() {
		return revised;
	}

	public void setRevised(Timestamp revised) {
		this.revised = revised;
	}

	@Basic
	@Column(name = "purged")
	public Timestamp getPurged() {
		return purged;
	}

	public void setPurged(Timestamp purged) {
		this.purged = purged;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		CdKMemberEntity that = (CdKMemberEntity) o;

		if (id != that.id)
			return false;
		if (reference != null ? !reference.equals(that.reference) : that.reference != null)
			return false;
		if (identifier != null ? !identifier.equals(that.identifier) : that.identifier != null)
			return false;
		if (salutation != null ? !salutation.equals(that.salutation) : that.salutation != null)
			return false;
		if (given != null ? !given.equals(that.given) : that.given != null)
			return false;
		if (family != null ? !family.equals(that.family) : that.family != null)
			return false;
		if (mobile != that.mobile)
			return false;
		if (email != null ? !email.equals(that.email) : that.email != null)
			return false;
		if (birth != null ? !birth.equals(that.birth) : that.birth != null)
			return false;
		if (locale != null ? !locale.equals(that.locale) : that.locale != null)
			return false;
		if (activated != that.activated)
			return false;
		if (made != null ? !made.equals(that.made) : that.made != null)
			return false;
		if (revised != null ? !revised.equals(that.revised) : that.revised != null)
			return false;
		if (purged != null ? !purged.equals(that.purged) : that.purged != null)
			return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result = id;
		result = 31 * result + (reference != null ? reference.hashCode() : 0);
		result = 31 * result + (identifier != null ? identifier.hashCode() : 0);
		result = 31 * result + (salutation != null ? salutation.hashCode() : 0);
		result = 31 * result + (given != null ? given.hashCode() : 0);
		result = 31 * result + (family != null ? family.hashCode() : 0);
		result = 31 * result + (email != null ? email.hashCode() : 0);
		result = 31 * result + (mobile != null ? mobile.hashCode() : 0);
		result = 31 * result + (birth != null ? birth.hashCode() : 0);
		result = 31 * result + (locale != null ? locale.hashCode() : 0);
		result = 31 * result + activated;
		result = 31 * result + (made != null ? made.hashCode() : 0);
		result = 31 * result + (revised != null ? revised.hashCode() : 0);
		result = 31 * result + (purged != null ? purged.hashCode() : 0);
		return result;
	}
}

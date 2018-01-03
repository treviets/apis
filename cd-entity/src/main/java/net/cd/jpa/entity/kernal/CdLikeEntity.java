package net.cd.jpa.entity.kernal;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Created by Vincent on 18/12/2017
 */
@Entity
@Table(name = "cd_like")
public class CdLikeEntity {

	private Integer id;
	private CdKMemberEntity author;
	private String made;
	private String revised;
	private String purged;
	private CdArticleEntity article;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@OneToOne
	@JoinColumn(name="author")
	public CdKMemberEntity getAuthor() {
		return author;
	}

	public void setAuthor(CdKMemberEntity author) {
		this.author = author;
	}

	
	@Basic
	@Column(name = "made")
	public String getMade() {
		return made;
	}

	public void setMade(String made) {
		this.made = made;
	}

	@Basic
	@Column(name = "revised")
	public String getRevised() {
		return revised;
	}

	public void setRevised(String revised) {
		this.revised = revised;
	}

	@Basic
	@Column(name = "purged")
	public String getPurged() {
		return purged;
	}

	public void setPurged(String purged) {
		this.purged = purged;
	}
	
	

	@ManyToOne
	public CdArticleEntity getArticle() {
		return article;
	}

	public void setArticle(CdArticleEntity article) {
		this.article = article;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		CdLikeEntity that = (CdLikeEntity) o;

		if (id != that.id)
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
		int result = id != null ? id : 0;
		result = 31 * result + (made != null ? made.hashCode() : 0);
		result = 31 * result + (revised != null ? revised.hashCode() : 0);
		result = 31 * result + (purged != null ? purged.hashCode() : 0);
		return result;
	}
}

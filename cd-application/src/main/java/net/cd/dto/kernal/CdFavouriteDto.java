package net.cd.dto.kernal;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class CdFavouriteDto {
	private Integer id;
	private CdKMemberDto author;
	private String made;
	private String revised;
	@JsonIgnore
	private CdArticleDto article;
	
	@JsonIgnore
	private String purged;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public CdKMemberDto getAuthor() {
		return author;
	}
	public void setAuthor(CdKMemberDto author) {
		this.author = author;
	}
	public String getMade() {
		return made;
	}
	public void setMade(String made) {
		this.made = made;
	}
	public String getRevised() {
		return revised;
	}
	public void setRevised(String revised) {
		this.revised = revised;
	}
	public String getPurged() {
		return purged;
	}
	public void setPurged(String purged) {
		this.purged = purged;
	}
	public CdArticleDto getArticle() {
		return article;
	}
	public void setArticle(CdArticleDto article) {
		this.article = article;
	}
	
}

package net.cd.dto.kernal;

import net.cd.jpa.entity.kernal.CdFeedEntity.FeedScope;

public class CdFeedDto {
	private Integer id;
	private String reference;
	private CdKMemberDto author;
	private CdArticleDto article;
	private FeedScope scope;
	private String made;
	private String revised;
    private String purged;
    
	public CdKMemberDto getAuthor() {
		return author;
	}
	
	
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


	public void setAuthor(CdKMemberDto author) {
		this.author = author;
	}
	public CdArticleDto getArticle() {
		return article;
	}
	public void setArticle(CdArticleDto article) {
		this.article = article;
	}


	public FeedScope getScope() {
		return scope;
	}


	public void setScope(FeedScope scope) {
		this.scope = scope;
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
	
	
}

package net.cd.jpa.entity.kernal;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Created by Vincent on 07/12/2017
 */
@Entity
@Table(name = "cd_feed")
public class CdFeedEntity {
	public enum FeedScope {
        PUBLIC, PRIVATE, FRIEND;
    }
	private Integer id;
	private String reference;
	private FeedScope scope;
	private CdKMemberEntity author;
	private CdArticleEntity article;
	private String made;
	private String revised;
    private String purged;
    
    @Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	@Basic
    @Column(name="reference")
	public String getReference() {
		return reference;
	}
	public void setReference(String reference) {
		this.reference = reference;
	}
	
	@Enumerated(EnumType.STRING)
	@Column(name="scope")
	public FeedScope getScope() {
		return scope;
	}
	public void setScope(FeedScope scope) {
		this.scope = scope;
	}
	
	
	@OneToOne (cascade=CascadeType.DETACH)
    @JoinColumn(name = "author")
	public CdKMemberEntity getAuthor() {
		return author;
	}
	public void setAuthor(CdKMemberEntity author) {
		this.author = author;
	}
	
	@OneToOne (cascade=CascadeType.ALL)
    @JoinColumn(name = "article")
	public CdArticleEntity getArticle() {
		return article;
	}
	public void setArticle(CdArticleEntity article) {
		this.article = article;
	}
	
	@Basic
	@Column(name="made")
	public String getMade() {
		return made;
	}
	public void setMade(String made) {
		this.made = made;
	}
	
	@Basic
	@Column(name="revised")
	public String getRevised() {
		return revised;
	}
	public void setRevised(String revised) {
		this.revised = revised;
	}
	
	@Basic
	@Column(name="purged")
	public String getPurged() {
		return purged;
	}
	public void setPurged(String purged) {
		this.purged = purged;
	}
    
    
	
}

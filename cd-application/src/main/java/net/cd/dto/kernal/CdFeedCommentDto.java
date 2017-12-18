package net.cd.dto.kernal;

public class CdFeedCommentDto {
	private Integer id;
	private Integer article;
	private Integer comment;
	private String made;
	private String revised;
	private String purged;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getArticle() {
		return article;
	}
	public void setArticle(Integer article) {
		this.article = article;
	}
	public Integer getComment() {
		return comment;
	}
	public void setComment(Integer comment) {
		this.comment = comment;
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

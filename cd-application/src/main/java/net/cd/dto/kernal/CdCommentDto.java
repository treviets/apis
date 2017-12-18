package net.cd.dto.kernal;

public class CdCommentDto {
	private Integer id;
	private CdKMemberDto author;
	private String comment;
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
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	
	
}

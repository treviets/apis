package net.cd.dto.kernal;

import java.util.List;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Created by Vincent on 07/12/2017.
 */
public class CdArticleDto {

    @NotNull
    private Integer id;
    private String title;
    private String description;
    private Integer favouriteCount;
    private Boolean isFavourite;
    private Integer commentCount;
    private Integer sharedCount;
    private String made;
    private String revised;
    @JsonIgnore
    private String purged;
    private List<CdKAssetDto> photos;
    private List<CdCommentDto> comments;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getFavouriteCount() {
		return favouriteCount;
	}
	public void setFavouriteCount(Integer favouriteCount) {
		this.favouriteCount = favouriteCount;
	}
	public Boolean getIsFavourite() {
		return isFavourite;
	}
	public void setIsFavourite(Boolean isFavourite) {
		this.isFavourite = isFavourite;
	}
	public Integer getCommentCount() {
		return commentCount;
	}
	public void setCommentCount(Integer commentCount) {
		this.commentCount = commentCount;
	}
	public Integer getSharedCount() {
		return sharedCount;
	}
	public void setSharedCount(Integer sharedCount) {
		this.sharedCount = sharedCount;
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
	
	public List<CdKAssetDto> getPhotos() {
		return photos;
	}
	public void setPhotos(List<CdKAssetDto> photos) {
		this.photos = photos;
	}
	public List<CdCommentDto> getComments() {
		return comments;
	}
	public void setComments(List<CdCommentDto> comments) {
		this.comments = comments;
	}
    
	
    
}

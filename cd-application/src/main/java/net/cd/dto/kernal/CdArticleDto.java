package net.cd.dto.kernal;

import java.util.Set;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Vincent on 07/12/2017.
 */
public class CdArticleDto {

	@NotNull
	private Integer id;
	private String title;
	private String description;
	private boolean isFavourite;
	private String made;
	private String revised;
	@JsonIgnore
	private String purged;
	private Set<CdKAssetDto> photos;
	private Set<CdCommentDto> comments;
	private Set<CdLikeDto> likes;
	private Set<CdShareDto> shares;
	private Set<CdFavouriteDto> favourites;

	
	

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

	@JsonProperty(value="favouriteCount")
	public Integer getFavouriteCount() {
		return favourites != null ? favourites.size() : 0;
	}


	public boolean getIsFavourite() {
		return isFavourite;
	}

	public void setIsFavourite(boolean isFavourite) {
		this.isFavourite = isFavourite;
	}

	@JsonProperty(value="commentCount")
	public Integer getCommentCount() {
		return comments != null ? comments.size() : 0;
	}

	@JsonProperty(value="sharedCount")
	public Integer getSharedCount() {
		return shares != null ? shares.size() : 0;
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

	public Set<CdKAssetDto> getPhotos() {
		return photos;
	}

	public void setPhotos(Set<CdKAssetDto> photos) {
		this.photos = photos;
	}

	public Set<CdCommentDto> getComments() {
		return comments;
	}

	public void setComments(Set<CdCommentDto> comments) {
		this.comments = comments;
	}

	public Set<CdLikeDto> getLikes() {
		return likes;
	}

	public void setLikes(Set<CdLikeDto> likes) {
		this.likes = likes;
	}

	@JsonProperty(value="likeCount")
	public Integer getLikeCount() {
		return likes != null ? likes.size() : 0;
	}

	public Set<CdShareDto> getShares() {
		return shares;
	}

	public void setShares(Set<CdShareDto> shares) {
		this.shares = shares;
	}

	public Set<CdFavouriteDto> getFavourites() {
		return favourites;
	}

	public void setFavourites(Set<CdFavouriteDto> favourites) {
		this.favourites = favourites;
	}

	
	
}

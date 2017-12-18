package net.cd.jpa.entity.kernal;

import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * Created by Vincent on 07/12/2017
 */
@Entity
@Table(name = "cd_article")
public class CdArticleEntity {
	
	private Integer id;
    private String title;
    private String description;
    private String made;
    private String revised;
    private String purged;
    private List<CdKAssetEntity> photos;
    private List<CdCommentEntity> comments;
    private List<CdLikeEntity> likes;
    private List<CdShareEntity> shares;
    private List<CdFavouriteEntity> favourites;
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
	@Column(name="title")
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	@Basic
	@Column(name="description")
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
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
	
	
	@OneToMany (fetch = FetchType.EAGER, cascade=CascadeType.ALL)
    @JoinTable(
            name = "cd_articleImage",
            joinColumns = @JoinColumn(name = "article", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "asset", referencedColumnName = "id"))
    public List<CdKAssetEntity> getPhotos() {
		return photos;
	}
	public void setPhotos(List<CdKAssetEntity> photos) {
		this.photos = photos;
	}
	
	
	@OneToMany (fetch = FetchType.EAGER, cascade=CascadeType.ALL)
    @JoinTable(
            name = "cd_articleComment",
            joinColumns = @JoinColumn(name = "article", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "comment", referencedColumnName = "id"))
	public List<CdCommentEntity> getComments() {
		return comments;
	}
	public void setComments(List<CdCommentEntity> comments) {
		this.comments = comments;
	}
	
	@OneToMany (fetch = FetchType.EAGER, cascade=CascadeType.ALL)
    @JoinTable(
            name = "cd_articleLike",
            joinColumns = @JoinColumn(name = "article", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "like", referencedColumnName = "id"))
	public List<CdLikeEntity> getLikes() {
		return likes;
	}
	public void setLikes(List<CdLikeEntity> likes) {
		this.likes = likes;
	}
	
	@OneToMany (fetch = FetchType.EAGER, cascade=CascadeType.ALL)
    @JoinTable(
            name = "cd_articleShare",
            joinColumns = @JoinColumn(name = "article", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "share", referencedColumnName = "id"))
	public List<CdShareEntity> getShares() {
		return shares;
	}
	public void setShares(List<CdShareEntity> shares) {
		this.shares = shares;
	}
	
	@OneToMany (fetch = FetchType.EAGER, cascade=CascadeType.ALL)
    @JoinTable(
            name = "cd_articleFavourite",
            joinColumns = @JoinColumn(name = "article", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "favourite", referencedColumnName = "id"))
	public List<CdFavouriteEntity> getFavourites() {
		return favourites;
	}
	public void setFavourites(List<CdFavouriteEntity> favourites) {
		this.favourites = favourites;
	}
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CdArticleEntity that = (CdArticleEntity) o;

        if (id != that.id) return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (made != null ? !made.equals(that.made) : that.made != null) return false;
        if (revised != null ? !revised.equals(that.revised) : that.revised != null) return false;
        if (purged != null ? !purged.equals(that.purged) : that.purged != null) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (made != null ? made.hashCode() : 0);
        result = 31 * result + (revised != null ? revised.hashCode() : 0);
        result = 31 * result + (purged != null ? purged.hashCode() : 0);
        return result;
    }
}

package net.cd.jpa.entity.kernal;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by Tree.Yip on 25/6/2017.
 */
@Entity
@Table(name = "cd_kAsset")
public class CdKAssetEntity {

    public enum AssetTypes {
    		AVATAR, FEED, ALBUM;
    }

    private Integer id;
    private String reference;
    private String extern;
    private Integer member;
    private String md5;
    private String mime;
    private String name;
    private String note;
    private AssetTypes type;
    private Integer link;
    private Integer purgable;
    private Timestamp made;
    private Timestamp revised;
    private Timestamp purged;
	private CdArticleEntity article;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
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
    @Column(name = "extern")
    public String getExtern() {
        return extern;
    }

    public void setExtern(String extern) {
        this.extern = extern;
    }

    @Basic
    @Column(name="member")
    public Integer getMember() {
        return member;
    }

    public void setMember(Integer member) {
        this.member = member;
    }

    @Basic
    @Column(name = "md5")
    public String getMd5() {
        return md5;
    }

    public void setMd5(String md5) {
        this.md5 = md5;
    }

    @Basic
    @Column(name = "mime")
    public String getMime() {
        return mime;
    }

    public void setMime(String mime) {
        this.mime = mime;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "note")
    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Enumerated(EnumType.STRING)
    @Column(name = "type", columnDefinition = "ENUM('AVATAR', 'FEED', 'ALBUM')")
    public AssetTypes getType() {
        return type;
    }

    public void setType(AssetTypes type) {
        this.type = type;
    }

    @Basic
    @Column(name = "link")
    public Integer getLink() {
        return link;
    }

    public void setLink(Integer link) {
        this.link = link;
    }

    @Basic
    @Column(name = "purgable")
    public Integer getPurgable() {
        return purgable;
    }

    public void setPurgable(Integer important) {
        this.purgable = important;
    }

    @Basic
    @Column(name = "made")
    public Timestamp getMade() {
        return made;
    }

    public void setMade(Timestamp made) {
        this.made = (made != null && made.getTime() != 0) ? made : new Timestamp(System.currentTimeMillis());
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

    @ManyToOne
	public CdArticleEntity getArticle() {
		return article;
	}

	public void setArticle(CdArticleEntity article) {
		this.article = article;
	}
	
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CdKAssetEntity that = (CdKAssetEntity) o;

        if (id != that.id) return false;
        if (reference != null ? !reference.equals(that.reference) : that.reference != null) return false;
        if (md5 != null ? !md5.equals(that.md5) : that.md5 != null) return false;
        if (mime != null ? !mime.equals(that.mime) : that.mime != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (note != null ? !note.equals(that.note) : that.note != null) return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;
        if (extern != null ? !extern.equals(that.extern) : that.extern != null) return false;
        if (link != that.link) return false;
        if (purgable != that.purgable) return false;
        if (made != null ? !made.equals(that.made) : that.made != null) return false;
        if (revised != null ? !revised.equals(that.revised) : that.revised != null) return false;
        if (purged != null ? !purged.equals(that.purged) : that.purged != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id : 0;
        result = 31 * result + (reference != null ? reference.hashCode() : 0);
        result = 31 * result + (md5 != null ? md5.hashCode() : 0);
        result = 31 * result + (mime != null ? mime.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (note != null ? note.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (extern != null ? extern.hashCode() : 0);
        result = 31 * result + (link != null ? link.hashCode() : 0);
        result = 31 * result + (purgable != null ? purgable.hashCode() : 0);
        result = 31 * result + (made != null ? made.hashCode() : 0);
        result = 31 * result + (revised != null ? revised.hashCode() : 0);
        result = 31 * result + (purged != null ? purged.hashCode() : 0);
        return result;
    }
}

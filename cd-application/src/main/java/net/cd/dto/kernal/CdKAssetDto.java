package net.cd.dto.kernal;

import net.cd.jpa.entity.kernal.CdKAssetEntity;

import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Vincent on 01/12/2017.
 */
public class CdKAssetDto {

    @NotNull
    private Integer id;
    @JsonIgnore
    private String reference;
    @JsonIgnore
    private String extern;
    @JsonIgnore
    private Integer member;
    @JsonIgnore
    private String md5;
    @JsonIgnore
    private String mime;
    @JsonIgnore
    private String name;
    @JsonProperty(value="description")
    private String note;
    @JsonIgnore
    private CdKAssetEntity.AssetTypes type;
    @JsonIgnore
    private Integer link;
    @JsonIgnore
    private Integer purgable;
    @JsonIgnore
    private Long made;

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

    public String getExtern() {
        return extern;
    }

    public void setExtern(String extern) {
        this.extern = extern;
    }

    public Integer getMember() {
        return member;
    }

    public void setMember(Integer member) {
        this.member = member;
    }

    public String getMd5() {
        return md5;
    }

    public void setMd5(String md5) {
        this.md5 = md5;
    }

    public String getMime() {
        return mime;
    }

    public void setMime(String mime) {
        this.mime = mime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public CdKAssetEntity.AssetTypes getType() {
        return type;
    }

    public void setType(CdKAssetEntity.AssetTypes type) {
        this.type = type;
    }

    
    public Integer getLink() {
        return link;
    }
    @JsonProperty(value="url")
    @Transient
    public String url() {
    		return "http://150.95.104.147:8080/apis/kernel/asset/"+reference;
    }

    public void setLink(Integer link) {
        this.link = link;
    }

    public Integer getPurgable() {
        return purgable;
    }

    public void setPurgable(Integer purgable) {
        this.purgable = purgable;
    }

    public Long getMade() {
        return made;
    }

    public void setMade(Long made) {
        this.made = made;
    }
}

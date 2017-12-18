package net.cd.dto.kernal;

import net.cd.jpa.entity.kernal.CdKAssetEntity;

/**
 * Created by Vincent on 01/12/2017.
 */
public class CdKAssetMetaDataDto {

    public enum OpKEntityType {
        OpKRegistrant, OpKBilling,
    }

    public Integer id;
    public String reference;
    public OpKEntityType opKEntityType;
    public CdKAssetEntity.AssetTypes opKAssetType;
    public Long expiry;

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

    public OpKEntityType getOpKEntityType() {
        return opKEntityType;
    }

    public void setOpKEntityType(OpKEntityType opKEntityType) {
        this.opKEntityType = opKEntityType;
    }

    public CdKAssetEntity.AssetTypes getVnKAssetType() {
        return opKAssetType;
    }

    public void setVnKAssetType(CdKAssetEntity.AssetTypes opKAssetType) {
        this.opKAssetType = opKAssetType;
    }

    public Long getExpiry() {
        return expiry;
    }

    public void setExpiry(Long expiry) {
        this.expiry = expiry;
    }
}

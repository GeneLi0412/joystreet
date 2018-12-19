package com.gene.joystreet.entity;

import java.io.Serializable;
import java.math.BigDecimal;

public class Goods implements Serializable{

	private static final long serialVersionUID = -2589055496032077604L;

	private String id;

    private String sellerId;

    private String goodsName;

    private String defaultItemId;

    private String auditStatus;

    private String isMarketable;

    private String brandId;

    private String caption;

    private String category1Id;

    private String category2Id;

    private String category3Id;

    private String smallPic;

    private BigDecimal price;

    private String typeTemplateId;

    private String isEnableSpec;

    private String isDelete;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getSellerId() {
        return sellerId;
    }

    public void setSellerId(String sellerId) {
        this.sellerId = sellerId == null ? null : sellerId.trim();
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName == null ? null : goodsName.trim();
    }

    public String getDefaultItemId() {
        return defaultItemId;
    }

    public void setDefaultItemId(String defaultItemId) {
        this.defaultItemId = defaultItemId == null ? null : defaultItemId.trim();
    }

    public String getAuditStatus() {
        return auditStatus;
    }

    public void setAuditStatus(String auditStatus) {
        this.auditStatus = auditStatus == null ? null : auditStatus.trim();
    }

    public String getIsMarketable() {
        return isMarketable;
    }

    public void setIsMarketable(String isMarketable) {
        this.isMarketable = isMarketable == null ? null : isMarketable.trim();
    }

    public String getBrandId() {
        return brandId;
    }

    public void setBrandId(String brandId) {
        this.brandId = brandId == null ? null : brandId.trim();
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption == null ? null : caption.trim();
    }

    public String getCategory1Id() {
        return category1Id;
    }

    public void setCategory1Id(String category1Id) {
        this.category1Id = category1Id == null ? null : category1Id.trim();
    }

    public String getCategory2Id() {
        return category2Id;
    }

    public void setCategory2Id(String category2Id) {
        this.category2Id = category2Id == null ? null : category2Id.trim();
    }

    public String getCategory3Id() {
        return category3Id;
    }

    public void setCategory3Id(String category3Id) {
        this.category3Id = category3Id == null ? null : category3Id.trim();
    }

    public String getSmallPic() {
        return smallPic;
    }

    public void setSmallPic(String smallPic) {
        this.smallPic = smallPic == null ? null : smallPic.trim();
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getTypeTemplateId() {
        return typeTemplateId;
    }

    public void setTypeTemplateId(String typeTemplateId) {
        this.typeTemplateId = typeTemplateId == null ? null : typeTemplateId.trim();
    }

    public String getIsEnableSpec() {
        return isEnableSpec;
    }

    public void setIsEnableSpec(String isEnableSpec) {
        this.isEnableSpec = isEnableSpec == null ? null : isEnableSpec.trim();
    }

    public String getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(String isDelete) {
        this.isDelete = isDelete == null ? null : isDelete.trim();
    }
}
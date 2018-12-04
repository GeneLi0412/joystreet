package com.gene.joystreet.entity;

import java.io.Serializable;

/**
 * 规格详情
 * @author: LJP
 * @date: 2018年12月4日 上午9:23:11
 */
public class Specificationoption implements Serializable{
	
	private static final long serialVersionUID = 66565428841854827L;

	private String id;

    private String optionName;

    private String specId;

    private Integer orders;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getOptionName() {
        return optionName;
    }

    public void setOptionName(String optionName) {
        this.optionName = optionName == null ? null : optionName.trim();
    }

    public String getSpecId() {
        return specId;
    }

    public void setSpecId(String specId) {
        this.specId = specId;
    }

    public Integer getOrders() {
        return orders;
    }

    public void setOrders(Integer orders) {
        this.orders = orders;
    }
}
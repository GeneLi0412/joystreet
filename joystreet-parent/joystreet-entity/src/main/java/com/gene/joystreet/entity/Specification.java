package com.gene.joystreet.entity;

import java.io.Serializable;
import java.util.List;

/**
 * 规格
 * @author: LJP
 * @date: 2018年12月4日 上午9:21:55
 */
public class Specification implements Serializable{

	private static final long serialVersionUID = -2659885759962584825L;

	private String id;

    private String specName;
    
    private List<Specificationoption> specificationOptions;

    public List<Specificationoption> getSpecificationOptions() {
		return specificationOptions;
	}

	public void setSpecificationOptions(List<Specificationoption> specificationOptions) {
		this.specificationOptions = specificationOptions;
	}

	public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getSpecName() {
        return specName;
    }

    public void setSpecName(String specName) {
        this.specName = specName == null ? null : specName.trim();
    }
}
package com.gene.joystreet.entity;

import java.io.Serializable;

public class Specification implements Serializable{

	private static final long serialVersionUID = -5484213511693512844L;

	private Long id;

    private String specName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSpecName() {
        return specName;
    }

    public void setSpecName(String specName) {
        this.specName = specName == null ? null : specName.trim();
    }
}
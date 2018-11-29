package com.gene.joystreet.entity;

import java.io.Serializable;

public class Contentcategory implements Serializable{

	private static final long serialVersionUID = 8673557881175604842L;

	private Long id;

    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }
}
package com.gene.joystreet.entity;

import java.io.Serializable;

public class Brand implements Serializable{

	private static final long serialVersionUID = 8694282905688172576L;

	private String id;

    private String name;

    private String firstChar;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getFirstChar() {
        return firstChar;
    }

    public void setFirstChar(String firstChar) {
        this.firstChar = firstChar == null ? null : firstChar.trim();
    }
}
package com.gene.joystreet.entity;

import java.io.Serializable;
import java.util.List;

/**
 * 商品整合
 * @author: LJP
 * @date: 2018年12月19日 下午4:25:31
 */
public class Product implements Serializable{

	private static final long serialVersionUID = 8174093269736733550L;
	
	/**
	 * 商品SPU
	 */
	private Goods goods;
	
	/**
	 * 商品详情
	 */
	private Goodsdesc goodsdesc;
	
	/**
	 * 商品SKU列表
	 */
	private List<Item> items;
	
	public Product() {
		// TODO Auto-generated constructor stub
	}

	public Product(Goods goods, Goodsdesc goodsdesc, List<Item> items) {
		super();
		this.goods = goods;
		this.goodsdesc = goodsdesc;
		this.items = items;
	}

	public Goods getGoods() {
		return goods;
	}

	public void setGoods(Goods goods) {
		this.goods = goods;
	}

	public Goodsdesc getGoodsdesc() {
		return goodsdesc;
	}

	public void setGoodsdesc(Goodsdesc goodsdesc) {
		this.goodsdesc = goodsdesc;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}
	
}

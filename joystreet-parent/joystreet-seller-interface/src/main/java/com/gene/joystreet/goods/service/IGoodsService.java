package com.gene.joystreet.goods.service;

import java.util.Map;

import com.gene.joystreet.entity.Product;

/**
 * 商品相关
 * @author: LJP
 * @date: 2018年12月19日 下午4:33:01
 */
public interface IGoodsService {

	/**
	 * 添加商品
	 * @param product
	 * @return
	 */
	public Map<String, Object> addGoods(Product product);

}

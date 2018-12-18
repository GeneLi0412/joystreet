package com.gene.joystreet.itemcat.service;

import java.util.Map;

/**
 * 商品分类相关
 * @author: LJP
 * @date: 2018年12月18日 下午4:10:21
 */
public interface ItemCatService {

	/**
	 * 查询商品分类
	 * @param page
	 * @param rows
	 * @param parentId
	 * @return
	 */
	public Map<String, Object> queryByParent(Integer page, Integer rows, String parentId);
	
}

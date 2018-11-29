package com.gene.joystreet.brand.service;

import java.util.List;

import com.gene.joystreet.entity.Brand;

/**
 * 
* Copyright: Copyright (c) 2018 GeneLi0412
* 
* @ClassName: IBrandService.java
* @Description: 商品品牌相关
*
* @author: LJP
* @date: 2018年11月29日 下午3:30:05
 */
public interface IBrandService {
	
	/**
	 * 查询所有品牌列表
	 * @return
	 */
	public List<Brand> queryAllBrands();
}

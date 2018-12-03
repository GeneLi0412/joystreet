package com.gene.joystreet.brand.service;

import java.util.Map;

import com.gene.joystreet.entity.Brand;
import com.gene.joystreet.util.PageResult;

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
	 * 根据分页查找品牌
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public PageResult<Brand> queryByPage(int pageNo, int pageSize, String search);

	/**
	 * 添加品牌
	 * @param brand
	 * @return
	 */
	public Map<String, Object> addBrand(Brand brand);

	/**
	 * 查找
	 * @param id
	 * @return
	 */
	public Map<String, Object> findOne(String id);

	/**
	 * 更新
	 * @param brand
	 * @return
	 */
	public Map<String, Object> updateBrand(Brand brand);

	/**
	 * 批量删除
	 * @param ids
	 * @return
	 */
	public Map<String, Object> deleteByIds(String[] ids);
}

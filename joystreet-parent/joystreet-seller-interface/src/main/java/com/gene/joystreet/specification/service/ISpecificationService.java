package com.gene.joystreet.specification.service;

import java.util.Map;

/**
 * 规格服务
 * @author: LJP
 * @date: 2018年12月4日 上午9:25:10
 */
public interface ISpecificationService {

	/**
	 * 分页高级查询
	 * @param page
	 * @param rows
	 * @param searchText
	 * @return
	 */
	public Map<String, Object> querySpecificByPage(Integer page, Integer rows, String searchText);
	
	/**
	 * 新增或修改
	 * @param specificId
	 * @param specificName
	 * @param optionNames
	 * @param optionOrders
	 * @return
	 */
	public Map<String, Object> saveOrModify(String specificId, String specificName,
			String[] optionNames, Integer[] optionOrders);

	/**
	 * 批量删除规格
	 * @param ids
	 * @return
	 */
	public Map<String, Object> deleteSpecificByIds(String[] ids);

	/**
	 * 根据规格ID查询规格信息
	 * @param id
	 * @return
	 */
	public Map<String, Object> querySpecificById(String id);

	/**
	 * 查询所有
	 * @return
	 */
	public Map<String, Object> queryAll();
	
}

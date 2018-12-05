package com.gene.joystreet.template.service;

import java.util.Map;

import com.gene.joystreet.entity.Typetemplate;

/**
 * 商品模板管理
 * @author: LJP
 * @date: 2018年12月5日 上午9:24:31
 */
public interface ITemplateService {

	/**
	 * 分页查询商品模板
	 * @param page
	 * @param rows
	 * @param searchstr
	 * @return
	 */
	public Map<String, Object> queryTemplatesByPage(Integer page, Integer rows, String searchstr);

	/**
	 * 修改更新
	 * @param typetemplate
	 * @return
	 */
	public Map<String, Object> saveOrModify(Typetemplate typetemplate);

	/**
	 * 批量删除
	 * @param ids
	 * @return
	 */
	public Map<String, Object> deleteByIds(String[] ids);
	
}

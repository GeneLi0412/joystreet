package com.gene.joystreet.specification.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.dubbo.common.utils.StringUtils;
import com.gene.joystreet.common.SystemMessageConstant;
import com.gene.joystreet.specification.service.ISpecificationService;

/**
 * 规格管理相关
 * @author: LJP
 * @date: 2018年12月3日 下午6:12:17
 */
@Controller
@RequestMapping("specification")
public class SpecificationController {
	
	@Autowired
	private ISpecificationService specificationService;
	
	@RequestMapping("queryAll")
	@ResponseBody
	public Map<String, Object> queryAll(){
		Map<String, Object> base = new HashMap<>();
		try {
			base = specificationService.queryAll();
		} catch (Exception e) {
			base.put("error", true);
			base.put("message", SystemMessageConstant.OPERATION_FAIL);
		}
		return base;
	}
	
	/**
	 * 分页高级查询
	 * @param page
	 * @param rows
	 * @param searchText
	 * @return
	 */
	@RequestMapping("queryByPage")
	@ResponseBody
	public Map<String, Object> querySpecificByPage(@RequestParam(defaultValue="1") Integer page, @RequestParam(defaultValue="5") Integer rows,
			String searchText){
		Map<String, Object> base = new HashMap<>();
		try {
			base = specificationService.querySpecificByPage(page, rows, searchText);
		} catch (Exception e) {
			base.put("error", true);
			base.put("message", SystemMessageConstant.OPERATION_FAIL);
			base.put("exception", e);
		}
		return base;
	}
	
	
	/**
	 * 新增或修改
	 * @param specificId
	 * @param specificName
	 * @param optionNames
	 * @param optionOrders
	 * @return
	 */
	@RequestMapping("saveOrModify")
	@ResponseBody
	public Map<String, Object> saveOrModify(String specificId, String specificName,
			String[] optionNames, Integer[] optionOrders){
		Map<String, Object> base = new HashMap<>();
		if(StringUtils.isBlank(specificName)) {
			base.put("error", true);
			base.put("message", "名字不能为空！");
			return base;
		}
		try {
			base = specificationService.saveOrModify(specificId, specificName, optionNames, optionOrders);
		} catch (Exception e) {
			base.put("error", true);
			base.put("message", SystemMessageConstant.OPERATION_FAIL);
			base.put("exception", e);
		}
		return base;
	}
	
	/**
	 * 批量删除
	 * @param ids
	 * @return
	 */
	@RequestMapping("deleteByIds")
	@ResponseBody
	public Map<String, Object> deleteByIds(String[] ids){
		Map<String, Object> base = new HashMap<>();
		try {
			base = specificationService.deleteSpecificByIds(ids);
		} catch (Exception e) {
			base.put("error", true);
			base.put("message", SystemMessageConstant.OPERATION_FAIL);
		}
		return base;
	}
	
	/**
	 * 根据ID查找规格
	 * @param id
	 * @return
	 */
	@RequestMapping("findOne")
	@ResponseBody
	public Map<String, Object> findOne(String id){
		Map<String, Object> base = new HashMap<>();
		try {
			base = specificationService.querySpecificById(id);
		} catch (Exception e) {
			base.put("error", true);
			base.put("message", SystemMessageConstant.OPERATION_FAIL);
		}
		return base;
	}
}

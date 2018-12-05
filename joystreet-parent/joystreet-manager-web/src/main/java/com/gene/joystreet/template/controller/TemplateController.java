package com.gene.joystreet.template.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.dubbo.common.utils.StringUtils;
import com.gene.joystreet.common.SystemMessageConstant;
import com.gene.joystreet.entity.Typetemplate;
import com.gene.joystreet.template.service.ITemplateService;

/**
 * 商品模板
 * @author: LJP
 * @date: 2018年12月5日 上午9:22:58
 */
@Controller
@RequestMapping("template")
public class TemplateController {
	
	@Autowired
	private ITemplateService templateService;
	
	/**
	 * 批量删除
	 * @param ids
	 * @return
	 */
	@RequestMapping("deleteByIds")
	@ResponseBody
	public Map<String, Object> deleteByIds(String[] ids){
		Map<String, Object> base = new HashMap<>();
		if(ids == null || ids.length == 0) {
			base.put("error", true);
			base.put("message", "请选择要删除的选项！");
			return base;
		}
		try {
			base = templateService.deleteByIds(ids);
		} catch (Exception e) {
			base.put("error", true);
			base.put("message", SystemMessageConstant.OPERATION_FAIL);
		}
		return base;
	}
	
	/**
	 * 新增或修改
	 * @param typetemplate
	 * @return
	 */
	@RequestMapping("saveOrModify")
	@ResponseBody
	public Map<String, Object> saveOrModify(Typetemplate typetemplate){
		Map<String, Object> base = new HashMap<>();
		if(typetemplate == null) {
			base.put("error", true);
			base.put("message", "传参异常！");
			return base;
		}
		if(StringUtils.isBlank(typetemplate.getName())) {
			base.put("error", true);
			base.put("message", "名字不能为空！");
			return base;
		}
		try {
			base = templateService.saveOrModify(typetemplate);
		} catch (Exception e) {
			base.put("error", true);
			base.put("message", SystemMessageConstant.OPERATION_FAIL);
			base.put("exception", e);
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
	public Map<String, Object> queryByPage(@RequestParam(defaultValue="1") Integer page, @RequestParam(defaultValue="5") Integer rows,
			String searchstr){
		Map<String, Object> base = new HashMap<>();
		try {
			base = templateService.queryTemplatesByPage(page, rows, searchstr);
		} catch (Exception e) {
			base.put("error", true);
			base.put("message", SystemMessageConstant.OPERATION_FAIL);
			base.put("exception", e);
		}
		return base;
	}
}

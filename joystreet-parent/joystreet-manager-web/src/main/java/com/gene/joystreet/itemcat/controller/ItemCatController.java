package com.gene.joystreet.itemcat.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gene.joystreet.itemcat.service.ItemCatService;
import com.gene.joystreet.util.ReturnMap;

/**
 * 商品分类
 * @author: LJP
 * @date: 2018年12月18日 下午4:09:19
 */
@Controller
@RequestMapping("itemcat")
public class ItemCatController {
	
	@Autowired
	private ItemCatService itemCatService;
	
	/**
	 * 根据父级ID查询商品分类
	 * @param page
	 * @param rows
	 * @param parentId
	 * @return
	 */
	@RequestMapping("queryByParent")
	@ResponseBody
	public Map<String, Object> queryByParent(@RequestParam(defaultValue="1") Integer page,@RequestParam(defaultValue="15") Integer rows,
			@RequestParam(defaultValue="0") String parentId){
		Map<String, Object> base = new HashMap<>();
		try {
			base = itemCatService.queryByParent(page, rows, parentId);
		} catch (Exception e) {
			e.printStackTrace();
			return ReturnMap.error();
		}
		return base;
	}
}

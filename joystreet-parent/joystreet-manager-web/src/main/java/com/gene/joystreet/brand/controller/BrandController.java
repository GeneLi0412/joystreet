package com.gene.joystreet.brand.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gene.joystreet.brand.service.IBrandService;

/**
 * 
 * Copyright: Copyright (c) 2018 GeneLi0412
 * 
 * @ClassName: BrandController.java
 * @Description: 品牌控制层
 *
 * @author: LJP
 * @date: 2018年11月29日 下午3:42:00
 */

@Controller
@RequestMapping("brand")
public class BrandController {

	@Autowired
	private IBrandService brandService;
	
	@RequestMapping("queryAllBrands")
	@ResponseBody
	public Map<String, Object> queryAllBands(){
		Map<String, Object> base = new HashMap<>();
		base.put("error", false);
		base.put("message", "操作成功");
		base.put("rows", brandService.queryAllBrands());
		return base;
 	}
}

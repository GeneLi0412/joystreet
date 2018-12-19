package com.gene.joystreet.goods.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gene.joystreet.entity.Product;
import com.gene.joystreet.goods.service.IGoodsService;
import com.gene.joystreet.util.ReturnMap;

/**
 * 商品相关
 * @author: LJP
 * @date: 2018年12月19日 下午4:31:40
 */
@Controller
@RequestMapping("goods")
public class GoodsController {
	
	@Autowired
	private IGoodsService goodsService;
	
	/**
	 * 添加商品
	 * @param product
	 * @return
	 */
	@ResponseBody
	@RequestMapping("addGoods")
	public Map<String, Object> addGoods(@RequestBody Product product) {
		Map<String, Object> base = new HashMap<>();
		// 将登陆用户名绑定到商品
		String userName = SecurityContextHolder.getContext().getAuthentication().getName();
		product.getGoods().setSellerId(userName);
		try {
			base = goodsService.addGoods(product);
		} catch (Exception e) {
			e.printStackTrace();
			return ReturnMap.error();
		}
		return base;
	}
}

package com.gene.joystreet.seller.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.dubbo.common.utils.StringUtils;
import com.gene.joystreet.entity.Seller;
import com.gene.joystreet.seller.service.ISellerService;
import com.gene.joystreet.util.ReturnMap;

/**
 * 商家控制层
 * @author: LJP
 * @date: 2018年12月10日 下午3:56:58
 */
@Controller
@RequestMapping("seller")
public class SellerController {
	
	@Autowired
	private ISellerService sellerService;
	
	/**
	 * 添加商户
	 * @param seller
	 * @return
	 */
	@RequestMapping("register")
	@ResponseBody
	public Map<String, Object> add(@RequestBody Seller seller){
		Map<String, Object> base = new HashMap<>();
		if(seller==null) {
			return ReturnMap.error("参数传递异常");
		}
		if(StringUtils.isBlank(seller.getName())) {
			return ReturnMap.error("用户名不能为空");
		}
		try {
			base = sellerService.addSeller(seller);
		} catch (Exception e) {
			return ReturnMap.error();
		}
		return base;
	}
}

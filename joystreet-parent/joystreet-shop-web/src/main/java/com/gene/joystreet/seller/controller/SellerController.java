package com.gene.joystreet.seller.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
	public Map<String, Object> add(Seller seller){
		Map<String, Object> base = new HashMap<>();
		if(seller==null) {
			return ReturnMap.error("参数传递异常");
		}
		if(StringUtils.isBlank(seller.getSellerId())) {
			return ReturnMap.error("登录名不能为空");
		}
		if(StringUtils.isBlank(seller.getPassword())) {
			return ReturnMap.error("密码不能为空");
		}
		if(StringUtils.isBlank(seller.getName())) {
			return ReturnMap.error("公司名字不能为空");
		}
		if(StringUtils.isBlank(seller.getNickName())) {
			return ReturnMap.error("商店名字不能为空");
		}
		if(StringUtils.isBlank(seller.getPassword())) {
			return ReturnMap.error("密码不能为空");
		}
		try {
			base = sellerService.addSeller(seller);
		} catch (Exception e) {
			e.printStackTrace();
			return ReturnMap.error();
		}
		return base;
	}
}

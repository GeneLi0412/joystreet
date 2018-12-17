package com.gene.joystreet.seller.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gene.joystreet.seller.service.ISellerService;
import com.gene.joystreet.util.ReturnMap;

/**
 * 商家控制层
 * @author: LJP
 * @date: 2018年12月17日 下午4:09:14
 */
@Controller
@RequestMapping("seller")
public class SellerController {
	
	@Autowired
	private ISellerService sellerService;
	
	/**
	 * 分页查询商家信息
	 * @param page
	 * @param rows
	 * @param companyName 公司名
	 * @param shopName 店铺名
	 * @return
	 */
	@RequestMapping("queryByPage")
	@ResponseBody
	public Map<String, Object> querySellerPage(@RequestParam(defaultValue="1") Integer page, @RequestParam(defaultValue="10") Integer rows,
				String companyName, String shopName){
		Map<String, Object> base = new HashMap<>();
		try {
			base = sellerService.queryByPage(page, rows, companyName, shopName);
		} catch (Exception e) {
			e.printStackTrace();
			return ReturnMap.error();
		}
		return base;
	}
}

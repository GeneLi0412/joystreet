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
	 * 更新商家申请状态
	 * @param sellerId
	 * @param status
	 * @return
	 */
	@RequestMapping("updateSellerStatus")
	@ResponseBody
	public Map<String, Object> updateSellerStatus(String sellerId, String status){
		Map<String, Object> base = new HashMap<>();
		try {
			base = sellerService.updateSellerStatus(sellerId, status);
		} catch (Exception e) {
			e.printStackTrace();
			return ReturnMap.error();
		}
		return base;
	}
	
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
				String companyName, String shopName, String status){
		Map<String, Object> base = new HashMap<>();
		try {
			base = sellerService.queryByPage(page, rows, companyName, shopName, status);
		} catch (Exception e) {
			e.printStackTrace();
			return ReturnMap.error();
		}
		return base;
	}
}

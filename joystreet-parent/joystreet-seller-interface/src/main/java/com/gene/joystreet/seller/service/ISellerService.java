package com.gene.joystreet.seller.service;

import java.util.Map;

import com.gene.joystreet.entity.Seller;

/**
 * 商户相关
 * @author: LJP
 * @date: 2018年12月10日 下午4:51:44
 */
public interface ISellerService {

	/**
	 * 添加商户
	 * @param seller
	 * @return
	 */
	public Map<String, Object> addSeller(Seller seller);

}

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

	/**
	 * 分页查询商家信息
	 * @param page
	 * @param rows
	 * @param companyName
	 * @param shopName
	 * @return
	 */
	public Map<String, Object> queryByPage(Integer page, Integer rows, String companyName, String shopName, String status);

	/**
	 * 更新商家状态
	 * @param sellerId
	 * @param status
	 * @return
	 */
	public Map<String, Object> updateSellerStatus(String sellerId, String status);

	/**
	 * 根据登录名查找用户
	 * @param username
	 * @return
	 */
	public Seller querySeller(String username);

}

package com.gene.joystreet.seller.service.impl;

import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gene.joystreet.dao.SellerMapper;
import com.gene.joystreet.entity.Seller;
import com.gene.joystreet.seller.service.ISellerService;
import com.gene.joystreet.util.ReturnMap;

@Service
@Transactional
public class SellerServiceImpl implements ISellerService{
	
	@Autowired
	private SellerMapper sellerMapper;

	@Override
	public Map<String, Object> addSeller(Seller seller) {
		// 判断ID是否重复
		Seller sel = sellerMapper.selectByPrimaryKey(seller.getSellerId());
		if(sel != null) {
			return ReturnMap.error("该用户名已存在，请重新输入！");
		}
		// 对密码进行加密
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String encode = encoder.encode(seller.getPassword());
		seller.setPassword(encode);
		// 创建时间
		seller.setCreateTime(new Date());
		// 状态
		seller.setStatus("1");
		sellerMapper.insertSelective(seller);
		return ReturnMap.success();
	}
}

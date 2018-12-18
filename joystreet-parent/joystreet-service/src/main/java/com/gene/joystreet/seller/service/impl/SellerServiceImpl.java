package com.gene.joystreet.seller.service.impl;

import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.dubbo.common.utils.StringUtils;
import com.gene.joystreet.dao.SellerMapper;
import com.gene.joystreet.entity.Seller;
import com.gene.joystreet.entity.SellerExample;
import com.gene.joystreet.seller.service.ISellerService;
import com.gene.joystreet.util.PageResult;
import com.gene.joystreet.util.ReturnMap;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

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
		seller.setStatus("0");
		sellerMapper.insertSelective(seller);
		return ReturnMap.success();
	}

	@Override
	public Map<String, Object> queryByPage(Integer page, Integer rows, String companyName, String shopName, String status) {
		// 分页
		PageHelper.startPage(page, rows);
		// 高级查询
		SellerExample sellerExample = new SellerExample();
		// 公司名
		if(!StringUtils.isBlank(companyName)) {
			sellerExample.or().andNameLike("%"+ companyName +"%");
		}
		// 商店名字
		if(!StringUtils.isBlank(shopName)) {
			sellerExample.or().andNickNameLike("%"+ shopName +"%");
		}
		// 状态
		if(!StringUtils.isBlank(status)) {
			sellerExample.or().andStatusEqualTo(status);
		}
		Page<Seller> resPage = (Page<Seller>) sellerMapper.selectByExample(sellerExample);
		// 封装
		PageResult<Seller> sellerPage = new PageResult<>(resPage.getTotal(), resPage.getResult());
		return ReturnMap.success(sellerPage);
	}

	@Override
	public Map<String, Object> updateSellerStatus(String sellerId, String status) {
		// 封装商家实体
		Seller seller = new Seller();
		// id
		seller.setSellerId(sellerId);
		// 状态码
		seller.setStatus(status);
		sellerMapper.updateByPrimaryKeySelective(seller);
		return ReturnMap.success();
	}

	@Override
	public Seller querySeller(String username) {
		Seller seller = sellerMapper.selectByPrimaryKey(username);
		return seller;
	}
}

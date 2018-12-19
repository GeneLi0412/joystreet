package com.gene.joystreet.goods.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gene.joystreet.dao.GoodsMapper;
import com.gene.joystreet.dao.GoodsdescMapper;
import com.gene.joystreet.entity.Product;
import com.gene.joystreet.goods.service.IGoodsService;
import com.gene.joystreet.util.IDUtils;
import com.gene.joystreet.util.ReturnMap;

@Service
@Transactional
public class GoodsServiceImpl implements IGoodsService{
	
	@Autowired
	private GoodsMapper goodsMapper;
	
	@Autowired
	private GoodsdescMapper goodsdescMapper;

	@Override
	public Map<String, Object> addGoods(Product product) {
		// 创建商品ID
		String goodsId = IDUtils.getId();
		product.getGoods().setId(goodsId);
		// 设置状态
		product.getGoods().setAuditStatus("0");
		goodsMapper.insertSelective(product.getGoods());
		// 关联商品、商品详情
		product.getGoodsdesc().setGoodsId(goodsId);
		goodsdescMapper.insertSelective(product.getGoodsdesc());
		return ReturnMap.success();
	}
	
}

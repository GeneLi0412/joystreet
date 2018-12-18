package com.gene.joystreet.itemcat.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.dubbo.common.utils.StringUtils;
import com.gene.joystreet.dao.ItemcatMapper;
import com.gene.joystreet.entity.Itemcat;
import com.gene.joystreet.entity.ItemcatExample;
import com.gene.joystreet.itemcat.service.ItemCatService;
import com.gene.joystreet.util.PageResult;
import com.gene.joystreet.util.ReturnMap;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

@Service
@Transactional
public class ItemCatServiceImpl implements ItemCatService{
	
	@Autowired
	private ItemcatMapper itemcatMapper;

	@Override
	public Map<String, Object> queryByParent(Integer page, Integer rows, String parentId) {
		// 开始分页
		PageHelper.startPage(page, rows);
		// 指定父级
		ItemcatExample itemcatExample = new ItemcatExample();
		if(!StringUtils.isBlank(parentId)) {
			itemcatExample.or().andParentIdEqualTo(parentId);
		}
		// 查询
		Page<Itemcat> pageRes = (Page<Itemcat>) itemcatMapper.selectByExample(itemcatExample);
		// 封装结果
		PageResult<Itemcat> itemCatPage = new PageResult<>(pageRes.getTotal(), pageRes.getResult());
		return ReturnMap.success(itemCatPage);
	}

}

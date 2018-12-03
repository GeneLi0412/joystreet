package com.gene.joystreet.brand.service.impl;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gene.joystreet.brand.service.IBrandService;
import com.gene.joystreet.common.SystemMessageConstant;
import com.gene.joystreet.dao.BrandMapper;
import com.gene.joystreet.entity.Brand;
import com.gene.joystreet.entity.BrandExample;
import com.gene.joystreet.util.IDUtils;
import com.gene.joystreet.util.PageResult;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.StringUtil;

@Service
@Transactional
public class BrandServiceImpl implements IBrandService{

	@Autowired
	private BrandMapper brandMapper;

	@Override
	public PageResult<Brand> queryByPage(int pageNo, int pageSize, String search) {
		// 分页
		PageHelper.startPage(pageNo, pageSize);
		// 条件查询
		BrandExample brandExample = new BrandExample();
		if(StringUtil.isNotEmpty(search)) {
			// 首字符
			brandExample.or().andFirstCharLike("%"+ search +"%");
			// 名字
			brandExample.or().andNameLike("%"+ search +"%");
		}
		Page<Brand> page = (Page<Brand>) brandMapper.selectByExample(brandExample);
		return new PageResult<>(page.getTotal(), page.getResult());
	}

	@Override
	public Map<String, Object> addBrand(Brand brand) {
		Map<String, Object> base = new HashMap<>();
		brand.setId(IDUtils.getId());
		brandMapper.insert(brand);
		base.put("error", false);
		base.put("message", SystemMessageConstant.OPERATION_SUCCESS);
		return base;
	}

	@Override
	public Map<String, Object> findOne(String id) {
		Map<String, Object> base = new HashMap<>();
		Brand brand = brandMapper.selectByPrimaryKey(id);
		base.put("error", false);
		base.put("message", SystemMessageConstant.OPERATION_SUCCESS);
		base.put("data", brand);
		return base;
	}

	@Override
	public Map<String, Object> updateBrand(Brand brand) {
		Map<String, Object> base = new HashMap<>();
		brandMapper.updateByPrimaryKey(brand);
		base.put("error", false);
		base.put("message", SystemMessageConstant.OPERATION_SUCCESS);
		return base;
	}

	@Override
	public Map<String, Object> deleteByIds(String[] ids) {
		Map<String, Object> base = new HashMap<>();
		List<String> idlist = Arrays.asList(ids);
		BrandExample brandExample = new BrandExample();
		brandExample.or().andIdIn(idlist);
		brandMapper.deleteByExample(brandExample);
		base.put("error", false);
		base.put("message", SystemMessageConstant.OPERATION_SUCCESS);
		return base;
	}
}

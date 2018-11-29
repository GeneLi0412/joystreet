package com.gene.joystreet.brand.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gene.joystreet.brand.service.IBrandService;
import com.gene.joystreet.dao.BrandMapper;
import com.gene.joystreet.entity.Brand;

@Service
public class BrandServiceImpl implements IBrandService{

	@Autowired
	private BrandMapper brandMapper;
	
	@Override
	public List<Brand> queryAllBrands() {
		return brandMapper.selectAll();
	}

}

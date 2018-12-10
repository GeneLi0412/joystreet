package com.gene.joystreet.specification.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.codec.digest.Md5Crypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.dubbo.common.utils.StringUtils;
import com.gene.joystreet.common.SystemMessageConstant;
import com.gene.joystreet.dao.SpecificationMapper;
import com.gene.joystreet.dao.SpecificationoptionMapper;
import com.gene.joystreet.entity.Specification;
import com.gene.joystreet.entity.SpecificationExample;
import com.gene.joystreet.entity.Specificationoption;
import com.gene.joystreet.entity.SpecificationoptionExample;
import com.gene.joystreet.specification.service.ISpecificationService;
import com.gene.joystreet.util.IDUtils;
import com.gene.joystreet.util.PageResult;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.StringUtil;

@Service
@Transactional
public class SpecificationServiceImpl implements ISpecificationService{

	@Autowired
	private SpecificationMapper specificationMapper;
	
	@Autowired
	private SpecificationoptionMapper specificationoptionMapper;
	
	@Override
	public Map<String, Object> querySpecificByPage(Integer page, Integer rows, String searchText) {
		Map<String, Object> base = new HashMap<>();
		// 分页
		PageHelper.startPage(page, rows);
		// 高级查询
		SpecificationExample specificationExample = new SpecificationExample();
		if(StringUtil.isNotEmpty(searchText)) {
			specificationExample.or().andSpecNameLike("%"+ searchText +"%");
		}
		// 调用查询
		Page<Specification> pageRes = (Page<Specification>) specificationMapper.selectByExample(specificationExample);
		PageResult<Specification> pageResult = new PageResult<>(pageRes.getTotal(), pageRes.getResult());
		base.put("error", false);
		base.put("message", SystemMessageConstant.OPERATION_SUCCESS);
		base.put("result", pageResult);
		return base;
	}

	@Override
	public Map<String, Object> saveOrModify(String specificId, String specificName,
			String[] optionNames, Integer[] optionOrders) {
		Map<String, Object> base = new HashMap<>();
		// 封装
		Specification specification = new Specification();
		// 名字
		specification.setSpecName(specificName);
		// 新增
		if(StringUtils.isBlank(specificId)) {
			// 添加ID
			specification.setId(IDUtils.getId());
			specificationMapper.insert(specification);
		}else {
			// 更新specific
			specification.setId(specificId);
			specificationMapper.updateByPrimaryKeySelective(specification);
			
			// 删除所有绑定的规格选项
			SpecificationoptionExample example = new SpecificationoptionExample();
			// 设置规格ID
			example.or().andSpecIdEqualTo(specification.getId());
			specificationoptionMapper.deleteByExample(example);
		}
		if(optionNames != null && optionOrders != null) {
			// 绑定规格与规格选项
			for(int i=0;i<optionNames.length;i++) {
				Specificationoption option = new Specificationoption();
				// ID
				option.setId(IDUtils.getId());
				// name
				option.setOptionName(optionNames[i]);
				// oder
				option.setOrders(optionOrders[i]);
				// bond specific
				option.setSpecId(specification.getId());
				specificationoptionMapper.insertSelective(option);
			}
		}
		base.put("error", false);
		base.put("message", SystemMessageConstant.OPERATION_SUCCESS);
		return base;
	}

	@Override
	public Map<String, Object> deleteSpecificByIds(String[] ids) {
		Map<String, Object> base = new HashMap<>();
		// 装换为List
		List<String> idlist = Arrays.asList(ids);
		SpecificationExample specificationExample = new SpecificationExample();
		specificationExample.or().andIdIn(idlist);
		specificationMapper.deleteByExample(specificationExample);
		// 删除绑定的规格选项
		for (String specificId : ids) {
			SpecificationoptionExample optionExample = new SpecificationoptionExample();
			// 设置specific id
			optionExample.or().andSpecIdEqualTo(specificId);
			specificationoptionMapper.deleteByExample(optionExample);
		}
		base.put("error", false);
		base.put("message", SystemMessageConstant.OPERATION_SUCCESS);
		return base;
	}

	@Override
	public Map<String, Object> querySpecificById(String id) {
		Map<String, Object> base = new HashMap<>();
		Specification specification = specificationMapper.selectByPrimaryKey(id);
		// 查询绑定的规格选项
		SpecificationoptionExample optionExample = new SpecificationoptionExample();
		// 设置specific id
		optionExample.or().andSpecIdEqualTo(id);
		// 排序
		optionExample.setOrderByClause("orders asc");
		List<Specificationoption> specificationOptions = specificationoptionMapper.selectByExample(optionExample);
		specification.setSpecificationOptions(specificationOptions);
		base.put("error", false);
		base.put("message", SystemMessageConstant.OPERATION_SUCCESS);
		base.put("data", specification);
		return base;
	}

	@Override
	public Map<String, Object> queryAll() {
		Map<String, Object> base = new HashMap<>();
		// 前端需求进行封装
		List<Specification> specifications = specificationMapper.selectByExample(new SpecificationExample());
		// 封装为LIST
		List<Map<String, Object>> rows = new ArrayList<>();
		for (Specification spec : specifications) {
			Map<String, Object> map = new HashMap<>();
			// ID
			map.put("id", spec.getId());
			// NAME
			map.put("text", spec.getSpecName());
			rows.add(map);
		}
		base.put("error", false);
		base.put("message", SystemMessageConstant.OPERATION_SUCCESS);
		base.put("data", rows);
		return base;
	}
	
}

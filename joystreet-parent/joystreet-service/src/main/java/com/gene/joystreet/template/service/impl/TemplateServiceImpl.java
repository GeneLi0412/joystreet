package com.gene.joystreet.template.service.impl;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.dubbo.common.utils.StringUtils;
import com.gene.joystreet.common.SystemMessageConstant;
import com.gene.joystreet.dao.TypetemplateMapper;
import com.gene.joystreet.entity.Typetemplate;
import com.gene.joystreet.entity.TypetemplateExample;
import com.gene.joystreet.template.service.ITemplateService;
import com.gene.joystreet.util.IDUtils;
import com.gene.joystreet.util.PageResult;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.StringUtil;

@Service
@Transactional
public class TemplateServiceImpl implements ITemplateService{
	
	@Autowired
	private TypetemplateMapper typetemplateMapper;

	@Override
	public Map<String, Object> queryTemplatesByPage(Integer page, Integer rows, String searchstr) {
		Map<String, Object> base = new HashMap<>();
		// 分页
		PageHelper.startPage(page, rows);
		// 高级查询
		TypetemplateExample example = new TypetemplateExample();
		if(StringUtil.isNotEmpty(searchstr)) {
			// 商品名
			example.or().andNameLike("%"+ searchstr +"%");
			// 规格
			example.or().andSpecIdsLike("%"+ searchstr +"%");
			// 品牌
			example.or().andBrandIdsLike("%"+ searchstr +"%");
		}
		// 调用查询
		Page<Typetemplate> pageRes = (Page<Typetemplate>) typetemplateMapper.selectByExample(example);
		PageResult<Typetemplate> presult = new PageResult<>(pageRes.getTotal(), pageRes.getResult());
		base.put("error", false);
		base.put("message", SystemMessageConstant.OPERATION_SUCCESS);
		base.put("data", presult);
		return base;
	}

	@Override
	public Map<String, Object> saveOrModify(Typetemplate typetemplate) {
		Map<String, Object> base = new HashMap<>();
		// 新增
		if(StringUtils.isBlank(typetemplate.getId())) {
			// 配置ID
			typetemplate.setId(IDUtils.getId());
			typetemplateMapper.insertSelective(typetemplate);
		}else {
			typetemplateMapper.updateByPrimaryKeySelective(typetemplate);
		}
		base.put("error", false);
		base.put("message", SystemMessageConstant.OPERATION_SUCCESS);
		return base;
	}

	@Override
	public Map<String, Object> deleteByIds(String[] ids) {
		Map<String, Object> base = new HashMap<>();
		// 装换为List
		List<String> idlist = Arrays.asList(ids);
		TypetemplateExample example = new TypetemplateExample();
		example.or().andIdIn(idlist);
		typetemplateMapper.deleteByExample(example);
		base.put("error", false);
		base.put("message", SystemMessageConstant.OPERATION_SUCCESS);
		return base;
	}
	
}

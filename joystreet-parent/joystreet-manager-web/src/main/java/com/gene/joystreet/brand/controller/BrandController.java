package com.gene.joystreet.brand.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gene.joystreet.brand.service.IBrandService;
import com.gene.joystreet.common.SystemMessageConstant;
import com.gene.joystreet.entity.Brand;
import com.gene.joystreet.util.PageResult;

/**
 * 品牌相关
 * @author: LJP
 * @date: 2018年11月30日 下午3:59:14
 */
@Controller
@RequestMapping("brand")
public class BrandController {

	@Autowired
	private IBrandService brandService;
	
	@RequestMapping("queryAllBrands")
	@ResponseBody
	public List<Brand> queryAllBands(){
		return brandService.queryAllBrands();
 	}
	
	/**
	 * 分页查询品牌列表
	 * @param page
	 * @param rows
	 * @return
	 */
	@RequestMapping("queryByPage")
	@ResponseBody
	public PageResult<Brand> queryByPage(@RequestParam(defaultValue="0") int page, @RequestParam(defaultValue="5") int rows){
		return brandService.queryByPage(page, rows);
	}
	
	/**
	 * 添加品牌
	 * @param brand
	 * @return
	 */
	@RequestMapping("saveBrand")
	@ResponseBody
	public Map<String, Object> addBrand(@RequestBody Brand brand){
		Map<String, Object> base = new HashMap<>();
		try {
			base = brandService.addBrand(brand);
		} catch (Exception e) {
			base.put("error", true);
			base.put("message", SystemMessageConstant.OPERATION_FAIL);
		}
		return base;
	}
	
	/**
	 * 根据ID查找品牌记录
	 * @param id
	 * @return
	 */
	@RequestMapping("findOne")
	@ResponseBody
	public Map<String, Object> findOne(String id){
		Map<String, Object> base = new HashMap<>();
		try {
			base = brandService.findOne(id);
		} catch (Exception e) {
			base.put("error", true);
			base.put("message", SystemMessageConstant.OPERATION_FAIL);
		}
		return base;
	}
	
	/**
	 * 更新
	 * @param brand
	 * @return
	 */
	@RequestMapping("updateBrand")
	@ResponseBody
	public Map<String, Object> updateBrand(@RequestBody Brand brand){
		Map<String, Object> base = new HashMap<>();
		try {
			base = brandService.updateBrand(brand);
		} catch (Exception e) {
			base.put("error", true);
			base.put("message", SystemMessageConstant.OPERATION_FAIL);
		}
		return base;
	}
	
	/**
	 * 批量删除
	 * @param ids
	 * @return
	 */
	@RequestMapping("deleteByIds")
	@ResponseBody
	public Map<String, Object> deleteByIds(String[] ids){
		Map<String, Object> base = new HashMap<>();
		try {
			base = brandService.deleteByIds(ids);
		} catch (Exception e) {
			base.put("error", true);
			base.put("message", SystemMessageConstant.OPERATION_FAIL);
		}
		return base;
	}
}

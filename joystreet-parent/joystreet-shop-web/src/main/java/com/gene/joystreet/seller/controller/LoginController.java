package com.gene.joystreet.seller.controller;

import java.util.Map;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gene.joystreet.util.ReturnMap;

/**
 * 登录信息相关
 * @author: LJP
 * @date: 2018年12月10日 下午2:35:59
 */
@Controller
@RequestMapping("login")
public class LoginController {

	@RequestMapping("name")
	@ResponseBody
	public Map<String, Object> queryUserName(){
		String name = SecurityContextHolder.getContext().getAuthentication().getName();
		return ReturnMap.success(name);
	}
}

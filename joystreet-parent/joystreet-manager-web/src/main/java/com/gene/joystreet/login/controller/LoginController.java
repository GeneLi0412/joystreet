package com.gene.joystreet.login.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gene.joystreet.common.SystemMessageConstant;

/**
 * 登录相关
 * @author: LJP
 * @date: 2018年12月7日 上午11:16:35
 */
@Controller
@RequestMapping("login")
public class LoginController {

	/**
	 * 查询登录名
	 * @return
	 */
	@RequestMapping("userName")
	@ResponseBody
	public Map<String, Object> queryLoginName(){
		Map<String, Object> base = new HashMap<>();
		String name = SecurityContextHolder.getContext().getAuthentication().getName();
		base.put("data", name);
		base.put("error", false);
		base.put("message", SystemMessageConstant.OPERATION_SUCCESS);
		return base;
	}
}

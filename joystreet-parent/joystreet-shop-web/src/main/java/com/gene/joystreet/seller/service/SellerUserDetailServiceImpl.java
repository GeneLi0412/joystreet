package com.gene.joystreet.seller.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.gene.joystreet.entity.Seller;

public class SellerUserDetailServiceImpl implements UserDetailsService{
	
	// 引入sellerService
	private ISellerService sellerService;

	public void setSellerService(ISellerService sellerService) {
		this.sellerService = sellerService;
	}


	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// 权限列表
		List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
		grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_USER"));

		// 查询Seller
		Seller seller = sellerService.querySeller(username);
		if(seller!=null && seller.getStatus().equals("1")) {
			return new User(username, seller.getPassword(), grantedAuthorities);
		}
		return null;
	}

}

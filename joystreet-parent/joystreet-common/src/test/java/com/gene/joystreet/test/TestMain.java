package com.gene.joystreet.test;

import com.gene.joystreet.util.IDUtils;

public class TestMain {
	public static void main(String[] args) {
		for(int i=0;i<1000;i++) {
			System.out.println(IDUtils.getId());
		}
	}
}

package com.gene.joystreet.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 根据时间戳生成唯一ID
 * @author: LJP
 * @date: 2018年12月2日 上午12:42:04
 */
public class IDUtils {
	// 线程同步
	private static byte[] lock = new byte[0];
	
	public static String getId() {
		String randNo;
		synchronized (lock) {
			// 生成随机数
			randNo = String.valueOf((Math.random()*9+1)*1000000).substring(0, 6);
		}
		// 获得当前日期
		Date now = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
		// 获取时间戳
		String timeStamp = String.valueOf(System.currentTimeMillis());
		String shortStamp = timeStamp.substring(timeStamp.length()-4);
		return  dateFormat.format(now)+shortStamp+randNo;
	}
}

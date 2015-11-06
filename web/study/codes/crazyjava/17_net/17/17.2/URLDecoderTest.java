package com.poshidi;

import java.net.URLDecoder;
import java.net.URLEncoder;

public class URLDecoderTest {
	public static void main(String[] args) throws Exception{
		//将application/x-www-form-urlencoded字符串
		//转换成普通字符串
		//其中的字符串直接从图17.3所示的窗口中复制过来
		String keyWord = URLDecoder.decode("%B7%E8%BF%F1java", "GBK");
//		String keyWord = URLDecoder.decode("%B7%E8%BF%F1java", "GBK");
		System.out.println(keyWord);
		//将普通字符串转换成
		//application/x-www-form-urlencoded字符串
		String urlStr = URLEncoder.encode("疯狂Android讲义", "GBK");
//		String urlStr = URLEncoder.encode("疯狂Android讲义", "utf8");
		System.out.println(urlStr);
	}	
}

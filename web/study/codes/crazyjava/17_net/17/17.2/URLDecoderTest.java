package com.poshidi;

import java.net.URLDecoder;
import java.net.URLEncoder;

public class URLDecoderTest {
	public static void main(String[] args) throws Exception{
		//��application/x-www-form-urlencoded�ַ���
		//ת������ͨ�ַ���
		//���е��ַ���ֱ�Ӵ�ͼ17.3��ʾ�Ĵ����и��ƹ���
		String keyWord = URLDecoder.decode("%B7%E8%BF%F1java", "GBK");
//		String keyWord = URLDecoder.decode("%B7%E8%BF%F1java", "GBK");
		System.out.println(keyWord);
		//����ͨ�ַ���ת����
		//application/x-www-form-urlencoded�ַ���
		String urlStr = URLEncoder.encode("���Android����", "GBK");
//		String urlStr = URLEncoder.encode("���Android����", "utf8");
		System.out.println(urlStr);
	}	
}

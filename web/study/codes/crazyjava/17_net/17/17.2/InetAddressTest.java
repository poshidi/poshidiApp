package com.poshidi;

import java.net.InetAddress;

public class InetAddressTest {
	public static void main(String[] args) throws Exception{
		//根据主机名字来获取对应的InetAddress实例
		InetAddress ip = InetAddress.getByName("www.crazyit.org");
		//判断是否可达
		System.out.println("crazyit是否可达：" + ip.isReachable(20000));
		//获取该InetAddress实例的IP字符串
		System.out.println(ip.getHostAddress());
		//根据原始IP地址来获取对应的InetAddress实例
		InetAddress local = InetAddress.getByAddress(new byte[]{127,0,0,1});
		//获取该InetAddress实例对应的全限定域名
		System.out.println(local.getCanonicalHostName());
	}
}

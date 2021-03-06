package com.poshidi;

import java.io.IOException;
import java.io.PrintStream;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class ProxyTest {
	//下面是代理服务器的地址和端口，换成实际有效的代理服务器的地址和端口
	final String PROXY_ADDR = "129.82.12.188";
	final int PROXY_PORT = 3124;
	//定义需要访问的网站地址
	String urlStr = "http://www.crazyit.org";
	public void init() throws IOException , MalformedURLException{
		URL url = new URL(urlStr);
		//创建一个代理服务器对象
		Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(PROXY_ADDR, PROXY_PORT));
		URLConnection conn = url.openConnection(proxy);
		//设置超时时长
		conn.setConnectTimeout(3000);
		try(
				//通过代理服务器读取数据的Scanner
				Scanner scan = new Scanner(conn.getInputStream());
				PrintStream ps = new PrintStream("index.htm"))
				{
					while(scan.hasNextLine()){
						String line = scan.nextLine();
						//在控制台输出网页资源内容
						System.out.println(line);
						//将网页资源内容输出到指定输出流
						ps.println(line);
					}
				}
	}
	public static void main(String[] args) throws IOException , MalformedURLException{
		new ProxyTest().init();
	}
}

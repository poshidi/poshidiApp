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
	//�����Ǵ���������ĵ�ַ�Ͷ˿ڣ�����ʵ����Ч�Ĵ���������ĵ�ַ�Ͷ˿�
	final String PROXY_ADDR = "129.82.12.188";
	final int PROXY_PORT = 3124;
	//������Ҫ���ʵ���վ��ַ
	String urlStr = "http://www.crazyit.org";
	public void init() throws IOException , MalformedURLException{
		URL url = new URL(urlStr);
		//����һ���������������
		Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(PROXY_ADDR, PROXY_PORT));
		URLConnection conn = url.openConnection(proxy);
		//���ó�ʱʱ��
		conn.setConnectTimeout(3000);
		try(
				//ͨ�������������ȡ���ݵ�Scanner
				Scanner scan = new Scanner(conn.getInputStream());
				PrintStream ps = new PrintStream("index.htm"))
				{
					while(scan.hasNextLine()){
						String line = scan.nextLine();
						//�ڿ���̨�����ҳ��Դ����
						System.out.println(line);
						//����ҳ��Դ���������ָ�������
						ps.println(line);
					}
				}
	}
	public static void main(String[] args) throws IOException , MalformedURLException{
		new ProxyTest().init();
	}
}

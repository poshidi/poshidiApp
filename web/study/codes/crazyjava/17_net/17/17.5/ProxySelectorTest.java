package com.poshidi;

import java.io.IOException;
import java.io.PrintStream;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.SocketAddress;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProxySelectorTest {
	//�����Ǵ���������ĵ�ַ�Ͷ˿�
	//���һ������������ĵ�ַ�Ͷ˿�
	final String PROXY_ADDR = "139.82.12.188";
	final int PROXY_PORT = 3124;
	//������Ҫ���ʵ���վ��ַ
	String urlStr = "http://www.crzyit.org";
	public void init() throws IOException , MalformedURLException{
		//ע��Ĭ�ϵĴ���ѡ����
		ProxySelector.setDefault(new ProxySelector(){

			//����"ҵ����Ҫ"�����ض��Ķ�Ӧ�Ĵ��������
			@Override
			public List<Proxy> select(URI uri) {
				// TODO Auto-generated method stub
				List<Proxy> result = new ArrayList<>();
				result.add(new Proxy(Proxy.Type.HTTP, new InetSocketAddress(PROXY_ADDR, PROXY_PORT)));
				return null;
			}

			@Override
			public void connectFailed(URI uri, SocketAddress sa, IOException ioe) {
				// TODO Auto-generated method stub
				System.out.println("�޷����ӵ�ָ�����������!");
			}
		});
		URL url = new URL(urlStr);
		//û��ָ�������������ֱ�Ӵ�����
		URLConnection conn = url.openConnection();
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
	public static void main(String[] args) throws IOException, MalformedURLException{
		new ProxySelectorTest().init();
	}
}

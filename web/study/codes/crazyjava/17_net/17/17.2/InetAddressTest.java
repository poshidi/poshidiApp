package com.poshidi;

import java.net.InetAddress;

public class InetAddressTest {
	public static void main(String[] args) throws Exception{
		//����������������ȡ��Ӧ��InetAddressʵ��
		InetAddress ip = InetAddress.getByName("www.crazyit.org");
		//�ж��Ƿ�ɴ�
		System.out.println("crazyit�Ƿ�ɴ" + ip.isReachable(20000));
		//��ȡ��InetAddressʵ����IP�ַ���
		System.out.println(ip.getHostAddress());
		//����ԭʼIP��ַ����ȡ��Ӧ��InetAddressʵ��
		InetAddress local = InetAddress.getByAddress(new byte[]{127,0,0,1});
		//��ȡ��InetAddressʵ����Ӧ��ȫ�޶�����
		System.out.println(local.getCanonicalHostName());
	}
}

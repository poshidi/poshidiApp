//package com.poshidi;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.charset.Charset;

public class SimpleAIOClient {
	static final int PORT =30000;
	public static void main(String[] args) throws Exception{
		//���ڶ�ȡ���ݵ�ByteBuffer
		ByteBuffer buff = ByteBuffer.allocate(1024);
		Charset utf = Charset.forName("utf-8");
		try(
			//����AsynchronousSocketChannel����
			AsynchronousSocketChannel clientChannel = AsynchronousSocketChannel.open())
			{
				//����Զ�̷�����
				clientChannel.connect(new InetSocketAddress("127.0.0.1", PORT)).get();
				buff.clear();
				//��clientChannel�ж�ȡ����
				clientChannel.read(buff).get();
				buff.flip();
				//��buff�е�����ת��Ϊ�ַ���
				String content = utf.decode(buff).toString();
				System.out.println("��������Ϣ:" + content);
			}
	}
}

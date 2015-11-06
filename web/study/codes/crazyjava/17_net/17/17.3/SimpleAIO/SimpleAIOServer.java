//package com.poshidi;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.util.concurrent.Future;

public class SimpleAIOServer {
	static final int PORT = 30000;
	public static void main(String[] args) throws Exception{
		try(
			//����AsynchronousServerSocketChannel����
			AsynchronousServerSocketChannel serverChannel = AsynchronousServerSocketChannel.open())
		{
			//ָ����ָ����ַ���˿ڼ���
			serverChannel.bind(new InetSocketAddress(PORT));
			while(true){
				//����ѭ���������Կͻ��˵�����
				Future<AsynchronousSocketChannel> future = serverChannel.accept();
				//��ȡ������ɺ󷵻ص�AsynchronousSocketChannel
				AsynchronousSocketChannel socketChannel = future.get();
				//ִ�����
				socketChannel.write(ByteBuffer.wrap("��ӭ������AIO�����磡".getBytes("UTF-8"))).get();
			}
		}
	}
}

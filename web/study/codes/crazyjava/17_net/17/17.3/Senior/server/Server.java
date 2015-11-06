package com.poshidi;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	private static final int SERVER_PORT = 30000;
	//ʹ��CrazyitMap����������ÿ���ͻ����ֺͶ�Ӧ�����֮��Ķ�Ӧ��ϵ
	public static CrazyitMap<String, PrintStream> clients = new CrazyitMap<>();
	public void init(){
		try(
			//����������ServerSocket
			ServerSocket ss = new ServerSocket(SERVER_PORT))
		{
			//������ѭ�������ϵؽ������Կͻ��˵�����
			while(true){
				Socket socket = ss.accept();
				new ServerThread(socket).start();
			}
		}
		//����׳��쳣
		catch(IOException ex){
			System.out.println("����������ʧ�ܣ��Ƿ�˿�" + SERVER_PORT + "�ѱ�ռ��?");
		}
	}
	public static void main(String[] args){
		Server server = new Server();
		server.init();
	}
}

package com.poshidi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

//������ÿ���߳�ͨ�ŵ��߳���
public class ServerThread implements Runnable{
	//���嵱ǰ�߳��������Socket
	Socket s = null;
	//���߳��������Socket��Ӧ��������
	BufferedReader br = null;
	public ServerThread(Socket s) throws IOException{
		this.s = s;
		//��ʼ����Socket��Ӧ��������
		br = new BufferedReader(new InputStreamReader(s.getInputStream()));
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try{
			String content = null;
			//����ѭ�����ϵش�Socket�ж�ȡ�ͻ��˷��͹���������
			while((content = readFromClient()) != null){
				//����socketList�е�ÿ��Socket
				//��������������ÿ��Socket
				for(Socket s : MyServer.socketList){
					PrintStream ps = new PrintStream(s.getOutputStream());
					ps.println(content);
				}
			}
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	//�����ȡ�ͻ������ݵķ���
	private String readFromClient(){
		try{
			return br.readLine();
		}
		//��������쳣���������Socket��Ӧ�Ŀͻ����Ѿ��ر�
		catch(IOException e){
			//ɾ����Socket
			MyServer.socketList.remove(s);
		}
		return null;
	}
}

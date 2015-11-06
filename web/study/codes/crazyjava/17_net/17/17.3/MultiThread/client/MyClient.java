package com.poshidi;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class MyClient {
	public static void main(String[] args) throws Exception{
		Socket s = new Socket("127.0.0.1", 30000);
		//�ͻ�������ClientThread�̲߳��ϵض�ȡ���Է�����������
		new Thread(new ClientThread(s)).start();
		//��ȡ��Socket��Ӧ�������
		PrintStream ps = new PrintStream(s.getOutputStream());
		String line = null;
		//���ϵض�ȡ��������
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while((line = br.readLine()) != null){
			//���û��ļ�����������д��Socket��Ӧ�������
			ps.println(line);
		}
	}
}

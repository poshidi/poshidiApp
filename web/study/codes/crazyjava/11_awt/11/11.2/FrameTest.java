package com.poshidi;

import java.awt.Frame;

public class FrameTest {
	public static void main(String[] args){
		Frame f = new Frame("���Դ���");
		//���ô��ڵĴ�С��λ��
		f.setBounds(300, 30, 250, 200);
		//��������ʾ����(Frame����Ĭ�ϴ�������״̬)
		f.setVisible(true);
	}
}

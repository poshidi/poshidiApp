package com.poshidi;

import java.awt.Frame;

public class FrameTest {
	public static void main(String[] args){
		Frame f = new Frame("测试窗口");
		//设置窗口的大小、位置
		f.setBounds(300, 30, 250, 200);
		//讲窗口显示出来(Frame对象默认处于隐藏状态)
		f.setVisible(true);
	}
}

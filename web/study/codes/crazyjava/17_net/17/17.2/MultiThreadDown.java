package com.poshidi;

public class MultiThreadDown {
	public static void main(String[] args) throws Exception{
		//初始化DownUtil对象
		final DownUtil downUtil = new DownUtil("http://www.crazyit.org/"
				+ "attachment.php?aid=MTY0NXxjNjBiYzNjN3wxMzE1NTQ2MjU5fGNhO"
				+ "DlKVmpXVmhpNGlkWmVzR2JZbnluZWpqSllOd3JzckdodXJOMUpOWWt0aTJz,"
				, "oracelsql.rar", 4);
//		final DownUtil downUtil = new DownUtil("http://192.168.78.21:8080/LuceneSearchTest/"
//				, "springsecurity.rar", 4);
		downUtil.download();
		new Thread(){
			public void run(){
				while(downUtil.getCompleteRate() < 1){
					// 每隔0.1秒查询一次任务的完成进度，
					// GUI程序中可根据该进度来绘制进度条
					System.out.println("已完成："
							+ downUtil.getCompleteRate());
					try{
						Thread.sleep(1000);
					}catch(Exception ex){}
				}
			}
		}.start();
	}
}

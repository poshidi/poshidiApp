package com.poshidi;

public class MultiThreadDown {
	public static void main(String[] args) throws Exception{
		//��ʼ��DownUtil����
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
					// ÿ��0.1���ѯһ���������ɽ��ȣ�
					// GUI�����пɸ��ݸý��������ƽ�����
					System.out.println("����ɣ�"
							+ downUtil.getCompleteRate());
					try{
						Thread.sleep(1000);
					}catch(Exception ex){}
				}
			}
		}.start();
	}
}

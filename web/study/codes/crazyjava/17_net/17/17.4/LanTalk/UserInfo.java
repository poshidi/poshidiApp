package com.poshidi;

import java.net.SocketAddress;

public class UserInfo {
	//���û���ͼ��
	private String icon;
	//���û�������
	private String name;
	//���û���MulticastSocket���ڵ�IP��ַ�Ͷ˿�
	private SocketAddress address;
	//���û�ʧȥ��ϵ�Ĵ���
	private int lost;
	//���û���Ӧ�Ľ�������
	private ChatFrame chatFrame;
	public UserInfo(){}
	//�в����Ĺ�����
	public UserInfo(String icon, String name, SocketAddress address, int lost){
		this.setIcon(icon);
		this.setName(name);
		this.setAddress(address);
		this.setLost(lost);
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public SocketAddress getAddress() {
		return address;
	}
	public void setAddress(SocketAddress address) {
		this.address = address;
	}
	public int getLost() {
		return lost;
	}
	public void setLost(int lost) {
		this.lost = lost;
	}
	public ChatFrame getChatFrame() {
		return chatFrame;
	}
	public void setChatFrame(ChatFrame chatFrame) {
		this.chatFrame = chatFrame;
	}
	//��дhashCode()��equals()����
	public int hashCode(){
		return address.hashCode();
	}
	public boolean equals(Object obj){
		if(obj != null && obj.getClass() == UserInfo.class){
			UserInfo target = (UserInfo) obj;
			if(address != null){
				return address.equals(target.getAddress());
			}
		}
		return false;
	}
}

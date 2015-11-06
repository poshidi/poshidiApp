package com.poshidi;

import java.net.SocketAddress;

public class UserInfo {
	//该用户的图标
	private String icon;
	//该用户的名字
	private String name;
	//该用户的MulticastSocket所在的IP地址和端口
	private SocketAddress address;
	//该用户失去联系的次数
	private int lost;
	//该用户对应的叫他窗口
	private ChatFrame chatFrame;
	public UserInfo(){}
	//有参数的构造器
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
	//重写hashCode()和equals()方法
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

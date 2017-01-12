package com.studio.gzs.mm.qq;

public class QQGroupInfo {
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	public String getmemberCount() {
		return memberCount;
	}
	public void setmemberCount(String count) {
		this.memberCount = count;
	}
	public String getmCount() {
		return mCount;
	}
	public void setmCount(String mCount) {
		this.mCount = mCount;
	}
	private String groupName="";//QQ分组名称
	private String memberCount="0";//成员个数
	private String mCount="0";//开通微信好友个数
}

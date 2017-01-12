package com.studio.gzs.mm.ui.friend;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.studio.gzs.mm.qq.QQFriendInfo;
import com.studio.gzs.mm.R;

public class InviteQQAdapter extends BaseAdapter {
	private ArrayList<QQFriendInfo> group=null;
	private Context context;
	private LayoutInflater inflater;
	
	public InviteQQAdapter(Activity a,ArrayList<QQFriendInfo> qqFriends){
		this.context=a;
		inflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		if(qqFriends==null){
			group=new ArrayList<QQFriendInfo>();
		}else{
			this.group=qqFriends;
		}
	}
	@Override
	public int getCount() {
		return group.size();
	}

	@Override
	public Object getItem(int position) {
		return group.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder=null;
		if(convertView==null){
			holder=new ViewHolder();
			convertView=inflater.inflate(R.layout.inviteqqfriends_item, null);
			holder.nickname_tv=(TextView)convertView.findViewById(R.id.qq_friend_group_name);
			convertView.setTag(holder);
		}else{
			holder = (ViewHolder) convertView.getTag();
		}
		holder.nickname_tv.setText(group.get(position).qqName);
		
		return convertView;
	}
	private  class ViewHolder {
		public TextView nickname_tv;//Í·Ïñ
	}
}

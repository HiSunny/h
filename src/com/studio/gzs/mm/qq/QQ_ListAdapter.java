package com.studio.gzs.mm.qq;

import java.util.ArrayList;
import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.studio.gzs.mm.R;

public class QQ_ListAdapter extends BaseAdapter {
	private Context context;
	private ArrayList<QQFriendInfo> friends=null;
	private LayoutInflater inflater = null;
	private ViewHolder holder=null;
	
	public QQ_ListAdapter(Activity a,ArrayList<QQFriendInfo> qqFriends){
		context=a;
		inflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		if(qqFriends!=null){
			friends=qqFriends;
		}else{
			friends=new ArrayList<QQFriendInfo>();
		}
	}

	@Override
	public int getCount() {
		return friends.size();
	}

	@Override
	public Object getItem(int position) {
		return friends.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		holder=null;
		if(convertView==null){
			holder=new ViewHolder();
			convertView=inflater.inflate(R.layout.qq_friend_item, null);
			holder.qq_friend_name=(TextView)convertView.findViewById(R.id.qq_friend_name);
			holder.qq_friend_num=(TextView)convertView.findViewById(R.id.qq_friend_name_qqnum);
			holder.qq_friend_add_state=(TextView)convertView.findViewById(R.id.qq_friend_add_state);
			holder.qq_friend_reg_state=(ImageView)convertView.findViewById(R.id.qq_friend_reg_state);
			convertView.setTag(holder);
		}else{
			holder = (ViewHolder) convertView.getTag();
		}
		holder.qq_friend_name.setText(friends.get(position).qqName);
		holder.qq_friend_num.setText(friends.get(position).qqNum);
		
		//是否注册微信
		if(!friends.get(position).isRegMmUser){
			holder.qq_friend_reg_state.setVisibility(View.GONE);
		}
		//是否添加成微信好友
		if(!friends.get(position).isRegMmUser||!friends.get(position).isAddMmFriend){
			holder.qq_friend_add_state.setVisibility(View.GONE);
		}
		
		return convertView;
	}
	
	//私有内部类
	private  class ViewHolder {
		public ImageView qqAvatar;//头像
		public TextView qq_friend_name;//QQ昵称
		public TextView qq_friend_num;//QQ号
		public TextView qq_friend_add_state;//是否已添加成微信好友
		public ImageView qq_friend_reg_state;//是否已注册微信
	}
}

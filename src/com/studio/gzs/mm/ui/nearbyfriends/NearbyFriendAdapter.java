package com.studio.gzs.mm.ui.nearbyfriends;

import java.util.ArrayList;

import com.studio.gzs.mm.R;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class NearbyFriendAdapter extends BaseAdapter {
	private Context context;
	private ArrayList<NearbyFriend> friends=null;
	private LayoutInflater inflater;
	public NearbyFriendAdapter(Activity a,ArrayList<NearbyFriend> nearByFriends){
		this.context=a;
		if(nearByFriends==null){
			friends=new ArrayList<NearbyFriend>();			
		}else{
			friends=nearByFriends;
		}
		this.inflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);	
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
		ViewHolder holder=null;
		if(convertView==null){
			convertView=inflater.inflate(R.layout.nearby_friend_item, null);
			holder=new ViewHolder();
			holder.avatar_iv=(ImageView)convertView.findViewById(R.id.nearby_friend_avatar_iv);
			holder.friend_name=(TextView)convertView.findViewById(R.id.nearby_friend_name);
			holder.friend_sex=(ImageView)convertView.findViewById(R.id.nearby_friend_sex);
			holder.is_friend=(TextView)convertView.findViewById(R.id.nearby_friend_is_friend);
			holder.friend_distance=(TextView)convertView.findViewById(R.id.nearby_friend_distance);
			holder.friend_sign=(TextView)convertView.findViewById(R.id.nearby_friend_sign);
			convertView.setTag(holder);
		}else{
			holder=(ViewHolder) convertView.getTag();
		}
		holder.friend_name.setText(friends.get(position).friend_name);
		holder.friend_distance.setText(friends.get(position).distance);
		holder.friend_sign.setText(friends.get(position).friend_sign);
		if(!friends.get(position).isFriend){
			holder.is_friend.setVisibility(View.INVISIBLE);
		}		
		if(friends.get(position).isMan){
			holder.friend_sex.setVisibility(View.VISIBLE);
			holder.friend_sex.setImageResource(R.drawable.ic_sex_male);
		}else{
			holder.friend_sex.setVisibility(View.VISIBLE);
			holder.friend_sex.setImageResource(R.drawable.ic_sex_female);
		}
		return convertView;
	
	}
	private class ViewHolder{
		ImageView avatar_iv;
		TextView friend_name;
		TextView is_friend;
		ImageView friend_sex;
		TextView friend_distance;
		TextView friend_sign;
	}

}

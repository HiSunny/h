package com.studio.gzs.mm.ui.friend;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.studio.gzs.mm.qq.QQGroupInfo;
import com.studio.gzs.mm.R;

public class InviteQQGroupAdapter extends BaseAdapter {
	private ArrayList<QQGroupInfo> group=null;
	private Context context;
	private LayoutInflater inflater;

	
	public InviteQQGroupAdapter(Activity a,ArrayList<QQGroupInfo> qqGroup){
		this.context=a;
		inflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		if(qqGroup==null){
			group=new ArrayList<QQGroupInfo>();
		}else{
			this.group=qqGroup;
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
			convertView=inflater.inflate(R.layout.inviteqqfriendsgroup_item, null);
			holder.group_name=(TextView)convertView.findViewById(R.id.qq_friend_group_name);
			convertView.setTag(holder);
		}else{
			holder = (ViewHolder) convertView.getTag();
		}
		holder.group_name.setText(group.get(position).getGroupName());
		return convertView;
	}
	private  class ViewHolder {
		public TextView group_name;//Í·Ïñ
	}
	
}

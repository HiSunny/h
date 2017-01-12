package com.studio.gzs.mm.ui;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.studio.gzs.mm.R;

public class ChattingAdapter extends BaseAdapter {

	private ArrayList<ContactPersion> lastContacts=null;
	private LayoutInflater inflater=null;
	private Context context;
	private ViewHolder holder=null;
	
	
	public ChattingAdapter(Activity a,ArrayList<ContactPersion> contacts){
		this.context=a;
		inflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		
		if(contacts==null){
			lastContacts=new ArrayList<ContactPersion>();
		}else{
			lastContacts=contacts;
		}
	}

	@Override
	public int getCount() {
		return lastContacts.size();
	}

	@Override
	public Object getItem(int position) {
		return lastContacts.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		if(convertView==null){
			convertView=inflater.inflate(R.layout.conversation_item, null);
			holder=new ViewHolder();
	//		holder.avatar_iv=(ImageView) convertView.findViewById(R.id.avatar_iv);
			holder.nickname_tv=(TextView)convertView.findViewById(R.id.nickname_tv);
			holder.update_time_tv=(TextView)convertView.findViewById(R.id.update_time_tv);
			holder.last_msg_tv=(TextView)convertView.findViewById(R.id.last_msg_tv);
			convertView.setTag(holder);
		}else{
			holder=(ViewHolder) convertView.getTag();
		}
		holder.nickname_tv.setText(lastContacts.get(position).nickname);
		holder.update_time_tv.setText(lastContacts.get(position).update_time);
		holder.last_msg_tv.setText(lastContacts.get(position).last_msg);
		return convertView;
	}
	private  class ViewHolder{
	//	ImageView avatar_iv; //头像
	//	TextView tipcnt_tv;//未读信息个数
		TextView nickname_tv;//昵称
		TextView update_time_tv;//最后更新时间
		TextView last_msg_tv;//最后信息
	}

}

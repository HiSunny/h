package com.studio.gzs.mm.ui;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.studio.gzs.mm.R;

public class CantactAdapter extends BaseAdapter {
	
	private ArrayList<ContactPersion> contacts=null;
	private LayoutInflater inflater=null;
	private Context context;
	private ViewHolder holder=null;
	
	public CantactAdapter(Activity a,ArrayList<ContactPersion> contactPersions){
		this.context=a;
		this.inflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);	
		if(contactPersions==null){
			this.contacts=new ArrayList<ContactPersion>();
		}else{
			this.contacts=contactPersions;
		}		
	}	
	@Override
	public int getCount() {
		return contacts.size();
	}

	@Override
	public Object getItem(int position) {
		return contacts.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

		if(convertView==null){
			convertView=inflater.inflate(R.layout.contact_item, null);
			holder=new ViewHolder();
			holder.contactitem_catalog=(TextView) convertView.findViewById(R.id.contactitem_catalog);
			holder.contactitem_avatar_iv=(ImageView)convertView.findViewById(R.id.contactitem_avatar_iv);
			holder.contactitem_nick=(TextView)convertView.findViewById(R.id.contactitem_nick);
			holder.contactitem_icon=(ImageView)convertView.findViewById(R.id.contactitem_icon);
			holder.contactitem_account=(TextView)convertView.findViewById(R.id.contactitem_account);
			holder.contactitem_signature=(TextView)convertView.findViewById(R.id.contactitem_signature);
			holder.contactitem_select_cb=(CheckBox)convertView.findViewById(R.id.last_msg_tv);
			convertView.setTag(holder);
		}else{
			holder=(ViewHolder) convertView.getTag();
		}
		holder.contactitem_catalog.setText("A");
		holder.contactitem_account.setText("11");
		holder.contactitem_nick.setText(contacts.get(position).nickname);
		holder.contactitem_signature.setText("我爱天安门,我爱祖国,我爱人民！");
		return convertView;
	}
	private  class ViewHolder{
		TextView contactitem_catalog;//分类
		TextView contactitem_nick;//昵称
		ImageView contactitem_avatar_iv;//头像
		ImageView contactitem_icon;//
		TextView contactitem_account;//
		TextView contactitem_signature;//签名
		CheckBox contactitem_select_cb;//选择按钮
	}

}

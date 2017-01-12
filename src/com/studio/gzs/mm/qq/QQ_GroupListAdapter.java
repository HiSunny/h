package com.studio.gzs.mm.qq;

import java.util.ArrayList;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.studio.gzs.mm.R;

public class QQ_GroupListAdapter extends BaseAdapter {
	private Context context;
	private ArrayList<QQGroupInfo> groups=null;
	private LayoutInflater inflater = null;
	private ViewHolder holder=null;
	
	//构造函数
	public QQ_GroupListAdapter(Activity a,ArrayList<QQGroupInfo> qqGroups){
			this.context=a;
			inflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			if(qqGroups!=null){
				this.groups=qqGroups;
			}else{
				groups=new ArrayList<QQGroupInfo>();
			}
	}

	@Override
	public int getCount() {
		// 返回列表中元素个数
		return groups.size();
	}

	@Override
	public Object getItem(int position) {
		// 返回指定位置的元素
		return groups.get(position);
	}

	@Override
	public long getItemId(int position) {
		// 返回指定位置的元素ID
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		//返回元素视图
		holder=null;
		if(convertView==null){
			holder=new ViewHolder();
			convertView=inflater.inflate(R.layout.qq_group_item, null);
			holder.groupName=(TextView)convertView.findViewById(R.id.qq_group_name);
			holder.groupCount=(TextView)convertView.findViewById(R.id.qq_group_weixin_num);
			convertView.setTag(holder);
		}else{
			holder = (ViewHolder) convertView.getTag();
		}
		holder.groupName.setText(groups.get(position).getGroupName());
		holder.groupCount.setText("共"+groups.get(position).getmemberCount()+"人，"+groups.get(position).getmCount()+"人开通微信");
		return convertView;
	}
	//私有内部类
	private  class ViewHolder {
		public  TextView groupName;//分组名称
		public  TextView groupCount;
	}

}

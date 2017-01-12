package com.studio.gzs.mm;

import com.studio.gzs.mm.R;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ExpandListActivityDemo extends Activity{
	
	private ExpandableListAdapter adapter;
	private ExpandableListView listView;
	private String[] provinces={"山东","河北"};
	private String[][] cities={{"济南","济宁","菏泽"},{"石家庄","天津","焦作"}};

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.city_select);
		listView=(ExpandableListView)findViewById(R.id.city_select_lv);
		adapter=new MyExpandableListAdapter(this, provinces, cities);
		listView.setAdapter(adapter);
	}
	/*
	 * 自定义二级分类列表
	 */
	public class MyExpandableListAdapter extends BaseExpandableListAdapter {
		private String[] groups=null;
		private String[][] children=null;
		private Activity context;
		private LayoutInflater mChildInflater; // 用于加载二级分类的布局xml
		private LayoutInflater mGroupInflater; // 用于加载一级分类的布局xml
		
		public MyExpandableListAdapter(Activity activity,String[] groups,String [][] children){
			if(groups!=null){
				this.groups=groups;
			}else{
				this.groups=new String[]{};
			}
			if(children!=null){
				this.children=children;
			}else{
				this.children=new String[][]{};
			}
			this.context=activity;
			mChildInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			mGroupInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		}

		@Override
		public boolean areAllItemsEnabled() {
			// ExpandableListAdapter里面的所有条目都可用吗？如果是yes，就意味着所有条目可以选择和点击了。
			return super.areAllItemsEnabled();
		}

		@Override
		public boolean isEmpty() {
			// 如果当前适配器不包含任何数据则返回True。经常用来决定一个空视图是否应该被显示。
			return super.isEmpty();
		}

		@Override
		public void onGroupCollapsed(int groupPosition) {
			//当组展开状态的时候此方法被调用
			super.onGroupCollapsed(groupPosition);
			
		}

		@Override
		public void onGroupExpanded(int groupPosition) {
			//当组收缩状态的时候此方法被调用。
			super.onGroupExpanded(groupPosition);
		}
		
		@Override
		public int getGroupCount() {
			//返回一级分类数
			return groups.length;
		}

		@Override
		public int getChildrenCount(int groupPosition) {
			// 返回二级分类的个数
			return groups[groupPosition].length();
		}

		@Override
		public Object getGroup(int groupPosition) {
			// 返回一级分类对象
			return groups[groupPosition];
		}

		@Override
		public Object getChild(int groupPosition, int childPosition) {
			// 返回二级分类对象
			return children[groupPosition][childPosition];
		}

		@Override
		public long getGroupId(int groupPosition) {
			// 一级分类ID
			return groupPosition;
		}

		@Override
		public long getChildId(int groupPosition, int childPosition) {
			// 二级分类ID
			return childPosition;
		}

		@Override
		public boolean hasStableIds() {
			//数据是否唯一
			return true;
		}

		@Override
		public View getGroupView(int groupPosition, boolean isExpanded,
				View convertView, ViewGroup parent) {
			//获取一级分类视图
			if (convertView == null) {
				convertView = mGroupInflater.inflate(R.layout.city_select_province_item, null);
			} 
			TextView textView = (TextView) convertView.findViewById(R.id.city_select_province_name);
			textView.setText(groups[groupPosition]);
			ImageView imageView =(ImageView)convertView.findViewById(R.id.city_select_province_indicator);
			if(isExpanded){
				imageView.setImageResource(R.drawable.mm_submenu_down);
			}else{
				imageView.setImageResource(R.drawable.mm_submenu);
			}
			return convertView;
		}

		@Override
		public View getChildView(int groupPosition, int childPosition,
				boolean isLastChild, View convertView, ViewGroup parent) {
			// 获取二级分类视图
			ViewHolder holder=null ; // 清空临时变量
			if (convertView == null) { // 若行未初始化
				// 通过flater初始化行视图
				convertView = mChildInflater.inflate(R.layout.city_select_city_item, null);
				// 并将行视图的3个子视图引用放到tag中
				holder = new ViewHolder();
				holder.textView1 = (TextView) convertView.findViewById(R.id.city_select_city_name);
				convertView.setTag(holder);
			} else { // 若行已初始化，直接从tag属性获得子视图的引用
				holder = (ViewHolder) convertView.getTag();
			}
			holder.textView1.setText(children[groupPosition][childPosition]);
			return convertView;
		}

		@Override
		public boolean isChildSelectable(int groupPosition, int childPosition) {
			// 是否选中指定位置上的子元素。
			String temp=children[groupPosition][childPosition];
			Toast.makeText(context, "你选择了["+temp+"]", 2000).show();
			return true;
		}
		// 定义一个内部类，用于保存二级分类的子视图引用
		public class ViewHolder {
			public TextView textView1;
		}
		
	
	}

}

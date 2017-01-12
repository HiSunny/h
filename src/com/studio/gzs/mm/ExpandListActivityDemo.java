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
	private String[] provinces={"ɽ��","�ӱ�"};
	private String[][] cities={{"����","����","����"},{"ʯ��ׯ","���","����"}};

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.city_select);
		listView=(ExpandableListView)findViewById(R.id.city_select_lv);
		adapter=new MyExpandableListAdapter(this, provinces, cities);
		listView.setAdapter(adapter);
	}
	/*
	 * �Զ�����������б�
	 */
	public class MyExpandableListAdapter extends BaseExpandableListAdapter {
		private String[] groups=null;
		private String[][] children=null;
		private Activity context;
		private LayoutInflater mChildInflater; // ���ڼ��ض�������Ĳ���xml
		private LayoutInflater mGroupInflater; // ���ڼ���һ������Ĳ���xml
		
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
			// ExpandableListAdapter�����������Ŀ�������������yes������ζ��������Ŀ����ѡ��͵���ˡ�
			return super.areAllItemsEnabled();
		}

		@Override
		public boolean isEmpty() {
			// �����ǰ�������������κ������򷵻�True��������������һ������ͼ�Ƿ�Ӧ�ñ���ʾ��
			return super.isEmpty();
		}

		@Override
		public void onGroupCollapsed(int groupPosition) {
			//����չ��״̬��ʱ��˷���������
			super.onGroupCollapsed(groupPosition);
			
		}

		@Override
		public void onGroupExpanded(int groupPosition) {
			//��������״̬��ʱ��˷��������á�
			super.onGroupExpanded(groupPosition);
		}
		
		@Override
		public int getGroupCount() {
			//����һ��������
			return groups.length;
		}

		@Override
		public int getChildrenCount(int groupPosition) {
			// ���ض�������ĸ���
			return groups[groupPosition].length();
		}

		@Override
		public Object getGroup(int groupPosition) {
			// ����һ���������
			return groups[groupPosition];
		}

		@Override
		public Object getChild(int groupPosition, int childPosition) {
			// ���ض����������
			return children[groupPosition][childPosition];
		}

		@Override
		public long getGroupId(int groupPosition) {
			// һ������ID
			return groupPosition;
		}

		@Override
		public long getChildId(int groupPosition, int childPosition) {
			// ��������ID
			return childPosition;
		}

		@Override
		public boolean hasStableIds() {
			//�����Ƿ�Ψһ
			return true;
		}

		@Override
		public View getGroupView(int groupPosition, boolean isExpanded,
				View convertView, ViewGroup parent) {
			//��ȡһ��������ͼ
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
			// ��ȡ����������ͼ
			ViewHolder holder=null ; // �����ʱ����
			if (convertView == null) { // ����δ��ʼ��
				// ͨ��flater��ʼ������ͼ
				convertView = mChildInflater.inflate(R.layout.city_select_city_item, null);
				// ��������ͼ��3������ͼ���÷ŵ�tag��
				holder = new ViewHolder();
				holder.textView1 = (TextView) convertView.findViewById(R.id.city_select_city_name);
				convertView.setTag(holder);
			} else { // �����ѳ�ʼ����ֱ�Ӵ�tag���Ի������ͼ������
				holder = (ViewHolder) convertView.getTag();
			}
			holder.textView1.setText(children[groupPosition][childPosition]);
			return convertView;
		}

		@Override
		public boolean isChildSelectable(int groupPosition, int childPosition) {
			// �Ƿ�ѡ��ָ��λ���ϵ���Ԫ�ء�
			String temp=children[groupPosition][childPosition];
			Toast.makeText(context, "��ѡ����["+temp+"]", 2000).show();
			return true;
		}
		// ����һ���ڲ��࣬���ڱ���������������ͼ����
		public class ViewHolder {
			public TextView textView1;
		}
		
	
	}

}

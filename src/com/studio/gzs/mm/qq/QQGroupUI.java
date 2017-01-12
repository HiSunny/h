package com.studio.gzs.mm.qq;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

import com.studio.gzs.mm.R;

public class QQGroupUI extends Activity {
	private ListView qqGroup;
	private QQ_GroupListAdapter adapter;
	private ArrayList<QQGroupInfo> qqGroups=new ArrayList<QQGroupInfo>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.qq_group);
		qqGroup=(ListView)findViewById(R.id.qq_group_lv);
		init();
		adapter=new QQ_GroupListAdapter(this, qqGroups);	
		qqGroup.setAdapter(adapter);
		
		//选择一行记录
		qqGroup.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				Intent intent=new Intent(getApplicationContext(), QQFriendUI.class);
				startActivity(intent);
				
			}
		});
		/*qqGroup.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				Intent intent=new Intent(getApplicationContext(), QQFriendUI.class);
				startActivity(intent);
			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {
				// TODO Auto-generated method stub
				
			}
		});*/
	}
	public void init(){
		QQGroupInfo group1=new QQGroupInfo();
		group1.setGroupName("我的好友");
		group1.setmemberCount("5");
		group1.setmCount("2");
		QQGroupInfo group2=new QQGroupInfo();
		group2.setGroupName("同学");
		group2.setmemberCount("8");
		group2.setmCount("4");
		qqGroups.add(group1);
		qqGroups.add(group2);
	}
}


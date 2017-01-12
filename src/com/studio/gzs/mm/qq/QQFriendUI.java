package com.studio.gzs.mm.qq;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import com.studio.gzs.mm.ui.chatting.ChattingUI;
import com.studio.gzs.mm.R;
public class QQFriendUI extends Activity {
	private ListView qqList;
	private QQ_ListAdapter adapter;
	private ArrayList<QQFriendInfo> qqfriedns=null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.qq_friend);
		qqList=(ListView)findViewById(R.id.qq_friend_lv);
		init();
		adapter=new QQ_ListAdapter(this, qqfriedns);
		qqList.setAdapter(adapter);
		qqList.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				Intent intent=new Intent(getApplicationContext(), ChattingUI.class);
				startActivity(intent);
				
			}
		});
	}
	public void init(){
		qqfriedns=new ArrayList<QQFriendInfo>();
		QQFriendInfo f1=new QQFriendInfo();
		f1.qqName="±¦±´¶ù";
		f1.qqNum="3177711627";
		f1.isAddMmFriend=false;
		f1.isRegMmUser=false;
		qqfriedns.add(f1);
		QQFriendInfo f2=new QQFriendInfo();
		f2.qqName="÷ÈÐ¡Ã¨";
		f2.qqNum="1139127047";
		f2.isAddMmFriend=false;
		f2.isRegMmUser=true;
		qqfriedns.add(f2);
		QQFriendInfo f3=new QQFriendInfo();
		f3.qqName="ÀäÎ¢";
		f3.qqNum="1139127047";
		f3.isAddMmFriend=true;
		f3.isRegMmUser=true;
		qqfriedns.add(f3);
	}
}

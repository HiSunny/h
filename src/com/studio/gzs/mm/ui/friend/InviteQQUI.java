package com.studio.gzs.mm.ui.friend;

import java.util.ArrayList;

import com.studio.gzs.mm.qq.QQFriendInfo;
import com.studio.gzs.mm.qq.QQGroupInfo;
import com.studio.gzs.mm.R;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

public class InviteQQUI extends Activity {
	private LinearLayout content_layout;
	private LayoutInflater inflater;
	private ListView qqGroup_lv;
	private View content_v;
	private InviteQQAdapter adpater;
	private ArrayList<QQFriendInfo> qqFriend=new ArrayList<QQFriendInfo>();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.mm_pref_invite);
		
		content_layout=(LinearLayout)findViewById(R.id.content_lv);
		inflater=(LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		content_v=inflater.inflate(R.layout.inviteqqfriends, null);
		content_layout.addView(content_v);
		
		qqGroup_lv=(ListView)content_v.findViewById(R.id.inviteqqfriends_friend_lv);
		adpater=new InviteQQAdapter(InviteQQUI.this, qqFriend);
		qqGroup_lv.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {

				
			}
		});
	}
}

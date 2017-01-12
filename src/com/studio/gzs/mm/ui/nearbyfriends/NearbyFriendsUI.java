package com.studio.gzs.mm.ui.nearbyfriends;

import java.util.ArrayList;

import com.studio.gzs.mm.R;
import com.studio.gzs.mm.R.id;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.style.LeadingMarginSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

public class NearbyFriendsUI extends Activity{
	
	private Button rightBtn;
	private ImageButton leftBtn;
	private TextView title;
	private LayoutInflater inflater;
	private LinearLayout content_lv;
	private View content;
	private ListView nearby_friend_lv;
	private NearbyFriendAdapter adapter;
	private ArrayList<NearbyFriend> nearByFriends=new ArrayList<NearbyFriend>();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.mm_pref_nearbyfriend);
		
		content_lv=(LinearLayout)findViewById(R.id.content_lv);
		inflater=(LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		content=inflater.inflate(R.layout.nearby_friend, null);
		content_lv.addView(content);		
		nearby_friend_lv=(ListView)findViewById(R.id.nearby_friend_lv);
		
		init();
		
		adapter=new NearbyFriendAdapter(NearbyFriendsUI.this,nearByFriends);
		nearby_friend_lv.setAdapter(adapter);
		initTitle();
		
	}
	public void init(){
		NearbyFriend f=new NearbyFriend();
		f.friend_name="小墨迹";
		f.isFriend=false;
		f.isMan=false;
		f.distance="距离100米";
		f.friend_sign="我的爱无止境！";
		nearByFriends.add(f);
		NearbyFriend m=new NearbyFriend();
		m.friend_name="小羊羔";
		m.isFriend=true;
		m.isMan=true;
		m.distance="距离200米";
		m.friend_sign="天上掉馅饼啦！";
		nearByFriends.add(m);
	}
	public void initTitle(){
		rightBtn=(Button)findViewById(R.id.title_btn4);
		rightBtn.setText(R.string.app_back);
		rightBtn.setVisibility(View.VISIBLE);
		rightBtn.setBackgroundDrawable(getResources().getDrawable(R.drawable.mm_title_btn_back));	
		leftBtn=(ImageButton)findViewById(R.id.title_btn1);
		leftBtn.setImageDrawable(getResources().getDrawable(R.drawable.mm_title_btn_menu));
		title=(TextView)findViewById(R.id.title);
		title.setText(R.string.nearby_friend_title);
		leftBtn.setVisibility(View.VISIBLE);
	}
	public class NearByFriendOnClickListener implements View.OnClickListener{

		@Override
		public void onClick(View v) {
			switch (v.getId()) {
			case R.id.title_btn4:
				finish();
				break;
			case R.id.title_btn1:
				Intent intent=new Intent();
			//	intent.setClass(NearbyFriendsUI.this, cls);
			default:
				break;
			}
			
		}
		
	}
}

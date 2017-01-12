package com.studio.gzs.mm;

import java.util.ArrayList;

import com.studio.gzs.mm.ui.AddressUI;
import com.studio.gzs.mm.ui.CantactAdapter;
import com.studio.gzs.mm.ui.ChattingAdapter;
import com.studio.gzs.mm.ui.ContactPersion;
import com.studio.gzs.mm.ui.MMImageButton;
import com.studio.gzs.mm.ui.chatting.ChattingUI;
import com.studio.gzs.mm.ui.nearbyfriends.NearbyFriend;
import com.studio.gzs.mm.ui.nearbyfriends.NearbyFriendAdapter;
import com.studio.gzs.mm.R;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;


public class MainUI extends Activity {
	private LinearLayout content;
	private MMImageButton leftBtn,rightBtn;
	private TextView title;
	private String flag;
	private Intent intent;
	private LayoutInflater inflater;
	private ListView main_chatting_lv;
	private TextView empty_conversation_tv;
	private ChattingAdapter chatting_ad;
	private CantactAdapter  cantact_ad;
	private NearbyFriendAdapter nearbyFriend_ad;
	private ArrayList<ContactPersion> contacts=new ArrayList<ContactPersion>();
	private ArrayList<NearbyFriend> nearByFriends=new ArrayList<NearbyFriend>();
	
	private static final int MENU_EXIT=Menu.FIRST;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		//getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		
		setContentView(R.layout.mm_pref);
		
		
		inflater=(LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		flag=getIntent().getStringExtra("msg");
		
		init();
		
		content=(LinearLayout)findViewById(R.id.content_lv);//�б���������LinearLayout
		
		
			
		leftBtn=(MMImageButton)findViewById(R.id.title_btn4);
		rightBtn=(MMImageButton)findViewById(R.id.title_btn1);
		title=(TextView)findViewById(R.id.title);
		
		rightBtn.setVisibility(View.INVISIBLE);
		leftBtn.setVisibility(View.INVISIBLE);
		
		if("weixin".equals(flag)){			
			initList();			
			title.setText(R.string.main_title);
			rightBtn.setVisibility(View.VISIBLE);
			rightBtn.setImageFlag(true);
			rightBtn.setTitleLogo(getResources().getDrawable(R.drawable.mm_title_btn_compose_normal));
			
			chatting_ad=new ChattingAdapter(MainUI.this, contacts);		
			main_chatting_lv.setAdapter(chatting_ad);
			main_chatting_lv.setOnItemClickListener(new OnItemClickListener() {

				@Override
				public void onItemClick(AdapterView<?> parent, View view,
						int position, long id) {
					Intent intent=new Intent(getApplicationContext(), ChattingUI.class);
					startActivity(intent);					
				}
			});
			
		}else if("address".equals(flag)){
			initList();		
			title.setText(R.string.main_contact);
			rightBtn.setVisibility(View.VISIBLE);
			rightBtn.setImageFlag(true);
			rightBtn.setTitleLogo(getResources().getDrawable(R.drawable.mm_title_btn_add_contact_normal));
			
			cantact_ad=new CantactAdapter(MainUI.this, contacts);
			main_chatting_lv.setAdapter(cantact_ad);
			
			rightBtn.setOnClickListener(new OnClickListener() {			
				@Override
				public void onClick(View v) {
					intent=new Intent(MainUI.this, AddressUI.class);
					startActivity(intent);
				}
			});
			
		}else if("friends".equals(flag)){
			initList();	
			title.setText(R.string.main_addcontact);
			initByFriend();
			nearbyFriend_ad=new NearbyFriendAdapter(MainUI.this, nearByFriends);
			main_chatting_lv.setAdapter(nearbyFriend_ad);
			
		}else if("setting".equals(flag)){
			title.setText(R.string.main_setting);
			initSeting();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		menu.add(0, MENU_EXIT, 0, "�˳�").setIcon(R.drawable.menu_exit);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case MENU_EXIT:
			Intent startMain = new Intent(Intent.ACTION_MAIN);
			startMain.addCategory(Intent.CATEGORY_HOME);
			startMain.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(startMain);//ת����ҳ
			moveTaskToBack(true);
		//	exit2();
			exit1();
			break;
		default:
			break;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void finish() {
	
		System.exit(0);
		super.finish();
	}
	/**
	 * ʹ������������ر�Ӧ�ó�������Ҫ˵���÷���������Android 1.5 API LevelΪ3���ϲſ��ԣ�
	 * ͬʱ��ҪȨ��android.permission.RESTART_PACKAGES��
	 * @Description TODO void
	 */
	public void exit2(){
		ActivityManager activityMgr= (ActivityManager) this.getSystemService(ACTIVITY_SERVICE );
		activityMgr.restartPackage(getPackageName()); 
	}
	/**
	 * ʹ��Activity���������ڣ�����֪��Android�Ĵ������ṩ����ʷջ�����ǿ���ͨ��stack��ԭ���������ʵ�֣�
	 * ����ͨ����������ʱ����Intent��ֱ�Ӽ����־ Intent.FLAG_ACTIVITY_CLEAR_TOP��
	 * ��������Bʱ��������ý��̿ռ������Activity��
	 * @Description TODO void
	 */
	public void exit1(){
		Intent startMain = new Intent(Intent.ACTION_MAIN);
		startMain.addCategory(Intent.CATEGORY_HOME);
		startMain.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		startActivity(startMain);
		finish();
	}
	public void init(){
		ContactPersion c=new ContactPersion();
		c.nickname="����";
		c.update_time="12����ǰ";
		c.last_msg="�Է�û?";
		contacts.add(c);
		ContactPersion b=new ContactPersion();
		b.nickname="С��";
		b.update_time="16����ǰ";
		b.last_msg="���զ��?";
		contacts.add(b);
		
	}
	public void initByFriend(){
		NearbyFriend f=new NearbyFriend();
		f.friend_name="Сī��";
		f.isFriend=false;
		f.isMan=false;
		f.distance="����100��";
		f.friend_sign="�ҵİ���ֹ����";
		nearByFriends.add(f);
		NearbyFriend m=new NearbyFriend();
		m.friend_name="С���";
		m.isFriend=true;
		m.isMan=true;
		m.distance="����200��";
		m.friend_sign="���ϵ��ڱ�����";
		nearByFriends.add(m);
	}
	public void initList(){
		View contentView=inflater.inflate(R.layout.main, null);
		content.addView(contentView,LayoutParams.FILL_PARENT,LayoutParams.FILL_PARENT);
		
		main_chatting_lv=(ListView)findViewById(R.id.main_chatting_lv);//list��
		empty_conversation_tv=(TextView)findViewById(R.id.empty_conversation_tv);//Ϊ��ʱ��ʾ
		
		if(contacts!=null&&contacts.size()!=0){
			empty_conversation_tv.setVisibility(View.GONE);
		}
	}
	public void initSeting(){
		View contentView=inflater.inflate(R.layout.contact_info_header_normal, null);
		content.addView(contentView,LayoutParams.FILL_PARENT,LayoutParams.FILL_PARENT);
	}
}

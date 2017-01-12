package com.studio.gzs.mm;

import com.studio.gzs.mm.R;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TabHost;

public class MainTabUI3 extends TabActivity {
	public static final String TAB_WENXIN = "weixin";
	public static final String TAB_ADRESS = "address";
	public static final String TAB_FRIENDS = "friends";
	public static final String TAB_SETTING = "setting";
	
	private TabHost tabHost=null;
	private TabHost.TabSpec spec=null;
	private RadioGroup tab_group;
	private Intent intent=null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);		
		
		requestWindowFeature(Window.FEATURE_NO_TITLE);//去标题
		//getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);//全屏
		
		setContentView(R.layout.main_tab_radiogroup);
		tabHost=getTabHost();

		intent=new Intent(this, MainUI.class);
		intent.putExtra("msg", TAB_WENXIN);
		spec=tabHost.newTabSpec(TAB_WENXIN);
		spec.setContent(intent).setIndicator(TAB_WENXIN);
		tabHost.addTab(spec);
		
		intent=new Intent(this, MainUI.class);
		intent.putExtra("msg", TAB_ADRESS);
		spec=tabHost.newTabSpec(TAB_ADRESS);
		spec.setContent(intent).setIndicator(TAB_ADRESS);
		tabHost.addTab(spec);
		
		intent=new Intent(this, MainUI.class);
		intent.putExtra("msg", TAB_FRIENDS);
		spec=tabHost.newTabSpec(TAB_FRIENDS);
		spec.setContent(intent).setIndicator(TAB_FRIENDS);
		tabHost.addTab(spec);
		
		intent=new Intent(this, MainUI.class);
		intent.putExtra("msg", TAB_SETTING);
		spec=tabHost.newTabSpec(TAB_SETTING);
		spec.setContent(intent).setIndicator(TAB_SETTING);
		tabHost.addTab(spec);
		
		setDefaultTab(0);
		
		tab_group=(RadioGroup)findViewById(R.id.main_tab_group);
		tab_group.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				
				switch (checkedId) {
				case R.id.main_tab_weixin:	
					tabHost.setCurrentTabByTag(TAB_WENXIN);
					break;
				case R.id.main_tab_address:
					tabHost.setCurrentTabByTag(TAB_ADRESS);
					break;
				case R.id.main_tab_find_friend:
					tabHost.setCurrentTabByTag(TAB_FRIENDS);
					break;
				case R.id.main_tab_settings:
					tabHost.setCurrentTabByTag(TAB_SETTING);
					break;
				default:
					break;
				}
				
			}
		});
	}
}

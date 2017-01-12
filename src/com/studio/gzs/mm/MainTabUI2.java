package com.studio.gzs.mm;

import com.studio.gzs.mm.R;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TabHost;
import android.widget.TextView;

public class MainTabUI2 extends TabActivity {
	private TabHost tabHost=null;
	private TabHost.TabSpec spec = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_tab_new);
		//获得TabHost的对象
		tabHost=getTabHost();
			
		//通过TabHost.TabSpec增加tab的一页，，
		spec = tabHost.newTabSpec("微信");
		//通过setIndicator增加页的标签
		spec.setIndicator(prepareTabView("微信",R.drawable.tab_weixin));
		//通过setContent()增加标签事件
		//spec.setContent(intent);
		spec.setContent(R.id.txt1);
		tabHost.addTab(spec);
		
		spec = tabHost.newTabSpec("通讯录");
		spec.setIndicator(prepareTabView("通讯录", R.drawable.tab_address));
		spec.setContent(R.id.txt2);
		tabHost.addTab(spec);
		
		spec = tabHost.newTabSpec("找朋友");
		spec.setIndicator(prepareTabView("找朋友", R.drawable.tab_find_frd));
		spec.setContent(R.id.txt3);
		tabHost.addTab(spec);
		
		spec = tabHost.newTabSpec("设置");
		spec.setIndicator(prepareTabView("设置", R.drawable.tab_settings));
		spec.setContent(R.id.txt4);
		tabHost.addTab(spec);
		
		tabHost.setCurrentTab(0);
	}
/*	//设置布局以及图标、文字信息
	private View prepareTabView(String text, int resId) {
		View view = LayoutInflater.from(this).inflate(R.layout.tabwight_layout_new,
				null);
		RadioButton iv = (RadioButton) view.findViewById(R.id.tab_icon_new);
		iv.setText(text);
		iv.setButtonDrawable(resId);
		return view;
	}*/
	private View prepareTabView(String text, int resId) {
		View view = LayoutInflater.from(this).inflate(R.layout.tabwight_layout_new2,
				null);
		ImageView iv = (ImageView) view.findViewById(R.id.tab_icon);
		iv.setBackgroundResource(resId);
		TextView tv=(TextView)view.findViewById(R.id.tab_text);
		tv.setText(text);
		return view;
	}
}

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
		//���TabHost�Ķ���
		tabHost=getTabHost();
			
		//ͨ��TabHost.TabSpec����tab��һҳ����
		spec = tabHost.newTabSpec("΢��");
		//ͨ��setIndicator����ҳ�ı�ǩ
		spec.setIndicator(prepareTabView("΢��",R.drawable.tab_weixin));
		//ͨ��setContent()���ӱ�ǩ�¼�
		//spec.setContent(intent);
		spec.setContent(R.id.txt1);
		tabHost.addTab(spec);
		
		spec = tabHost.newTabSpec("ͨѶ¼");
		spec.setIndicator(prepareTabView("ͨѶ¼", R.drawable.tab_address));
		spec.setContent(R.id.txt2);
		tabHost.addTab(spec);
		
		spec = tabHost.newTabSpec("������");
		spec.setIndicator(prepareTabView("������", R.drawable.tab_find_frd));
		spec.setContent(R.id.txt3);
		tabHost.addTab(spec);
		
		spec = tabHost.newTabSpec("����");
		spec.setIndicator(prepareTabView("����", R.drawable.tab_settings));
		spec.setContent(R.id.txt4);
		tabHost.addTab(spec);
		
		tabHost.setCurrentTab(0);
	}
/*	//���ò����Լ�ͼ�ꡢ������Ϣ
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

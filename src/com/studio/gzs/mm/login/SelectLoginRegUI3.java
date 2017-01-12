package com.studio.gzs.mm.login;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ComponentName;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.studio.gzs.mm.R;

public class SelectLoginRegUI3 extends Activity {

	private Button loginBtn,regBtn;
	private PopupWindow popupWindow;
	
	//ѡ��˵�
	private TextView qqLogin_tv,mobReg_tv,mailReg_tv,cancle_tv;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.select_login_reg);
		loginBtn=(Button)findViewById(R.id.select_login_btn);
		regBtn=(Button)findViewById(R.id.select_register_btn);
		MyOnClientListener listen=new MyOnClientListener();
		loginBtn.setOnClickListener(listen);
		regBtn.setOnClickListener(listen);
	}

	@Override
	protected void onResume() {
		if(popupWindow!=null&&popupWindow.isShowing()){
			popupWindow.dismiss();
		}
		super.onResume();
	}

	public class MyOnClientListener implements View.OnClickListener{

		@Override
		public void onClick(View v) {
			Intent intent=new Intent();
			switch (v.getId()) {
			case R.id.select_login_btn:
				intent.setClass(SelectLoginRegUI3.this, LoginUI.class);
				intent.putExtra("LoginReg", 0);
				startActivity(intent);
				break;
			case R.id.select_register_btn:
			//	openDialog();
				popoSelectMenu();
				break;
			default:
				break;
			}
			
		}
		
	}
	private void popoSelectMenu(){
		
		LayoutInflater mLayoutInflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
		View menuView = (View)mLayoutInflater.inflate(R.layout.alert_dialog_menu_layout_new, null, true);
		
		//ʹ��QQ��¼
		qqLogin_tv=(TextView)menuView.findViewById(R.id.popup_text1);
		qqLogin_tv.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent=new Intent();
				intent.setClass(SelectLoginRegUI3.this, LoginUI.class);
				startActivity(intent);		
			}
		});
		//�ֻ�ע��
		mobReg_tv=(TextView)menuView.findViewById(R.id.popup_text2);
		mobReg_tv.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent=new Intent();
				intent.setClass(SelectLoginRegUI3.this, RegByMobileRegUI.class);
				startActivity(intent);	
				
			}
		});
		//����ע��
		mailReg_tv=(TextView)menuView.findViewById(R.id.popup_text3);
		mailReg_tv.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent=new Intent();
				intent.setClass(SelectLoginRegUI3.this, RegByMailRegUI.class);
				startActivity(intent);
				
			}
		});
		//ȡ��
		cancle_tv=(TextView)menuView.findViewById(R.id.popup_text4);
		cancle_tv.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				popupWindow.dismiss();
				
			}
		});
		
	/*	popupWindow = new PopupWindow(menuView, LayoutParams.FILL_PARENT,
				LayoutParams.FILL_PARENT, true);*/
		popupWindow = new PopupWindow(menuView, LayoutParams.FILL_PARENT,238, true);
		popupWindow.setBackgroundDrawable(getResources().getDrawable(R.drawable.btn_style_alert_dialog_background));
		popupWindow.setAnimationStyle(R.style.PopupAnimation);
		popupWindow.showAtLocation(findViewById(R.id.parent), Gravity.RIGHT|Gravity.BOTTOM, 0, 0);
		popupWindow.update();
		
	}
	//Dialog��ʾ��С�����Լ���μӶ���
	private void openDialog(){
		View menuView = View.inflate(this, R.layout.alert_dialog_menu_layout_new, null);
		// ����AlertDialog
		final AlertDialog menuDialog = new AlertDialog.Builder(this).create();
		menuDialog.setView(menuView);
	//	menuDialog.setView(menuView, 100, 100, 100, 100);
		menuDialog.show();
	//	content_list=(ListView)findViewById(R.id.content_list);
	//	content_list.setAdapter()
	}

}

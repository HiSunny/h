package com.studio.gzs.mm.login;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager.LayoutParams;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.studio.gzs.mm.MainTabUI3;
import com.studio.gzs.mm.ui.MMImageButton;
import com.studio.gzs.mm.R;

public class LoginUI extends Activity {
	private String login_num;
	private String login_password;
	
	private MMImageButton leftBtn,rightBtn;
	private ImageView title_logo;

	private LinearLayout content;
	private LayoutInflater inflater;
	private View content_lv;
	
	private BtnOnClickListener listener;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.mm_pref);
		
		inflater=(LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		content=(LinearLayout)findViewById(R.id.content_lv);
		
		content_lv=inflater.inflate(R.layout.login, null);//µÇÂ¼	
		content.addView(content_lv, LayoutParams.FILL_PARENT, LayoutParams.FILL_PARENT);
		initLoginTitle();
	
	}
	public void  initLoginTitle(){
		
		rightBtn=(MMImageButton)findViewById(R.id.title_btn4);
		leftBtn=(MMImageButton)findViewById(R.id.title_btn1);
		title_logo=(ImageView)findViewById(R.id.title_logo);
		
	
		rightBtn.setVisibility(View.VISIBLE);
		rightBtn.setBackgroundResource(R.drawable.mm_title_btn_back);
		rightBtn.setTitle(R.string.app_back);

		leftBtn.setVisibility(View.VISIBLE);
		leftBtn.setTitle(R.string.intro_existed_login);
		
		listener=new BtnOnClickListener();
		rightBtn.setOnClickListener(listener);
		leftBtn.setOnClickListener(listener);

		title_logo.setVisibility(View.VISIBLE);
		title_logo.setImageDrawable(getResources().getDrawable(R.drawable.title_logo));
		
	}
	
	//µÇÂ¼ÑéÖ¤
	public void loginValidate(){
		login_num=((EditText) findViewById(R.id.login_account_auto)).getText().toString();
		login_password=((EditText) findViewById(R.id.login_password_et)).getText().toString();
	}
	
	public class BtnOnClickListener implements View.OnClickListener{

		@Override
		public void onClick(View v) {
			switch (v.getId()) {
			case R.id.title_btn4:
				finish();
				break;
			case R.id.title_btn1:
				loginValidate();
				Intent intent=new Intent(LoginUI.this,MainTabUI3.class);
				startActivity(intent);
				break;
			default:
				break;
			}
		}
		
	}
}

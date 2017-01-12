package com.studio.gzs.mm.login;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.studio.gzs.mm.MainTabUI3;
import com.studio.gzs.mm.ui.MMImageButton;
import com.studio.gzs.mm.R;

public class RegByMobileSetNickUI extends Activity {
    private MMImageButton cancelBtn,nextBtn;
    private TextView title;
	private LayoutInflater inflater;
	private LinearLayout content;
	private View content_lv;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.mm_pref);
		
		inflater=(LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		content=(LinearLayout)findViewById(R.id.content_lv);
		
		content_lv=inflater.inflate(R.layout.regbymobilesetnick_reg, null);
		content.addView(content_lv, LayoutParams.FILL_PARENT, LayoutParams.FILL_PARENT);
		
		init();

	}
	public void init(){
		cancelBtn=(MMImageButton)findViewById(R.id.title_btn4);
		nextBtn=(MMImageButton)findViewById(R.id.title_btn1);
		title=(TextView)findViewById(R.id.title);
		
		MoblieRegOnClickListener listen=new MoblieRegOnClickListener();
		
		cancelBtn.setVisibility(View.VISIBLE);
		cancelBtn.setTitle(R.string.app_cancel);
		cancelBtn.setOnClickListener(listen);
		
		nextBtn.setVisibility(View.VISIBLE);
		nextBtn.setTitle(R.string.app_nextstep);
		nextBtn.setOnClickListener(listen);
		
		title.setText(R.string.regbymobile_reg_setnick_title);
		
	}
	public class MoblieRegOnClickListener implements View.OnClickListener{

		@Override
		public void onClick(View v) {
			switch (v.getId()) {
			case R.id.title_btn4:
				finish();
				break;
			case R.id.title_btn1:
				Intent intent=new Intent(RegByMobileSetNickUI.this,MainTabUI3.class);
				startActivity(intent);
				break;
			default:
				break;
			}		
		}	
	}
}


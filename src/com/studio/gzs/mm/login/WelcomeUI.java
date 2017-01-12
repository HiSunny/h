package com.studio.gzs.mm.login;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

import com.studio.gzs.mm.ui.chatting.ChattingUI;
import com.studio.gzs.mm.R;

public class WelcomeUI extends Activity {
	 private ImageView welcome_iv;
	    @Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.welcome);
	        welcome_iv=(ImageView)findViewById(R.id.welcome_iv);
	        welcome_iv.setOnClickListener(new OnClickListener() {	
				@Override
				public void onClick(View v) {
				Intent intent=new Intent(getApplicationContext(), SelectLoginRegUI3.class);
				//Intent intent=new Intent(getApplicationContext(), NearbyFriendsUI.class);
			//	Intent intent=new Intent(getApplicationContext(), ChattingUI.class);
					startActivity(intent);				
				}
			});
	    }
		@Override
		protected void onDestroy() {
			finish();
			super.onDestroy();
		}
}
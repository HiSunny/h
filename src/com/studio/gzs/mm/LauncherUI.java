package com.studio.gzs.mm;

import com.studio.gzs.mm.login.WelcomeUI;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class LauncherUI extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Intent intent=new Intent(LauncherUI.this, WelcomeUI.class);
		startActivity(intent);
	}
	
}

package com.project.savemoney;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;

public class WelcomActivity  extends Activity{
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.welcome);
		new Handler().postDelayed(new Runnable() {
			public void run() {
				Intent intent = new Intent(WelcomActivity.this,
						MainActivity.class); // Ö÷½çÃæ
				startActivity(intent);
				WelcomActivity.this.finish();
			}
		}, 3000);
		
	}
}

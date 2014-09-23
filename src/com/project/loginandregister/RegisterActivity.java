package com.project.loginandregister;

import com.project.savemoney.MainActivity;
import com.project.savemoney.R;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends Activity {

	private EditText et_register_mobilephone;
	private EditText et_regist_password;
	private SharedPreferences sp;
	private Button bt_register_ture;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.register);
		init();

		bt_register_ture.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				login();
				Toast.makeText(getApplicationContext(), "注册成功", 1).show();
				Intent intent = new Intent(RegisterActivity.this,
						MainActivity.class);
				startActivity(intent);
			}
		});
	}

	// 初始化方法
	private void init() {
		et_register_mobilephone = (EditText) findViewById(R.id.et_register_mobilephone);
		et_regist_password = (EditText) findViewById(R.id.et_regist_password);
		bt_register_ture = (Button) findViewById(R.id.bt_register_ture);
		sp = getSharedPreferences("share", MODE_PRIVATE);
	}

	// 点击按钮后完成的事件
	public void login() {
		String username = et_register_mobilephone.getText().toString().trim();
		String password = et_regist_password.getText().toString().trim();

		Editor editor = sp.edit();
		editor.putString("username", username);
		editor.putString("password", password);

		editor.commit();// 用来刷新

	}

	
	// 按两次返回键退出软件
	private long exitTime = 0;

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK
				&& event.getAction() == KeyEvent.ACTION_DOWN) {
			if ((System.currentTimeMillis() - exitTime) > 2000) {
				Toast.makeText(getApplicationContext(), "再按一次退出程序",
						Toast.LENGTH_SHORT).show();
				exitTime = System.currentTimeMillis();
			} else {
				finish();
				System.exit(0);
			}
			return true;
		}
		return super.onKeyDown(keyCode, event);
	}
	
	@Override
	protected void onStop() {
		finish();
		super.onStop();

	}

}

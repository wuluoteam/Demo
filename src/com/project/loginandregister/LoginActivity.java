package com.project.loginandregister;

import com.project.savemoney.MainActivity;
import com.project.savemoney.R;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends Activity {

	private Button login_bt_denglu;
	private Button login_bt_suibiankankan;
	private Button login_bt_zhuce;
	private EditText et_login_username;
	private EditText et_login_password;
	private SharedPreferences sp;
	private String name;
	private String pwd;
	private String username;
	private String password;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);
		// 初始化
		init();
		// 获取保存的用户信息
		getValues();

		login_bt_zhuce.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				Intent intent = new Intent(LoginActivity.this,
						RegisterActivity.class);
				startActivity(intent);

			}
		});
		login_bt_suibiankankan.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(LoginActivity.this,
						MainActivity.class);
				startActivity(intent);

			}
		});
		login_bt_denglu.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				username = et_login_username.getText().toString().trim();
				password = et_login_password.getText().toString().trim();
				if (TextUtils.isEmpty(username)||TextUtils.isEmpty(password)) {
					Toast.makeText(getApplicationContext(), "用户名或密码为空", 1)
							.show();
				} else {
					if (username.equals(name) && password.equals(pwd)) {
						Intent intent = new Intent(LoginActivity.this,
								MainActivity.class);
						startActivity(intent);
						Toast.makeText(getApplicationContext(), "用户登录", 1)
								.show();
					} else {

						Toast.makeText(getApplicationContext(),
								"用户名不存在或密码输入错误", 1).show();
					}
				}

			}
		});

	}

	private void init() {
		login_bt_zhuce = (Button) findViewById(R.id.login_bt_zhuce);
		login_bt_suibiankankan = (Button) findViewById(R.id.login_bt_suibiankankan);
		login_bt_denglu = (Button) findViewById(R.id.login_bt_denglu);
		et_login_username = (EditText) findViewById(R.id.et_login_username);
		et_login_password = (EditText) findViewById(R.id.et_login_password);
		sp = getSharedPreferences("share", MODE_PRIVATE);

	}

	private void getValues() {
		
		name = sp.getString("username", null);
		pwd = sp.getString("password",null);
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

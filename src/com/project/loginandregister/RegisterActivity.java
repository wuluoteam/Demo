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
				Toast.makeText(getApplicationContext(), "ע��ɹ�", 1).show();
				Intent intent = new Intent(RegisterActivity.this,
						MainActivity.class);
				startActivity(intent);
			}
		});
	}

	// ��ʼ������
	private void init() {
		et_register_mobilephone = (EditText) findViewById(R.id.et_register_mobilephone);
		et_regist_password = (EditText) findViewById(R.id.et_regist_password);
		bt_register_ture = (Button) findViewById(R.id.bt_register_ture);
		sp = getSharedPreferences("share", MODE_PRIVATE);
	}

	// �����ť����ɵ��¼�
	public void login() {
		String username = et_register_mobilephone.getText().toString().trim();
		String password = et_regist_password.getText().toString().trim();

		Editor editor = sp.edit();
		editor.putString("username", username);
		editor.putString("password", password);

		editor.commit();// ����ˢ��

	}

	
	// �����η��ؼ��˳����
	private long exitTime = 0;

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK
				&& event.getAction() == KeyEvent.ACTION_DOWN) {
			if ((System.currentTimeMillis() - exitTime) > 2000) {
				Toast.makeText(getApplicationContext(), "�ٰ�һ���˳�����",
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

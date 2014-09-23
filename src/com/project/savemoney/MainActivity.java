package com.project.savemoney;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TabHost.TabSpec;

public class MainActivity extends Activity implements OnClickListener {

	private FragmentTransaction ft;
	private FragmentManager fm;
	private Fragment1 fragment1;
	private Fragment2 fragment2;
	private Fragment3 fragment3;
	private Fragment4 fragment4;
	private Fragment5 fragment5;
	private LinearLayout 		linear;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		
		linear = (LinearLayout) findViewById(R.id.linear);
		Button bt_main = (Button) findViewById(R.id.bt_main);
		Button bt_buy = (Button) findViewById(R.id.bt_buy);
		Button bt_yue = (Button) findViewById(R.id.bt_yue);
		Button bt_jiaoyiyue = (Button) findViewById(R.id.bt_jiaoyiyue);
		Button bt_more = (Button) findViewById(R.id.bt_more);

		fragment1 = new Fragment1();
		fragment2 = new Fragment2();
		fragment3 = new Fragment3();
		fragment4 = new Fragment4();
		fragment5 = new Fragment5();
		
		fm = getFragmentManager();
		ft=fm.beginTransaction();
		ft.replace(R.id.linear, fragment1);
		ft.commit();
		

		bt_main.setOnClickListener(this);
		bt_buy.setOnClickListener(this);
		bt_yue.setOnClickListener(this);
		bt_jiaoyiyue.setOnClickListener(this);
		bt_more.setOnClickListener(this);
		

	}

	@Override
	public void onClick(View v) {
		ft = fm.beginTransaction();
		switch (v.getId()) {
		case R.id.bt_main:
			ft.replace(R.id.linear, fragment1);
			break;
		case R.id.bt_buy:
			ft.replace(R.id.linear, fragment2);
			break;
		case R.id.bt_yue:
			ft.replace(R.id.linear, fragment3);
			break;
		case R.id.bt_jiaoyiyue:
			ft.replace(R.id.linear, fragment4);
			break;
		case R.id.bt_more:
			ft.replace(R.id.linear, fragment5);
			break;

		}
		ft.commit();
	}

}

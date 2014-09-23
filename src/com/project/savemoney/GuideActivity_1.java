package com.project.savemoney;

import java.util.ArrayList;

import android.R.bool;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class GuideActivity_1 extends Activity implements OnPageChangeListener {
	private ViewPager guidePagerShowing;
	private boolean flag = true;
	/**
	 * 装点点的ImageView数组
	 */
	private ImageView[] tips;

	private ArrayList<View> pageViews;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

		requestWindowFeature(Window.FEATURE_NO_TITLE);
		SharedPreferences sharedPreferences = getSharedPreferences("check",
				MODE_PRIVATE);

		if (sharedPreferences.getBoolean("flag", true)) {
			setContentView(R.layout.guide);
			LayoutInflater inflater = getLayoutInflater();
			pageViews = new ArrayList<View>();
			View page1 = inflater.inflate(R.layout.guide_page1, null);
			View page2 = inflater.inflate(R.layout.guide_page2, null);
			View page3 = inflater.inflate(R.layout.guide_page3, null);
			Button button1 = (Button) page3.findViewById(R.id.Button1);
			pageViews.add(page1);
			pageViews.add(page2);
			pageViews.add(page3);

			guidePagerShowing = (ViewPager) findViewById(R.id.guidepages);
			ViewGroup group = (ViewGroup) findViewById(R.id.viewGroup);

			// 添加小点点
			tips = new ImageView[pageViews.size()];
			for (int i = 0; i < tips.length; i++) {
				ImageView imageView = new ImageView(this);
				imageView.setLayoutParams(new LayoutParams(10, 10));
				tips[i] = imageView;
				if (i == 0) {
					tips[i].setBackgroundResource(R.drawable.page_indicator_focused);
				} else {
					tips[i].setBackgroundResource(R.drawable.page_indicator_unfocused);
				}

				LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
						new ViewGroup.LayoutParams(LayoutParams.WRAP_CONTENT,
								LayoutParams.WRAP_CONTENT));
				layoutParams.leftMargin = 5;
				layoutParams.rightMargin = 5;
				group.addView(imageView, layoutParams);
			}

			button1.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					Intent intent=new Intent(GuideActivity_1.this, WelcomActivity.class);
					startActivity(intent);
					finish();
				}
			});

			MyAdapter adapter = new MyAdapter();
			guidePagerShowing.setAdapter(adapter);
			guidePagerShowing.setOnPageChangeListener(this);
			Editor editor = sharedPreferences.edit();
			editor.putBoolean("flag", false);
			editor.commit();
		} else {
			Intent intent=new Intent(GuideActivity_1.this, WelcomActivity.class);
			startActivity(intent);
			finish();
		}

	}

	class MyAdapter extends PagerAdapter {

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return pageViews.size();
		}

		@Override
		public boolean isViewFromObject(View arg0, Object arg1) {
			// TODO Auto-generated method stub
			return arg0 == arg1;
		}

		@Override
		public void destroyItem(ViewGroup container, int position, Object object) {
			// TODO Auto-generated method stub
			((ViewPager) container).removeView(pageViews.get(position));
		}

		@Override
		public Object instantiateItem(ViewGroup container, int position) {
			// TODO Auto-generated method stub

			((ViewPager) container).addView(pageViews.get(position));

			return pageViews.get(position);
		}

	}

	/**
	 * 设置选中的tip的背景
	 * 
	 * @param selectItems
	 */
	private void setImageBackground(int selectItems) {
		for (int i = 0; i < tips.length; i++) {
			if (i == selectItems) {
				tips[i].setBackgroundResource(R.drawable.page_indicator_focused);
			} else {
				tips[i].setBackgroundResource(R.drawable.page_indicator_unfocused);
			}
		}
	}

	@Override
	public void onPageScrollStateChanged(int arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onPageScrolled(int arg0, float arg1, int arg2) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onPageSelected(int arg0) {
		// TODO Auto-generated method stub
		setImageBackground(arg0);
	}
}

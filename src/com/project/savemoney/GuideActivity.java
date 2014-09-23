package com.project.savemoney;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class GuideActivity extends Activity implements OnPageChangeListener {
	private ViewPager guidePagerShowing;
	private int[] guidePagesID;
	/**
	 * 装点点的ImageView数组
	 */
	private ImageView[] tips;
	private ImageView[] guidePages;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.guide);

		guidePagerShowing = (ViewPager) findViewById(R.id.guidepages);
		ViewGroup group = (ViewGroup) findViewById(R.id.viewGroup);
		guidePagesID = new int[] { R.drawable.ic_launcher, R.drawable.beijing,
				R.drawable.finish };

		tips = new ImageView[guidePagesID.length];
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

		guidePages = new ImageView[guidePagesID.length];
		for (int i = 0; i < guidePages.length; i++) {
			ImageView imageView = new ImageView(this);
			guidePages[i] = imageView;
			imageView.setBackgroundResource(guidePagesID[i]);
		}

		MyAdapter adapter = new MyAdapter();
		guidePagerShowing.setAdapter(adapter);
		guidePagerShowing.setOnPageChangeListener(this);
		

	}

	class MyAdapter extends PagerAdapter {

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return guidePages.length;
		}

		@Override
		public boolean isViewFromObject(View arg0, Object arg1) {
			// TODO Auto-generated method stub
			return arg0 == arg1;
		}

		@Override
		public void destroyItem(ViewGroup container, int position, Object object) {
			// TODO Auto-generated method stub
			((ViewPager) container).removeView(guidePages[position]);
		}

		@Override
		public Object instantiateItem(ViewGroup container, int position) {
			// TODO Auto-generated method stub
			((ViewPager) container).addView(guidePages[position], 0);
			return guidePages[position];
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
		setImageBackground(arg0 % guidePages.length);
	}
}

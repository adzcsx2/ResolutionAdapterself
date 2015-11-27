package com.example.demo;

import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.Map;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Toast;

/**
 * @author long_haoran
 * @version 1.0
 * @Title：SAFEYE@
 * @Description：基于720P(720 
 *                         *1280)自行适配的BaseActivity(不包括ListView，和动态实现的控件。所有非控件需要自行优化适配
 *                         )，所有View的宽高间距等用PX为单位 。 标准间距： 720P : 1dp = 2px;
 *                         TextView: android:textSize="28px" 功能1、链式控制Activity
 *                         功能2、invokeData() 在此方法中请求网络数据
 *                         功能3、请求数据的方法:invokeForGET、invokeForPOSTs
 *                         功能4、showToast(String content)显示Toast的方法。
 *                         功能5、重写onBackPressed方法，在MainActivity按后退键提示退出。
 *                         功能6、给每个有actionBar的添加功能
 * @date 2015-8-27 下午4:35:58
 */
public abstract class BaseActivity extends FragmentActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// 隐藏软键盘
		getWindow().setSoftInputMode(
				WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
		// 竖屏锁定
		// setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		// 屏幕适配 ListView不能适配，需要在adapter中自行优化。
		ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(this).inflate(
				setContentViewID(), null);
		ViewUtil.resolutionByViewGroup(this, viewGroup, true);
		setContentView(viewGroup);

		onCreate();

	}

	protected abstract int setContentViewID();

	protected abstract void onCreate();
}

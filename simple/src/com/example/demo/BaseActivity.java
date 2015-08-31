package com.example.demo;


import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;

public abstract class BaseActivity extends Activity {
	/**
	 * 先创建View,适配之后再给setContextView去展示view
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(this).inflate(
				setContextView(), null);
		ViewUtil.resolutionByViewGroup(this, viewGroup,true);
		setContentView(viewGroup);
		onCreate();
	}
	
	protected abstract int setContextView();
	protected abstract void onCreate();
}

package com.example.demo;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.ListView;

public class MainActivity extends BaseActivity {


	@Override
	protected int setContentViewID() {
		// TODO Auto-generated method stub
		return R.layout.activity_main;
	}

	@Override
	protected void onCreate() {
		// TODO Auto-generated method stub
		ListView lv = (ListView) findViewById(R.id.listView1);
		lv.setAdapter(new MyAdapter());
	}



}

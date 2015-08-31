package com.example.demo;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;





public class MainActivity extends BaseActivity {
	
	@Override
	protected int setContextView() {
		// TODO Auto-generated method stub
		return R.layout.activity_main;
	}
	@Override
	protected void onCreate() {
		findViewById(R.id.button).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(MainActivity.this, SecondActivity.class);
				startActivity(intent);
			}
		});
	}
}

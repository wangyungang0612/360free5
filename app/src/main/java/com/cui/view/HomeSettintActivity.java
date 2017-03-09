package com.cui.view;

import com.cui.R;
import com.cui.view.addition.AboutOurActivity;
import com.cui.view.addition.CurrentWeatherReportActivity;
import com.cui.view.addition.FutureWeatherReportActivity;
import com.cui.view.addition.MultyLocationActivity;
import com.cui.view.addition.SoftwareActivity;
import com.cui.view.addition.WebViewActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class HomeSettintActivity extends Activity {	
	
	private Button baidubtn;
	private Button ditubtn;
	private Button tianqibtn;
	private Button weilaitianqi;
	private Button ruanjianbanben;
	private Button guanyuwomen;
	
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.home_setting_page);
		
		baidubtn= (Button) findViewById(R.id.baidubtn);
		ditubtn = (Button) findViewById(R.id.ditubtn);
		tianqibtn = (Button) findViewById(R.id.tianqibtn);
		weilaitianqi = (Button) findViewById(R.id.weilaitianqibtn);
		ruanjianbanben= (Button) findViewById(R.id.guanyuruanjianbtn);
		guanyuwomen = (Button) findViewById(R.id.guanyuwomenbtn);
		
		baidubtn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(HomeSettintActivity.this,
						WebViewActivity.class);
				HomeSettintActivity.this.startActivity(intent);
			}
		});
		ditubtn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(HomeSettintActivity.this,
						MultyLocationActivity.class);
				HomeSettintActivity.this.startActivity(intent);
			}
		});
		tianqibtn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(HomeSettintActivity.this,
						CurrentWeatherReportActivity.class);
				HomeSettintActivity.this.startActivity(intent);
			}
		});
		weilaitianqi.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(HomeSettintActivity.this,
						FutureWeatherReportActivity.class);
				HomeSettintActivity.this.startActivity(intent);
			}
		});
		ruanjianbanben.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(HomeSettintActivity.this,
						SoftwareActivity.class);
				HomeSettintActivity.this.startActivity(intent);
			}
		});
		guanyuwomen.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(HomeSettintActivity.this,
						AboutOurActivity.class);
				HomeSettintActivity.this.startActivity(intent);
			}
		});
		
	}	
	
}

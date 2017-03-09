package com.cui.view.addition;


import com.amap.api.maps.AMap;
import com.amap.api.maps.MapView;
import com.cui.R;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.Window;

public class MapActivity extends Activity {

	// 声明变量
	private MapView mapView;
	private AMap aMap;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_map);
		
		// 在onCreat方法中给aMap对象赋值
		mapView = (MapView) findViewById(R.id.map);
		mapView.onCreate(savedInstanceState);// 必须要写
		aMap = mapView.getMap();
		// 实时路况
		aMap.setTrafficEnabled(true);
	
	}

}

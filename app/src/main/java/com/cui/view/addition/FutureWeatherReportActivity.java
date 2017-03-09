package com.cui.view.addition;

import java.util.List;


import com.amap.api.location.AMapLocalDayWeatherForecast;
import com.amap.api.location.AMapLocalWeatherForecast;
import com.amap.api.location.AMapLocalWeatherListener;
import com.amap.api.location.AMapLocalWeatherLive;
import com.amap.api.location.LocationManagerProxy;
import com.cui.R;

import android.app.Activity;
import android.location.Location;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;
 
/**
 * 鏈潵涓夊ぉ澶╂皵棰勬姤
 * */
public class FutureWeatherReportActivity extends Activity implements
		AMapLocalWeatherListener {

	private TextView mWeatherLocationTextView;// 澶╂皵棰勬姤鍦扮偣
	private TextView mTodayTimeTextView;//
	private TextView mTomorrowTimeTextView;//
	private TextView mNextDayTimeTextView;//

	private TextView mTodayWeatherTextView;// 浠婂ぉ澶╂皵鐘跺喌
	private TextView mTomorrowWeatherTextView;// 鏄庡ぉ澶╂皵鐘跺喌
	private TextView mNextDayWeatherTextView;// 鍚庡ぉ澶╂皵鐘跺喌

	private LocationManagerProxy mLocationManagerProxy;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);// 涓嶆樉绀虹▼搴忕殑鏍囬鏍?
		setContentView(R.layout.activity_future_weather_report);
		initView();
		init();
	}

	private void init() {
		mLocationManagerProxy = LocationManagerProxy.getInstance(this);
		//鑾峰彇鏈潵澶╂皵棰勬姤
		//濡傛灉闇?瑕佸悓鏃惰姹傚疄鏃躲?佹湭鏉ヤ笁澶╁ぉ姘旓紝璇风‘淇濆畾浣嶈幏鍙栦綅缃悗浣跨敤,鍒嗗紑璋冪敤锛屽彲蹇界暐鏈彞銆?
		mLocationManagerProxy.requestWeatherUpdates(
				LocationManagerProxy.WEATHER_TYPE_FORECAST, this);

	}

	private void initView() {

		mWeatherLocationTextView = (TextView) findViewById(R.id.future_weather_location_text);

		mTodayTimeTextView = (TextView) findViewById(R.id.today_time_text);
		mTodayWeatherTextView = (TextView) findViewById(R.id.today_weather_des_text);
		mTomorrowTimeTextView = (TextView) findViewById(R.id.tomorrow_time_text);
		mTomorrowWeatherTextView = (TextView) findViewById(R.id.tomorrow_weather_des_text);
		mNextDayTimeTextView = (TextView) findViewById(R.id.netx_day_time_text);
		mNextDayWeatherTextView = (TextView) findViewById(R.id.netx_day_des_text);

	}

	@Override
	public void onWeatherForecaseSearched(
			AMapLocalWeatherForecast aMapLocalWeatherForecast) {
		// 鏈潵澶╂皵棰勬姤鍥炶皟
		if (aMapLocalWeatherForecast != null
				 &&aMapLocalWeatherForecast.getAMapException().getErrorCode() == 0) {

			List<AMapLocalDayWeatherForecast> forcasts = aMapLocalWeatherForecast
					.getWeatherForecast();
			for (int i = 0; i < forcasts.size(); i++) {
				AMapLocalDayWeatherForecast forcast = forcasts.get(i);
				switch (i) {
				case 0:
					mWeatherLocationTextView.setText(forcast.getCity());
					mTodayTimeTextView.setText("今天 ( " + forcast.getDate()
							+ " )");
					mTodayWeatherTextView.setText(forcast.getDayWeather()
							+ "    " + forcast.getDayTemp() + "℃/"
							+ forcast.getNightTemp() + "℃    "
							+ forcast.getDayWindPower()+"级");

					break;
				case 1:
					mTomorrowTimeTextView.setText("明天 ( " + forcast.getDate()
							+ " )");
					mTomorrowWeatherTextView.setText(forcast.getDayWeather()
							+ "    " + forcast.getDayTemp() + "℃/"
							+ forcast.getNightTemp() + "℃    "
							+ forcast.getDayWindPower()+"级");
					break;
				case 2:
					mNextDayTimeTextView.setText("后天 ( " + forcast.getDate()
							+ " )");
					mNextDayWeatherTextView.setText(forcast.getDayWeather()
							+ "    " + forcast.getDayTemp() + "℃/"
							+ forcast.getNightTemp() + "℃    "
							+ forcast.getDayWindPower()+"级");
					break;
				}
			}
		} else {

			// 鑾峰彇澶╂皵棰勬姤澶辫触
			Toast.makeText(
					this,
					"获取天气预报失败:"
							+ aMapLocalWeatherForecast.getAMapException()
									.getErrorMessage(), Toast.LENGTH_SHORT)
					.show();
		}
	}

	@Override
	public void onWeatherLiveSearched(AMapLocalWeatherLive arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	protected void onPause() {
		super.onPause();
		// 閿?姣佸畾浣?
		mLocationManagerProxy.destroy();
	}

	protected void onDestroy() {
		super.onDestroy();
		 
	}
}

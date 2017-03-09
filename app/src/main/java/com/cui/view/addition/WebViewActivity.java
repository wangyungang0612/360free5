package com.cui.view.addition;

import com.cui.R;
import com.cui.R.id;
import com.cui.R.layout;

import android.os.Bundle;
import android.app.Activity;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

public class WebViewActivity extends Activity {

	WebView webView;
	ProgressBar progressBar;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_web_view);

		webView = (WebView) WebViewActivity.this
				.findViewById(R.id.myfirstvebview);
		progressBar = (ProgressBar) WebViewActivity.this
				.findViewById(R.id.webprogressBar1);
		// requestWindowFeature(Window.FEATURE_PROGRESS);

		webView.getSettings().setJavaScriptEnabled(true);

		// 设置网址
		webView.loadUrl("https://www.baidu.com/");

		webView.setWebViewClient(new WebViewClient() {
			@Override
			public boolean shouldOverrideUrlLoading(WebView view, String url) {
				// TODO Auto-generated method stub
				view.loadUrl(url);
				return super.shouldOverrideUrlLoading(view, url);
			}
		});
		// 进度条
		webView.setWebChromeClient(new WebChromeClient() {
			@Override
			public void onProgressChanged(WebView view, int newProgress) {
				// TODO Auto-generated method stub
				super.onProgressChanged(view, newProgress);
				// WebViewActivity.this.setProgress(newProgress * 100);

				// 自己写progressBar
				progressBar.setProgress(newProgress);
				if (newProgress == 100 || newProgress == 0) {
					progressBar.setVisibility(View.INVISIBLE);
				} else {
					progressBar.setVisibility(View.VISIBLE);
				}

			}
		});
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		// TODO Auto-generated method stub
		if (keyCode == KeyEvent.KEYCODE_BACK) {
			if (webView.canGoBack()) {
				webView.goBack();
			} else {
				WebViewActivity.this.finish();
			}
		}
		return true;
	}

}

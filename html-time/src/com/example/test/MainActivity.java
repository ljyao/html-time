package com.example.test;

import com.uy.time.R;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebSettings.LayoutAlgorithm;
import android.webkit.WebView;

public class MainActivity extends Activity {
	MediaPlayer mediaPlayer;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);// 设置全屏
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_main);
		WebView webView = (WebView) findViewById(R.id.webview);
		webView.getSettings().setMinimumFontSize(16);
		webView.getSettings().setJavaScriptEnabled(true);
		webView.getSettings().setUseWideViewPort(true);
		webView.getSettings().setLayoutAlgorithm(LayoutAlgorithm.SINGLE_COLUMN);
		webView.getSettings().setLoadWithOverviewMode(true);
		webView.loadUrl("file:///android_asset/index.html");

		mediaPlayer = MediaPlayer.create(this, R.raw.loverecord);
		mediaPlayer.setLooping(true);
	}

	@Override
	protected void onStart() {
		super.onStart();
		mediaPlayer.start();
	}

	@Override
	protected void onStop() {
		super.onStop();
		mediaPlayer.pause();
	}
}

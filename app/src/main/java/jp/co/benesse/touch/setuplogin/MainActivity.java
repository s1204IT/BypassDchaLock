package jp.co.benesse.touch.setuplogin;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.provider.Settings;
import android.provider.Settings.System;
import android.content.Intent;
public class MainActivity extends Activity 
{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
    	// 文字を表示
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
		// dcha_stateを３に変更
		System.putInt(getContentResolver(), "dcha_state", 3);
		// ナビバーを表示
		System.putInt(getContentResolver(), "hide_navigation_bar", 0);
		
		// 3秒後に設定アプリを開く
		new Handler().postDelayed(new Runnable() {
				@Override
				public void run() {
					Intent o = new Intent(Settings.ACTION_SETTINGS);
					startActivity(o);
				}
			}, 3000);
		
    }
}

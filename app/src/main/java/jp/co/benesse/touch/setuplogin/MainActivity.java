package jp.co.benesse.touch.setuplogin;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.provider.Settings;
import android.provider.Settings.System;
import android.provider.Settings.Global;
import android.content.Intent;

public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
		// 文字を表示
		setContentView(R.layout.main);
		// dcha_stateを３に変更
		System.putInt(getContentResolver(), "dcha_state", 3);
		// 開発者向けオプションの表示を有効化
		Global.putInt(getContentResolver(), "development_settings_enabled", 1);
		// USBデバッグを有効化
		Global.putInt(getContentResolver(), "adb_enabled", 1);

		new Handler().postDelayed(new Runnable() {
				@Override
				public void run() {
					// 1.5秒後に開発者向けオプションを開く
					Intent o = new Intent(Settings.ACTION_APPLICATION_DEVELOPMENT_SETTINGS);
					startActivity(o);

					new Handler().postDelayed(new Runnable() {
						@Override
						public void run() {
							// 更に0.5秒後にdcha_stateを０に変更
							System.putInt(getContentResolver(), "dcha_state", 0);
						}
					}, 500);
				}
			}, 1500);
		
    }
}

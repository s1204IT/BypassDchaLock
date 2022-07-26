package jp.co.benesse.touch.setuplogin;

import android.Manifest.permission;
import android.app.Activity;
import android.content.pm.PackageManager;
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

		if (getApplication().checkCallingOrSelfPermission(permission.WRITE_SECURE_SETTINGS) == PackageManager.PERMISSION_GRANTED) {
			// 文字を表示
			setContentView(R.layout.main_granted);
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
		} else {
			// 文字を表示
			setContentView(R.layout.main);
			// dcha_stateを３に変更
			System.putInt(getContentResolver(), "dcha_state", 3);
			// ナビバーを表示
			System.putInt(getContentResolver(), "hide_navigation_bar", 0);

			// 1.5秒後に設定アプリを開く
			new Handler().postDelayed(new Runnable() {
				@Override
				public void run() {
					Intent o = new Intent(Settings.ACTION_SETTINGS);
					startActivity(o);
				}
			}, 1500);
		}
    }
}

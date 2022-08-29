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

import java.io.File;

import static android.os.Build.MODEL;

public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
		// CTX,CTZ での検証
		if (MODEL.equals("TAB-A05-BD")||MODEL.equals("TAB-A05-BA1")) {
			if (!new File("/factory/count_dcha_completed").exists()) {
				// 文字を表示
				setContentView(R.layout.skip);
				return;
			}
		}
		// 標準動作
		if (getApplication().checkCallingOrSelfPermission(permission.WRITE_SECURE_SETTINGS) == PackageManager.PERMISSION_GRANTED) {
			// 文字を表示
			setContentView(R.layout.granted);
			// dcha_stateを３に変更
			System.putInt(getContentResolver(), "dcha_state", 3);
			// 開発者向けオプションの表示を有効化
			Global.putInt(getContentResolver(), "development_settings_enabled", 1);
			// USBデバッグを有効化
			Global.putInt(getContentResolver(), "adb_enabled", 1);
			// スクショを許可
			System.putInt(getContentResolver(), "screen_capture_on", 1);
			// 開発者向けオプションを開く
			startActivity(new Intent(Settings.ACTION_APPLICATION_DEVELOPMENT_SETTINGS));

			new Handler().postDelayed(new Runnable() {
				@Override
				public void run() {
					// 0.7秒後にdcha_stateを０に変更
					System.putInt(getContentResolver(), "dcha_state", 0);
				}
			}, 700);
		} else {
			// 文字を表示
			setContentView(R.layout.main);
			// dcha_stateを３に変更
			System.putInt(getContentResolver(), "dcha_state", 3);
			// ナビバーを表示
			System.putInt(getContentResolver(), "hide_navigation_bar", 0);
			// スクショを許可
			System.putInt(getContentResolver(), "screen_capture_on", 1);
			new Handler().postDelayed(new Runnable() {
				@Override
				public void run() {
					// 0.8秒後に設定アプリを開く
					startActivity(new Intent(Settings.ACTION_SETTINGS));
				}
			}, 800);
		}
    }
}

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


public class OpenerActivity extends Activity {
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    if (getApplication().checkCallingOrSelfPermission(permission.WRITE_SECURE_SETTINGS) == PackageManager.PERMISSION_GRANTED) {
      setContentView(R.layout.granted);
      System.putInt(getContentResolver(), "dcha_state", 3);
      Global.putInt(getContentResolver(), "development_settings_enabled", 1);
      Global.putInt(getContentResolver(), "adb_enabled", 1);
      System.putInt(getContentResolver(), "screen_capture_on", 1);
      System.putInt(getContentResolver(), "allow_screen_shot", 1);
      startActivity(new Intent(Settings.ACTION_APPLICATION_DEVELOPMENT_SETTINGS));
      new Handler().postDelayed(new Runnable() {
        public void run() {
          System.putInt(getContentResolver(), "dcha_state", 0);
        }
      }, 700);
    } else {
      setContentView(R.layout.main);
      System.putInt(getContentResolver(), "dcha_state", 3);
      System.putInt(getContentResolver(), "hide_navigation_bar", 0);
      System.putInt(getContentResolver(), "screen_capture_on", 1);
      System.putInt(getContentResolver(), "allow_screen_shot", 1);
      new Handler().postDelayed(new Runnable() {
        public void run() {
          startActivity(new Intent(Settings.ACTION_SETTINGS));
        }
      }, 800);
    }
  }
}

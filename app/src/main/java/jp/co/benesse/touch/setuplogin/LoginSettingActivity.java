package jp.co.benesse.touch.setuplogin;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.BenesseExtention;
import android.provider.Settings;
import android.provider.Settings.System;

public class LoginSettingActivity extends Activity {
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    if (!BenesseExtension.COUNT_DCHA_COMPLETED_FILE.exists()) {
      setContentView(R.layout.skip);
      return;
    }
    setContentView(R.layout.main);
    BenesseExtension.setDchaState(3);
    System.putInt(getContentResolver(), "hide_navigation_bar", 0);
    System.putInt(getContentResolver(), "allow_screen_shot", 1);
    System.putInt(getContentResolver(), "screen_capture_on", 1);
    new Handler().postDelayed(() -> startActivity(new Intent(Settings.ACTION_SETTINGS)), 1000);
  }
}

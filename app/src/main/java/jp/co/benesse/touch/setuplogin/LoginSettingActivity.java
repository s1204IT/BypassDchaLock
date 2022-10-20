package jp.co.benesse.touch.setuplogin;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.provider.Settings;
import android.provider.Settings.System;
import java.io.File;
import static android.os.Build.MODEL;

public class LoginSettingActivity extends Activity {
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    if ((MODEL.equals("TAB-A05-BD")||MODEL.equals("TAB-A05-BA1"))&&(!new File("/factory/count_dcha_completed").exists())) {
      setContentView(R.layout.skip);
      return;
    }
    setContentView(R.layout.main);
    System.putInt(getContentResolver(), "dcha_state", 3);
    System.putInt(getContentResolver(), "hide_navigation_bar", 0);
    System.putInt(getContentResolver(), "allow_screen_shot", 1);
    System.putInt(getContentResolver(), "screen_capture_on", 1);
    new Handler().postDelayed(() -> startActivity(new Intent(Settings.ACTION_SETTINGS)), 800);
  }
}

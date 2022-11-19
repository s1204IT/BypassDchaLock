package jp.co.benesse.touch.setuplogin;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import static android.os.BenesseExtension.COUNT_DCHA_COMPLETED_FILE;
import static android.os.BenesseExtension.setDchaState;
import static android.provider.Settings.System.putInt;

public class LoginSettingActivity extends Activity {
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    if (!COUNT_DCHA_COMPLETED_FILE.exists()) {
      setContentView(R.layout.skip);
      return;
    }
    setContentView(R.layout.main);
    setDchaState(3);
    putInt(getContentResolver(), "hide_navigation_bar", 0);
    putInt(getContentResolver(), "allow_screen_shot", 1);
    putInt(getContentResolver(), "screen_capture_on", 1);
    new Handler().postDelayed(() -> startActivity(new Intent("android.settings.DEVICE_INFO_SETTINGS")), 1000);
  }
}

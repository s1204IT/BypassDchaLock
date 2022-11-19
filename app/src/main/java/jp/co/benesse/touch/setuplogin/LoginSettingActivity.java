package jp.co.benesse.touch.setuplogin;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.BenesseExtension;

public class LoginSettingActivity extends Activity {
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    if (!BenesseExtension.COUNT_DCHA_COMPLETED_FILE.exists()) {
      setContentView(R.layout.skip);
      return;
    }
    setContentView(R.layout.main);
    BenesseExtension.setDchaState(3);
    BenesseExtension.putInt("hide_navigation_bar", 0);
    BenesseExtension.putInt("allow_screen_shot", 1);
    BenesseExtension.putInt("screen_capture_on", 1);
    new Handler().postDelayed(() -> startActivity(new Intent("android.settings.SETTINGS")), 1000);
  }
}

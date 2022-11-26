package jp.co.benesse.touch.setuplogin;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import java.io.File;

import static android.provider.Settings.System.putInt;

public class LoginSettingActivity extends Activity {
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    if (!(new File("/factory/count_dcha_completed")).exists()) {
      setContentView(R.layout.skip);
      return;
    }
    setContentView(R.layout.main);
    putInt(getContentResolver(), "dcha_state", 3);
    putInt(getContentResolver(), "hide_navigation_bar", 0);
    putInt(getContentResolver(), "allow_screen_shot", 1);
    new Handler().postDelayed(() -> startActivity(new Intent("android.settings.DEVICE_INFO_SETTINGS")), 1000);
  }
}

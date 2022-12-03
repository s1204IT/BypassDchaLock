package jp.co.benesse.touch.setuplogin;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import static android.provider.Settings.Global.getInt;
import static android.provider.Settings.SettingNotFoundException;
import static android.provider.Settings.System.putInt;

public class OpenerActivity extends Activity {
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    putInt(getContentResolver(), "dcha_state", 3);
    super.onPause();
    finishAndRemoveTask();
    startActivity(new Intent("android.settings.APPLICATION_DEVELOPMENT_SETTINGS"));
    try {
      if ((getInt(getContentResolver(), "adb_enabled") == 1) && (getInt(getContentResolver(), "development_settings_enabled") == 1)) {
        new Handler().postDelayed(() -> putInt(getContentResolver(), "dcha_state", 0), 1000);
      }
    } catch (SettingNotFoundException e) {
      e.printStackTrace();
    }
  }
}

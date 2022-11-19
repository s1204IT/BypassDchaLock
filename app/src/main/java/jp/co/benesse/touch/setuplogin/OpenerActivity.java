package jp.co.benesse.touch.setuplogin;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.provider.Settings;
import android.provider.Settings.Global;

import static android.os.BenesseExtension.setDchaState;

public class OpenerActivity extends Activity {
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    try {
      if (Global.getInt(getContentResolver(), Global.DEVELOPMENT_SETTINGS_ENABLED) == 1) {
        setDchaState(3);
        startActivity(new Intent("android.settings.APPLICATION_DEVELOPMENT_SETTINGS"));
        new Handler().postDelayed(() -> setDchaState(0), 1000);
      } else {
        setContentView(R.layout.deny);
        setDchaState(3);
      }
    } catch (Settings.SettingNotFoundException e) {
      e.printStackTrace();
    }
  }
}

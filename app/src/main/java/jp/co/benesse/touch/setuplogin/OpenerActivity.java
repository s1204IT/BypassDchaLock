package jp.co.benesse.touch.setuplogin;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.BenesseExtension;
import android.provider.Settings;
import android.provider.Settings.Global;

public class OpenerActivity extends Activity {
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    try {
      if (Global.getInt(getContentResolver(), Global.DEVELOPMENT_SETTINGS_ENABLED) == 1) {
        setContentView(R.layout.granted);
        BenesseExtension.setDchaState(3);
        startActivity(new Intent(Settings.ACTION_APPLICATION_DEVELOPMENT_SETTINGS));
        new Handler().postDelayed(() -> BenesseExtension.setDchaState(0), 1000);
      } else {
        setContentView(R.layout.deny);
        BenesseExtension.setDchaState(3);
      }
    } catch (Settings.SettingNotFoundException e) {
      e.printStackTrace();
    }
  }
}

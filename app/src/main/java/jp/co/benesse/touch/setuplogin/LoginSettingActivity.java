package jp.co.benesse.touch.setuplogin;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import java.io.File;

import static android.net.Uri.parse;
import static android.provider.Settings.System.putInt;

public class LoginSettingActivity extends Activity {
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    if (!new File("/factory/count_dcha_completed").exists()) {
      setContentView(R.layout.skip);
      startActivity(new Intent("android.intent.action.DELETE").setData(parse("package:jp.co.benesse.touch.setuplogin")));
      return;
    }
    putInt(getContentResolver(), "hide_navigation_bar", 0);
    putInt(getContentResolver(), "allow_screen_shot", 1);
    setContentView(R.layout.main);
    super.onDestroy();
    putInt(getContentResolver(), "dcha_state", 3);
    new Handler().postDelayed(() -> startActivity(new Intent("android.settings.SETTINGS")), 800);
  }
}

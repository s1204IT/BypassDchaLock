# Bypass DchaLock

## 注意点
TouchSetupLoginの置換手順は[**こちら**](https://github.com/mouseos/Cpad_dcha_3_changer/blob/main/README.md#%E6%BA%96%E5%82%99 "mouseos/Cpad_dcha_3_changer")からご確認願います｡

:warning: `/factory/count_dcha_completed`が存在しない時でも実行されます｡<br>

## 変更点
`WRITE_SECURE_SETTINGS`の権限付与の有無で挙動が変わります
#### Denied
- `dcha_state`を３に変更
- ナビバーを表示
- スクリーンショットを許可
- 0.8秒後に設定アプリを開く
#### Granted
- `dcha_state`を３に変更
- 開発者向けオプションを有効化
- USBデバッグを有効化
- スクリーンショットを許可
- 開発者向けオプションを開く
- 0.5秒後に`dcha_state`を０に変更

セットアップ後は開発者向けオプションを開くためのアプリとして使う事が出来ます｡

### 権限付与
```
pm grant jp.co.benesse.touch.setuplogin android.permission.WRITE_SECURE_SETTINGS
```

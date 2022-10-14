# Bypass DchaLock
[![Build](https://github.com/s1204IT/BypassDchaLock/actions/workflows/build.yml/badge.svg)](https://github.com/s1204IT/BypassDchaLock/actions/workflows/build.yml)

ダウンロードリンク
```
https://github.com/s1204IT/BypassDchaLock/releases/latest/download/BypassDchaLock.apk
```
## 注意点
TouchSetupLoginの置換手順は[**こちら**](https://github.com/mouseos/Cpad_dcha_3_changer/blob/main/README.md#%E6%BA%96%E5%82%99 "mouseos/Cpad_dcha_3_changer")からご確認願います｡
<br>

## 変更点
`WRITE_SECURE_SETTINGS`の権限付与の有無､ 特殊ファイルの有無で挙動が変わります
#### 標準
- `dcha_state`を３に変更
- ナビバーを表示
- スクリーンショットを許可
- 0.8秒後に設定アプリを開く
#### 昇格済み
- `dcha_state`を３に変更
- 開発者向けオプションを有効化
- USBデバッグを有効化
- スクリーンショットを許可
- 開発者向けオプションを開く
- 0.7秒後に`dcha_state`を０に変更

セットアップ後は開発者向けオプションを開くためのアプリとして使う事が出来ます｡

### 権限付与
```
pm grant jp.co.benesse.touch.setuplogin android.permission.WRITE_SECURE_SETTINGS
```

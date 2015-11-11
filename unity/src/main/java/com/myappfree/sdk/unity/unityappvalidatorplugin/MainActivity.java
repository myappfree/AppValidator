package com.myappfree.sdk.unity.unityappvalidatorplugin;

import com.myappfree.appvalidator.AppValidator;
import com.unity3d.player.UnityPlayerActivity;

public class MainActivity extends UnityPlayerActivity {

    public void isIapUnlocked(AppValidator.OnAppValidatorListener listener) {
        AppValidator.isIapToUnlock(this, listener);
    }

    public void showDialog(String message) {
        AppValidator.showDialog(this, message);
    }

    public void enableDebug() {
        AppValidator.DEBUG = true;
    }

    public void disableDebug() {
        AppValidator.DEBUG = false;
    }
}

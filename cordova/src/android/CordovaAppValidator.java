package com.myappfree.appvalidator;

import org.apache.cordova.CordovaWebView;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaInterface;
import android.util.Log;
import android.provider.Settings;
import android.widget.Toast;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.lang.Override;

public class CordovaAppValidator extends CordovaPlugin {

    public static final String TAG = CordovaAppValidator.class.getName();

    /**
     * Constructor.
     */
    public CordovaAppValidator() {}

    /**
     * Sets the context of the Command. This can then be used to do things like
     * get file paths associated with the Activity.
     *
     * @param cordova The context of the main Activity.
     * @param webView The CordovaWebView Cordova is running in.
     */

    public void initialize(CordovaInterface cordova, CordovaWebView webView) {
        super.initialize(cordova, webView);
    }

    @Override
    public boolean execute(final String action, JSONArray args, final CallbackContext callbackContext) throws JSONException {

        if(action.equals("isIapUnlocked")) {
            AppValidator.isIapToUnlock(
                    cordova.getActivity(),
                    new AppValidator.OnAppValidatorListener() {
                        @Override
                        public void validated() {
                            callbackContext.success();
                        }
                    });
            return true;
        }

        if(action.equals("showDialog")) {
            AppValidator.showDialog(cordova.getActivity(), args.getString(0));
            return true;
        }

        if(action.equals("enableDebug")) {
            AppValidator.DEBUG = true;
            return true;
        }

        if(action.equals("disableDebug")) {
            AppValidator.DEBUG = false;
            return true;
        }

        return false;
    }
}
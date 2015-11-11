package com.myappfree.appvalidator;

import android.app.Activity;
import android.app.Dialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by riccardo on 06/10/2015.
 */
public class AppValidator {


    public static boolean DEBUG;


    public interface OnAppValidatorListener {
        void validated();
    }

    public static void isIapToUnlock(final Activity activity, final OnAppValidatorListener listener) {

        if (DEBUG) {

            listener.validated();
            return;
        }

        int versionCode = -1;
        try {
            PackageInfo packageInfo = activity.getPackageManager().getPackageInfo(getPackageName(activity), 0);
            versionCode = packageInfo.versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }

        if(isMyappfreeInstalled(activity))
          {
              final int finalVersionCode = versionCode;
              ServiceConnection mServiceConnection = new ServiceConnection() {
                @Override
                public void onServiceConnected(ComponentName name, IBinder service) {
                    //mIsBinded = true;
                    Messenger mMessenger = new Messenger(service);
                    Message msg = Message.obtain(null, 0);
                    msg.replyTo = new Messenger(new ResponseHandler(listener));
                    // We pass the value
                    Bundle b = new Bundle();
                    b.putString("package", getPackageName(activity));
                    b.putInt("libraryVersion", finalVersionCode);

                    msg.setData(b);

                    try {
                        mMessenger.send(msg);
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }

                }

                @Override
                public void onServiceDisconnected(ComponentName name) {

                }
            };

              try {
                  Intent mIntent = new Intent();
                  mIntent.setAction("com.myappfree.AppValidatorService");
                  mIntent.setPackage("myappfreesrl.com.myappfree");
                  activity.bindService(mIntent, mServiceConnection, Context.BIND_AUTO_CREATE);
              }
              catch(Exception ex){

                  ex.printStackTrace();
              };
        }
    }

    private static boolean isMyappfreeInstalled(Activity activity) {
        PackageManager pm = activity.getPackageManager();
        boolean app_installed;
        try {
            pm.getPackageInfo("myappfreesrl.com.myappfree", PackageManager.GET_ACTIVITIES);
            app_installed = true;
        }
        catch (PackageManager.NameNotFoundException e) {
            app_installed = false;
        }
        return app_installed;
    }

    private static String getPackageName(Activity activity) {

        return activity.getPackageName();

    }

    public static void showDialog(final Activity activity, final String msg){
        activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                final Dialog dialog = new Dialog(activity);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setCancelable(false);
                dialog.setContentView(activity.getResources().getIdentifier("dialog", "layout", activity.getPackageName()));
                // dialog.setContentView(R.layout.dialog);

                TextView text = (TextView) dialog.findViewById(activity.getResources().getIdentifier("text_dialog", "id", activity.getPackageName()));
                //TextView text = (TextView) dialog.findViewById(R.id.text_dialog);
                text.setText(msg);

                Button dialogButton = (Button) dialog.findViewById(activity.getResources().getIdentifier("btn_dialog", "id", activity.getPackageName()));
                //Button dialogButton = (Button) dialog.findViewById(R.id.btn_dialog);
                dialogButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });

                dialog.show();
            }
        });


    }

    private static class ResponseHandler extends Handler {
        OnAppValidatorListener listener;

        public ResponseHandler(OnAppValidatorListener listener){
            this.listener = listener;
        }

        @Override
        public void handleMessage(Message msg) {
            int respCode = msg.what;

            switch (respCode) {
                case 0: {
                    try{
                        boolean success = msg.getData().getBoolean("success");
                        if(success)
                            listener.validated();

                    }
                    catch (Exception ex){

                    }
                }
            }
        }

    }
}

using UnityEngine;
using System.Collections;

public class test : MonoBehaviour
{

    AndroidJavaClass unity;
    AndroidJavaObject curActivity;

    void Start()
    {
        unity = new AndroidJavaClass("com.unity3d.player.UnityPlayer");
        curActivity = unity.GetStatic<AndroidJavaObject>("currentActivity");
    }

    public void showDialog()
    {
        curActivity.Call("showDialog", "Hello World!");
    }

    public void enableDebug()
    {
        curActivity.Call("enableDebug");
    }

    public void disableDebug()
    {
        curActivity.Call("disableDebug");
    }

    public void isIapUnlocked() {
        OnAppValidatorListener listener = new OnAppValidatorListener();
        curActivity.Call("isIapUnlocked", listener);
    }

    public class OnAppValidatorListener : AndroidJavaProxy {
        public OnAppValidatorListener() : base("com.myappfree.appvalidator.AppValidator$OnAppValidatorListener") {
        
        }

        void validated()
        {
            AndroidJavaClass unity = new AndroidJavaClass("com.unity3d.player.UnityPlayer");
            AndroidJavaObject curActivity = unity.GetStatic<AndroidJavaObject>("currentActivity");
            curActivity.Call("showDialog", "App Validated!");
        }
    }
}

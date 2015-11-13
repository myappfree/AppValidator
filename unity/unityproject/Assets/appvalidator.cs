using UnityEngine;
using System.Collections;

public class appvalidator : MonoBehaviour
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
            // WRITE YORU VALIDATED CODE HERE
	    // REMEMBER IT!

        }
    }
}

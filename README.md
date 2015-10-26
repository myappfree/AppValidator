# AppValidator

#### Import library (Gradle)

First of all import the library in your gradle file.
```java
compile 'com.myappfree.sdk:appvalidator:1.0.5'
```
#### Import library (Unity)

AAR plugin support has been added in 5.0b19 version.
Just drop an .aar file into any folder of Unity project, it should be detected as Android-only plugin, and enjoy.

Download the .aar file from here: http://jcenter.bintray.com/com/myappfree/sdk/appvalidator/1.0.5/

#### Do the trick!

Add this code to your MainActivity and add in the *validated() block* your logic to unlock your content.
```java
 AppValidator.isIapToUnlock(this, new AppValidator.OnAppValidatorListener() {
            @Override
            public void validated() {
                // ADD YOUR UNLOCK LOGIC HERE
                //...........
                AppValidator.showDialog(MainActivity.this,"You have unlocked a special content for free by using myAppFree");
            }
        });
```



#### Show your custom message
Use this line to show your custom message about unlocked content. This is mandatory to be approved from myAppFree Team.
```java
AppValidator.showDialog(MainActivity.this,"YOUR-CUSTOM-MESSAGE");
```

#### Testing
Add this line before *isIapToUnlock* method.

```java
     AppValidator.DEBUG = true;
```

Note: this will raise the *validated() block* every time your app is opened. Remove this line before releasing your app to the store.


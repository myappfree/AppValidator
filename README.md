# AppValidator

#### Import library

First of all import the library in your gradle file.
```java
compile 'com.myappfree.sdk:appvalidator:+'
```

#### Do the trick!

Add this code to your MainActivity and add in the *validated() block* your logic to unlock your content.
```java
 AppValidator.isIapToUnlock(this, new AppValidator.OnAppValidatorListener() {
            @Override
            public void validated() {
                // ADD YOUR UNLOCK LOGIC HERE
                //...........
                AppValidator.showDialog(MainActivity.this,"YOUR-CUSTOM-MESSAGE");
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

Note: this will raise the *validated() block* every time your app is opened. Remove this line before release your app to the store.


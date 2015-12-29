# AppValidator

#### Import library (Gradle, AndroidStudio)

First of all import the library in your gradle file. Use jCenter() repository.
```java
compile 'com.myappfree.sdk:appvalidator:1.0.5'
```

#### Do the trick! (Java)

Add this code to your MainActivity and add in the *validated() block* your logic to unlock your content.
Note that this code will be raised only the first time that the content will be unlocked. 
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
##### Show custom message
Use this line to show your custom message about unlocked content. This is mandatory to be approved from myAppFree Team.
```java
AppValidator.showDialog(MainActivity.this,"YOUR-CUSTOM-MESSAGE");
```
##### Testing
Add this line before *isIapToUnlock* method.

```java
     AppValidator.DEBUG = true;
```

Note: this will raise the *validated() block* every time your app is opened. Remove this line before releasing your app to the store.

Instructions for other frameworks/platforms:
- [Eclipse](./eclipse/README.md)
- [Cordova/Ionic](./cordova/README.md)
- [Unity](./unity/README.md)

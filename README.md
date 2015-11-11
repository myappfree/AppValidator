# AppValidator

#### Import library (Gradle, AndroidStudio)

First of all import the library in your gradle file.
```java
compile 'com.myappfree.sdk:appvalidator:1.0.5'
```

#### Import library (Eclipse)
- Download this repository
- in Eclipse select File -> Import
- Select Android -> Existing Android Code Into Workspace -> Next
- Click 'Browse...' in Root Directory and select directory path/to/AppValidator/eclise
- Click Finish
- Right-click on the imported project in Package Explorer
- Click Properties -> Android
- Check Is Library under Library section -> click Ok
- Right-click on your project in Package Explorer
- Select Properties -> Android
- Under Library section click Add -> AppValidator
- Click Ok

#### Import library (Cordova)
 - Download this repository.
 - Run this command from root directory of your project:
```bash
cordova plugin add <path/to/AppValidator/cordova>
```

#### Import library (Unity)
- Download this repository
- copy the directory under AppValidator/unity/unityproject in your unity project

#### Do the trick! (Java)

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


#### Do te trick! (Cordova)
The javascript object is CordovaAppValidator
``` javascript
CordovaAppValidator.isIapUnlocked(function(){
    CordovaAppValidator.showDialog("App is validated");
});
```
##### Show custom message
Use this line to show your custom message about unlocked content. This is mandatory to be approved from myAppFree Team.
``` javascript
CordovaAppValidator.showDialog("App is validated");
```

##### Testing
In order to enable/disable DEBUG mode run:
``` javascript
CordovaAppValidator.enableDebug(); // enable debug
CordovaAppValidator.disableDebug(); // disable debug
```
Note: this will raise the *validated() block* every time your app is opened. Remove this line before releasing your app to the store.

#### Do te trick! (Unity)
Use the script appvalidator.cs

Edit validated block on line 41 to perform custom actions and run function: isIapUnlocked()

##### Show custom message
Use function showDialog() inside appvalidator.cs to show a custom message. This is mandatory to be approved from myAppFree Team.

##### Testing
In order to enable/disable DEBUG mode use function enableDebug() and disableDebug() inside appvalidator.cs:

Note: this will raise the *validated() block* every time your app is opened. Remove this line before releasing your app to the store.
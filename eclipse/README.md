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
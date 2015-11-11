#### Import library (Cordova)
 - Download this repository.
 - Run this command from root directory of your project:
```bash
cordova plugin add <path/to/AppValidator/cordova>
```

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
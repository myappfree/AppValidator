#### Import library (Unity)
- Download this repository
- copy the directory under AppValidator/unity/unityproject in your unity project

#### Do te trick! (Unity)
Use the script appvalidator.cs

Edit validated block on line 41 to perform custom actions and run function: isIapUnlocked()

##### Show custom message
Use function showDialog() inside appvalidator.cs to show a custom message. This is mandatory to be approved from myAppFree Team.

##### Testing
In order to enable/disable DEBUG mode use function enableDebug() and disableDebug() inside appvalidator.cs

Note: this will raise the *validated() block* every time your app is opened. Remove this line before releasing your app to the store.
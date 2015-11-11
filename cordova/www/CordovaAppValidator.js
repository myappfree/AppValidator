var exec = require('cordova/exec');

function AppValidator() {
	console.log("AppValidator.js: is created");
}

AppValidator.prototype.isIapUnlocked = function(validated) {
	exec(validated, null, "CordovaAppValidator", "isIapUnlocked", []);
}

AppValidator.prototype.showDialog = function(message) {
	exec(null, null, "CordovaAppValidator", "showDialog", [message]);
}

AppValidator.prototype.enableDebug = function() {
	exec(null, null, "CordovaAppValidator", "enableDebug", []);
}

AppValidator.prototype.disableDebug = function() {
	exec(null, null, "CordovaAppValidator", "disableDebug", []);
}

var appValidator = new AppValidator();
module.exports = appValidator;

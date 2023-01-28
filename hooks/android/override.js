const fs = require('fs');

// File destination.txt will be created or overwritten by default.
fs.copyFile('src/android/MainActivity.java', '/Users/christian/DEVELOPMENT/sbrick-configurator/dist_cordova//platforms/android/app/src/main/java/com/huskykoglhof/sbrick_configurator_debug/MainActivity.java', (err) => {
  if (err) throw err;
  console.log('source.txt was copied to destination.txt');
});

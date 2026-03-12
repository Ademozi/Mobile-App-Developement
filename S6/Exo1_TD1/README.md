# Hello App !
---


# Q6. Define SecondActivity as the main activity (homepage)

Move the intent filter from MainActivity to SecondActivity.

Example:
```
<activity android:name=".SecondActivity">
    <intent-filter>
        <action android:name="android.intent.action.MAIN"/>
        <category android:name="android.intent.category.LAUNCHER"/>
    </intent-filter>
</activity>
```
And remove it from MainActivity.

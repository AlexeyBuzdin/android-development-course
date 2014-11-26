## Session 7: Android Data Storage
### [Presentation](Android Data Storage.pdf)
### Task part 3

1. Create new folder res/xml and add create settings.xml
2. In settings.xml define a PreferenceCategory and a Preference to hold user chosen color (can be preset list of colors or hex) with yellow as default
3. Create MyPreferenceActivity and extend it from PreferenceActivity (don't forget to register it in AndroidManifest)
4. Create new folder res/menu and new menu resource with 'Settings' menu item
5. Configure you MainActivity to show ActionBar with 'Settings' button
6. Add action listener to 'Settings' menu to open MyPreferenceActivity
7. Align your custom TODO item list Adapter to paint items background corresponding to User defined color in 'Settings'
8. Add ActiveAndroid dependency to you app build.gradle
9. Extend you TodoItem class with Model and add @Column and @Table annotations
10. Register database in AndroidManifest and register ActiveAndroid application
11. Implement saving and fetching of TODO models from and to DB

### Code Examples

#### How to add ActiveAndroid dependency (in app/build.gradle)
``` groovy
repositories {
    jcenter()
    maven { url "https://oss.sonatype.org/content/repositories/snapshots/" }
}

dependencies {
    compile ('com.michaelpardo:activeandroid:3.1.0-SNAPSHOT')
}
```

#### ActiveAndroid model
```java
@Table(name = "MyPersistedClass")
public class MyPersistedClass extends Model {

    @Column(name = "type")
    private int value;

    @Column(name = "description")
    private String description;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
```

#### ActiveAndroid API
```java
MyPersistedClass aClass = new MyPersistedClass();
aClass.setDescription(textView.getText().toString());
aClass.save(); // To save or update

new Select().from(MyPersistedClass.class).execute(); // To Select all
```

#### ActiveAndroid Database registration in AndroidManifest
```xml
<manifest ...>
    <application android:name="com.activeandroid.app.Application" ...>

        ...

        <meta-data android:name="MY_DB_NAME" android:value="MyDB.db" />
        <meta-data android:name="MY_DB_VERSION" android:value="1" />

    </application>
</manifest>
```

### Links

https://github.com/pardom/ActiveAndroid/wiki/Getting-started
http://developer.android.com/guide/topics/ui/actionbar.html
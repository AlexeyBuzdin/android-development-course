## Session 5: Android UI (part 5)
### [Presentation](Android%20UI%20part%20II.pdf)
### Task part 1

1. Create project
2. Create layout with 3 views (Button, EditText, ListView)
3. Set layout to Activity
4. Set simple Adapter to ListView
5. Create new Layout for ListViewAdapter
6. Create custom Adapter, demonstrate displaying different dates
7. SetOnClickListener to button and add element to List
8. Create new class ToDoItem and use it to represent todo text and date for the Adapter
9. SetOnClickListener to Delete button

![Mockup](mockup.png)

### Code Examples

Button click example
```xml
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:paddingLeft="@dimen/activity_horizontal_margin"
    android:paddingRight="@dimen/activity_horizontal_margin"
    android:paddingTop="@dimen/activity_vertical_margin"
    android:paddingBottom="@dimen/activity_vertical_margin"
    tools:context=".MyActivity">

    <Button
        android:id="@+id/button"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Click Me"/>

    <TextView
        android:id="@+id/text_view"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content" />

    <!--<ListView-->
        <!--android:id="@+id/listView"-->
        <!--android:layout_width="wrap_content"-->
        <!--android:layout_height="wrap_content" />-->

</LinearLayout>
```

``` java
 @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        final TextView textView = (TextView) findViewById(R.id.text_view);
        Button button = (Button) findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText("Hello");
            }
        });

    }
```

Simple ArrayAdapter
``` java
   @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        String[] values = new String[] { "Android", "iPhone", "WindowsMobile",
                "Blackberry", "WebOS", "Ubuntu", "Windows7", "Max OS X",
                "Linux", "OS/2", "Ubuntu", "Windows7", "Max OS X", "Linux",
                "OS/2", "Ubuntu", "Windows7", "Max OS X", "Linux", "OS/2",
                "Android", "iPhone", "WindowsMobile" };

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, values);

        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(adapter);
    }
```

Custom ArrayAdapter implementation
``` java
public class CustomArrayAdapter extends ArrayAdapter {

    public CustomArrayAdapter(Context context, int resource, List objects) {
        super(context, resource, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder vh;
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
            vh = new ViewHolder(convertView);
            convertView.setTag(vh);
        } else {
            vh = (ViewHolder) convertView.getTag();
        }

        vh.textView.setText(getItem(position).toString());

        return convertView;
    }

    private static class ViewHolder {
        TextView textView;

        public ViewHolder(View convertView) {
            textView = (TextView) convertView.findViewById(R.id.my_text_view);
        }
    }
}
```

### Links
* [ArrayAdapter documentation](http://developer.android.com/reference/android/widget/ArrayAdapter.html)
* [Generic ViewHolder](https://medium.com/@AlexeyBuzdin/generic-viewholder-for-android-63bf9e0db06a)

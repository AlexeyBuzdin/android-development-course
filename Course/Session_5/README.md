## Session 5: Android UI (part 5)
### [Presentation](presentation)
### Code Examples

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

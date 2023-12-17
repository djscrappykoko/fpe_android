// CustomAdapter.java
public class CustomAdapter extends BaseAdapter {
    private ArrayList dataList;
    private Context context;

    public CustomAdapter(Context context, ArrayList dataList) {
        this.context = context;
        this.dataList = dataList;
    }

    @Override
    public int getCount() {
        return dataList.size();
    }

    @Override
    public Object getItem(int position) {
        return dataList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);
        }
        
        TextView textView = convertView.findViewById(R.id.item_text);
        textView.setText(dataList.get(position));

        return convertView;
    }
}

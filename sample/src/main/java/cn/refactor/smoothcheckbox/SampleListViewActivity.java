package cn.refactor.smoothcheckbox;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.io.Serializable;
import java.util.ArrayList;

import cn.refactor.library.SmoothCheckBox;

public class SampleListViewActivity extends AppCompatActivity {
    private ArrayList<Bean> mList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);

        for (int i = 0; i < 100; i ++) {
            mList.add(new Bean());
        }

        ListView lv = (ListView) findViewById(R.id.lv);
        lv.setAdapter(new BaseAdapter() {
            @Override
            public int getCount() {
                return mList.size();
            }

            @Override
            public Object getItem(int position) {
                return mList.get(position);
            }

            @Override
            public long getItemId(int position) {
                return 0;
            }

            @Override
            public View getView(final int position, View convertView, ViewGroup parent) {
                ViewHolder holder;
                if (convertView == null) {
                    holder = new ViewHolder();
                    convertView = View.inflate(SampleListViewActivity.this, R.layout.item, null);
                    holder.tv = (TextView) convertView.findViewById(R.id.tv);
                    holder.cb = (SmoothCheckBox) convertView.findViewById(R.id.scb);
                    convertView.setTag(holder);
                } else {
                    holder = (ViewHolder) convertView.getTag();
                }

                final Bean bean = mList.get(position);
                holder.cb.setOnCheckedChangeListener(new SmoothCheckBox.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(SmoothCheckBox checkBox, boolean isChecked) {
                        bean.isChecked = isChecked;
                    }
                });
                String text = getString(R.string.string_item_subffix) + position;
                holder.tv.setText(text);
                holder.cb.setChecked(bean.isChecked);

                return convertView;
            }

            class ViewHolder {
                SmoothCheckBox cb;
                TextView tv;
            }
        });
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Bean bean = (Bean) parent.getAdapter().getItem(position);
                bean.isChecked = !bean.isChecked;
                SmoothCheckBox checkBox = (SmoothCheckBox) view.findViewById(R.id.scb);
                checkBox.setChecked(bean.isChecked, true);
            }
        });
    }

    class Bean implements Serializable {
        boolean isChecked;
    }
}

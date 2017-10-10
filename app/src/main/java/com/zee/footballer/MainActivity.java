package com.zee.footballer;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import com.zee.footballer.adapters.StableArrayAdapter;

import java.util.ArrayList;

public class MainActivity extends Activity {

     ListView lvFootballers;
     ArrayList<String> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initData();
        initViews();

    }

    private void initData() {

        String[] data = new String[] { "Ronaldo", "Messi", "Iniesta",
                "Zidane", "Rooney", "Kaka", "Hazard", "Ronaldinho",
                "Robben" };

        list = new ArrayList<String>();
        for (int i = 0; i < data.length; ++i) {
            list.add(data[i]);
        }
    }

    private void initViews() {

        lvFootballers = (ListView) findViewById(R.id.lvFootballers);

        final StableArrayAdapter adapter = new StableArrayAdapter(this,
                android.R.layout.simple_list_item_1, list);
        lvFootballers.setAdapter(adapter);

        lvFootballers.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, final View view,
                                    int position, long id) {
                final String item = (String) parent.getItemAtPosition(position);
                view.animate().setDuration(2000).alpha(0)
                        .withEndAction(new Runnable() {
                            @Override
                            public void run() {
                                list.remove(item);
                                adapter.notifyDataSetChanged();
                                view.setAlpha(1);
                            }
                        });
            }

        });
    }

}

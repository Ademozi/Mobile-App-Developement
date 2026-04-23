package com.supermarket.listview_exo2;

import android.content.Context;
import android.widget.BaseAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MyAdapter extends BaseAdapter {
    Context context;
    ArrayList<ProgrammingLanguage> list;

    public MyAdapter(Context context, ArrayList<ProgrammingLanguage> list){
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ProgrammingLanguage programmingLanguage = list.get(i);
        if (view == null) {
            LayoutInflater layoutInflater = LayoutInflater.from(context);
            view = layoutInflater.inflate(R.layout.custom_list_item, null);
        }
        ImageView imageView = view.findViewById(R.id.img);
        TextView textView = view.findViewById(R.id.txt);

        imageView.setImageResource(programmingLanguage.logo);
        textView.setText(programmingLanguage.name);

        return view;
    }

}

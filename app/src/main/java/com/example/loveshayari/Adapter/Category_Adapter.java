package com.example.loveshayari.Adapter;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.loveshayari.Activity.Main_Activity;
import com.example.loveshayari.R;

public class Category_Adapter extends BaseAdapter
{

    Main_Activity mainActivity;
    ImageView imageView;
    String[] name;
    int[] imgArr;

    public Category_Adapter(Main_Activity mainActivity, String[] name, int[] img) {
        this.mainActivity = mainActivity;
        this.name = name;
        this.imgArr = img;

    }

    @Override
    public int getCount() {
        return name.length;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        view= LayoutInflater.from(mainActivity).inflate(R.layout.activity_main_item,parent,false);

        ImageView imageView=view.findViewById(R.id.main_item_img);
        TextView txtName=view.findViewById(R.id.main_item_name);

        txtName.setText(""+name[position]);

        imageView.setImageResource(imgArr[position]);


        return view;
    }
}
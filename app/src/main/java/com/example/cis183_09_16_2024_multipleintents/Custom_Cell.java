package com.example.cis183_09_16_2024_multipleintents;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class Custom_Cell extends BaseAdapter {

    Context context;
    ArrayList<Pet> Petlist;

    public Custom_Cell(Context c, ArrayList<Pet> pl)
    {
        context = c;
        Petlist = pl;
    }


    @Override
    public int getCount() {
        return Petlist.size();
    }

    @Override
    public Object getItem(int i) {
        return Petlist.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view == null)
        {
            LayoutInflater Inflater = (LayoutInflater) context.getSystemService(MainActivity.LAYOUT_INFLATER_SERVICE);
            view = Inflater.inflate(R.layout.activity_custom_cell, null);
        }
        TextView name = view.findViewById(R.id.et_v_cell_name);
        TextView age = view.findViewById(R.id.et_v_cell_age);

        Pet emp = Petlist.get(i);
        name.setText("Name: " + emp.getName());
        age.setText("" + emp.getAge());
        return view;
    }
}
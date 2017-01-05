package com.example.gijs.mobieleaphasia;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import java.util.List;

/**
 * Created by gijs on 5/01/2017.
 */

public class PictureListAdapter extends BaseAdapter {
    private Activity activity;
    private List<Integer> picturesID;

    public PictureListAdapter (Activity activity, List<Integer> picturesID){
        this.activity = activity;
        this.picturesID = picturesID;
    }

    @Override
    public int getCount() {
        return picturesID.size();
    }

    @Override
    public Object getItem(int position) {
        return picturesID.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater=activity.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.picturelist, null,true);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.icon);
        imageView.setImageResource(picturesID.get(position));
        return rowView;
    }
}

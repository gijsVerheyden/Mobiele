package com.example.gijs.mobieleaphasia;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.List;

/**
 * Created by gijs on 5/01/2017.
 */

public class TestActivity2 extends AppCompatActivity {
    private ListView pictures;
    private List<Integer> picturesID;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test2);

        pictures = (ListView) findViewById(R.id.image_list);
        pictures.setAdapter(new PictureListAdapter(TestActivity2.this,picturesID));
    }
}

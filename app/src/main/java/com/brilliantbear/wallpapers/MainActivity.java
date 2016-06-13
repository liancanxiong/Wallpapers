package com.brilliantbear.wallpapers;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.brilliantbear.wallpapers.view.ListFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            getFragmentManager().beginTransaction().add(R.id.frame_main, new ListFragment()).commit();
        }
    }
}

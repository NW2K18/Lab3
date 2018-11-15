package com.example.todofragments;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Above was the initial code, now below is the code code added by the lab
        // Starting of by creating a FragmentManager to manager our todo fragment
        // that we have created
        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.fragment_container);

        // If fragment is null... This is to do with saved instance state?
        // So the bundle contains the id?
        if (fragment == null){
            TodoFragment todoFragment = new TodoFragment();
            fm.beginTransaction()
                    .add(R.id.fragment_container, todoFragment)
                    .commit();
        }
    }
}

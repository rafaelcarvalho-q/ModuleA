package com.qranio.sample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.qranio.modulea.view.fragment.ListFragment;
import com.qranio.modulea.view.fragment.ModuleAFragment;

public class ListSampleActivity extends AppCompatActivity implements View.OnClickListener {

    // Views
    ListFragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_sample);
        setScreenComponents();
    }

    @Override
    public void onClick(View view) {
    }

    protected void setScreenComponents() {

        fragment = (ListFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_list_module);
    }

    //==============================================================================================
    // Métodos Privados
    //==============================================================================================

}

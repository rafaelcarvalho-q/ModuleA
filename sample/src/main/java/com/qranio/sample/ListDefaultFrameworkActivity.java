package com.qranio.sample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;

import com.qranio.modulea.view.fragment.ListFragment;

public class ListDefaultFrameworkActivity extends AppCompatActivity implements View.OnClickListener {

    // Views
    ListFragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_default_framework);
        setScreenComponents();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public void onClick(View view) {
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {

            case android.R.id.home:

                onBackPressed();
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    protected void setScreenComponents() {

        fragment = (ListFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_list_module);
    }

    //==============================================================================================
    // Métodos Privados
    //==============================================================================================

}

package com.qranio.sample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;

import com.qranio.modulea.view.fragment.ModuleAFragment;

public class ScreeOneCustomFrameworkActivity extends AppCompatActivity implements View.OnClickListener {

    // Views
    ModuleAFragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen_one_custom_framework);
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

        fragment = (ModuleAFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_module);
    }

    //==============================================================================================
    // Métodos Privados
    //==============================================================================================

}

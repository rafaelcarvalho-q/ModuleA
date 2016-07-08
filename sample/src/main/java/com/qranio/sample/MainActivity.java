package com.qranio.sample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.qranio.modulea.view.fragment.ModuleAFragment;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    // Views
    private Button btDefaultFramework;
    private Button btScreemCustom;
    private Button btDefault2Framework;
    private Button btScreem2Custom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setScreenComponents();
        setListeners();
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.bt_default_framework:

                startActivity(new Intent(this, ScreeOneDefaultFrameworkActivity.class));
                break;

            case R.id.bt_screem_custom:

                startActivity(new Intent(this, ScreeOneCustomFrameworkActivity.class));
                break;

            case R.id.bt_default_2_framework:

                startActivity(new Intent(this, ListDefaultFrameworkActivity.class));
                break;

            case R.id.bt_screem_2_custom:

                startActivity(new Intent(this, ListCustomFrameworkActivity.class));
                break;
        }
    }

    protected void setScreenComponents() {

        btDefaultFramework = (Button) findViewById(R.id.bt_default_framework);
        btScreemCustom = (Button) findViewById(R.id.bt_screem_custom);
        btDefault2Framework = (Button) findViewById(R.id.bt_default_2_framework);
        btScreem2Custom = (Button) findViewById(R.id.bt_screem_2_custom);
    }

    //==============================================================================================
    // Métodos Privados
    //==============================================================================================

    private void setListeners() {

        btDefaultFramework.setOnClickListener(this);
        btScreemCustom.setOnClickListener(this);
        btDefault2Framework.setOnClickListener(this);
        btScreem2Custom.setOnClickListener(this);

    }
}

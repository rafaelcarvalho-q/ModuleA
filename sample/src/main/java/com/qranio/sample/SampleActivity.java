package com.qranio.sample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.qranio.modulea.view.ModuleAFragment;

public class SampleActivity extends AppCompatActivity implements View.OnClickListener {

    // Views
    ModuleAFragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample);
        setScreenComponents();

//        fragment.setCancelButtonLabel("Cancelar2");
//        fragment.setSendButtonLabel("Enviar2");
//        fragment.setMessage("Minha mensagem!");
//        fragment.setCancelButtonListener(this);
//        fragment.setSendButtonListener(this);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.bt_cancel:

                Toast.makeText(this, "Botão cancelar", Toast.LENGTH_SHORT).show();
                break;

            case R.id.bt_send:

                Toast.makeText(this, "Botão enviar", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    protected void setScreenComponents() {

        fragment = (ModuleAFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_module);
    }

    //==============================================================================================
    // Métodos Privados
    //==============================================================================================

}

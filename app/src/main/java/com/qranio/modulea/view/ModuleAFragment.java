package com.qranio.modulea.view;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.qranio.modulea.R;

/**
 * Created by Rafael C. Almeida on 05/07/16.
 */
public class ModuleAFragment extends Fragment {

    // Views
    private View view;
    private TextView tvMmessage;
    private Button btCancel;
    private Button btSend;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_module, container, true);
        setScreenComponents();

        return view;
    }

    public void setMessage(@NonNull String message) {

        tvMmessage.setText(message);
    }

    public void setCancelButtonLabel(@NonNull String label) {

        btCancel.setText(label);
    }

    public void setSendButtonLabel(@NonNull String label) {

        btSend.setText(label);
    }

    public void setMessage(@StringRes int idMessage) {

        tvMmessage.setText(idMessage);
    }

    public void setCancelButtonListener(@NonNull View.OnClickListener onClickListener) {

        btCancel.setOnClickListener(onClickListener);
    }

    public void setSendButtonListener(@NonNull View.OnClickListener onClickListener) {

        btSend.setOnClickListener(onClickListener);
    }

    //==============================================================================================
    // Métodos Privados
    //==============================================================================================

    private void setScreenComponents() {

        tvMmessage = (TextView) view.findViewById(R.id.tv_message);
        btCancel = (Button) view.findViewById(R.id.bt_cancel);
        btSend = (Button) view.findViewById(R.id.bt_send);
    }
}
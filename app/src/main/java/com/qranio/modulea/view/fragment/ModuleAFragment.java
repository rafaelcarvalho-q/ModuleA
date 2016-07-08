package com.qranio.modulea.view.fragment;

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
    private TextView tvTitle;
    private Button btDefault;
    private Button btPrimary;
    private Button btSuccess;
    private Button btInfo;
    private Button btWarning;
    private Button btDanger;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_module, container, true);
        setScreenComponents();

        return view;
    }

    public void setTitle(String titile) {

        tvTitle.setText(titile);
    }

    public void setButtonDefaultLabel(String label) {

        btDefault.setText(label);
    }

    public void setButtonDefaultOnClickListener(View.OnClickListener onClickListener) {

        btDefault.setOnClickListener(onClickListener);
    }

    public void setButtonPrimaryLabel(String label) {

        btPrimary.setText(label);
    }

    public void setButtonPrimaryOnClickListener(View.OnClickListener onClickListener) {

        btPrimary.setOnClickListener(onClickListener);
    }

    public void setButtonSuccessLabel(String label) {

        btSuccess.setText(label);
    }

    public void setButtonSuccessOnClickListener(View.OnClickListener onClickListener) {

        btSuccess.setOnClickListener(onClickListener);
    }

    public void setButtonInfoLabel(String label) {

        btInfo.setText(label);
    }

    public void setButtonInfoOnClickListener(View.OnClickListener onClickListener) {

        btInfo.setOnClickListener(onClickListener);
    }

    public void setButtonWarningLabel(String label) {

        btWarning.setText(label);
    }

    public void setButtonWarningOnClickListener(View.OnClickListener onClickListener) {

        btWarning.setOnClickListener(onClickListener);
    }

    public void setButtonDangerLabel(String label) {

        btDanger.setText(label);
    }

    public void setButtonDangerOnClickListener(View.OnClickListener onClickListener) {

        btDanger.setOnClickListener(onClickListener);
    }

    //==============================================================================================
    // Métodos Privados
    //==============================================================================================

    private void setScreenComponents() {

        tvTitle = (TextView) view.findViewById(R.id.tv_title);
        btDefault = (Button) view.findViewById(R.id.bt_default);
        btPrimary = (Button) view.findViewById(R.id.bt_primary);
        btSuccess = (Button) view.findViewById(R.id.bt_success);
        btInfo = (Button) view.findViewById(R.id.bt_info);
        btWarning = (Button) view.findViewById(R.id.bt_warning);
        btDanger = (Button) view.findViewById(R.id.bt_danger);
    }
}
package com.qranio.modulea.interfaces;

import android.view.View;

/**
 * Created by Rafael C. Almeida on 04/05/16.
 */
public interface ClickListener<T> {

    void onItemClick(View view, int position, T data);
    void onLongClick(View view, int position, T data);
}
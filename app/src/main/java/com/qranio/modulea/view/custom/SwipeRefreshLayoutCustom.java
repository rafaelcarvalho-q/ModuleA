package com.qranio.modulea.view.custom;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.AttributeSet;

import com.qranio.modulea.R;

/**
 * Created by Rafael C. Almeida on 07/07/16.
 */
public class SwipeRefreshLayoutCustom extends SwipeRefreshLayout {

    public SwipeRefreshLayoutCustom(Context context) {

        super(context);
        setup(context, null);
    }

    public SwipeRefreshLayoutCustom(Context context, AttributeSet attrs) {

        super(context, attrs);
        setup(context, attrs);
    }

    //==============================================================================================
    // Métodos Privados
    //==============================================================================================

    private void setup(Context context, AttributeSet attrs) {

        if (attrs != null) {

            TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.SwipeRefreshLayoutCustom, 0, 0);
            int firstProgressColor = a.getResourceId(R.styleable.SwipeRefreshLayoutCustom_firstProgressColor, R.color.module_red_100);
            int secondProgressColor = a.getResourceId(R.styleable.SwipeRefreshLayoutCustom_secondProgressColor, R.color.module_red_200);
            int thirdProgressColor = a.getResourceId(R.styleable.SwipeRefreshLayoutCustom_thirdProgressColor, R.color.module_red_300);
            int foutrhProgressColor = a.getResourceId(R.styleable.SwipeRefreshLayoutCustom_fourtProgressColor, R.color.module_red_400);
            a.recycle();

            setColorSchemeResources(firstProgressColor, secondProgressColor, thirdProgressColor, foutrhProgressColor);
        }
    }
}

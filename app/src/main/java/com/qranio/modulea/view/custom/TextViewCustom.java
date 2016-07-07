package com.qranio.modulea.view.custom;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;

import com.qranio.modulea.R;

/**
 * Created by Rafael C. Almeida on 04/05/16.
 */
public class TextViewCustom extends android.support.v7.widget.AppCompatTextView {

    private ColorStateList drawableTint;
    private ColorStateList backgroundTint;

    public TextViewCustom(Context context, AttributeSet attrs, int defStyle) {

        super(context, attrs, defStyle);
        init(context, attrs, defStyle);
    }

    public TextViewCustom(Context context, AttributeSet attrs) {

        super(context, attrs);
        init(context, attrs, 0);
    }

    public TextViewCustom(Context context) {
        super(context);
    }

    private void init(Context context, AttributeSet attrs, int defStyle) {

        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.TextViewCustom, defStyle, 0);
        drawableTint = a.getColorStateList(R.styleable.TextViewCustom_drawableTintSelector);
        backgroundTint = a.getColorStateList(R.styleable.TextViewCustom_backgroundTintSelector);
        a.recycle();
    }

    @Override
    protected void drawableStateChanged() {

        super.drawableStateChanged();
        updateDrawableTintColor();
        updateBackgroundTintColor();
    }

    private void updateDrawableTintColor() {

        if (drawableTint == null) {

            return;
        }

        int color = drawableTint.getColorForState(getDrawableState(), 0);

        Drawable[] drawables = getCompoundDrawables();

        for (Drawable drawable : drawables) {

            if (drawable != null) {
                drawable.mutate();
                drawable.setColorFilter(color, PorterDuff.Mode.SRC_ATOP);
            }
        }
    }

    private void updateBackgroundTintColor() {

        if (backgroundTint == null) {

            return;
        }

        int color = backgroundTint.getColorForState(getDrawableState(), 0);

        Drawable drawable = getBackground();

        if (drawable != null) {

            drawable.mutate();
            drawable.setColorFilter(color, PorterDuff.Mode.SRC_ATOP);
        }
    }
}
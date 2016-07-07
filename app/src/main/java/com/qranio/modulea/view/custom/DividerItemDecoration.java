package com.qranio.modulea.view.custom;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by Rafael C. Almeida on 08/06/16.
 */
public class DividerItemDecoration extends RecyclerView.ItemDecoration {

    private int mOrientation;

    public interface DecoratorInterface {

        Drawable getDivider(int position);
    }

    @Override
    public void onDrawOver(Canvas canvas, RecyclerView parent, RecyclerView.State state) {

        if (mOrientation == LinearLayoutManager.HORIZONTAL) {

            drawHorizontalDividers(canvas, parent);

        } else if (mOrientation == LinearLayoutManager.VERTICAL) {

            drawVerticalDividers(canvas, parent);
        }
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {

        super.getItemOffsets(outRect, view, parent, state);

        int position = parent.getChildAdapterPosition(view);
        DecoratorInterface decoratorInterface = getDecoratorInterface(parent);

        mOrientation = ((LinearLayoutManager) parent.getLayoutManager()).getOrientation();
        Drawable divider = decoratorInterface.getDivider(position);

        if (divider != null) {

            if (mOrientation == LinearLayoutManager.HORIZONTAL) {

                outRect.left = divider.getIntrinsicWidth();

            } else if (mOrientation == LinearLayoutManager.VERTICAL) {

                outRect.top = divider.getIntrinsicHeight();
            }
        }
    }

    //==============================================================================================
    // Métodos privados
    //==============================================================================================

    private void drawHorizontalDividers(Canvas canvas, RecyclerView parent) {

        DecoratorInterface decoratorInterface = getDecoratorInterface(parent);
        int parentTop = parent.getPaddingTop();
        int parentBottom = parent.getHeight() - parent.getPaddingBottom();
        int childCount = parent.getChildCount();

        for (int i = 0; i < childCount; i++) {

            setHorizontalDivider(canvas, parent.getChildAt(i), decoratorInterface.getDivider(i), parentTop, parentBottom);
        }
    }

    private void drawVerticalDividers(Canvas canvas, RecyclerView parent) {

        DecoratorInterface decoratorInterface = getDecoratorInterface(parent);
        int parentLeft = parent.getPaddingLeft();
        int parentRight = parent.getWidth() - parent.getPaddingRight();
        int childCount = parent.getChildCount();

        for (int i = 0; i < childCount; i++) {

            Drawable divider = decoratorInterface.getDivider(i);
            setVerticalDivider(canvas, parent.getChildAt(i), divider, parentLeft, parentRight);
        }
    }

    private void setVerticalDivider(final Canvas canvas, final View child, final Drawable divider, final int parentLeft, final int parentRight) {

        if (divider != null) {

            RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child.getLayoutParams();
            int parentTop = child.getBottom() + params.bottomMargin;
            int parentBottom = parentTop + divider.getIntrinsicHeight();

            divider.setBounds(parentLeft, parentTop, parentRight, parentBottom);
            divider.draw(canvas);
        }
    }

    private void setHorizontalDivider(Canvas canvas, View child, Drawable divider, int parentTop, int parentBottom) {

        if (divider != null) {

            RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child.getLayoutParams();
            int parentLeft = child.getRight() + params.rightMargin;
            int parentRight = parentLeft + divider.getIntrinsicWidth();

            divider.setBounds(parentLeft, parentTop, parentRight, parentBottom);
            divider.draw(canvas);
        }
    }

    private DecoratorInterface getDecoratorInterface(RecyclerView recyclerView) {

        return (DecoratorInterface) recyclerView.getAdapter();
    }
}

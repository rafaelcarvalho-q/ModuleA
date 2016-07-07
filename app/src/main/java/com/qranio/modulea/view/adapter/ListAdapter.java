package com.qranio.modulea.view.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.qranio.modulea.R;
import com.qranio.modulea.model.User;

/**
 * Created by Rafael C. Almeida on 05/05/16.
 */
public class ListAdapter extends RecyclerViewAdapter<User> {

    private static final int TYPE_FOOTER = 1;
    private static final int TYPE_ITEM = 2;
    private boolean hasLoadMore;
    private boolean showLoadMore;
    private Drawable divider;

    public ListAdapter(Context context, boolean hasLoadMore) {

        super(context);
        this.hasLoadMore = hasLoadMore;
        divider = ContextCompat.getDrawable(getContext(), R.drawable.divider_line);
    }

    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = null;

        switch (viewType) {

            case TYPE_FOOTER:

                view = getInflater().inflate(R.layout.item_load_footer, parent, false);
                return new FooterViewHolder(view);

            default:

                view = getInflater().inflate(R.layout.item_list, parent, false);
                return new ViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(RecyclerViewAdapter.ViewHolder holder, int position) {

        switch (getItemViewType(position)) {

            case TYPE_FOOTER:

                configFooter((FooterViewHolder) holder);
                break;

            default:

                setDataItemView((ViewHolder) holder, getItem(position));
                break;
        }
    }

    @Override
    public int getItemCount() {

        return (getItensListCount() + 1);
    }

    @Override
    public int getItemViewType(int position) {

        if (position >= (getItemCount() - 1)) {

            return TYPE_FOOTER;
        }

        return TYPE_ITEM;
    }

    public boolean isShowLoadingMore() {
        return showLoadMore;
    }

    @Override
    public Drawable getDivider(int position) {

        return divider;
    }

    public class ViewHolder extends RecyclerViewAdapter.ViewHolder implements View.OnClickListener {

        TextView tvFirstName;
        TextView tvLastName;
        TextView tvEmail;
        TextView tvDate;
        ImageView ivUser;

        public ViewHolder(View view) {

            super(view);

            ivUser = (ImageView) view.findViewById(R.id.iv_user);
            tvFirstName = (TextView) view.findViewById(R.id.tv_first_name);
            tvLastName = (TextView) view.findViewById(R.id.tv_last_name);
            tvEmail = (TextView) view.findViewById(R.id.tv_email);
            tvDate = (TextView) view.findViewById(R.id.tv_date);

            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {

            final int itemPosition = getItemPosition();
            onItemclicked(v, itemPosition, getItem(itemPosition));
        }
    }

    public class FooterViewHolder extends RecyclerViewAdapter.ViewHolder {

        LinearLayout llContent;
        RelativeLayout rlLoadMore;

        public FooterViewHolder(View view) {

            super(view);
            llContent = (LinearLayout) view.findViewById(R.id.ll_content);
            rlLoadMore = (RelativeLayout) view.findViewById(R.id.rl_content_load_more);
            rlLoadMore.setVisibility(View.GONE);
        }
    }

    public void showLoadMore(boolean showLoadMore) {

        this.showLoadMore = showLoadMore;
    }

    //==============================================================================================
    // Metodos privados
    //==============================================================================================

    private void setDataItemView(final ViewHolder viewHolder, final User user) {

        viewHolder.ivUser.setImageDrawable(ContextCompat.getDrawable(getContext(), user.getImageIdRes()));
        viewHolder.tvFirstName.setText(user.getFirstName());
        viewHolder.tvLastName.setText(user.getLastName());
        viewHolder.tvEmail.setText(user.getEmail());
        viewHolder.tvDate.setText(user.getDate());
    }

    private void configFooter(FooterViewHolder viewHolder) {

        if (hasLoadMore && showLoadMore) {

            viewHolder.rlLoadMore.setVisibility(View.VISIBLE);
            viewHolder.llContent.setVisibility(View.VISIBLE);

        } else {

            viewHolder.rlLoadMore.setVisibility(View.GONE);
            viewHolder.llContent.setVisibility(View.GONE);
        }
    }
}
package com.qranio.modulea.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;

import com.qranio.modulea.interfaces.ClickListener;
import com.qranio.modulea.view.custom.DividerItemDecoration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Rafael C. Almeida on 04/05/16.
 */
public abstract class RecyclerViewAdapter<T> extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> implements DividerItemDecoration.DecoratorInterface {

    private List<T> itensList;

    private final Context context;
    private final LayoutInflater inflater;
    private ClickListener clickListener;

    public RecyclerViewAdapter(Context context) {

        this.context = context;
        inflater = LayoutInflater.from(context);
        itensList = new ArrayList<T>(0);
    }

    public final List<T> getItensList() {

        return itensList;
    }

    public final T getItem(int position) {

        if (itensList == null || itensList.isEmpty()) {

            return null;
        }

        if (position >= itensList.size()) {

            return itensList.get(itensList.size() - 1);
        }

        return (position < 0) ? itensList.get(0) : itensList.get(position);
    }

    public final void delete(int position) {

        itensList.remove(position);
        notifyItemRemoved(position);
    }

    public final void addItensAndNotifyDataSet(T... itens) {

        addItens(itens);
        notifyDataSetChanged();
    }

    public final void addItensAndNotifyDataSet(List<T> itens) {

        addItens(itens);
        notifyDataSetChanged();
    }

    public final void addItens(T... itens) {

        if (itens == null || itens.length <= 0) {

            return;
        }

        itensList.addAll(new ArrayList<T>(Arrays.asList(itens)));
    }

    public final void addItens(List<T> itens) {

        if (itens == null || itens.isEmpty()) {

            return;
        }

        itensList.addAll(itens);
    }

    public final void addItensInitList(T... itens) {

        if (itens == null) {

            return;
        }

        for (T item : itens) {

            itensList.add(0, item);
        }
    }

    public void notifyItensChanged(List<T> itens) {

        if (itensList == null || itens == null) {

            return;
        }

        int index = -1;

        for (T item : itens) {

            index = itensList.indexOf(item);

            if (index >= 0) {

                notifyItemChanged(index);
            }
        }
    }

    public final void addItensInitListPositionAndNotifyItensInserted(T... itens) {

        if (itens == null || itens.length <= 0) {

            return;
        }

        for (T item : itens) {

            itensList.add(0, item);
            notifyItemInserted(0);
        }
    }

    public boolean isEmpty() {

        return itensList == null || itensList.isEmpty();
    }

    public int getItensListCount() {

        return (itensList == null) ? 0 : itensList.size();
    }

    public final LayoutInflater getInflater() {

        return inflater;
    }

    public final Context getContext() {

        return context;
    }

    public final void setClickListener(ClickListener<T> clickListener) {

        this.clickListener = clickListener;
    }

    public final ClickListener getOnclickListener() {

        return clickListener;
    }

    protected final void onItemclicked(View view, int position, T data) {

        if (clickListener != null) {

            clickListener.onItemClick(view, position, data);
        }
    }

    protected final void onLongItemclicked(View view, int position, T data) {

        if (clickListener != null) {

            clickListener.onLongClick(view, position, data);
        }
    }

    public void replaceAndMoveItem(int toPosition, T object, T newObject) {

        if (itensList == null || itensList.isEmpty() || object == null || newObject == null) {

            return;
        }

        int index = getItensList().indexOf(object);

        getItensList().remove(index);
        getItensList().add(toPosition, newObject);

        notifyItemMoved(index, toPosition);
        notifyItemChanged(toPosition);
    }

    public void replaceItem(T object, T newObject) {

        if (object == null || newObject == null) {

            return;
        }

        int index = getItensList().indexOf(object);

        if (index >= 0) {

            getItensList().remove(index);
            getItensList().add(index, newObject);
            notifyItemChanged(index);
        }
    }

    public void clear() {

        if (itensList != null) {

            itensList.clear();
        }
    }

    public static abstract class ViewHolder extends RecyclerView.ViewHolder {

        private MergeRecyclerViewAdapter adapter;

        public ViewHolder(View itemView) {

            super(itemView);
        }

        public final int getItemPosition() {

            if (adapter != null) {

                MergeRecyclerViewAdapter.SectionModel sectionModel =
                        adapter.getSectionModelForPosition(getAdapterPosition());

                return sectionModel.getItemAdapterPosition();

            }

            return getAdapterPosition();
        }

        protected void setMergeRecyclerViewAdapter(MergeRecyclerViewAdapter adapter) {

            this.adapter = adapter;
        }
    }
}
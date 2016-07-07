package com.qranio.modulea.view.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.qranio.modulea.view.custom.DividerItemDecoration;
import com.qranio.modulea.view.custom.Section;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rafael C. Almeida on 05/05/16.
 */
public class MergeRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> implements DividerItemDecoration.DecoratorInterface {

    private static final int SECTION_TYPE = Integer.MAX_VALUE;
    private int mSectionResourceId;
    private int mTextResourceId;
    private List<Section> sectionList;
    private LayoutInflater inflater;

    public MergeRecyclerViewAdapter(Context context, int sectionResourceId, int textResourceId) {

        mSectionResourceId = sectionResourceId;
        mTextResourceId = textResourceId;
        sectionList = new ArrayList();
        inflater = LayoutInflater.from(context);
    }

    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int typeView) {

        SectionModel sectionModel = getSectionModelForTypeView(typeView);

        if (typeView == SECTION_TYPE) {

            return new SectionViewHolder(inflater.inflate(mSectionResourceId,
                    parent, false), mTextResourceId);
        }

        Section section = sectionModel.getSection();

        RecyclerViewAdapter.ViewHolder viewHolder = (RecyclerViewAdapter.ViewHolder)
                section.getAdapter().onCreateViewHolder(parent,
                        section.getChieldTypeViewForSectionTypeView(typeView));

        viewHolder.setMergeRecyclerViewAdapter(this);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final RecyclerViewAdapter.ViewHolder viewHolder, int position) {

        SectionModel sectionModel = getSectionModelForPosition(position);
        Section section = sectionModel.getSection();

        if (sectionModel.isSectionHeader()) {

            ((SectionViewHolder) viewHolder).title.setText(section.getTitle());

        } else {

            section.getAdapter().onBindViewHolder(viewHolder, sectionModel.getItemAdapterPosition());
        }
    }

    @Override
    public int getItemViewType(int position) {

        SectionModel sectionModel = getSectionModelForPosition(position);

        if (sectionModel.isSectionHeader()) {

            return SECTION_TYPE;
        }

        Section section = sectionModel.getSection();
        return section.getSectionTypeView(sectionModel.getItemAdapterPosition());
    }

    @Override
    public int getItemCount() {

        int size = 0;

        for (Section section : sectionList) {

            // É necessário verificar se está vazio pois o header e footer não são itens válidos para serem incluidos
            if (!section.isEmpty()) {

                size += section.getCount();
                size += 1;
            }
        }

        return size;
    }

    public void addSections(Section... sections) {

        for (Section section : sections) {

            RecyclerView.Adapter adapter = section.getAdapter();

            if (adapter != null) {

                adapter.registerAdapterDataObserver(new AdapterDataObserver());
            }

            sectionList.add(section);
        }
    }

    public void addSection(int position, Section section) {

        sectionList.add(position, section);
    }

    public Section getSection(int position) {

        if (sectionList == null || sectionList.isEmpty()) {

            return null;
        }

        int pos = (position <= 0) ? 0 : (position >= sectionList.size() ? (sectionList.size() - 1) : position);

        return sectionList.get(pos);
    }

    public void removeSection(int position) {

        Section section = getSection(position);

        if (section != null) {

            sectionList.remove(position);
            notifyItemRemoved(position);
        }
    }

    @Override
    public Drawable getDivider(int position) {

        SectionModel sectionModel = getSectionModelForPosition(position);

        if (sectionModel != null) {

            Section section = sectionModel.getSection();
            return section.getAdapter().getDivider(position);
        }

        return null;
    }

    public static class SectionModel {

        private Section section;
        private int itemAdapterPosition;
        private boolean isSectionHeader;

        public SectionModel(Section section, int itemAdapterPosition, boolean isSectionHeader) {

            this.section = section;
            this.itemAdapterPosition = itemAdapterPosition;
            this.isSectionHeader = isSectionHeader;
        }

        public SectionModel(Section section) {

            this(section, 0, false);
        }

        public Section getSection() {
            return section;
        }

        public void setSection(Section section) {
            this.section = section;
        }

        public int getItemAdapterPosition() {
            return itemAdapterPosition;
        }

        public void setItemAdapterPosition(int itemAdapterPosition) {

            this.itemAdapterPosition = itemAdapterPosition;
        }

        public boolean isSectionHeader() {
            return isSectionHeader;
        }

        public void setIsSectionHeader(boolean isSectionHeader) {

            this.isSectionHeader = isSectionHeader;
        }
    }

    //==============================================================================================
    // Metodos privados
    //==============================================================================================

    private class SectionViewHolder extends RecyclerViewAdapter.ViewHolder {

        public TextView title;

        public SectionViewHolder(View view, int mTextResourceid) {

            super(view);
            title = (TextView) view.findViewById(mTextResourceid);
        }
    }

    // TODO verificar se é necessário ajustar as posições
    private class AdapterDataObserver extends RecyclerView.AdapterDataObserver {

        @Override
        public void onChanged() {

            notifyDataSetChanged();
        }

        @Override
        public void onItemRangeChanged(int positionStart, int itemCount) {

            notifyItemRangeChanged(positionStart, itemCount);
        }

        @Override
        public void onItemRangeInserted(int positionStart, int itemCount) {

            notifyItemRangeInserted(positionStart, itemCount);
        }

        @Override
        public void onItemRangeRemoved(int positionStart, int itemCount) {

            notifyItemRangeRemoved(positionStart, itemCount);
        }
    }

    public synchronized SectionModel getSectionModelForPosition(int position) {

        for (Section section : sectionList) {

            if (!section.isEmpty() && position <= section.getCount()) {

                int itemPosition = (position > section.getSectionPosition() ? (position - 1) : position);
                boolean isSectionHeader = position == section.getSectionPosition();

                return new SectionModel(section, itemPosition, isSectionHeader);
            }

            if (!section.isEmpty()) {

                position -= section.getCount() + 1;
            }
        }

        return null;
    }

    private SectionModel getSectionModelForTypeView(int typeView) {

        for (Section section : sectionList) {

            if (section.hasSectionTypeView(typeView)) {

                return new SectionModel(section);
            }
        }

        return null;
    }
}
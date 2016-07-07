package com.qranio.modulea.view.custom;

import com.qranio.modulea.view.adapter.RecyclerViewAdapter;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;

/**
 * Created by Rafael C. Almeida on 05/05/16.
 */
public class Section {

    private RecyclerViewAdapter adapter;
    private String title;
    private int sectionPosition;
    private HashMap<Integer, Integer> sectionTypeMap;

    public Section(RecyclerViewAdapter adapter, String title) {

        this.adapter = adapter;
        this.title = title;
        this.sectionTypeMap = new HashMap<Integer, Integer>(0);
    }

    public Section(RecyclerViewAdapter adapter, String title, int sectionPosition) {

        this(adapter, title);
        this.sectionPosition = sectionPosition;
    }

    public RecyclerViewAdapter getAdapter() {
        return adapter;
    }

    public void setAdapter(RecyclerViewAdapter adapter) {
        this.adapter = adapter;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getCount() {

        // Retorna todas as posições incluindo o header e o footer
        return adapter != null ? adapter.getItemCount() : 0;
    }

    public boolean isEmpty() {

        // Verifica os itens da lista excluindo o header e footer
        return adapter == null || adapter.isEmpty();
    }

    public int getSectionPosition() {

        return sectionPosition;
    }

    public void setSectionPosition(int sectionPosition) {

        this.sectionPosition = sectionPosition;
    }

    public boolean hasChieldTypeView(int typeView) {

        return sectionTypeMap.containsValue(typeView);
    }

    public boolean hasSectionTypeView(int typeView) {

        return sectionTypeMap.containsKey(typeView);
    }

    public int getSectionTypeView(int position) {

        int typeView = adapter.getItemViewType(position);

        if (!hasChieldTypeView(typeView)) {

            int id = new Random().nextInt();
            sectionTypeMap.put(id, typeView);

            return id;
        }

        return getSectionTypeViewForChieldTypeView(typeView);
    }

    public int getSectionTypeViewForChieldTypeView(int typeView) {

        Iterator<Map.Entry<Integer, Integer>> iterator = sectionTypeMap.entrySet().iterator();

        while (iterator.hasNext()) {

            Map.Entry<Integer, Integer> next = iterator.next();

            if (next.getValue() == typeView) {

                return next.getKey();
            }
        }

        return -1;
    }

    public int getChieldTypeViewForSectionTypeView(int typeView) {

        Iterator<Map.Entry<Integer, Integer>> iterator = sectionTypeMap.entrySet().iterator();

        while (iterator.hasNext()) {

            Map.Entry<Integer, Integer> next = iterator.next();

            if (next.getKey() == typeView) {

                return next.getValue();
            }
        }

        return -1;
    }
}

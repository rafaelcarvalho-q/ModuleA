package com.qranio.modulea.view.fragment;

import android.os.Bundle;
import android.support.annotation.ColorRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.qranio.modulea.R;
import com.qranio.modulea.controller.LoginController;
import com.qranio.modulea.interfaces.ClickListener;
import com.qranio.modulea.model.User;
import com.qranio.modulea.view.adapter.ListAdapter;
import com.qranio.modulea.view.custom.DividerItemDecoration;

import java.util.List;

/**
 * Created by Rafael C. Almeida on 07/07/16.
 */
public class ListFragment extends Fragment {

    private LinearLayoutManager linearLayoutManager;
    private ListAdapter adapter;
    private LoginController controller;

    // Views
    private View view;
    private RecyclerView rvList;
    private SwipeRefreshLayout swipeContainer;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_list, container, true);

        controller = new LoginController();
        adapter = new ListAdapter(getContext(), true);
        linearLayoutManager = new LinearLayoutManager(getActivity());

        setScreenComponents();
        setListeners();
        listUsers();

        return view;
    }

    public void setSwipeRefreshLayoutColorSchemeResources(@ColorRes @NonNull int... colorResIds) {

        swipeContainer.setColorSchemeResources(colorResIds);
    }

    public void setClickListener(ClickListener<User> itemClickListener) {

        adapter.setClickListener(itemClickListener);
    }

    //==============================================================================================
    // Métodos Privados
    //==============================================================================================

    private void setScreenComponents() {

        swipeContainer = (SwipeRefreshLayout) view.findViewById(R.id.swipeContainer);
        rvList = (RecyclerView) view.findViewById(R.id.rv_list);
        swipeContainer = (SwipeRefreshLayout) view.findViewById(R.id.swipeContainer);

        rvList.setLayoutManager(linearLayoutManager);
        rvList.setItemAnimator(new DefaultItemAnimator());
        rvList.addItemDecoration(new DividerItemDecoration());
        rvList.setAdapter(adapter);
    }

    private void setListeners() {
    }

    private void listUsers() {

        List<User> users = controller.loadUsers();

        adapter.showLoadMore(true);
        adapter.addItens(users);
        adapter.notifyDataSetChanged();
    }
}
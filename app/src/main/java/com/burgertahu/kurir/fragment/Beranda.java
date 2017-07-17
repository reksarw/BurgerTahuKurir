package com.burgertahu.kurir.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.burgertahu.kurir.R;
import com.burgertahu.kurir.adapter.OrderAdapter;


public class Beranda extends Fragment{

    public Beranda() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.halaman_beranda, container, false);
        RecyclerView rv = (RecyclerView) rootView.findViewById(R.id.rvBeranda);

        OrderAdapter adapter = new OrderAdapter(getContext().getApplicationContext());
        rv.setAdapter(adapter);
        rv.setHasFixedSize(true);
        rv.setLayoutManager(new LinearLayoutManager(getActivity()));

        return rootView;
    }

}
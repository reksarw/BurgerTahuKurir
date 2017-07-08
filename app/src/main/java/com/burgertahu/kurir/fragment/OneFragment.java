package com.burgertahu.kurir.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.burgertahu.kurir.R;
import com.burgertahu.kurir.adapter.RecyclerAdapter;


public class OneFragment extends Fragment{

    String [] name={"Apple","Facebook","Twitter","Google",
            "Microsoft","Wikipedia","Yahoo","Youtube"};

    String [] deskripsi = {"Apple is" , "Facebook is" , "Twitter is" , "Google is" , "Microsoft is"
            ,"Wikipedia is","Yahoo is","Youtube is"};

    public OneFragment() {
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

        RecyclerAdapter adapter = new RecyclerAdapter(name , deskripsi , getContext().getApplicationContext());
        rv.setAdapter(adapter);
        rv.setHasFixedSize(true);
        rv.setLayoutManager(new LinearLayoutManager(getActivity()));

        return rootView;
    }

}
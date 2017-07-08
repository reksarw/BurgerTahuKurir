package com.burgertahu.kurir.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.burgertahu.kurir.R;
import com.burgertahu.kurir.helper.RecyclerViewHolder;


public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerViewHolder> {

    private final Context context;
    private String[] mDataNama , mDataDekripsi;
    LayoutInflater inflater;

    public RecyclerAdapter(String[] myDataNama , String[] myDataDeskripsi , Context context) {
        mDataNama = myDataNama;
        mDataDekripsi = myDataDeskripsi;
        this.context=context;
        inflater=LayoutInflater.from(context);
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v=inflater.inflate(R.layout.list_cards, parent, false);

        RecyclerViewHolder viewHolder = new RecyclerViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {

        holder.tv1.setText(mDataNama[position]);
        holder.tv1.setOnClickListener(clickListener);
        holder.tv1.setTag(holder);
        holder.tv2.setText(mDataDekripsi[position]);
        holder.tv2.setOnClickListener(clickListener);
        holder.tv2.setTag(holder);
    }

    View.OnClickListener clickListener=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            RecyclerViewHolder vholder = (RecyclerViewHolder) v.getTag();

            int position = vholder.getPosition();

            Toast.makeText(context , "Menu ini berada di posisi " + position, Toast.LENGTH_LONG).show();


        }
    };

    @Override
    public int getItemCount() {
        return mDataNama.length;
    }
}
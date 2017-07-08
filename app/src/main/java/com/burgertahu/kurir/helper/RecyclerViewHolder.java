package com.burgertahu.kurir.helper;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.burgertahu.kurir.R;

public class RecyclerViewHolder extends RecyclerView.ViewHolder {

    public TextView tv1,tv2;

    public RecyclerViewHolder(View itemView) {
        super(itemView);

        tv1 = (TextView) itemView.findViewById(R.id.cvNama);
        tv2 = (TextView) itemView.findViewById(R.id.cvDeskripsi);
    }
}
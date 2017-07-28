package com.burgertahu.kurir.helper;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.burgertahu.kurir.R;
import com.burgertahu.kurir.activity.LoginActivity;
import com.burgertahu.kurir.activity.OrderActivity;

public class OrderViewHolder extends RecyclerView.ViewHolder {

    public TextView cvNama ,cvAlamat , cvKeterangan, cvTanggalWaktu;
    private Context context;

    public OrderViewHolder(final View itemView , final String[] mDataNama) {
        super(itemView);
        context = itemView.getContext().getApplicationContext();
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent pindah = new Intent(context, OrderActivity.class);
                pindah.putExtra("INTENT_TANGGAL_WAKTU" , "" + mDataNama[getPosition()]);
                context.startActivity(pindah);
            }
        });

        cvNama = (TextView) itemView.findViewById(R.id.cvNama);
        cvAlamat = (TextView) itemView.findViewById(R.id.cvAlamat);
        cvKeterangan = (TextView) itemView.findViewById(R.id.cvKeterangan);
        cvTanggalWaktu = (TextView) itemView.findViewById(R.id.cvTanggalWaktu);
    }
}
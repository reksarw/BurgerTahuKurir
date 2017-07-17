package com.burgertahu.kurir.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import com.burgertahu.kurir.config.BaseApp;

import com.burgertahu.kurir.R;
import com.burgertahu.kurir.helper.OrderViewHolder;

import java.util.Calendar;


public class OrderAdapter extends RecyclerView.Adapter<OrderViewHolder> {

    String BASEURL = BaseApp.endpointUrl;
    String [] name={"Dian Sugianto Kusuma" , "Ratna Utari" , "Suryadi Purnama","Farida Lestari"};

    String [] alamat = {"Jl.Bandung No 6" , "Jl.Jakarta No 13" , "Jl.Jakarta No 5" , "Jl.Bogor No 97"};

    String [] tanggal_waktu = {"Jumat, 7 Juli 2017 16:12" , "Rabu, 5 Juli 2017 12:00" , "Selasa, 2 Juli 2017 13:12" , "Senin, 27 Maret 2017 08:12"};

    private final Context context;
    private String[] mDataNama , mDataAlamat;
    LayoutInflater inflater;

    public OrderAdapter(Context context) {
        mDataNama = name;
        mDataAlamat = alamat;
        this.context=context;
        inflater=LayoutInflater.from(context);
    }

    @Override
    public OrderViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v=inflater.inflate(R.layout.list_order, parent, false);

        OrderViewHolder viewHolder = new OrderViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(OrderViewHolder holder, int position) {
        holder.cvNama.setText(mDataNama[position]);
        holder.cvNama.setOnClickListener(clickListener);
        holder.cvNama.setTag(holder);
        holder.cvAlamat.setText(mDataAlamat[position]);
        holder.cvAlamat.setOnClickListener(clickListener);
        holder.cvAlamat.setTag(holder);
        holder.cvKeterangan.setText("Keterangan " + position);
        holder.cvTanggalWaktu.setText(tanggal_waktu[position]);
    }

    View.OnClickListener clickListener=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            OrderViewHolder vholder = (OrderViewHolder) v.getTag();

            int position = vholder.getPosition();

            Toast.makeText(context , "Menu ini berada di posisi " + position, Toast.LENGTH_LONG).show();

        }
    };

    @Override
    public int getItemCount() {
        return mDataNama.length;
    }
}
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

import java.text.ParseException;
import java.util.Calendar;


public class OrderAdapter extends RecyclerView.Adapter<OrderViewHolder> {

    String BASEURL = BaseApp.endpointUrl;
    String [] name={"Dian Sugianto Kusuma" , "Ratna Utari" , "Suryadi Purnama","Farida Lestari"};

    String [] alamat = {"Jl.Bandung No 6" , "Jl.Jakarta No 13" , "Jl.Jakarta No 5" , "Jl.Bogor No 97"};

    String [] tanggal_waktu = {"2017-7-22 12:12:12" , "2017-7-22 19:15:12" , "2017-7-15 17:12:12"
    , "2017-7-12 15:22:12"};

    private final Context context;
    private String[] mDataNama , mDataAlamat;
    LayoutInflater inflater;
    BaseApp baseApp = new BaseApp();

    public OrderAdapter(Context context) {
        mDataNama = name;
        mDataAlamat = alamat;
        this.context=context;
        inflater=LayoutInflater.from(context);
    }

    @Override
    public OrderViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v=inflater.inflate(R.layout.list_order, parent, false);

        OrderViewHolder viewHolder = new OrderViewHolder(v , tanggal_waktu);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(OrderViewHolder holder, int position) {
        holder.cvNama.setText(mDataNama[position]);
        holder.cvNama.setTag(holder);
        holder.cvAlamat.setText(mDataAlamat[position]);
        holder.cvAlamat.setTag(holder);
        holder.cvKeterangan.setText("Keterangan " + position);
        holder.cvTanggalWaktu.setText(baseApp.humanTime(tanggal_waktu[position]));
    }

    @Override
    public int getItemCount() {
        return mDataNama.length;
    }
}
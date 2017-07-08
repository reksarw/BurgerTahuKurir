package com.burgertahu.kurir.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.burgertahu.kurir.R;
import com.burgertahu.kurir.helper.SettingHolder;

public class SettingAdapter  extends RecyclerView.Adapter<SettingHolder> {

    private final Context context;

    int[] myContent = new int[]{R.string.txtChangeProfile ,R.string.txtChangePwd , R.string.txtLogout};
    int[] myIconList = new int[]{R.drawable.ic_user , R.drawable.lock , R.drawable.ic_logout};

    LayoutInflater inflater;

    public SettingAdapter(Context context) {
        this.context=context;
        inflater=LayoutInflater.from(context);
    }

    @Override
    public SettingHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = inflater.inflate(R.layout.list_settings, parent, false);

        SettingHolder viewHolder = new SettingHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(SettingHolder holder, final int position) {
        holder.icon.setImageResource(myIconList[position]);
        holder.icon.setTag(holder);
        holder.content.setText(myContent[position]);
        holder.content.setTag(holder);
    }

    @Override
    public int getItemCount() {
        return myContent.length;
    }
}

package com.burgertahu.kurir.helper;

import android.content.Intent;
import android.graphics.Color;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.burgertahu.kurir.R;
import com.burgertahu.kurir.activity.PasswordActivity;
import com.burgertahu.kurir.activity.ProfilActivity;

public class SettingHolder extends RecyclerView.ViewHolder {

    public TextView content;
    public ImageView icon , navigation;
    public RelativeLayout RelativeLayout;

    public SettingHolder(final View itemView) {
        super(itemView);

        icon = (ImageView) itemView.findViewById(R.id.txtIcon);
        content = (TextView) itemView.findViewById(R.id.txtContent);
        navigation = (ImageView) itemView.findViewById(R.id.txtNavigation);
        RelativeLayout = (RelativeLayout) itemView.findViewById(R.id.placeSnackBar);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch(getAdapterPosition())
                {
                    case 0:
                        v.getContext().startActivity(new Intent(v.getContext(), ProfilActivity.class));
                        break;

                    case 1:
                        v.getContext().startActivity(new Intent(v.getContext(), PasswordActivity.class));
                        break;

                    case 2:
                        Snackbar snackbar = Snackbar
                                .make(RelativeLayout, "Apakah yakin ingin keluar?", Snackbar.LENGTH_LONG)
                                .setAction("Ya, keluar", new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                        Toast.makeText(itemView.getContext(), "Yes clicked", Toast.LENGTH_LONG).show();
                                    }
                                });
                        snackbar.setActionTextColor(Color.RED);
                        View sbView = snackbar.getView();
                        TextView textView = (TextView) sbView.findViewById(android.support.design.R.id.snackbar_text);
                        textView.setTextColor(Color.YELLOW);
                        snackbar.show();
                        break;
                }
            }
        });
    }
}
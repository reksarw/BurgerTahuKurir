package com.burgertahu.kurir.activity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.burgertahu.kurir.R;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class ProfilActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ImageView imgProfile = (ImageView) findViewById(R.id.imgProfile);

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Ubah Profil");

        FrameLayout frame = (FrameLayout) findViewById(R.id.container);
        LayoutInflater.from(getApplicationContext()).inflate(R.layout.form_profile, frame , true);

        TextView btnSave = (TextView) findViewById(R.id.btnSave);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Simpan clicked", Toast.LENGTH_SHORT).show();
            }
        });

        if ( imgProfile == null)
        {
            // loading
            Toast.makeText(getApplicationContext(),"Loading...", Toast.LENGTH_SHORT).show();
        }
        else
        {
            Picasso.with(getApplicationContext()).load("http://i.imgur.com/DvpvklR.png").into(imgProfile);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                break;
        }
        return true;
    }
}

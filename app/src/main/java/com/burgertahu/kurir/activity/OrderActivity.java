package com.burgertahu.kurir.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.burgertahu.kurir.R;
import com.burgertahu.kurir.config.BaseApp;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class OrderActivity extends AppCompatActivity {

    Button btnAntar , btnRute;
    TextView txtPesanan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        BaseApp baseApp = new BaseApp();
        Bundle bundle = getIntent().getExtras();

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Order Detail");
        getSupportActionBar().setSubtitle(baseApp.humanTime(bundle.getString("INTENT_TANGGAL_WAKTU")));

        FrameLayout frame = (FrameLayout) findViewById(R.id.container);
        LayoutInflater.from(getApplicationContext()).inflate(R.layout.detail_order, frame , true);

        ImageView icon_sms = (ImageView) findViewById(R.id.iconSms);
        ImageView icon_telp = (ImageView) findViewById(R.id.iconTelp);

        txtPesanan = (TextView) findViewById(R.id.txtLihatPesanan);

        txtPesanan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent pindah = new Intent(getApplicationContext(), PesananActivity.class);
                pindah.putExtra("ID_PESANAN" , "5");
                getApplicationContext().startActivity(pindah);
            }
        });

        icon_sms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"ICON SMS CLICK", Toast.LENGTH_SHORT).show();
            }
        });

        icon_sms.setOnHoverListener(new View.OnHoverListener() {
            @Override
            public boolean onHover(View view, MotionEvent motionEvent) {
                return true;
            }
        });

        icon_telp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"ICON TELP CLICK", Toast.LENGTH_SHORT).show();
            }
        });

        btnAntar = (Button) findViewById(R.id.btnAntar);
        btnRute = (Button) findViewById(R.id.btnLihatRute);
        btnRute.setVisibility(View.GONE);

        btnAntar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnAntar.setVisibility(View.GONE);
                btnRute.setVisibility(View.VISIBLE);
            }
        });
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

    public void alertDialogShow()
    {
        AlertDialog.Builder builder1 = new AlertDialog.Builder(getApplicationContext());
        builder1.setMessage("Write your message here.");
        builder1.setCancelable(true);

        builder1.setPositiveButton(
                "Yes",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });

        builder1.setNegativeButton(
                "No",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });

        AlertDialog alert11 = builder1.create();
        alert11.show();
    }
}
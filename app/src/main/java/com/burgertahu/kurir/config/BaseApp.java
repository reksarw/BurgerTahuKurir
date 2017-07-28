package com.burgertahu.kurir.config;

import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.text.format.DateFormat;
import android.util.DisplayMetrics;
import android.util.Log;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class BaseApp extends Application {

    public static final String endpointUrl = "http://localhost:5000/";
    private String[] listBulan = { "Januari" , "Februari" , "Maret" , "April" , "Mei" , "Juni"
            , "Juli" , "Agustus" , "September" , "Oktober" , "November" , "Desember"};
    private String[] listHari = { "Senin","Selasa","Rabu","Kamis","Jumat","Sabtu","y"};

    @Override
    public void onCreate()
    {
        super.onCreate();
        setLocate("id");
    }

    public static boolean getKoneksi(Context context) {

        ConnectivityManager con_manager = (ConnectivityManager)
                context.getSystemService(Context.CONNECTIVITY_SERVICE);

        if (con_manager.getActiveNetworkInfo() != null
                && con_manager.getActiveNetworkInfo().isAvailable()
                && con_manager.getActiveNetworkInfo().isConnected()) {
            return true;
        } else {
            return false;
        }
    }

    public void setLocate(String lang)
    {
        Locale myLocale = new Locale(lang);
        Resources res = getResources();
        DisplayMetrics dm = res.getDisplayMetrics();
        Configuration conf = res.getConfiguration();
        conf.locale = myLocale;
        res.updateConfiguration(conf, dm);
    }

    public String humanTime(String dateTime){
        String tanggalWaktu = null;

        String[] separated = dateTime.split(" ");
        String[] tanggal = separated[0].trim().split("-");
        String[] waktu = separated[1].trim().split(":");

        SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = fmt.parse(separated[0].trim());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        SimpleDateFormat fmtOut = new SimpleDateFormat("EEEE");

        tanggalWaktu = fmtOut.format(date);
        tanggalWaktu += " , " + tanggal[2];
        tanggalWaktu += " " + listBulan[Integer.parseInt(String.valueOf(Integer.parseInt(tanggal[1])- 1))];
        tanggalWaktu += " " + tanggal[0];
        tanggalWaktu += " " + waktu[0] + ":" + waktu[1];

        return tanggalWaktu;
    }

}

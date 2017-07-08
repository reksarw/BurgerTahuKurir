package com.burgertahu.kurir.activity;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.burgertahu.kurir.R;

import java.util.Locale;

public class LoginActivity extends AppCompatActivity {

//    Spinner spinner;
//
//    String [] ListLanguage = {"Bahasa Indonesia" , "English"};
//    String [] ListLocale = {"id" , "en"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        /* Font setting */
        String fontPath= "fonts/dancing_in_the_rainbow.ttf";
        Typeface type = Typeface.createFromAsset(getAssets(), fontPath);
        TextView txtAppName = (TextView) findViewById(R.id.appName);
        txtAppName.setTypeface(type);
        EditText inputUsr = (EditText) findViewById(R.id.inputUsername);
        EditText inputPwd = (EditText) findViewById(R.id.inputPassword);
        inputUsr.setTypeface(Typeface.SERIF);
        inputPwd.setTypeface(Typeface.SERIF);
        /* Font setting */

        Button btnMasuk = (Button) findViewById(R.id.btnLogin);

        btnMasuk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pindah = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(pindah);
            }
        });

//        spinner = (Spinner) findViewById(R.id.spinner);
//        ArrayAdapter <String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, ListLanguage);
//        spinner.setAdapter(adapter);
//
//        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                int index = spinner.getSelectedItemPosition();
//                setLocate(ListLocale[index] , position);
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> parent) {
//            }
//        });
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
}

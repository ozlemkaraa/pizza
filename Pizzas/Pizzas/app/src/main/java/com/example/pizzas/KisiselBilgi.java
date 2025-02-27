package com.example.pizzas;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;

import android.widget.CheckBox;


public class KisiselBilgi extends AppCompatActivity {
    EditText etc, etad, etsad, edt,  etk;
    Button btc, btsiparis;
    CheckBox checkBox;
    VeriTabani db;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kisisel_bilgi);

        btc = findViewById(R.id.btgeri);
        btsiparis = findViewById(R.id.btsiparis);
        etad = findViewById(R.id.etad);
        etsad = findViewById(R.id.etsad);
        edt = findViewById(R.id.edt);
        etc = findViewById(R.id.etc);
        checkBox = findViewById(R.id.checkBox3);
        db = new VeriTabani(KisiselBilgi.this,"dbtablo",null,1);



        btsiparis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String isim = etad.getText().toString();
                String soyisim = etsad.getText().toString();
                String adres = edt.getText().toString();
                String telefon = etc.getText().toString();
                long recordid = db.saveNewUserData(isim, soyisim, adres, telefon);

                if (etad.getText().toString().trim().isEmpty()) {
                    etad.setError("Bu alan boş bırakılamaz");
                }

                if (etsad.getText().toString().trim().isEmpty()) {
                    etsad.setError("Bu alan boş bırakılamaz");
                }

                if (edt.getText().toString().trim().isEmpty()) {
                    edt.setError("Bu alan boş bırakılamaz");
                }

                if (etc.getText().toString().trim().isEmpty()) {
                    etc.setError("Bu alan boş bırakılamaz");
                }

                if (!etad.getText().toString().trim().isEmpty() &&
                        !etsad.getText().toString().trim().isEmpty() &&
                        !edt.getText().toString().trim().isEmpty() &&
                        !etc.getText().toString().trim().isEmpty()) {

                    Intent SiparisOlustu = new Intent(KisiselBilgi.this, SiparisOlustuNew.class);
                    startActivity(SiparisOlustu);
                }

            }

        });


        btc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (isChecked) {
                    Intent intent = new Intent(KisiselBilgi.this, krediKarti.class);
                    startActivity(intent);
                }
            }
        });
    }
}


package com.example.pizzas;

import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import java.util.Locale;

public class KendinSecPizza extends AppCompatActivity {
    Button btko,btks;
    TextView etfs;
    Spinner sps;
    double totalAmount = 175;



    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kendin_sec_pizza);

        btks = findViewById(R.id.btks);
        btko = findViewById(R.id.btko);
        etfs=findViewById(R.id.etfs);
        sps=findViewById(R.id.sps);

        int selectedItemPosition = sps.getSelectedItemPosition();

        sps.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                switch (position) {
                    case 0:
                        totalAmount = 175.0;
                        etfs.setText(String.format(Locale.getDefault(), "Toplam Tutar: %.2f ₺", totalAmount));
                        break;
                    case 1:
                        totalAmount = 200.0;
                        etfs.setText(String.format(Locale.getDefault(), "Toplam Tutar: %.2f ₺", totalAmount));
                        break;
                    case 2:
                        totalAmount = 200.0;
                        etfs.setText(String.format(Locale.getDefault(), "Toplam Tutar: %.2f ₺", totalAmount));
                        break;
                    case 3:
                        totalAmount = 200.0;
                        etfs.setText(String.format(Locale.getDefault(), "Toplam Tutar: %.2f ₺", totalAmount));
                        break;
                    case 4:
                        totalAmount = 195.0;
                        etfs.setText(String.format(Locale.getDefault(), "Toplam Tutar: %.2f ₺", totalAmount));
                        break;
                    case 5:
                        totalAmount = 190.0;
                        etfs.setText(String.format(Locale.getDefault(), "Toplam Tutar: %.2f ₺", totalAmount));
                        break;
                }

            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        btks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sonraki=new Intent(KendinSecPizza.this,KisiselBilgi.class);
                startActivity(sonraki);
            }

        });

        btko.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent önceki=new Intent(KendinSecPizza.this,MainActivity.class);
                startActivity(önceki);
            }
        });

    }
}
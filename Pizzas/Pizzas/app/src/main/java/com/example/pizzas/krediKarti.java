package com.example.pizzas;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class krediKarti extends AppCompatActivity {

    EditText kartnumet;
    EditText sktet;
    EditText cvvet;
    Button onaybt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kredi_karti);

        kartnumet = findViewById(R.id.kartnumet);
        sktet = findViewById(R.id.sktet);
        cvvet = findViewById(R.id.cvvet);
        onaybt = findViewById(R.id.onaybt);

        onaybt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validateInputs()) {
                    performPayment();
                    finish();
                } else {
                    Toast.makeText(krediKarti.this, "Lütfen tüm bilgileri girin", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void performPayment() {
        String cardNumber = kartnumet.getText().toString();
        String expirationDate = sktet.getText().toString();
        String cvv = cvvet.getText().toString();


        processPayment(cardNumber, expirationDate, cvv);
    }

    private boolean validateInputs() {
        String cardNumber = kartnumet.getText().toString();
        String expirationDate = sktet.getText().toString();
        String cvv = cvvet.getText().toString();

        return !cardNumber.isEmpty() && !expirationDate.isEmpty() && !cvv.isEmpty();
    }

    private void processPayment(String cardNumber, String expirationDate, String cvv) {

        Toast.makeText(this, "Ödeme Başarılı", Toast.LENGTH_SHORT).show();
    }
}



package com.example.pizzas;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import java.util.Locale;

public class PizzaSecenek extends AppCompatActivity {



    private RadioGroup radioGroup;
    private RadioButton rb1, rb2, rb3, rb4;
    private Spinner spinner;
    private TextView etf;
    private Button btso, btss;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pizza_secenek);

        radioGroup = findViewById(R.id.radioGroup);
        rb1 = findViewById(R.id.rb1);
        rb2 = findViewById(R.id.rb2);
        rb3 = findViewById(R.id.rb3);
        rb4 = findViewById(R.id.rb4);
        spinner = findViewById(R.id.spinner);
        etf = findViewById(R.id.etf);
        btso = findViewById(R.id.btso);
        btss = findViewById(R.id.btss);


        radioGroup.setOnCheckedChangeListener((group, checkedId) -> updateTotalAmount());


        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                updateTotalAmount();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {

            }
        });

        btso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent anasayfa=new Intent(PizzaSecenek.this,MainActivity.class);
                startActivity(anasayfa);
            }

        });
        btss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sonraki=new Intent(PizzaSecenek.this,KisiselBilgi.class);
                startActivity(sonraki);
            }

        });

    }

    private void updateTotalAmount() {
        double totalAmount = 0;

        int selectedRadioButtonId = radioGroup.getCheckedRadioButtonId();
        RadioButton selectedRadioButton = findViewById(selectedRadioButtonId);

        if (selectedRadioButton != null) {
            String tagValue = selectedRadioButton.getTag().toString();
            totalAmount += Double.parseDouble(tagValue);
        }


        int selectedItemPosition = spinner.getSelectedItemPosition();
        double spinnerPrice = getSpinnerPrice(selectedItemPosition);
        totalAmount += spinnerPrice;


        etf.setText(String.format(Locale.getDefault(), "Toplam Tutar: %.2f ₺", totalAmount));
    }

    private double getSpinnerPrice(int position) {

        double itemPrice = 0;

        //
        switch (position) {
            case 0:
                itemPrice = 0.0;
                break;
            case 1:
                itemPrice = 25.0;
                break;
            case 2:
                itemPrice = 25.0;
                break;
            case 3:
                itemPrice = 25.0;
                break;
            case 4:
                itemPrice = 20.0;
                break;
            case 5:
                itemPrice = 15.0;
                break;

        }

        return itemPrice;
    }



}
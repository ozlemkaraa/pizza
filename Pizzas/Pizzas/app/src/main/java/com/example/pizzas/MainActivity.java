package com.example.pizzas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
public class MainActivity extends AppCompatActivity {
    Button bts, bty;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bts = findViewById(R.id.bts);
        bty = findViewById(R.id.bty);


        bty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pizzayap=new Intent(MainActivity.this,KendinSecPizza.class);
                startActivity(pizzayap);
            }

        });



        bts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pizzasec=new Intent(MainActivity.this,PizzaSecenek.class);
                startActivity(pizzasec);
            }

        });


    }
}
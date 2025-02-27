package com.example.pizzas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.airbnb.lottie.LottieAnimationView;


public class SiparisOlustuNew extends AppCompatActivity {

     LottieAnimationView anim;
     Button bitti;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_siparis_olustu_new);

        anim = findViewById(R.id.anim11);
        bitti = findViewById(R.id.bitti);

        bitti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent anaSayfa=new Intent(SiparisOlustuNew.this,MainActivity.class);
                startActivity(anaSayfa);
            }
        });

    }

}
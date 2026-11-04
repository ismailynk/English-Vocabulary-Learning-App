package com.company.kelimeezberprojesi1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Son extends AppCompatActivity {
    Button tekrar,anaSayfa;
    TextView puan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_son);
        tekrar = findViewById(R.id.buttonTekrar);
        anaSayfa = findViewById(R.id.buttonAnaSayfa);
        puan = findViewById(R.id.textViewPuan);
        Veriler veri = new Veriler();

        tekrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Son.this,MainActivity.class);
                startActivity(intent);
            }
        });
        anaSayfa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        puan.setText("PUANINZ: "+veri.setPuan());
    }
}
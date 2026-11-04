package com.company.kelimeezberprojesi1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;


public class MainActivity extends AppCompatActivity  {

    private wordviewmodel wordview;
    ImageView img;
    TextView turk , ing ;
    Button anladım;
    int tıklama =1;
    Veriler veri = new Veriler();

    String kelimeTr1 = veri.kelimeTr1;
    String kelimeTr2 = veri.kelimeTr2;
    String kelimeTr3 = veri.kelimeTr3;
    String kelimeTr4 = veri.kelimeTr4;
    String kelimeTr5 = veri.kelimeTr5;

    String kelimeIng1=veri.kelimeIng1;
    String kelimeIng2=veri.kelimeIng2;
    String kelimeIng3=veri.kelimeIng3;
    String kelimeIng4=veri.kelimeIng4;
    String kelimeIng5=veri.kelimeIng5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    //wordview = ViewModelProviders.of(this).get(wordviewmodel.class);


        img = findViewById(R.id.imageView);
        turk = findViewById(R.id.textViewTr);
        ing = findViewById(R.id.textViewIng);
        anladım = findViewById(R.id.buttonAnladım);

        ing.setText(kelimeIng1);
        turk.setText(kelimeTr1);



        // Anladım butonu tıklanma yeri
        anladım .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // her tıklamada
                tıklama++;
                if(tıklama == 6)
                {
                    tıklama=1;
                    anladım.setText("Anladım");

                    Intent intent = new Intent(MainActivity.this,imgToIng.class);
                    startActivity(intent);

                }
                else
                {
                    // yeni görsel
                    // yeni ingilizce kelime
                    // yeni türkçe kelime

                    if(tıklama == 1)
                    {
                        // görsel atama eklenecek
                        ing.setText(kelimeIng1);
                        turk.setText(kelimeTr1);
                    }
                    else if(tıklama == 2)
                    {
                        // görsel atama eklenecek
                        ing.setText(kelimeIng2);
                        turk.setText(kelimeTr2);
                    }
                    else if(tıklama == 3)
                    {
                        // görsel atama eklenecek
                        ing.setText(kelimeIng3);
                        turk.setText(kelimeTr3);
                    }
                    else if(tıklama == 4)
                    {
                        // görsel atama eklenecek
                        ing.setText(kelimeIng4);
                        turk.setText(kelimeTr4);
                    }
                    else
                    {
                        // görsel atama eklenecek
                        ing.setText(kelimeIng5);
                        turk.setText(kelimeTr5);
                        anladım.setText("Diğer Sayfa");
                    }

                 }



            }
        });

    }
}
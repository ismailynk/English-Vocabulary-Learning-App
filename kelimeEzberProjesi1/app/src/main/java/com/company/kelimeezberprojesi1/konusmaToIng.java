package com.company.kelimeezberprojesi1;

import android.content.Intent;
import android.speech.RecognizerIntent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Random;

public class konusmaToIng extends AppCompatActivity {

    TextView result,soru;
    ImageButton imgB;
    Button kontrol;

    String Ingkelime[] = new String[5];
    Random random = new Random();
    int Soru[] = {1,1,1,1,1};
    String Cevap;
    int puan = 0;

    Veriler veri = new Veriler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_konusma_to_ing);

        result = findViewById(R.id.textViewMic);
        imgB = findViewById(R.id.imageButton);
        soru = findViewById(R.id.textViewSoru);
        kontrol = findViewById(R.id.buttonKontrol);



        String ingKelime1 = veri.kelimeIng1;
        String ingKelime2 = veri.kelimeIng2;
        String ingKelime3 = veri.kelimeIng3;
        String ingKelime4 = veri.kelimeIng4;
        String ingKelime5 = veri.kelimeIng5;

        Ingkelime[0]=ingKelime1;
        Ingkelime[1]=ingKelime2;
        Ingkelime[2]=ingKelime3;
        Ingkelime[3]=ingKelime4;
        Ingkelime[4]=ingKelime5;

       Cevap =  randomSoru(Ingkelime);

        imgB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                konusmaToText();

            }
        });
        kontrol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(result.getText().toString().equalsIgnoreCase(soru.getText().toString())){
                    Toast.makeText(getApplicationContext(),"Tebrikler Doğru",Toast.LENGTH_SHORT).show();
                    puan+=10;

                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Üzgünüm  Yanlış",Toast.LENGTH_SHORT).show();
                    puan -= 10;
                }
                soru.setText("");
                Cevap =  randomSoru(Ingkelime);

            }
        });
    }

    public void konusmaToText()
    {
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.ENGLISH);

        startActivityForResult(intent,1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 1 && resultCode == RESULT_OK){
            ArrayList<String> speakResults = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
            result.setText(speakResults.get(0));
        }
    }

    public String randomSoru(String[] kelimeler){
        int soruSec = random.nextInt(5);
        int i ;
        for(i = 0; i<5 ;i++)
        {
            if(Soru[soruSec] == -1)
            {
                soruSec++;

                if(soruSec == 5)
                {
                    soruSec = 0;
                }
            }
            else
            {
                Soru[soruSec] = -1;
                soru.setText(kelimeler[soruSec]);
                break;
            }
        }

        if(i == 5){
            veri.getPuan(puan);
            Intent intent = new Intent(this,ImgToYazi.class);
            startActivity(intent);
        }
        return kelimeler[soruSec];
    }
}
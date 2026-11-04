package com.company.kelimeezberprojesi1;

import android.content.Intent;
import android.graphics.Color;
import android.os.CountDownTimer;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


import java.util.Random;

public class trToIng extends AppCompatActivity {

    Button A2,B2,C2,D2,Ok2;
    TextView tr;
    Random random = new Random();
    Button Bdizi2[] = new Button[4];
    String Ingkelime2Dizi[] = new String[5];
    String Trkelime2Dizi[] = new String[5];
    int Soru2[] = {1,1,1,1,1};
    int secilenSik = -1 ;
    int cevapSik=0;
    int cevapKelime=0;
    int puan = 0;
    Veriler veri = new Veriler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tr_to_ing2);


        tr = findViewById(R.id.textViewTurk);
        A2 = findViewById(R.id.buttonA2);
        B2 = findViewById(R.id.buttonB2);
        C2 = findViewById(R.id.buttonC2);
        D2 = findViewById(R.id.buttonD2);
        Ok2 = findViewById(R.id.buttonOk2);

        Bdizi2[0]=A2;
        Bdizi2[1]=B2;
        Bdizi2[2]=C2;
        Bdizi2[3]=D2;


        String ingKelime1 = veri.kelimeIng1;
        String ingKelime2 = veri.kelimeIng2;
        String ingKelime3 = veri.kelimeIng3;
        String ingKelime4 = veri.kelimeIng4;
        String ingKelime5 = veri.kelimeIng5;

        String TrKelime1 = veri.kelimeTr1;
        String TrKelime2 = veri.kelimeTr2;
        String TrKelime3 = veri.kelimeTr3;
        String TrKelime4 = veri.kelimeTr4;
        String TrKelime5 = veri.kelimeTr5;

        Ingkelime2Dizi[0]=ingKelime1;
        Ingkelime2Dizi[1]=ingKelime2;
        Ingkelime2Dizi[2]=ingKelime3;
        Ingkelime2Dizi[3]=ingKelime4;
        Ingkelime2Dizi[4]=ingKelime5;

        Trkelime2Dizi[0]=TrKelime1;
        Trkelime2Dizi[1]=TrKelime2;
        Trkelime2Dizi[2]=TrKelime3;
        Trkelime2Dizi[3]=TrKelime4;
        Trkelime2Dizi[4]=TrKelime5;

         cevapKelime = randomSoru(Trkelime2Dizi);
         cevapSik = randomCevap(cevapKelime);
         randomSiklar(cevapSik,cevapKelime);

        A2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bdizi2[0].setBackgroundColor(Color.YELLOW);
                Bdizi2[1].setBackgroundColor(Color.rgb(221,255,188));
                Bdizi2[2].setBackgroundColor(Color.rgb(221,255,188));
                Bdizi2[3].setBackgroundColor(Color.rgb(221,255,188));
                secilenSik = 0;

            }
        });
        B2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bdizi2[0].setBackgroundColor(Color.rgb(221,255,188));
                Bdizi2[1].setBackgroundColor(Color.YELLOW);
                Bdizi2[2].setBackgroundColor(Color.rgb(221,255,188));
                Bdizi2[3].setBackgroundColor(Color.rgb(221,255,188));
                secilenSik = 1;
            }
        });
        C2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bdizi2[0].setBackgroundColor(Color.rgb(221,255,188));
                Bdizi2[1].setBackgroundColor(Color.rgb(221,255,188));
                Bdizi2[2].setBackgroundColor(Color.YELLOW);
                Bdizi2[3].setBackgroundColor(Color.rgb(221,255,188));
                secilenSik = 2;

            }
        });
        D2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bdizi2[0].setBackgroundColor(Color.rgb(221,255,188));
                Bdizi2[1].setBackgroundColor(Color.rgb(221,255,188));
                Bdizi2[2].setBackgroundColor(Color.rgb(221,255,188));
                Bdizi2[3].setBackgroundColor(Color.YELLOW);
                secilenSik = 3;
            }
        });
        Ok2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(secilenSik == -1)
                {
                    Toast.makeText(getApplicationContext(),"Lütfen Bir Şıkkı Seçiniz",Toast.LENGTH_SHORT).show();

                }
                else
                {
                    if (cevapSik == secilenSik)
                    {

                        Bdizi2[cevapSik].setBackgroundColor(Color.GREEN);
                        puan += 10;
                        bekle();

                    }
                    else
                    {
                        Bdizi2[cevapSik].setBackgroundColor(Color.GREEN);
                        Bdizi2[secilenSik].setBackgroundColor(Color.RED);
                        puan -= 10;
                        bekle();
                        Soru2[cevapKelime] = 1;
                    }
                    secilenSik = -1;
                }

            }

        });

    }
    public int randomSoru(String[] kelimeler){
        int soruSec = random.nextInt(5);
        int i ;
        for(i = 0; i<5 ;i++)
        {
            if(Soru2[soruSec] == -1)
            {
                soruSec++;

                if(soruSec == 5)
                {
                    soruSec = 0;
                }
            }
            else
            {
                Soru2[soruSec] = -1;
                tr.setText(kelimeler[soruSec]);
                break;
            }
        }

        if(i == 5){
            veri.getPuan(puan);
            Intent intent = new Intent(this,ingToTr.class);
            startActivity(intent);
        }
        return soruSec;
    }
    public int randomCevap (int cevap){
        int cevapSec = random.nextInt(4);
        Bdizi2[cevapSec].setText(Ingkelime2Dizi[cevap]);
        return cevapSec;
    }
    public void randomSiklar(int cevapSik , int cevapKelime) {
        int kelimeler[]={1,1,1,1,1};
        int siklar[]={1,1,1,1};
        kelimeler[cevapKelime]=-1;
        siklar[cevapSik]=-1;

        for(int i = 0; i<3 ;i++ )
        {
            int sikSec = random.nextInt(4);
            if(siklar[sikSec]==-1)
            {
                i--;
            }
            else
            {
                for(int j = 0; j<4;j++)
                {
                    int kelimeSec = random.nextInt(5);
                    if(kelimeler[kelimeSec]==-1)
                    {
                        j--;
                    }
                    else
                    {
                        Bdizi2[sikSec].setText(Ingkelime2Dizi[kelimeSec]);
                        kelimeler[kelimeSec]=-1;
                        siklar[sikSec]=-1;
                        break;
                    }
                }
            }
        }
    }
    public void bekle (){
        new CountDownTimer(2000,1000){

            @Override
            public void onTick(long l) {

            }

            @Override
            public void onFinish() {
                cevapKelime = randomSoru(Trkelime2Dizi);
                cevapSik = randomCevap(cevapKelime);
                randomSiklar(cevapSik,cevapKelime);
                Bdizi2[0].setBackgroundColor(Color.rgb(221,255,188));
                Bdizi2[1].setBackgroundColor(Color.rgb(221,255,188));
                Bdizi2[2].setBackgroundColor(Color.rgb(221,255,188));
                Bdizi2[3].setBackgroundColor(Color.rgb(221,255,188));


            }
        }.start();
    }

}
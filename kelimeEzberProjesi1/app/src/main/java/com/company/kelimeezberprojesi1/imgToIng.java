package com.company.kelimeezberprojesi1;

import android.content.Intent;
import android.graphics.Color;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import java.util.Random;

public class imgToIng extends AppCompatActivity {

    Button A,B,C,D,Ok;
    ImageView img;
    Random random = new Random();
    TextView text;

    Button Bdizi[] = new Button[4];
    String kelime[] = new String[5];
    int Soru[] = {1,1,1,1,1};
    int secilenSik= -1 ;
    int cevapSik=0;
    int cevapKelime=0;
    int puan = 0;
    Veriler veri = new Veriler();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_img_to_ing);

        text = findViewById(R.id.textView);
        A = findViewById(R.id.buttonA);
        B = findViewById(R.id.buttonB);
        C = findViewById(R.id.buttonC);
        D = findViewById(R.id.buttonD);
        Ok = findViewById(R.id.buttonOk);

        Bdizi[0]=A;
        Bdizi[1]=B;
        Bdizi[2]=C;
        Bdizi[3]=D;

        String ingKelime1 = veri.kelimeIng1;
        String ingKelime2 = veri.kelimeIng2;
        String ingKelime3 = veri.kelimeIng3;
        String ingKelime4 = veri.kelimeIng4;
        String ingKelime5 = veri.kelimeIng5;

        kelime[0]=ingKelime1;
        kelime[1]=ingKelime2;
        kelime[2]=ingKelime3;
        kelime[3]=ingKelime4;
        kelime[4]=ingKelime5;


             cevapKelime = randomSoru(kelime);
             cevapSik = randomCevap(cevapKelime);
            randomSiklar(cevapSik,cevapKelime);

            A.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Bdizi[0].setBackgroundColor(Color.YELLOW);
                    Bdizi[1].setBackgroundColor(Color.rgb(221,255,188));
                    Bdizi[2].setBackgroundColor(Color.rgb(221,255,188));
                    Bdizi[3].setBackgroundColor(Color.rgb(221,255,188));
                    secilenSik =0;
                }
            });
            B.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Bdizi[0].setBackgroundColor(Color.rgb(221,255,188));
                    Bdizi[1].setBackgroundColor(Color.YELLOW);
                    Bdizi[2].setBackgroundColor(Color.rgb(221,255,188));
                    Bdizi[3].setBackgroundColor(Color.rgb(221,255,188));
                    secilenSik =1;
                }
            });
            C.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Bdizi[0].setBackgroundColor(Color.rgb(221,255,188));
                    Bdizi[1].setBackgroundColor(Color.rgb(221,255,188));
                    Bdizi[2].setBackgroundColor(Color.YELLOW);
                    Bdizi[3].setBackgroundColor(Color.rgb(221,255,188));
                    secilenSik =2;
                }
            });
            D.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Bdizi[0].setBackgroundColor(Color.rgb(221,255,188));
                    Bdizi[1].setBackgroundColor(Color.rgb(221,255,188));
                    Bdizi[2].setBackgroundColor(Color.rgb(221,255,188));
                    Bdizi[3].setBackgroundColor(Color.YELLOW);
                    secilenSik =3;
                }
            });

        Ok.setOnClickListener(new View.OnClickListener() {
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

                        Bdizi[cevapSik].setBackgroundColor(Color.GREEN);
                        puan +=10;
                        bekle();

                    }
                    else
                    {

                        Bdizi[cevapSik].setBackgroundColor(Color.GREEN);
                        Bdizi[secilenSik].setBackgroundColor(Color.RED);
                        puan -=10;
                        bekle();
                        Soru[cevapKelime]=1;
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
                 text.setText(kelimeler[soruSec]);
                 break;
                }
            }

            if(i == 5){
                veri.getPuan(puan);
                Intent intent = new Intent(this,trToIng.class);
                startActivity(intent);
            }
            return soruSec;
        }

        public int randomCevap (int cevap){
         int cevapSec = random.nextInt(4);
         Bdizi[cevapSec].setText(kelime[cevap]);
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
                        Bdizi[sikSec].setText(kelime[kelimeSec]);
                        kelimeler[kelimeSec]=-1;
                        siklar[sikSec]=-1;
                        break;
                    }
                }
            }
        }
    }

            public void bekle (){
        new CountDownTimer(1500,1000){

            @Override
            public void onTick(long l) {

            }

            @Override
            public void onFinish() {
                cevapKelime = randomSoru(kelime);
                cevapSik = randomCevap(cevapKelime);
                randomSiklar(cevapSik,cevapKelime);

                Bdizi[0].setBackgroundColor(Color.rgb(221,255,188));
                Bdizi[1].setBackgroundColor(Color.rgb(221,255,188));
                Bdizi[2].setBackgroundColor(Color.rgb(221,255,188));
                Bdizi[3].setBackgroundColor(Color.rgb(221,255,188));


            }
        }.start();
    }


 }










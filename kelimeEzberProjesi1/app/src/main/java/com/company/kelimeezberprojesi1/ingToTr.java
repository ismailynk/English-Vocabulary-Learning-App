package com.company.kelimeezberprojesi1;

import android.content.Intent;
import android.graphics.Color;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class ingToTr extends AppCompatActivity {


    Button A3,B3,C3,D3,Ok3;
    TextView ingiliz;
    Random random = new Random();
    Button Bdizi3[] = new Button[4];
    String Ingkelime3Dizi[] = new String[5];
    String Trkelime3Dizi[] = new String[5];
    int Soru3[] = {1,1,1,1,1};
    int secilenSik = -1 ;
    int cevapSik=0;
    int cevapKelime=0;
    int puan = 0;
    Veriler veri = new Veriler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ing_to_tr);

        ingiliz = findViewById(R.id.textViewIngiliz);
        A3 = findViewById(R.id.buttonA3);
        B3 = findViewById(R.id.buttonB3);
        C3 = findViewById(R.id.buttonC3);
        D3 = findViewById(R.id.buttonD3);
        Ok3 = findViewById(R.id.buttonOk3);

        Bdizi3[0]=A3;
        Bdizi3[1]=B3;
        Bdizi3[2]=C3;
        Bdizi3[3]=D3;


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

        Ingkelime3Dizi[0]=ingKelime1;
        Ingkelime3Dizi[1]=ingKelime2;
        Ingkelime3Dizi[2]=ingKelime3;
        Ingkelime3Dizi[3]=ingKelime4;
        Ingkelime3Dizi[4]=ingKelime5;

        Trkelime3Dizi[0]=TrKelime1;
        Trkelime3Dizi[1]=TrKelime2;
        Trkelime3Dizi[2]=TrKelime3;
        Trkelime3Dizi[3]=TrKelime4;
        Trkelime3Dizi[4]=TrKelime5;

         cevapKelime = randomSoru(Ingkelime3Dizi);
         cevapSik = randomCevap(cevapKelime);
        randomSiklar(cevapSik,cevapKelime);

        A3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bdizi3[0].setBackgroundColor(Color.YELLOW);
                Bdizi3[1].setBackgroundColor(Color.rgb(221,255,188));
                Bdizi3[2].setBackgroundColor(Color.rgb(221,255,188));
                Bdizi3[3].setBackgroundColor(Color.rgb(221,255,188));
                secilenSik =0;
            }
        });
        B3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bdizi3[0].setBackgroundColor(Color.rgb(221,255,188));
                Bdizi3[1].setBackgroundColor(Color.YELLOW);
                Bdizi3[2].setBackgroundColor(Color.rgb(221,255,188));
                Bdizi3[3].setBackgroundColor(Color.rgb(221,255,188));
                secilenSik =1;

            }
        });
        C3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bdizi3[0].setBackgroundColor(Color.rgb(221,255,188));
                Bdizi3[1].setBackgroundColor(Color.rgb(221,255,188));
                Bdizi3[2].setBackgroundColor(Color.YELLOW);
                Bdizi3[3].setBackgroundColor(Color.rgb(221,255,188));
                secilenSik =2;


            }
        });
        D3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bdizi3[0].setBackgroundColor(Color.rgb(221,255,188));
                Bdizi3[1].setBackgroundColor(Color.rgb(221,255,188));
                Bdizi3[2].setBackgroundColor(Color.rgb(221,255,188));
                Bdizi3[3].setBackgroundColor(Color.YELLOW);
                secilenSik =3;
            }
        });
        Ok3.setOnClickListener(new View.OnClickListener() {
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

                        Bdizi3[cevapSik].setBackgroundColor(Color.GREEN);
                        puan +=10;
                        bekle();

                    }
                    else
                    {

                        Bdizi3[cevapSik].setBackgroundColor(Color.GREEN);
                        Bdizi3[secilenSik].setBackgroundColor(Color.RED);
                        puan -= 10;
                        bekle();
                        Soru3[cevapKelime]=1;

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
            if(Soru3[soruSec] == -1)
            {
                soruSec++;

                if(soruSec == 5)
                {
                    soruSec = 0;
                }
            }
            else
            {
                Soru3[soruSec] = -1;
                ingiliz.setText(kelimeler[soruSec]);
                break;
            }
        }

        if(i == 5){
            veri.getPuan(puan);
            Intent intent2 = new Intent(this,konusmaToIng.class);
            startActivity(intent2);
        }
        return soruSec;
    }
    public int randomCevap (int cevap){
        int cevapSec = random.nextInt(4);
        Bdizi3[cevapSec].setText(Trkelime3Dizi[cevap]);
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
                        Bdizi3[sikSec].setText(Trkelime3Dizi[kelimeSec]);
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
                cevapKelime = randomSoru(Ingkelime3Dizi);
                cevapSik = randomCevap(cevapKelime);
                randomSiklar(cevapSik,cevapKelime);
                Bdizi3[0].setBackgroundColor(Color.rgb(221,255,188));
                Bdizi3[1].setBackgroundColor(Color.rgb(221,255,188));
                Bdizi3[2].setBackgroundColor(Color.rgb(221,255,188));
                Bdizi3[3].setBackgroundColor(Color.rgb(221,255,188));


            }
        }.start();
    }
}
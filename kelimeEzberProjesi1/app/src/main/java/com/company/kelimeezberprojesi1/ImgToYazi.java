package com.company.kelimeezberprojesi1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class ImgToYazi extends AppCompatActivity {

    Button Ok4;
    EditText girilen;
    ImageView img;
    TextView trKelime;
    int Cevap;
    int puan = 0 ;

    int Soru[] = {1,1,1,1,1};
    Random random = new Random();
    String kelime[] = new String[5];
    String Trkelime[] = new String[5];
    Veriler veri = new Veriler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_img_to_yazi);



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

        kelime[0]=ingKelime1;
        kelime[1]=ingKelime2;
        kelime[2]=ingKelime3;
        kelime[3]=ingKelime4;
        kelime[4]=ingKelime5;

        Trkelime[0]=TrKelime1;
        Trkelime[1]=TrKelime2;
        Trkelime[2]=TrKelime3;
        Trkelime[3]=TrKelime4;
        Trkelime[4]=TrKelime5;

        Ok4 = findViewById(R.id.buttonOk4);
        girilen = findViewById(R.id.editTextGirilen);
        img = findViewById(R.id.imageViewSoruImg);
        trKelime = findViewById(R.id.textViewSoruTr);

        Cevap =  randomSoru(Trkelime);

        Ok4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(kelime[Cevap].equalsIgnoreCase(girilen.getText().toString()) )
                {
                    Toast.makeText(getApplicationContext(),"Tebrikler Doğru",Toast.LENGTH_SHORT).show();
                    puan += 10;
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Üzgünüm  Yanlış",Toast.LENGTH_SHORT).show();
                    Soru[Cevap] = 1;
                    puan -= 10;
                }
                girilen.setText("");
                Cevap =  randomSoru(Trkelime);
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
                trKelime.setText(kelimeler[soruSec]);
                break;
            }
        }

        if(i == 5){
            veri.getPuan(puan);
            Intent intent = new Intent(this,Son.class);
            startActivity(intent);
        }
       return soruSec;
    }


}
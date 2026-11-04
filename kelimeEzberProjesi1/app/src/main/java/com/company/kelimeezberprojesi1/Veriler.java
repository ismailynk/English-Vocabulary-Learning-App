package com.company.kelimeezberprojesi1;

public class Veriler {

    String trkelime[];
    String ingkelime[];
    String kelimeTr1="erişim";
    String kelimeTr2="hesap";
    String kelimeTr3="tavsiye";
    String kelimeTr4="kullanım";
    String kelimeTr5="kayıt olmak";


    String kelimeIng1="access";
    String kelimeIng2="account";
    String kelimeIng3="advice";
    String kelimeIng4="usage";
    String kelimeIng5="register";

    int puan = 0;

    public void getPuan (int puan){
       this.puan += puan;
    }
    public int setPuan()
    {
        return this.puan;
    }
}

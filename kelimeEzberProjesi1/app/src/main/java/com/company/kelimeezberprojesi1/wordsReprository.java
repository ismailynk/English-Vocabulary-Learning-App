package com.company.kelimeezberprojesi1;

import android.app.Application;
import android.arch.lifecycle.LiveData;

import java.util.List;

public class wordsReprository {
     private wordDAO worddao;
     private LiveData<List<sqlwords>> words;

     public wordsReprository(Application application){
         wordsDatabase database = wordsDatabase.getInstance(application);
         worddao = database.worddao();
         words = worddao.getAllwords();
     }
     public LiveData<List<sqlwords>> getAllwords()
     {
         return words;
     }
}

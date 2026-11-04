package com.company.kelimeezberprojesi1;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import java.util.List;

public class wordviewmodel extends ViewModel {
    private wordsReprository reprository;
    private LiveData<List<sqlwords>>words;

    public wordviewmodel(@NonNull Application application) {
        //super(application);
        reprository = new wordsReprository(application);
        words= reprository.getAllwords();
    }
    public LiveData<List<sqlwords>> getAllwords(){
        return  words;
    }
}

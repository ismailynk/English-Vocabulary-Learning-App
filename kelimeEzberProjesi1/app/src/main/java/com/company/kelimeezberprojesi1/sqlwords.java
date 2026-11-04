package com.company.kelimeezberprojesi1;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "words")
public class sqlwords {
    @PrimaryKey(autoGenerate = true)
    public int id;
     public String tr;
     public String ing;
    public String reading;

    public sqlwords(String tr, String ing, String reading) {
        this.tr = tr;
        this.ing = ing;
        this.reading = reading;
    }

    public int getId() {
        return id;
    }

    public String getTr() {
        return tr;
    }

    public String getIng() {
        return ing;
    }

    public String getReading() {
        return reading;
    }

    public void setId(int id) {
        this.id = id;
    }
}

package com.company.kelimeezberprojesi1;
import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = sqlwords.class, version = 1)
public abstract class wordsDatabase extends RoomDatabase {
    private static wordsDatabase instance;

    public abstract wordDAO worddao();

    public static synchronized wordsDatabase getInstance(Context context){
        if (instance ==null)
        {
            instance= Room.databaseBuilder(context.getApplicationContext(),wordsDatabase.class,"wordsDatabase").fallbackToDestructiveMigration()
                    .addCallback(roomcb)
                    .build();
        }
        return instance;
    }

    private static RoomDatabase.Callback roomcb = new RoomDatabase.Callback(){
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new PopulateDatabaseAsycTask(instance).execute();
        }
    };

    private static class PopulateDatabaseAsycTask extends AsyncTask<Void,Void,Void>
    {
        private wordDAO worddao;

        public PopulateDatabaseAsycTask(wordsDatabase worddb) {
            worddao = worddb.worddao();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            return null;
        }
    }
}

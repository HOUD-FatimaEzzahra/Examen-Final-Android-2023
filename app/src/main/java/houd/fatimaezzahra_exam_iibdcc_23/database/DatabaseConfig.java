package houd.fatimaezzahra_exam_iibdcc_23.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import houd.fatimaezzahra_exam_iibdcc_23.model.Pays;

@Database(entities={Pays.class},version=1,exportSchema = false)

public abstract class DatabaseConfig extends RoomDatabase {

    private static DatabaseConfig database;

    private static String DATABASE_NAME="pays_database";

    public synchronized static DatabaseConfig getInstance(Context context)
    {
        if(database==null)
        {
            database= Room.databaseBuilder(context.getApplicationContext(),DatabaseConfig.class,DATABASE_NAME)
            .allowMainThreadQueries().fallbackToDestructiveMigration().build();
        }
        return database;
    }

    public abstract PaysDao paysDao();
}

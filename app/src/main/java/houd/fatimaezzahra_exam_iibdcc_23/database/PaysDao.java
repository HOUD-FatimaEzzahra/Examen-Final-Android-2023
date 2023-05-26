package houd.fatimaezzahra_exam_iibdcc_23.database;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import static androidx.room.OnConflictStrategy.REPLACE;

import houd.fatimaezzahra_exam_iibdcc_23.model.Pays;

@Dao
public interface PaysDao {

    @Insert(onConflict =REPLACE)
    void insert(Pays pays);

    @Delete
    void delete(Pays pays);

     @Query("UPDATE table_pays SET nom= :nom,capitale=:capitale,nombreHabitants=:nombreHabitants where ID=:ID")
     void update(int ID, String nom,String capitale,int nombreHabitants);

     @Query("SELECT * FROM table_pays")
     List<Pays> getAll();
}

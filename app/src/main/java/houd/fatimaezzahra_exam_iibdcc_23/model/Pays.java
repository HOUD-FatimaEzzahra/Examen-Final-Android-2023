package houd.fatimaezzahra_exam_iibdcc_23.model;


import android.os.Bundle;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;
@Entity(tableName ="table_pays")
public class Pays implements Serializable {
    @PrimaryKey(autoGenerate = true)
    private int ID;

    @ColumnInfo(name="nom")
    private String nom;

    @ColumnInfo(name="capitale")
    private String capitale;

    @ColumnInfo(name="nombreHabitants")
    private int nombreHabitants;

    public Pays() {
    }

    public Pays(String nom, String capitale, int nombreHabitants) {
        this.nom = nom;
        this.capitale = capitale;
        this.nombreHabitants = nombreHabitants;
    }

    public Pays(int ID, String nom, String capitale, int nombreHabitants) {
        this.ID = ID;
        this.nom = nom;
        this.capitale = capitale;
        this.nombreHabitants = nombreHabitants;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getID() {
        return ID;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCapitale() {
        return capitale;
    }

    public void setCapitale(String capitale) {
        this.capitale = capitale;
    }

    public int getNombreHabitants() {
        return nombreHabitants;
    }

    public void setNombreHabitants(int nombreHabitants) {
        this.nombreHabitants = nombreHabitants;
    }


    public static Bundle toBundle(Pays pays){
        Bundle bundle = new Bundle();
        bundle.putInt("ID",pays.getID());
        bundle.putString("nom",pays.getNom());
        bundle.putString("capitale",pays.getCapitale());
        bundle.putInt("nombreHabitants",pays.getNombreHabitants());
        return bundle;
    }

    public static Pays fromBundle(Bundle bundle){
        Pays pays = new Pays();
        pays.setID(bundle.getInt("ID"));
        pays.setNom(bundle.getString("nom"));
        pays.setCapitale(bundle.getString("capitale"));
        pays.setNombreHabitants(bundle.getInt("nombreHabitants"));
        return pays;
    }
}

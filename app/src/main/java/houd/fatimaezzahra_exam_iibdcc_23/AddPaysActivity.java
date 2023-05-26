package houd.fatimaezzahra_exam_iibdcc_23;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import houd.fatimaezzahra_exam_iibdcc_23.database.DatabaseConfig;
import houd.fatimaezzahra_exam_iibdcc_23.model.Pays;

public class AddPaysActivity extends AppCompatActivity {

    EditText add_nom_pays, add_capitale_pays, add_nbr_habitant_pays;

    DatabaseConfig database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        System.out.println("onCreate");
        setContentView(R.layout.add_pays_screen);

        Button button = findViewById(R.id.addPays);

        add_nom_pays = findViewById(R.id.add_nom_pays);
        add_capitale_pays = findViewById(R.id.add_capitale_pays);
        add_nbr_habitant_pays = findViewById(R.id.add_nbr_habitat_pays);

        database = DatabaseConfig.getInstance(this);

        button.setOnClickListener(view -> {
            save();
            navigateBack();
        });
    }

    private void navigateBack(){
        Intent intent = new Intent(this, RecycleListActivity.class);
        startActivity(intent);
    }

    public void save() {
        try{
            database.paysDao().insert(
                    new Pays(
                            add_nom_pays.getText().toString(),
                            add_capitale_pays.getText().toString(),
                            Integer.parseInt(add_nbr_habitant_pays.getText().toString())
                    )
            );
            toastMe("Pays ajouté avec succès");
        }catch (Exception e){
            toastMe("Erreur lors de l'ajout du pays");
            Log.e("AddPaysActivity", e.getMessage());
        }
    }

    private void toastMe(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }

}
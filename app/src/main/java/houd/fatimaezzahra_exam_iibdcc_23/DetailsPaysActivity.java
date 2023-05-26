package houd.fatimaezzahra_exam_iibdcc_23;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;



import houd.fatimaezzahra_exam_iibdcc_23.database.DatabaseConfig;
import houd.fatimaezzahra_exam_iibdcc_23.model.Pays;

public class DetailsPaysActivity extends AppCompatActivity {

    EditText details_nom_pays, details_capitale_pays, details_nbr_habitant_pays;
    Pays pays;

    DatabaseConfig database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details_pays_screen);


        Button deleteButton = findViewById(R.id.deleteContact);
        Button updateButton = findViewById(R.id.updateContact);

        details_nom_pays = findViewById(R.id.details_nom_pays);
        details_capitale_pays = findViewById(R.id.details_capitale_pays);
        details_nbr_habitant_pays = findViewById(R.id.details_nbr_habitants_pays);

        database = DatabaseConfig.getInstance(this);

        loadUser();

        updateButton.setOnClickListener(view -> {
            update();
            navigateBack();
        });

        deleteButton.setOnClickListener(view -> {
            delete();
            navigateBack();
        });
    }

    public void loadUser() {
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        pays = Pays.fromBundle(bundle);
        details_nom_pays.setText(pays.getNom());
        details_capitale_pays.setText(pays.getCapitale());
        details_nbr_habitant_pays.setText(String.valueOf(pays.getNombreHabitants()));
    }

    public void update() {
        try {
            database.paysDao().update(
                    pays.getID(),
                    details_nom_pays.getText().toString(),
                    details_capitale_pays.getText().toString(),
                    Integer.parseInt(details_nbr_habitant_pays.getText().toString())
            );
            toastMe("Pays updated");
        }catch (Exception e){
            toastMe(e.getMessage());
        }
    }

    private void delete() {
        try {
            database.paysDao().delete(pays);
            toastMe("Pays deleted");
        }catch (Exception e){
            toastMe(e.getMessage());
        }
    }

    private void navigateBack(){
        Intent intent = new Intent(this, RecycleListActivity.class);
        startActivity(intent);
    }

    private void toastMe(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }

}
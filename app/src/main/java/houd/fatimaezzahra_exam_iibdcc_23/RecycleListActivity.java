package houd.fatimaezzahra_exam_iibdcc_23;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import houd.fatimaezzahra_exam_iibdcc_23.Adapter.PaysViewAdapterRecycle;
import houd.fatimaezzahra_exam_iibdcc_23.database.DatabaseConfig;
import houd.fatimaezzahra_exam_iibdcc_23.model.Pays;


public class RecycleListActivity extends AppCompatActivity {
    RecyclerView listView;
    DatabaseConfig database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycle_list_screen);

        listView = findViewById(R.id.users_list);

        Button button = findViewById(R.id.new_contact);
        button.setOnClickListener(view -> {
            Intent intent = new Intent(this, AddPaysActivity.class);
            startActivity(intent);
        });

        database = DatabaseConfig.getInstance(this);

    }

    @Override
    protected void onResume() {
        super.onResume();
        getData();
    }


    private void getData() {
        System.out.println("getData");
        List<Pays> pays = database.paysDao().getAll();
        listView.setLayoutManager(new LinearLayoutManager(this));
        listView.setAdapter(new PaysViewAdapterRecycle( this, pays,paysItem -> {
            Intent intent = new Intent(this, DetailsPaysActivity.class);
            Bundle bundle = Pays.toBundle(paysItem);
            intent.putExtras(bundle);
            startActivity(intent);
        }
        ));
    }

    private void toastMe(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }


}

package houd.fatimaezzahra_exam_iibdcc_23.Adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import houd.fatimaezzahra_exam_iibdcc_23.R;

public class PaysViewHolder extends RecyclerView.ViewHolder {
    TextView nom_pays, capitale_pays, nbr_habitant_pays;
    public PaysViewHolder(@NonNull View itemView) {
        super(itemView);
        nom_pays = itemView.findViewById(R.id.nom_pays);
        capitale_pays = itemView.findViewById(R.id.capitale_pays);
        nbr_habitant_pays = itemView.findViewById(R.id.nbr_habitant_pays);
    }

}

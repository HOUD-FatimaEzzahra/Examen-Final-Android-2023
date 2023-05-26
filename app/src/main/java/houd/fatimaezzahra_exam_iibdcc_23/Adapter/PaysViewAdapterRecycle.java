package houd.fatimaezzahra_exam_iibdcc_23.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import houd.fatimaezzahra_exam_iibdcc_23.R;
import houd.fatimaezzahra_exam_iibdcc_23.model.Pays;

public class PaysViewAdapterRecycle extends RecyclerView.Adapter<PaysViewHolder> {

    Context context;
    List<Pays> pays;
    ItemClickListener itemClickListener;


    public PaysViewAdapterRecycle(Context context, List<Pays> pays, ItemClickListener itemClickListener) {
        System.out.println("PaysViewAdapterRecycle --------------->"+pays.size());
        this.context = context;
        this.pays = pays;
        this.itemClickListener = itemClickListener;
    }

    @NonNull
    @Override
    public PaysViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new PaysViewHolder(LayoutInflater.from(context).inflate(R.layout.paysview, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull PaysViewHolder holder, int position) {
        holder.nom_pays.setText(pays.get(position).getNom());
        holder.capitale_pays.setText(pays.get(position).getCapitale());
        holder.nbr_habitant_pays.setText(String.valueOf(pays.get(position).getNombreHabitants()));

        holder.itemView.setOnClickListener(view -> itemClickListener.onItemClick(pays.get(position)));

    }

    @Override
    public int getItemCount() {
        return pays.size();
    }


    public interface ItemClickListener {
        void onItemClick(Pays user);
    }

}

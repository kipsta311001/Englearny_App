package bayon.fabien.englearny_app;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.BreakIterator;
import java.util.Arrays;
import java.util.List;

public class UtilisateurListAdpater extends RecyclerView.Adapter<UtilisateurListAdpater.ViewHolder> {


    List<Utilisateurs> listOfUtilisateurs;


    public UtilisateurListAdpater(List<Utilisateurs> listOfUtilisateurs, UtilisateurActivity utilisateurActivity) {
        this.listOfUtilisateurs = listOfUtilisateurs;


    }

    @NonNull
    @Override
    public UtilisateurListAdpater.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.utilisateur_list_cell, parent, false);
        UtilisateurListAdpater.ViewHolder viewHolder = new UtilisateurListAdpater.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull UtilisateurListAdpater.ViewHolder holder, int position) {
        holder.name.setText(listOfUtilisateurs.get(position).getUtilisateurName());
        holder.firstName.setText(listOfUtilisateurs.get(position).getUtilisateurFirstName());
    }


    @Override
    public int getItemCount() {
        return listOfUtilisateurs.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        TextView firstName;

        public ViewHolder(@NonNull View listOfUtilisateurs) {
            super(listOfUtilisateurs);
            name = listOfUtilisateurs.findViewById(R.id.textNom);
            firstName = listOfUtilisateurs.findViewById(R.id.textPrenom);

        }
    }
}


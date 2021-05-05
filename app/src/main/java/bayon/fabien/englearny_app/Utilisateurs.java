package bayon.fabien.englearny_app;

import android.content.IntentFilter;

import com.google.gson.annotations.SerializedName;

public class Utilisateurs {


    @SerializedName("id")
    public int id;

    @SerializedName("nom")
    public String nom;

    @SerializedName("prenom")
    public String prenom;

    public Utilisateurs(int id, String nom, String prenom) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;

    }

    public String getUtilisateurName() {
        return nom;
    }
    public int getUtilisateurId() {
        return id;
    }
    public String getUtilisateurFirstName() {
        return prenom;
    }



}



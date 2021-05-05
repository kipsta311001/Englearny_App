package bayon.fabien.englearny_app;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UtilisateurActivity extends AppCompatActivity {

    TextView name ;
    TextView firstName ;

    private RecyclerView utilisateurListRecyclerView;
    private RecyclerView.Adapter utilisateurListAdapter;
    private RecyclerView.LayoutManager utilisateurListLayoutManager;

    private List<Utilisateurs> utilisateursList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_utilisateur);

        name = findViewById(R.id.textNom);
        firstName = findViewById(R.id.textPrenom);

        utilisateurListRecyclerView = findViewById(R.id.utilisateurRecyclerView);

        utilisateurListRecyclerView.setHasFixedSize(true);


        utilisateurListLayoutManager = new LinearLayoutManager(this);
        utilisateurListRecyclerView.setLayoutManager(utilisateurListLayoutManager);


        utilisateursList = new ArrayList<>();


        Call<Utilisateurs[]> utilsateurCall = ApiClient.getResultsApi().getListUtilisateurs();
        utilsateurCall.enqueue(new Callback<Utilisateurs[]>() {


            @Override
            public void onResponse(Call<Utilisateurs[]> call, Response<Utilisateurs[]> response) {
                for(int i = 0; i < response.body().length ; i++ ){
                    System.out.println("ALLEZ CA MARCHE" + i );
                    Utilisateurs utilisateurs = new Utilisateurs(response.body()[0].getUtilisateurId(), response.body()[0].getUtilisateurName(), response.body()[0].getUtilisateurFirstName());
                    System.out.println(utilisateurs.getUtilisateurFirstName());
                    utilisateursList.add(new Utilisateurs(response.body()[i].getUtilisateurId(), response.body()[i].getUtilisateurName(), response.body()[i].getUtilisateurFirstName()));

                }


                utilisateurListRecyclerView.setAdapter(new UtilisateurListAdpater(utilisateursList,(UtilisateurActivity.this)));
            }

            @Override
            public void onFailure(Call<Utilisateurs[]> call, Throwable t) {
                System.out.println(t.getMessage());
            }


        });

    }

}
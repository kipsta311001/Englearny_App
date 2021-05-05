package bayon.fabien.englearny_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {


    EditText email ;
    EditText password ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        email = findViewById(R.id.inputEmail);
        password = findViewById(R.id.inputPassword);

    }

    public void Connexion( View v){

        Intent testIntent = new Intent(this, TestActivity.class);
        String userEmail = email.getText().toString();
        String userPassword = password.getText().toString();
        if (!userEmail.equals("") && !userPassword.equals("")) {
            testIntent.putExtra("email", userEmail);
            testIntent.putExtra("password", userPassword);
            startActivity(testIntent);
        }

    }

    public void Liste_utilisateurs(View v){
        Intent utilisateurIntent = new Intent(this, UtilisateurActivity.class);
        startActivity(utilisateurIntent);
    }
}
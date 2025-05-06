package com.example.groupe_alternant_2025;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class CalculatriceActivity extends AppCompatActivity {

    private TextView textViewCalcul;
    private Button bouton0;
    private Button bouton1;
    private Button bouton2;
    private Button bouton3;
    private Button bouton4;
    private Button bouton5;
    private Button bouton6;
    private Button bouton7;
    private Button bouton8;
    private Button bouton9;
    private Button boutonMultiplier;
    private Button boutonPlus;
    private Button boutonMoins;
    private Button boutonDiviser;

    private Integer premierElement=0;

    private Integer deuxiemeElement=0;

    private TypeOperation typeOperation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_calculatrice);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        bouton0 = findViewById(R.id.bouton_0);
        bouton1 = findViewById(R.id.bouton_1);
        bouton2 = findViewById(R.id.bouton_2);
        bouton3 = findViewById(R.id.bouton_3);
        bouton4 = findViewById(R.id.bouton_4);
        bouton5 = findViewById(R.id.bouton_5);
        bouton6 = findViewById(R.id.bouton_6);
        bouton7 = findViewById(R.id.bouton_7);
        bouton8 = findViewById(R.id.bouton_8);
        bouton9 = findViewById(R.id.bouton_9);
        textViewCalcul = findViewById(R.id.textView_calcul);
        bouton0.setOnClickListener(v -> ajouterChiffre(0));
        bouton1.setOnClickListener(v -> ajouterChiffre(1));
        bouton2.setOnClickListener(v -> ajouterChiffre(2));
        bouton3.setOnClickListener(v -> ajouterChiffre(3));
        bouton4.setOnClickListener(v -> ajouterChiffre(4));
        bouton5.setOnClickListener(v -> ajouterChiffre(5));
        bouton6.setOnClickListener(v -> ajouterChiffre(6));
        bouton7.setOnClickListener(v -> ajouterChiffre(7));
        bouton8.setOnClickListener(v -> ajouterChiffre(8));
        bouton9.setOnClickListener(v -> ajouterChiffre(9));

        //TODO FAIRE LA MEME CHOSE POUR LES TYPE D OPERATION
        boutonPlus.setOnClickListener(v -> ajouterTypeOperation(TypeOperation.ADD));
        boutonMoins.setOnClickListener(v -> ajouterTypeOperation(TypeOperation.SUBSTRACT));
        boutonDiviser.setOnClickListener(v -> ajouterTypeOperation(TypeOperation.DIVIDE));
        boutonMultiplier.setOnClickListener(v -> ajouterTypeOperation(TypeOperation.MULTIPLY));
    }

    private void ajouterChiffre(Integer chiffreAAjouter){
        if(this.typeOperation==null){
            premierElement = 10* premierElement +chiffreAAjouter;
        }else{
            deuxiemeElement = 10* deuxiemeElement + chiffreAAjouter;
        }
        textViewCalcul.setText(textViewCalcul.getText()+chiffreAAjouter.toString());
    }

    private void ajouterTypeOperation(TypeOperation typeOperationAAjouter){
        if(this.typeOperation==null){
            this.typeOperation = typeOperationAAjouter;
            textViewCalcul.setText(textViewCalcul.getText()+typeOperationAAjouter.getSymbole());
        }else{

            Toast.makeText(this,"ERREUR",Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.monmenu,menu);
        MenuItem boutonRAZ = menu.findItem(R.id.bouton_raz);
        MenuItem boutonEgal = menu.findItem(R.id.bouton_egale);
        boutonRAZ.setOnMenuItemClickListener(v -> {
            premierElement=0;
            deuxiemeElement=0;
            typeOperation = null;
            textViewCalcul.setText("");
           return true;
        });
        boutonEgal.setOnMenuItemClickListener(v -> faisLeCalcul());

        // FAIRE UN BOUTON EGAL QUI AFFICHE LE RESULTAT DANS UN TOAST
        return super.onCreateOptionsMenu(menu);
    }

    private boolean faisLeCalcul() {
        String resultat ="";
        if(this.typeOperation != null){
            switch (this.typeOperation){
                case ADD:
                    resultat= ""+premierElement+deuxiemeElement;
                    break;
                case DIVIDE:
                    resultat= ""+premierElement/deuxiemeElement;
                    break;
                case MULTIPLY:
                    resultat = ""+premierElement*deuxiemeElement;
                    break;
                case SUBSTRACT:
                    resultat = ""+(premierElement-deuxiemeElement);
                    break;
                default:
                    resultat=""+premierElement;

            }
            Toast.makeText(this,resultat,Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(this,""+premierElement,Toast.LENGTH_LONG).show();

        }

        return true;
    }
}
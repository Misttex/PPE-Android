package com.example.gsbvisite.view;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.cardview.widget.CardView;
import com.example.gsbvisite.R;
import com.example.gsbvisite.controller.MedicamentController;
import com.example.gsbvisite.controller.PraticienController;
import com.example.gsbvisite.controller.RendezVousController;
import com.example.gsbvisite.model.Medicament;
import com.example.gsbvisite.model.Praticien;
import com.example.gsbvisite.model.RendezVous;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private MedicamentController medicamentController;
    private PraticienController praticienController;
    private RendezVousController rendezVousController;

    private ArrayList<Medicament> medicaments;
    private ArrayList<Praticien> praticiens;
    private ArrayList<RendezVous> rendezVous;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.medicamentController = MedicamentController.getInstance(this);
        medicaments = medicamentController.medicaments();
        this.praticienController = PraticienController.getInstance(this);
        praticiens = praticienController.praticiens();
        this.rendezVousController = RendezVousController.getInstance(this);
        rendezVous = rendezVousController.rendezVous();

        gestionClic((CardView) findViewById(R.id.btnListMedicament), MedicamentActivity.class);
        gestionClic((CardView) findViewById(R.id.btnCreateRDV), NiewRDVActivity.class);
        gestionClic((CardView) findViewById(R.id.btnListRDV), VoirRDVActivity.class);

    }
    private void gestionClic(CardView btn, final Class<?> classe){
        btn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "clic sur liste rendez-vous", Toast.LENGTH_SHORT).show();
                Log.d("message","clic sur liste rendez-vous**********");
                Intent intent = new Intent(MainActivity.this, classe );
                intent.putExtra("medicament", medicaments);
                startActivity(intent);

            }
        });

        btn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "clic sur créer rendez-vous", Toast.LENGTH_SHORT).show();
                Log.d("message","clic sur créer rendez-vous**********");
                Intent intent = new Intent(MainActivity.this, classe);
                startActivity(intent);
            }
        });

        btn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "clic sur liste médicament", Toast.LENGTH_SHORT).show();
                Log.d("message","clic sur liste médicaments**********");
                Intent intent = new Intent(MainActivity.this, classe);
                startActivity(intent);
            }
        });
    }

}
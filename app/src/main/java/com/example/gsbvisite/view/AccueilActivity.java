package com.example.gsbvisite.view;

import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
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
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class AccueilActivity extends AppCompatActivity {

    private MedicamentController medicamentController;
    private PraticienController praticienController;
    private RendezVousController rendezVousController;

    private ArrayList<Medicament> medicaments;
    private ArrayList<Praticien> praticiens;
    private ArrayList<RendezVous> rendezVous;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accueil);

        this.medicamentController = MedicamentController.getInstance(this);
        medicaments = medicamentController.medicaments();
        this.praticienController = PraticienController.getInstance(this);
        praticiens = praticienController.praticiens();
        this.rendezVousController = RendezVousController.getInstance(this);
        rendezVous = rendezVousController.rendezVous();
        this.configureToolBar();
        this.configureNavigation();
        gestionClic();
    }
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_activity,menu);
        return true;
    }
    private void configureToolBar(){
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("GSBVisite");
        setSupportActionBar(toolbar);
    }
    private void configureNavigation(){
        BottomNavigationView bottomNavigationView;
        bottomNavigationView = (BottomNavigationView) findViewById(R.id.navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Intent intent;
                switch (item.getItemId()){
                    case R.id.action_medicine:{
                        intent = new Intent( AccueilActivity.this, MedicamentActivity.class);
                        intent.putExtra("medicament", medicaments);
                        startActivity(intent);
                        break;
                    }
                    case R.id.action_rendezVous:{
                        intent = new Intent( AccueilActivity.this, VoirRDVActivity.class);
                        intent.putExtra("rendezVous", rendezVous);
                        startActivity(intent);
                        break;
                    }
                }
                return true;
            }
        });
    }
    private void gestionClic(){
        ((CardView)this.findViewById(R.id.btnListMedicament)).setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                Log.d("message","clic sur liste médicaments**********");
                Intent intent = new Intent(AccueilActivity.this,MedicamentActivity.class );
                intent.putExtra("medicament", medicaments);
                startActivity(intent);

            }
        });

        ((CardView)this.findViewById(R.id.btnListRDV)).setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                Log.d("message","clic sur liste rendez-vous**********");
                Intent intent = new Intent(AccueilActivity.this,VoirRDVActivity.class );
                intent.putExtra("rendezVous", rendezVous);
                startActivity(intent);

            }
        });
        ((CardView)this.findViewById(R.id.btnCreateRDV)).setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                Log.d("message","clic sur liste rendez-vous**********");
                Intent intent = new Intent(AccueilActivity.this, PrendreRdv.class );
                startActivity(intent);
            }
        });
    }
}
/*
package com.example.gsbvisite.view;

import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;
import com.example.gsbvisite.R;
import com.example.gsbvisite.controller.MedicamentController;
import com.example.gsbvisite.controller.PraticienController;
import com.example.gsbvisite.controller.RendezVousController;
import com.example.gsbvisite.model.Medicament;
import com.example.gsbvisite.model.Praticien;
import com.example.gsbvisite.model.RendezVous;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class PraticienActivity extends AppCompatActivity {

    private ListView lvPraticiens;
    private MedicamentController medicamentController;
    private PraticienController praticienController;
    private RendezVousController rendezVousController;

    private ArrayList<Medicament> medicaments;
    private ArrayList<Praticien> praticiens;
    private ArrayList<RendezVous> rendezVous;

    private RendezVousListAdapter listAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_praticien);
        this.medicamentController = MedicamentController.getInstance(this);
        medicaments = medicamentController.medicaments();
        this.rendezVousController= RendezVousController.getInstance(this);
        rendezVous = rendezVousController.rendezVous();
        praticiens = getIntent().getParcelableArrayListExtra("praticiens");
        lvPraticiens = (ListView)findViewById(R.id.listRendezVous);
        listAdapter = new PraticienListAdapter(this, this.praticiens);
        lvPraticiens.setAdapter(listAdapter);
        this.configureToolBar();
        this.configureNavigation();
    }

    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_activity,menu);
        return true;
    }
    private void configureToolBar(){
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Les praticiens");
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
                    case R.id.action_accueil:{
                        intent = new Intent( PraticienActivity.this, AccueilActivity.class);
                        startActivity(intent);
                        break;
                    }
                    case R.id.action_medicine:{
                        intent = new Intent( PraticienActivity.this, MedicamentActivity.class);
                        intent.putExtra("medicament", medicaments);
                        startActivity(intent);
                        break;
                    }
                    case R.id.action_rendezVous:{
                        intent = new Intent( PraticienActivity.this, VoirRDVActivity.class);
                        intent.putExtra("rendezVous", rendezVous);
                        startActivity(intent);
                        break;
                    }
                }
                return true;
            }
        });
    }
}*/

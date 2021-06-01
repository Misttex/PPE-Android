package com.example.gsbvisite.view;

import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.*;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.gsbvisite.R;
import com.example.gsbvisite.controller.MedicamentController;
import com.example.gsbvisite.controller.PraticienController;
import com.example.gsbvisite.controller.RendezVousController;
import com.example.gsbvisite.model.Medicament;
import com.example.gsbvisite.model.Praticien;
import com.example.gsbvisite.model.RendezVous;


import androidx.appcompat.widget.Toolbar;
import com.example.gsbvisite.model.RendezVous;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class VoirRDVActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{

    private ListView lvRendezVous;
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
        setContentView(R.layout.activity_voir_r_d_v);
        this.medicamentController = MedicamentController.getInstance(this);
        medicaments = medicamentController.medicaments();
        rendezVous = getIntent().getParcelableArrayListExtra("rendezVous");
        lvRendezVous = (ListView)findViewById(R.id.listRendezVous);
        lvRendezVous.setOnItemClickListener(this);
        listAdapter = new RendezVousListAdapter(this, this.rendezVous);
        lvRendezVous.setAdapter(listAdapter);
        this.configureToolBar();
        this.configureNavigation();
    }

    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_activity,menu);
        return true;
    }
    private void configureToolBar(){
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Vos rendez-vous");
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
                        intent = new Intent( VoirRDVActivity.this, AccueilActivity.class);
                        startActivity(intent);
                        break;
                    }
                    case R.id.action_medicine:{
                        intent = new Intent( VoirRDVActivity.this, MedicamentActivity.class);
                        intent.putExtra("medicament", medicaments);
                        startActivity(intent);
                        break;
                    }
                }
                return true;
            }
        });
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Log.i("Rendez","Position" + String.valueOf(position));
        RendezVous rendezvous = (RendezVous) listAdapter.getItem(position);
        String value = rendezvous.getDate();
        Toast.makeText(getApplicationContext(),value,Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(VoirRDVActivity.this, DetailRendezVous.class);
        intent.putExtra("rendezVous",rendezvous);
        startActivity(intent);
    }
}
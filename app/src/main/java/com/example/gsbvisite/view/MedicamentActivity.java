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
import com.example.gsbvisite.controller.RendezVousController;
import com.example.gsbvisite.model.Medicament;

import androidx.appcompat.widget.Toolbar;
import com.example.gsbvisite.model.RendezVous;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class MedicamentActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private ListView lvMedicaments;
    private ArrayList<Medicament> medicaments;
    private ArrayList<RendezVous> rendezVous;
    private RendezVousController rendezVousController;
    private MedicamentListAdapter listAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medicament);
        this.rendezVousController = RendezVousController.getInstance(this);
        rendezVous = rendezVousController.rendezVous();
        medicaments = getIntent().getParcelableArrayListExtra("medicament");
        lvMedicaments = (ListView)findViewById(R.id.listMedicaments);
        lvMedicaments.setOnItemClickListener(this);
        listAdapter = new MedicamentListAdapter(this, this.medicaments);
        lvMedicaments.setAdapter(listAdapter);
        this.configureToolBar();
        this.configureNavigation();
    }

    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_activity,menu);
        return true;
    }
    private void configureToolBar(){
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Vos médicaments");
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
                        intent = new Intent( MedicamentActivity.this, AccueilActivity.class);
                        startActivity(intent);
                        break;
                    }
                    case R.id.action_rendezVous:{
                        intent = new Intent( MedicamentActivity.this, VoirRDVActivity.class);
                        intent.putExtra("rendezVous", rendezVous);
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
        Log.i("Medoc","Position" + String.valueOf(position));
        Medicament medicament = (Medicament)listAdapter.getItem(position);
        String value = medicament.getMNomCommercial();
        Toast.makeText(getApplicationContext(),value,Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(MedicamentActivity.this, DetailMedicament.class);
        //intent.putExtra("nom",medicament.getMNomCommercial());
        //intent.putExtra("effet",medicament.getMEffet());
        //intent.putExtra("prix",medicament.getMPrixEchant());
        intent.putExtra("medicament",medicament);
        startActivity(intent);
    }
}
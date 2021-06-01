package com.example.gsbvisite.view;

import android.content.Intent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;
import com.example.gsbvisite.R;
import com.example.gsbvisite.controller.MedicamentController;
import com.example.gsbvisite.model.Medicament;

import java.util.ArrayList;

public class DetailMedicament extends AppCompatActivity {

    private MedicamentController medicamentController;
    private ArrayList<Medicament> medicaments;
    private TextView txtNom;
    private TextView txtEffet;
    private TextView txtPrix;
    private TextView txtDepotLegal;
    private TextView txtContreIndic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.medicamentController = MedicamentController.getInstance(this);
        medicaments = medicamentController.medicaments();
        setContentView(R.layout.activity_detail_medicament);
        txtNom = this.findViewById(R.id.txtNomCommercial);
        txtEffet = this.findViewById(R.id.txtEffet);
        txtPrix = this.findViewById(R.id.txtPrix);
        txtDepotLegal = this.findViewById(R.id.txtDepotLegal);
        txtContreIndic = this.findViewById(R.id.txtContreIndic);
        Medicament medicament = getIntent().getParcelableExtra("medicament");
        txtNom.setText(medicament.getMNomCommercial());
        txtEffet.setText(medicament.getMEffet());
        txtDepotLegal.setText(medicament.getMDepotLegal());
        txtContreIndic.setText(medicament.getMContreIndic());
        Double prix = medicament.getMPrixEchant();
        txtPrix.setText(prix.toString());
        this.configureToolbar();
    }
    private void configureToolbar(){
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Détail médicament");
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
    }
}
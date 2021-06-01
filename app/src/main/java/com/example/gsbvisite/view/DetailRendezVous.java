package com.example.gsbvisite.view;

import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;
import com.example.gsbvisite.R;
import com.example.gsbvisite.controller.MedicamentController;
import com.example.gsbvisite.controller.RendezVousController;
import com.example.gsbvisite.model.Medicament;
import com.example.gsbvisite.model.RendezVous;

import java.util.ArrayList;

public class DetailRendezVous extends AppCompatActivity {

    private RendezVousController rendezVousController;
    private ArrayList<RendezVous> rendezVous;
    private TextView txtDateRDV;
    private TextView txtHeure;
    private TextView txtPraticien;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.rendezVousController = RendezVousController.getInstance(this);
        rendezVous = rendezVousController.rendezVous();
        setContentView(R.layout.activity_detail_rendez_vous);
        txtDateRDV = this.findViewById(R.id.txtDateRDV);
        txtHeure= this.findViewById(R.id.txtHeure);
        txtPraticien = this.findViewById(R.id.txtPraticien);
        RendezVous rendezvous = getIntent().getParcelableExtra("rendezVous");
        txtDateRDV.setText(rendezvous.getDate());
        txtHeure.setText(rendezvous.getHeure());
        txtPraticien.setText((CharSequence) rendezvous.getPraticien());
        this.configureToolbar();
    }
    private void configureToolbar(){
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Détail Rendez-vous");
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null){
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }
}

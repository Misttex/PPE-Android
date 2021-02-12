package com.example.gsbvisite.view;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.gsbvisite.R;
import com.example.gsbvisite.controller.MedicamentController;
import com.example.gsbvisite.model.Medicament;

import java.util.ArrayList;

public class MedicamentActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private ListView lvMedicaments;
    private ArrayList<Medicament> medicaments;
    private MedicamentController medicamentController;
    private MedicamentListAdapter listAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medicament);
        medicaments = getIntent().getParcelableArrayListExtra("medicament");
        lvMedicaments = (ListView)findViewById(R.id.listMedicaments);
        lvMedicaments.setOnItemClickListener(this);
        listAdapter = new MedicamentListAdapter(this, this.medicaments);
        lvMedicaments.setAdapter(listAdapter);
        gestionClic((ImageButton) findViewById(R.id.btnAcceuil), MainActivity.class);
    }

    private void gestionClic(ImageButton btn, final Class<?> classe) {

        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(MedicamentActivity.this, classe);
                startActivity(intent);
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
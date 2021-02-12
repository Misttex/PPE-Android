package com.example.gsbvisite.view;

import android.content.Intent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.gsbvisite.R;
import com.example.gsbvisite.model.Medicament;

public class DetailMedicament extends AppCompatActivity {

    private TextView txtNom;
    private TextView txtEffet;
    private TextView txtPrix;
    private TextView txtDepotLegal;
    private TextView txtContreIndic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
        gestionClic((ImageButton) findViewById(R.id.btnRetourdeDetail), MedicamentActivity.class);
    }

    private void gestionClic(ImageButton btn, final Class classe) {
        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent (DetailMedicament.this, classe);
                startActivity(intent);
            }
        });

    }
}
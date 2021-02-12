package com.example.gsbvisite.view;

import android.content.Intent;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.gsbvisite.R;

public class VoirRDVActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_voir_r_d_v);
        gestionClic((ImageButton) findViewById(R.id.btnAcceuil), MainActivity.class);
    }

    private void gestionClic(ImageButton btn, final Class classe) {

        btn.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent intent = new Intent(VoirRDVActivity.this, classe);
                startActivity(intent);
            }
        });
    }
}
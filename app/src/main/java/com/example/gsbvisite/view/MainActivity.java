package com.example.gsbvisite.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.example.gsbvisite.R;

public class MainActivity extends AppCompatActivity {
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText) findViewById(R.id.idApplication);
        editText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if(actionId == EditorInfo.IME_ACTION_DONE){
                    String value = editText.getText().toString();
                    String marqueur = "9999";
                    if(value.compareTo(marqueur) == 0){
                        Intent intent = new Intent(MainActivity.this, AccueilActivity.class);
                        startActivity(intent);
                    }
                    else
                        Toast.makeText(MainActivity.this,"Code erroné",Toast.LENGTH_SHORT).show();
                }
                return false;
            }
        });
    }
}

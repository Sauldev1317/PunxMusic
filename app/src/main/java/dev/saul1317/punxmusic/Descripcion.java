package dev.saul1317.punxmusic;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import dev.saul1317.punxmusic.Model.Instrumento;

public class Descripcion extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_descripcion);
        Instrumento instrumento = getIntent().getParcelableExtra("instrumento");
        Log.e("Instrumento", instrumento.toString());
    }
}

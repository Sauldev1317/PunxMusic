package dev.saul1317.punxmusic;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Pair;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.facebook.shimmer.ShimmerFrameLayout;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

import dev.saul1317.punxmusic.Adapter.AdapterRecyclerviewInstrumento;
import dev.saul1317.punxmusic.Adapter.OnItemClickListener;
import dev.saul1317.punxmusic.Model.Instrumento;

public class Catalogo extends AppCompatActivity {

    private static final String TAG = "CATALOGO";
    RecyclerView recyclerview_catalogo;
    AdapterRecyclerviewInstrumento adapterRecyclerviewInstrumento;
    GridLayoutManager gridLayoutManager;
    ShimmerFrameLayout shimmer_view_container_catalogo;

    //FIREBASE
    private FirebaseAuth mAuth;
    FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catalogo);
        loadUI();
    }

    private void loadUI() {
        Toolbar home_toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(home_toolbar);

        if (getSupportActionBar() != null){
            getSupportActionBar().setTitle(R.string.txt_guitarra_electricas);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        home_toolbar.setNavigationIcon(R.drawable.back_icon);
        home_toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        shimmer_view_container_catalogo = (ShimmerFrameLayout) findViewById(R.id.shimmer_view_container_catalogo);
        recyclerview_catalogo = (RecyclerView) findViewById(R.id.recyclerview_catalogo);
        recyclerview_catalogo.setHasFixedSize(true);
        gridLayoutManager = new GridLayoutManager(this, 2);
        recyclerview_catalogo.setLayoutManager(gridLayoutManager);
        settingFirebase();
    }

    private void settingFirebase() {
        mAuth = FirebaseAuth.getInstance();
        db = FirebaseFirestore.getInstance();
        getInstrumentos();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.action_search){
            Toast.makeText(this, "Search", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }

    private void getInstrumentos() {
        shimmer_view_container_catalogo.startShimmer();
        db.collection("instrumento")
                .orderBy("nombre", Query.Direction.DESCENDING)
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        shimmer_view_container_catalogo.stopShimmer();
                        shimmer_view_container_catalogo.setVisibility(View.GONE);
                        if (task.isSuccessful()) {
                            if (task.getResult() != null) {
                                List<Instrumento> instrumentoList = new ArrayList<>();

                                for (QueryDocumentSnapshot document : task.getResult()) {
                                    Instrumento instrumento = document.toObject(Instrumento.class);
                                    instrumento.setId(document.getId());
                                    instrumentoList.add(instrumento);
                                }

                                adapterRecyclerviewInstrumento = new AdapterRecyclerviewInstrumento(R.layout.cardview_productos, instrumentoList,
                                        getApplicationContext(), new OnItemClickListener() {
                                    @Override
                                    public void onItemClick(Instrumento instrumento, View view) {
                                        abrirDescripcionInstrumento(instrumento, view);
                                    }
                                });

                                recyclerview_catalogo.setAdapter(adapterRecyclerviewInstrumento);

                            }
                        } else {
                            Log.e(TAG, "Error getting documents.", task.getException());
                        }
                    }
                });
    }

    private void abrirDescripcionInstrumento(Instrumento instrumento, View view){
        Intent intent = new Intent(Catalogo.this, Descripcion.class);
        intent.putExtra("instrumento", instrumento);
        Pair[] pairs = new Pair[2];
        pairs[0] = new Pair<View, String> (view, "cardview_instrument");
        pairs[1] = new Pair<View, String> (view, "img_instrument");
        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(Catalogo.this, pairs);
        startActivity(intent, options.toBundle());

    };
}

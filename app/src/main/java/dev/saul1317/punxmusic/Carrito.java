package dev.saul1317.punxmusic;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import dev.saul1317.punxmusic.Adapter.AdapterRecyclerviewInstrumento;
import dev.saul1317.punxmusic.Adapter.AdapterRecyclerviewShoppingCart;
import dev.saul1317.punxmusic.Adapter.OnItemClickListener;
import dev.saul1317.punxmusic.Data.Data;
import dev.saul1317.punxmusic.Model.Instrumento;


public class Carrito extends AppCompatActivity {

    RecyclerView recyclerview_shopping_cart;
    Button button_comprar;
    TextView txt_precio_total_shopping_cart;
    AdapterRecyclerviewShoppingCart adapterRecyclerviewShoppingCart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carrito);
        loadUI();
    }

    private void loadUI() {
        Toolbar home_toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(home_toolbar);

        if (getSupportActionBar() != null){
            getSupportActionBar().setTitle("Mi carrito");
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
        button_comprar = (Button) findViewById(R.id.button_comprar);
        txt_precio_total_shopping_cart = (TextView) findViewById(R.id.txt_precio_total_shopping_cart);
        recyclerview_shopping_cart = (RecyclerView) findViewById(R.id.recyclerview_shopping_cart);
        recyclerview_shopping_cart.setHasFixedSize(true);
        recyclerview_shopping_cart.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
        Data data = new Data(this);
        adapterRecyclerviewShoppingCart = new AdapterRecyclerviewShoppingCart(R.layout.cardview_shopping_cart, data.getAllShoppingCart(),
                getApplicationContext(), null);
        recyclerview_shopping_cart.setAdapter(adapterRecyclerviewShoppingCart);
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

}

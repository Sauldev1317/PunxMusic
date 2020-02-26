package dev.saul1317.punxmusic;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import dev.saul1317.punxmusic.Model.Instrumento;

public class Descripcion extends AppCompatActivity implements View.OnClickListener {

    ImageView img_instrument_description;
    TextView txt_name_instrument_description, txt_description_instrument_description, txt_price_instrument_description;
    LinearLayout btn_play_video;
    Button btn_add_shopping_cart;
    FrameLayout btn_add_fav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_descripcion);
        loadUI();
    }

    private void loadUI() {
        Toolbar toolbar_transparent = (Toolbar) findViewById(R.id.toolbar_transparent);
        setSupportActionBar(toolbar_transparent);
        // add back arrow to toolbar
        if (getSupportActionBar() != null){
            getSupportActionBar().setTitle(null);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        toolbar_transparent.setNavigationIcon(R.drawable.back_icon);
        toolbar_transparent.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        img_instrument_description = (ImageView) findViewById(R.id.img_instrument_description);
        btn_play_video = (LinearLayout) findViewById(R.id.btn_play_video);
        btn_play_video.setOnClickListener(this);
        txt_name_instrument_description = (TextView) findViewById(R.id.txt_name_instrument_description);
        txt_description_instrument_description = (TextView) findViewById(R.id.txt_description_instrument_description);
        txt_price_instrument_description = (TextView) findViewById(R.id.txt_price_instrument_description);
        btn_add_shopping_cart = (Button) findViewById(R.id.btn_add_shopping_cart);
        btn_add_shopping_cart.setOnClickListener(this);
        btn_add_fav = (FrameLayout) findViewById(R.id.btn_add_fav);
        btn_add_fav.setOnClickListener(this);

        Instrumento instrumento = getIntent().getParcelableExtra("instrumento");
        if (instrumento != null){
            updateUI(instrumento);
        }
    }

    private void updateUI(Instrumento instrumento) {
        Picasso.get().load(instrumento.getUrl_imagen()).into(img_instrument_description);
        txt_name_instrument_description.setText(instrumento.getNombre());
        txt_description_instrument_description.setText(instrumento.getDescripcion());
        txt_price_instrument_description.setText("$" + String.valueOf(instrumento.getPrecio()));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_descripcion, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.action_shopping_cart){
            Toast.makeText(this, "cart", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_play_video:
                Toast.makeText(this, "Ver video", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_add_shopping_cart:
                Toast.makeText(this, "Agregar al carrito", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_add_fav:
                Toast.makeText(this, "Agregado a favoritos", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
    }

    @Override
    public void onBackPressed() {
        //super.onBackPressed();
        supportFinishAfterTransition();
    }
}

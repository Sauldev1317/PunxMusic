package dev.saul1317.punxmusic;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import dev.saul1317.punxmusic.Adapter.PageAdapter;

public class Home extends AppCompatActivity implements TabLayout.OnTabSelectedListener, View.OnClickListener {


    private static final String TAG = "HOME";
    TabLayout tablayout_home;
    TabItem tab_home, tab_categoria, tab_noticias;
    ViewPager viewPager_content;
    PageAdapter pageAdapter;
    FloatingActionButton fab_shopping_cart;

    //FIREBASE
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        loadUI();
        settingFirebase();
    }

    private void settingFirebase() {
        mAuth = FirebaseAuth.getInstance();
    }

    @Override
    public void onStart() {
        super.onStart();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if (currentUser != null){
            //updateUI(currentUser);
        }else{
            anonymouslyAutheticate();
        }
    }

    private void anonymouslyAutheticate() {
        mAuth.signInAnonymously()
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "signInAnonymously:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            updateUI(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "signInAnonymously:failure", task.getException());
                            Toast.makeText(Home.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                            updateUI(null);
                        }
                    }
                });
    }


    private void loadUI() {
        Toolbar home_toolbar = (Toolbar) findViewById(R.id.toolbar);
        home_toolbar.setLogo(R.drawable.punxmusic_logo_appbar);
        home_toolbar.setNavigationIcon(R.drawable.burger_icon);
        setSupportActionBar(home_toolbar);
        getSupportActionBar().setTitle(null);

        tablayout_home = (TabLayout) findViewById(R.id.tablayout_home);
        viewPager_content = (ViewPager) findViewById(R.id.viewPager_content);
        //CONFIGURACIÓN DE TABS
        tablayout_home = (TabLayout) findViewById(R.id.tablayout_home);
        tab_home = (TabItem) findViewById(R.id.tab_home);
        tab_categoria = (TabItem) findViewById(R.id.tab_categoria);
        tab_noticias = (TabItem) findViewById(R.id.tab_noticias);
        viewPager_content = (ViewPager) findViewById(R.id.viewPager_content);

        fab_shopping_cart = (FloatingActionButton) findViewById(R.id.fab_shopping_cart);
        fab_shopping_cart.setOnClickListener(this);


        pageAdapter = new PageAdapter(getSupportFragmentManager(), tablayout_home.getTabCount());
        viewPager_content.setAdapter(pageAdapter);

        tablayout_home.addOnTabSelectedListener(this);
        viewPager_content.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tablayout_home));
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

    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        viewPager_content.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }

    private void updateUI(FirebaseUser currentUser) {

    }

    @Override
    public void onClick(View view) {
       if(view.getId() == R.id.fab_shopping_cart){
           Intent intent = new Intent(this, Carrito.class);
           startActivity(intent);
       }
    }
}

package dev.saul1317.punxmusic;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;

public class Home extends AppCompatActivity {

    TabLayout tablayout_home;
    ViewPager viewPager_content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        loadUI();
    }

    private void loadUI() {
        Toolbar home_toolbar = (Toolbar) findViewById(R.id.toolbar);
        home_toolbar.setLogo(R.drawable.punxmusic_logo_appbar);
        home_toolbar.setNavigationIcon(R.drawable.burger_icon);
        setSupportActionBar(home_toolbar);
        tablayout_home = (TabLayout) findViewById(R.id.tablayout_home);
        viewPager_content = (ViewPager) findViewById(R.id.viewPager_content);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here.
        int id = item.getItemId();
        if(id == R.id.action_search){
            Toast.makeText(this, "Search", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }
}

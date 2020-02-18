package dev.saul1317.punxmusic;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

import dev.saul1317.punxmusic.Adapter.PageAdapter;

public class Home extends AppCompatActivity implements TabLayout.OnTabSelectedListener {

    TabLayout tablayout_home;
    TabItem tab_home, tab_categoria, tab_noticias;
    ViewPager viewPager_content;
    PageAdapter pageAdapter;

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
        //CONFIGURACIÓN DE TABS
        tablayout_home = (TabLayout) findViewById(R.id.tablayout_home);
        tab_home = (TabItem) findViewById(R.id.tab_home);
        tab_categoria = (TabItem) findViewById(R.id.tab_categoria);
        tab_noticias = (TabItem) findViewById(R.id.tab_noticias);
        viewPager_content = (ViewPager) findViewById(R.id.viewPager_content);

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
}

package dev.saul1317.punxmusic.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import dev.saul1317.punxmusic.Categoria;
import dev.saul1317.punxmusic.Noticias;
import dev.saul1317.punxmusic.Novedades;

public class PageAdapter  extends FragmentPagerAdapter {

    private int numOfTab;

    public PageAdapter(@NonNull FragmentManager fm, int numOfTab) {
        super(fm, numOfTab);
        this.numOfTab = numOfTab;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new Novedades();
            case 1:
                return new Categoria();
            case 2:
                return new Noticias();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return numOfTab;
    }

    @Override
    public int getItemPosition(@NonNull Object object) {
        return POSITION_NONE;
    }
}
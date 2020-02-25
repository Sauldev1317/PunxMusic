package dev.saul1317.punxmusic;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;


/**
 * A simple {@link Fragment} subclass.
 */
public class Categoria extends Fragment implements View.OnClickListener {

    private FrameLayout button_catalogo_guitarra_electrica, button_catalogo_guitarra_acustica,
            button_catalogo_bajo, button_catalogo_bateria;

    public Categoria() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_categoria, container, false);
        button_catalogo_guitarra_electrica = (FrameLayout) view.findViewById(R.id.button_catalogo_guitarra_electrica);
        button_catalogo_guitarra_electrica.setOnClickListener(this);
        button_catalogo_guitarra_acustica = (FrameLayout) view.findViewById(R.id.button_catalogo_guitarra_acustica);
        button_catalogo_guitarra_acustica.setOnClickListener(this);
        button_catalogo_bajo = (FrameLayout) view.findViewById(R.id.button_catalogo_bajo);
        button_catalogo_bajo.setOnClickListener(this);
        button_catalogo_bateria = (FrameLayout) view.findViewById(R.id.button_catalogo_bateria);
        button_catalogo_bateria.setOnClickListener(this);
        return view;
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.button_catalogo_guitarra_electrica:
                abrirCatalogo();
                break;

            case R.id.button_catalogo_guitarra_acustica:
                abrirCatalogo();
                break;

            case R.id.button_catalogo_bajo:
                abrirCatalogo();
                break;

            case R.id.button_catalogo_bateria:
                abrirCatalogo();
                break;
        }
    }

    private void abrirCatalogo() {
        Intent intent = new Intent(getActivity(), Catalogo.class);
        startActivity(intent);
    }


}

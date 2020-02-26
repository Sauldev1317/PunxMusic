package dev.saul1317.punxmusic;


import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Handler;
import android.util.Log;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dev.saul1317.punxmusic.Adapter.AdapterRecyclerviewInstrumento;
import dev.saul1317.punxmusic.Adapter.OnItemClickListener;
import dev.saul1317.punxmusic.Animation.CardviewAnimation;
import dev.saul1317.punxmusic.Animation.CardviewAnimationEvent;
import dev.saul1317.punxmusic.Model.Instrumento;


/**
 * A simple {@link Fragment} subclass.
 */
public class Novedades extends Fragment implements View.OnTouchListener {

    private static final String TAG = "NOVEDADES";

    CardView cardview_nuevos_instrumentos, cardview_fender_instruments, cardview_tutoriales, cardview_conciertos;
    RecyclerView recyclerview_productos_populares;
    CardviewAnimation cardviewAnimation;
    AdapterRecyclerviewInstrumento adapterRecyclerviewInstrumento;

    //FIREBASE
    private FirebaseAuth mAuth;
    FirebaseFirestore db;


    public Novedades() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_novedades, container, false);
        cardviewAnimation = new CardviewAnimation();

        cardview_nuevos_instrumentos = (CardView) view.findViewById(R.id.cardview_nuevos_instrumentos);
        cardview_nuevos_instrumentos.setOnTouchListener(this);

        cardview_fender_instruments = (CardView) view.findViewById(R.id.cardview_fender_instruments);
        cardview_fender_instruments.setOnTouchListener(this);

        cardview_tutoriales = (CardView) view.findViewById(R.id.cardview_tutoriales);
        cardview_tutoriales.setOnTouchListener(this);

        cardview_conciertos = (CardView) view.findViewById(R.id.cardview_conciertos);
        cardview_conciertos.setOnTouchListener(this);

        recyclerview_productos_populares = (RecyclerView) view.findViewById(R.id.recyclerview_productos_populares);
        recyclerview_productos_populares.setHasFixedSize(true);
        recyclerview_productos_populares.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false));

        settingFirebase();

        return view;

    }

    private void settingFirebase() {
        mAuth = FirebaseAuth.getInstance();
        db = FirebaseFirestore.getInstance();
        getInstrumentos();
    }

    private void getInstrumentos() {

        db.collection("instrumento")
                .orderBy("nombre", Query.Direction.DESCENDING)
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            if (task.getResult() != null) {
                                List<Instrumento> instrumentoList = new ArrayList<>();

                                for (QueryDocumentSnapshot document : task.getResult()) {
                                    Instrumento instrumento = document.toObject(Instrumento.class);
                                    instrumento.setId(document.getId());
                                    instrumentoList.add(instrumento);
                                }

                                adapterRecyclerviewInstrumento = new AdapterRecyclerviewInstrumento(R.layout.cardview_productos, instrumentoList,
                                        getContext(), new OnItemClickListener() {
                                    @Override
                                    public void onItemClick(Instrumento instrumento, View view) {
                                        abrirDescripcionInstrumento(instrumento, view);
                                    }
                                });

                                recyclerview_productos_populares.setAdapter(adapterRecyclerviewInstrumento);

                            }
                        } else {
                            Log.e(TAG, "Error getting documents.", task.getException());
                        }
                    }
                });
    }


    @Override
    public boolean onTouch(View view, MotionEvent event) {
        switch (view.getId()){
            case R.id.cardview_nuevos_instrumentos:
                cardviewAnimation.setCarviewAction(event.getAction(), view, new CardviewAnimationEvent() {
                    @Override
                    public void OnCardviewAnimationFinish(View view) {
                        abrirCatalogo();
                    }
                });
                break;

            case R.id.cardview_fender_instruments:
                cardviewAnimation.setCarviewAction(event.getAction(), view, new CardviewAnimationEvent() {
                    @Override
                    public void OnCardviewAnimationFinish(View view) {
                        Toast.makeText(getContext(), "Fender Instrumentos", Toast.LENGTH_SHORT).show();
                    }
                });
                break;

            case R.id.cardview_tutoriales:
                cardviewAnimation.setCarviewAction(event.getAction(), view, new CardviewAnimationEvent() {
                    @Override
                    public void OnCardviewAnimationFinish(View view) {
                        Toast.makeText(getContext(), "Tutoriales", Toast.LENGTH_SHORT).show();
                    }
                });
                break;

            case R.id.cardview_conciertos:
                cardviewAnimation.setCarviewAction(event.getAction(), view, new CardviewAnimationEvent() {
                    @Override
                    public void OnCardviewAnimationFinish(View view) {
                        Toast.makeText(getContext(), "Conciertos", Toast.LENGTH_SHORT).show();
                    }
                });
                break;

            default:
                break;
        }
        return true;
    }

    private void abrirDescripcionInstrumento(Instrumento instrumento, View view){
        Intent intent = new Intent(getActivity(), Descripcion.class);
        intent.putExtra("instrumento", instrumento);
        Pair[] pairs = new Pair[2];
        pairs[0] = new Pair<View, String> (view, "cardview_instrument");
        pairs[1] = new Pair<View, String> (view, "img_instrument");
        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(getActivity(), pairs);
        startActivity(intent, options.toBundle());

    };

    private void abrirCatalogo(){
        Intent intent = new Intent(getActivity(), Catalogo.class);
        startActivity(intent);
    }

}

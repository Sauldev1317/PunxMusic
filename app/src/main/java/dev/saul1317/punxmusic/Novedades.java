package dev.saul1317.punxmusic;


import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import dev.saul1317.punxmusic.Animation.CardviewAnimation;
import dev.saul1317.punxmusic.Animation.CardviewAnimationEvent;


/**
 * A simple {@link Fragment} subclass.
 */
public class Novedades extends Fragment implements View.OnTouchListener {


    CardView cardview_nuevos_instrumentos, cardview_fender_instruments, cardview_tutoriales, cardview_conciertos;
    RecyclerView recyclerview_productos_populares;
    CardviewAnimation cardviewAnimation;

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
        return view;


    }

    @Override
    public boolean onTouch(View view, MotionEvent event) {
        switch (view.getId()){
            case R.id.cardview_nuevos_instrumentos:
                cardviewAnimation.setCarviewAction(event.getAction(), view, new CardviewAnimationEvent() {
                    @Override
                    public void OnCardviewAnimationFinish(View view) {
                        Toast.makeText(getContext(), "Hola we", Toast.LENGTH_SHORT).show();
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


}

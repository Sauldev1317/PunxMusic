package dev.saul1317.punxmusic.Animation;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Handler;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import androidx.cardview.widget.CardView;

public class CardviewAnimation {

    //DURACION DE LA ANIMACION DE LOS BOTONES AL MOMENTO DE HACER CLICK
    public static final int DURATION_ANIMATION_CARD = 200;
    CardviewAnimationEvent cardviewAnimationEvent;


    /*
     * SACAMOS TRES TIPOS DE EVENTOS PARA EL TOUCH LISTENER
     * 1.- ACTION DOWN: PRESIONAR EL BOTON
     * 2.- ACTION UP: DEJAR DE PRESIONAR EL BOTON
     * 3.- ACTION CANCEL: CANCELAR EL TOUCH (CUANDO NO SE COMPLETA EL ACTION UP)
     *
     * NOTA SE SACAN ESTOS EVENTOS PARA REALIZAR LAS DIFERENTES ANIMACIONES AL MOMENTO DE INTERACTUAR CON EL BOTON
     */
    public void setCarviewAction(int action, final View view, final CardviewAnimationEvent cardviewAnimationEvent) {
        switch (action) {
            //PRESIONAS EL BOTON Y EJECUTA UNA ANIMACION
            case MotionEvent.ACTION_DOWN:
                //EL BOTON SE HACE PEQUEÑO SIMULANDO QUE LO ESTAS PRESIONANDO
                animationCardPushDown(view);
                break;

            //CUANDO SE DEJA DE PRESIONAR EL BOTON EJECUTA UNA ANIMACION CONTRARIA A LA DE ACTION_DOWN
            case MotionEvent.ACTION_UP:
                //EL BOTON VUELVE A SU TAMAÑO NORMAL PERO DESPUES DE LA ANIMACION EJECUTA UNA ACCION
                animationCardPushUp(view);
                // EN ESTE CASO LA OPCION 1 EJECUTA ABRIRRASTREOPEDIDO() EL CUAL ABRE LA VENTA DEL CODIGO DE RASTREO
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if(cardviewAnimationEvent!= null) {
                            cardviewAnimationEvent.OnCardviewAnimationFinish(view);
                        }
                    }
                },150);
                //NOTA: EN CASO DE QUE SE REQUIERA AGREGAR MAS OPCIONES EN EL MENU RECOMIENDO SUSTITUIR LOS IF POR SWITCH PARA TENER MAYOR CONTROL Y ORDEN DEL CODIGO
                break;

            //EN CASO DE QUE NO SE COMPLETE EL ACTION UP ENTONCES EJECUTA LA MISMA ANIMACION PARA RECUPERAR EL TAMAÑO DEL BOTON PERO SOLO SE EJECUTA LA ACCION
            case MotionEvent.ACTION_CANCEL:
                //ANIMACION PARA HACER QUE EL BOTON SE HAGA GRANDE DESPUES DE DEJAR DE PRESIONARLO
                animationCardPushUp(view);
                break;
        }
    }
    /*
     * ANIMACION DEL CARDVIEW AL MOMENTO DE PRESIONAR
     * LA ANIMACION HACE QUE EL CARDVIEW SE HAGA MAS PEQUEÑO
     * PARA SIMULAR QUE SE CONTRAE AL MOMENTO DE PRESIONARLO
     */
    private void animationCardPushDown(View view){
        //SE REDUCE EL TAMAÑO AL 94% DEL TAMAÑO ORIGINAL
        ObjectAnimator scaleDownX = ObjectAnimator.ofFloat(view,
                "scaleX", 0.98f);
        ObjectAnimator scaleDownY = ObjectAnimator.ofFloat(view,
                "scaleY", 0.98f);
        scaleDownX.setDuration(DURATION_ANIMATION_CARD);
        scaleDownY.setDuration(DURATION_ANIMATION_CARD);

        AnimatorSet scaleDown = new AnimatorSet();
        scaleDown.play(scaleDownX).with(scaleDownY);

        scaleDown.start();
    }

    /*
     * ANIMACION DEL CARDVIEW AL MOMENTO DE DEJAR PRESIONADO EL BOTON
     * EL CARDVIEW VUELVE A SU TAMAÑO ORIGINAR
     */
    private void animationCardPushUp(View view){
        //SE INCREMENTA AL TAMAÑO ORIGINAL
        ObjectAnimator scaleDownX = ObjectAnimator.ofFloat(
                view, "scaleX", 1f);
        ObjectAnimator scaleDownY = ObjectAnimator.ofFloat(
                view, "scaleY", 1f);
        scaleDownX.setDuration(DURATION_ANIMATION_CARD);
        scaleDownY.setDuration(DURATION_ANIMATION_CARD);

        AnimatorSet scaleDown3 = new AnimatorSet();
        scaleDown3.play(scaleDownX).with(scaleDownY);

        scaleDown3.start();
    }
}

package dev.saul1317.punxmusic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.airbnb.lottie.LottieAnimationView;

public class Splash extends AppCompatActivity {

    public String TAG = "Splash";
    public final int DURATION_SPLASH = 2000;

    //LottieAnimationView animation_view;

    private Handler handler;
    private Runnable myRunnable;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        loadUI();
    }

    private void loadUI() {
        //animation_view = (LottieAnimationView) findViewById(R.id.animation_view);
    }

    @Override
    protected void onStart() {
        super.onStart();
        durationSplash();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
        handler.removeCallbacks(myRunnable);
    }

    public void durationSplash(){
        //hilo para abrir la siguiente ventana despues despues de tres segundos
        handler = new Handler();
        myRunnable = new Runnable() {
            @Override
            public void run() {
                openNewActivity();
            }
        };
        handler.postDelayed(myRunnable, DURATION_SPLASH);
    }


    //Abrir la siguiente ventana
    private void openNewActivity() {
        Intent intent = new Intent(this, Home.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        //overridePendingTransition( 0, R.anim.fade_out_animation);
    }

}

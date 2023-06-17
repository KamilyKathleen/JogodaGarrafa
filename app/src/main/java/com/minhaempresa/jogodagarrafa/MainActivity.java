package com.minhaempresa.jogodagarrafa;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private ImageView garrafa, dragoes;
    private Random aleatorio = new Random();
    private int lstDr;
    private boolean giro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        garrafa = findViewById(R.id.garrafa);
        dragoes = findViewById(R.id.dragoes);
    }
    public void girarGarrafa(View view) {
        if(!giro) {
            int num = aleatorio.nextInt(3600);

            float gX = garrafa.getWidth() / 2;
            float gY = garrafa.getHeight() / 2;
            float dX = dragoes.getWidth() / 2;
            float dY = dragoes.getHeight() / 2;

            Animation rotacao = new RotateAnimation(lstDr, num, gX, gY);
            Animation rotacao2 = new RotateAnimation(lstDr, num, dX,dY);

            rotacao.setDuration(2500);
            rotacao2.setDuration(2500);

            rotacao.setFillAfter(true);
            rotacao2.setFillAfter(true);

            rotacao.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationStart(Animation animation) {
                    giro = true;
                }

                @Override
                public void onAnimationEnd(Animation animation) {
                    giro = false;
                }

                @Override
                public void onAnimationRepeat(Animation animation){}
            });

            lstDr = num;

            garrafa.startAnimation(rotacao);
            dragoes.startAnimation(rotacao2);
        }
    }
}

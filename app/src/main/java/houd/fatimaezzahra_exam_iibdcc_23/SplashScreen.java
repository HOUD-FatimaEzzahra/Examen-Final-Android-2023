package houd.fatimaezzahra_exam_iibdcc_23;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class SplashScreen extends AppCompatActivity {

    private ImageView logo;
    private View Topview1,Topview2,Topview3;
    private View Bottomview1,Bottomview2,Bottomview3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN |
                View.SYSTEM_UI_FLAG_HIDE_NAVIGATION |
                View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN |
                View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION |
                View.SYSTEM_UI_FLAG_IMMERSIVE |
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE);

        setContentView(R.layout.activity_splash_screen);
        logo = findViewById(R.id.logo);
        Topview1 = findViewById(R.id.Topview1);
        Topview2 = findViewById(R.id.Topview2);
        Topview3 = findViewById(R.id.Topview3);
        Bottomview1 = findViewById(R.id.ButtomView1);
        Bottomview2 = findViewById(R.id.ButtomView2);
        Bottomview3 = findViewById(R.id.ButtomView3);

        Animation logoAnimation = android.view.animation.AnimationUtils.loadAnimation(this,R.anim.zoom_animation);
        Animation Topview1Animation = android.view.animation.AnimationUtils.loadAnimation(this,R.anim.top_views_animation);
        Animation Topview2Animation = android.view.animation.AnimationUtils.loadAnimation(this,R.anim.top_views_animation);
        Animation Topview3Animation = android.view.animation.AnimationUtils.loadAnimation(this,R.anim.top_views_animation);

        Animation Bottomview1Annimation = android.view.animation.AnimationUtils.loadAnimation(this,R.anim.buttom_views_animation);
        Animation Bottomview2Annimation = android.view.animation.AnimationUtils.loadAnimation(this,R.anim.buttom_views_animation);
        Animation Bottomview3Annimation = android.view.animation.AnimationUtils.loadAnimation(this,R.anim.buttom_views_animation);


        Topview1.startAnimation(Topview1Animation);
        Bottomview1.startAnimation(Bottomview1Annimation);

        Topview1Animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                Topview2.setVisibility(View.VISIBLE);
                Bottomview2.setVisibility(View.VISIBLE);
                Topview2.startAnimation(Topview2Animation);
                Bottomview2.startAnimation(Bottomview2Annimation);
            }
            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        Topview2Animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                Topview3.setVisibility(View.VISIBLE);
                Bottomview3.setVisibility(View.VISIBLE);
                Topview3.startAnimation(Topview3Animation);
                Bottomview3.startAnimation(Bottomview3Annimation);            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });


        Topview3Animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                logo.setVisibility(View.VISIBLE);
                logo.startAnimation(logoAnimation);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        // Créez un objet Handler pour gérer le délai
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // Créez une intention pour démarrer MainActivity
                Intent intent = new Intent(SplashScreen.this, RecycleListActivity.class);
                startActivity(intent);

                finish();
            }
        }, 4000); // Définissez la durée du délai en millisecondes (ici, 3000 ms = 3 secondes)

    }
}
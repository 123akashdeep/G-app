package com.example.shashank.g_app;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);

        ImageView iv=(ImageView) findViewById(R.id.img);
        Animation an= AnimationUtils.loadAnimation(getBaseContext(),R.anim.clock);
        iv.startAnimation(an);

        Animation an2= AnimationUtils.loadAnimation(getBaseContext(),R.anim.anim);
        iv.startAnimation(an2);

       /* new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                Intent i=new Intent(getApplicationContext(),Home.class);
                startActivity(i);
            }
        },9000);*/

    }

    @Override
    protected void onStop() {
        super.onStop();
        finish();
    }
}

package com.example.shashank.g_app;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

public class Splash extends AppCompatActivity {

    boolean check =false;
    ImageView iv;
    EditText idd,passs;
    LinearLayout ll;
    Button btn;
    String id,pass,i_d,k_ey;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);

        SharedPreferences sp=getSharedPreferences("login",1);
         i_d=sp.getString("id","def");
         k_ey=sp.getString("key","def");

        passs= (EditText) findViewById(R.id.password);
        idd= (EditText) findViewById(R.id.input_number);
        ll=(LinearLayout)findViewById(R.id.login);
        btn=(Button) findViewById(R.id.loginbutton);
        iv=(ImageView) findViewById(R.id.img);
        Animation an= AnimationUtils.loadAnimation(getBaseContext(),R.anim.clock);
        iv.startAnimation(an);
        an.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
            }
            @Override
            public void onAnimationEnd(Animation animation) {
                if((i_d.equals("14SCSE106002")) && (k_ey.equals("asd")))//shared preference chek on database and bring data related to saved key value pair
                {
                    startActivity(new Intent(Splash.this,Home.class));
                }
                else
                    {
                Animation an2 = AnimationUtils.loadAnimation(getBaseContext(), R.anim.anim);
                an2.setFillAfter(true);
                iv.startAnimation(an2);
                an2.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {
                    }
                    @Override
                    public void onAnimationEnd(Animation animation) {
                        ll.setVisibility(View.VISIBLE);
                    }
                    @Override
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
            }}
            @Override
            public void onAnimationRepeat(Animation animation) {
            }
        });

    }

    public void fun(View v){
      id= idd.getText().toString();
        pass=passs.getText().toString();
        if((id.equals("14SCSE106002")) && (pass.equals("asd")))//database connectivity to bring info
        {
            SharedPreferences sp= getSharedPreferences("login",1);
            SharedPreferences.Editor e=sp.edit();
            e.putString("id",id);
            e.putString("key",pass);
            e.commit();
            startActivity(new Intent(this,Home.class));
        }
        else{
            Toast.makeText(this,"wrong id ,password", Toast.LENGTH_LONG).show();

        }
    }

    @Override
    public void onBackPressed() {

        if(check)
        {
            super.onBackPressed();
            return;
        }
        this.check=true;
        Toast.makeText(this,"press back again to exit",Toast.LENGTH_SHORT).show();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                check=false;
            }
        },2000);
    }

    @Override
    protected void onStop() {
        super.onStop();
        finish();
    }
}

package com.example.myapplication;

import android.graphics.Point;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnTouchListener {
    int randomNumber;
    Random random = new Random();
    boolean forBombSet = true;
    ImageView bomb;
    int playerVector = 100;
    FrameLayout.LayoutParams lp;
    FrameLayout.LayoutParams lp1;
    View figure;
    View bombFragment;
    ImageView playerfigure;
    ImageView play;
    Display display ;
    Point size;
    int width ;
    int height;
   float x;
   float y;

   @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        play = findViewById(R.id.play_icon);
        figure = findViewById(R.id.figure);
        bombFragment = findViewById(R.id.bomb_fragment);
        display = getWindowManager().getDefaultDisplay();
        bomb = findViewById(R.id.bomb);
        lp = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.MATCH_PARENT);
        lp1 = new FrameLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
        size = new Point();
        display.getSize(size);
        width = size.x;
        height = size.y;
        playerfigure = findViewById(R.id.figureplayer);
    }
    public void play(View view) {
        play.setVisibility(View.INVISIBLE);
        playerfigure.setVisibility(View.VISIBLE);

        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                int xx = 5;
                while (forBombSet){



                    randomeBombeVector();

                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
        });
    }
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        x = event.getX();
        y = event.getY();
        if (play.getVisibility() != View.VISIBLE) {
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    if (x>(width/2) && playerVector<(width-250)) {
                        playerVector += 100;
                        lp.setMarginStart(playerVector);
                        figure.setLayoutParams(lp);
                    } else if(x<(width/2) && playerVector>72){

                        playerVector -= 100;
                        lp.setMarginStart(playerVector);
                        figure.setLayoutParams(lp);
                    }
            }
            return false;
        }
        return super.onTouchEvent(event);
   }

    @Override
 public boolean onTouch(View v, MotionEvent event) {

     return false;
 }
 public void randomeBombeVector (){
     randomNumber = random.nextInt(width);
     lp1.setMarginStart(randomNumber);
     bombFragment.setLayoutParams(lp1);
     bomb.setVisibility(View.VISIBLE);



 }



}






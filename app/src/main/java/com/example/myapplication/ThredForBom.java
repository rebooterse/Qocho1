package com.example.myapplication;

import android.graphics.Point;
import android.view.Display;
import android.view.View;

import java.util.Random;

public class ThredForBom extends MainActivity implements Runnable {


    Thread thread;
    public ThredForBom() {
        thread = new Thread(this,"patok");
        thread.start();
    }


    @Override
    public void run() {


        while (forBombSet) {
            randomBomber();


                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

        }

    }
}



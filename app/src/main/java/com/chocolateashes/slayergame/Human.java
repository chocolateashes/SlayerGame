package com.chocolateashes.slayergame;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.os.Looper;

/**
 * Created by Ashwini on 5/2/15.
 */
public class Human extends Bodies implements Runnable
{
    Bitmap zombieImage;

    private SlayerGame slayergameobject;
    public int xpos = 0;
    public int ypos = (int)(Math.random()*700);
    public Human (SlayerGame slayer)
    {
        slayergameobject = slayer;
        zombieImage = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(slayer.getResources(), R.drawable.man), 120, 120, false);
    }

    @Override
    public void drawBody(int y, int x, Canvas g)
    {
        ypos = y;
        xpos = x;
        g.drawBitmap(zombieImage, ypos, xpos, null);
        //Thread fall;

        //fall = new Thread(this);

        //fall.start();
    }

    public void falling()
    {
        Thread fallingnow = new Thread(this);
        fallingnow.start();
    }


    @Override
    public void run()
    {
        //Looper.prepare();
        while(true)
        {
            if(xpos>1000)
                break;
            xpos = xpos + 2;
            slayergameobject.board.postInvalidate();
            try {
                Thread.sleep((long)(500+ Math.random()*2000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

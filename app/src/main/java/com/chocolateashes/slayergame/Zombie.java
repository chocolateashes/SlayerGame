package com.chocolateashes.slayergame;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.os.Handler;
import android.os.Looper;
import android.view.View;

/**
 * Created by Ashwini on 5/2/15.
 */
public class Zombie extends Bodies implements Runnable
{
    Bitmap zombieImage;

    private SlayerGame slayergameobject;
    public int xpos = 0;
    public int ypos = (int)(Math.random()*700);
    public Zombie (SlayerGame slayer)
    {
        slayergameobject = slayer;
        zombieImage = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(slayer.getResources(), R.drawable.ghost), 130, 130, false);
        setVisible = true;
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
        /*Handler handler = new Handler();
        while(slayergameobject.gameNotOver==true)
        {
            handler.postDelayed(new Runnable ()
            {
                public void run() {
                    if(xpos>1000)
                        slayergameobject.gameNotOver=false;
                    xpos = xpos + 2;
                    slayergameobject.board.postInvalidate();
                }
            }, 1000);
        }

        if (xpos < 1000)
            xpos = xpos + 2;
        else if (xpos > 1000)
            slayergameobject.gameNotOver = false;*/
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

    public void killZombie(float x, float y)
    {
        if(x<=xpos+130 && x>=xpos-130 && y>=ypos-130 && y<=ypos+130){
            slayergameobject.zombielist
        }
    }
}

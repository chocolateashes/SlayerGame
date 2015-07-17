package com.chocolateashes.slayergame;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.View;

/**
 * Created by Ashwini on 5/2/15.
 */
public class BoardComponent extends View
{
    Bitmap backgroundImage;
    private SlayerGame slayergamemainobject;

    public BoardComponent(Context context)
    {
        super(context);
        slayergamemainobject = (SlayerGame)context;
        //backgroundImage = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.background), 1000, 1000,false);
        backgroundImage = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.images), 1000, 1000,false);
    }

    protected void onDraw(Canvas g)
    {
        //width and height of the device set to the screen width and height
        //SlayerGame.boardWidth = g.getWidth();
        //SlayerGame.boardHeight = g.getHeight();

        //draw background
        g.drawBitmap(backgroundImage, 0, 0, null);

        //draw zombies
        //for(int i = 0; i< SlayerGame.zombielist.length; i++)
        for(int i = 0; i<slayergamemainobject.humanlist.length; i++)
        {
            slayergamemainobject.zombielist[i].drawBody(slayergamemainobject.zombielist[i].ypos, slayergamemainobject.zombielist[i].xpos, g);
            slayergamemainobject.zombielist[i].falling();

            slayergamemainobject.humanlist[i].drawBody(slayergamemainobject.humanlist[i].ypos, slayergamemainobject.humanlist[i].xpos, g);
            slayergamemainobject.humanlist[i].falling();
        }
    }
}


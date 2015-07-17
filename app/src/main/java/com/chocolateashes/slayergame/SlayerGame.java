package com.chocolateashes.slayergame;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.os.Bundle;
import android.os.Looper;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;

import java.util.Timer;
import android.os.Handler;
import java.util.logging.LogRecord;


public class SlayerGame extends Activity implements View.OnTouchListener
{
    public static double boardWidth = 1000;
    public static double boardHeight = 1000;

    //public static int xpos=0;
    //public static int ypos=(int) (Math.random()*(boardWidth-5));
    public boolean gameNotOver=true;
    public int turn=0;
    public int count = 0;

    //Main class
    public BoardComponent board;
    public static Zombie[] zombielist;
    public Human[] humanlist;
    public static Zombie zombie;
    public static Zombie zombie2;
    public static Zombie zombie3;

    public static int number=0;


    //Thread fall = new Thread(this);
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        zombielist = new Zombie[5];
        humanlist = new Human[2];
        board = new BoardComponent(this);
        setContentView(board);
/*
        Handler handler = new Handler();
        while(gameNotOver==true)
        {
            handler.postDelayed(new Runnable ()
            {
                public void run() {
                    updateGameState();
                    board.postInvalidate();
                }
            }, 1000);
        }*/


        for(int i = 0; i<humanlist.length; i++) {
            zombielist[i] = new Zombie(this);
            humanlist[i] = new Human(this);
        }

        board = new BoardComponent(this);
        setContentView(board);
        //for(int i = 0;)
        //zombielist[i] = new Zombie(this);}
            //zombie.falling();



        //board.postInvalidate();
        //fall = new Thread(this);

    }
/*
    protected void updateGameState()
    {
            int x = (int)(Math.random()*10);
            if(x%2==0)
            {
                if(count<zombielist.length)
                {
                    zombielist[count] = new Zombie(this);
                    count++;
                }
            }
            for(int j = 0; j<count; j++)
            {
                zombielist[j].falling();
            }
            //board.postInvalidate();
            //pause = new Thread(this);
            //pause.start();

    }*/



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_slayer_game, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public int i;
    @Override
    public boolean onTouch(View v, MotionEvent event) {

        for( i=0; i<zombielist.length; i++)
        {
            zombielist[i].killZombie(event.getX(), event.getY());
        }
        board.postInvalidate();
        return false;    }
}

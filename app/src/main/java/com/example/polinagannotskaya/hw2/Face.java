package com.example.polinagannotskaya.hw2;

/*
Author:  Polina Gannotskaya
This Face class contains all the methods needed to draw a face.
 */


import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.SurfaceView;

import java.util.Random;

public class Face extends SurfaceView
{

    //global variables
    public static int skinColor;
    public static int eyeColor;
    public static int hairColor;
    public static int hairStyle;



    //constructor
    public Face(Context context, AttributeSet set)
    {
        super(context, set);
        setWillNotDraw(false);
        skinColor = randomize();
        eyeColor = randomize();
        hairColor = randomize();


    }
    @Override
    public void onDraw(Canvas canvas)
    {
        Paint background = new Paint();
        background.setColor(Color.WHITE);

        canvas.drawColor(Color.WHITE);
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.FILL);
        canvas.drawCircle(900, 600, 550, paint);

        drawFaceShape(skinColor, canvas);
        drawEyes(eyeColor, canvas);
        drawHair(hairColor, hairStyle, canvas);

        invalidate();
    }//begins the drawing of the face

    //method to make the variables random
    private int randomize()
    {
        Random rand = new Random();
        int red = rand.nextInt(255);
        int green = rand.nextInt(255);
        int blue = rand.nextInt(255);
        hairStyle = rand.nextInt(3);
        int outColor = Color.argb(255, red, green, blue);
        return outColor;
    }

    //calls the methods that draw the face


    public static void setEyeColor(int color) {
        eyeColor = color;
    }

    public static void setHairStyle(int style) {
        hairStyle = style;
    }

    public static void setSkinColor(int color) {
        skinColor = color;
    }

    public static void setHairColor(int color) {
        hairColor = color;
    }

    //draws the color of the skin onto the face
    public void drawFaceShape(int skinColor, Canvas canvas)
    {
        Paint paint = new Paint();
        paint.setColor(skinColor);
        paint.setStyle(Paint.Style.FILL);
        canvas.drawCircle(900, 600, 550, paint);

        //mouth
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.BLACK);
        canvas.drawArc(650, 500, 1150, 900, 180, -180, true, paint);
        invalidate();
    }

    public void drawEyes(int eyeColor, Canvas canvas)
    {
        Paint paint = new Paint();
        //Left eye
        paint.setColor(Color.WHITE);
        canvas.drawCircle(700, 500, 75, paint);
        //Right eye
        canvas.drawCircle(1100, 500, 75, paint);


        //choose Eye color
        paint.setColor(eyeColor);
        //draw eyes
        paint.setStyle(Paint.Style.FILL);
        canvas.drawCircle(700, 500, 50, paint);
        canvas.drawCircle(1100, 500, 50, paint);

        //pupil for left and right eye
        paint.setColor(Color.BLACK);
        canvas.drawCircle(700, 500, 25, paint);
        canvas.drawCircle(1100, 500, 25, paint);
        invalidate();

    }

    //method draws hair
    public  void drawHair(int hairColor, int hairStyle, Canvas canvas)
    {
        Paint paint = new Paint();
        //assigns hair color
        paint.setColor(hairColor);

        //draws the desired hairstyle
        if (hairStyle == 1)
        {
            //bald so no hair
        }
        if(hairStyle == 2)
        {
            //light strands
            paint.setStyle(Paint.Style.STROKE);
            canvas.drawArc(350, 50, 1450, 900, 180, 180, false, paint);
            canvas.drawArc(340, 50, 1460, 900, 180, 180, false, paint);
            canvas.drawArc(330, 50, 1470, 900, 180, 180, false, paint);
            canvas.drawArc(360, 50, 1440, 900, 180, 180, false, paint);
            canvas.drawArc(320, 50, 1430, 900, 180, 180, false, paint);

        }
        else if(hairStyle == 3)
        {
            //bowl haircut
            paint.setStyle(Paint.Style.FILL);
            canvas.drawArc(350, 50, 1450, 800, 180, 180, true, paint);

        }
        invalidate();
    }


}

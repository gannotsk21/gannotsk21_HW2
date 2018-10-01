package com.example.polinagannotskaya.hw2;


/*
Author:  Polina Gannotskaya
This SeekBarState class contains anything that pertains to the where the seekbars are at.
example: red adjust, constrain to color change, ect
 */

import android.graphics.Color;

public class SeekBarState
{

    private static final SeekBarState ourInstance = new SeekBarState();
    private int redAdjust;
    private int blueAdjust;
    private int greenAdjust;

    public static SeekBarState getInstance()
    {
        return ourInstance;
    }//returns the instance of this class

    //constructor for class
    private SeekBarState()
    {
        redAdjust = 0;
        blueAdjust = 0;
        greenAdjust = 0;
    }

    public void setRedAdjust(int rProgress)
    {
        redAdjust = rProgress;
    }//sets red adjust to progress

    public int getRedAdjust()
    {
        return redAdjust;
    }//returns red adjust

    public void setBlueAdjust(int bProgress)
    {
        blueAdjust = bProgress;
    }//sets blue adjust to progress

    public int getBlueAdjust()
    {
        return blueAdjust;
    }//returns blue adjust

    public void setGreenAdjust(int gProgress)
    {
        greenAdjust = gProgress;
    }//sets green adjust to progress

    public int getGreenAdjust()
    {
        return greenAdjust;
    }//returns green adjust


}

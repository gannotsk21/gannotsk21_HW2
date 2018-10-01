package com.example.polinagannotskaya.hw2;

import android.app.Activity;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static com.example.polinagannotskaya.hw2.Face.hairColor;
/*
Author:  Polina Gannotskaya
This MainActivity class contains all the elements that is on the user interface.
It also contains the listener classes
 */

public class MainActivity extends AppCompatActivity {

    // variables

    int buttonState = 1;
    public static Face myFace;



    /*
        onCreate method does the initial creating of the elements
         */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myFace = (Face) findViewById(R.id.facePicture);

        /*
        initiation of the seek bars as well as connecting the proper seek bars to it's listener
         */
        //RED seekBar
        SeekBar redSeekBar = findViewById(R.id.redSeekBar);
        redSeekBar.setOnSeekBarChangeListener(new redSeekBarListener());
        //BLUE seekBar
        SeekBar blueSeekBar = findViewById(R.id.blueSeekBar);
        blueSeekBar.setOnSeekBarChangeListener(new blueSeekBarListener());
        //GREEN seekBar
        SeekBar greenSeekBar = findViewById(R.id.greenSeekBar);
        greenSeekBar.setOnSeekBarChangeListener(new greenSeekBarListener());

        /*
        initiation of the Button and connecting the button to its listener
         */
        Button randomFaceButton = findViewById(R.id.randomFace);
        randomFaceButton.setOnClickListener(new randomFaceButtonListener());

        /*
        initiation of the spinner. It also connects the spinner to it's listener
         */
        SpinnerListener spinListener = new SpinnerListener();
        List<String> hair = new ArrayList<>();
        hair.add("Hairstyle 1");
        hair.add("Hairstyle 2");
        hair.add("Hairstyle 3");
        //gets info from strings.xml resource file
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, hair);
        //connect spinner to xml spinner
        Spinner spinnerHairChoice = findViewById(R.id.hairSpinner);
        //sets data to be seen in a drop down view
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerHairChoice.setOnItemSelectedListener(spinListener);
        spinnerHairChoice.setAdapter(dataAdapter);


        /*
        initiation of the radio group which contains three radio buttons.
         */
        //finds correct radio group
        RadioGroup radioGroup = findViewById(R.id.radioGroup);
        radioGroup.clearCheck();
        //sets radio group to listener
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                                                  @Override
                                                  public void onCheckedChanged(RadioGroup radioGroup, int checkedID) {
                                                      //checks if first radio button was checked
                                                      if (checkedID == R.id.hairColor) {
                                                          buttonState = 1;
                                                      }
                                                      if (checkedID == R.id.eyeColor) {
                                                          buttonState = 2;
                                                      }
                                                      if (checkedID == R.id.skinColor) {
                                                          buttonState = 3;
                                                      }
                                                  }
                                              }
        );


    }


    /*
    Listener class for the RED seek bar
     */
    private class redSeekBarListener implements SeekBar.OnSeekBarChangeListener {
        @Override
        public void onProgressChanged(SeekBar redSeekBar, int progress, boolean fromUser) {
            Log.i("progress", "" + progress);
            SeekBarState.getInstance().setRedAdjust(progress);
            Log.i("Delta", "" + SeekBarState.getInstance().getRedAdjust());
            TextView redTextBox = findViewById(R.id.redText4SeekBar);
            redTextBox.setText("Red Adjustment:  " + SeekBarState.getInstance().getRedAdjust());
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {
        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {
            if (buttonState == 1) {
                //changes hair color

                int red = Color.red(myFace.hairColor) + SeekBarState.getInstance().getRedAdjust();
                int green = Color.green(myFace.hairColor);
                int blue = Color.blue(myFace.hairColor);
                int outColor = Color.argb(255, red, green, blue);
                myFace.setHairColor(outColor);
            } else if (buttonState == 2) {
                //changes eye color
                int red = Color.red(myFace.eyeColor) + SeekBarState.getInstance().getRedAdjust();
                int green = Color.green(myFace.eyeColor);
                int blue = Color.blue(myFace.eyeColor);
                int outColor = Color.argb(255, red, green, blue);
                myFace.setEyeColor(outColor);
            } else if (buttonState == 3) {
                //changes skin color
                int red = Color.red(myFace.skinColor) + SeekBarState.getInstance().getRedAdjust();
                int green = Color.green(myFace.skinColor);
                int blue = Color.blue(myFace.skinColor);
                int outColor = Color.argb(255, red, green, blue);
                myFace.setSkinColor(outColor);
            }
        }
    }//as progress changes, red color changes


    /*
    Listener class for the BLUE seek bar
     */
    private class blueSeekBarListener implements SeekBar.OnSeekBarChangeListener {
        @Override
        public void onProgressChanged(SeekBar redSeekBar, int progress, boolean fromUser) {
            Log.i("progress", "" + progress);
            SeekBarState.getInstance().setBlueAdjust(progress);
            Log.i("Delta", "" + SeekBarState.getInstance().getBlueAdjust());
            TextView blueTextBox = findViewById(R.id.blueText4SeekBar);
            blueTextBox.setText("Blue Adjustment:  " + SeekBarState.getInstance().getBlueAdjust());
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {
        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {
            if (buttonState == 1) {
                //changes hair color

                int red = Color.red(myFace.hairColor);
                int green = Color.green(myFace.hairColor);
                int blue = Color.blue(myFace.hairColor) + SeekBarState.getInstance().getBlueAdjust();
                int outColor = Color.argb(255, red, green, blue);
                myFace.setHairColor(outColor);
            } else if (buttonState == 2) {
                //changes eye color
                int red = Color.red(myFace.eyeColor);
                int green = Color.green(myFace.eyeColor);
                int blue = Color.blue(myFace.eyeColor) + SeekBarState.getInstance().getBlueAdjust();
                int outColor = Color.argb(255, red, green, blue);
                myFace.setEyeColor(outColor);
            } else if (buttonState == 3) {
                //changes skin color
                int red = Color.red(myFace.skinColor);
                int green = Color.green(myFace.skinColor);
                int blue = Color.blue(myFace.skinColor) + SeekBarState.getInstance().getBlueAdjust();
                int outColor = Color.argb(255, red, green, blue);
                myFace.setSkinColor(outColor);
            }
        }
    }//as progress changes, blue color changes


    /*
    Listener class for the GREEN seek bar
    */
    private class greenSeekBarListener implements SeekBar.OnSeekBarChangeListener {
        @Override
        public void onProgressChanged(SeekBar redSeekBar, int progress, boolean fromUser) {
            Log.i("progress", "" + progress);
            SeekBarState.getInstance().setGreenAdjust(progress);
            Log.i("Delta", "" + SeekBarState.getInstance().getGreenAdjust());
            TextView greenTextBox = findViewById(R.id.greenText4SeekBar);
            greenTextBox.setText("Green Adjustment:  " + SeekBarState.getInstance().getGreenAdjust());

        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {
        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {
            if (buttonState == 1) {
                //changes hair color

                int red = Color.red(myFace.hairColor);
                int green = Color.green(myFace.hairColor) + SeekBarState.getInstance().getGreenAdjust();
                int blue = Color.blue(myFace.hairColor);
                int outColor = Color.argb(255, red, green, blue);
                myFace.setHairColor(outColor);
            } else if (buttonState == 2) {
                //changes eye color
                int red = Color.red(myFace.eyeColor);
                int green = Color.green(myFace.eyeColor) + SeekBarState.getInstance().getGreenAdjust();
                int blue = Color.blue(myFace.eyeColor);
                int outColor = Color.argb(255, red, green, blue);
                myFace.setEyeColor(outColor);
            } else if (buttonState == 3) {
                //changes skin color
                int red = Color.red(myFace.skinColor);
                int green = Color.green(myFace.skinColor) + SeekBarState.getInstance().getGreenAdjust();
                int blue = Color.blue(myFace.skinColor);
                int outColor = Color.argb(255, red, green, blue);
                myFace.setSkinColor(outColor);
            }
        }
    }//as progress changes, green color changes


    /*
    listener class for the random face button. It works when clicked
     */
    public class randomFaceButtonListener implements View.OnClickListener {
        public void onClick(View Button) {
            Face newRandom = (Face) findViewById(R.id.facePicture);
            newRandom.setEyeColor(random());
            newRandom.setHairColor(random());
            newRandom.setSkinColor(random());

            Random rand = new Random();
            int style = rand.nextInt(3);
            newRandom.setHairStyle(style);

        }
        public int random()
        {
            Random rand = new Random();
            int red = rand.nextInt(255);
            int green = rand.nextInt(255);
            int blue = rand.nextInt(255);
            int outColor = Color.argb(255, red, green, blue);
            return outColor;
        }
    }


}


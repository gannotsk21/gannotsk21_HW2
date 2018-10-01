package com.example.polinagannotskaya.hw2;

import android.app.Activity;
import android.view.View;
import android.widget.AdapterView;

import static com.example.polinagannotskaya.hw2.MainActivity.myFace;


/*
Spinner listener class.  When item is selected, it switches the hairstyle to the newly specified one.
 */
    public class SpinnerListener extends Activity implements AdapterView.OnItemSelectedListener {


        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            //int item = parent.getSelectedItemPosition();
            if (parent.getItemAtPosition(position).toString().equals("Hairstyle 1")) {

                myFace.setHairStyle(1);
            } else if (parent.getItemAtPosition(position).toString().equals("Hairstyle 2")) {
                myFace.setHairStyle(2);
            } else if (parent.getItemAtPosition(position).toString().equals("Hairstyle 3")) {
                myFace.setHairStyle(3);
            }
        }

        @Override
        public void onNothingSelected(AdapterView<?> arg0) {
            //nothing happens
        }
    }


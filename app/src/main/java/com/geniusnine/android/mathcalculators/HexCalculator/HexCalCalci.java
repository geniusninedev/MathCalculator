package com.geniusnine.android.mathcalculators.HexCalculator;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.geniusnine.android.mathcalculators.MainActivity;
import com.geniusnine.android.mathcalculators.R;

import java.util.ArrayList;

/**
 * Created by Dev on 12-04-2017.
 */

public class HexCalCalci extends AppCompatActivity {

    Spinner halfLifeSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_half_life_calci);


        halfLifeSpinner = (Spinner) findViewById(R.id.spinnerHalfLife);






        ArrayList area = new ArrayList();
        area.add("Select");
        area.add("Hexadecimal Calculator");
        area.add("Conversion Calculator");


        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, area);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        halfLifeSpinner.setAdapter(dataAdapter);

        halfLifeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {


                if (position == 1) {


                    Intent meanHalfLife = new Intent(getApplicationContext(), HexCalculator.class);
                    finish();
                    startActivity(meanHalfLife);


                }

                if (position == 2) {


                    Intent meanHalfLife = new Intent(getApplicationContext(), ConversionCalculator.class);
                    startActivity(meanHalfLife);
                    finish();


                }


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == android.R.id.home) {
            Intent intent=new Intent(HexCalCalci.this,MainActivity.class);
            //    finish();
            startActivity(intent);


        }


        return super.onOptionsItemSelected(item);
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch(keyCode){
            case KeyEvent.KEYCODE_BACK:

                Intent intent=new Intent(HexCalCalci.this,MainActivity.class);
                finish();
                startActivity(intent);

                return true;
        }
        return super.onKeyDown(keyCode, event);
    }

}



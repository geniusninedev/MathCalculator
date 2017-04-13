package com.geniusnine.android.mathcalculators.RatioCalculator;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.geniusnine.android.mathcalculators.R;

import java.util.ArrayList;

public class RatioScalingCalculator extends AppCompatActivity {
    Spinner areaField;
    TextView textViewResult;
    int ValueOne,ValueTwo;
    double ValueThree;
    EditText editTextFirstScale,editTextSecondScale,editTextThirdScale;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ratio_scaling_calculator);
        getSupportActionBar().setHomeButtonEnabled(true);
        editTextFirstScale=(EditText)findViewById(R.id.editTextFirstScale);
        editTextSecondScale=(EditText)findViewById(R.id.editTextSecondScale);
        editTextThirdScale=(EditText)findViewById(R.id.editTextThirdScale);
        textViewResult=(TextView)findViewById(R.id.textViewResult);
        areaField = (Spinner) findViewById(R.id.spinnerRatioScale);
        ArrayList area = new ArrayList();
        area.add("Shrink");
        area.add("Enlarge");


        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, area);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        areaField.setAdapter(dataAdapter);

        Button calci=(Button)findViewById(R.id.buttonCalci);
        Button reset=(Button)findViewById(R.id.buttonReset);
        calci.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                RatioCalci Calculator = new RatioCalci();


                if(editTextFirstScale.getText().toString().equals("")){
                    editTextFirstScale.setError("Enter The First Value");

                }if(editTextSecondScale.getText().toString().equals("")){
                    editTextSecondScale.setError("Enter The Second Value");

                }
                if(editTextThirdScale.getText().toString().equals("")){
                    editTextThirdScale.setError("Enter The Times Value");

                }
                else {

                    textViewResult.setVisibility(View.VISIBLE);

                    String spinnerArea = areaField.getSelectedItem().toString().trim();

                    InputMethodManager inputManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);


                    if (areaField.getSelectedItem().toString().trim().equals("Shrink")) {

                        ValueOne = Integer.parseInt(editTextFirstScale.getText().toString().trim());
                        ValueThree = Double.parseDouble(editTextThirdScale.getText().toString().trim());
                        ValueTwo = Integer.parseInt(editTextSecondScale.getText().toString().trim());

                        double resultgrossDomesticProductValue = Calculator.calculateShrinkage(ValueOne, ValueThree);

                        double result = Calculator.calculateShrinkageOne(ValueTwo, ValueThree);
                        textViewResult.setText("" + ValueOne + " : "  + ValueTwo + "  Shrink   " + ValueThree + "  times   " + resultgrossDomesticProductValue + " : " + result);

                    } else if (areaField.getSelectedItem().toString().trim().equals("Enlarge")) {

                        ValueOne = Integer.parseInt(editTextFirstScale.getText().toString().trim());
                        ValueThree = Double.parseDouble(editTextThirdScale.getText().toString().trim());
                        ValueTwo = Integer.parseInt(editTextSecondScale.getText().toString().trim());

                        double resultgrossDomesticProductValue = Calculator.calculateEnlarge(ValueOne, ValueThree);

                        double result = Calculator.calculateEnlargeOne(ValueTwo, ValueThree);
                        textViewResult.setText("" + ValueOne + " : " + ValueTwo + "  Enlarge  " + ValueThree + " times  " + resultgrossDomesticProductValue + " : " + result);

                    }


                    /*else{
                        Toast.makeText(getApplicationContext(),"Enter Three Values",Toast.LENGTH_LONG).show();
                    }*/
                }
            }



        });


        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editTextFirstScale.setText("");
                editTextThirdScale.setText("");
                editTextSecondScale.setText("");
                textViewResult.setText("");
                textViewResult.setVisibility(View.INVISIBLE);
            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == android.R.id.home) {
            Intent intent=new Intent(RatioScalingCalculator.this,RatioCalCalci.class);
            finish();
            startActivity(intent);

        }

        return super.onOptionsItemSelected(item);
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch(keyCode){
            case KeyEvent.KEYCODE_BACK:
                Intent intent=new Intent(RatioScalingCalculator.this,RatioCalCalci.class);
                finish();
                startActivity(intent);
                return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        // Checks the orientation of the screen
        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            //Toast.makeText(this, "landscape", Toast.LENGTH_SHORT).show();
        } else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT) {
            //Toast.makeText(this, "portrait", Toast.LENGTH_SHORT).show();
        }
    }
}

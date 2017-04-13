package com.geniusnine.android.mathcalculators.MassCalculator;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.geniusnine.android.mathcalculators.MainActivity;
import com.geniusnine.android.mathcalculators.R;

import java.math.RoundingMode;
import java.text.DecimalFormat;

public class MassCalculator extends AppCompatActivity {

    EditText editTextDensity,editTextVolume;
    TextView textViewDensity,textViewVolume;
    double densityValue,volumeValue;
    TextView textViewResultMass,textViewResulrMassInGram,textViewResulrMassInMiligram,textViewResultMassInTon,textViewResultMassIncarrat;
    TextView textViewResultMassInPound,textViewResultMassIngrain,textViewMass;
    public static final String RESULT_FORMAT = "#.###";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mass_calculator);
        editTextDensity=(EditText)findViewById(R.id.editTextDensity);
        editTextVolume=(EditText)findViewById(R.id.editTextVolume);

        textViewDensity=(TextView)findViewById(R.id.textViewDensity);
        textViewVolume=(TextView)findViewById(R.id.textViewVolume);
        textViewResultMass=(TextView)findViewById(R.id.textViewResulrMass);
        textViewResulrMassInGram=(TextView)findViewById(R.id.textViewResulrMassInGram);
        textViewResulrMassInMiligram=(TextView)findViewById(R.id.textViewResulrMassInMiligram);
        textViewResultMassInTon=(TextView)findViewById(R.id.textViewResultMassInTon);
        textViewResultMassInPound=(TextView)findViewById(R.id.textViewResultMassInPound);
        textViewResultMassIncarrat=(TextView)findViewById(R.id.textViewResultMassIncarrat);
        textViewResultMassIngrain=(TextView)findViewById(R.id.textViewResultMassIngrain);
        textViewMass=(TextView)findViewById(R.id.textViewMass);

        Button calculate=(Button)findViewById(R.id.buttonCalculate);
        Button clear=(Button)findViewById(R.id.buttonClear);
        calculate.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                DensityCalci densityCalci =new DensityCalci();

                InputMethodManager inputManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);

                if(editTextDensity.getText().toString().trim().equals("")){
                    editTextDensity.setError("Enter the Density");

                }
                if(editTextVolume.getText().toString().trim().equals("")){
                    editTextVolume.setError("Enter the Volume");

                }else{
                    densityValue = Double.parseDouble(editTextDensity.getText().toString().trim());
                    volumeValue = Double.parseDouble(editTextVolume.getText().toString().trim());

                    double result = densityCalci.calculateMassfromDensity(densityValue, volumeValue);
                    //    textViewMass.setText(View.VISIBLE);

                    textViewMass.setVisibility(TextView.VISIBLE);
                    textViewResultMass.setVisibility(TextView.VISIBLE);
                    textViewResulrMassInGram.setVisibility(TextView.VISIBLE);
                    textViewResulrMassInMiligram.setVisibility(TextView.VISIBLE);
                    textViewResultMassInTon.setVisibility(TextView.VISIBLE);
                    textViewResultMassInPound.setVisibility(TextView.VISIBLE);
                    textViewResultMassIncarrat.setVisibility(TextView.VISIBLE);


                    textViewResultMass.setText("" + result + " Kilogram");
                    textViewResulrMassInGram.setText("" + result*1000 + " gram");
                    textViewResulrMassInMiligram.setText("" + result*1000000 + "milligram");
                    textViewResultMassInTon.setText("" + result/1000 + " ton");
                    DecimalFormat df = new DecimalFormat(RESULT_FORMAT);
                    df.setRoundingMode(RoundingMode.HALF_UP);
                    textViewResultMassInPound.setText(""+ df.format(result/ 0.45359237 )+ " pound (lb)");
                    textViewResultMassIncarrat.setText(""+ df.format(result/ 0.0002 )+ " carrat");

                    textViewResultMassIngrain.setText(""+ result/ 0.00006479891 + " grain");
                }



            }
        });
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                //textViewMass.setVisibility(TextView.INVISIBLE);
               textViewResultMass.setVisibility(TextView.INVISIBLE);
               textViewResulrMassInGram.setVisibility(TextView.INVISIBLE);
                textViewResulrMassInMiligram.setVisibility(TextView.INVISIBLE);
                 textViewResultMassInTon.setVisibility(TextView.INVISIBLE);
               textViewResultMassInPound.setVisibility(TextView.INVISIBLE);
                textViewResultMassIncarrat.setText("");
                editTextDensity.setText("");
                editTextVolume.setText("");
                textViewResultMassIncarrat.setVisibility(TextView.INVISIBLE);


              /*  textViewResulrMassInGram.setText("");
                textViewResulrMassInMiligram.setText("");
                textViewResultMassInTon.setText("");
                textViewResultMassInPound.setText("");

                textViewResultMassIngrain.setText("");
                textViewMass.setText("");*/


            }
        });
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == android.R.id.home) {
            Intent intent=new Intent(MassCalculator.this,MainActivity.class);
            finish();
            startActivity(intent);


        }


        return super.onOptionsItemSelected(item);
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch(keyCode){
            case KeyEvent.KEYCODE_BACK:

                Intent intent=new Intent(MassCalculator.this,MainActivity.class);
                finish();
                startActivity(intent);

                return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}



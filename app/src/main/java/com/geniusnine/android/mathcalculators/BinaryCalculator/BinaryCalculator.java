package com.geniusnine.android.mathcalculators.BinaryCalculator;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.geniusnine.android.mathcalculators.MainActivity;
import com.geniusnine.android.mathcalculators.R;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

import java.util.ArrayList;

public class BinaryCalculator extends AppCompatActivity {
    EditText valueOne,valueTwo;
    Spinner mathOperations;
    TextView textViewResult,textViewBinaryResult,textViewOctalResult,textViewHexResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_binary_calculator);

        MobileAds.initialize(BinaryCalculator.this, getString(R.string.ads_app_id));
        AdView mAdView = (AdView) findViewById(R.id.adViewbinary);

        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        valueOne=(EditText)findViewById(R.id.editTextValueOne);
        valueTwo=(EditText)findViewById(R.id.editTextValueTwo);

        mathOperations=(Spinner)findViewById(R.id.spinnerOperations);
        textViewResult=(TextView)findViewById(R.id.textViewResult);
        textViewBinaryResult=(TextView)findViewById(R.id.textViewBinaryResult);
        textViewOctalResult=(TextView)findViewById(R.id.textViewOctalResult);
        textViewHexResult=(TextView)findViewById(R.id.textViewHexResult);


     //   oct.setText(String.valueOf(Integer.parseInt(deci,8)));
        Button calculate=(Button)findViewById(R.id.buttonCalculate);
        Button clear=(Button)findViewById(R.id.buttonClear);

        ArrayList sign = new ArrayList();
        sign.add("+");
        sign.add("-");
        sign.add("*");
        sign.add("/");

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, sign);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mathOperations.setAdapter(dataAdapter);

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                InputMethodManager inputManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);

                if (valueOne.getText().toString().trim().equals("")) {
                    valueOne.setError("Enter 1st Value");
                } else if (valueTwo.getText().toString().trim().equals("")) {
                    valueTwo.setError("Enter 2nd Value");
                }
                else{
                    Operations binaryCalculations = new Operations();
                    DecimalToBinary binaryConversion = new DecimalToBinary();



                    textViewBinaryResult.setVisibility(View.VISIBLE);
                    textViewResult.setVisibility(View.VISIBLE);
                    textViewOctalResult.setVisibility(View.VISIBLE);
                    textViewHexResult.setVisibility(View.VISIBLE);

                    final String valueOneValue = valueOne.getText().toString().trim();
                    final String valueTwoValue = valueTwo.getText().toString().trim();


                    if (mathOperations.getSelectedItem().toString().trim().equals("+")) {

                        Double resultgrossDomesticProductValue = Double.valueOf(binaryCalculations.BinarySum(valueOneValue,valueTwoValue));
                        textViewResult.setText("Decimal Value:" + resultgrossDomesticProductValue);

                        Double resultgrossDomesticProductValue1 =binaryConversion.decimalToBinary(resultgrossDomesticProductValue);
                        textViewBinaryResult.setText("Binary Value:" + resultgrossDomesticProductValue1);

                        Double resultgrossDomesticProductValue11 =binaryConversion.dectoOctal(resultgrossDomesticProductValue);
                        textViewOctalResult.setText("Octal Value:" + resultgrossDomesticProductValue11);


                        String resultgrossDomesticProductValueHex =binaryConversion.binaryToHex(resultgrossDomesticProductValue);
                        textViewHexResult.setText("Hexadecimal Value:" + resultgrossDomesticProductValueHex);
/*
                        textViewBinaryResult.setVisibility(View.INVISIBLE);
                        textViewResult.setVisibility(View.INVISIBLE);
                        textViewOctalResult.setVisibility(View.INVISIBLE);
                        textViewHexResult.setVisibility(View.INVISIBLE);*/
                    }else if (mathOperations.getSelectedItem().toString().trim().equals("-")) {

                        Double resultgrossDomesticProductValue = Double.valueOf(binaryCalculations.GetBinaryDiff(valueOneValue,valueTwoValue));
                        textViewResult.setText("Decimal Value:" + resultgrossDomesticProductValue);


                        Double resultgrossDomesticProductValue1 =binaryConversion.decimalToBinary(resultgrossDomesticProductValue);
                        textViewBinaryResult.setText("Binary Value:" + resultgrossDomesticProductValue1);

                        Double resultgrossDomesticProductValue11 =binaryConversion.dectoOctal(resultgrossDomesticProductValue);
                        textViewOctalResult.setText("Octal Value:" + resultgrossDomesticProductValue11);

                        String resultgrossDomesticProductValueHex =binaryConversion.binaryToHex(resultgrossDomesticProductValue);
                        textViewHexResult.setText("Hexadecimal Value:" + resultgrossDomesticProductValueHex);


                    }
                    else if (mathOperations.getSelectedItem().toString().trim().equals("*")) {

                        Double resultgrossDomesticProductValue = Double.valueOf(binaryCalculations.GetBinaryProd(valueOneValue,valueTwoValue));
                        textViewResult.setText("Decimal Value:" + resultgrossDomesticProductValue);

                        Double resultgrossDomesticProductValue1 =binaryConversion.decimalToBinary(resultgrossDomesticProductValue);
                        textViewBinaryResult.setText("Binary Value:" + resultgrossDomesticProductValue1);

                        Double resultgrossDomesticProductValue11 =binaryConversion.dectoOctal(resultgrossDomesticProductValue);
                        textViewOctalResult.setText("Octal Value:" + resultgrossDomesticProductValue11);


                        String resultgrossDomesticProductValueHex =binaryConversion.binaryToHex(resultgrossDomesticProductValue);
                        textViewHexResult.setText("Hexadecimal Value:" + resultgrossDomesticProductValueHex);

                    }  else if (mathOperations.getSelectedItem().toString().trim().equals("/")) {

                        Double resultgrossDomesticProductValue = Double.valueOf(binaryCalculations.GetBinaryQuotient(valueOneValue,valueTwoValue));
                        textViewResult.setText("Decimal Value:" + resultgrossDomesticProductValue);

                        Double resultgrossDomesticProductValue1 =binaryConversion.decimalToBinary(resultgrossDomesticProductValue);
                        textViewBinaryResult.setText("Binary Value:" + resultgrossDomesticProductValue1);

                        Double resultgrossDomesticProductValue11 =binaryConversion.dectoOctal(resultgrossDomesticProductValue);
                        textViewOctalResult.setText("Octal Value:" + resultgrossDomesticProductValue11);

                        String resultgrossDomesticProductValueHex =binaryConversion.binaryToHex(resultgrossDomesticProductValue);
                        textViewHexResult.setText("Hexadecimal Value:" + resultgrossDomesticProductValueHex);
                    }
                }

            }
        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                 //textViewBinaryResult.setVisibility(View.VISIBLE);

             textViewBinaryResult.setText("");
                textViewResult.setText("");
                textViewOctalResult.setText("");
              textViewHexResult.setText("");

                valueOne.setText("");
                valueTwo.setText("");
                textViewBinaryResult.setVisibility(View.GONE);


                textViewResult.setVisibility(View.GONE);
                textViewOctalResult.setVisibility(View.GONE);
                textViewHexResult.setVisibility(View.GONE);


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
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == android.R.id.home) {
            Intent intent=new Intent(BinaryCalculator.this,MainActivity.class);
            finish();
            startActivity(intent);


        }


        return super.onOptionsItemSelected(item);
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch(keyCode){
            case KeyEvent.KEYCODE_BACK:

                Intent intent=new Intent(BinaryCalculator.this,MainActivity.class);
                finish();
                startActivity(intent);

                return true;
        }
        return super.onKeyDown(keyCode, event);
    }

}




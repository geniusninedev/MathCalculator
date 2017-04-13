package com.geniusnine.android.mathcalculators.HexCalculator;

import android.content.Context;
import android.content.Intent;
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

import com.geniusnine.android.mathcalculators.MainActivity;
import com.geniusnine.android.mathcalculators.R;

import java.util.ArrayList;

public class HexCalculator extends AppCompatActivity {
    EditText valueOne,valueTwo,editTextAnswer;
    Spinner mathOperations;
    EditText hexValue,decimalValue;
    TextView textViewResult,textViewBinaryResult,textViewHexadecimalResult,textViewOctalResult,textViewHexValue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hex_calculator);

        valueOne=(EditText)findViewById(R.id.editTextValueOne);
        valueTwo=(EditText)findViewById(R.id.editTextValueTwo);


        mathOperations=(Spinner)findViewById(R.id.spinnerOperations);
        textViewResult=(TextView)findViewById(R.id.textViewResult);
        textViewBinaryResult=(TextView)findViewById(R.id.textViewBinaryResult);
        textViewHexadecimalResult=(TextView)findViewById(R.id.textViewHexResult);
        textViewOctalResult=(TextView)findViewById(R.id.textViewOctalResult);

        //  textViewBinaryResult=(TextView)findViewById(R.id.textViewBinaryResult);
        //  textViewHexValue=(TextView)findViewById(R.id.textViewHexResult);
        //  textViewDecimalValue=(TextView)findViewById(R.id.textViewDecimal);*/

        Button calculate=(Button)findViewById(R.id.buttonCalculate);
        Button clear=(Button)findViewById(R.id.buttonClear);
     /*  Button calci=(Button)findViewById(R.id.buttonCalci);
        Button clearbutton=(Button)findViewById(R.id.clearButton);
        Button calciDecimal=(Button)findViewById(R.id.buttonCalc);
        Button clearDecimal=(Button)findViewById(R.id.clear);
*/
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
                }
                else if (valueTwo.getText().toString().trim().equals("")) {
                    valueTwo.setError("Enter 2nd Value");
                }

                else {
                    HexCalci hexCalculations = new HexCalci();

                    textViewHexadecimalResult.setVisibility(View.VISIBLE);
                    textViewResult.setVisibility(View.VISIBLE);
                    textViewBinaryResult.setVisibility(View.VISIBLE);
                    textViewOctalResult.setVisibility(View.VISIBLE);

                    final String valueOneValue = valueOne.getText().toString().trim();
                    final String valueTwoValue = valueTwo.getText().toString().trim();

                    if (mathOperations.getSelectedItem().toString().trim().equals("+")) {

                        Double resultgrossDomesticProductValue = Double.valueOf(hexCalculations.HexSum(valueOneValue,valueTwoValue));
                        textViewResult.setText("Decimal Value: " + resultgrossDomesticProductValue);

                        String resultgrossDomesticProductValueHex =hexCalculations.binaryToHex(resultgrossDomesticProductValue);
                        textViewHexadecimalResult.setText("Hexadecimal Value:" + resultgrossDomesticProductValueHex);

                        Double resultgrossDomesticProductValueBinary = Double.valueOf(hexCalculations.hexToBinary(resultgrossDomesticProductValue));
                        textViewBinaryResult.setText("Binary Value: " + resultgrossDomesticProductValueBinary);

                        Double resultgrossDomesticProductValueOctal = Double.valueOf(hexCalculations.dectoOctal(resultgrossDomesticProductValue));
                        textViewOctalResult.setText("Octal Value: " + resultgrossDomesticProductValueOctal);


                    }else if (mathOperations.getSelectedItem().toString().trim().equals("-")) {

                        Double resultgrossDomesticProductValue = Double.valueOf(hexCalculations.HexDiff(valueOneValue,valueTwoValue));
                        textViewResult.setText("Decimal Value: " + resultgrossDomesticProductValue);

                        String resultgrossDomesticProductValueHex =hexCalculations.binaryToHex(resultgrossDomesticProductValue);
                        textViewHexadecimalResult.setText("Hexadecimal Value:" + resultgrossDomesticProductValueHex);

                        Double resultgrossDomesticProductValueBinary = Double.valueOf(hexCalculations.hexToBinary(resultgrossDomesticProductValue));
                        textViewBinaryResult.setText("Binary Value: " + resultgrossDomesticProductValueBinary);

                        Double resultgrossDomesticProductValueOctal = Double.valueOf(hexCalculations.dectoOctal(resultgrossDomesticProductValue));
                        textViewOctalResult.setText("Octal Value: " + resultgrossDomesticProductValueOctal);

                    }
                    else if (mathOperations.getSelectedItem().toString().trim().equals("*")) {

                        Double resultgrossDomesticProductValue = Double.valueOf(hexCalculations.HexProd(valueOneValue,valueTwoValue));
                        textViewResult.setText("Decimal Value: " + resultgrossDomesticProductValue);

                        String resultgrossDomesticProductValueHex =hexCalculations.binaryToHex(resultgrossDomesticProductValue);
                        textViewHexadecimalResult.setText("Hexadecimal Value:" + resultgrossDomesticProductValueHex);

                        Double resultgrossDomesticProductValueBinary = Double.valueOf(hexCalculations.hexToBinary(resultgrossDomesticProductValue));
                        textViewBinaryResult.setText("Binary Value: " + resultgrossDomesticProductValueBinary);

                        Double resultgrossDomesticProductValueOctal = Double.valueOf(hexCalculations.dectoOctal(resultgrossDomesticProductValue));
                        textViewOctalResult.setText("Octal Value: " + resultgrossDomesticProductValueOctal);

                    } else if (mathOperations.getSelectedItem().toString().trim().equals("/")) {

                        Double resultgrossDomesticProductValue = Double.valueOf(hexCalculations.HexDiv(valueOneValue,valueTwoValue));
                        textViewResult.setText("Decimal Value: " + resultgrossDomesticProductValue);

                        String resultgrossDomesticProductValueHex =hexCalculations.binaryToHex(resultgrossDomesticProductValue);
                        textViewHexadecimalResult.setText("Hexadecimal Value:" + resultgrossDomesticProductValueHex);

                        Double resultgrossDomesticProductValueBinary = Double.valueOf(hexCalculations.hexToBinary(resultgrossDomesticProductValue));
                        textViewBinaryResult.setText("Binary Value: " + resultgrossDomesticProductValueBinary);


                        Double resultgrossDomesticProductValueOctal = Double.valueOf(hexCalculations.dectoOctal(resultgrossDomesticProductValue));
                        textViewOctalResult.setText("Octal Value: " + resultgrossDomesticProductValueOctal);

                    }

                    else{

                    }

                }
            }
        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                textViewBinaryResult.setText("");
                textViewResult.setText("");
                textViewOctalResult.setText("");
                textViewHexadecimalResult.setText("");

                valueOne.setText("");
                valueTwo.setText("");

                textViewBinaryResult.setVisibility(View.GONE);


                textViewResult.setVisibility(View.GONE);
                textViewOctalResult.setVisibility(View.GONE);
                textViewHexadecimalResult.setVisibility(View.GONE);


                // textViewBinaryResult.setText("");
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
            Intent intent=new Intent(HexCalculator.this,MainActivity.class);
            finish();
            startActivity(intent);


        }


        return super.onOptionsItemSelected(item);
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch(keyCode){
            case KeyEvent.KEYCODE_BACK:

                Intent intent=new Intent(HexCalculator.this,MainActivity.class);
                finish();
                startActivity(intent);

                return true;
        }
        return super.onKeyDown(keyCode, event);
    }

}


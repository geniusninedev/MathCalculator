package com.geniusnine.android.mathcalculators.FractionCalculator;

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

import com.geniusnine.android.mathcalculators.R;

import java.util.ArrayList;

public class FractionCalculator extends AppCompatActivity {
    EditText firstValue,secondValue,thirdValue,fourthValue;
    TextView textViewFraction,textViewFractionOne;
    double valueOne,valueTwo,valueThree,valueFour;

    EditText editTextResult;
    Spinner mathOperation;
    TextView textViewResult,textViewfractionResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fraction_calculator);

        firstValue=(EditText)findViewById(R.id.editTextFirstValue);
        secondValue=(EditText)findViewById(R.id.editTextSecondValue);
        thirdValue=(EditText)findViewById(R.id.editTextThirdValue);
        fourthValue=(EditText)findViewById(R.id.editTextFourthValue);
        editTextResult=(EditText)findViewById(R.id.editTextResult);



        textViewFraction=(TextView)findViewById(R.id.textViewEqual);
        textViewFractionOne=(TextView)findViewById(R.id.textViewFractionOne);
        textViewResult=(TextView)findViewById(R.id.textViewResult);
        textViewfractionResult=(TextView)findViewById(R.id.textViewtextResult);


        mathOperation=(Spinner)findViewById(R.id.spinnerFraction);

        ArrayList area = new ArrayList();
        area.add("+");
        area.add("-");
        area.add("*");
        area.add("/");


        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, area);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mathOperation.setAdapter(dataAdapter);


        Button calculate=(Button)findViewById(R.id.buttonCalculate);
        Button clear=(Button)findViewById(R.id.buttonClear);

/*

        Button calci=(Button)findViewById(R.id.buttonCalci);
        Button reset=(Button)findViewById(R.id.buttonReset);
*/


        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FractionCalci fractionCalci=new FractionCalci();
                InputMethodManager inputManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
                String spinnerArea = mathOperation.getSelectedItem().toString().trim();

                if (firstValue.getText().toString().trim().equals("")) {
                    firstValue.setError("Enter 1st Value");
                }  if (secondValue.getText().toString().trim().equals("")) {
                    secondValue.setError("Enter 2nd Value");

                } if (thirdValue.getText().toString().trim().equals("")) {
                    thirdValue.setError("Enter 3rd Value");
                }  if (fourthValue.getText().toString().trim().equals("")) {
                    fourthValue.setError("Enter 4th Value");

                }
                else {
                    if (mathOperation.getSelectedItem().toString().trim().equals("+")) {

                        valueOne = (Double.parseDouble(firstValue.getText().toString().trim()));
                        valueTwo = (Double.parseDouble(secondValue.getText().toString().trim()));
                        valueThree = (Double.parseDouble(thirdValue.getText().toString().trim()));
                        valueFour = (Double.parseDouble(fourthValue.getText().toString().trim()));

                        int result = (int) fractionCalci.CalculateAdditionFraction(valueOne, valueTwo, valueThree, valueFour);
                        int result1 = (int) fractionCalci.CalculateAdditionFractionOne(valueTwo, valueFour);
                        editTextResult.setText("" + result);
                        textViewResult.setText("" + result1);
                        textViewfractionResult.setVisibility(View.VISIBLE);
                        textViewfractionResult.setText("Fraction:"+result+"/"+result1);
                    } else if (mathOperation.getSelectedItem().toString().trim().equals("-")) {

                        valueOne = (Double.parseDouble(firstValue.getText().toString().trim()));
                        valueTwo = (Double.parseDouble(secondValue.getText().toString().trim()));
                        valueThree = (Double.parseDouble(thirdValue.getText().toString().trim()));
                        valueFour = (Double.parseDouble(fourthValue.getText().toString().trim()));

                        int result = (int) fractionCalci.CalculateSubtractionFraction(valueOne, valueTwo, valueThree, valueFour);
                        int result1 = (int) fractionCalci.CalculateSubtractionFractionOne(valueTwo, valueFour);
                        textViewfractionResult.setVisibility(View.VISIBLE);
                        editTextResult.setText("" + result);
                        textViewResult.setText("" + result1);

                        textViewfractionResult.setText("Fraction:"+result+"/"+result1);
                    } else if (mathOperation.getSelectedItem().toString().trim().equals("*")) {
                        textViewfractionResult.setVisibility(View.VISIBLE);
                        valueOne = (Double.parseDouble(firstValue.getText().toString().trim()));
                        valueTwo = (Double.parseDouble(secondValue.getText().toString().trim()));
                        valueThree = (Double.parseDouble(thirdValue.getText().toString().trim()));
                        valueFour = (Double.parseDouble(fourthValue.getText().toString().trim()));

                        int result = (int) fractionCalci.CalculateMultiplicationFraction(valueOne, valueThree);
                        int result1 = (int) fractionCalci.CalculateMultiplicationFractionOne(valueTwo, valueFour);

                        editTextResult.setText("" + result);
                        textViewResult.setText("" + result1);

                        textViewfractionResult.setText("Fraction:"+result+"/"+result1);
                    } else if (mathOperation.getSelectedItem().toString().trim().equals("/")) {
                        textViewfractionResult.setVisibility(View.VISIBLE);
                        valueOne = (Double.parseDouble(firstValue.getText().toString().trim()));
                        valueTwo = (Double.parseDouble(secondValue.getText().toString().trim()));
                        valueThree = (Double.parseDouble(thirdValue.getText().toString().trim()));
                        valueFour = (Double.parseDouble(fourthValue.getText().toString().trim()));

                        int result = (int) fractionCalci.CalculateDivisionFraction(valueOne, valueFour);
                        int result1 = (int) fractionCalci.CalculateDivisionFractionOne(valueTwo, valueThree);

                        editTextResult.setText("" + result);
                        textViewResult.setText("" + result1);

                        textViewfractionResult.setText("Fraction:"+result+"/"+result1);
                    }
                }
            }
        });
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firstValue.setText("");
                secondValue.setText("");
                thirdValue.setText("");
                fourthValue.setText("");
                textViewfractionResult.setText("");
                editTextResult.setText("");
                textViewResult.setText("");
                textViewfractionResult.setVisibility(View.GONE);


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
            Intent intent=new Intent(FractionCalculator.this,FractionCalCalci.class);
            finish();
            startActivity(intent);


        }


        return super.onOptionsItemSelected(item);
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch(keyCode){
            case KeyEvent.KEYCODE_BACK:

                Intent intent=new Intent(FractionCalculator.this,FractionCalCalci.class);
                finish();
                startActivity(intent);

                return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}




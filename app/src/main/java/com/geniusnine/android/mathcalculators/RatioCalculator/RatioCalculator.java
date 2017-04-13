package com.geniusnine.android.mathcalculators.RatioCalculator;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.geniusnine.android.mathcalculators.R;

public class RatioCalculator extends AppCompatActivity {
    EditText editTextFirstValue,editTextSecondValue,editTextThirdValue,editTextFourthValue;
    double firstValue,secondValue,thirdValue,fourthValue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ratio_calculator);

        editTextFirstValue=(EditText)findViewById(R.id.editTextFirstValue);
        editTextSecondValue=(EditText)findViewById(R.id.editTextSecondValue);
        editTextThirdValue=(EditText)findViewById(R.id.editTextThirdValue);
        editTextFourthValue=(EditText)findViewById(R.id.editTextFourthValue);




        Button calculate=(Button)findViewById(R.id.buttonCalculate);
        Button clear=(Button)findViewById(R.id.buttonClear);




        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RatioCalci ratioCalci=new RatioCalci();
                InputMethodManager inputManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
                if (TextUtils.isEmpty(editTextFirstValue.getText().toString().trim())&&TextUtils.isEmpty(editTextSecondValue.getText().toString().trim())
                        &&TextUtils.isEmpty(editTextThirdValue.getText().toString().trim())
                        &&TextUtils.isEmpty(editTextFourthValue.getText().toString().trim())) {

                    Toast.makeText(RatioCalculator.this,"Please provide any Three values",Toast.LENGTH_SHORT).show();

                    return;
                }

                if (TextUtils.isEmpty(editTextFirstValue.getText().toString().trim())&&TextUtils.isEmpty(editTextSecondValue.getText().toString().trim())){
                    Toast.makeText(RatioCalculator.this,"Please provide any Three values",Toast.LENGTH_SHORT).show();

                    return;
                }

                if (TextUtils.isEmpty(editTextSecondValue.getText().toString().trim())&&TextUtils.isEmpty(editTextThirdValue.getText().toString().trim())) {
                    Toast.makeText(RatioCalculator.this,"Please provide any Three values",Toast.LENGTH_SHORT).show();

                    return;
                }
                if (TextUtils.isEmpty(editTextThirdValue.getText().toString().trim())&&TextUtils.isEmpty(editTextFourthValue.getText().toString().trim())) {
                    Toast.makeText(RatioCalculator.this,"Please provide any Three values",Toast.LENGTH_SHORT).show();

                    return;
                }

                if (TextUtils.isEmpty(editTextFirstValue.getText().toString().trim())&&TextUtils.isEmpty(editTextThirdValue.getText().toString().trim())) {
                    Toast.makeText(RatioCalculator.this,"Please provide any Three values",Toast.LENGTH_SHORT).show();

                    return;
                }
                if (TextUtils.isEmpty(editTextFirstValue.getText().toString().trim())&&TextUtils.isEmpty(editTextFourthValue.getText().toString().trim())) {
                    Toast.makeText(RatioCalculator.this,"Please provide any Three values",Toast.LENGTH_SHORT).show();

                    return;
                }

                if (TextUtils.isEmpty(editTextSecondValue.getText().toString().trim())&&TextUtils.isEmpty(editTextFourthValue.getText().toString().trim())) {
                    Toast.makeText(RatioCalculator.this,"Please provide any Three values",Toast.LENGTH_SHORT).show();

                    return;
                }
                if (TextUtils.isEmpty(editTextFirstValue.getText().toString().trim())) {
                    Toast.makeText(RatioCalculator.this,"Please provide any Three values",Toast.LENGTH_SHORT).show();

                    secondValue = Double.parseDouble(editTextSecondValue.getText().toString().trim());
                    thirdValue = Double.parseDouble(editTextThirdValue.getText().toString().trim());
                    fourthValue = Double.parseDouble(editTextFourthValue.getText().toString().trim());

                    int result = (int) ratioCalci.calculateFirstValueFrom(secondValue,thirdValue,fourthValue);
                    editTextFirstValue.setText(String.valueOf(result));

                    return;
                }
                if (TextUtils.isEmpty(editTextSecondValue.getText().toString().trim())) {
                    Toast.makeText(RatioCalculator.this,"Please provide any Three values",Toast.LENGTH_SHORT).show();

                    firstValue = Double.parseDouble(editTextFirstValue.getText().toString().trim());
                    thirdValue = Double.parseDouble(editTextThirdValue.getText().toString().trim());
                    fourthValue = Double.parseDouble(editTextFourthValue.getText().toString().trim());


                    int result = (int) ratioCalci.calculateSecondValueFrom(firstValue,thirdValue,fourthValue);
                    editTextSecondValue.setText(String.valueOf(result));
                    return;
                } if (TextUtils.isEmpty(editTextThirdValue.getText().toString().trim())) {
                    Toast.makeText(RatioCalculator.this,"Please provide any Three values",Toast.LENGTH_SHORT).show();
                    firstValue = Double.parseDouble(editTextFirstValue.getText().toString().trim());
                    secondValue = Double.parseDouble(editTextSecondValue.getText().toString().trim());
                    fourthValue = Double.parseDouble(editTextFourthValue.getText().toString().trim());


                    int result = (int) ratioCalci.calculateThirdValueFrom(firstValue,secondValue,fourthValue);
                    editTextThirdValue.setText(String.valueOf(result));

                    return;
                } if (TextUtils.isEmpty(editTextFourthValue.getText().toString().trim())) {
                    Toast.makeText(RatioCalculator.this,"Please provide any Three values",Toast.LENGTH_SHORT).show();

                    firstValue = Double.parseDouble(editTextFirstValue.getText().toString().trim());
                    secondValue = Double.parseDouble(editTextSecondValue.getText().toString().trim());
                    thirdValue = Double.parseDouble(editTextThirdValue.getText().toString().trim());


                    int result = (int) ratioCalci.calculateFourthValueFrom(firstValue,secondValue,thirdValue);
                    editTextFourthValue.setText(String.valueOf(result));
                    return;
                }



            }
        });
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editTextFirstValue.setText("");
                editTextSecondValue.setText("");
                editTextThirdValue.setText("");
                editTextFourthValue.setText("");
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == android.R.id.home) {
            Intent intent=new Intent(RatioCalculator.this,RatioCalCalci.class);
            finish();
            startActivity(intent);


        }


        return super.onOptionsItemSelected(item);
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch(keyCode){
            case KeyEvent.KEYCODE_BACK:

                Intent intent=new Intent(RatioCalculator.this,RatioCalCalci.class);
                finish();
                startActivity(intent);

                return true;
        }
        return super.onKeyDown(keyCode, event);
    }

}

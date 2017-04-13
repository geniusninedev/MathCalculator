package com.geniusnine.android.mathcalculators.FractionCalculator;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;

import com.geniusnine.android.mathcalculators.R;

public class FractiontoDecimalCalci extends AppCompatActivity {

    EditText editTextFirst,editTextSecond;
    EditText answereditText;
    double editTextFirstValue,editTextSecondValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fractionto_decimal_calci);

        editTextFirst=(EditText)findViewById(R.id.editTextFirst);
        editTextSecond=(EditText)findViewById(R.id.editTextSecond);
        answereditText=(EditText)findViewById(R.id.editTextResult);


        Button calculate =(Button)findViewById(R.id.buttonCal);
        final Button reset =(Button)findViewById(R.id.clearButton);

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FractionCalci fractionCalci=new FractionCalci();
                InputMethodManager inputManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
                if(editTextFirst.getText().toString().trim().equals("")){
                    editTextFirst.setError("Enter The 1st Fraction");
                }

                if(editTextSecond.getText().toString().trim().equals("")){
                    editTextSecond.setError("Enter The 2nd Fraction");
                }
                else{

                    editTextFirstValue=(Double.parseDouble(editTextFirst.getText().toString().trim()));
                    editTextSecondValue=(Double.parseDouble(editTextSecond.getText().toString().trim()));

                    double  result=fractionCalci.FractionToDecimal(editTextFirstValue,editTextSecondValue);
                   answereditText.setText(""+result);
                }
            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editTextFirst.setText("");
                editTextSecond.setText("");
                answereditText.setText("");
            }
        });

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == android.R.id.home) {
            Intent intent=new Intent(FractiontoDecimalCalci.this,FractionCalCalci.class);
            finish();
            startActivity(intent);

        }

        return super.onOptionsItemSelected(item);
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch(keyCode){
            case KeyEvent.KEYCODE_BACK:
                Intent intent=new Intent(FractiontoDecimalCalci.this,FractionCalCalci.class);
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

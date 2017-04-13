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
import android.widget.TextView;

import com.geniusnine.android.mathcalculators.R;

public class DecimaltoFractionCalci extends AppCompatActivity {
    EditText decimalNumber,editTextAnswer;
    TextView textViewAnswer,textViewAnswerDecimal;
    double DecimalNumberValue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_decimalto_fraction_calci);



        decimalNumber=(EditText)findViewById(R.id.editTextdecimalNumber);
        editTextAnswer=(EditText)findViewById(R.id.editTextAnswer);


        textViewAnswer=(TextView)findViewById(R.id.textViewAnswer);
        textViewAnswerDecimal=(TextView)findViewById(R.id.textViewResultDecimal);

        Button caculate=(Button)findViewById(R.id.calculateButton);
        Button reset=(Button)findViewById(R.id.resetButton);


        caculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FractionCalci fractionCalci=new FractionCalci();
                InputMethodManager inputManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
                if(decimalNumber.getText().toString().trim().equals("")){
                    decimalNumber.setError("Enter The Decimal Number");
                }

                else{

                    DecimalNumberValue=(Double.parseDouble(decimalNumber.getText().toString().trim()));

                    int result=fractionCalci.DecimalToFractionCalculate(DecimalNumberValue);
                    editTextAnswer.setText(""+result);
                    textViewAnswer.setText("1");
                    textViewAnswerDecimal.setVisibility(View.VISIBLE);
                    textViewAnswerDecimal.setText("Fraction:"+result+"/"+1);
                }
            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                decimalNumber.setText("");
                editTextAnswer.setText("");
                textViewAnswer.setText("");
                textViewAnswerDecimal.setVisibility(View.GONE);
            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == android.R.id.home) {
            Intent intent=new Intent(DecimaltoFractionCalci.this,FractionCalCalci.class);
            finish();
            startActivity(intent);

        }

        return super.onOptionsItemSelected(item);
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch(keyCode){
            case KeyEvent.KEYCODE_BACK:
                Intent intent=new Intent(DecimaltoFractionCalci.this,FractionCalCalci.class);
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

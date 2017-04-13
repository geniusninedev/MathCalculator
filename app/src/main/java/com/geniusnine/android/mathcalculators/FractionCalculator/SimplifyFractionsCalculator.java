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

public class SimplifyFractionsCalculator extends AppCompatActivity {
    TextView textViewAnswerSecond,textViewAnswerResult;
    EditText editTextAnswerFirst;
    EditText editTextSimpleValueOne,editTextSimpleValueTwo,editTextSimpleValueThree;
    double simpleValueOne,simpleValueTwo,simpleValueThree;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simplify_fractions_calculator);

        editTextSimpleValueOne=(EditText)findViewById(R.id.editTextSimplifyOne);
        editTextSimpleValueTwo=(EditText)findViewById(R.id.editTextSimplifyTwo);
        editTextSimpleValueThree=(EditText)findViewById(R.id.editTextSimplifyThird);
        editTextAnswerFirst=(EditText)findViewById(R.id.editTextAnswerFirst);

        textViewAnswerSecond=(TextView)findViewById(R.id.textViewAnswerSecond);
        textViewAnswerResult=(TextView)findViewById(R.id.textViewAnswerResult);

        Button calci=(Button)findViewById(R.id.buttonCalci);
        Button reset=(Button)findViewById(R.id.buttonReset);

        calci.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FractionCalci fractionCalci=new FractionCalci();
                InputMethodManager inputManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
                if(editTextSimpleValueOne.getText().toString().trim().equals("")){
                    editTextSimpleValueOne.setError("Enter The 1st Value");
                }
                if(editTextSimpleValueTwo.getText().toString().trim().equals("")){
                    editTextSimpleValueTwo.setError("Enter The 2nd Value");
                }
                if(editTextSimpleValueThree.getText().toString().trim().equals("")){
                    editTextSimpleValueThree.setError("Enter The 3rd Value");
                }
          else {

                    textViewAnswerSecond.setVisibility(View.INVISIBLE);
                    simpleValueOne = (Double.parseDouble(editTextSimpleValueOne.getText().toString().trim()));
                    simpleValueTwo = (Double.parseDouble(editTextSimpleValueTwo.getText().toString().trim()));
                    simpleValueThree = (Double.parseDouble(editTextSimpleValueThree.getText().toString().trim()));

                    int result = (int) fractionCalci.CalculateSimplifyFraction(simpleValueOne, simpleValueTwo, simpleValueThree);
                    int result1 = (int) fractionCalci.CalculateSimplifyFractionOne(simpleValueThree);
                    editTextAnswerFirst.setText("" + result);
                    textViewAnswerSecond.setText("" + result1);
                    textViewAnswerResult.setVisibility(View.VISIBLE);
                    textViewAnswerResult.setText("Fraction:"+result+"/"+result1);
                }
            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editTextSimpleValueOne.setText("");
                editTextSimpleValueTwo.setText("");
                editTextSimpleValueThree.setText("");
                editTextAnswerFirst.setText("");
                textViewAnswerSecond.setText("");
                textViewAnswerSecond.setVisibility(View.INVISIBLE);
                textViewAnswerResult.setVisibility(View.GONE);
            }
        });


    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == android.R.id.home) {
            Intent intent=new Intent(SimplifyFractionsCalculator.this,FractionCalCalci.class);
            finish();
            startActivity(intent);

        }

        return super.onOptionsItemSelected(item);
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch(keyCode){
            case KeyEvent.KEYCODE_BACK:
                Intent intent=new Intent(SimplifyFractionsCalculator.this,FractionCalCalci.class);
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


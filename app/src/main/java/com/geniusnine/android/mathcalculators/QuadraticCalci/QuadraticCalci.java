package com.geniusnine.android.mathcalculators.QuadraticCalci;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.geniusnine.android.mathcalculators.HalfLifeCalci.HalfLifeCalci;
import com.geniusnine.android.mathcalculators.MainActivity;
import com.geniusnine.android.mathcalculators.R;

public class QuadraticCalci extends AppCompatActivity {
    TextView valueOne,valueTwo,valueThree;
    EditText editTextValueOne,editTextValueTwo,editTextValueThree;
    TextView textViewResult,textViewValue;
    int valueOfFirst,valueOfSecond,valueOfThird;
    TextView rootOne,rootTwo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quadratic_calci);

        valueOne=(TextView)findViewById(R.id.textViewFirst);
        valueTwo=(TextView)findViewById(R.id.textViewSecond);
        valueThree=(TextView)findViewById(R.id.textViewThird);
        textViewValue=(TextView)findViewById(R.id.textViewValue);
        rootOne=(TextView)findViewById(R.id.textViewRoot1);
        rootTwo=(TextView)findViewById(R.id.textViewRoot2);

        editTextValueOne=(EditText) findViewById(R.id.editTextFirst);
        editTextValueTwo=(EditText)findViewById(R.id.editTextSecond);
        editTextValueThree=(EditText)findViewById(R.id.editTextThird);

        textViewResult=(TextView)findViewById(R.id.textViewResult);

        Button calculate=(Button)findViewById(R.id.buttonCalculate);
        Button clear=(Button)findViewById(R.id.buttonReset);
        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                QuadraticFormulaCalci quadraticFormulaCalci=new QuadraticFormulaCalci();
                InputMethodManager inputManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
                textViewValue.setVisibility(View.INVISIBLE);
                textViewResult.setVisibility(View.INVISIBLE);
                rootOne.setVisibility(View.INVISIBLE);
                rootTwo.setVisibility(View.INVISIBLE);

                if(editTextValueOne.getText().toString().trim().equals("")){
                    editTextValueOne.setError("Enter Coefficient Of a");
                }
                if(editTextValueTwo.getText().toString().trim().equals("")){
                    editTextValueTwo.setError("Enter Coefficient Of b");
                }
                if(editTextValueThree.getText().toString().trim().equals("")){
                    editTextValueThree.setError("Enter Coefficient Of c");
                }
                else {

                    textViewValue.setVisibility(View.VISIBLE);
                    textViewResult.setVisibility(View.VISIBLE);
                    rootOne.setVisibility(View.VISIBLE);
                    rootTwo.setVisibility(View.VISIBLE);

                    valueOfFirst = Integer.parseInt(editTextValueOne.getText().toString().trim());
                    valueOfSecond = Integer.parseInt(editTextValueTwo.getText().toString().trim());
                    valueOfThird = Integer.parseInt(editTextValueThree.getText().toString().trim());

                    double result = quadraticFormulaCalci.QuadraticFormula(valueOfFirst, valueOfSecond, valueOfThird);
                    textViewValue.setText("Given quadratic equation:  " + "\n"+ "("+valueOfFirst+")" + "x^2 +  " +"("+valueOfSecond+")" + "x +  " +"("+ valueOfThird+")");
                    textViewResult.setText("Roots Of =   " + result);

                    double rootValueResult = quadraticFormulaCalci.RootsEquation(valueOfFirst, valueOfSecond, valueOfThird);
                    rootOne.setText("1st Root :  " + rootValueResult);


                    double rootValueTwoResult = quadraticFormulaCalci.RootsEquationTwo(valueOfFirst, valueOfSecond, valueOfThird);
                    rootTwo.setText("2nd Root :  " + rootValueTwoResult);
                    if (result <= 0) {
                        Toast.makeText(getApplicationContext(), "Roots Are Imaginary", Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(getApplicationContext(), "Roots Are Real", Toast.LENGTH_LONG).show();
                    }
                }

            }
        });
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editTextValueOne.setText("");
                editTextValueTwo.setText("");
                editTextValueThree.setText("");
                textViewValue.setText("");
                textViewResult.setText("");
                rootOne.setText("");
                rootTwo.setText("");
                textViewValue.setVisibility(View.INVISIBLE);
                textViewResult.setVisibility(View.INVISIBLE);
                rootOne.setVisibility(View.INVISIBLE);
                rootTwo.setVisibility(View.INVISIBLE);

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
            Intent intent=new Intent(QuadraticCalci.this,MainActivity.class);
            finish();
            startActivity(intent);


        }


        return super.onOptionsItemSelected(item);
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch(keyCode){
            case KeyEvent.KEYCODE_BACK:

                Intent intent=new Intent(QuadraticCalci.this,MainActivity.class);
                finish();
                startActivity(intent);

                return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}

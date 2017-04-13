package com.geniusnine.android.mathcalculators.RootCalculator;

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

public class SquareRootCalculator extends AppCompatActivity {
    TextView textViewSquareRoot;
    EditText editTextSquareRoot;
    int squareRootNumber;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_square_root_calculator);

        textViewSquareRoot=(TextView)findViewById(R.id.textViewSquareRoot);
        editTextSquareRoot=(EditText) findViewById(R.id.editTextSquareRoot);

        Button calculate=(Button)findViewById(R.id.buttonCalculate);
        Button clear=(Button)findViewById(R.id.buttonReset);


        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                RootCalci squareRootCalculator=new RootCalci();
                InputMethodManager inputManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
                if(editTextSquareRoot.getText().toString().trim().equals("")){
                    editTextSquareRoot.setError("Enter The Number");
                }
                else {
                    squareRootNumber = Integer.parseInt(editTextSquareRoot.getText().toString().trim());
                    double result = squareRootCalculator.squareRoot((double) squareRootNumber);
                    // sqrRootResult.setText("Given quadratic equation:"+valueOfFirst+"x^2 +  "+ valueOfSecond+ "x +  "+valueOfThird);
                    editTextSquareRoot.setText("" + result);
                }
            }
        });
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editTextSquareRoot.setText("");
            }
        });

    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == android.R.id.home) {
            Intent intent=new Intent(SquareRootCalculator.this,RootCalCalci.class);
            finish();
            startActivity(intent);

        }

        return super.onOptionsItemSelected(item);
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch(keyCode){
            case KeyEvent.KEYCODE_BACK:
                Intent intent=new Intent(SquareRootCalculator.this,RootCalCalci.class);
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

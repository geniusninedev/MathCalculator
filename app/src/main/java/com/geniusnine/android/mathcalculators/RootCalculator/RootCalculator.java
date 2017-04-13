package com.geniusnine.android.mathcalculators.RootCalculator;

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

import com.geniusnine.android.mathcalculators.R;

public class RootCalculator extends AppCompatActivity {

    double generalRootNumber;
    int  generalRoot;

    TextView textViewGeneralRoot,textViewGeneralRootNumber,textViewResult;
    EditText editTextGeneralRoot,editTextGeneralRootNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_root_calculator);

        textViewGeneralRoot=(TextView)findViewById(R.id.textViewGeneralRoot);
        textViewGeneralRootNumber=(TextView)findViewById(R.id.textViewRootNumber);
        textViewResult=(TextView)findViewById(R.id.textViewResult);


        editTextGeneralRoot=(EditText) findViewById(R.id.editTextRoot);
        editTextGeneralRootNumber=(EditText) findViewById(R.id.editTextRootNumber);




        Button buttonCalci=(Button)findViewById(R.id.CalciButton);
        Button buttonClear=(Button)findViewById(R.id.ClearButton);



        buttonCalci.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RootCalci squareRootCalculator=new RootCalci();
                InputMethodManager inputManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
                if(editTextGeneralRoot.getText().toString().trim().equals("")){
                    editTextGeneralRoot.setError("Enter The Root ");
                }
                if(editTextGeneralRootNumber.getText().toString().trim().equals("")){
                    editTextGeneralRootNumber.setError("Enter The Number");
                }
                else {
                    textViewResult.setVisibility(View.VISIBLE);
                    generalRoot = Integer.parseInt(editTextGeneralRoot.getText().toString().trim());
                    generalRootNumber=Double.parseDouble(editTextGeneralRootNumber.getText().toString().trim());

                    double result = squareRootCalculator.nthroot( generalRoot,generalRootNumber);
                    // sqrRootResult.setText("Given quadratic equation:"+valueOfFirst+"x^2 +  "+ valueOfSecond+ "x +  "+valueOfThird);
                    textViewResult.setText(generalRoot  + " Root Of "+  generalRootNumber +"  is:   "+ result);
                }

            }


        });
        buttonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editTextGeneralRoot.setText("");
                editTextGeneralRootNumber.setText("");
                textViewResult.setText("");
                textViewResult.setVisibility(View.GONE);

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
            Intent intent=new Intent(RootCalculator.this,RootCalCalci.class);
            finish();
            startActivity(intent);


        }


        return super.onOptionsItemSelected(item);
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch(keyCode){
            case KeyEvent.KEYCODE_BACK:

                Intent intent=new Intent(RootCalculator.this,RootCalCalci.class);
                finish();
                startActivity(intent);

                return true;
        }
        return super.onKeyDown(keyCode, event);
    }

}


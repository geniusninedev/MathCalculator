package com.geniusnine.android.mathcalculators.ExponentCalci;

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

import com.geniusnine.android.mathcalculators.DensityCalculator.DensityCalculator;
import com.geniusnine.android.mathcalculators.MainActivity;
import com.geniusnine.android.mathcalculators.R;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class ExponentCalculator extends AppCompatActivity {
    EditText editTextBase,editTextExponent,editTextResult;
    TextView textViewExponent,textViewEqual;
    double baseValue;
    int exponentValue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exponent_calculator);
        MobileAds.initialize(ExponentCalculator.this, getString(R.string.ads_app_id));
        AdView mAdView = (AdView) findViewById(R.id.adViewexponent);

        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        editTextBase=(EditText)findViewById(R.id.editTextBase);
        editTextExponent=(EditText)findViewById(R.id.editTextExponent);
       // editTextResult=(EditText)findViewById(R.id.editTextResult);

        textViewExponent=(TextView)findViewById(R.id.textViewExponent);
        textViewEqual=(TextView)findViewById(R.id.textViewresult);

        Button calculate=(Button)findViewById(R.id.buttonCalculate);
        Button clear=(Button)findViewById(R.id.buttonClear);
        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ExponentCalci exponentCalci=new ExponentCalci();

                if(editTextBase.getText().toString().trim().equals("")){
                    editTextBase.setError("Enter The Base Value ");
                }
                if(editTextExponent.getText().toString().trim().equals("")){
                    editTextExponent.setError("Enter The Exponent Value");
                }
                else{
                    baseValue = Double.parseDouble(editTextBase.getText().toString().trim());
                    exponentValue=Integer.parseInt(editTextExponent.getText().toString().trim());

                    textViewEqual.setVisibility(View.VISIBLE);

                    double result = exponentCalci.mathPower( baseValue,exponentValue);
                    textViewEqual.setText(baseValue+" exponent "+exponentValue+" = "+result);


                    // sqrRootResult.setText("Given quadratic equation:"+valueOfFirst+"x^2 +  "+ valueOfSecond+ "x +  "+valueOfThird);
                    // textViewResult.setText(generalRoot  + " Root Of "+  generalRootNumber +"  is:   "+ result);
                }

                InputMethodManager inputManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
            }


        });
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editTextBase.setText("");
                editTextExponent.setText("");
                textViewEqual.setText("");
                textViewEqual.setVisibility(View.INVISIBLE);
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
            Intent intent=new Intent(ExponentCalculator.this,MainActivity.class);
            finish();
            startActivity(intent);


        }


        return super.onOptionsItemSelected(item);
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch(keyCode){
            case KeyEvent.KEYCODE_BACK:

                Intent intent=new Intent(ExponentCalculator.this,MainActivity.class);
                finish();
                startActivity(intent);

                return true;
        }
        return super.onKeyDown(keyCode, event);
    }

}


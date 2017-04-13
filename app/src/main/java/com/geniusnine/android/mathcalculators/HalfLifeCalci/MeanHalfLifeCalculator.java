package com.geniusnine.android.mathcalculators.HalfLifeCalci;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.geniusnine.android.mathcalculators.R;

public class MeanHalfLifeCalculator extends AppCompatActivity {

    TextView textViewHalf,textViewMeanLife,textViewDecayConstant;
    EditText editTextHalf,editTextMeanLife,editTextDecayConstant;
    double HalfValue,MeanLifeValue,DecayConstantValue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mean_half_life_calculator);
        getSupportActionBar().setHomeButtonEnabled(true);

        textViewHalf=(TextView)findViewById(R.id.textViewHalf);
        textViewMeanLife=(TextView)findViewById(R.id.textViewMeanLife);
        textViewDecayConstant=(TextView)findViewById(R.id.textViewDecay);


        editTextHalf=(EditText) findViewById(R.id.editTextHalf);
        editTextMeanLife=(EditText) findViewById(R.id.editTextMeanLife);
        editTextDecayConstant=(EditText) findViewById(R.id.editTextDecay);


        Button buttonCalculate=(Button)findViewById(R.id.buttonCalculateOne);
        Button buttonClear=(Button)findViewById(R.id.buttonClearSecond);


        buttonCalculate.setOnClickListener(new View.OnClickListener() {




            @Override
            public void onClick(View v) {

                MeanHalfLifeCalci MeanHalfLifeCalci=new MeanHalfLifeCalci();

                InputMethodManager inputManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
                //Toast.makeText(getApplicationContext(),"Enter Any One Value",Toast.LENGTH_LONG).show();

                if (TextUtils.isEmpty(editTextHalf.getText().toString().trim())&&TextUtils.isEmpty(editTextMeanLife.getText().toString().trim())
                        &&TextUtils.isEmpty(editTextDecayConstant.getText().toString().trim())) {

                    Toast.makeText(MeanHalfLifeCalculator.this,"Please provide any One value",Toast.LENGTH_SHORT).show();

                    return;
                }

                if (TextUtils.isEmpty(editTextHalf.getText().toString().trim())&&TextUtils.isEmpty(editTextMeanLife.getText().toString().trim())){
                    Toast.makeText(MeanHalfLifeCalculator.this,"Please provide any One values",Toast.LENGTH_SHORT).show();
                    DecayConstantValue = Double.parseDouble(editTextDecayConstant.getText().toString().trim());


                    double resultDecay = MeanHalfLifeCalci.calculatehalfTimeFromDecayConstant(DecayConstantValue);
                    double resultDecayConstant = MeanHalfLifeCalci.calculateMeanLifeTimeFromDecayConstant(DecayConstantValue);

                    editTextHalf.setText(String.valueOf(resultDecay));
                    editTextMeanLife.setText(String.valueOf(resultDecayConstant));
                    return;
                }
                if (TextUtils.isEmpty(editTextMeanLife.getText().toString().trim())&&TextUtils.isEmpty(editTextDecayConstant.getText().toString().trim())){
                    Toast.makeText(MeanHalfLifeCalculator.this,"Please provide any One values",Toast.LENGTH_SHORT).show();
                    HalfValue = Double.parseDouble(editTextHalf.getText().toString().trim());


                    double resultDecay = MeanHalfLifeCalci.calculateMeanLifeTimeFromhalfTime(HalfValue);
                    double resultDecayConstant = MeanHalfLifeCalci.calculateDecayconstantFromhalfTime(HalfValue);

                    editTextMeanLife.setText(String.valueOf(resultDecay));
                    editTextDecayConstant.setText(String.valueOf(resultDecayConstant));
                    return;
                }
                if (TextUtils.isEmpty(editTextHalf.getText().toString().trim())&&TextUtils.isEmpty(editTextDecayConstant.getText().toString().trim())){
                    Toast.makeText(MeanHalfLifeCalculator.this,"Please provide any One values",Toast.LENGTH_SHORT).show();
                    MeanLifeValue = Double.parseDouble(editTextMeanLife.getText().toString().trim());


                    double resultDecay = MeanHalfLifeCalci.calculatehalfTimeFromMeanLifeTime(MeanLifeValue);
                    double resultDecayConstant = MeanHalfLifeCalci.calculateDecayconstantFromMeanLifeTime(MeanLifeValue);

                    editTextHalf.setText(String.valueOf(resultDecay));
                    editTextDecayConstant.setText(String.valueOf(resultDecayConstant));
                    return;
                }

    if(!editTextHalf.getText().toString().trim().equals("") && !editTextDecayConstant.getText().toString().trim().equals("") &&
            !editTextMeanLife.getText().toString().trim().equals("") ){
                  Toast.makeText(MeanHalfLifeCalculator.this,"Please provide any One values",Toast.LENGTH_SHORT).show();
            return;
        }

                if(!editTextHalf.getText().toString().trim().equals("") && !editTextDecayConstant.getText().toString().trim().equals("") &&
                        editTextMeanLife.getText().toString().trim().equals("") ){
                    Toast.makeText(MeanHalfLifeCalculator.this,"Please provide any One values",Toast.LENGTH_SHORT).show();
                    return;
                }

                if(editTextHalf.getText().toString().trim().equals("") && !editTextDecayConstant.getText().toString().trim().equals("") &&
                        !editTextMeanLife.getText().toString().trim().equals("") ){
                    Toast.makeText(MeanHalfLifeCalculator.this,"Please provide any One values",Toast.LENGTH_SHORT).show();
                    return;
                }  if(!editTextHalf.getText().toString().trim().equals("") && editTextDecayConstant.getText().toString().trim().equals("") &&
                        !editTextMeanLife.getText().toString().trim().equals("") ){
                    Toast.makeText(MeanHalfLifeCalculator.this,"Please provide any One values",Toast.LENGTH_SHORT).show();
                    return;
                }






            }
        });

        buttonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editTextHalf.setText("");
                editTextDecayConstant.setText("");
                editTextMeanLife.setText("");
            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == android.R.id.home) {
            Intent intent=new Intent(MeanHalfLifeCalculator.this,HalfLifeCalci.class);
            finish();
            startActivity(intent);

        }

        return super.onOptionsItemSelected(item);
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch(keyCode){
            case KeyEvent.KEYCODE_BACK:

                Intent intent=new Intent(MeanHalfLifeCalculator.this,HalfLifeCalci.class);
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

package com.geniusnine.android.mathcalculators.LogCalculator;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.geniusnine.android.mathcalculators.MainActivity;
import com.geniusnine.android.mathcalculators.R;

import java.util.ArrayList;

public class LogCalculator extends AppCompatActivity {
    EditText editTextAnswer,editTextExponent;
    TextView textViewLog,textViewEqual;
    Spinner spinnerBase;
    double Exponent,BaseValue;
    EditText ExponentOther,BaseOther;
    double ExponentValue,Base;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_calculator);


        editTextAnswer=(EditText)findViewById(R.id.editTextAnswer);
        editTextExponent=(EditText)findViewById(R.id.editTextExponentValue);

        ExponentOther=(EditText)findViewById(R.id.editTextExponentOther);
        BaseOther=(EditText)findViewById(R.id.editTextBaseOther);

        textViewLog=(TextView)findViewById(R.id.textViewLog);
        textViewEqual=(TextView)findViewById(R.id.textViewEqual);

        spinnerBase=(Spinner)findViewById(R.id.spinnerBase);


        Button calculate=(Button)findViewById(R.id.buttonCalculate);
        final Button clear=(Button)findViewById(R.id.buttonClear);

        ArrayList area = new ArrayList();
        area.add("2");
        area.add("10");
        area.add("e");
        area.add("Other");

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, area);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinnerBase.setAdapter(dataAdapter);

     spinnerBase.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
         @Override
         public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
             if (position==0){

                 editTextExponent.setVisibility(View.VISIBLE);

                 ExponentOther.setVisibility(View.INVISIBLE);
                 BaseOther.setVisibility(View.INVISIBLE);


             }
             if (position==1){
                 editTextExponent.setVisibility(View.VISIBLE);

                 ExponentOther.setVisibility(View.INVISIBLE);
                 BaseOther.setVisibility(View.INVISIBLE);


             }
             if (position==2){
                 editTextExponent.setVisibility(View.VISIBLE);

                 ExponentOther.setVisibility(View.INVISIBLE);
                 BaseOther.setVisibility(View.INVISIBLE);


             }

             if (position==3){
                 editTextExponent.setVisibility(View.GONE);

                 ExponentOther.setVisibility(View.VISIBLE);
                 BaseOther.setVisibility(View.VISIBLE);


             }
         }

         @Override
         public void onNothingSelected(AdapterView<?> parent) {

         }
     });
        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LogCalci logCalculator = new LogCalci();

                InputMethodManager inputManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);




                if (spinnerBase.getSelectedItem().toString().trim().equals("e")) {
                  /*  ExponentOther.setVisibility(View.INVISIBLE);
                    editTextAnswer.setVisibility(View.VISIBLE);
                    BaseOther.setVisibility(View.INVISIBLE);*/


                    if (TextUtils.isEmpty(editTextExponent.getText().toString().trim())) {
                        editTextExponent.setError("Enter Exponent");
                        return;
                    }

                        Exponent = (Double.parseDouble(editTextExponent.getText().toString().trim()));
                        //  baseValue = (Double.parseDouble(editTextBaseValue.getText().toString().trim()));
                        double result = logCalculator.loge(Exponent);
                        editTextAnswer.setText("" + result);


                }
                if (spinnerBase.getSelectedItem().toString().trim().equals("2")) {

                    if (TextUtils.isEmpty(editTextExponent.getText().toString().trim())) {
                        editTextExponent.setError("Enter Exponent");
                        return;
                    }

                        Exponent = (Double.parseDouble(editTextExponent.getText().toString().trim()));
                        // baseValue = (Double.parseDouble(editTextBaseValue.getText().toString().trim()));

                        double result = logCalculator.log2(Exponent);
                        editTextAnswer.setText("" + result);

                }


                if (spinnerBase.getSelectedItem().toString().trim().equals("10")) {

                    if (TextUtils.isEmpty(editTextExponent.getText().toString().trim())) {
                        editTextExponent.setError("Enter Exponent");
                        return;
                    }


                        Exponent = (Double.parseDouble(editTextExponent.getText().toString().trim()));
                        // baseValue = (Double.parseDouble(editTextBaseValue.getText().toString().trim()));

                        double result = logCalculator.log10(Exponent);
                        editTextAnswer.setText("" + result);

                }

                if (spinnerBase.getSelectedItem().toString().trim().equals("Other")) {


                    try {



                        editTextAnswer.setVisibility(View.INVISIBLE);
                        ExponentValue = Double.parseDouble(ExponentOther.getText().toString().trim());

                        BaseValue = Double.parseDouble(BaseOther.getText().toString().trim());


                        double resultOther = logCalculator.logb(ExponentValue, BaseValue);

                        editTextAnswer.setVisibility(View.VISIBLE);
                        editTextAnswer.setText("" + resultOther);

                        editTextExponent.setText("");
                        //spinnerBase.getSelectedItem().toString().trim().equals("");


                    } catch (NumberFormatException e) {


                    }

                }


            }






        });
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (spinnerBase.getSelectedItem().toString().trim().equals("e")) {
                    editTextExponent.setText("");
                    editTextAnswer.setText("");
                }

                if (spinnerBase.getSelectedItem().toString().trim().equals("10")) {
                    editTextExponent.setText("");
                    editTextAnswer.setText("");
                }

                if (spinnerBase.getSelectedItem().toString().trim().equals("2")) {
                    editTextExponent.setText("");
                    editTextAnswer.setText("");
                }
                if (spinnerBase.getSelectedItem().toString().trim().equals("Other")) {

                    ExponentOther.setText("");
                    BaseOther.setText("");
                   /* editTextExponent.setVisibility(View.VISIBLE);
                    ExponentOther.setVisibility(View.VISIBLE);
                    BaseOther.setVisibility(View.VISIBLE);*/
                    editTextAnswer.setText("");
                }





                //  editTextExponent.setVisibility(View.VISIBLE);
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
            Intent intent=new Intent(LogCalculator.this,MainActivity.class);
            finish();
            startActivity(intent);


        }


        return super.onOptionsItemSelected(item);
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch(keyCode){
            case KeyEvent.KEYCODE_BACK:

                Intent intent=new Intent(LogCalculator.this,MainActivity.class);
                finish();
                startActivity(intent);

                return true;
        }
        return super.onKeyDown(keyCode, event);
    }

}




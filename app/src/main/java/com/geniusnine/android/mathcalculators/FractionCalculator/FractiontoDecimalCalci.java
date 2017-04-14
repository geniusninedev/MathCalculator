package com.geniusnine.android.mathcalculators.FractionCalculator;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;

import com.geniusnine.android.mathcalculators.R;

public class FractiontoDecimalCalci extends android.support.v4.app.Fragment{

    EditText editTextFirst,editTextSecond;
    EditText answereditText;
    double editTextFirstValue,editTextSecondValue;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.activity_fractionto_decimal_calci, container, false);


        editTextFirst=(EditText)view.findViewById(R.id.editTextFirst);
        editTextSecond=(EditText)view.findViewById(R.id.editTextSecond);
        answereditText=(EditText)view.findViewById(R.id.editTextResult);


        Button calculate =(Button)view.findViewById(R.id.buttonCal);
        final Button reset =(Button)view.findViewById(R.id.clearButton);

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FractionCalci fractionCalci=new FractionCalci();
                hideKeyboard();

                if(editTextFirst.getText().toString().trim().equals("")){
                    editTextFirst.setError("Enter The 1st Fraction");
                }

                if(editTextSecond.getText().toString().trim().equals("")){
                    editTextSecond.setError("Enter The 2nd Fraction");
                }
                else{
                    answereditText.setVisibility(View.INVISIBLE);
                    editTextFirstValue=(Double.parseDouble(editTextFirst.getText().toString().trim()));
                    editTextSecondValue=(Double.parseDouble(editTextSecond.getText().toString().trim()));

                    double  result=fractionCalci.FractionToDecimal(editTextFirstValue,editTextSecondValue);
                   answereditText.setText(""+result);
                    answereditText.setVisibility(View.VISIBLE);
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
return  view;
    }

    public void hideKeyboard() {
        InputMethodManager inputMethodManager = (InputMethodManager) getActivity()
                .getSystemService(android.content.Context.INPUT_METHOD_SERVICE);

        inputMethodManager.hideSoftInputFromWindow(
                getActivity().getCurrentFocus()
                        .getWindowToken(), 0);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == android.R.id.home) {
            Intent intent=new Intent(getActivity(),FractionCalCalci.class);
           // finish();
            startActivity(intent);

        }

        return super.onOptionsItemSelected(item);
    }
   /* @Override
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
*/
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

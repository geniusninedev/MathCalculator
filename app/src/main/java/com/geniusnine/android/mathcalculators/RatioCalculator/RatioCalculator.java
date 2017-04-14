package com.geniusnine.android.mathcalculators.RatioCalculator;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.geniusnine.android.mathcalculators.R;

public class RatioCalculator extends android.support.v4.app.Fragment {
    EditText editTextFirstValue,editTextSecondValue,editTextThirdValue,editTextFourthValue;
    double firstValue,secondValue,thirdValue,fourthValue;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.activity_ratio_calculator, container, false);


        editTextFirstValue=(EditText)view.findViewById(R.id.editTextFirstValue);
        editTextSecondValue=(EditText)view.findViewById(R.id.editTextSecondValue);
        editTextThirdValue=(EditText)view.findViewById(R.id.editTextThirdValue);
        editTextFourthValue=(EditText)view.findViewById(R.id.editTextFourthValue);




        Button calculate=(Button)view.findViewById(R.id.buttonCalculate);
        Button clear=(Button)view.findViewById(R.id.buttonClear);




        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RatioCalci ratioCalci=new RatioCalci();

                hideKeyboard();
                if (TextUtils.isEmpty(editTextFirstValue.getText().toString().trim())&&TextUtils.isEmpty(editTextSecondValue.getText().toString().trim())
                        &&TextUtils.isEmpty(editTextThirdValue.getText().toString().trim())
                        &&TextUtils.isEmpty(editTextFourthValue.getText().toString().trim())) {

                    Toast.makeText(getActivity(),"Please provide any Three values",Toast.LENGTH_SHORT).show();

                    return;
                }

                if (TextUtils.isEmpty(editTextFirstValue.getText().toString().trim())&&TextUtils.isEmpty(editTextSecondValue.getText().toString().trim())){
                    Toast.makeText(getActivity(),"Please provide any Three values",Toast.LENGTH_SHORT).show();

                    return;
                }

                if (TextUtils.isEmpty(editTextSecondValue.getText().toString().trim())&&TextUtils.isEmpty(editTextThirdValue.getText().toString().trim())) {
                    Toast.makeText(getActivity(),"Please provide any Three values",Toast.LENGTH_SHORT).show();

                    return;
                }
                if (TextUtils.isEmpty(editTextThirdValue.getText().toString().trim())&&TextUtils.isEmpty(editTextFourthValue.getText().toString().trim())) {
                    Toast.makeText(getActivity(),"Please provide any Three values",Toast.LENGTH_SHORT).show();

                    return;
                }

                if (TextUtils.isEmpty(editTextFirstValue.getText().toString().trim())&&TextUtils.isEmpty(editTextThirdValue.getText().toString().trim())) {
                    Toast.makeText(getActivity(),"Please provide any Three values",Toast.LENGTH_SHORT).show();

                    return;
                }
                if (TextUtils.isEmpty(editTextFirstValue.getText().toString().trim())&&TextUtils.isEmpty(editTextFourthValue.getText().toString().trim())) {
                    Toast.makeText(getActivity(),"Please provide any Three values",Toast.LENGTH_SHORT).show();

                    return;
                }

                if (TextUtils.isEmpty(editTextSecondValue.getText().toString().trim())&&TextUtils.isEmpty(editTextFourthValue.getText().toString().trim())) {
                    Toast.makeText(getActivity(),"Please provide any Three values",Toast.LENGTH_SHORT).show();

                    return;
                }
                if (TextUtils.isEmpty(editTextFirstValue.getText().toString().trim())) {
                    Toast.makeText(getActivity(),"Please provide any Three values",Toast.LENGTH_SHORT).show();

                    secondValue = Double.parseDouble(editTextSecondValue.getText().toString().trim());
                    thirdValue = Double.parseDouble(editTextThirdValue.getText().toString().trim());
                    fourthValue = Double.parseDouble(editTextFourthValue.getText().toString().trim());

                    int result = (int) ratioCalci.calculateFirstValueFrom(secondValue,thirdValue,fourthValue);
                    editTextFirstValue.setText(String.valueOf(result));

                    return;
                }
                if (TextUtils.isEmpty(editTextSecondValue.getText().toString().trim())) {
                    Toast.makeText(getActivity(),"Please provide any Three values",Toast.LENGTH_SHORT).show();

                    firstValue = Double.parseDouble(editTextFirstValue.getText().toString().trim());
                    thirdValue = Double.parseDouble(editTextThirdValue.getText().toString().trim());
                    fourthValue = Double.parseDouble(editTextFourthValue.getText().toString().trim());


                    int result = (int) ratioCalci.calculateSecondValueFrom(firstValue,thirdValue,fourthValue);
                    editTextSecondValue.setText(String.valueOf(result));
                    return;
                } if (TextUtils.isEmpty(editTextThirdValue.getText().toString().trim())) {
                    Toast.makeText(getActivity(),"Please provide any Three values",Toast.LENGTH_SHORT).show();
                    firstValue = Double.parseDouble(editTextFirstValue.getText().toString().trim());
                    secondValue = Double.parseDouble(editTextSecondValue.getText().toString().trim());
                    fourthValue = Double.parseDouble(editTextFourthValue.getText().toString().trim());


                    int result = (int) ratioCalci.calculateThirdValueFrom(firstValue,secondValue,fourthValue);
                    editTextThirdValue.setText(String.valueOf(result));

                    return;
                } if (TextUtils.isEmpty(editTextFourthValue.getText().toString().trim())) {
                    Toast.makeText(getActivity(),"Please provide any Three values",Toast.LENGTH_SHORT).show();

                    firstValue = Double.parseDouble(editTextFirstValue.getText().toString().trim());
                    secondValue = Double.parseDouble(editTextSecondValue.getText().toString().trim());
                    thirdValue = Double.parseDouble(editTextThirdValue.getText().toString().trim());


                    int result = (int) ratioCalci.calculateFourthValueFrom(firstValue,secondValue,thirdValue);
                    editTextFourthValue.setText(String.valueOf(result));
                    return;
                }



            }
        });
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editTextFirstValue.setText("");
                editTextSecondValue.setText("");
                editTextThirdValue.setText("");
                editTextFourthValue.setText("");
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

        //noinspection SimplifiableIfStatement
        if (id == android.R.id.home) {
            Intent intent=new Intent(getActivity(),RatioCalCalci.class);
            //finish();
            startActivity(intent);


        }


        return super.onOptionsItemSelected(item);
    }
  /*  @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch(keyCode){
            case KeyEvent.KEYCODE_BACK:

                Intent intent=new Intent(getActivity(),RatioCalCalci.class);
               // finish();
                startActivity(intent);

                return true;
        }
        return super.onKeyDown(keyCode, event);
    }*/

}

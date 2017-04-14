package com.geniusnine.android.mathcalculators.HalfLifeCalci;

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
import android.widget.TextView;
import android.widget.Toast;

import com.geniusnine.android.mathcalculators.R;

import static com.facebook.FacebookSdk.getApplicationContext;

/**
 * Created by Dev on 12-04-2017.
 */

public class HalfLifeCalculatorCalci extends android.support.v4.app.Fragment {

    TextView textViewQuantity,textViewInitial,textViewTime,textViewHalfLife;
    EditText editTextQuantity,editTextInitial,editTextTime,editTextHalfLife;
    double QuantityValue,InitialValue,TimeValue,HalfLifeValue;




    halfLifeCalculator HalfLifeCalci;
    MeanHalfLifeCalci MeanHalfLifeCalci;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.half_life, container, false);



        textViewQuantity = (TextView)view. findViewById(R.id.textViewQuantity);
        textViewInitial = (TextView)view. findViewById(R.id.textViewInitial);

        textViewTime = (TextView)view. findViewById(R.id.textViewTime);
        textViewHalfLife = (TextView)view. findViewById(R.id.textViewHalfLife);


        editTextQuantity = (EditText)view. findViewById(R.id.editTextQuantity);
        editTextInitial = (EditText)view. findViewById(R.id.editTextInitial);
        editTextTime = (EditText)view. findViewById(R.id.editTextTime);
        editTextHalfLife = (EditText) view.findViewById(R.id.editTextHalfLife);

        Button calculate = (Button)view. findViewById(R.id.buttonCalculate);
        Button clear = (Button) view.findViewById(R.id.buttonClear);


        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                halfLifeCalculator HalfLifeCalci = new halfLifeCalculator();


                hideKeyboard();

                Toast.makeText(getApplicationContext(), "Enter Any Three Values", Toast.LENGTH_LONG).show();

                if (TextUtils.isEmpty(editTextQuantity.getText().toString().trim()) && TextUtils.isEmpty(editTextInitial.getText().toString().trim())
                        && TextUtils.isEmpty(editTextTime.getText().toString().trim())
                        && TextUtils.isEmpty(editTextHalfLife.getText().toString().trim())) {

                    Toast.makeText(getActivity(), "Please provide any Three values", Toast.LENGTH_SHORT).show();

                    return;
                }
                if (TextUtils.isEmpty(editTextQuantity.getText().toString().trim()) && TextUtils.isEmpty(editTextInitial.getText().toString().trim())) {
                    Toast.makeText(getActivity(), "Please provide any Three values", Toast.LENGTH_SHORT).show();

                    return;
                }

                if (TextUtils.isEmpty(editTextInitial.getText().toString().trim()) && TextUtils.isEmpty(editTextTime.getText().toString().trim())) {
                    Toast.makeText(getActivity(), "Please provide any Three values", Toast.LENGTH_SHORT).show();

                    return;
                }
                if (TextUtils.isEmpty(editTextTime.getText().toString().trim()) && TextUtils.isEmpty(editTextHalfLife.getText().toString().trim())) {
                    Toast.makeText(getActivity(), "Please provide any Three values", Toast.LENGTH_SHORT).show();

                    return;
                }

                if (TextUtils.isEmpty(editTextQuantity.getText().toString().trim()) && TextUtils.isEmpty(editTextTime.getText().toString().trim())) {
                    Toast.makeText(getActivity(), "Please provide any Three values", Toast.LENGTH_SHORT).show();

                    return;
                }
                if (TextUtils.isEmpty(editTextQuantity.getText().toString().trim()) && TextUtils.isEmpty(editTextHalfLife.getText().toString().trim())) {
                    Toast.makeText(getActivity(), "Please provide any Three values", Toast.LENGTH_SHORT).show();

                    return;
                }

                if (TextUtils.isEmpty(editTextInitial.getText().toString().trim()) && TextUtils.isEmpty(editTextHalfLife.getText().toString().trim())) {
                    Toast.makeText(getActivity(), "Please provide any Three values", Toast.LENGTH_SHORT).show();

                    return;
                }

                if (TextUtils.isEmpty(editTextQuantity.getText().toString().trim())) {
                    Toast.makeText(getActivity(), "Please provide any Three values", Toast.LENGTH_SHORT).show();
                    InitialValue = Double.parseDouble(editTextInitial.getText().toString().trim());
                    TimeValue = Double.parseDouble(editTextTime.getText().toString().trim());
                    HalfLifeValue = Double.parseDouble(editTextHalfLife.getText().toString().trim());


                    double result = HalfLifeCalci.calculateQuantityRemainsFromInitial(InitialValue, TimeValue, HalfLifeValue);
                    editTextQuantity.setText(String.valueOf(result));
/*
                    if(editTextInitial.getText().toString().trim().equals("")){
                        editTextInitial.setError("Enter Initial Quantity");
                    }
                    if(editTextTime.getText().toString().trim().equals("")){
                        editTextTime.setError("Enter Time");
                    }
                    if(editTextHalfLife.getText().toString().trim().equals("")){
                        editTextHalfLife.setError("Enter Half Life");
                    }*/
                 /*   else {*/

/*
                    }*/
                }


                if (TextUtils.isEmpty(editTextInitial.getText().toString().trim())) {
                    Toast.makeText(getActivity(), "Please provide any Three values", Toast.LENGTH_SHORT).show();
                    QuantityValue = Double.parseDouble(editTextQuantity.getText().toString().trim());
                    TimeValue = Double.parseDouble(editTextTime.getText().toString().trim());
                    HalfLifeValue = Double.parseDouble(editTextHalfLife.getText().toString().trim());


                    double result = HalfLifeCalci.calculateInitialQuantityFromQuantityRemains(QuantityValue, TimeValue, HalfLifeValue);
                    editTextInitial.setText(String.valueOf(result));

                }

                if (TextUtils.isEmpty(editTextHalfLife.getText().toString().trim())) {

                    Toast.makeText(getActivity(), "Please provide any Three values", Toast.LENGTH_SHORT).show();

                    QuantityValue = Double.parseDouble(editTextQuantity.getText().toString().trim());
                    TimeValue = Double.parseDouble(editTextTime.getText().toString().trim());
                    InitialValue = Double.parseDouble(editTextInitial.getText().toString().trim());

                    double result = HalfLifeCalci.calculateTimeHalfFromInitial(QuantityValue, InitialValue, TimeValue);
                    editTextHalfLife.setText(String.valueOf(result));
                }

                if (TextUtils.isEmpty(editTextTime.getText().toString().trim())) {

                    Toast.makeText(getActivity(), "Please provide any Three values", Toast.LENGTH_SHORT).show();

                    QuantityValue = Double.parseDouble(editTextQuantity.getText().toString().trim());
                    HalfLifeValue = Double.parseDouble(editTextHalfLife.getText().toString().trim());

                    InitialValue = Double.parseDouble(editTextInitial.getText().toString().trim());


                    double result = HalfLifeCalci.calculateTimeFromQuantity(HalfLifeValue, QuantityValue, InitialValue);
                    editTextTime.setText(String.valueOf(result));
                }


            }
        });
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editTextQuantity.setText("");
                editTextInitial.setText("");
                editTextTime.setText("");
                editTextHalfLife.setText("");
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
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == android.R.id.home) {
            Intent intent=new Intent(getActivity(),HalfLifeCalci.class);
          //  finish();
            startActivity(intent);


        }


        return super.onOptionsItemSelected(item);
    }
  /*  @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch(keyCode){
            case KeyEvent.KEYCODE_BACK:

                Intent intent=new Intent(HalfLifeCalculatorCalci.this,HalfLifeCalci.class);
                finish();
                startActivity(intent);

                return true;
        }
        return super.onKeyDown(keyCode, event);
    }*/

}


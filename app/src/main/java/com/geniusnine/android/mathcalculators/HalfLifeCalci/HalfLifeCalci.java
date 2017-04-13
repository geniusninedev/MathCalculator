package com.geniusnine.android.mathcalculators.HalfLifeCalci;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.geniusnine.android.mathcalculators.MainActivity;
import com.geniusnine.android.mathcalculators.R;

import java.util.ArrayList;

public class HalfLifeCalci extends AppCompatActivity {





    halfLifeCalculator HalfLifeCalci;
    Spinner halfLifeSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_half_life_calci);

       /* textViewQuantity=(TextView)findViewById(R.id.textViewQuantity);
        textViewInitial=(TextView)findViewById(R.id.textViewInitial);

        textViewTime=(TextView)findViewById(R.id.textViewTime);
        textViewHalfLife=(TextView)findViewById(R.id.textViewHalfLife);
*/

        halfLifeSpinner=(Spinner)findViewById(R.id.spinnerHalfLife);




       /* editTextQuantity=(EditText) findViewById(R.id.editTextQuantity);
        editTextInitial=(EditText)findViewById(R.id.editTextInitial);
        editTextTime=(EditText)findViewById(R.id.editTextTime);
        editTextHalfLife=(EditText)findViewById(R.id.editTextHalfLife);

        Button calculate=(Button)findViewById(R.id.buttonCalculate);
        Button clear=(Button)findViewById(R.id.buttonClear);*/

        ArrayList area = new ArrayList();
        area.add("Select");
        area.add("Half Life Calculator");
        area.add("Mean Half Life Calculator");


        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, area);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        halfLifeSpinner.setAdapter(dataAdapter);

        halfLifeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {


            /*    if (position==0){

*//*

                    textViewQuantity.setVisibility(View.INVISIBLE);
                    textViewInitial.setVisibility(View.INVISIBLE);
                    textViewHalfLife.setVisibility(View.INVISIBLE);
                    textViewTime.setVisibility(View.INVISIBLE);

                    editTextQuantity.setVisibility(View.INVISIBLE);
                    editTextInitial.setVisibility(View.INVISIBLE);
                    editTextTime.setVisibility(View.INVISIBLE);
                    editTextHalfLife.setVisibility(View.INVISIBLE);
*//*





                }*/
                if (position==1){



                    Intent meanHalfLife=new Intent(getApplicationContext(),HalfLifeCalculatorCalci.class);
                    finish();
                    startActivity(meanHalfLife);


                }

                if (position==2){


                    Intent meanHalfLife = new Intent(getApplicationContext(), MeanHalfLifeCalculator.class);
                    startActivity(meanHalfLife);
                    finish();





                }


           /*     if (halfLifeSpinner.getSelectedItem().toString().trim().equals("Half Life Calculator")) {


                    Intent meanHalfLife=new Intent(getApplicationContext(),HalfLifeCalci.class);
                    finish();
                    startActivity(meanHalfLife);


                    textViewQuantity.setVisibility(View.VISIBLE);
                    textViewInitial.setVisibility(View.VISIBLE);
                    textViewHalfLife.setVisibility(View.VISIBLE);
                    textViewTime.setVisibility(View.VISIBLE);

                    editTextQuantity.setVisibility(View.VISIBLE);
                    editTextInitial.setVisibility(View.VISIBLE);
                    editTextTime.setVisibility(View.VISIBLE);
                    editTextHalfLife.setVisibility(View.VISIBLE);






                }

              *//*  if (halfLifeSpinner.getSelectedItem().toString().trim().equals("Select")) {

                    textViewQuantity.setVisibility(View.INVISIBLE);
                    textViewInitial.setVisibility(View.INVISIBLE);
                    textViewHalfLife.setVisibility(View.INVISIBLE);
                    textViewTime.setVisibility(View.INVISIBLE);

                    editTextQuantity.setVisibility(View.INVISIBLE);
                    editTextInitial.setVisibility(View.INVISIBLE);
                    editTextTime.setVisibility(View.INVISIBLE);
                    editTextHalfLife.setVisibility(View.INVISIBLE);




                }
*//*
               if (halfLifeSpinner.getSelectedItem().toString().trim().equals("Mean Half Life Calculator")) {


                    Intent meanHalfLife = new Intent(getApplicationContext(), MeanHalfLifeCalculator.class);
                    startActivity(meanHalfLife);
                    finish();
                }*/
              /*  if (position==0){

                   *//* editTextQuantity.setVisibility(View.VISIBLE);
                    editTextInitial.setVisibility(View.VISIBLE);
                    editTextTime.setVisibility(View.VISIBLE);
                    editTextHalfLife.setVisibility(View.VISIBLE);

                    textViewQuantity.setVisibility(View.INVISIBLE);
                    textViewInitial.setVisibility(View.VISIBLE);
                    textViewTime.setVisibility(View.VISIBLE);
                    textViewQuantity.setVisibility(View.VISIBLE);*//*




                }
                else if (position==1){
                    Intent meanHalfLife=new Intent(getApplicationContext(),HalfLifeCalci.class);
                    startActivity(meanHalfLife);
                    finish();
                }*/

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        /*calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                halfLifeCalculator HalfLifeCalci=new halfLifeCalculator();

                InputMethodManager inputManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);

                Toast.makeText(getApplicationContext(),"Enter Any Three Values",Toast.LENGTH_LONG).show();

                if (TextUtils.isEmpty(editTextQuantity.getText().toString().trim())&&TextUtils.isEmpty(editTextInitial.getText().toString().trim())
                        &&TextUtils.isEmpty(editTextTime.getText().toString().trim())
                        &&TextUtils.isEmpty(editTextHalfLife.getText().toString().trim())) {

                    Toast.makeText(HalfLifeCalci.this,"Please provide any Three values",Toast.LENGTH_SHORT).show();

                    return;
                }
                if (TextUtils.isEmpty(editTextQuantity.getText().toString().trim())&&TextUtils.isEmpty(editTextInitial.getText().toString().trim())){
                    Toast.makeText(HalfLifeCalci.this,"Please provide any Three values",Toast.LENGTH_SHORT).show();

                    return;
                }

                if (TextUtils.isEmpty(editTextInitial.getText().toString().trim())&&TextUtils.isEmpty(editTextTime.getText().toString().trim())) {
                    Toast.makeText(HalfLifeCalci.this,"Please provide any Three values",Toast.LENGTH_SHORT).show();

                    return;
                }
                if (TextUtils.isEmpty(editTextTime.getText().toString().trim())&&TextUtils.isEmpty(editTextHalfLife.getText().toString().trim())) {
                    Toast.makeText(HalfLifeCalci.this,"Please provide any Three values",Toast.LENGTH_SHORT).show();

                    return;
                }

                if (TextUtils.isEmpty(editTextQuantity.getText().toString().trim())&&TextUtils.isEmpty(editTextTime.getText().toString().trim())) {
                    Toast.makeText(HalfLifeCalci.this,"Please provide any Three values",Toast.LENGTH_SHORT).show();

                    return;
                }
                if (TextUtils.isEmpty(editTextQuantity.getText().toString().trim())&&TextUtils.isEmpty(editTextHalfLife.getText().toString().trim())) {
                    Toast.makeText(HalfLifeCalci.this,"Please provide any Three values",Toast.LENGTH_SHORT).show();

                    return;
                }

                if (TextUtils.isEmpty(editTextInitial.getText().toString().trim())&&TextUtils.isEmpty(editTextHalfLife.getText().toString().trim())) {
                    Toast.makeText(HalfLifeCalci.this,"Please provide any Three values",Toast.LENGTH_SHORT).show();

                    return;
                }

                if (TextUtils.isEmpty(editTextQuantity.getText().toString().trim())) {
                    Toast.makeText(HalfLifeCalci.this,"Please provide any Three values",Toast.LENGTH_SHORT).show();
                    InitialValue = Double.parseDouble(editTextInitial.getText().toString().trim());
                    TimeValue = Double.parseDouble(editTextTime.getText().toString().trim());
                    HalfLifeValue = Double.parseDouble(editTextHalfLife.getText().toString().trim());


                    double result = HalfLifeCalci.calculateQuantityRemainsFromInitial(InitialValue, TimeValue, HalfLifeValue);
                    editTextQuantity.setText(String.valueOf(result));
*//*
                    if(editTextInitial.getText().toString().trim().equals("")){
                        editTextInitial.setError("Enter Initial Quantity");
                    }
                    if(editTextTime.getText().toString().trim().equals("")){
                        editTextTime.setError("Enter Time");
                    }
                    if(editTextHalfLife.getText().toString().trim().equals("")){
                        editTextHalfLife.setError("Enter Half Life");
                    }*//*
                 *//*   else {*//*

*//*
                    }*//*
                }


                if (TextUtils.isEmpty(editTextInitial.getText().toString().trim())) {
                    Toast.makeText(HalfLifeCalci.this,"Please provide any Three values",Toast.LENGTH_SHORT).show();
                    QuantityValue = Double.parseDouble(editTextQuantity.getText().toString().trim());
                    TimeValue = Double.parseDouble(editTextTime.getText().toString().trim());
                    HalfLifeValue = Double.parseDouble(editTextHalfLife.getText().toString().trim());


                    double result = HalfLifeCalci.calculateInitialQuantityFromQuantityRemains(QuantityValue, TimeValue, HalfLifeValue);
                    editTextInitial.setText(String.valueOf(result));

                }

                if(TextUtils.isEmpty(editTextHalfLife.getText().toString().trim())) {

                    Toast.makeText(HalfLifeCalci.this,"Please provide any Three values",Toast.LENGTH_SHORT).show();

                    QuantityValue = Double.parseDouble(editTextQuantity.getText().toString().trim());
                    TimeValue = Double.parseDouble(editTextTime.getText().toString().trim());
                    InitialValue = Double.parseDouble(editTextInitial.getText().toString().trim());

                    double result = HalfLifeCalci.calculateTimeHalfFromInitial(QuantityValue,InitialValue,TimeValue);
                    editTextHalfLife.setText(String.valueOf(result));
                }

                if(TextUtils.isEmpty(editTextTime.getText().toString().trim())) {

                    Toast.makeText(HalfLifeCalci.this,"Please provide any Three values",Toast.LENGTH_SHORT).show();

                    QuantityValue = Double.parseDouble(editTextQuantity.getText().toString().trim());
                    HalfLifeValue = Double.parseDouble(editTextHalfLife.getText().toString().trim());

                    InitialValue = Double.parseDouble(editTextInitial.getText().toString().trim());


                    double result = HalfLifeCalci.calculateTimeFromQuantity(HalfLifeValue,QuantityValue,InitialValue);
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
*/
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
            Intent intent=new Intent(HalfLifeCalci.this,MainActivity.class);
        //    finish();
            startActivity(intent);


        }


        return super.onOptionsItemSelected(item);
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch(keyCode){
            case KeyEvent.KEYCODE_BACK:

                Intent intent=new Intent(HalfLifeCalci.this,MainActivity.class);
                finish();
                startActivity(intent);

                return true;
        }
        return super.onKeyDown(keyCode, event);
    }

}


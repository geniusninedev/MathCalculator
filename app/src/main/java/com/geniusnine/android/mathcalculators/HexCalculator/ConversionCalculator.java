package com.geniusnine.android.mathcalculators.HexCalculator;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.geniusnine.android.mathcalculators.R;

import java.util.ArrayList;

public class ConversionCalculator extends AppCompatActivity {

    EditText editTextConvertNumber,editTextDecimalNumber,editTextHexadecimalNumber,editTextOctalNumber;
    Spinner numberFormatValue,spinnerDecimal,spinnerHexadecimal,spinnerOctal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conversion_calculator);


        editTextConvertNumber=(EditText)findViewById(R.id.editTextNumber);
        editTextDecimalNumber=(EditText)findViewById(R.id.editTextDecimalNumber);
        editTextHexadecimalNumber=(EditText)findViewById(R.id.editTextHexaDecimalNumber);
        editTextOctalNumber=(EditText)findViewById(R.id.editTextOctalNumber);



        numberFormatValue=(Spinner)findViewById(R.id.spinnerNumber);
        spinnerDecimal=(Spinner)findViewById(R.id.spinnerDecimalNumber);
        spinnerHexadecimal=(Spinner)findViewById(R.id.spinnerHexaDecimalNumber);
        spinnerOctal=(Spinner)findViewById(R.id.spinnerOctalNumber);


        ArrayList area = new ArrayList();

        area.add("Decimal");
        area.add("Hexadecimal");
        area.add("Octal");

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, area);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        numberFormatValue.setAdapter(dataAdapter);


        ArrayList areaDecimal = new ArrayList();

        areaDecimal.add("Binary");
        areaDecimal.add("Hexadecimal");
        areaDecimal.add("Octal");

        ArrayAdapter<String> dataAdapterDecimal = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, areaDecimal);
        dataAdapterDecimal.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerDecimal.setAdapter(dataAdapterDecimal);


        ArrayList areaHexadecimal = new ArrayList();

        areaHexadecimal.add("Binary");
        areaHexadecimal.add("Decimal");
        areaHexadecimal.add("Octal");

        ArrayAdapter<String> dataAdapterHexadecimal = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, areaHexadecimal);
        dataAdapterHexadecimal.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerHexadecimal.setAdapter(dataAdapterHexadecimal);


        ArrayList areaOctal = new ArrayList();

        areaOctal.add("Binary");
        areaOctal.add("Decimal");
        areaOctal.add("Hexadecimal");

        ArrayAdapter<String> dataAdapterOctal = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, areaOctal);
        dataAdapterOctal.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerOctal.setAdapter(dataAdapterOctal);



        Button calci=(Button)findViewById(R.id.buttonCalculator);
        Button reset=(Button)findViewById(R.id.buttonClear);

calci.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {

        HexCalci Calculator = new HexCalci();
        InputMethodManager inputManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
        if(editTextConvertNumber.getText().toString().equals("")){
            editTextConvertNumber.setError("Enter The Binary Number");

        }if(editTextDecimalNumber.getText().toString().equals("")){
            editTextDecimalNumber.setError("Enter The Decimal Number");

        }
        if(editTextHexadecimalNumber.getText().toString().equals("")){
            editTextHexadecimalNumber.setError("Enter The Hexadecimal Number");

        }
        if(editTextOctalNumber.getText().toString().equals("")){
            editTextOctalNumber.setError("Enter The Octal Number");

        }
        else
        {

            String spinnerArea = numberFormatValue.getSelectedItem().toString().trim();


            double  ValueOne = Double.parseDouble(editTextConvertNumber.getText().toString().trim());



            if (numberFormatValue.getSelectedItem().toString().trim().equals("Decimal")) {

                double resultgrossDomesticProductValueDecimal =Calculator.binaryToDecimal(ValueOne);
              editTextConvertNumber.setText(""+resultgrossDomesticProductValueDecimal);

            } else  if (numberFormatValue.getSelectedItem().toString().trim().equals("Hexadecimal")) {

                String resultgrossDomesticProductValueHex =Calculator.binaryToHex(ValueOne);
                editTextConvertNumber.setText("" + resultgrossDomesticProductValueHex);

            }

            else  if (numberFormatValue.getSelectedItem().toString().trim().equals("Octal")) {

                String resultgrossDomesticProductValueDecimal = String.valueOf(Calculator.binarytoOctal(ValueOne));
                editTextConvertNumber.setText(""+resultgrossDomesticProductValueDecimal);

            }

            double  ValueTwo = Double.parseDouble(editTextDecimalNumber.getText().toString().trim());

            String spinnerArea1 = spinnerDecimal.getSelectedItem().toString().trim();

            if(spinnerDecimal.getSelectedItem().toString().trim().equals("Binary")){

                double resultgrossDomesticProductValueDecimal =Calculator.decimalToBinary(ValueTwo);
                editTextDecimalNumber.setText(""+resultgrossDomesticProductValueDecimal);

            }

          else  if(spinnerDecimal.getSelectedItem().toString().trim().equals("Hexadecimal")){

                String resultgrossDomesticProductValueDecimal =Calculator.decToHex(ValueTwo);
                editTextDecimalNumber.setText(""+resultgrossDomesticProductValueDecimal);

            }
            else  if(spinnerDecimal.getSelectedItem().toString().trim().equals("Octal")){

                double resultgrossDomesticProductValueDecimal =Calculator.dectoOctal(ValueTwo);
                editTextDecimalNumber.setText(""+resultgrossDomesticProductValueDecimal);

            }

            String spinnerArea2 = spinnerHexadecimal.getSelectedItem().toString().trim();
            String  ValueThree = String.valueOf(editTextHexadecimalNumber.getText().toString().trim());

            if(spinnerHexadecimal.getSelectedItem().toString().trim().equals("Binary")){


            /*    Double resultgrossDomesticProductValueBinary = Double.valueOf(Calculator.convertHexToBinary(ValueThree));
                editTextHexadecimalNumber.setText("" + resultgrossDomesticProductValueBinary);
*/

            }
            else  if(spinnerHexadecimal.getSelectedItem().toString().trim().equals("Decimal")){

                Double resultgrossDomesticProductValueBinary = Double.valueOf(Calculator.hex2dec(ValueThree));
                editTextHexadecimalNumber.setText("" + resultgrossDomesticProductValueBinary);

            }
            else  if(spinnerHexadecimal.getSelectedItem().toString().trim().equals("Octal")){

                Double resultgrossDomesticProductValueBinary = Double.valueOf(Calculator.hex2Octal(ValueThree));
                editTextHexadecimalNumber.setText("" + resultgrossDomesticProductValueBinary);

            }
            else {

            }


            String spinnerArea4 = spinnerOctal.getSelectedItem().toString().trim();
            String  ValueFour = editTextOctalNumber.getText().toString().trim();

            if(spinnerOctal.getSelectedItem().toString().trim().equals("Binary")){

              String resultgrossDomesticProductValueBinary = String.valueOf(Calculator.getBinaryFromOctalNumber(ValueFour));
                editTextOctalNumber.setText("" + resultgrossDomesticProductValueBinary);

            }
          /*  else  if(spinnerOctal.getSelectedItem().toString().trim().equals("Decimal")){

                Double resultgrossDomesticProductValueBinary = Double.valueOf(Calculator.hex2dec(ValueThree));
                editTextOctalNumber.setText("" + resultgrossDomesticProductValueBinary);

            }
            else  if(spinnerOctal.getSelectedItem().toString().trim().equals("Hexadecimal")){

                Double resultgrossDomesticProductValueBinary = Double.valueOf(Calculator.hex2Octal(ValueThree));
                editTextOctalNumber.setText("" + resultgrossDomesticProductValueBinary);

            }*/

        }
          }
         });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editTextConvertNumber.setText("");
                editTextDecimalNumber.setText("");
                editTextHexadecimalNumber.setText("");
                editTextOctalNumber.setText("");
            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == android.R.id.home) {
            Intent intent=new Intent(ConversionCalculator.this,HexCalCalci.class);
            finish();
            startActivity(intent);

        }

        return super.onOptionsItemSelected(item);
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch(keyCode){
            case KeyEvent.KEYCODE_BACK:
                Intent intent=new Intent(ConversionCalculator.this,HexCalCalci.class);
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

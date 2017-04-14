package com.geniusnine.android.mathcalculators.HexCalculator;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.geniusnine.android.mathcalculators.R;

import java.util.ArrayList;

public class ConversionCalculator extends android.support.v4.app.Fragment {

    EditText editTextConvertNumber,editTextDecimalNumber,editTextHexadecimalNumber,editTextOctalNumber;
    Spinner numberFormatValue,spinnerDecimal,spinnerHexadecimal,spinnerOctal;
  /*  @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conversion_calculator);*/
  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

      //Returning the layout file after inflating
      //Change R.layout.tab1 in you classes
      View view = inflater.inflate(R.layout.activity_conversion_calculator, container, false);

      editTextConvertNumber = (EditText) view.findViewById(R.id.editTextNumber);
      editTextDecimalNumber = (EditText) view.findViewById(R.id.editTextDecimalNumber);
      editTextHexadecimalNumber = (EditText) view.findViewById(R.id.editTextHexaDecimalNumber);
      editTextOctalNumber = (EditText) view.findViewById(R.id.editTextOctalNumber);


      numberFormatValue = (Spinner) view.findViewById(R.id.spinnerNumber);
      spinnerDecimal = (Spinner) view.findViewById(R.id.spinnerDecimalNumber);
      spinnerHexadecimal = (Spinner) view.findViewById(R.id.spinnerHexaDecimalNumber);
      spinnerOctal = (Spinner) view.findViewById(R.id.spinnerOctalNumber);


      ArrayList area = new ArrayList();

      area.add("Decimal");
      area.add("Hexadecimal");
      area.add("Octal");

      ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, area);
      dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
      numberFormatValue.setAdapter(dataAdapter);


      ArrayList areaDecimal = new ArrayList();

      areaDecimal.add("Binary");
      areaDecimal.add("Hexadecimal");
      areaDecimal.add("Octal");

      ArrayAdapter<String> dataAdapterDecimal = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, areaDecimal);
      dataAdapterDecimal.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
      spinnerDecimal.setAdapter(dataAdapterDecimal);


      ArrayList areaHexadecimal = new ArrayList();

      areaHexadecimal.add("Binary");
      areaHexadecimal.add("Decimal");
      areaHexadecimal.add("Octal");

      ArrayAdapter<String> dataAdapterHexadecimal = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, areaHexadecimal);
      dataAdapterHexadecimal.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
      spinnerHexadecimal.setAdapter(dataAdapterHexadecimal);


      ArrayList areaOctal = new ArrayList();

      areaOctal.add("Binary");
      areaOctal.add("Decimal");
      areaOctal.add("Hexadecimal");

      ArrayAdapter<String> dataAdapterOctal = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, areaOctal);
      dataAdapterOctal.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
      spinnerOctal.setAdapter(dataAdapterOctal);


      Button calci = (Button) view.findViewById(R.id.buttonCalculator);
      Button reset = (Button) view.findViewById(R.id.buttonClear);

      calci.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {

              HexCalci Calculator = new HexCalci();

              hideKeyboard();
              if (editTextConvertNumber.getText().toString().equals("")) {
                  editTextConvertNumber.setError("Enter The Binary Number");

              }
              if (editTextDecimalNumber.getText().toString().equals("")) {
                  editTextDecimalNumber.setError("Enter The Decimal Number");

              }
              if (editTextHexadecimalNumber.getText().toString().equals("")) {
                  editTextHexadecimalNumber.setError("Enter The Hexadecimal Number");

              }
              if (editTextOctalNumber.getText().toString().equals("")) {
                  editTextOctalNumber.setError("Enter The Octal Number");

              } else {

                  String spinnerArea = numberFormatValue.getSelectedItem().toString().trim();


                  double ValueOne = Double.parseDouble(editTextConvertNumber.getText().toString().trim());


                  if (numberFormatValue.getSelectedItem().toString().trim().equals("Decimal")) {

                      double resultgrossDomesticProductValueDecimal = Calculator.binaryToDecimal(ValueOne);
                      editTextConvertNumber.setText("" + resultgrossDomesticProductValueDecimal);

                  } else if (numberFormatValue.getSelectedItem().toString().trim().equals("Hexadecimal")) {

                      String resultgrossDomesticProductValueHex = Calculator.binaryToHex(ValueOne);
                      editTextConvertNumber.setText("" + resultgrossDomesticProductValueHex);

                  } else if (numberFormatValue.getSelectedItem().toString().trim().equals("Octal")) {

                      String resultgrossDomesticProductValueDecimal = String.valueOf(Calculator.binarytoOctal(ValueOne));
                      editTextConvertNumber.setText("" + resultgrossDomesticProductValueDecimal);

                  }

                  double ValueTwo = Double.parseDouble(editTextDecimalNumber.getText().toString().trim());

                  String spinnerArea1 = spinnerDecimal.getSelectedItem().toString().trim();

                  if (spinnerDecimal.getSelectedItem().toString().trim().equals("Binary")) {

                      double resultgrossDomesticProductValueDecimal = Calculator.decimalToBinary(ValueTwo);
                      editTextDecimalNumber.setText("" + resultgrossDomesticProductValueDecimal);

                  } else if (spinnerDecimal.getSelectedItem().toString().trim().equals("Hexadecimal")) {

                      String resultgrossDomesticProductValueDecimal = Calculator.decToHex(ValueTwo);
                      editTextDecimalNumber.setText("" + resultgrossDomesticProductValueDecimal);

                  } else if (spinnerDecimal.getSelectedItem().toString().trim().equals("Octal")) {

                      double resultgrossDomesticProductValueDecimal = Calculator.dectoOctal(ValueTwo);
                      editTextDecimalNumber.setText("" + resultgrossDomesticProductValueDecimal);

                  }

                  String spinnerArea2 = spinnerHexadecimal.getSelectedItem().toString().trim();
                  String ValueThree = String.valueOf(editTextHexadecimalNumber.getText().toString().trim());

                  if (spinnerHexadecimal.getSelectedItem().toString().trim().equals("Binary")) {



                  } else if (spinnerHexadecimal.getSelectedItem().toString().trim().equals("Decimal")) {

                      Double resultgrossDomesticProductValueBinary = Double.valueOf(Calculator.hex2dec(ValueThree));
                      editTextHexadecimalNumber.setText("" + resultgrossDomesticProductValueBinary);

                  } else if (spinnerHexadecimal.getSelectedItem().toString().trim().equals("Octal")) {

                      Double resultgrossDomesticProductValueBinary = Double.valueOf(Calculator.hex2Octal(ValueThree));
                      editTextHexadecimalNumber.setText("" + resultgrossDomesticProductValueBinary);

                  } else {

                  }


                  String spinnerArea4 = spinnerOctal.getSelectedItem().toString().trim();
                  String ValueFour = editTextOctalNumber.getText().toString().trim();

                  if (spinnerOctal.getSelectedItem().toString().trim().equals("Binary")) {

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
            Intent intent=new Intent(getActivity(),HexCalCalci.class);

            startActivity(intent);

        }

        return super.onOptionsItemSelected(item);
    }
   /* @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch(keyCode){
            case KeyEvent.KEYCODE_BACK:
                Intent intent=new Intent(getActivity(),HexCalCalci.class);
             //   finish();
                startActivity(intent);
                return true;
        }
        return super.onKeyDown(keyCode, event);
    }*/

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

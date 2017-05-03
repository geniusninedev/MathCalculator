package com.geniusnine.android.mathcalculators.TimeCalculator;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.geniusnine.android.mathcalculators.GCFCalculator.GCFCalculator;
import com.geniusnine.android.mathcalculators.MainActivity;
import com.geniusnine.android.mathcalculators.R;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

import java.util.ArrayList;

public class TimeCalculator extends AppCompatActivity {
    EditText firstDay,firstMinute,firstHour,firstSecond;
    EditText secondDay,secondMinute,secondHour,secondSecond;

    TextView textViewResult;
    Spinner areaField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_calculator);

        MobileAds.initialize(TimeCalculator.this, getString(R.string.ads_app_id));
        AdView mAdView = (AdView) findViewById(R.id.adViewtimecal);

        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        textViewResult=(TextView)findViewById(R.id.textViewResult);


        firstDay=(EditText)findViewById(R.id.editTextfirstDay);
        firstMinute=(EditText)findViewById(R.id.editTextfirstMinute);
        firstHour=(EditText)findViewById(R.id.editTextfirstHour);
        firstSecond=(EditText)findViewById(R.id.editTextfirstSecond);



        secondDay=(EditText)findViewById(R.id.editTextsecondDay);
        secondMinute=(EditText)findViewById(R.id.editTextsecondMinute);
        secondHour=(EditText)findViewById(R.id.editTextsecondHour);
        secondSecond=(EditText)findViewById(R.id.editTextsecondSecond);


        Button buttonCalculte=(Button) findViewById(R.id.buttonCalculate);
        Button buttonClear=(Button) findViewById(R.id.buttonClear);

        areaField = (Spinner) findViewById(R.id.spinnerTime);

        ArrayList area = new ArrayList();
        area.add("+");
        area.add("-");


        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, area);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        areaField.setAdapter(dataAdapter);

        buttonCalculte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                time Calculator = new time();

                InputMethodManager inputManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
                if (firstDay.getText().toString().trim().equals("")) {
                    firstDay.setError("Enter first Day");
                }

                else if (firstMinute.getText().toString().trim().equals("")) {
                    firstMinute.setError("Enter firstMinute");
                }


                else if (firstHour.getText().toString().trim().equals("")) {
                    firstHour.setError("Enter firstHour");
                }


                else if (firstSecond.getText().toString().trim().equals("")) {
                    firstSecond.setError("Enter firstSecond");


                }
                else  if (secondDay.getText().toString().trim().equals("")) {
                    secondDay.setError("Enter secondDay");


                }
                else  if (secondMinute.getText().toString().trim().equals("")) {
                    secondMinute.setError("Enter secondMinute");

                }
                else  if (secondHour.getText().toString().trim().equals("")) {
                    secondHour.setError("Enter secondHour");


                }
                else  if (secondSecond.getText().toString().trim().equals("")) {
                    secondSecond.setError("Enter secondSecond");

                }
                else {
                    String spinnerArea = areaField.getSelectedItem().toString().trim();

                    int firstDayValue = Integer.parseInt(firstDay.getText().toString().trim());
                    int firstMinuteValue = Integer.parseInt(firstMinute.getText().toString().trim());
                    int firstHourValue = Integer.parseInt(firstHour.getText().toString().trim());
                    int firstSecondValue = Integer.parseInt(firstSecond.getText().toString().trim());

                    int secondDayValue =Integer.parseInt(secondDay.getText().toString().trim());
                    int secondMinuteValue = Integer.parseInt(secondMinute.getText().toString().trim());
                    int secondHourValue = Integer.parseInt(secondHour.getText().toString().trim());
                    int secondSecondValue = Integer.parseInt(secondSecond.getText().toString().trim());

                    if (areaField.getSelectedItem().toString().trim().equals("+")) {


                        textViewResult.setVisibility(View.VISIBLE);

                        int resultgrossDomesticProductValue = Calculator.timeCalculatoraddDay(firstDayValue, secondDayValue);
                        int resulthour=Calculator.timeCalculatoraddHour(firstHourValue,secondHourValue);
                        int resultminute=Calculator.timeCalculatoraddMinute(firstMinuteValue,secondMinuteValue);
                        int resultsecond=Calculator.timeCalculatoraddSecond(firstSecondValue,secondSecondValue);

                        textViewResult.setText("" + resultgrossDomesticProductValue+"Days: "+resulthour+"Hours: "+resultminute+"Minutes: "+resultsecond+"Seconds ");

                    }


                    if (areaField.getSelectedItem().toString().trim().equals("-")) {


                        textViewResult.setVisibility(View.VISIBLE);

                        int resultgrossDomesticProductValue = Calculator.timeCalculatorsubDay(firstDayValue, secondDayValue);
                        int resulthour=Calculator.timeCalculatorsubHour(firstHourValue,secondHourValue);
                        int resultminute=Calculator.timeCalculatorsubMinute(firstMinuteValue,secondMinuteValue);
                        int resultsecond=Calculator.timeCalculatorsubSecond(firstSecondValue,secondSecondValue);

                        textViewResult.setText("" + resultgrossDomesticProductValue+"Days: "+resulthour+"Hours: "+resultminute+"Minutes: "+resultsecond+"Seconds");

                    }

                }

            }
        });
        buttonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                textViewResult.setText("");

                firstDay.setText("");
                firstMinute.setText("");
                firstHour.setText("");
                firstSecond.setText("");



                secondDay.setText("");
                secondMinute.setText("");
                secondHour.setText("");
                secondSecond.setText("");
                textViewResult.setVisibility(View.GONE);



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
            Intent intent=new Intent(TimeCalculator.this,MainActivity.class);
            //    finish();
            startActivity(intent);


        }


        return super.onOptionsItemSelected(item);
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch(keyCode){
            case KeyEvent.KEYCODE_BACK:

                Intent intent=new Intent(TimeCalculator.this,MainActivity.class);
                finish();
                startActivity(intent);

                return true;
        }
        return super.onKeyDown(keyCode, event);
    }

}







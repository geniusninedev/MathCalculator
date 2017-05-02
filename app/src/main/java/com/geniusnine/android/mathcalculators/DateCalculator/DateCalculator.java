package com.geniusnine.android.mathcalculators.DateCalculator;

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

import com.geniusnine.android.mathcalculators.MainActivity;
import com.geniusnine.android.mathcalculators.R;

public class DateCalculator extends AppCompatActivity {
    public EditText monthStart, monthEnd, dayStart, dayEnd, yearStart, yearEnd;
    public Button calculate;
    public TextView resultText;

    public String mS, mE;
    public int dS, dE, yS, yE, years_passed, days_passed;

    public String months[] = {"january", "february", "march", "april", "may", "june", "july",
            "august", "september", "october", "november", "december"};
    public int monthKeys[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
    public int monthDays[] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_calculator);
        monthStart = (EditText)findViewById(R.id.monthStart);
        dayStart = (EditText)findViewById(R.id.dayStart);
        yearStart = (EditText)findViewById(R.id.yearStart);

        monthEnd = (EditText)findViewById(R.id.monthEnd);
        dayEnd = (EditText)findViewById(R.id.dayEnd);
        yearEnd = (EditText)findViewById(R.id.yearEnd);

        calculate = (Button)findViewById(R.id.btnCalculate);
        resultText = (TextView)findViewById(R.id.txtResult);


    }

    public int calculateYears(int s, int e)
    {
        if(monthStart.getText().toString().trim().equals("")){
            monthStart.setError("Enter Month");
        }
        if(dayStart.getText().toString().trim().equals("")){
            dayStart.setError("Enter Day");
        }
        if(yearStart.getText().toString().trim().equals("")){
            yearStart.setError("Enter Year");
        }


        if(monthEnd.getText().toString().trim().equals("")){
            monthEnd.setError("Enter Month");
        }
        if(dayEnd.getText().toString().trim().equals("")){
            dayEnd.setError("Enter Day");
        }
        if(yearEnd.getText().toString().trim().equals("")){
            yearEnd.setError("Enter Year");
        }

            int y = 0;

           if (s < e)
        {
            y = yE - yS;
        }
        else if (s > e)
        {
            y = yE - yS - 1;
        }
        else if (s == e)
        {
            if (dE < dS)
            {
                y = yE - yS - 1;
            }
            else
            {
                y = yE - yS;
            }
        }

        return y;

    }

    public int calculateDays(int s, int e, int dS, int dE) {

        if(monthStart.getText().toString().trim().equals("")){
            monthStart.setError("Enter Month");
        }
        if(dayStart.getText().toString().trim().equals("")){
            dayStart.setError("Enter Day");
        }
        if(yearStart.getText().toString().trim().equals("")){
            yearStart.setError("Enter Year");
        }


        if(monthEnd.getText().toString().trim().equals("")){
            monthEnd.setError("Enter Month");
        }
        if(dayEnd.getText().toString().trim().equals("")){
            dayEnd.setError("Enter Day");
        }
        if(yearEnd.getText().toString().trim().equals("")){
            yearEnd.setError("Enter Year");
        }
            int d = 0;

            if (s < e) {
                for (int i = 0; i < monthDays.length; i++) {
                    if (monthKeys[i] == s) {
                        d = d + (monthDays[i] - dS);
                    } else if (monthKeys[i] > s && monthKeys[i] < e) {
                        d = d + monthDays[i];
                    } else if (monthKeys[i] == e) {
                        d = d + dE;
                    }
                }
            }
        else if (e < s) {
                int days_passed_A = 0;

                for (int i = 0; i < monthDays.length; i++) {
                    if (monthKeys[i] == s) {
                        d = d + (monthDays[i] - dS);
                    } else if (monthKeys[i] > s) {
                        d = d + (monthDays[i]);
                    }
                }

                for (int i = 0; i < monthDays.length; i++) {
                    if (monthKeys[i] == e) {
                        days_passed_A = days_passed_A + dE;
                    } else if (monthKeys[i] < e) {
                        days_passed_A = days_passed_A + monthDays[i];
                    }
                }

                d = d + days_passed_A;
            } else if (e == s) {
                if (dE >= dS) {
                    d = d + (Math.abs(dE - dS));
                } else {
                    d = d + (365 - Math.abs(dE - dS));
                }

            }

            return d;

        }


    public int findMonthKey(String m)
    {

        if(monthStart.getText().toString().trim().equals("")){
            monthStart.setError("Enter Month");
        }
        if(dayStart.getText().toString().trim().equals("")){
            dayStart.setError("Enter Day");
        }
        if(yearStart.getText().toString().trim().equals("")){
            yearStart.setError("Enter Year");
        }


        if(monthEnd.getText().toString().trim().equals("")){
            monthEnd.setError("Enter Month");
        }
        if(dayEnd.getText().toString().trim().equals("")){
            dayEnd.setError("Enter Day");
        }
        if(yearEnd.getText().toString().trim().equals("")){
            yearEnd.setError("Enter Year");
        }
        int key = 0;
        System.out.println(m);

        for (int i = 0; i < monthKeys.length; i++)
        {
            if (m.equals(months[i]))
            {
                key = monthKeys[i];
                return key;
            }
        }

        return 0;
    }

    public void calculateDate(View v)
    {

        InputMethodManager inputManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);

        if(monthStart.getText().toString().trim().equals("")){
            monthStart.setError("Enter Month");
        }
        if(dayStart.getText().toString().trim().equals("")){
            dayStart.setError("Enter Day");
        }
        if(yearStart.getText().toString().trim().equals("")){
            yearStart.setError("Enter Year");
        }


        if(monthEnd.getText().toString().trim().equals("")){
            monthEnd.setError("Enter Month");
        }
        if(dayEnd.getText().toString().trim().equals("")){
            dayEnd.setError("Enter Day");
        }
        if(yearEnd.getText().toString().trim().equals("")){
            yearEnd.setError("Enter Year");
        }
        else {
            mS = monthStart.getText().toString().toLowerCase();
            mE = monthEnd.getText().toString().toLowerCase();

            dS = Integer.parseInt(dayStart.getText().toString());
            dE = Integer.parseInt(dayEnd.getText().toString());

            yS = Integer.parseInt(yearStart.getText().toString());
            yE = Integer.parseInt(yearEnd.getText().toString());

            int monthStart = findMonthKey(mS);
            int monthEnd = findMonthKey(mE);

            //Get the distance between years
            years_passed = calculateYears(monthStart, monthEnd);

            //Days calculation
            days_passed = calculateDays(monthStart, monthEnd, dS, dE);

            if (days_passed == 365) {
                years_passed++;
                days_passed = 0;
            }

            if (monthStart != 0 && monthEnd != 0 && (dS <= 31 && dS > 0) && (dE <= 31 && dE > 0) && (yE >= yS)) {
                resultText.setText("" + years_passed + " years, " + days_passed + " days.");
            } else if (yE < yS) {


                resultText.setText("Can't calculate backwards!");
            } else if (monthStart == 0 || monthEnd == 0) {
                resultText.setText("Invalid entry in month!");
            } else if (dS > 31 || dE > 31) {
                resultText.setText("No more than 31 days!");
            } else if (dS <= 0 || dE <= 0) {
                resultText.setText("Date must be larger than 0!");
            }
        }
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
            Intent intent=new Intent(DateCalculator.this,MainActivity.class);
            //    finish();
            startActivity(intent);


        }


        return super.onOptionsItemSelected(item);
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch(keyCode){
            case KeyEvent.KEYCODE_BACK:

                Intent intent=new Intent(DateCalculator.this,MainActivity.class);
                finish();
                startActivity(intent);

                return true;
        }
        return super.onKeyDown(keyCode, event);
    }

}









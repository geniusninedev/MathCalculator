package com.geniusnine.android.mathcalculators.RootCalculator;

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
import android.widget.TextView;

import com.geniusnine.android.mathcalculators.R;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class SquareRootCalculator extends android.support.v4.app.Fragment{
    TextView textViewSquareRoot;
    EditText editTextSquareRoot;
    int squareRootNumber;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.activity_square_root_calculator, container, false);

        MobileAds.initialize(getActivity(), getString(R.string.ads_app_id));
        AdView mAdView = (AdView)view. findViewById(R.id.adViewsquareroot);

        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        textViewSquareRoot=(TextView)view.findViewById(R.id.textViewSquareRoot);
        editTextSquareRoot=(EditText) view.findViewById(R.id.editTextSquareRoot);

        Button calculate=(Button)view.findViewById(R.id.buttonCalculate);
        Button clear=(Button)view.findViewById(R.id.buttonReset);


        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                RootCalci squareRootCalculator=new RootCalci();
                hideKeyboard();

                if(editTextSquareRoot.getText().toString().trim().equals("")){
                    editTextSquareRoot.setError("Enter The Number");
                }
                else {
                    squareRootNumber = Integer.parseInt(editTextSquareRoot.getText().toString().trim());
                    double result = squareRootCalculator.squareRoot((double) squareRootNumber);
                    // sqrRootResult.setText("Given quadratic equation:"+valueOfFirst+"x^2 +  "+ valueOfSecond+ "x +  "+valueOfThird);
                    editTextSquareRoot.setText("" + result);
                }
            }
        });
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editTextSquareRoot.setText("");
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
            Intent intent=new Intent(getActivity(),RootCalCalci.class);
           // finish();
            startActivity(intent);

        }

        return super.onOptionsItemSelected(item);
    }
   /* @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch(keyCode){
            case KeyEvent.KEYCODE_BACK:
                Intent intent=new Intent(SquareRootCalculator.this,RootCalCalci.class);
                finish();
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

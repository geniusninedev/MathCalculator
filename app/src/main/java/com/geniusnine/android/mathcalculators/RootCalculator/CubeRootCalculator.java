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

public class CubeRootCalculator extends android.support.v4.app.Fragment{

    TextView textViewCubeRoot;
    EditText cubeRootResult;
    int cubeRootNumber;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.activity_cube_root_calculator, container, false);

        MobileAds.initialize(getActivity(), getString(R.string.ads_app_id));
        AdView mAdView = (AdView)view. findViewById(R.id.adViewcuberoot);

        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        textViewCubeRoot=(TextView)view.findViewById(R.id.textViewCubeNumber);
        cubeRootResult=(EditText) view.findViewById(R.id.editTextCubeRootResult);

        Button calci=(Button)view.findViewById(R.id.buttonCalci);
        Button reset=(Button)view.findViewById(R.id.buttonClear);

        calci.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RootCalci squareRootCalculator=new RootCalci();
                hideKeyboard();

                if(cubeRootResult.getText().toString().trim().equals("")){
                    cubeRootResult.setError("Enter The Number");
                }

                else {
                    cubeRootNumber = Integer.parseInt(cubeRootResult.getText().toString().trim());
                    double result = squareRootCalculator.cubeRoot((double) cubeRootNumber);
                    // sqrRootResult.setText("Given quadratic equation:"+valueOfFirst+"x^2 +  "+ valueOfSecond+ "x +  "+valueOfThird);
                    cubeRootResult.setText("" + result);
                }
            }
        });
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cubeRootResult.setText("");
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
            //finish();
            startActivity(intent);

        }

        return super.onOptionsItemSelected(item);
    }
  /*  @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch(keyCode){
            case KeyEvent.KEYCODE_BACK:
                Intent intent=new Intent(CubeRootCalculator.this,RootCalCalci.class);
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


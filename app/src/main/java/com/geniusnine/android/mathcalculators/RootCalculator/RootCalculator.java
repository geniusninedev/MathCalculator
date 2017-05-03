package com.geniusnine.android.mathcalculators.RootCalculator;

import android.content.Intent;
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

public class RootCalculator extends android.support.v4.app.Fragment{

    double generalRootNumber;
    int  generalRoot;

    TextView textViewGeneralRoot,textViewGeneralRootNumber,textViewResult;
    EditText editTextGeneralRoot,editTextGeneralRootNumber;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.activity_root_calculator, container, false);
        MobileAds.initialize(getActivity(), getString(R.string.ads_app_id));
        AdView mAdView = (AdView)view. findViewById(R.id.adViewrootcal);

        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        textViewGeneralRoot=(TextView)view.findViewById(R.id.textViewGeneralRoot);
        textViewGeneralRootNumber=(TextView)view.findViewById(R.id.textViewRootNumber);
        textViewResult=(TextView)view.findViewById(R.id.textViewResult);


        editTextGeneralRoot=(EditText)view. findViewById(R.id.editTextRoot);
        editTextGeneralRootNumber=(EditText)view. findViewById(R.id.editTextRootNumber);




        Button buttonCalci=(Button)view.findViewById(R.id.CalciButton);
        Button buttonClear=(Button)view.findViewById(R.id.ClearButton);



        buttonCalci.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RootCalci squareRootCalculator=new RootCalci();
                hideKeyboard();
                if(editTextGeneralRoot.getText().toString().trim().equals("")){
                    editTextGeneralRoot.setError("Enter The Root ");
                }
                if(editTextGeneralRootNumber.getText().toString().trim().equals("")){
                    editTextGeneralRootNumber.setError("Enter The Number");
                }
                else {
                    textViewResult.setVisibility(View.VISIBLE);
                    generalRoot = Integer.parseInt(editTextGeneralRoot.getText().toString().trim());
                    generalRootNumber=Double.parseDouble(editTextGeneralRootNumber.getText().toString().trim());

                    double result = squareRootCalculator.nthroot( generalRoot,generalRootNumber);
                    // sqrRootResult.setText("Given quadratic equation:"+valueOfFirst+"x^2 +  "+ valueOfSecond+ "x +  "+valueOfThird);
                    textViewResult.setText(generalRoot  + " Root Of "+  generalRootNumber +"  is:   "+ result);
                }

            }


        });
        buttonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editTextGeneralRoot.setText("");
                editTextGeneralRootNumber.setText("");
                textViewResult.setText("");
                textViewResult.setVisibility(View.GONE);

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
            Intent intent=new Intent(getActivity(),RootCalCalci.class);
           // finish();
            startActivity(intent);


        }


        return super.onOptionsItemSelected(item);
    }
  /*  @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch(keyCode){
            case KeyEvent.KEYCODE_BACK:

                Intent intent=new Intent(RootCalculator.this,RootCalCalci.class);
                finish();
                startActivity(intent);

                return true;
        }
        return super.onKeyDown(keyCode, event);
    }*/

}


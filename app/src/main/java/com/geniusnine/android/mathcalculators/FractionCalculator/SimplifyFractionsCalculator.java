package com.geniusnine.android.mathcalculators.FractionCalculator;

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

public class SimplifyFractionsCalculator  extends android.support.v4.app.Fragment{
    TextView textViewAnswerSecond,textViewAnswerResult;
    EditText editTextAnswerFirst;
    EditText editTextSimpleValueOne,editTextSimpleValueTwo,editTextSimpleValueThree;
    double simpleValueOne,simpleValueTwo,simpleValueThree;
  /*  @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simplify_fractions_calculator);*/
  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


      View view = inflater.inflate(R.layout.activity_simplify_fractions_calculator, container, false);

      MobileAds.initialize(getActivity(), getString(R.string.ads_app_id));
      AdView mAdView = (AdView) view.findViewById(R.id.adViewsimplyfraction);

      AdRequest adRequest = new AdRequest.Builder().build();
      mAdView.loadAd(adRequest);
        editTextSimpleValueOne=(EditText)view.findViewById(R.id.editTextSimplifyOne);
        editTextSimpleValueTwo=(EditText)view.findViewById(R.id.editTextSimplifyTwo);
        editTextSimpleValueThree=(EditText)view.findViewById(R.id.editTextSimplifyThird);
        editTextAnswerFirst=(EditText)view.findViewById(R.id.editTextAnswerFirst);

        textViewAnswerSecond=(TextView)view.findViewById(R.id.textViewAnswerSecond);
        textViewAnswerResult=(TextView)view.findViewById(R.id.textViewAnswerResult);

        Button calci=(Button)view.findViewById(R.id.buttonCalci);
        Button reset=(Button)view.findViewById(R.id.buttonReset);

        calci.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FractionCalci fractionCalci=new FractionCalci();
      hideKeyboard();
                if(editTextSimpleValueOne.getText().toString().trim().equals("")){
                    editTextSimpleValueOne.setError("Enter The 1st Value");
                }
                if(editTextSimpleValueTwo.getText().toString().trim().equals("")){
                    editTextSimpleValueTwo.setError("Enter The 2nd Value");
                }
                if(editTextSimpleValueThree.getText().toString().trim().equals("")){
                    editTextSimpleValueThree.setError("Enter The 3rd Value");
                }
          else {

                    textViewAnswerSecond.setVisibility(View.INVISIBLE);
                    simpleValueOne = (Double.parseDouble(editTextSimpleValueOne.getText().toString().trim()));
                    simpleValueTwo = (Double.parseDouble(editTextSimpleValueTwo.getText().toString().trim()));
                    simpleValueThree = (Double.parseDouble(editTextSimpleValueThree.getText().toString().trim()));

                    int result = (int) fractionCalci.CalculateSimplifyFraction(simpleValueOne, simpleValueTwo, simpleValueThree);
                    int result1 = (int) fractionCalci.CalculateSimplifyFractionOne(simpleValueThree);
                    editTextAnswerFirst.setText("" + result);
                    textViewAnswerSecond.setText("" + result1);
                    textViewAnswerResult.setVisibility(View.VISIBLE);
                    textViewAnswerResult.setText("Fraction:"+result+"/"+result1);
                }
            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editTextSimpleValueOne.setText("");
                editTextSimpleValueTwo.setText("");
                editTextSimpleValueThree.setText("");
                editTextAnswerFirst.setText("");
                textViewAnswerSecond.setText("");
                textViewAnswerSecond.setVisibility(View.INVISIBLE);
                textViewAnswerResult.setVisibility(View.GONE);
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
            Intent intent=new Intent(getActivity(),FractionCalCalci.class);
            //finish();
            startActivity(intent);

        }

        return super.onOptionsItemSelected(item);
    }
  /*  @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch(keyCode){
            case KeyEvent.KEYCODE_BACK:
                Intent intent=new Intent(SimplifyFractionsCalculator.this,FractionCalCalci.class);
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


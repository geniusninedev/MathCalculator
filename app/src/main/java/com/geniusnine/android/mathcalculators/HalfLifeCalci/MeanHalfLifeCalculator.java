package com.geniusnine.android.mathcalculators.HalfLifeCalci;

import android.content.Intent;
import android.content.res.Configuration;
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
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class MeanHalfLifeCalculator extends android.support.v4.app.Fragment {

    TextView textViewHalf,textViewMeanLife,textViewDecayConstant;
    EditText editTextHalf,editTextMeanLife,editTextDecayConstant;
    double HalfValue,MeanLifeValue,DecayConstantValue;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.activity_mean_half_life_calculator, container, false);

        MobileAds.initialize(getActivity(), getString(R.string.ads_app_id));
        AdView mAdView = (AdView)view.findViewById(R.id.adViewmeanhalflife);

        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        textViewHalf=(TextView)view.findViewById(R.id.textViewHalf);
        textViewMeanLife=(TextView)view.findViewById(R.id.textViewMeanLife);
        textViewDecayConstant=(TextView)view.findViewById(R.id.textViewDecay);


        editTextHalf=(EditText)view. findViewById(R.id.editTextHalf);
        editTextMeanLife=(EditText)view. findViewById(R.id.editTextMeanLife);
        editTextDecayConstant=(EditText)view. findViewById(R.id.editTextDecay);


        Button buttonCalculate=(Button)view.findViewById(R.id.buttonCalculateOne);
        Button buttonClear=(Button)view.findViewById(R.id.buttonClearSecond);


        buttonCalculate.setOnClickListener(new View.OnClickListener() {




            @Override
            public void onClick(View v) {

                MeanHalfLifeCalci MeanHalfLifeCalci=new MeanHalfLifeCalci();
hideKeyboard();

                if (TextUtils.isEmpty(editTextHalf.getText().toString().trim())&&TextUtils.isEmpty(editTextMeanLife.getText().toString().trim())
                        &&TextUtils.isEmpty(editTextDecayConstant.getText().toString().trim())) {

                    Toast.makeText(getActivity(),"Please provide any One value",Toast.LENGTH_SHORT).show();

                    return;
                }

                if (TextUtils.isEmpty(editTextHalf.getText().toString().trim())&&TextUtils.isEmpty(editTextMeanLife.getText().toString().trim())){
                    Toast.makeText(getActivity(),"Please provide any One values",Toast.LENGTH_SHORT).show();
                    DecayConstantValue = Double.parseDouble(editTextDecayConstant.getText().toString().trim());


                    double resultDecay = MeanHalfLifeCalci.calculatehalfTimeFromDecayConstant(DecayConstantValue);
                    double resultDecayConstant = MeanHalfLifeCalci.calculateMeanLifeTimeFromDecayConstant(DecayConstantValue);

                    editTextHalf.setText(String.valueOf(resultDecay));
                    editTextMeanLife.setText(String.valueOf(resultDecayConstant));
                    return;
                }
                if (TextUtils.isEmpty(editTextMeanLife.getText().toString().trim())&&TextUtils.isEmpty(editTextDecayConstant.getText().toString().trim())){
                    Toast.makeText(getActivity(),"Please provide any One values",Toast.LENGTH_SHORT).show();
                    HalfValue = Double.parseDouble(editTextHalf.getText().toString().trim());


                    double resultDecay = MeanHalfLifeCalci.calculateMeanLifeTimeFromhalfTime(HalfValue);
                    double resultDecayConstant = MeanHalfLifeCalci.calculateDecayconstantFromhalfTime(HalfValue);

                    editTextMeanLife.setText(String.valueOf(resultDecay));
                    editTextDecayConstant.setText(String.valueOf(resultDecayConstant));
                    return;
                }
                if (TextUtils.isEmpty(editTextHalf.getText().toString().trim())&&TextUtils.isEmpty(editTextDecayConstant.getText().toString().trim())){
                    Toast.makeText(getActivity(),"Please provide any One values",Toast.LENGTH_SHORT).show();
                    MeanLifeValue = Double.parseDouble(editTextMeanLife.getText().toString().trim());


                    double resultDecay = MeanHalfLifeCalci.calculatehalfTimeFromMeanLifeTime(MeanLifeValue);
                    double resultDecayConstant = MeanHalfLifeCalci.calculateDecayconstantFromMeanLifeTime(MeanLifeValue);

                    editTextHalf.setText(String.valueOf(resultDecay));
                    editTextDecayConstant.setText(String.valueOf(resultDecayConstant));
                    return;
                }

    if(!editTextHalf.getText().toString().trim().equals("") && !editTextDecayConstant.getText().toString().trim().equals("") &&
            !editTextMeanLife.getText().toString().trim().equals("") ){
                  Toast.makeText(getActivity(),"Please provide any One values",Toast.LENGTH_SHORT).show();
            return;
        }

                if(!editTextHalf.getText().toString().trim().equals("") && !editTextDecayConstant.getText().toString().trim().equals("") &&
                        editTextMeanLife.getText().toString().trim().equals("") ){
                    Toast.makeText(getActivity(),"Please provide any One values",Toast.LENGTH_SHORT).show();
                    return;
                }

                if(editTextHalf.getText().toString().trim().equals("") && !editTextDecayConstant.getText().toString().trim().equals("") &&
                        !editTextMeanLife.getText().toString().trim().equals("") ){
                    Toast.makeText(getActivity(),"Please provide any One values",Toast.LENGTH_SHORT).show();
                    return;
                }  if(!editTextHalf.getText().toString().trim().equals("") && editTextDecayConstant.getText().toString().trim().equals("") &&
                        !editTextMeanLife.getText().toString().trim().equals("") ){
                    Toast.makeText(getActivity(),"Please provide any One values",Toast.LENGTH_SHORT).show();
                    return;
                }






            }
        });

        buttonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editTextHalf.setText("");
                editTextDecayConstant.setText("");
                editTextMeanLife.setText("");
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
            Intent intent=new Intent(getActivity(),HalfLifeCalci.class);
          //  finish();
            startActivity(intent);

        }

        return super.onOptionsItemSelected(item);
    }
 /*   @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch(keyCode){
            case KeyEvent.KEYCODE_BACK:

                Intent intent=new Intent(MeanHalfLifeCalculator.this,HalfLifeCalci.class);
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

package com.geniusnine.android.mathcalculators.DensityCalculator;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.geniusnine.android.mathcalculators.DateCalculator.DateCalculator;
import com.geniusnine.android.mathcalculators.MainActivity;
import com.geniusnine.android.mathcalculators.R;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class DensityCalculator extends AppCompatActivity {
    EditText editTextDensity,editTextVolume,editTextMass;
    TextView textViewDensity,textViewVolume,textViewMass;
    double densityValue,volumeValue,massValue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_density_calculator);

        MobileAds.initialize(DensityCalculator.this, getString(R.string.ads_app_id));
        AdView mAdView = (AdView) findViewById(R.id.adViewdensity);

        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        editTextDensity=(EditText)findViewById(R.id.editTextDensity);
        editTextVolume=(EditText)findViewById(R.id.editTextVolume);
        editTextMass=(EditText)findViewById(R.id.editTextMass);

        textViewDensity=(TextView)findViewById(R.id.textViewDensity);
        textViewVolume=(TextView)findViewById(R.id.textViewVolume);
        textViewMass=(TextView)findViewById(R.id.textViewMass);


        Button calculate=(Button)findViewById(R.id.buttonCalculate);
        Button clear=(Button)findViewById(R.id.buttonClear);

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DensityCalci densityCalci =new DensityCalci();

                InputMethodManager inputManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);



                if (TextUtils.isEmpty(editTextDensity.getText().toString().trim())&&TextUtils.isEmpty(editTextVolume.getText().toString().trim())
                        &&TextUtils.isEmpty(editTextMass.getText().toString().trim())
                        ) {

                    Toast.makeText(DensityCalculator.this,"Please provide any Two values",Toast.LENGTH_SHORT).show();

                    return;
                }

                if(!editTextVolume.getText().toString().equals("")&& !editTextMass.getText().toString().equals("")  && editTextDensity.getText().toString().trim().equals("")){




                    volumeValue = Double.parseDouble(editTextVolume.getText().toString().trim());
                    massValue = Double.parseDouble(editTextMass.getText().toString().trim());


                    double result = densityCalci.calculateDensityfromVolume(volumeValue, massValue);
                    editTextDensity.setText("" + result + "");

                    return;
                }

                if(!editTextDensity.getText().toString().equals("") &&!editTextVolume.getText().toString().equals("") && editTextMass.getText().toString().trim().equals("") ){
                    densityValue = Double.parseDouble(editTextDensity.getText().toString().trim());
                    volumeValue = Double.parseDouble(editTextVolume.getText().toString().trim());


                    double result = densityCalci.calculateMassfromDensity(densityValue, volumeValue);
                    editTextMass.setText("" + result + " ");
                    return;
                }


                if(!editTextDensity.getText().toString().equals("") &&!editTextMass.getText().toString().equals("") && editTextVolume.getText().toString().trim().equals("") ){

                    densityValue = Double.parseDouble(editTextDensity.getText().toString().trim());
                    massValue = Double.parseDouble(editTextMass.getText().toString().trim());


                    double result = densityCalci.calculateVolumefromDensity(densityValue, massValue);
                    editTextVolume.setText("" + result + " ");

                    return;
                }



                if(!editTextMass.getText().toString().equals("")){
                    Toast.makeText(DensityCalculator.this,"Please provide any Two values",Toast.LENGTH_SHORT).show();
                    return;
                }
                if(!editTextDensity.getText().toString().equals("")){
                    Toast.makeText(DensityCalculator.this,"Please provide any Two values",Toast.LENGTH_SHORT).show();
                    return;
                }
                if(!editTextVolume.getText().toString().equals("")){
                    Toast.makeText(DensityCalculator.this,"Please provide any Two values",Toast.LENGTH_SHORT).show();
                    return;
                }



            }
        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editTextDensity.setText("");
                editTextVolume.setText("");
                editTextMass.setText("");
            }
        });






    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == android.R.id.home) {
            Intent intent=new Intent(DensityCalculator.this,MainActivity.class);
            finish();
            startActivity(intent);


        }


        return super.onOptionsItemSelected(item);
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch(keyCode){
            case KeyEvent.KEYCODE_BACK:

                Intent intent=new Intent(DensityCalculator.this,MainActivity.class);
                finish();
                startActivity(intent);

                return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}

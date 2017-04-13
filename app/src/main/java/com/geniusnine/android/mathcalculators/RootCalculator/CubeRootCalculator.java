package com.geniusnine.android.mathcalculators.RootCalculator;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.geniusnine.android.mathcalculators.R;

public class CubeRootCalculator extends AppCompatActivity {
    TextView textViewCubeRoot;
    EditText cubeRootResult;
    int cubeRootNumber;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_cube_root_calculator);

        textViewCubeRoot=(TextView)findViewById(R.id.textViewCubeNumber);
        cubeRootResult=(EditText) findViewById(R.id.editTextCubeRootResult);

        Button calci=(Button)findViewById(R.id.buttonCalci);
        Button reset=(Button)findViewById(R.id.buttonClear);

        calci.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RootCalci squareRootCalculator=new RootCalci();
                InputMethodManager inputManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
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

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == android.R.id.home) {
            Intent intent=new Intent(CubeRootCalculator.this,RootCalCalci.class);
            finish();
            startActivity(intent);

        }

        return super.onOptionsItemSelected(item);
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch(keyCode){
            case KeyEvent.KEYCODE_BACK:
                Intent intent=new Intent(CubeRootCalculator.this,RootCalCalci.class);
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


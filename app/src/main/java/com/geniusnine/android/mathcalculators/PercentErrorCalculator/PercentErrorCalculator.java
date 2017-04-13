package com.geniusnine.android.mathcalculators.PercentErrorCalculator;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.geniusnine.android.mathcalculators.MainActivity;
import com.geniusnine.android.mathcalculators.R;

public class PercentErrorCalculator extends AppCompatActivity {
    TextView observedValue,trueValue,result;
    double paralleloneValue,seriesoneValue;
    EditText editTextobservedValue,editTexttrueValue;

    PercentageErrorCalci percentageError;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_percent_error_calculator);

     //   getSupportActionBar().setHomeButtonEnabled(true);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        observedValue=(TextView)findViewById(R.id.textViewObservedValue);
        trueValue=(TextView)findViewById(R.id.textViewTrueValue);
        result=(TextView)findViewById(R.id.textViewResult);
        result.setVisibility(View.INVISIBLE);

        editTextobservedValue=(EditText)findViewById(R.id.editTextObservedValue);
        editTexttrueValue=(EditText)findViewById(R.id.editTextTrueValue);

        Button buttonCalculte=(Button) findViewById(R.id.buttonCalculate);
        Button buttonClear=(Button) findViewById(R.id.buttonClear);

        buttonCalculte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(TextUtils.isEmpty(editTextobservedValue.getText().toString().trim())){
                    editTextobservedValue.setError("Enter the Observed Value");
                    return;
                }
                if(TextUtils.isEmpty(editTexttrueValue.getText().toString().trim())){
                    editTexttrueValue.setError("Enter the True Value");
                    return;
                }
                else {

                    paralleloneValue = Double.parseDouble(editTextobservedValue.getText().toString().trim());
                    seriesoneValue = Double.parseDouble(editTexttrueValue.getText().toString().trim());



                    String paralleloneValue1 = Double.toString((double) paralleloneValue);
                    String parallelsecondValue1 = Double.toString((double) seriesoneValue);


                    result.setVisibility(View.VISIBLE);

                    PercentageErrorCalci percentageError = new PercentageErrorCalci();

                    double percentError_result=percentageError.calculatePercentageError(paralleloneValue,seriesoneValue);

                    result.setText("Percent error =" + percentError_result+"%");

                }


            }
        });
        buttonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editTextobservedValue.setText("");
                editTexttrueValue.setText("");
                result.setText("");
                result.setVisibility(View.INVISIBLE);
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
            Intent intent=new Intent(PercentErrorCalculator.this,MainActivity.class);
            finish();
            startActivity(intent);


        }


        return super.onOptionsItemSelected(item);
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch(keyCode){
            case KeyEvent.KEYCODE_BACK:

                Intent intent=new Intent(
                        PercentErrorCalculator.this,MainActivity.class);
                finish();
                startActivity(intent);

                return true;
        }
        return super.onKeyDown(keyCode, event);
    }

}

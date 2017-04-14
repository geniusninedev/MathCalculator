package com.geniusnine.android.mathcalculators.GCFCalculator;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.geniusnine.android.mathcalculators.MainActivity;
import com.geniusnine.android.mathcalculators.R;

public class GCFCalculator extends AppCompatActivity {
    EditText editTextAnswerNumber;
    TextView textViewNumber,textViewResult;

    EditText editTextFirstValue,  editTextSecondValue,editTextThirdValue,editTextFourthValue,editTextFifthValue,
            editTextSixValue,editTextSevenValue,editTextEightValue,editTextNinethValue,editTextTenthValue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gcfcalculator);
        editTextAnswerNumber=(EditText)findViewById(R.id.editTextAnswerNumber);

        editTextFirstValue=(EditText)findViewById(R.id.editTextOne);
        editTextSecondValue=(EditText)findViewById(R.id.editTextTwo);
        editTextThirdValue=(EditText)findViewById(R.id.editTextThree);
        editTextFourthValue=(EditText)findViewById(R.id.editTextFour);
        editTextFifthValue=(EditText)findViewById(R.id.editTextFive);
        editTextSixValue=(EditText)findViewById(R.id.editTextSix);
        editTextSevenValue=(EditText)findViewById(R.id.editTextSeven);
        editTextEightValue=(EditText)findViewById(R.id.editTextEight);
        editTextNinethValue=(EditText)findViewById(R.id.editTextNine);
        editTextTenthValue=(EditText)findViewById(R.id.editTextTen);


        textViewNumber=(TextView)findViewById(R.id.textViewNumber);
        textViewResult=(TextView)findViewById(R.id.textViewResult);

        Button calculate=(Button)findViewById(R.id.buttonCalculate);
        Button clear=(Button)findViewById(R.id.buttonClear);

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gcf lcmCalci=new gcf();

                InputMethodManager inputManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);

                if (editTextAnswerNumber.getText().toString().trim().equals("2")) {

                    if (TextUtils.isEmpty(editTextFirstValue.getText().toString().trim())&&TextUtils.isEmpty(editTextSecondValue.getText().toString().trim())) {

                        Toast.makeText(GCFCalculator.this,"Please provide  Two values",Toast.LENGTH_SHORT).show();

                        return;
                    }

                    if(!editTextFirstValue.getText().toString().trim().equals("")&& editTextSecondValue.getText().toString().trim().equals("")
                            &&editTextThirdValue.getText().toString().trim().equals("")  )
                    {
                        Toast.makeText(GCFCalculator.this,"Please provide 1st Two values",Toast.LENGTH_SHORT).show();
                    }

                    if(!editTextFirstValue.getText().toString().trim().equals("")&& !editTextSecondValue.getText().toString().trim().equals("")
                            &&!editTextThirdValue.getText().toString().trim().equals("")  )
                    {
                        Toast.makeText(GCFCalculator.this,"Please provide 1st Two values",Toast.LENGTH_SHORT).show();
                    } if(!editTextFirstValue.getText().toString().trim().equals("")&& !editTextSecondValue.getText().toString().trim().equals("")
                            &&!editTextFourthValue.getText().toString().trim().equals("")  )
                    {
                        Toast.makeText(GCFCalculator.this,"Please provide 1st Two values",Toast.LENGTH_SHORT).show();
                    }if(!editTextFirstValue.getText().toString().trim().equals("")&& !editTextSecondValue.getText().toString().trim().equals("")
                            &&!editTextFifthValue.getText().toString().trim().equals("")  )
                    {
                        Toast.makeText(GCFCalculator.this,"Please provide 1st Two values",Toast.LENGTH_SHORT).show();
                    }if(!editTextFirstValue.getText().toString().trim().equals("")&& !editTextSecondValue.getText().toString().trim().equals("")
                            &&!editTextSixValue.getText().toString().trim().equals("")  )
                    {
                        Toast.makeText(GCFCalculator.this,"Please provide 1st Two values",Toast.LENGTH_SHORT).show();
                    }
                    if(!editTextFirstValue.getText().toString().trim().equals("")&& !editTextSecondValue.getText().toString().trim().equals("")
                            &&!editTextSevenValue.getText().toString().trim().equals("")  )
                    {
                        Toast.makeText(GCFCalculator.this,"Please provide 1st Two values",Toast.LENGTH_SHORT).show();
                    } if(!editTextFirstValue.getText().toString().trim().equals("")&& !editTextSecondValue.getText().toString().trim().equals("")
                            &&!editTextEightValue.getText().toString().trim().equals("")  )
                    {
                        Toast.makeText(GCFCalculator.this,"Please provide 1st Two values",Toast.LENGTH_SHORT).show();
                    }if(!editTextFirstValue.getText().toString().trim().equals("")&& !editTextSecondValue.getText().toString().trim().equals("")
                            &&!editTextNinethValue.getText().toString().trim().equals("")  )
                    {
                        Toast.makeText(GCFCalculator.this,"Please provide 1st Two values",Toast.LENGTH_SHORT).show();
                    }if(!editTextFirstValue.getText().toString().trim().equals("")&& !editTextSecondValue.getText().toString().trim().equals("")
                            &&!editTextTenthValue.getText().toString().trim().equals("")  )
                    {
                        Toast.makeText(GCFCalculator.this,"Please provide 1st Two values",Toast.LENGTH_SHORT).show();
                    }

                    else if(editTextFirstValue.getText().toString().trim().equals("")&& editTextSecondValue.getText().toString().trim().equals(""))
                    {
                        Toast.makeText(GCFCalculator.this,"Please provide 1st Two values",Toast.LENGTH_SHORT).show();

                    }


                    int valueFirst=Integer.parseInt(editTextFirstValue.getText().toString().trim());
                    int valueSecond=Integer.parseInt(editTextSecondValue.getText().toString().trim());


                    editTextFirstValue.setVisibility(View.VISIBLE);
                    editTextSecondValue.setVisibility(View.VISIBLE);

                    editTextThirdValue.setVisibility(View.VISIBLE);
                    editTextFourthValue.setVisibility(View.VISIBLE);
                    editTextFifthValue.setVisibility(View.VISIBLE);
                    editTextSixValue.setVisibility(View.VISIBLE);
                    editTextSevenValue.setVisibility(View.VISIBLE);
                    editTextEightValue.setVisibility(View.VISIBLE);
                    editTextNinethValue.setVisibility(View.VISIBLE);
                    editTextTenthValue.setVisibility(View.VISIBLE);

                    double resultgrossDomesticProductValue = lcmCalci.gcdOne(valueFirst, valueSecond);
                    textViewResult.setText("Greatest Common Factor:" + resultgrossDomesticProductValue);
                }



                else if (editTextAnswerNumber.getText().toString().trim().equals("3")) {

                    if (TextUtils.isEmpty(editTextFirstValue.getText().toString().trim())&&TextUtils.isEmpty(editTextSecondValue.getText().toString().trim())&&TextUtils.isEmpty(editTextThirdValue.getText().toString().trim())) {

                        Toast.makeText(GCFCalculator.this,"Please provide  Three values",Toast.LENGTH_SHORT).show();

                        return;
                    }

                    if(!editTextFirstValue.getText().toString().trim().equals("")&& !editTextSecondValue.getText().toString().trim().equals("")&& !editTextThirdValue.getText().toString().trim().equals("")
                            &&!editTextFourthValue.getText().toString().trim().equals("")  )
                    {
                        Toast.makeText(GCFCalculator.this,"Please provide 1st Three values",Toast.LENGTH_SHORT).show();
                    }if(!editTextFirstValue.getText().toString().trim().equals("")&& !editTextSecondValue.getText().toString().trim().equals("")&& !editTextThirdValue.getText().toString().trim().equals("")
                            &&!editTextFifthValue.getText().toString().trim().equals("")  )
                    {
                        Toast.makeText(GCFCalculator.this,"Please provide 1st Three values",Toast.LENGTH_SHORT).show();
                    }if(!editTextFirstValue.getText().toString().trim().equals("")&& !editTextSecondValue.getText().toString().trim().equals("")&& !editTextThirdValue.getText().toString().trim().equals("")
                            &&!editTextSixValue.getText().toString().trim().equals("")  )
                    {
                        Toast.makeText(GCFCalculator.this,"Please provide 1st Three values",Toast.LENGTH_SHORT).show();
                    }
                    if(!editTextFirstValue.getText().toString().trim().equals("")&& !editTextSecondValue.getText().toString().trim().equals("")&& !editTextThirdValue.getText().toString().trim().equals("")
                            &&!editTextSevenValue.getText().toString().trim().equals("")  )
                    {
                        Toast.makeText(GCFCalculator.this,"Please provide 1st Three values",Toast.LENGTH_SHORT).show();
                    } if(!editTextFirstValue.getText().toString().trim().equals("")&& !editTextSecondValue.getText().toString().trim().equals("")&& !editTextThirdValue.getText().toString().trim().equals("")
                            &&!editTextEightValue.getText().toString().trim().equals("")  )
                    {
                        Toast.makeText(GCFCalculator.this,"Please provide 1st Three values",Toast.LENGTH_SHORT).show();
                    }if(!editTextFirstValue.getText().toString().trim().equals("")&& !editTextSecondValue.getText().toString().trim().equals("")&& !editTextThirdValue.getText().toString().trim().equals("")
                            &&!editTextNinethValue.getText().toString().trim().equals("")  )
                    {
                        Toast.makeText(GCFCalculator.this,"Please provide 1st Three values",Toast.LENGTH_SHORT).show();
                    }if(!editTextFirstValue.getText().toString().trim().equals("")&& !editTextSecondValue.getText().toString().trim().equals("")&& !editTextThirdValue.getText().toString().trim().equals("")
                            &&!editTextTenthValue.getText().toString().trim().equals("")  )
                    {
                        Toast.makeText(GCFCalculator.this,"Please provide 1st Three values",Toast.LENGTH_SHORT).show();
                    }

                    int valueFirst=Integer.parseInt(editTextFirstValue.getText().toString().trim());
                    int valueSecond=Integer.parseInt(editTextSecondValue.getText().toString().trim());
                    int valueThird=Integer.parseInt(editTextThirdValue.getText().toString().trim());

                    editTextFirstValue.setVisibility(View.VISIBLE);
                    editTextSecondValue.setVisibility(View.VISIBLE);

                    editTextThirdValue.setVisibility(View.VISIBLE);
                    editTextFourthValue.setVisibility(View.VISIBLE);
                    editTextFifthValue.setVisibility(View.VISIBLE);
                    editTextSixValue.setVisibility(View.VISIBLE);
                    editTextSevenValue.setVisibility(View.VISIBLE);
                    editTextEightValue.setVisibility(View.VISIBLE);
                    editTextNinethValue.setVisibility(View.VISIBLE);
                    editTextTenthValue.setVisibility(View.VISIBLE);

                    double resultgrossDomesticProductValue = lcmCalci.gcdTwo(valueFirst, valueSecond,valueThird);
                    textViewResult.setText("Greatest Common Factor:" + resultgrossDomesticProductValue);
                }




                else if (editTextAnswerNumber.getText().toString().trim().equals("4")) {
                    //   Toast.makeText(MainActivity.this,"Please provide Four values",Toast.LENGTH_SHORT).show();

                    if (TextUtils.isEmpty(editTextFirstValue.getText().toString().trim())&& TextUtils.isEmpty(editTextSecondValue.getText().toString().trim())&&
                            TextUtils.isEmpty(editTextThirdValue.getText().toString().trim())
                            && TextUtils.isEmpty(editTextFourthValue.getText().toString().trim())) {

                        Toast.makeText(GCFCalculator.this,"Please provide 1st Four values",Toast.LENGTH_SHORT).show();

                        return;
                    }


                    if (!editTextFirstValue.getText().toString().trim().equals("")&& editTextSecondValue.getText().toString().trim().equals("")&& editTextThirdValue.getText().toString().trim().equals("")
                            &&editTextFourthValue.getText().toString().trim().equals("")
                            ) {

                        Toast.makeText(GCFCalculator.this,"Please provide 1st Four values",Toast.LENGTH_SHORT).show();

                        return;
                    }


                    if (!editTextFirstValue.getText().toString().trim().equals("")&& !editTextSecondValue.getText().toString().trim().equals("")&& editTextThirdValue.getText().toString().trim().equals("")
                            &&editTextFourthValue.getText().toString().trim().equals("")
                            ) {

                        Toast.makeText(GCFCalculator.this,"Please provide 1st Four values",Toast.LENGTH_SHORT).show();

                        return;
                    }

                    if (!editTextFirstValue.getText().toString().trim().equals("")&& !editTextSecondValue.getText().toString().trim().equals("")&& !editTextThirdValue.getText().toString().trim().equals("")
                            &&editTextFourthValue.getText().toString().trim().equals("")
                            ) {

                        Toast.makeText(GCFCalculator.this,"Please provide 1st Four values",Toast.LENGTH_SHORT).show();

                        return;
                    }


                    if(!editTextFirstValue.getText().toString().trim().equals("")&& !editTextSecondValue.getText().toString().trim().equals("")&& !editTextThirdValue.getText().toString().trim().equals("")
                            && !editTextFourthValue.getText().toString().trim().equals("")
                            &&!editTextFifthValue.getText().toString().trim().equals("")  )
                    {
                        Toast.makeText(GCFCalculator.this,"Please provide 1st Four values",Toast.LENGTH_SHORT).show();
                    }


                    if(!editTextFirstValue.getText().toString().trim().equals("")&& !editTextSecondValue.getText().toString().trim().equals("")
                            && !editTextFourthValue.getText().toString().trim().equals("")
                            &&!editTextFifthValue.getText().toString().trim().equals("") &&!editTextSixValue.getText().toString().trim().equals("")  )
                    {
                        Toast.makeText(GCFCalculator.this,"Please provide 1st Four values",Toast.LENGTH_SHORT).show();
                    }


                    if(!editTextFirstValue.getText().toString().trim().equals("")&& !editTextSecondValue.getText().toString().trim().equals("")
                            &&!editTextSevenValue.getText().toString().trim().equals("")  )
                    {
                        Toast.makeText(GCFCalculator.this,"Please provide 1st Four values",Toast.LENGTH_SHORT).show();
                    }


                    if(!editTextFirstValue.getText().toString().trim().equals("")&& !editTextSecondValue.getText().toString().trim().equals("")
                            && !editTextFourthValue.getText().toString().trim().equals("")
                            &&!editTextFifthValue.getText().toString().trim().equals("") &&!editTextEightValue.getText().toString().trim().equals("")  )
                    {
                        Toast.makeText(GCFCalculator.this,"Please provide 1st Four values",Toast.LENGTH_SHORT).show();
                    }


                    if(!editTextFirstValue.getText().toString().trim().equals("")&& !editTextSecondValue.getText().toString().trim().equals("")
                            && !editTextFourthValue.getText().toString().trim().equals("")
                            &&!editTextFifthValue.getText().toString().trim().equals("")  &&!editTextNinethValue.getText().toString().trim().equals("")  )
                    {
                        Toast.makeText(GCFCalculator.this,"Please provide 1st Four values",Toast.LENGTH_SHORT).show();
                    }


                    if(!editTextFirstValue.getText().toString().trim().equals("")&& !editTextSecondValue.getText().toString().trim().equals("")
                            && !editTextFourthValue.getText().toString().trim().equals("")
                            &&!editTextFifthValue.getText().toString().trim().equals("") &&!editTextTenthValue.getText().toString().trim().equals("")  )
                    {
                        Toast.makeText(GCFCalculator.this,"Please provide 1st Four values",Toast.LENGTH_SHORT).show();
                        return;
                    }
                    if(!editTextFirstValue.getText().toString().trim().equals("")&& !editTextSecondValue.getText().toString().trim().equals("")&& !editTextThirdValue.getText().toString().trim().equals("")
                            && editTextFourthValue.getText().toString().trim().equals("")
                            )
                    {
                        Toast.makeText(GCFCalculator.this,"Please provide 1st Four values",Toast.LENGTH_SHORT).show();
                        return;
                    }

                    if(!editTextFirstValue.getText().toString().trim().equals("")&& !editTextSecondValue.getText().toString().trim().equals("")&& editTextThirdValue.getText().toString().trim().equals("")
                            && editTextFourthValue.getText().toString().trim().equals("")
                            )
                    {
                        Toast.makeText(GCFCalculator.this,"Please provide 1st Four values",Toast.LENGTH_SHORT).show();
                    }

                    if(!editTextFirstValue.getText().toString().trim().equals("")&& editTextSecondValue.getText().toString().trim().equals("")&& editTextThirdValue.getText().toString().trim().equals("")
                            && editTextFourthValue.getText().toString().trim().equals("")
                            )
                    {
                        Toast.makeText(GCFCalculator.this,"Please provide 1st Four values",Toast.LENGTH_SHORT).show();
                        return;
                    }

                    if(!editTextFirstValue.getText().toString().trim().equals("")&& editTextSecondValue.getText().toString().trim().equals("")&&editTextSecondValue.getText().toString().trim().equals("")
                            &&editTextFourthValue.getText().toString().trim().equals(""))
                    {
                        Toast.makeText(GCFCalculator.this,"Please provide 1st Four values",Toast.LENGTH_SHORT).show();
                        return;
                    }

                  /*  if(TextUtils.isEmpty(editTextSecondValue.getText().toString().trim()))
                    {
                        Toast.makeText(MainActivity.this,"Please provide 1st Four values",Toast.LENGTH_SHORT).show();

                        return;
                    }*/


                 /*   if(editTextThirdValue.getText().toString().trim().equals(""))
                    {
                        Toast.makeText(MainActivity.this,"Please provide 1st Four values",Toast.LENGTH_SHORT).show();
                        return;
                    }

                    if(editTextFourthValue.getText().toString().trim().equals(""))
                    {
                        Toast.makeText(MainActivity.this,"Please provide 1st Four values",Toast.LENGTH_SHORT).show();
                    }*/



                    int valueFirst=Integer.parseInt(editTextFirstValue.getText().toString().trim());
                    int valueSecond=Integer.parseInt(editTextSecondValue.getText().toString().trim());
                    int valueThird=Integer.parseInt(editTextThirdValue.getText().toString().trim());
                    int valueFourth=Integer.parseInt(editTextFourthValue.getText().toString().trim());

                    editTextFirstValue.setVisibility(View.VISIBLE);
                    editTextSecondValue.setVisibility(View.VISIBLE);

                    editTextThirdValue.setVisibility(View.VISIBLE);
                    editTextFourthValue.setVisibility(View.VISIBLE);
                    editTextFifthValue.setVisibility(View.VISIBLE);
                    editTextSixValue.setVisibility(View.VISIBLE);
                    editTextSevenValue.setVisibility(View.VISIBLE);
                    editTextEightValue.setVisibility(View.VISIBLE);
                    editTextNinethValue.setVisibility(View.VISIBLE);
                    editTextTenthValue.setVisibility(View.VISIBLE);

                    double resultgrossDomesticProductValue = lcmCalci.gcdThree(valueFirst, valueSecond,valueThird,valueFourth);
                    textViewResult.setText("Greatest Common Factor:" + resultgrossDomesticProductValue);
                }




                else if (editTextAnswerNumber.getText().toString().trim().equals("5")) {
                    if (TextUtils.isEmpty(editTextFirstValue.getText().toString().trim())&& TextUtils.isEmpty(editTextSecondValue.getText().toString().trim())&&
                            TextUtils.isEmpty(editTextThirdValue.getText().toString().trim())
                            && TextUtils.isEmpty(editTextFourthValue.getText().toString().trim())  && TextUtils.isEmpty(editTextFifthValue.getText().toString().trim())) {

                        Toast.makeText(GCFCalculator.this,"Please provide 1st Five values",Toast.LENGTH_SHORT).show();

                        return;

                    }
                    if(!editTextFirstValue.getText().toString().trim().equals("")&& !editTextSecondValue.getText().toString().trim().equals("")&&
                            !editTextThirdValue.getText().toString().trim().equals("")
                            &&editTextFourthValue.getText().toString().trim().equals("")&&editTextFifthValue.getText().toString().trim().equals("")
                            )
                    {
                        Toast.makeText(GCFCalculator.this,"Please provide 1st Five values",Toast.LENGTH_SHORT).show();
                        return;
                    }

                    if(!editTextFirstValue.getText().toString().trim().equals("")&& !editTextSecondValue.getText().toString().trim().equals("")&&

                            editTextThirdValue.getText().toString().trim().equals("")
                            &&editTextFourthValue.getText().toString().trim().equals("")&&editTextFifthValue.getText().toString().trim().equals("")
                            )
                    {
                        Toast.makeText(GCFCalculator.this,"Please provide 1st Five values",Toast.LENGTH_SHORT).show();
                        return;
                    }


                    if(!editTextFirstValue.getText().toString().trim().equals("")&& !editTextSecondValue.getText().toString().trim().equals("")&&

                            !editTextThirdValue.getText().toString().trim().equals("")
                            &&!editTextFourthValue.getText().toString().trim().equals("") &&editTextFifthValue.getText().toString().trim().equals("")
                            )
                    {
                        Toast.makeText(GCFCalculator.this,"Please provide 1st Five values",Toast.LENGTH_SHORT).show();
                        return;
                    }

                    if(!editTextFirstValue.getText().toString().trim().equals("")&& editTextSecondValue.getText().toString().trim().equals("")&&
                            editTextThirdValue.getText().toString().trim().equals("")
                            &&editTextFourthValue.getText().toString().trim().equals("")
                            )
                    {
                        Toast.makeText(GCFCalculator.this,"Please provide 1st Five values",Toast.LENGTH_SHORT).show();
                        return;
                    }

                    if(!editTextFirstValue.getText().toString().trim().equals("")&& !editTextSecondValue.getText().toString().trim().equals("")&&
                            !editTextFirstValue.getText().toString().trim().equals("")&& !editTextSecondValue.getText().toString().trim().equals("")
                            &&!editTextThirdValue.getText().toString().trim().equals("")
                            &&!editTextFourthValue.getText().toString().trim().equals("") && !editTextSixValue.getText().toString().trim().equals("")
                            )
                    {
                        Toast.makeText(GCFCalculator.this,"Please provide 1st Five values",Toast.LENGTH_SHORT).show();
                    }if(!editTextFirstValue.getText().toString().trim().equals("")&& !editTextSecondValue.getText().toString().trim().equals("")&&
                            !editTextFirstValue.getText().toString().trim().equals("")&& !editTextSecondValue.getText().toString().trim().equals("")
                            &&!editTextThirdValue.getText().toString().trim().equals("")
                            &&!editTextFourthValue.getText().toString().trim().equals("") && !editTextSixValue.getText().toString().trim().equals("")
                            &&!editTextSevenValue.getText().toString().trim().equals("")  )
                    {
                        Toast.makeText(GCFCalculator.this,"Please provide 1st Five values",Toast.LENGTH_SHORT).show();
                    }if(!editTextFirstValue.getText().toString().trim().equals("")&& !editTextSecondValue.getText().toString().trim().equals("")&&
                            !editTextFirstValue.getText().toString().trim().equals("")&& !editTextSecondValue.getText().toString().trim().equals("")
                            &&!editTextThirdValue.getText().toString().trim().equals("")
                            &&!editTextFourthValue.getText().toString().trim().equals("") && !editTextSixValue.getText().toString().trim().equals("")
                            &&!editTextSevenValue.getText().toString().trim().equals("") &&!editTextEightValue.getText().toString().trim().equals("")
                            )
                    {
                        Toast.makeText(GCFCalculator.this,"Please provide 1st Five values",Toast.LENGTH_SHORT).show();
                    }

                    if(!editTextFirstValue.getText().toString().trim().equals("")&& !editTextSecondValue.getText().toString().trim().equals("")&&
                            !editTextFirstValue.getText().toString().trim().equals("")&& !editTextSecondValue.getText().toString().trim().equals("")
                            &&!editTextThirdValue.getText().toString().trim().equals("")
                            &&!editTextFourthValue.getText().toString().trim().equals("") && !editTextSixValue.getText().toString().trim().equals("")
                            &&!editTextSevenValue.getText().toString().trim().equals("") &&!editTextEightValue.getText().toString().trim().equals("")
                            &&!editTextNinethValue.getText().toString().trim().equals("")
                            &&!editTextTenthValue.getText().toString().trim().equals("") )
                    {
                        Toast.makeText(GCFCalculator.this,"Please provide 1st Five values",Toast.LENGTH_SHORT).show();
                    }

                    int valueFirst=Integer.parseInt(editTextFirstValue.getText().toString().trim());
                    int valueSecond=Integer.parseInt(editTextSecondValue.getText().toString().trim());
                    int valueThird=Integer.parseInt(editTextThirdValue.getText().toString().trim());
                    int valueFourth=Integer.parseInt(editTextFourthValue.getText().toString().trim());
                    int valueFive=Integer.parseInt(editTextFifthValue.getText().toString().trim());


                    editTextFirstValue.setVisibility(View.VISIBLE);
                    editTextSecondValue.setVisibility(View.VISIBLE);

                    editTextThirdValue.setVisibility(View.VISIBLE);
                    editTextFourthValue.setVisibility(View.VISIBLE);
                    editTextFifthValue.setVisibility(View.VISIBLE);
                    editTextSixValue.setVisibility(View.VISIBLE);
                    editTextSevenValue.setVisibility(View.VISIBLE);
                    editTextEightValue.setVisibility(View.VISIBLE);
                    editTextNinethValue.setVisibility(View.VISIBLE);
                    editTextTenthValue.setVisibility(View.VISIBLE);

                    double resultgrossDomesticProductValue = lcmCalci.gcd(valueFirst, valueSecond,valueThird,valueFourth,valueFive);
                    textViewResult.setText("Greatest Common Factor:" + resultgrossDomesticProductValue);
                }
                else if (editTextAnswerNumber.getText().toString().trim().equals("6")) {



                    if (TextUtils.isEmpty(editTextFirstValue.getText().toString().trim())&& TextUtils.isEmpty(editTextSecondValue.getText().toString().trim())&&
                            TextUtils.isEmpty(editTextThirdValue.getText().toString().trim())
                            && TextUtils.isEmpty(editTextFourthValue.getText().toString().trim())  && TextUtils.isEmpty(editTextFifthValue.getText().toString().trim())
                            && TextUtils.isEmpty(editTextSixValue.getText().toString().trim()) ) {

                        Toast.makeText(GCFCalculator.this,"Please provide 1st Six values",Toast.LENGTH_SHORT).show();

                        return;
                    }





                    if(!editTextFirstValue.getText().toString().trim().equals("")&& !editTextSecondValue.getText().toString().trim().equals("")
                            &&!editTextThirdValue.getText().toString().trim().equals("")
                            &&!editTextFourthValue.getText().toString().trim().equals("")      &&!editTextFifthValue.getText().toString().trim().equals("")
                            &&!editTextSixValue.getText().toString().trim().equals("")
                            &&!editTextSevenValue.getText().toString().trim().equals("")  )
                    {
                        Toast.makeText(GCFCalculator.this,"Please provide 1st Six values",Toast.LENGTH_SHORT).show();
                        return;
                    }


                    if(!editTextFirstValue.getText().toString().trim().equals("")&& !editTextSecondValue.getText().toString().trim().equals("")
                            &&!editTextThirdValue.getText().toString().trim().equals("")
                            &&!editTextFourthValue.getText().toString().trim().equals("")      &&!editTextFifthValue.getText().toString().trim().equals("")
                            &&editTextSixValue.getText().toString().trim().equals("")
                            )
                    {
                        Toast.makeText(GCFCalculator.this,"Please provide 1st Six values",Toast.LENGTH_SHORT).show();
                        return;
                    }



                    if(!editTextFirstValue.getText().toString().trim().equals("")&& !editTextSecondValue.getText().toString().trim().equals("")
                            &&!editTextThirdValue.getText().toString().trim().equals("")
                            &&!editTextFourthValue.getText().toString().trim().equals("")      &&editTextFifthValue.getText().toString().trim().equals("")
                            &&editTextSixValue.getText().toString().trim().equals("")
                            )
                    {
                        Toast.makeText(GCFCalculator.this,"Please provide 1st Six values",Toast.LENGTH_SHORT).show();
                        return;
                    }


                    if(!editTextFirstValue.getText().toString().trim().equals("")&& !editTextSecondValue.getText().toString().trim().equals("")
                            &&!editTextThirdValue.getText().toString().trim().equals("")
                            &&editTextFourthValue.getText().toString().trim().equals("")      &&editTextFifthValue.getText().toString().trim().equals("")
                            &&editTextSixValue.getText().toString().trim().equals("")
                            )
                    {
                        Toast.makeText(GCFCalculator.this,"Please provide 1st Six values",Toast.LENGTH_SHORT).show();
                        return;
                    }

                    if(!editTextFirstValue.getText().toString().trim().equals("")&& !editTextSecondValue.getText().toString().trim().equals("")
                            &&editTextThirdValue.getText().toString().trim().equals("")
                            &&editTextFourthValue.getText().toString().trim().equals("")      &&editTextFifthValue.getText().toString().trim().equals("")
                            &&editTextSixValue.getText().toString().trim().equals("")
                            )
                    {
                        Toast.makeText(GCFCalculator.this,"Please provide 1st Six values",Toast.LENGTH_SHORT).show();
                        return;
                    }

                    if(!editTextFirstValue.getText().toString().trim().equals("")&& editTextSecondValue.getText().toString().trim().equals("")
                            &&editTextThirdValue.getText().toString().trim().equals("")
                            &&editTextFourthValue.getText().toString().trim().equals("")      &&editTextFifthValue.getText().toString().trim().equals("")
                            &&editTextSixValue.getText().toString().trim().equals("")
                            )
                    {
                        Toast.makeText(GCFCalculator.this,"Please provide 1st Six values",Toast.LENGTH_SHORT).show();
                        return;
                    }


                    if(!editTextFirstValue.getText().toString().trim().equals("")&& !editTextSecondValue.getText().toString().trim().equals("")
                            &&!editTextThirdValue.getText().toString().trim().equals("")
                            &&!editTextFourthValue.getText().toString().trim().equals("")      &&!editTextFifthValue.getText().toString().trim().equals("")
                            &&!editTextSixValue.getText().toString().trim().equals("")
                            &&!editTextSevenValue.getText().toString().trim().equals("")
                            &&!editTextEightValue.getText().toString().trim().equals("")  )
                    {
                        Toast.makeText(GCFCalculator.this,"Please provide 1st Six values",Toast.LENGTH_SHORT).show();
                    }if(!editTextFirstValue.getText().toString().trim().equals("")&& !editTextSecondValue.getText().toString().trim().equals("")
                            &&!editTextThirdValue.getText().toString().trim().equals("")
                            &&!editTextFourthValue.getText().toString().trim().equals("")      &&!editTextFifthValue.getText().toString().trim().equals("")
                            &&!editTextSixValue.getText().toString().trim().equals("")
                            &&!editTextSevenValue.getText().toString().trim().equals("")
                            &&!editTextEightValue.getText().toString().trim().equals("")
                            &&!editTextNinethValue.getText().toString().trim().equals("")  )
                    {
                        Toast.makeText(GCFCalculator.this,"Please provide 1st Six values",Toast.LENGTH_SHORT).show();
                    }if(!editTextFirstValue.getText().toString().trim().equals("")&& !editTextSecondValue.getText().toString().trim().equals("")
                            &&!editTextThirdValue.getText().toString().trim().equals("")
                            &&!editTextFourthValue.getText().toString().trim().equals("")      &&!editTextFifthValue.getText().toString().trim().equals("")
                            &&!editTextSixValue.getText().toString().trim().equals("")
                            &&!editTextSevenValue.getText().toString().trim().equals("")
                            &&!editTextEightValue.getText().toString().trim().equals("")
                            &&!editTextNinethValue.getText().toString().trim().equals("")
                            &&!editTextTenthValue.getText().toString().trim().equals("")  )
                    {
                        Toast.makeText(GCFCalculator.this,"Please provide 1st Six values",Toast.LENGTH_SHORT).show();
                    }
                    int valueFirst=Integer.parseInt(editTextFirstValue.getText().toString().trim());
                    int valueSecond=Integer.parseInt(editTextSecondValue.getText().toString().trim());
                    int valueThird=Integer.parseInt(editTextThirdValue.getText().toString().trim());
                    int valueFourth=Integer.parseInt(editTextFourthValue.getText().toString().trim());
                    int valueFive=Integer.parseInt(editTextFifthValue.getText().toString().trim());
                    int valueSix=Integer.parseInt(editTextSixValue.getText().toString().trim());


                    editTextFirstValue.setVisibility(View.VISIBLE);
                    editTextSecondValue.setVisibility(View.VISIBLE);

                    editTextThirdValue.setVisibility(View.VISIBLE);
                    editTextFourthValue.setVisibility(View.VISIBLE);
                    editTextFifthValue.setVisibility(View.VISIBLE);
                    editTextSixValue.setVisibility(View.VISIBLE);
                    editTextSevenValue.setVisibility(View.VISIBLE);
                    editTextEightValue.setVisibility(View.VISIBLE);
                    editTextNinethValue.setVisibility(View.VISIBLE);
                    editTextTenthValue.setVisibility(View.VISIBLE);

                    double resultgrossDomesticProductValue = lcmCalci.gcdFour(valueFirst, valueSecond,valueThird,valueFourth,valueFive,valueSix);
                    textViewResult.setText("Greatest Common Factor:" + resultgrossDomesticProductValue);
                }

                else if (editTextAnswerNumber.getText().toString().trim().equals("7")) {



                    if (TextUtils.isEmpty(editTextFirstValue.getText().toString().trim())&& TextUtils.isEmpty(editTextSecondValue.getText().toString().trim())&&
                            TextUtils.isEmpty(editTextThirdValue.getText().toString().trim())
                            && TextUtils.isEmpty(editTextFourthValue.getText().toString().trim())  && TextUtils.isEmpty(editTextFifthValue.getText().toString().trim())
                            && TextUtils.isEmpty(editTextSixValue.getText().toString().trim())
                            && TextUtils.isEmpty(editTextSevenValue.getText().toString().trim()) ) {

                        Toast.makeText(GCFCalculator.this,"Please provide 1st Seven values",Toast.LENGTH_SHORT).show();

                        return;
                    }





                    if(!editTextFirstValue.getText().toString().trim().equals("")&& !editTextSecondValue.getText().toString().trim().equals("")
                            && !editTextThirdValue.getText().toString().trim().equals("")  && !editTextFourthValue.getText().toString().trim().equals("")
                            && !editTextFifthValue.getText().toString().trim().equals("")
                            && !editTextSixValue.getText().toString().trim().equals("")
                            && editTextSevenValue.getText().toString().trim().equals("") )
                    {
                        Toast.makeText(GCFCalculator.this,"Please provide 1st Seven values",Toast.LENGTH_SHORT).show();

                        return;
                    }

                    if(!editTextFirstValue.getText().toString().trim().equals("")&& !editTextSecondValue.getText().toString().trim().equals("")
                            && !editTextThirdValue.getText().toString().trim().equals("")  && !editTextFourthValue.getText().toString().trim().equals("")
                            && !editTextFifthValue.getText().toString().trim().equals("")
                            && editTextSixValue.getText().toString().trim().equals("")
                            && editTextSevenValue.getText().toString().trim().equals("") )
                    {
                        Toast.makeText(GCFCalculator.this,"Please provide 1st Seven values",Toast.LENGTH_SHORT).show();

                        return;
                    }


                    if(!editTextFirstValue.getText().toString().trim().equals("")&& !editTextSecondValue.getText().toString().trim().equals("")
                            && !editTextThirdValue.getText().toString().trim().equals("")  && !editTextFourthValue.getText().toString().trim().equals("")
                            && editTextFifthValue.getText().toString().trim().equals("")
                            && editTextSixValue.getText().toString().trim().equals("")
                            && editTextSevenValue.getText().toString().trim().equals("") )
                    {
                        Toast.makeText(GCFCalculator.this,"Please provide 1st Seven values",Toast.LENGTH_SHORT).show();

                        return;
                    }



                    if(!editTextFirstValue.getText().toString().trim().equals("")&& !editTextSecondValue.getText().toString().trim().equals("")
                            && !editTextThirdValue.getText().toString().trim().equals("")  && editTextFourthValue.getText().toString().trim().equals("")
                            && editTextFifthValue.getText().toString().trim().equals("")
                            && editTextSixValue.getText().toString().trim().equals("")
                            && editTextSevenValue.getText().toString().trim().equals("") )
                    {
                        Toast.makeText(GCFCalculator.this,"Please provide 1st Seven values",Toast.LENGTH_SHORT).show();

                        return;
                    }

                    if(!editTextFirstValue.getText().toString().trim().equals("")&& editTextSecondValue.getText().toString().trim().equals("")
                            && editTextThirdValue.getText().toString().trim().equals("")  && editTextFourthValue.getText().toString().trim().equals("")
                            && editTextFifthValue.getText().toString().trim().equals("")
                            && editTextSixValue.getText().toString().trim().equals("")
                            && editTextSevenValue.getText().toString().trim().equals("") )
                    {
                        Toast.makeText(GCFCalculator.this,"Please provide 1st Seven values",Toast.LENGTH_SHORT).show();

                        return;
                    }


                    if(!editTextFirstValue.getText().toString().trim().equals("")&& editTextSecondValue.getText().toString().trim().equals("")
                            && editTextThirdValue.getText().toString().trim().equals("")  && editTextFourthValue.getText().toString().trim().equals("")
                            && editTextFifthValue.getText().toString().trim().equals("")
                            && editTextSixValue.getText().toString().trim().equals("")
                            && editTextSevenValue.getText().toString().trim().equals("") )
                    {
                        Toast.makeText(GCFCalculator.this,"Please provide 1st Seven values",Toast.LENGTH_SHORT).show();

                        return;
                    }


                    if(!editTextFirstValue.getText().toString().trim().equals("")&& editTextSecondValue.getText().toString().trim().equals("")
                            && editTextThirdValue.getText().toString().trim().equals("")    &&editTextFourthValue.getText().toString().trim().equals("")
                            && editTextFifthValue.getText().toString().trim().equals("")
                            && editTextSixValue.getText().toString().trim().equals("")
                            && editTextSevenValue.getText().toString().trim().equals(""))
                    {
                        Toast.makeText(GCFCalculator.this,"Please provide 1st Seven values",Toast.LENGTH_SHORT).show();
                        return;
                    }

                /*    if(!editTextFirstValue.getText().toString().trim().equals("")&& !editTextSecondValue.getText().toString().trim().equals("")
                            && !editTextThirdValue.getText().toString().trim().equals("")    &&!editTextFourthValue.getText().toString().trim().equals("")
                            &&!editTextFifthValue.getText().toString().trim().equals("")  )
                    {
                        Toast.makeText(MainActivity.this,"Please provide 1st Seven values",Toast.LENGTH_SHORT).show();
                        return;
                    }*/


                    if(!editTextFirstValue.getText().toString().trim().equals("")&& !editTextSecondValue.getText().toString().trim().equals("")
                            && !editTextThirdValue.getText().toString().trim().equals("")   &&!editTextFourthValue.getText().toString().trim().equals("")
                            &&!editTextFifthValue.getText().toString().trim().equals("")   &&!editTextSixValue.getText().toString().trim().equals("")

                            &&editTextSevenValue.getText().toString().trim().equals("") )
                    {
                        Toast.makeText(GCFCalculator.this,"Please provide 1st Seven values",Toast.LENGTH_SHORT).show();
                    }
                    if(!editTextFirstValue.getText().toString().trim().equals("")&& !editTextSecondValue.getText().toString().trim().equals("")
                            && !editTextThirdValue.getText().toString().trim().equals("")
                            &&!editTextFourthValue.getText().toString().trim().equals("")
                            &&!editTextFifthValue.getText().toString().trim().equals("")
                            &&!editTextSixValue.getText().toString().trim().equals("")
                            &&!editTextSevenValue.getText().toString().trim().equals("")
                            &&!editTextEightValue.getText().toString().trim().equals("")  )
                    {
                        Toast.makeText(GCFCalculator.this,"Please provide 1st Seven values",Toast.LENGTH_SHORT).show();
                    }if(!editTextFirstValue.getText().toString().trim().equals("")&& !editTextSecondValue.getText().toString().trim().equals("")
                            && !editTextThirdValue.getText().toString().trim().equals("")
                            &&!editTextFourthValue.getText().toString().trim().equals("")
                            &&!editTextFifthValue.getText().toString().trim().equals("")
                            &&!editTextSixValue.getText().toString().trim().equals("")
                            &&!editTextSevenValue.getText().toString().trim().equals("")
                            &&!editTextEightValue.getText().toString().trim().equals("")   &&!editTextNinethValue.getText().toString().trim().equals("")  )
                    {
                        Toast.makeText(GCFCalculator.this,"Please provide 1st Seven values",Toast.LENGTH_SHORT).show();
                    }

                  /*  if(!editTextFirstValue.getText().toString().trim().equals("")&& !editTextSecondValue.getText().toString().trim().equals("")
                            &&!editTextTenthValue.getText().toString().trim().equals("")  )
                    {
                        Toast.makeText(MainActivity.this,"Please provide 1st Seven values",Toast.LENGTH_SHORT).show();
                    }*/

                    if(!editTextFirstValue.getText().toString().trim().equals("")&& !editTextSecondValue.getText().toString().trim().equals("")
                            && !editTextThirdValue.getText().toString().trim().equals("")
                            &&!editTextFourthValue.getText().toString().trim().equals("")
                            &&!editTextFifthValue.getText().toString().trim().equals("")
                            &&!editTextSixValue.getText().toString().trim().equals("")
                            &&!editTextSevenValue.getText().toString().trim().equals("")
                            &&!editTextEightValue.getText().toString().trim().equals("")
                            )
                    {
                        Toast.makeText(GCFCalculator.this,"Please provide 1st Seven values",Toast.LENGTH_SHORT).show();
                    }

                    if(!editTextFirstValue.getText().toString().trim().equals("")&& !editTextSecondValue.getText().toString().trim().equals("")
                            &&!editTextThirdValue.getText().toString().trim().equals("")
                            &&!editTextFourthValue.getText().toString().trim().equals("")      &&!editTextFifthValue.getText().toString().trim().equals("")
                            &&!editTextSixValue.getText().toString().trim().equals("")
                            &&!editTextSevenValue.getText().toString().trim().equals("")
                            &&!editTextEightValue.getText().toString().trim().equals("")
                            &&!editTextNinethValue.getText().toString().trim().equals("")
                            )
                    {
                        Toast.makeText(GCFCalculator.this,"Please provide 1st Seven values",Toast.LENGTH_SHORT).show();
                    }if(!editTextFirstValue.getText().toString().trim().equals("")&& !editTextSecondValue.getText().toString().trim().equals("")
                            &&!editTextThirdValue.getText().toString().trim().equals("")
                            &&!editTextFourthValue.getText().toString().trim().equals("")      &&!editTextFifthValue.getText().toString().trim().equals("")
                            &&!editTextSixValue.getText().toString().trim().equals("")
                            &&!editTextSevenValue.getText().toString().trim().equals("")
                            &&!editTextEightValue.getText().toString().trim().equals("")
                            &&!editTextNinethValue.getText().toString().trim().equals("")
                            &&!editTextTenthValue.getText().toString().trim().equals("")  )
                    {
                        Toast.makeText(GCFCalculator.this,"Please provide 1st Seven values",Toast.LENGTH_SHORT).show();
                    }


                    int valueFirst=Integer.parseInt(editTextFirstValue.getText().toString().trim());
                    int valueSecond=Integer.parseInt(editTextSecondValue.getText().toString().trim());
                    int valueThird=Integer.parseInt(editTextThirdValue.getText().toString().trim());
                    int valueFourth=Integer.parseInt(editTextFourthValue.getText().toString().trim());
                    int valueFive=Integer.parseInt(editTextFifthValue.getText().toString().trim());
                    int valueSix=Integer.parseInt(editTextSixValue.getText().toString().trim());
                    int valueSeven=Integer.parseInt(editTextSevenValue.getText().toString().trim());


                    editTextFirstValue.setVisibility(View.VISIBLE);
                    editTextSecondValue.setVisibility(View.VISIBLE);

                    editTextThirdValue.setVisibility(View.VISIBLE);
                    editTextFourthValue.setVisibility(View.VISIBLE);
                    editTextFifthValue.setVisibility(View.VISIBLE);
                    editTextSixValue.setVisibility(View.VISIBLE);
                    editTextSevenValue.setVisibility(View.VISIBLE);
                    editTextEightValue.setVisibility(View.VISIBLE);
                    editTextNinethValue.setVisibility(View.VISIBLE);
                    editTextTenthValue.setVisibility(View.VISIBLE);

                    double resultgrossDomesticProductValue = lcmCalci.gcdFive(valueFirst, valueSecond,valueThird,valueFourth,valueFive,valueSix,valueSeven);
                    textViewResult.setText("Greatest Common Factor:" + resultgrossDomesticProductValue);
                }
                else if (editTextAnswerNumber.getText().toString().trim().equals("8")) {


                    if (TextUtils.isEmpty(editTextFirstValue.getText().toString().trim())&& TextUtils.isEmpty(editTextSecondValue.getText().toString().trim())&&
                            TextUtils.isEmpty(editTextThirdValue.getText().toString().trim())
                            && TextUtils.isEmpty(editTextFourthValue.getText().toString().trim())  && TextUtils.isEmpty(editTextFifthValue.getText().toString().trim())
                            && TextUtils.isEmpty(editTextSixValue.getText().toString().trim())
                            && TextUtils.isEmpty(editTextSevenValue.getText().toString().trim())
                            && TextUtils.isEmpty(editTextEightValue.getText().toString().trim())) {

                        Toast.makeText(GCFCalculator.this,"Please provide 1st Eight values",Toast.LENGTH_SHORT).show();

                        return;
                    }

                    if(!editTextFirstValue.getText().toString().trim().equals("")&& !editTextSecondValue.getText().toString().trim().equals("")
                            && !editTextThirdValue.getText().toString().trim().equals("")  && !editTextFourthValue.getText().toString().trim().equals("")
                            && !editTextFifthValue.getText().toString().trim().equals("")
                            && !editTextSixValue.getText().toString().trim().equals("")
                            && !editTextSevenValue.getText().toString().trim().equals("") &&editTextEightValue.getText().toString().trim().equals(""))
                    {
                        Toast.makeText(GCFCalculator.this,"Please provide 1st Eight values",Toast.LENGTH_SHORT).show();

                        return;
                    }

                    if(!editTextFirstValue.getText().toString().trim().equals("")&& !editTextSecondValue.getText().toString().trim().equals("")
                            && !editTextThirdValue.getText().toString().trim().equals("")  && !editTextFourthValue.getText().toString().trim().equals("")
                            && !editTextFifthValue.getText().toString().trim().equals("")
                            && !editTextSixValue.getText().toString().trim().equals("")
                            && editTextSevenValue.getText().toString().trim().equals("") &&editTextEightValue.getText().toString().trim().equals(""))
                    {
                        Toast.makeText(GCFCalculator.this,"Please provide 1st Eight values",Toast.LENGTH_SHORT).show();

                        return;
                    }


                    if(!editTextFirstValue.getText().toString().trim().equals("")&& !editTextSecondValue.getText().toString().trim().equals("")
                            && !editTextThirdValue.getText().toString().trim().equals("")  && !editTextFourthValue.getText().toString().trim().equals("")
                            && !editTextFifthValue.getText().toString().trim().equals("")
                            && editTextSixValue.getText().toString().trim().equals("")
                            && editTextSevenValue.getText().toString().trim().equals("") &&editTextEightValue.getText().toString().trim().equals(""))
                    {
                        Toast.makeText(GCFCalculator.this,"Please provide 1st Eight values",Toast.LENGTH_SHORT).show();

                        return;
                    }


                    if(!editTextFirstValue.getText().toString().trim().equals("")&& !editTextSecondValue.getText().toString().trim().equals("")
                            && !editTextThirdValue.getText().toString().trim().equals("")  && !editTextFourthValue.getText().toString().trim().equals("")
                            && editTextFifthValue.getText().toString().trim().equals("")
                            && editTextSixValue.getText().toString().trim().equals("")
                            && editTextSevenValue.getText().toString().trim().equals("") &&editTextEightValue.getText().toString().trim().equals(""))
                    {
                        Toast.makeText(GCFCalculator.this,"Please provide 1st Eight values",Toast.LENGTH_SHORT).show();

                        return;
                    }



                    if(!editTextFirstValue.getText().toString().trim().equals("")&& !editTextSecondValue.getText().toString().trim().equals("")
                            && !editTextThirdValue.getText().toString().trim().equals("")  && editTextFourthValue.getText().toString().trim().equals("")
                            && editTextFifthValue.getText().toString().trim().equals("")
                            && editTextSixValue.getText().toString().trim().equals("")
                            && editTextSevenValue.getText().toString().trim().equals("") &&editTextEightValue.getText().toString().trim().equals(""))
                    {
                        Toast.makeText(GCFCalculator.this,"Please provide 1st Eight values",Toast.LENGTH_SHORT).show();

                        return;
                    }

                    if(!editTextFirstValue.getText().toString().trim().equals("")&& !editTextSecondValue.getText().toString().trim().equals("")
                            && editTextThirdValue.getText().toString().trim().equals("")  && editTextFourthValue.getText().toString().trim().equals("")
                            && editTextFifthValue.getText().toString().trim().equals("")
                            && editTextSixValue.getText().toString().trim().equals("")
                            && editTextSevenValue.getText().toString().trim().equals("") &&editTextEightValue.getText().toString().trim().equals(""))
                    {
                        Toast.makeText(GCFCalculator.this,"Please provide 1st Eight values",Toast.LENGTH_SHORT).show();

                        return;
                    }


                    if(!editTextFirstValue.getText().toString().trim().equals("")&& editTextSecondValue.getText().toString().trim().equals("")
                            && editTextThirdValue.getText().toString().trim().equals("")  && editTextFourthValue.getText().toString().trim().equals("")
                            && editTextFifthValue.getText().toString().trim().equals("")
                            && editTextSixValue.getText().toString().trim().equals("")
                            && editTextSevenValue.getText().toString().trim().equals("") &&editTextEightValue.getText().toString().trim().equals(""))
                    {
                        Toast.makeText(GCFCalculator.this,"Please provide 1st Eight values",Toast.LENGTH_SHORT).show();

                        return;
                    }
                    if(!editTextFirstValue.getText().toString().trim().equals("")&& !editTextSecondValue.getText().toString().trim().equals("")
                            &&!editTextThirdValue.getText().toString().trim().equals("")
                            &&!editTextFourthValue.getText().toString().trim().equals("")      &&!editTextFifthValue.getText().toString().trim().equals("")
                            &&!editTextSixValue.getText().toString().trim().equals("")
                            &&!editTextSevenValue.getText().toString().trim().equals("")
                            &&!editTextEightValue.getText().toString().trim().equals("")
                            &&!editTextNinethValue.getText().toString().trim().equals("")
                            &&!editTextTenthValue.getText().toString().trim().equals("")  )
                    {
                        Toast.makeText(GCFCalculator.this,"Please provide 1st Eight values",Toast.LENGTH_SHORT).show();
                    }

                    if(!editTextFirstValue.getText().toString().trim().equals("")&& !editTextSecondValue.getText().toString().trim().equals("")
                            &&!editTextThirdValue.getText().toString().trim().equals("")
                            &&!editTextFourthValue.getText().toString().trim().equals("")      &&!editTextFifthValue.getText().toString().trim().equals("")
                            &&!editTextSixValue.getText().toString().trim().equals("")
                            &&!editTextSevenValue.getText().toString().trim().equals("")
                            &&!editTextEightValue.getText().toString().trim().equals("")
                            &&!editTextNinethValue.getText().toString().trim().equals(""))
                    {
                        Toast.makeText(GCFCalculator.this,"Please provide 1st Eight values",Toast.LENGTH_SHORT).show();
                    }


                    int valueFirst=Integer.parseInt(editTextFirstValue.getText().toString().trim());
                    int valueSecond=Integer.parseInt(editTextSecondValue.getText().toString().trim());
                    int valueThird=Integer.parseInt(editTextThirdValue.getText().toString().trim());
                    int valueFourth=Integer.parseInt(editTextFourthValue.getText().toString().trim());
                    int valueFive=Integer.parseInt(editTextFifthValue.getText().toString().trim());
                    int valueSix=Integer.parseInt(editTextSixValue.getText().toString().trim());
                    int valueSeven=Integer.parseInt(editTextSevenValue.getText().toString().trim());
                    int valueEight=Integer.parseInt(editTextEightValue.getText().toString().trim());

                    editTextFirstValue.setVisibility(View.VISIBLE);
                    editTextSecondValue.setVisibility(View.VISIBLE);

                    editTextThirdValue.setVisibility(View.VISIBLE);
                    editTextFourthValue.setVisibility(View.VISIBLE);
                    editTextFifthValue.setVisibility(View.VISIBLE);
                    editTextSixValue.setVisibility(View.VISIBLE);
                    editTextSevenValue.setVisibility(View.VISIBLE);
                    editTextEightValue.setVisibility(View.VISIBLE);
                    editTextNinethValue.setVisibility(View.VISIBLE);
                    editTextTenthValue.setVisibility(View.VISIBLE);

                    double resultgrossDomesticProductValue = lcmCalci.gcdSix(valueFirst, valueSecond,valueThird,valueFourth,valueFive,valueSix,valueSeven,valueEight);
                    textViewResult.setText("Greatest Common Factor::" + resultgrossDomesticProductValue);
                }
                else if (editTextAnswerNumber.getText().toString().trim().equals("9")) {




                    if (TextUtils.isEmpty(editTextFirstValue.getText().toString().trim())&& TextUtils.isEmpty(editTextSecondValue.getText().toString().trim())&&
                            TextUtils.isEmpty(editTextThirdValue.getText().toString().trim())
                            && TextUtils.isEmpty(editTextFourthValue.getText().toString().trim())  && TextUtils.isEmpty(editTextFifthValue.getText().toString().trim())
                            && TextUtils.isEmpty(editTextSixValue.getText().toString().trim())
                            && TextUtils.isEmpty(editTextSevenValue.getText().toString().trim())&& TextUtils.isEmpty(editTextEightValue.getText().toString().trim())&&
                            TextUtils.isEmpty(editTextNinethValue.getText().toString().trim())) {

                        Toast.makeText(GCFCalculator.this,"Please provide 1st Nine values",Toast.LENGTH_SHORT).show();

                        return;
                    }if(!editTextFirstValue.getText().toString().trim().equals("")&& editTextSecondValue.getText().toString().trim().equals("")
                            && editTextThirdValue.getText().toString().trim().equals("")  && editTextFourthValue.getText().toString().trim().equals("")
                            && editTextFifthValue.getText().toString().trim().equals("")
                            && editTextSixValue.getText().toString().trim().equals("")
                            && editTextSevenValue.getText().toString().trim().equals("")
                            &&editTextEightValue.getText().toString().trim().equals("")
                            &&editTextNinethValue.getText().toString().trim().equals(""))
                    {
                        Toast.makeText(GCFCalculator.this,"Please provide 1st Nine values",Toast.LENGTH_SHORT).show();

                        return;
                    }

                    if(!editTextFirstValue.getText().toString().trim().equals("")&& !editTextSecondValue.getText().toString().trim().equals("")
                            && editTextThirdValue.getText().toString().trim().equals("")  && editTextFourthValue.getText().toString().trim().equals("")
                            && editTextFifthValue.getText().toString().trim().equals("")
                            && editTextSixValue.getText().toString().trim().equals("")
                            && editTextSevenValue.getText().toString().trim().equals("")
                            &&editTextEightValue.getText().toString().trim().equals("")
                            &&editTextNinethValue.getText().toString().trim().equals(""))
                    {
                        Toast.makeText(GCFCalculator.this,"Please provide 1st Nine values",Toast.LENGTH_SHORT).show();

                        return;
                    }
                    if(!editTextFirstValue.getText().toString().trim().equals("")&& !editTextSecondValue.getText().toString().trim().equals("")
                            && !editTextThirdValue.getText().toString().trim().equals("")  && editTextFourthValue.getText().toString().trim().equals("")
                            && editTextFifthValue.getText().toString().trim().equals("")
                            && editTextSixValue.getText().toString().trim().equals("")
                            && editTextSevenValue.getText().toString().trim().equals("")
                            &&editTextEightValue.getText().toString().trim().equals("")
                            &&editTextNinethValue.getText().toString().trim().equals(""))
                    {
                        Toast.makeText(GCFCalculator.this,"Please provide 1st Nine values",Toast.LENGTH_SHORT).show();

                        return;
                    }
                    if(!editTextFirstValue.getText().toString().trim().equals("")&& !editTextSecondValue.getText().toString().trim().equals("")
                            && !editTextThirdValue.getText().toString().trim().equals("")  && !editTextFourthValue.getText().toString().trim().equals("")
                            && editTextFifthValue.getText().toString().trim().equals("")
                            && editTextSixValue.getText().toString().trim().equals("")
                            && editTextSevenValue.getText().toString().trim().equals("")
                            &&editTextEightValue.getText().toString().trim().equals("")
                            &&editTextNinethValue.getText().toString().trim().equals(""))
                    {
                        Toast.makeText(GCFCalculator.this,"Please provide 1st Nine values",Toast.LENGTH_SHORT).show();

                        return;
                    }

                    if(!editTextFirstValue.getText().toString().trim().equals("")&& !editTextSecondValue.getText().toString().trim().equals("")
                            && !editTextThirdValue.getText().toString().trim().equals("")  && !editTextFourthValue.getText().toString().trim().equals("")
                            && !editTextFifthValue.getText().toString().trim().equals("")
                            && editTextSixValue.getText().toString().trim().equals("")
                            && editTextSevenValue.getText().toString().trim().equals("")
                            && editTextEightValue.getText().toString().trim().equals("")
                            && editTextNinethValue.getText().toString().trim().equals(""))
                    {
                        Toast.makeText(GCFCalculator.this,"Please provide 1st Nine values",Toast.LENGTH_SHORT).show();

                        return;
                    }


                    if(!editTextFirstValue.getText().toString().trim().equals("")&& !editTextSecondValue.getText().toString().trim().equals("")
                            && !editTextThirdValue.getText().toString().trim().equals("")  && !editTextFourthValue.getText().toString().trim().equals("")
                            && !editTextFifthValue.getText().toString().trim().equals("")
                            && !editTextSixValue.getText().toString().trim().equals("")
                            && editTextSevenValue.getText().toString().trim().equals("")
                            && editTextEightValue.getText().toString().trim().equals("")
                            && editTextNinethValue.getText().toString().trim().equals(""))
                    {
                        Toast.makeText(GCFCalculator.this,"Please provide 1st Nine values",Toast.LENGTH_SHORT).show();

                        return;
                    }
                    if(!editTextFirstValue.getText().toString().trim().equals("")&& !editTextSecondValue.getText().toString().trim().equals("")
                            && !editTextThirdValue.getText().toString().trim().equals("")  && !editTextFourthValue.getText().toString().trim().equals("")
                            && !editTextFifthValue.getText().toString().trim().equals("")
                            && !editTextSixValue.getText().toString().trim().equals("")
                            && !editTextSevenValue.getText().toString().trim().equals("")
                            && editTextEightValue.getText().toString().trim().equals("")
                            &&  editTextNinethValue.getText().toString().trim().equals(""))
                    {
                        Toast.makeText(GCFCalculator.this,"Please provide 1st Nine values",Toast.LENGTH_SHORT).show();

                        return;
                    }
                    if(!editTextFirstValue.getText().toString().trim().equals("")&& !editTextSecondValue.getText().toString().trim().equals("")
                            && !editTextThirdValue.getText().toString().trim().equals("")  && !editTextFourthValue.getText().toString().trim().equals("")
                            && !editTextFifthValue.getText().toString().trim().equals("")
                            && !editTextSixValue.getText().toString().trim().equals("")
                            && !editTextSevenValue.getText().toString().trim().equals("")
                            && !editTextEightValue.getText().toString().trim().equals("")
                            &&  editTextNinethValue.getText().toString().trim().equals(""))
                    {
                        Toast.makeText(GCFCalculator.this,"Please provide 1st Nine values",Toast.LENGTH_SHORT).show();

                        return;
                    }



                    int valueFirst=Integer.parseInt(editTextFirstValue.getText().toString().trim());
                    int valueSecond=Integer.parseInt(editTextSecondValue.getText().toString().trim());
                    int valueThird=Integer.parseInt(editTextThirdValue.getText().toString().trim());
                    int valueFourth=Integer.parseInt(editTextFourthValue.getText().toString().trim());
                    int valueFive=Integer.parseInt(editTextFifthValue.getText().toString().trim());
                    int valueSix=Integer.parseInt(editTextSixValue.getText().toString().trim());
                    int valueSeven=Integer.parseInt(editTextSevenValue.getText().toString().trim());
                    int valueEight=Integer.parseInt(editTextEightValue.getText().toString().trim());
                    int valueNine=Integer.parseInt(editTextNinethValue.getText().toString().trim());

                    editTextFirstValue.setVisibility(View.VISIBLE);
                    editTextSecondValue.setVisibility(View.VISIBLE);

                    editTextThirdValue.setVisibility(View.VISIBLE);
                    editTextFourthValue.setVisibility(View.VISIBLE);
                    editTextFifthValue.setVisibility(View.VISIBLE);
                    editTextSixValue.setVisibility(View.VISIBLE);
                    editTextSevenValue.setVisibility(View.VISIBLE);
                    editTextEightValue.setVisibility(View.VISIBLE);
                    editTextNinethValue.setVisibility(View.VISIBLE);
                    editTextTenthValue.setVisibility(View.VISIBLE);

                    double resultgrossDomesticProductValue = lcmCalci.gcdSeven(valueFirst, valueSecond,valueThird,valueFourth,valueFive,valueSix,valueSeven,valueEight,valueNine);
                    textViewResult.setText("Greatest Common Factor:" + resultgrossDomesticProductValue);
                }
                else if (editTextAnswerNumber.getText().toString().trim().equals("10")) {
                    if (TextUtils.isEmpty(editTextFirstValue.getText().toString().trim())&& TextUtils.isEmpty(editTextSecondValue.getText().toString().trim())&&
                            TextUtils.isEmpty(editTextThirdValue.getText().toString().trim())
                            && TextUtils.isEmpty(editTextFourthValue.getText().toString().trim())  && TextUtils.isEmpty(editTextFifthValue.getText().toString().trim())
                            && TextUtils.isEmpty(editTextSixValue.getText().toString().trim())
                            && TextUtils.isEmpty(editTextSevenValue.getText().toString().trim())&& TextUtils.isEmpty(editTextEightValue.getText().toString().trim())&&
                            TextUtils.isEmpty(editTextNinethValue.getText().toString().trim())
                            &&  TextUtils.isEmpty(editTextNinethValue.getText().toString().trim())) {

                        Toast.makeText(GCFCalculator.this,"Please provide 1st Ten values",Toast.LENGTH_SHORT).show();

                        return;
                    }

                    if(!editTextFirstValue.getText().toString().trim().equals("")&& !editTextSecondValue.getText().toString().trim().equals("")
                            && !editTextThirdValue.getText().toString().trim().equals("")  && !editTextFourthValue.getText().toString().trim().equals("")
                            && !editTextFifthValue.getText().toString().trim().equals("")
                            && !editTextSixValue.getText().toString().trim().equals("")
                            && !editTextSevenValue.getText().toString().trim().equals("")
                            && !editTextEightValue.getText().toString().trim().equals("")
                            &&  !editTextNinethValue.getText().toString().trim().equals("")
                            &&  editTextTenthValue.getText().toString().trim().equals(""))
                    {
                        Toast.makeText(GCFCalculator.this,"Please provide 1st Ten values",Toast.LENGTH_SHORT).show();

                        return;
                    }

                    if(!editTextFirstValue.getText().toString().trim().equals("")&& !editTextSecondValue.getText().toString().trim().equals("")
                            && !editTextThirdValue.getText().toString().trim().equals("")  && !editTextFourthValue.getText().toString().trim().equals("")
                            && !editTextFifthValue.getText().toString().trim().equals("")
                            && !editTextSixValue.getText().toString().trim().equals("")
                            && !editTextSevenValue.getText().toString().trim().equals("")
                            && !editTextEightValue.getText().toString().trim().equals("")
                            &&  editTextNinethValue.getText().toString().trim().equals("")
                            &&  editTextTenthValue.getText().toString().trim().equals(""))
                    {
                        Toast.makeText(GCFCalculator.this,"Please provide 1st Ten values",Toast.LENGTH_SHORT).show();

                        return;
                    }
                    if(!editTextFirstValue.getText().toString().trim().equals("")&& !editTextSecondValue.getText().toString().trim().equals("")
                            && !editTextThirdValue.getText().toString().trim().equals("")  && !editTextFourthValue.getText().toString().trim().equals("")
                            && !editTextFifthValue.getText().toString().trim().equals("")
                            && !editTextSixValue.getText().toString().trim().equals("")
                            && editTextSevenValue.getText().toString().trim().equals("")
                            && editTextEightValue.getText().toString().trim().equals("")
                            &&  editTextNinethValue.getText().toString().trim().equals("")
                            &&  editTextTenthValue.getText().toString().trim().equals(""))
                    {
                        Toast.makeText(GCFCalculator.this,"Please provide 1st Ten values",Toast.LENGTH_SHORT).show();

                        return;
                    }

                    if(!editTextFirstValue.getText().toString().trim().equals("")&& !editTextSecondValue.getText().toString().trim().equals("")
                            && !editTextThirdValue.getText().toString().trim().equals("")  && !editTextFourthValue.getText().toString().trim().equals("")
                            && !editTextFifthValue.getText().toString().trim().equals("")
                            &&editTextSixValue.getText().toString().trim().equals("")
                            && editTextSevenValue.getText().toString().trim().equals("")
                            && editTextEightValue.getText().toString().trim().equals("")
                            &&  editTextNinethValue.getText().toString().trim().equals("")
                            &&  editTextTenthValue.getText().toString().trim().equals(""))
                    {
                        Toast.makeText(GCFCalculator.this,"Please provide 1st Ten values",Toast.LENGTH_SHORT).show();

                        return;
                    } if(!editTextFirstValue.getText().toString().trim().equals("")&& !editTextSecondValue.getText().toString().trim().equals("")
                            && !editTextThirdValue.getText().toString().trim().equals("")  && !editTextFourthValue.getText().toString().trim().equals("")
                            && editTextFifthValue.getText().toString().trim().equals("")
                            && editTextSixValue.getText().toString().trim().equals("")
                            && editTextSevenValue.getText().toString().trim().equals("")
                            && editTextEightValue.getText().toString().trim().equals("")
                            &&  editTextNinethValue.getText().toString().trim().equals("")
                            &&  editTextTenthValue.getText().toString().trim().equals(""))
                    {
                        Toast.makeText(GCFCalculator.this,"Please provide 1st Ten values",Toast.LENGTH_SHORT).show();

                        return;
                    }
                    if(!editTextFirstValue.getText().toString().trim().equals("")&& !editTextSecondValue.getText().toString().trim().equals("")
                            && !editTextThirdValue.getText().toString().trim().equals("")  && editTextFourthValue.getText().toString().trim().equals("")
                            && editTextFifthValue.getText().toString().trim().equals("")
                            && editTextSixValue.getText().toString().trim().equals("")
                            && editTextSevenValue.getText().toString().trim().equals("")
                            && editTextEightValue.getText().toString().trim().equals("")
                            &&  editTextNinethValue.getText().toString().trim().equals("")
                            &&  editTextTenthValue.getText().toString().trim().equals(""))
                    {
                        Toast.makeText(GCFCalculator.this,"Please provide 1st Ten values",Toast.LENGTH_SHORT).show();

                        return;
                    }

                    if(!editTextFirstValue.getText().toString().trim().equals("")&& !editTextSecondValue.getText().toString().trim().equals("")
                            && editTextThirdValue.getText().toString().trim().equals("")  && editTextFourthValue.getText().toString().trim().equals("")
                            && editTextFifthValue.getText().toString().trim().equals("")
                            && editTextSixValue.getText().toString().trim().equals("")
                            && editTextSevenValue.getText().toString().trim().equals("")
                            && editTextEightValue.getText().toString().trim().equals("")
                            &&  editTextNinethValue.getText().toString().trim().equals("")
                            &&  editTextTenthValue.getText().toString().trim().equals(""))
                    {
                        Toast.makeText(GCFCalculator.this,"Please provide 1st Ten values",Toast.LENGTH_SHORT).show();

                        return;
                    }

                    if(!editTextFirstValue.getText().toString().trim().equals("")&& editTextSecondValue.getText().toString().trim().equals("")
                            && editTextThirdValue.getText().toString().trim().equals("")  && editTextFourthValue.getText().toString().trim().equals("")
                            && editTextFifthValue.getText().toString().trim().equals("")
                            && editTextSixValue.getText().toString().trim().equals("")
                            && editTextSevenValue.getText().toString().trim().equals("")
                            && editTextEightValue.getText().toString().trim().equals("")
                            &&  editTextNinethValue.getText().toString().trim().equals("")
                            &&  editTextTenthValue.getText().toString().trim().equals(""))
                    {
                        Toast.makeText(GCFCalculator.this,"Please provide 1st Ten values",Toast.LENGTH_SHORT).show();

                        return;
                    }
                    int valueFirst=Integer.parseInt(editTextFirstValue.getText().toString().trim());
                    int valueSecond=Integer.parseInt(editTextSecondValue.getText().toString().trim());
                    int valueThird=Integer.parseInt(editTextThirdValue.getText().toString().trim());
                    int valueFourth=Integer.parseInt(editTextFourthValue.getText().toString().trim());
                    int valueFive=Integer.parseInt(editTextFifthValue.getText().toString().trim());
                    int valueSix=Integer.parseInt(editTextSixValue.getText().toString().trim());
                    int valueSeven=Integer.parseInt(editTextSevenValue.getText().toString().trim());
                    int valueEight=Integer.parseInt(editTextEightValue.getText().toString().trim());
                    int valueNine=Integer.parseInt(editTextNinethValue.getText().toString().trim());
                    int valueTen=Integer.parseInt(editTextTenthValue.getText().toString().trim());

                    editTextFirstValue.setVisibility(View.VISIBLE);
                    editTextSecondValue.setVisibility(View.VISIBLE);

                    editTextThirdValue.setVisibility(View.VISIBLE);
                    editTextFourthValue.setVisibility(View.VISIBLE);
                    editTextFifthValue.setVisibility(View.VISIBLE);
                    editTextSixValue.setVisibility(View.VISIBLE);
                    editTextSevenValue.setVisibility(View.VISIBLE);
                    editTextEightValue.setVisibility(View.VISIBLE);
                    editTextNinethValue.setVisibility(View.VISIBLE);
                    editTextTenthValue.setVisibility(View.VISIBLE);

                    double resultgrossDomesticProductValue = lcmCalci.gcdEight(valueFirst, valueSecond,valueThird,valueFourth,valueFive,valueSix,valueSeven,valueEight,valueNine,valueTen);
                    textViewResult.setText("Greatest Common Factor::" + resultgrossDomesticProductValue);
                }


                else{

                }
            }
        });
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editTextFirstValue.setText("");
                editTextSecondValue.setText("");
                editTextThirdValue.setText("");
                editTextFourthValue.setText("");
                editTextFifthValue.setText("");
                editTextSixValue.setText("");
                editTextSevenValue.setText("");
                editTextEightValue.setText("");
                editTextNinethValue.setText("");
                editTextTenthValue.setText("");
                textViewResult.setText("");
                editTextAnswerNumber.setText("");
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
            Intent intent=new Intent(GCFCalculator.this,MainActivity.class);
            //    finish();
            startActivity(intent);


        }


        return super.onOptionsItemSelected(item);
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch(keyCode){
            case KeyEvent.KEYCODE_BACK:

                Intent intent=new Intent(GCFCalculator.this,MainActivity.class);
                finish();
                startActivity(intent);

                return true;
        }
        return super.onKeyDown(keyCode, event);
    }

}

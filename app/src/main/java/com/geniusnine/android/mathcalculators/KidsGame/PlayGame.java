package com.geniusnine.android.mathcalculators.KidsGame;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.geniusnine.android.mathcalculators.R;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Random;


public class
PlayGame extends AppCompatActivity implements OnClickListener {

    //gameplay elements
    private int level = 0, answer = 0, operator = 0, operand1 = 0, operand2 = 0;
    //operator constants
    private final int ADD_OPERATOR = 0, SUBTRACT_OPERATOR = 1, MULTIPLY_OPERATOR = 2,
            DIVIDE_OPERATOR = 3;
    //operator text
    private String[] operators = {"+", "-", "x", "/"};
    //min and max for each level and operator
    private int[][] levelMin = {
            {1, 11, 21},
            {1, 5, 10},
            {2, 5, 10},
            {2, 3, 5}};
    private int[][] levelMax = {
            {10, 25, 50},
            {10, 20, 30},
            {5, 10, 15},
            {10, 50, 100}};
    //random number generator
    private Random random;
    //ui elements
    private TextView question, answerTxt, scoreTxt;
    private ImageView response;
    private Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn0,
            enterBtn, clearBtn;

    //shared preferences
    private SharedPreferences gamePrefs;
    public static final String GAME_PREFS = "ArithmeticFile";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_game);
        gamePrefs = getSharedPreferences(GAME_PREFS, 0);

        //text and image views
        question = (TextView)findViewById(R.id.question);
        answerTxt = (TextView)findViewById(R.id.answer);
        response = (ImageView)findViewById(R.id.response);
        scoreTxt = (TextView)findViewById(R.id.score);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        response.setVisibility(View.INVISIBLE);

        btn1 = (Button)findViewById(R.id.btn1);
        btn2 = (Button)findViewById(R.id.btn2);
        btn3 = (Button)findViewById(R.id.btn3);
        btn4 = (Button)findViewById(R.id.btn4);
        btn5 = (Button)findViewById(R.id.btn5);
        btn6 = (Button)findViewById(R.id.btn6);
        btn7 = (Button)findViewById(R.id.btn7);
        btn8 = (Button)findViewById(R.id.btn8);
        btn9 = (Button)findViewById(R.id.btn9);
        btn0 = (Button)findViewById(R.id.btn0);
        enterBtn = (Button)findViewById(R.id.enter);
        clearBtn = (Button)findViewById(R.id.clear);


        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);
        btn0.setOnClickListener(this);
        enterBtn.setOnClickListener(this);
        clearBtn.setOnClickListener(this);

        if(savedInstanceState!=null){
            //saved instance state data
            level=savedInstanceState.getInt("level");
            int exScore = savedInstanceState.getInt("score");
            scoreTxt.setText("Score: "+exScore);
        }
        else{
            //get passed level number
            Bundle extras = getIntent().getExtras();
            if(extras !=null)
            {
                int passedLevel = extras.getInt("level", -1);
                if(passedLevel>=0) level = passedLevel;
            }
        }


        random = new Random();

        chooseQuestion();
    }

    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.enter){
            //enter button
            //get answer
            String answerContent = answerTxt.getText().toString();
            //check we have an answer
            if(!answerContent.endsWith("?")){
                //get number
                int enteredAnswer = Integer.parseInt(answerContent.substring(2));
                //get score
                int exScore = getScore();
                //check answer
                if(enteredAnswer==answer){
                    //correct
                    scoreTxt.setText("Score: "+(exScore+1));
                    response.setImageResource(R.drawable.tick);
                    response.setVisibility(View.VISIBLE);
                }
                else{
                    //set high score
                    setHighScore();
                    //incorrect
                    scoreTxt.setText("Score: 0");
                    response.setImageResource(R.drawable.cross);
                    response.setVisibility(View.VISIBLE);
                }
                chooseQuestion();
            }
        }
        else if(view.getId()==R.id.clear){
            //clear button
            answerTxt.setText("= ?");
        }
        else {
            //number button
            response.setVisibility(View.INVISIBLE);
            //get number from tag
            int enteredNum = Integer.parseInt(view.getTag().toString());
            //either first or subsequent digit
            if(answerTxt.getText().toString().endsWith("?"))
                answerTxt.setText("= "+enteredNum);
            else
                answerTxt.append(""+enteredNum);
        }
    }

    //method retrieves score
    private int getScore(){
        String scoreStr = scoreTxt.getText().toString();
        return Integer.parseInt(scoreStr.substring(scoreStr.lastIndexOf(" ")+1));
    }

    //method generates questions
    private void chooseQuestion(){
        //reset answer text
        answerTxt.setText("= ?");
        //choose operator
        operator = random.nextInt(operators.length);
        //choose operands
        operand1 = getOperand();
        operand2 = getOperand();


        if(operator==SUBTRACT_OPERATOR){
            //no negative answers
            while(operand2>operand1){
                operand1 = getOperand();
                operand2 = getOperand();
            }
        }
        else if(operator==DIVIDE_OPERATOR){
            //whole numbers only
            while((((double)operand1/(double)operand2)%1 > 0)
                    || (operand1==operand2)){
                operand1 = getOperand();
                operand2 = getOperand();
            }
        }


        switch(operator){
            case ADD_OPERATOR:
                answer = operand1+operand2;
                break;
            case SUBTRACT_OPERATOR:
                answer = operand1-operand2;
                break;
            case MULTIPLY_OPERATOR:
                answer = operand1*operand2;
                break;
            case DIVIDE_OPERATOR:
                answer = operand1/operand2;
                break;
            default:
                break;
        }


        question.setText(operand1+" "+operators[operator]+" "+operand2);
    }


    private int getOperand(){
        return random.nextInt(levelMax[operator][level] - levelMin[operator][level] + 1)
                + levelMin[operator][level];
    }


    private void setHighScore(){
        int exScore = getScore();
        if(exScore>0){
            //we have a valid score
            SharedPreferences.Editor scoreEdit = gamePrefs.edit();
            DateFormat dateForm = new SimpleDateFormat("dd MMMM yyyy");
            String dateOutput = dateForm.format(new Date());
            //get existing scores
            String scores = gamePrefs.getString("highScores", "");
            //check for scores
            if(scores.length()>0){
                //we have existing scores
                List<Score> scoreStrings = new ArrayList<Score>();
                //split scores
                String[] exScores = scores.split("\\|");
                //add score object for each
                for(String eSc : exScores){
                    String[] parts = eSc.split(" - ");
                    scoreStrings.add(new Score(parts[0], Integer.parseInt(parts[1])));
                }
                //new score
                Score newScore = new Score(dateOutput, exScore);
                scoreStrings.add(newScore);
                //sort
                Collections.sort(scoreStrings);
                //get top ten
                StringBuilder scoreBuild = new StringBuilder("");
                for(int s=0; s<scoreStrings.size(); s++){
                    if(s>=10) break;
                    if(s>0) scoreBuild.append("|");
                    scoreBuild.append(scoreStrings.get(s).getScoreText());
                }
                //write to prefs
                scoreEdit.putString("highScores", scoreBuild.toString());
                scoreEdit.commit();

            }
            else{
                //no existing scores
                scoreEdit.putString("highScores", ""+dateOutput+" - "+exScore);
                scoreEdit.commit();
            }
        }
    }

    //set high score if activity destroyed
    protected void onDestroy(){
        setHighScore();
        super.onDestroy();
    }

    //save instance state
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        //save score and level
        int exScore = getScore();
        savedInstanceState.putInt("score", exScore);
        savedInstanceState.putInt("level", level);
        //superclass method
        super.onSaveInstanceState(savedInstanceState);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch (item.getItemId()) {
            case android.R.id.home:
                Intent i = new Intent(this, Home.class);
                finish();
                startActivity(i);

                // app icon in action bar clicked; goto parent activity.

                return true;
            default:
                return super.onOptionsItemSelected(item);

        }
    }
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch (keyCode) {
            case KeyEvent.KEYCODE_BACK:

                Intent intent = new Intent(this, Home.class);
                finish();
                startActivity(intent);

                return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}

package com.geniusnine.android.mathcalculators.KidsGame;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.geniusnine.android.mathcalculators.MainActivity;
import com.geniusnine.android.mathcalculators.R;

public class Home extends AppCompatActivity implements View.OnClickListener {
    private Button playBtn, helpBtn, highBtn;
    //level names
    String[] levelNames = {"Easy", "Medium", "Hard"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        playBtn = (Button)findViewById(R.id.play_btn);
        helpBtn = (Button)findViewById(R.id.help_btn);
        highBtn = (Button)findViewById(R.id.high_btn);

        //listen for clicks
        playBtn.setOnClickListener(this);
        helpBtn.setOnClickListener(this);
        highBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.play_btn){
            //play button
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Choose a level")
                    .setSingleChoiceItems(levelNames, 0, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                            //start gameplay
                            startPlay(which);
                        }
                    });
            AlertDialog ad = builder.create();
            ad.show();
        }
        else if(view.getId()==R.id.help_btn){
            //how to play button
            Intent helpIntent = new Intent(this, HowToPlay.class);
            finish();
            this.startActivity(helpIntent);
        }
        else if(view.getId()==R.id.high_btn){
            //high scores button
            Intent highIntent = new Intent(this, HighScore.class);
            finish();
            this.startActivity(highIntent);
        }
    }
    private void startPlay(int chosenLevel){
        //start gameplay
        Intent playIntent = new Intent(this, PlayGame.class);
        finish();
        playIntent.putExtra("level", chosenLevel);
        this.startActivity(playIntent);
    }
  /*  @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }*/

   /* @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }*/

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch (item.getItemId()) {
            case android.R.id.home:
                Intent i = new Intent(this, MainActivity.class);
                this.finish( );
                startActivity(i);

                // app icon in action bar clicked; goto parent activity.

                return true;
            default:
                return super.onOptionsItemSelected(item);

        }


    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch(keyCode){
            case KeyEvent.KEYCODE_BACK:

                Intent intent=new Intent(this,MainActivity.class);
                finish();
                startActivity(intent);

                return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}

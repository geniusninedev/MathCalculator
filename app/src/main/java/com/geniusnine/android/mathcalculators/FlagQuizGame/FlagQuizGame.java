package com.geniusnine.android.mathcalculators.FlagQuizGame;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.graphics.Point;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.Display;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.Toast;

import com.geniusnine.android.mathcalculators.MainActivity;
import com.geniusnine.android.mathcalculators.R;

import java.util.Set;

public class FlagQuizGame extends AppCompatActivity {
    public static final String CHOICES = "pref_numberOfChoices";
    public static final String REGIONS = "pref_regionsToInclude";

    private boolean phoneDevice = true; // used to force portrait mode
    private boolean preferencesChanged = true; // did preferences change?

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_flag_quiz_game);

        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);

        PreferenceManager.setDefaultValues(this, R.xml.preferences, false);


        PreferenceManager.getDefaultSharedPreferences(this).
                registerOnSharedPreferenceChangeListener(
                        preferenceChangeListener);

        int screenSize = getResources().getConfiguration().screenLayout &
                Configuration.SCREENLAYOUT_SIZE_MASK;


        if (screenSize == Configuration.SCREENLAYOUT_SIZE_LARGE ||
                screenSize == Configuration.SCREENLAYOUT_SIZE_XLARGE)
            phoneDevice = false; // not a phone-sized device

        if (phoneDevice)
            setRequestedOrientation(
                    ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }

    @Override
    protected void onStart() {
        super.onStart();

        if (preferencesChanged) {

            QuizFragment quizFragment = (QuizFragment) getFragmentManager().findFragmentById(R.id.quizFragment);
            quizFragment.updateGuessRows(PreferenceManager.getDefaultSharedPreferences(this));
            quizFragment.updateRegions(PreferenceManager.getDefaultSharedPreferences(this));
            quizFragment.resetQuiz();
            preferencesChanged = false;
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // get the default Display object representing the screen
        Display display = ((WindowManager)
                getSystemService(WINDOW_SERVICE)).getDefaultDisplay();
        Point screenSize = new Point(); // used to store screen size
        display.getRealSize(screenSize); // store size in screenSize

        // display the app's menu only in portrait orientation
        if (screenSize.x < screenSize.y) // x is width, y is height
        {
            getMenuInflater().inflate(R.menu.menu_main, menu); // inflate the menu
            return true;
        } else

            return false;

    } // end method onCreateOptionsMenu

    // displays SettingsActivity when running on a phone
  /*  @Override
    public boolean onOptionsItemSelected(MenuItem item) {


        //noinspection SimplifiableIfStatement

        //noinspection SimplifiableIfStatement
        switch (item.getItemId()) {
            case android.R.id.home:

                Intent intent = new Intent(this, MainActivity.class);
                finish();
                startActivity(intent);


            default:
                if (id == R.id.action_settings) {
                    Intent preferencesIntent = new Intent(this, SettingsActivity.class);
                    startActivity(preferencesIntent);
                    return super.onOptionsItemSelected(item);
                }
                return super.onOptionsItemSelected(item);

        }

    }*/
   /* @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
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
                if (id == R.id.action_settings) {
                    Intent preferencesIntent = new Intent(this, SettingsActivity.class);
                    startActivity(preferencesIntent);
                    return super.onOptionsItemSelected(item);
                }
                return super.onOptionsItemSelected(item);

        }
    }*/

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
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
                if (id == R.id.action_settings) {
                    Intent preferencesIntent = new Intent(this, SettingsActivity.class);
                    startActivity(preferencesIntent);
                    return super.onOptionsItemSelected(item);
                }
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


    private SharedPreferences.OnSharedPreferenceChangeListener preferenceChangeListener =
            new SharedPreferences.OnSharedPreferenceChangeListener()
            {

                @Override
                public void onSharedPreferenceChanged(
                        SharedPreferences sharedPreferences, String key)
                {
                    preferencesChanged = true;

                    QuizFragment quizFragment = (QuizFragment)
                            getFragmentManager().findFragmentById(R.id.quizFragment);

                    if (key.equals(CHOICES))
                    {
                        quizFragment.updateGuessRows(sharedPreferences);
                        quizFragment.resetQuiz();
                    }
                    else if (key.equals(REGIONS))
                    {
                        Set<String> regions =
                                sharedPreferences.getStringSet(REGIONS, null);

                        if (regions != null && regions.size() > 0)
                        {
                            quizFragment.updateRegions(sharedPreferences);
                            quizFragment.resetQuiz();
                        }
                        else
                        {
                            SharedPreferences.Editor editor = sharedPreferences.edit();
                            regions.add(
                                    getResources().getString(R.string.default_region));
                            editor.putStringSet(REGIONS, regions);
                            editor.commit();
                            Toast.makeText(FlagQuizGame.this,
                                    R.string.default_region_message,
                                    Toast.LENGTH_SHORT).show();
                        }
                    }

                  //  Toast.makeText(getApplicationContext(),"Quiz will restart with your new settings" ,Toast.LENGTH_SHORT).show();
                }
            };

}

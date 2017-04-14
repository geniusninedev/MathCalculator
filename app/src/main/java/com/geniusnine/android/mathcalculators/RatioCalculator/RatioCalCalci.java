package com.geniusnine.android.mathcalculators.RatioCalculator;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.geniusnine.android.mathcalculators.MainActivity;
import com.geniusnine.android.mathcalculators.R;

/**
 * Created by Dev on 12-04-2017.
 */

public class RatioCalCalci extends AppCompatActivity  implements TabLayout.OnTabSelectedListener {
    private TabLayout tabLayout;

    //This is our viewPager

    FrameLayout simpleFrameLayout;
    private FragmentPagerAdapter mPagerAdapter;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ratiocal_calci);




            //Initializing the tablayout
            mPagerAdapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
                private final Fragment[] mFragments = new Fragment[] {
                        new RatioCalculator(),
                        new RatioScalingCalculator(),
                };
                private final String[] mFragmentNames = new String[] {
                        getString(R.string.app_name8),
                        getString(R.string.app_name16)
                };
                @Override
                public Fragment getItem(int position) {
                    return mFragments[position];
                }
                @Override
                public int getCount() {
                    return mFragments.length;
                }

                public CharSequence getPageTitle(int position) {
                    return mFragmentNames[position];
                }

            };

            viewPager = (ViewPager) findViewById(R.id.pager);
            viewPager.setAdapter(mPagerAdapter);
            TabLayout tabLayout = (TabLayout) findViewById(R.id.tabLayoutratio);
            tabLayout.setupWithViewPager(viewPager);
        simpleFrameLayout = (FrameLayout) findViewById(R.id.simpleFrameLayout);


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
            Intent intent=new Intent(RatioCalCalci.this,MainActivity.class);
            //    finish();
            startActivity(intent);


        }


        return super.onOptionsItemSelected(item);
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch(keyCode){
            case KeyEvent.KEYCODE_BACK:

                Intent intent=new Intent(RatioCalCalci.this,MainActivity.class);
                finish();
                startActivity(intent);

                return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }
}




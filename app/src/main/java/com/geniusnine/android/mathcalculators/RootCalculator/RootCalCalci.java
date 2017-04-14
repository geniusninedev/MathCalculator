package com.geniusnine.android.mathcalculators.RootCalculator;

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

public class RootCalCalci extends AppCompatActivity {
    private TabLayout tabLayout;
    FrameLayout simpleFrameLayout;
    //This is our viewPager

    private FragmentPagerAdapter mPagerAdapter;
    private ViewPager viewPager;




        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_rootcal_calci);


            //Initializing the tablayout
            mPagerAdapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
                private final Fragment[] mFragments = new Fragment[] {
                        new RootCalculator(),
                        new SquareRootCalculator(),new CubeRootCalculator()
                };
                private final String[] mFragmentNames = new String[] {
                        getString(R.string.app_name93),
                        getString(R.string.app_name19),
                        getString(R.string.app_name20),
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
            TabLayout tabLayout = (TabLayout) findViewById(R.id.tabLayoutRoot);
            tabLayout.setupWithViewPager(viewPager);



        }






    /*    TabLayout.Tab firstTab = tabLayout.newTab();
        firstTab.setText("Root Calculator"); // set the Text for the first Tab
        // set an icon for the
// first tab
        tabLayout.addTab(firstTab); // add  the tab at in the TabLayout
// Create a new Tab named "Second"
        TabLayout.Tab secondTab = tabLayout.newTab();
        secondTab.setText("Square Root Calculator"); // set the Text for the second Tab
        // set an icon for the second tab
        tabLayout.addTab(secondTab);


        TabLayout.Tab thirdTab = tabLayout.newTab();
        thirdTab.setText("Cube Root Calculator"); // set the Text for the second Tab
        // set an icon for the second tab
        tabLayout.addTab(thirdTab);

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
// get the current selected tab's position and replace the fragment accordingly
                Fragment fragment = null;
                switch (tab.getPosition()) {
                    case 0:
                        fragment = new RootCalculator();
                        break;
                    case 1:
                        fragment = new SquareRootCalculator();
                        break;
                    case 2:
                        fragment = new CubeRootCalculator();
                        break;

                }
                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.simpleFrameLayout, fragment);
                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                ft.commit();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
*/




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
            Intent intent=new Intent(RootCalCalci.this,MainActivity.class);
            //    finish();
            startActivity(intent);


        }


        return super.onOptionsItemSelected(item);
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch(keyCode){
            case KeyEvent.KEYCODE_BACK:

                Intent intent=new Intent(RootCalCalci.this,MainActivity.class);
                finish();
                startActivity(intent);

                return true;
        }
        return super.onKeyDown(keyCode, event);
    }

   /* @Override
    public void onTabSelected(TabLayout.Tab tab) {

    }*/

 /*   @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }*/
}






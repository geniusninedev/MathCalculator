package com.geniusnine.android.mathcalculators.Forum;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.geniusnine.android.mathcalculators.MainActivity;
import com.geniusnine.android.mathcalculators.R;
import com.geniusnine.android.mathcalculators.fragment.MyTopPostsFragment;
import com.geniusnine.android.mathcalculators.fragment.RecentPostsFragment;
import com.google.firebase.auth.FirebaseAuth;

public class ForumActivity extends BaseActivity {


    private static final String TAG = "MainActivity";
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener firebaseAuthListner;
    private FragmentPagerAdapter mPagerAdapter;
    private ViewPager mViewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forum);

       /* Toolbar toolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Forum");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);*/
        // Create the adapter that will return a fragment for each section
        mPagerAdapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
            private final Fragment[] mFragments = new Fragment[] {
                    new RecentPostsFragment(),
                    new MyTopPostsFragment(),
            };
            private final String[] mFragmentNames = new String[] {
                    getString(R.string.heading_recent),
                    getString(R.string.heading_my_top_posts)
            };
            @Override
            public Fragment getItem(int position) {
                return mFragments[position];
            }
            @Override
            public int getCount() {
                return mFragments.length;
            }
            @Override
            public CharSequence getPageTitle(int position) {
                return mFragmentNames[position];
            }
        };
        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mPagerAdapter);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);

        // Button launches NewPostActivity
        findViewById(R.id.fab_new_post).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                startActivity(new Intent(ForumActivity.this, NewPostActivity.class));
            }
        });
    }


}

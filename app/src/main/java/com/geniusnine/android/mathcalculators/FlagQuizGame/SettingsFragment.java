package com.geniusnine.android.mathcalculators.FlagQuizGame;


import android.os.Bundle;
import android.preference.PreferenceFragment;

import com.geniusnine.android.mathcalculators.R;


public class SettingsFragment extends PreferenceFragment
{

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preferences);
    }
}

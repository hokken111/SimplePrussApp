package com.sofancy.nahue.firstfancyapp

import android.os.Bundle
import com.lightvessel.core.injection.CanFindViews
import com.lightvessel.core.navigation.FragmentedActivity
import com.lightvessel.core.navigation.FragmentedSection
import com.sofancy.nahue.firstfancyapp.R

/**
 * Created by nahue on 23/07/15.
 */

class MainActivity: FragmentedActivity<MainActivity, BaseFragment>() {
    override val layout = R.layout.activity_main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        goToFragment(SettingsFragment())
    }
}

abstract class BaseFragment: FragmentedSection<BaseFragment, MainActivity>(), CanFindViews
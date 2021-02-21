package com.github.orelzion.sharedprefrences.view

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.preference.PreferenceManager
import com.github.orelzion.sharedprefrences.R
import com.github.orelzion.sharedprefrences.model.OnBoardingRepository
import com.github.orelzion.sharedprefrences.viewmodel.MainViewModel
import com.github.orelzion.sharedprefrences.viewmodel.OnBoardingRepositoryFactory

class MainActivity : AppCompatActivity() {

    private val viewModel by viewModels<MainViewModel> { OnBoardingRepositoryFactory(
        OnBoardingRepository(PreferenceManager.getDefaultSharedPreferences(this))
    ) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel.bindIsVisitedOnBoarding().observe(this) {
            if(!it) {
                val onBoardingIntent = Intent(this, OnBoardingActivity::class.java)
                startActivity(onBoardingIntent)
            }
        }
        viewModel.onMainLaunched()
    }
}
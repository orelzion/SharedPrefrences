package com.github.orelzion.sharedprefrences.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.github.orelzion.sharedprefrences.model.OnBoardingRepository

class MainViewModel(private val repository: OnBoardingRepository): ViewModel() {

    private val isVisitedOnBoardingObserver = MutableLiveData<Boolean>()
    fun bindIsVisitedOnBoarding(): LiveData<Boolean> = isVisitedOnBoardingObserver

    fun onMainLaunched() {
        isVisitedOnBoardingObserver.postValue(repository.isOnBoardingVisited())
    }
}
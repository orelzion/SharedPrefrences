package com.github.orelzion.sharedprefrences.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.github.orelzion.sharedprefrences.model.OnBoardingRepository
import java.lang.IllegalArgumentException

class OnBoardingRepositoryFactory(private val repository: OnBoardingRepository): ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass == MainViewModel::class.java) {
            return MainViewModel(repository) as T
        } else {
            throw IllegalArgumentException()
        }
    }
}
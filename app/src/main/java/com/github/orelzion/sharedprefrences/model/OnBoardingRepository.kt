package com.github.orelzion.sharedprefrences.model

import android.content.SharedPreferences
import androidx.core.content.edit

class OnBoardingRepository(private val sharedPreferences: SharedPreferences) {

    companion object {
        private const val VISITED_ON_BOARDING_KEY = "visited_on_boarding"
    }

    fun isOnBoardingVisited(): Boolean {
        return sharedPreferences
            .getBoolean(VISITED_ON_BOARDING_KEY, false)
    }

    fun saveOnBoardingVisited(isVisited: Boolean) {
        sharedPreferences
            .edit {
                putBoolean(VISITED_ON_BOARDING_KEY, true)
            }
    }
}
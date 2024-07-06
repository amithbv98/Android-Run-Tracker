package com.example.myapplication.repositories

import com.example.myapplication.db.RunDAO
import javax.inject.Inject
import com.example.myapplication.db.Run

class MainRepository @Inject constructor(
    val runDAO: RunDAO
) {
    suspend fun insert(run:Run) = runDAO.insertRun(run)

    suspend fun delete(run:Run) = runDAO.deleteRun(run)

    fun getAllRunsSortedByDate() = runDAO.getAllRunsSortedByDate()

    fun getAllRunsSortedByDistance() = runDAO.getAllRunsSortedByDistance()

    fun getAllRunsSortedByMillis() = runDAO.getAllRunsSortedByTimeInMillis()

    fun getAllRunsSortedByAVGSpeed() = runDAO.getTotalAvgSpeed()

    fun getAllRunsSortedByCalories() = runDAO.getAllRunsSortedByCaloriesBurned()

    fun getTotalAvgSpeed() = runDAO.getTotalAvgSpeed()

    fun getTotalDistance() = runDAO.getTotalDistance()

    fun getTotalCaloriesBurnt() = runDAO.getTotalCaloriesBurned()

    fun getTotalTimeInMillis() = runDAO.getTotalTimeInMillis()
}
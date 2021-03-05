package com.nightowl094.retrofitunittestwithcoroutine

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.nightowl094.retrofitunittestwithcoroutine.data.CommentDTOItem
import com.nightowl094.retrofitunittestwithcoroutine.data.GetCommentsService
import com.nightowl094.retrofitunittestwithcoroutine.data.JSONPlaceholderRemoteSource
import com.nightowl094.retrofitunittestwithcoroutine.functions.getOrAwaitValue
import com.nightowl094.retrofitunittestwithcoroutine.ui.view_models.MainViewModel
import kotlinx.coroutines.*
import kotlinx.coroutines.test.*
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestWatcher
import org.junit.runner.Description
import retrofit2.create

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */

class GetCommentsTest {

    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    private lateinit var vm: MainViewModel

    @Before
    fun before() {

        vm = MainViewModel()
        vm.comments.observeForever {
            println(it)
        }
    }

    @Test
    fun getCommentsTest() {
        vm.getComments()
        val result = vm.comments.getOrAwaitValue()

        println(result)
        assertNotEquals(null, result)
    }

}
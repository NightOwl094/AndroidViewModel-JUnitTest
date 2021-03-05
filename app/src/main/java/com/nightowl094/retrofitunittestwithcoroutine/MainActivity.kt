package com.nightowl094.retrofitunittestwithcoroutine

import android.os.Bundle
import android.util.Log
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.lifecycleScope
import com.nightowl094.retrofitunittestwithcoroutine.data.GetCommentsService
import com.nightowl094.retrofitunittestwithcoroutine.data.JSONPlaceholderRemoteSource
import com.nightowl094.retrofitunittestwithcoroutine.ui.theme.RetrofitUnitTestWithCoroutineTheme
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.create

class MainActivity : AppCompatActivity() {
    private val jsonPlaceholderRetrofit = JSONPlaceholderRemoteSource.jsonPlaceholderRemoteSource
    private val getDummyCommentsService
        get() = jsonPlaceholderRetrofit.create<GetCommentsService>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RetrofitUnitTestWithCoroutineTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    Greeting("Android")
                }
            }
        }

        lifecycleScope.launch(Dispatchers.IO) {
            getDummyCommentsService.fetchDummyCommentData().also {
                Log.d("ttt", "MainActivity onCreate: ${it}")
            }
        }

    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    RetrofitUnitTestWithCoroutineTheme {
        Greeting("Android")
    }
}
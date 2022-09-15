package com.funkymuse.composedlib

import android.os.Bundle
import android.util.Log
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.funkymuse.composed.core.OnLifecycleEvent
import com.funkymuse.composed.core.OnResume
import com.funkymuse.composed.core.lazylist.lastVisibleIndex
import com.funkymuse.composed.core.lazylist.lastVisibleIndexState
import com.funkymuse.composedlib.ui.theme.ComposedLibTheme
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposedLibTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    Greeting()
                }
            }
        }
    }
}

@Composable
fun Greeting() {
    val columnState = rememberLazyListState()
    Log.d("COMPOSED", "YEAZZZ")
    val lastVisibleIndex by columnState.lastVisibleIndexState()

    val list = mutableListOf<String>()
    repeat(100) {
        list += "${UUID.randomUUID()} $it"
    }
    LazyColumn(modifier = Modifier.fillMaxSize(), state = columnState) {
        items(list) { item ->
            MakeText(it = item)
        }
    }
    OnLifecycleEvent { source, event ->
        Log.d("STATE", "$source $event")
    }
    OnResume {
        Log.d("STATE", "resumed $it latestVisible $lastVisibleIndex")
    }
}

@Composable
fun MakeText(it: String) {
    Text(text = it)
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposedLibTheme {
        Greeting()
    }
}
package com.funkymuse.composedlib

import android.os.Bundle
import android.util.Log
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.funkymuse.composed.core.OnLifecycleEvent
import com.funkymuse.composed.core.OnResume
import com.funkymuse.composedlib.ui.theme.ComposedLibTheme

class MainActivity : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      ComposedLibTheme {
        // A surface container using the 'background' color from the theme
        Surface(color = MaterialTheme.colors.background) {
          Greeting("Android")
        }
      }
    }
  }
}

@Composable
fun Greeting(name: String) {
  Text(text = "Hello $name!")

  OnLifecycleEvent { source, event ->
    Log.d("STATE", "$source $event")
  }
  OnResume {
    Log.d("STATE", "resumed $it")
  }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
  ComposedLibTheme {
    Greeting("Android")
  }
}
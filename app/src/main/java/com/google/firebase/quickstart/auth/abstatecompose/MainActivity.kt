package com.google.firebase.quickstart.auth.abstatecompose

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.Role.Companion.Button
import androidx.compose.ui.tooling.preview.Preview
import com.google.firebase.quickstart.auth.abstatecompose.ui.theme.AbStateComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
                    AbState()
        }
    }
}

@Composable
fun AbNoState() {
    var clickCount = 0
    Column {
        Button(onClick = {
            clickCount++
            Log.d("TAG", "NoState: "+clickCount)
        }) {
            Text(text = ""+clickCount+" times clicked")
        }
    }
}
@SuppressLint("UnrememberedMutableState")
@Composable
fun AbMutableStateClick() {
    var clickCount by mutableStateOf(0)//Not recommended
    Column {
        Button(onClick = { clickCount++ }) {
            Text(text = "" + clickCount + " times clicked")
        }
    }
}
@Composable
fun AbRememberSample() {
    var clickCount by remember { mutableStateOf(0) }
    Column {
        Button(onClick = { clickCount++ }) {
            Text(text = "" + clickCount + " times clicked")
        }
    }
}
@Composable
fun AbRememberSaveableSample() {
    var clickCount = rememberSaveable { mutableStateOf(0) }
    Column {
        Button(onClick = { clickCount.value++ }) {
            Text(text = "" + clickCount.value + " times clicked")
        }
    }
}
@Composable
fun AbState()
{
   Column()
   {
       AbNoState()
       AbMutableStateClick()
       AbRememberSample()
       AbRememberSaveableSample()
   }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun defaultPreview()
{
    AbState()
}
package com.example.jectpackcomposebasic

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.jectpackcomposebasic.ui.theme.JectpackComposeBasicTheme

class MainActivity02 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // MessageCard(name = "My Android")
            MessageCard(Message("Android","Jetpack Compose"))
        }
    }
    
    @Composable
    fun MessageCard(msg:Message){
        Row() {
            Image(painter = painterResource(id = R.drawable.test), contentDescription = null)
            Column() {
                Text(text = msg.author)
                Text(text = msg.body)
            }
        }
    }


}

data class Message(val author: String,val body: String)
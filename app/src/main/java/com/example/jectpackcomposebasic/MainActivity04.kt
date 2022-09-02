package com.example.jectpackcomposebasic

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jectpackcomposebasic.ui.theme.JectpackComposeBasicTheme

class MainActivity04 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JectpackComposeBasicTheme {
                MessageCard(Message("Android", "Jetpack Compose"))
            }
        }
    }

    @Composable
    fun MessageCard(msg: Message) {
        Row(
            modifier = Modifier
                .padding(all = 8.dp)
                .background(MaterialTheme.colors.background)
        ) {
            Image(
                painter = painterResource(id = R.drawable.huzhang),
                contentDescription = null ,
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape)
            )
            Column() {
                Text(text = msg.author)
                Spacer(modifier = Modifier.height(4.dp))
                Text(text = msg.body)
            }
        }
        Log.i(TAG,"Why not use jetpack?")
    }

    @Composable
    @Preview
    fun PreviewMessageCard(){
        MessageCard(Message("Yiin","2006070201"))
    }

}

package com.example.jectpackcomposebasic

import android.content.ContentValues.TAG
import android.os.Bundle
import android.text.style.BackgroundColorSpan
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.compose.tutorial.SampleData
import com.example.jectpackcomposebasic.ui.theme.JectpackComposeBasicTheme

class MainActivity05 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            JectpackComposeBasicTheme {
                Conversation(SampleData.conversationSample)
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
                contentDescription = null,
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape)
            )
            Spacer(modifier = Modifier.width(8.dp))
            // remember ????????????composable?????????????????????????????????????????????????????????????????????by????????????
            var isExpanded by remember { mutableStateOf(false) }
            val surfaceColor: Color by animateColorAsState(
                if (isExpanded) MaterialTheme.colors.primary else MaterialTheme.colors.surface
            )
            Column(
                modifier = Modifier.clickable { isExpanded = !isExpanded }
            ) {
                Text(
                    text = msg.author,
                    color = MaterialTheme.colors.secondaryVariant
                )
                Spacer(modifier = Modifier.height(4.dp))
                Surface(
                    //??????
                    shape = MaterialTheme.shapes.medium,
                    //????????????
                    elevation =1.dp,
                    color = surfaceColor,
                    //??????????????????
                    modifier = Modifier.animateContentSize().padding(1.dp)
                )
                {
                    Text(
                        text = msg.body,
                        modifier = Modifier.padding(4.dp),
                        style = MaterialTheme.typography.body2,
                        //???Expended???true?????????????????????Expended???false??????????????????
                        maxLines = if (isExpanded) Int.MAX_VALUE else 1


                    )
                }
        }
    }
}

@Composable
fun Conversation(messages: List<Message>) {
    //??????????????????
    LazyColumn {
        items(messages) { messages ->
            MessageCard(messages)
        }
    }
}

@Composable
@Preview
fun PreviewMessageCard() {
    MessageCard(Message("Yiin", "2006070201\ndfasfs\n"))
}

}

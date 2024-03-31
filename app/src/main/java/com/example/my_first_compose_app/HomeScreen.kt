package com.example.my_first_compose_app

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun HomeScreen() {
    Surface(color = MaterialTheme.colorScheme.primary) {
        var listSize by remember {
            mutableIntStateOf(20)
        }.also {
            if (it.intValue < 1)
                it.intValue = 1
        }

        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Button(
                    onClick = { listSize = ++listSize },
                    colors = ButtonColors(Color.Black, Color.White, Color.Gray, Color.DarkGray),
                    enabled = listSize < 20
                ) {
                    Text(text = "Add Text")
                }

                Button(
                    onClick = { listSize = --listSize },
                    colors = ButtonColors(Color.Black, Color.White, Color.Gray, Color.DarkGray),
                    enabled = listSize > 1
                ) {
                    Text(text = "Remove Text")
                }
            }

            LazyColumn(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                items(listSize) {
                    Text(
                        modifier = Modifier.padding(10.dp),
                        text = (it + 1).toString(),
                        fontSize = 28.sp
                    )
                }
            }
        }


//        Box(
//            modifier = Modifier.fillMaxSize()
//        ) {
//            Text(
//                text = "Hello ${stringResource(id = R.string.app_name)}",
//                fontStyle = FontStyle.Italic,
//                fontSize = 24.sp,
//                fontWeight = FontWeight.Bold,
//                fontFamily = FontFamily.Monospace,
//                modifier = Modifier
//                    .align(Alignment.Center)
//                    .padding(5.dp)
//            )
//            Text(
//                text = "VIRI XEZE AVIDA ${stringResource(id = R.string.app_name)}",
//                fontStyle = FontStyle.Italic,
//                fontSize = 24.sp,
//                fontWeight = FontWeight.Bold,
//                fontFamily = FontFamily.Monospace,
//                modifier = Modifier
//                    .padding(top = 150.dp)
//                    .align(Alignment.Center)
//                    .background(color = Color.Cyan)
//            )
//        }
    }
}

@Composable
@Preview(showBackground = true)
fun HomeScreenPreview() {
    HomeScreen()
}
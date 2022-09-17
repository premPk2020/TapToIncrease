package com.example.composefundamentals

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composefundamentals.ui.theme.ComposeFundamentalsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeFundamentalsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    TapToIncrease()
                }
            }
        }
    }
}


@Composable
fun TapToIncrease() {
    val number = remember {
        mutableStateOf(0)
    }
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        Text(

            text = number.value.toString(),
            fontSize = MaterialTheme.typography.h1.fontSize,
            modifier = Modifier.padding(50.dp)
        )
        Surface(
            modifier = Modifier
                .clip(CircleShape)
                .clickable {
                    number.value++;
                }, color = Color.LightGray
        ) {
            Box(contentAlignment = Alignment.Center) {
                Text(
                    text = "Tap",
                    fontSize = MaterialTheme.typography.button.fontSize,
                    modifier = Modifier.padding(30.dp),
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeFundamentalsTheme {
        TapToIncrease()
    }
}
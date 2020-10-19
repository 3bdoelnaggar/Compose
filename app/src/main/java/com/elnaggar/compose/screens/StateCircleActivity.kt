package com.elnaggar.compose.screens

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.ui.tooling.preview.Preview
import com.elnaggar.compose.animations.StateCircle
import com.elnaggar.compose.ui.ComposeTheme

class StateCircleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            StateCircle(modifier = Modifier.fillMaxSize().padding(58.dp),stateNum = 6 )
        }
    }
}

@Preview
@Composable
fun preview(){
    MaterialTheme() {
        StateCircle(modifier = Modifier.fillMaxSize().padding(58.dp),stateNum = 6 )

    }
}



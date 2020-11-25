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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.ui.tooling.preview.Preview
import com.elnaggar.compose.animations.CircleDrawingRaceLoading
import com.elnaggar.compose.animations.StateCircle
import com.elnaggar.compose.animations.Tanora
import com.elnaggar.compose.ui.ComposeTheme

class TanoraActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column {
                Tanora(modifier = Modifier.fillMaxSize().padding(80.dp))
                CircleDrawingRaceLoading(modifier = Modifier.fillMaxSize().padding(58.dp))
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun previewTanora() {
    MaterialTheme() {
        CircleDrawingRaceLoading(modifier = Modifier.fillMaxSize().padding(100.dp),unActiveColor =  Color.Black,activeColor  = Color.Magenta)


    }
}



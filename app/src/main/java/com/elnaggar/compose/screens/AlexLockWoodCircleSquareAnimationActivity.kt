package com.elnaggar.compose.screens

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.unit.dp
import com.elnaggar.compose.animations.CircleSquare

class AlexLockWoodCircleSquareAnimationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column() {
                Row {
                    CircleSquare(modifier = Modifier.size(200.dp).padding(8.dp))
                    CircleSquare(modifier = Modifier.size(200.dp).padding(8.dp), 1)

                }
                Row {
                    CircleSquare(modifier = Modifier.size(200.dp).padding(8.dp), 2)
                    CircleSquare(modifier = Modifier.size(200.dp).padding(8.dp), 3)

                }
            }
        }
        }
}




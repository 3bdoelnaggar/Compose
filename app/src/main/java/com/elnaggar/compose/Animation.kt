package com.elnaggar.compose

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.unit.dp
import androidx.ui.tooling.preview.Preview
import com.elnaggar.compose.ui.ComposeTheme

class Animation : AppCompatActivity() {
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




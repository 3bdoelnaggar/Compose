package com.elnaggar.compose

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
import com.elnaggar.compose.ui.ComposeTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            StateCircle(modifier = Modifier.fillMaxSize().padding(58.dp),stateNum = 8)
        }
    }
}

@Composable
fun LayoutsCodelab() {
    Scaffold(topBar = {
        TopAppBar(
                title = {
                    Text(text = "مطاعم الاسكندرية")
                },
                actions = {
                    IconButton(onClick = {}) {
                        Icon(Icons.Filled.Favorite)

                    }
                }
        )
    }) { innerPadding ->
        PhotographerCard(Modifier.padding(innerPadding).padding(8.dp))

    }
}

@Composable
private fun BodyContent(modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Text(text = "Hi there!")
        Text(text = "Thanks for going through the Layouts codelab")
    }
}

@Preview(showBackground = true)
@Composable
fun PhotographerCard(modifier: Modifier = Modifier) {

    Row(
            modifier = Modifier.fillMaxWidth().padding(8.dp)
                    .clip(RoundedCornerShape(4.dp))
                    .background(MaterialTheme.colors.surface)
                    .clickable(onClick = {}).padding(16.dp)
    ) {
        Surface(
                modifier = Modifier.preferredSize(100.dp),
                shape = CircleShape,
                color = MaterialTheme.colors.onSurface.copy(alpha = 0.2f)
        ) {
            Image(vectorResource(id = R.drawable.ic_launcher_background))
        }
        Column(modifier = Modifier.padding(start = 8.dp).align(Alignment.CenterVertically)) {
            Text(text = "Abdalla Elnaggar", fontWeight = FontWeight.Bold)
            ProvideEmphasis(emphasis = EmphasisAmbient.current.medium) {
                Text(text = "Android Developer", style = MaterialTheme.typography.body2)
                Text(text = "Android Developer", style = MaterialTheme.typography.body2)
                Text(text = "Android Developer", style = MaterialTheme.typography.body2)
                Text(text = "Android Developer", style = MaterialTheme.typography.body2)


            }
        }
    }
}


//@Preview(showBackground = true)
//@Composable
//fun PhotographerCardPreview() {
//    ComposeTheme {
//        PhotographerCard()
//    }
//}
@Preview(showBackground = true)
@Composable
fun LayoutsCodelabPreview() {
    ComposeTheme {
        LayoutsCodelab()
    }
}



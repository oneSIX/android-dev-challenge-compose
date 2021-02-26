
package com.kentsinclair.androiddevchallenge

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.kentsinclair.androiddevchallenge.models.PuppyInfo
import com.kentsinclair.androiddevchallenge.models.PuppyName
import com.kentsinclair.androiddevchallenge.models.Tagline
import com.kentsinclair.androiddevchallenge.ui.components.PuppyList
import com.kentsinclair.androiddevchallenge.ui.theme.MyTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyTheme {
                MyApp()
            }
        }
    }
}

// Start building your app here!
@Composable
fun MyApp() {
    Surface(color = MaterialTheme.colors.background) {
        PuppyList(
            puppyList(), modifier = Modifier.fillMaxWidth()
        )
    }
}

@Composable
private fun puppyList() = listOf(

    PuppyInfo(PuppyName("Reggie"), Tagline("he's got two faces")),
    PuppyInfo(PuppyName("Stitch"), Tagline("his name is actually just Jon")),
    PuppyInfo(PuppyName("Coco"), Tagline("this one is a small smartypants")),
    PuppyInfo(PuppyName("Kiki"), Tagline("got any snacks?"))

)

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun LightPreview() {
    MyTheme {
        MyApp()
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun DarkPreview() {
    MyTheme(darkTheme = true) {
        MyApp()
    }
}

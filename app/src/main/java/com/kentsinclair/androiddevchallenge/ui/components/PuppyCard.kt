package com.kentsinclair.androiddevchallenge.ui.components

import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview
import com.kentsinclair.androiddevchallenge.R
import com.kentsinclair.androiddevchallenge.models.PuppyInfo
import com.kentsinclair.androiddevchallenge.models.PuppyName
import com.kentsinclair.androiddevchallenge.models.Tagline

@Preview
@Composable
fun PreviewPuppy() {
    val puplist = listOf(
        PuppyInfo(PuppyName("harvey"), Tagline("he's got two faces")),
        PuppyInfo(PuppyName("jonboy"), Tagline("his name is actually just Jon"))
    )
    PuppyList(puppies = puplist, modifier = Modifier.fillMaxWidth())
}

@Composable
fun PuppyCard(puppy: PuppyInfo, modifier: Modifier = Modifier) {
    val context = LocalContext.current
    Card(
        modifier = modifier,
        border = BorderStroke(color = Color.Gray, width = Dp.Hairline),
        shape = RoundedCornerShape(8.dp)
    ) {
        Row(
            modifier
                .clip(RoundedCornerShape(4.dp))
                .background(MaterialTheme.colors.surface)
                .padding(8.dp)
                .clickable {
                    Toast
                        .makeText(context, "${puppy.puppyName} Clicked!", Toast.LENGTH_SHORT)
                        .show()
                }) {
            Surface(
                modifier = Modifier
                    .size(50.dp)
                    .clip(RoundedCornerShape(4.dp)),
                shape = CircleShape,
                color = MaterialTheme.colors.onSurface.copy(alpha = 0.15f)
            ) {
//                // image goes here.


            }
            Column(
                modifier = Modifier
                    .padding(start = 8.dp, end = 8.dp)
                    .align(Alignment.CenterVertically)
            ) {

                Text(puppy.puppyName, fontWeight = FontWeight.Bold)
                CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
                    Text(puppy.puppyShortDescription, style = MaterialTheme.typography.body2)
                }
            }
        }
    }
}
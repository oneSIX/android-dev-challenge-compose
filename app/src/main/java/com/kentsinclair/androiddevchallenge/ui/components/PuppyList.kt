package com.kentsinclair.androiddevchallenge.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kentsinclair.androiddevchallenge.models.PuppyInfo

@Composable
fun PuppyList(puppies: List<PuppyInfo>, modifier: Modifier = Modifier) {
    LazyColumn(modifier = modifier) {

        item {
            Text(
                "Puppy app!",
                textAlign = TextAlign.Center,
                fontSize = 18.sp,
                modifier = Modifier.fillMaxWidth(1f)
                    .padding(12.dp)
            )
        }

        items(items = puppies) { puppy ->
            PuppyCard(puppy = puppy, modifier = modifier.padding(2.dp))
        }
    }
}


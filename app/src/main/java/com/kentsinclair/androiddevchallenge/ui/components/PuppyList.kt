package com.kentsinclair.androiddevchallenge.ui.components

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.kentsinclair.androiddevchallenge.models.PuppyInfo

@Composable
fun PuppyList(puppies: List<PuppyInfo>, modifier: Modifier = Modifier) {
    LazyColumn(modifier = modifier) {
        items(items = puppies) { puppy ->
            PuppyCard(puppy = puppy, modifier = modifier.padding(2.dp))
        }
    }
}


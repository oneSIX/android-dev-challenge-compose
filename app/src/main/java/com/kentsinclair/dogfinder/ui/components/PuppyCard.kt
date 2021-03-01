/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.kentsinclair.dogfinder.ui.components

import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ContentAlpha
import androidx.compose.material.LocalContentAlpha
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.kentsinclair.dogfinder.data.DogRepo
import dev.chrisbanes.accompanist.coil.CoilImage

@Composable
fun PuppyCard(
    puppyIndex: Int,
    modifier: Modifier = Modifier,
    onPuppyClicked: (index: Int) -> Unit
) {

    val puppy = remember { DogRepo.dogs[puppyIndex] }
    // index not puppy
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
                    onPuppyClicked(puppyIndex)
                    Toast
                        .makeText(context, "${puppy.puppyName} Clicked!", Toast.LENGTH_SHORT)
                        .show()
                }
        ) {
            Surface(
                modifier = Modifier
                    .size(50.dp)
                    .clip(RoundedCornerShape(4.dp)),
                shape = CircleShape,
                color = MaterialTheme.colors.onSurface.copy(alpha = 0.15f)
            ) {
                CoilImage(
                    modifier = Modifier.fillMaxSize(1f),
                    data = puppy.imageResourceId,
                    contentDescription = puppy.puppyShortDescription
                )
            }
            Column(
                modifier = Modifier
                    .padding(start = 8.dp, end = 8.dp)
                    .align(Alignment.CenterVertically)
            ) {

                Text(puppy.puppyName, fontWeight = FontWeight.Bold, color = Color.White)
                CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
                    Text(puppy.puppyShortDescription, style = MaterialTheme.typography.body2, color = Color.White)
                }
            }
        }
    }
}

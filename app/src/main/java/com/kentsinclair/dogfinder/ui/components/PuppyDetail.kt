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

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.kentsinclair.dogfinder.data.DogRepo
import com.kentsinclair.dogfinder.models.PuppyInfo
import dev.chrisbanes.accompanist.coil.CoilImage

@Composable
fun PuppyDetail(puppyIndex: Int) {
    val puppy = DogRepo.dogs[puppyIndex]
    Scaffold(
        content = {
            Column {
                Details(resourceId = puppy.imageResourceId, puppy)
            }
        }
    )
}

@Composable
fun Details(resourceId: Int, puppy: PuppyInfo) {
    Card(
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier.padding(8.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(puppy.puppyName, style = MaterialTheme.typography.h3, color = Color.White)
            Text(
                puppy.puppyShortDescription,
                style = MaterialTheme.typography.h6,
                color = Color.White
            )
            CoilImage(
                data = resourceId,
                contentDescription = "BOOOO",
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
            )
        }
    }
}

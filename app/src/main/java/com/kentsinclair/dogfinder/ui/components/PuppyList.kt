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

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.navigate
import com.kentsinclair.dogfinder.data.DogRepo

@Composable
fun PuppyList(
    navController: NavController,
    modifier: Modifier = Modifier
) {
    Scaffold(
        content = {
            val puppies = remember { DogRepo.dogs }
            LazyColumn(modifier = modifier) {

                item {
                    Text(
                        "Puppy app!",
                        textAlign = TextAlign.Center,
                        fontSize = 18.sp,
                        modifier = Modifier
                            .fillMaxWidth(1f)
                            .padding(12.dp)
                    )
                }

                itemsIndexed(puppies) { index, _ ->
                    PuppyCard(index, modifier = modifier.padding(2.dp)) { _ ->
                        navController.navigate("puppyDetail/$index")
                    }
                }
            }
        }
    )
}

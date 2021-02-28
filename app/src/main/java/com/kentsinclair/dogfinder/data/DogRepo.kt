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
package com.kentsinclair.dogfinder.data

import com.kentsinclair.dogfinder.models.PuppyInfo
import com.kentsinclair.dogfinder.models.PuppyName
import com.kentsinclair.dogfinder.models.Tagline

object DogRepo {
    val dogs = listOf(

        PuppyInfo(0, PuppyName("Reggie"), Tagline("he's got two faces")),
        PuppyInfo(1, PuppyName("Stitch"), Tagline("his name is actually just Jon")),
        PuppyInfo(2, PuppyName("Coco"), Tagline("this one is a small smartypants")),
        PuppyInfo(3, PuppyName("Kiki"), Tagline("got any snacks?"))

    )
}

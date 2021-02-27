package com.kentsinclair.androiddevchallenge.models

data class PuppyInfo(private val name: PuppyName, private val shortDesc: Tagline)  {
     val puppyName get() = name.name
     val puppyShortDescription get() = shortDesc.shortDesc
}

data class PuppyName(val name: String)

data class Tagline(val shortDesc: String)
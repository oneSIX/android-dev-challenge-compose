package com.kentsinclair.androiddevchallenge.models

data class PuppyInfo(val name: PuppyName, val shortDesc: Tagline)

data class PuppyName(val name: String)

data class Tagline(val shortDesc: String)
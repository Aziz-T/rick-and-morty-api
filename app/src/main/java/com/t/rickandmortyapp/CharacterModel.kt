package com.t.rickandmortyapp

import java.io.Serializable

class CharacterModel (
    val id : Int,
    val name: String,
    val status: String,
    val species: String,
    val type: String,
    val gender: String,
    val image: String,
    val episode: List<String>) : Serializable






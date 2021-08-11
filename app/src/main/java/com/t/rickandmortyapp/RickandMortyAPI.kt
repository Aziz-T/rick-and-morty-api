package com.t.rickandmortyapp

import retrofit2.Call
import retrofit2.http.GET

interface RickandMortyAPI {
    @GET("character")
    fun getCharacters(): Call<CharacterResponse>
}
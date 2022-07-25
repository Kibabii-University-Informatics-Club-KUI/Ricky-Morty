package com.kanyideveloper.rickymorty.api

import com.kanyideveloper.rickymorty.model.CharactersResponse
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("character")
    fun getCharacters(): Call<CharactersResponse>
}
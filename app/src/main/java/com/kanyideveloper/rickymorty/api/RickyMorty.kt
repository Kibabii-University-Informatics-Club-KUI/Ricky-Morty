package com.kanyideveloper.rickymorty.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RickyMorty {

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://rickandmortyapi.com/api/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val api by lazy { retrofit.create(ApiService::class.java) }
}
package com.kanyideveloper.rickymorty

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ProgressBar
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.kanyideveloper.rickymorty.adapter.CharactersAdapter
import com.kanyideveloper.rickymorty.api.RickyMorty
import com.kanyideveloper.rickymorty.model.CharactersResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private val adapter by lazy { CharactersAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val myProgressbar = findViewById<ProgressBar>(R.id.charactersProgressBar)
        val myRecyclerView = findViewById<RecyclerView>(R.id.charactersRecyclerView)

        RickyMorty.api.getCharacters().enqueue(object: Callback<CharactersResponse>{
            override fun onResponse(
                call: Call<CharactersResponse>,
                response: Response<CharactersResponse>
            ) {
                myProgressbar.isVisible = false
                if (response.isSuccessful){
                    adapter.submitList(response.body()?.results)
                    myRecyclerView.adapter = adapter
                }
            }

            override fun onFailure(call: Call<CharactersResponse>, t: Throwable) {
                Toast.makeText(applicationContext, t.message, Toast.LENGTH_SHORT).show()
                myProgressbar.isVisible = false
            }

        })
    }
}
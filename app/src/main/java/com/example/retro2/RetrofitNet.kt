package com.example.retro2
import com.example.retro2.dataModel.RecipeResponse
import retrofit2.http.GET

interface RetrofitNet {



    @GET("recipes")
    suspend fun getRecipes(): RecipeResponse
}

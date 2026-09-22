package com.example.retro2.ui.theme.viewmodel

import android.util.Log
import androidx.compose.ui.geometry.Rect
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retro2.RetrofitNet
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class RecipeViewModel : ViewModel() {

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://dummyjson.com")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val api = retrofit.create(RetrofitNet::class.java)
    private val api2 = retrofit.create(RetrofitNet::class.java)

    fun loadRecipe(){
        viewModelScope.launch {
            try{
                val response = api.getRecipes()
                val listRecipe = response.recipes
                for(recipe in listRecipe){
                    Log.d("DUMMY_JSON_APP", "name: ${recipe.name} | instructions: ${recipe.ingredients} | caloriesPerServing: ${recipe.caloriesPerServing}")
                }
            }
            catch (ex: Exception){
                Log.d("DUMMY_JSON_APP", "${ex.message}")
            }
        }

    }
}




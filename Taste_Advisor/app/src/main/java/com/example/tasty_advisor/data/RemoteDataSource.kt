package com.example.tasty_advisor.data

import com.example.tasty_advisor.data.network.FoodRecipesApi
import com.example.tasty_advisor.models.FoodRecipe
import retrofit2.Response
import javax.inject.Inject

class RemoteDataSource @Inject constructor (
    private val foodRecipesApi: FoodRecipesApi
) {
    suspend fun getRecipes(queries: Map<String,String>): Response<FoodRecipe> {
        return foodRecipesApi.getRecipes(queries)
    }
}
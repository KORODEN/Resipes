package com.kode.recipes.data.recipe.repository

import android.util.Log
import com.kode.recipes.data.base.ApiFactory
import com.kode.recipes.data.base.BaseRepository
import com.kode.recipes.data.recipe.converter.toRecipe
import com.kode.recipes.data.recipe.network.RecipeApi
import com.kode.recipes.domain.recipe.Recipe
import retrofit2.HttpException
import java.io.IOException

class RecipeRepository : BaseRepository() {

    // Ретрофит имплементирует интерфейс RecipeApi с запросами
    private val recipeApi: RecipeApi = ApiFactory.retrofit

    suspend fun getRecipes(): List<Recipe>? {
        return safeApiCall(
            call = { recipeApi.getRecipesAsync() },
            errorMessage = "Error while trying to get recipes"
        )?.recipes?.map { it.toRecipe() }
    }
}
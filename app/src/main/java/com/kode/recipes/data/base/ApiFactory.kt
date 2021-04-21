package com.kode.recipes.data.base

import com.kode.recipes.data.recipe.network.RecipeApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Объект, служащий для создания экземпляра класса ретрофит
 */
object ApiFactory {

    val retrofit: RecipeApi by lazy {
        Retrofit.Builder()
            .baseUrl("https://test.kode-t.ru")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(RecipeApi::class.java)
    }

}
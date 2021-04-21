package com.kode.recipes.data.recipe.converter

import com.kode.recipes.domain.recipe.Recipe
import com.koroden.recipes.data.recipe.model.RecipeDto

fun RecipeDto.toRecipe() = Recipe(
    uuid,
    name,
    images[0],
    description,
    instructions,
    difficulty
)

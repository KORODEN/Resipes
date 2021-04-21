package com.kode.recipes.ui.recipe

import android.os.Bundle
import android.view.View
import androidx.navigation.navGraphViewModels
import com.kode.recipes.R
import com.kode.recipes.databinding.FragmentRecipeDetailsBinding
import com.kode.recipes.presentation.recipe.RecipesViewModel
import com.kode.recipes.ui.base.BaseFragment

class RecipeDetailsFragment : BaseFragment(R.layout.fragment_recipe_details) {

    override val viewModel: RecipesViewModel by navGraphViewModels(R.id.recipesMasterDetailGraph) {
        defaultViewModelProviderFactory
    }

    private var binding: FragmentRecipeDetailsBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentRecipeDetailsBinding.bind(view)

        binding!!.viewModel = viewModel
        binding!!.lifecycleOwner = this
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}
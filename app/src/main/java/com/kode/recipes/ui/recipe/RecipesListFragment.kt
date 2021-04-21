package com.kode.recipes.ui.recipe

import android.os.Bundle
import android.view.View
import androidx.navigation.navGraphViewModels
import com.kode.recipes.R
import com.kode.recipes.databinding.FragmentRecipesListBinding
import com.kode.recipes.presentation.base.ItemClickListener
import com.kode.recipes.presentation.recipe.RecipesAdapter
import com.kode.recipes.presentation.recipe.RecipesViewModel
import com.kode.recipes.ui.base.BaseFragment

class RecipesListFragment : BaseFragment(R.layout.fragment_recipes_list) {

    override val viewModel: RecipesViewModel by navGraphViewModels(R.id.recipesMasterDetailGraph) {
        defaultViewModelProviderFactory
    }

    private var binding: FragmentRecipesListBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentRecipesListBinding.bind(view)

        binding!!.viewModel = viewModel
        binding!!.lifecycleOwner = this

        binding!!.adapter = RecipesAdapter(ItemClickListener {
            viewModel.selectedRecipe.value = it
            navigateTo(R.id.action_recipesListFragment_to_recipeDetailsFragment)
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}
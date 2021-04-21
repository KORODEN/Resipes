package com.kode.recipes.ui.base

import android.widget.Toast
import androidx.annotation.IdRes
import androidx.annotation.LayoutRes
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.kode.recipes.presentation.base.BaseViewModel

/**
 * Базовый класс [Fragment],
 * имеющий общие для других фрагментов методы.
 * */
abstract class BaseFragment(@LayoutRes layoutId: Int) : Fragment(layoutId) {

    protected abstract val viewModel: BaseViewModel

    protected fun navigateTo(@IdRes action: Int) {
        findNavController().navigate(action)
    }
}
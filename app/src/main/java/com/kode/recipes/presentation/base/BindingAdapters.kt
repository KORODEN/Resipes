package com.kode.recipes.presentation.base

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

object BindingAdapters {

    @JvmStatic
    @BindingAdapter(value = ["imageUrl"])
    fun ImageView.setImageFromUrl(url: String?) {
        if (url != null && url.isNotBlank()) {
            //если есть картинка
            //устанавливаем картинку из url в imageView форматом Bitmap
            Glide.with(this).load(url).into(this)
        }
    }

    @JvmStatic
    @BindingAdapter(value = ["adapter"])
    fun RecyclerView.bindRecyclerViewAdapter(adapter: BaseListAdapter<*>) {
        this.run {
            this.setHasFixedSize(true) // с осторожностью
            this.adapter = adapter
        }
    }

    @JvmStatic
    @Suppress("UNCHECKED_CAST")
    @BindingAdapter(value = ["items"])
    fun <T> RecyclerView.setItems(items: List<T>?) {
        (this.adapter as? BaseListAdapter<T>)?.submitList(items)
    }
}
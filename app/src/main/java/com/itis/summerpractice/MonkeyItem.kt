package com.itis.summerpractice


import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.itis.summerpractice.databinding.ItemMonkeyBinding

class MonkeyItem(
    private val binding: ItemMonkeyBinding,
    private val glide: RequestManager,
    private val onItemClick: (Monkey) -> Unit,
) : RecyclerView.ViewHolder(binding.root) {

    private val options: RequestOptions = RequestOptions
        .diskCacheStrategyOf(DiskCacheStrategy.NONE)

    fun onBind(monkey: Monkey) {
        binding.run {
            tvTitle.text = monkey.name

            glide
                .load(monkey.url)
                .placeholder(R.drawable.loading)
                .error(R.drawable.not_found)
                .apply(options)
                .into(ivImage)

            root.setOnClickListener {
                onItemClick(monkey)
            }

        }
    }
}
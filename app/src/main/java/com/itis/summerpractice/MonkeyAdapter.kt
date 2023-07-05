package com.itis.summerpractice

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import com.itis.summerpractice.databinding.ItemMonkeyBinding

class MonkeyAdapter(
    private var list: List<Monkey>,
    private val glide: RequestManager,
    private val onItemClick: (Monkey) -> Unit,
) : RecyclerView.Adapter<MonkeyItem>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MonkeyItem = MonkeyItem(
        binding = ItemMonkeyBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false,
        ),
        glide = glide,
        onItemClick = onItemClick,
    )

    override fun onBindViewHolder(holder: MonkeyItem, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }
}
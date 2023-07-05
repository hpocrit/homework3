package com.itis.summerpractice

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.itis.summerpractice.databinding.FragmentDescriptionBinding

class DescriptionFragment : Fragment(R.layout.fragment_description) {
    private var _binding: FragmentDescriptionBinding? = null
    private val binding get() = _binding!!
    private val options: RequestOptions = RequestOptions.diskCacheStrategyOf(DiskCacheStrategy.ALL)

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentDescriptionBinding.bind(view)

        (requireActivity() as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(false)

        val id = arguments?.getInt("id")

        val glide : RequestManager = Glide.with(this)

        val monkey = MonkeyRepository.list.single{it.id == id}

        glide
            .load(monkey.url)
            .error(R.drawable.not_found)
            .apply(options)
            .into(binding!!.ivDetailedPicture)

        binding.tvDetailedId.text = getString(R.string.id) + monkey.id.toString()
        binding.tvDetailedName.text = monkey.name
        binding.tvDetailedDescription.text = monkey.description
    }

    override fun onDestroy() {
        super.onDestroy()

        _binding = null

    }

}
package com.itis.summerpractice

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.bumptech.glide.Glide
import com.itis.summerpractice.databinding.FragmentListBinding

class ListFragment : Fragment(R.layout.fragment_list) {
    private var binding: FragmentListBinding? = null
    private var adapter: MonkeyAdapter? = null
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentListBinding.bind(view)

        initAdapter()
    }


    private fun initAdapter() {
        adapter = MonkeyAdapter(
            list = MonkeyRepository.list,
            glide = Glide.with(this),
            onItemClick = {monkey ->
                showDetailedInfo(monkey)
            })
        binding?.rvMonkeys?.adapter = adapter
        binding?.rvMonkeys?.layoutManager = GridLayoutManager(requireContext(), 2)
    }

    private fun showDetailedInfo(monkey: Monkey) {
        val bundle : Bundle = bundleOf("id" to monkey.id)
        this.findNavController().navigate(R.id.action_listFragment_to_descriptionFragment, bundle)
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}
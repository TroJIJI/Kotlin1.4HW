package com.example.kotlin14hw

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.kotlin14hw.databinding.FragmentFirstBinding


class FirstFragment : Fragment() {

    private lateinit var binding: FragmentFirstBinding
    private lateinit var viewModel: MainViewModel
    private var list = arrayListOf<String>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        result()
    }

    private fun result() {
        viewModel = ViewModelProvider(requireActivity()).get(MainViewModel::class.java)

        viewModel.counter.observe(viewLifecycleOwner) {
            binding.tvCounter.text = it.toString()
        }
        binding.btnPlus.setOnClickListener {
            viewModel.onIncrementClick()
            list.add(viewModel.plus)
            viewModel.setCommands(list)
        }
        binding.btnMinus.setOnClickListener{
            viewModel.onDecrementClick()
            list.add(viewModel.minus)
            viewModel.setCommands(list)
        }

    }

}
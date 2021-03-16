package com.example.actionlistenerexample.home

import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.actionlistenerexample.Constance
import com.example.actionlistenerexample.base.BaseFragment
import com.example.actionlistenerexampletow.activity.MainViewModel
import com.example.actionlistenerexampletow.databinding.FragmentHomeBinding
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!


    private val homeViewmodel: HomeViewmodel by viewModels()

    val mainViewModel: MainViewModel by viewModels()

    lateinit var model: MainViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        binding.viewmodel = homeViewmodel
        binding.lifecycleOwner = viewLifecycleOwner
        model = ViewModelProviders.of(requireActivity()).get(MainViewModel::class.java)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.send.setOnClickListener(View.OnClickListener {
            send("home")
        })

        if (model.action == "sunday"){
            model.action = ""
            taskHome("sunday")
        }
//        mainViewModel.mainLiveData.value?.let {
//            if (it.equals("sunday")){
//                taskHome(it)
//            }
//        }
    }


    fun send(data: String) {
        val action = HomeFragmentDirections.actionHomeFragmentToDetailFragment()
        findNavController().navigate(action)

//        mainViewModel.mainLiveData.value = "holiday"
        model.action = "holiday"

    }

    fun taskHome(data: String) {
        binding.tvHome.text = data
    }

    companion object {
        @JvmStatic
        fun newInstance() = HomeFragment().apply {}
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
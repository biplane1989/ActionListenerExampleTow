package com.example.actionlistenerexample.detail

import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProviders
import com.example.actionlistenerexample.Constance
import com.example.actionlistenerexample.base.BaseFragment
import com.example.actionlistenerexampletow.activity.MainViewModel
import com.example.actionlistenerexampletow.databinding.FragmentDetailBinding

class DetailFragment : Fragment() {


    private var _binding: FragmentDetailBinding? = null
    private val binding get() = _binding!!
    private val detailViewmodel: DetailViewmodel by viewModels()
    private val mainViewmodel : MainViewModel by viewModels()

    lateinit var model: MainViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentDetailBinding.inflate(inflater, container, false)

        binding.viewmodel = detailViewmodel
        binding.lifecycleOwner = viewLifecycleOwner
        model = ViewModelProviders.of(requireActivity()).get(MainViewModel::class.java)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.back.setOnClickListener(View.OnClickListener {
            backAction("detail")
        })

        if (model.action == "holiday"){
            model.action = ""
            taskDetail("holiday")
        }
//        mainViewmodel.mainLiveData.value?.let {
//            if (it.equals("holiday")){
//                taskDetail(it)
//            }
//        }
    }


    fun backAction(data: String) {
//        mainViewmodel.mainLiveData.value = "sunday"
        model.action = "sunday"
        activity?.onBackPressed()
    }


    fun taskDetail(data: String){
        binding.tvDetail.text = data
    }

    companion object {
        @JvmStatic
        fun newInstance() = DetailFragment().apply {}
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
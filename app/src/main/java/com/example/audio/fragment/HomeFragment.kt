package com.example.audio.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.audio.mvvm_api_call.ContactDetails
import com.example.audio.mvvm_api_call.ResponseItemAdapter
import com.example.audio.mvvm_api_call.ResponseViewModel
import com.example.audio.mvvm_api_call.TestDeatilsItem
import com.example.vinothLearningApp.R

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment()
{
    private lateinit var viewModel:ResponseViewModel
    lateinit var recyclerViewData:RecyclerView
    lateinit var progressBar:ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view = inflater.inflate(R.layout.fragment_home,container,false)
        recyclerViewData = view.findViewById(R.id.recyclerViewData)
        progressBar = view.findViewById(R.id.progress_circular)

        viewModel = ViewModelProvider(this).get(ResponseViewModel::class.java)

        viewModel.liveData.observe(viewLifecycleOwner, Observer {
            progressBar.visibility = View.GONE
            Log.d("TAG", "onCreateView: "+it)
            callAdapter(it.contactDetails, it.testDeatils as ArrayList<TestDeatilsItem?>?)
        })
        viewModel.callRepo()
        return view
    }

    private fun callAdapter(
        responseModelClass: ContactDetails?,
        testDeatils: ArrayList<TestDeatilsItem?>?) {
        val responseItemAdapter = ResponseItemAdapter(responseModelClass,testDeatils,requireActivity())
        recyclerViewData.adapter = responseItemAdapter
    }


}
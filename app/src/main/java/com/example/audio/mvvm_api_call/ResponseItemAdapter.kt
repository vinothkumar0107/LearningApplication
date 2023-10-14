package com.example.audio.mvvm_api_call

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.vinothLearningApp.R

class ResponseItemAdapter(var responseData: ContactDetails?, var testDetaiList: ArrayList<TestDeatilsItem?>?, var contect:Context)
    : RecyclerView.Adapter<ResponseItemAdapter.ResponseViewHolder>()
{

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ResponseItemAdapter.ResponseViewHolder
    {
        return ResponseViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_adapter,parent,false))
    }



    override fun onBindViewHolder(holder: ResponseItemAdapter.ResponseViewHolder, position: Int) {
        holder.name.text = responseData!!.name
        holder.age.text = responseData!!.age.toString()
        holder.address.text = responseData!!.address
        holder.contact.text = responseData!!.contactNo
        holder.role.text = responseData!!.designation
        holder.testDetail.text = testDetaiList?.get(position)?.value ?: ""
    }

    override fun getItemCount(): Int {
        return testDetaiList!!.size
    }

    class ResponseViewHolder(view:View) : RecyclerView.ViewHolder(view) {
        lateinit var name : TextView
        lateinit var age : TextView
        lateinit var address : TextView
        lateinit var contact : TextView
        lateinit var role : TextView
        lateinit var testDetail : TextView
        init {
            name = view.findViewById(R.id.name)
            age = view.findViewById(R.id.age)
            address = view.findViewById(R.id.address)
            role = view.findViewById(R.id.role)
            testDetail = view.findViewById(R.id.testValue)
            contact = view.findViewById(R.id.contact)
        }
    }
}
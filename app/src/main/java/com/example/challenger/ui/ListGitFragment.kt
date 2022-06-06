package com.example.challenger.ui

import android.content.Context
import android.os.Bundle


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

  import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.challenger.R

import com.example.challenger.viewmodel.model.Item
import layout.GitAdapter
import java.lang.RuntimeException



class ListGitFragment : Fragment(R.layout.fragment_list_git) {

    interface selectedGitRepo {
        fun selectRepo(position:Int)
    }
    var activityInside:selectedGitRepo?=null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if(context is selectedGitRepo)
            activityInside=context
        else
            throw RuntimeException( context.toString()+" must implement SelectGitRepo")
    }

    // TODO: Rename and change types of parameters
    private var listItems:MutableList<String> =mutableListOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
    fun listGitRepo(repoList:MutableList<String>){
        listItems=repoList
     }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view:View=inflater.inflate(R.layout.fragment_list_git, container, false)

        return view
    }
    fun setupRecycledView(list: List<Item>){
        //recyclerView.layoutManager=LinearLayoutManager(this)
       // Log.d("msg","Recycler "+list.toString())

        val recyclerView  =view?.findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView?.layoutManager= LinearLayoutManager(context)
        recyclerView?.adapter=GitAdapter(list)
    }

}



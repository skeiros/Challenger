package com.example.challenger.ui

import android.content.Context
import android.os.Bundle

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.fragment.app.Fragment
import com.example.challenger.R
import java.lang.RuntimeException



class ListGitFragment : Fragment() {
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
        val personListView: ListView =view.findViewById(R.id.gitListView);
        val arrayAdapter: ArrayAdapter<*>
        arrayAdapter= ArrayAdapter(this.requireContext() ,android.R.layout.simple_list_item_1,listItems)
        personListView.adapter=arrayAdapter
        personListView.setOnItemClickListener { parent, _, position, _ ->
            val selectedItem = parent.getItemAtPosition(position) as String
            activityInside?.selectRepo(position)
        }
        return view
    }


}



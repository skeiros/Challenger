package com.example.challenger.ui

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ListView
import android.widget.TextView
import com.example.challenger.R
import java.lang.RuntimeException

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"


/**
 * A simple [Fragment] subclass.
 * Use the [GitDetailFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class GitDetailFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var detailGit:String=""
    interface backFromGitDetail {
        fun backFromDetail()
    }
    var activityInside:backFromGitDetail?=null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if(context is backFromGitDetail)
            activityInside=context
        else
            throw RuntimeException( context.toString()+" must implement SelectGitRepo")
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
    fun setDetail(detail:String){
        detailGit=detail
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view:View=inflater.inflate(R.layout.fragment_git_detail, container, false)
        val buttonBack:Button =view.findViewById(R.id.buttonBack)
        buttonBack.setOnClickListener {
            // your code to perform when the user clicks on the button
            Log.d("msg","BackButton")
            activityInside?.backFromDetail()
        }
        val gitTextDetail:TextView=view.findViewById(R.id.GitTextDetail)
        gitTextDetail.text=detailGit
        return view
    }


}
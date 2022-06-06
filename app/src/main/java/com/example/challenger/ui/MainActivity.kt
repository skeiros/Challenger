package com.example.challenger.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager

import com.example.challenger.R
import com.example.challenger.data.GitDataSet
import com.example.challenger.databinding.ActivityMainBinding
import com.example.challenger.interfaces.GitAppInterface
import com.example.challenger.viewmodel.model.Item
import com.example.challenger.viewmodel.MainViewModel
import com.example.challenger.viewmodel.MyViewModelFactory


private lateinit var viewModel: MainViewModel

class MainActivity : AppCompatActivity(),ListGitFragment.selectedGitRepo,GitDetailFragment.backFromGitDetail  {
    private val TAG = "MainActivity"
    // private lateinit var binding: ActivityMainBinding
    lateinit var viewModel: MainViewModel
    private val retrofitService = GitAppInterface.getInstance()
    //val recyclerView:RecyclerView=findViewById(R.id.recyclerView)
    //  val adapter = MainAdapter()
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val listGitFragment=ListGitFragment();
        val binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        viewModel = ViewModelProvider(this, MyViewModelFactory(GitDataSet(retrofitService))).get(MainViewModel::class.java)
        //binding.recyclerview.adapter = adapter
        viewModel.gitList.observe(this, Observer {
            //Log.d("msg", "MainActivity: $it")

            if (savedInstanceState == null) {
                     supportFragmentManager.beginTransaction()
                    .replace(R.id.fragmentContainerView, listGitFragment)
                    .commitNow()//*/
                listGitFragment.setupRecycledView( it )
            }
        })
        viewModel.errorMessage.observe(this, Observer {
            Log.d("msg", "onCreate: $it")
        })

        viewModel.getAllMovies()


    }

    override fun selectRepo(position: Int) {
        TODO("Not yet implemented")
    }

    override fun backFromDetail() {
        TODO("Not yet implemented")
    }

    /* fun setupRecycledView(list: List<MovieItem>){
         //recyclerView.layoutManager=LinearLayoutManager(this)
         val recyclerView=binding.recyclerView
         recyclerView.layoutManager= LinearLayoutManager(this)
         recyclerView.adapter=MovieAdapter(list)
     }*/

}
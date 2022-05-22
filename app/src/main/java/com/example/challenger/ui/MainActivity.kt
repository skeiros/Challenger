package com.example.challenger.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

import com.example.challenger.R
import com.example.challenger.data.Item
import com.example.challenger.viewmodel.MainViewModel


const val BASE_URL="https://api.github.com/search/";
private lateinit var viewModel: MainViewModel

class MainActivity : AppCompatActivity(),ListGitFragment.selectedGitRepo,GitDetailFragment.backFromGitDetail  {
    val listGitFragment=ListGitFragment();
    var gitDetailFragment=GitDetailFragment();

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel= ViewModelProvider(this).get(MainViewModel::class.java)
        var repoList:MutableList<String> = mutableListOf()
        var itemObserver= Observer<List<Item>>{
            for (item:Item in it){
                repoList.add("Proyect: "+ item.name.toString()+"\nAutor: "+item.owner.login+"")

            }
            listGitFragment.listGitRepo(repoList)
            if (savedInstanceState == null) {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragmentContainerView, listGitFragment)
                    .commitNow()//*/
            }
        }
        viewModel.getListItemLiveData().observe(this,itemObserver)
           }

    override fun selectRepo(position: Int) {
        Log.d("msg","Click on pos: "+position.toString())
            val detail=viewModel.getDetail(position)
            gitDetailFragment.setDetail(detail);
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainerView, gitDetailFragment)
                .commitNow()//*/

    }

    override fun backFromDetail() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainerView, listGitFragment)
            .commitNow()//*/
    }

}
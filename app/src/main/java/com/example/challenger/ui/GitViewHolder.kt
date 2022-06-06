/*
 * *
 * Created by Daniel Sequeiros on 5/6/22 22:54
 * Copyright (c) 2022. All rights reserved
 * Last modified 5/6/22 22:54
 * /
 */

package com.example.challenger.ui

import android.util.Log
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.challenger.databinding.AdapterGitBinding
import com.example.challenger.viewmodel.model.Item

class GitViewHolder(view: View): RecyclerView.ViewHolder(view) {
    val binding=AdapterGitBinding.bind(view)

    fun render(item: Item){
         binding.name.text=item.name
        binding.score.text= item.score.toString()
        binding.login.text=item.owner.login
        Glide.with(binding.imageView.context).load(item.owner.avatar_url).into(binding.imageView)

        /* binding.tvSuperHeroName.text=superHeroModel.superhero
         binding.tvRealName.text=superHeroModel.realname
         binding.tvPublisher.text=superHeroModel.publisher
        // Glide.with(binding.ivSuperHero.context).load(superHeroModel.photo).into(binding.ivSuperHero)*/
    }
}
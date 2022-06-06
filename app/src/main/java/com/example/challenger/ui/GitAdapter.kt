/*
 * *
 * Created by Daniel Sequeiros on 5/6/22 22:57
 * Copyright (c) 2022. All rights reserved
 * Last modified 5/6/22 22:54
 * /
 */

package layout

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.challenger.R
import com.example.challenger.ui.GitViewHolder
import com.example.challenger.viewmodel.model.Item

class GitAdapter(var list: List<Item>): RecyclerView.Adapter<GitViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GitViewHolder {
        val layoutInflater= LayoutInflater.from(parent.context)
        return GitViewHolder(layoutInflater.inflate(R.layout.adapter_git,parent,false))
    }

    override fun onBindViewHolder(holder: GitViewHolder, position: Int) {
        val item=list[position]
        holder.render(item)
    }

    override fun getItemCount(): Int=list.size

}
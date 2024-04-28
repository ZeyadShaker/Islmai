package com.Islmai.islami2

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.Islmai.databinding.ItemSuraNameBinding

class SuraNameAdapter(val suraItems: List<SuraNameIndex>) :Adapter<SuraNameAdapter.SuraNameViewHolder>(){
    var onItemClickListener:onSuraItemClickListener?=null
    class SuraNameViewHolder(val suraNameBinding: ItemSuraNameBinding):ViewHolder(suraNameBinding.root){
        fun bind(item: SuraNameIndex){
            suraNameBinding.suraIndex.text="${item.index}"
            suraNameBinding.suraName.text=item.name
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SuraNameViewHolder {
        val inflater=LayoutInflater.from(parent.context)
      var binding=ItemSuraNameBinding.inflate(inflater,parent,false)
        return SuraNameViewHolder(binding)
    }

    override fun getItemCount(): Int =suraItems.size

    override fun onBindViewHolder(holder: SuraNameViewHolder, position: Int) {
        val item=suraItems.get(position)
        holder.bind(item)
        holder.suraNameBinding.root.setOnClickListener{
            onItemClickListener?.onSuraClick(item,position)
        }

    }
    interface onSuraItemClickListener{
        fun onSuraClick(suraNameIndex: SuraNameIndex,position: Int)
    }
}
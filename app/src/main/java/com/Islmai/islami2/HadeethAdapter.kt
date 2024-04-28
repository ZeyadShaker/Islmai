package com.Islmai.islami2

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.Islmai.databinding.ItemHadethBinding
import com.Islmai.databinding.ItemVerseBinding

class HadeethAdapter(var ahadeethList:List<String>?)  :Adapter<HadeethAdapter.HadeethViewHolder>(){
    var onHadeethItemClickListener:OnHadeethItemClickListener?=null
    class HadeethViewHolder(val binding:ItemHadethBinding):ViewHolder(binding.root){
        fun bind(verse:String){
            binding.hadeethItem.text=verse
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HadeethViewHolder {

val inflater=LayoutInflater.from(parent.context)
val binding=ItemHadethBinding.inflate(inflater,parent,false)
        return HadeethViewHolder(binding)
    }

    override fun getItemCount(): Int =ahadeethList?.size?:0


    override fun onBindViewHolder(holder: HadeethViewHolder, position: Int) {
        val item=ahadeethList?.get(position)?:return
        holder.binding.root.setOnClickListener{
            onHadeethItemClickListener?.onHadeethItemClick(position)
        }
        holder.bind(item)

    }
    fun update(verses: List<String>){
        this.ahadeethList=verses
        notifyDataSetChanged()

    }
    interface OnHadeethItemClickListener{
        fun onHadeethItemClick(hadeethItemPosition:Int)
    }

}
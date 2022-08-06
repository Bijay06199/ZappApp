package com.example.zappapp.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.zappapp.R
import com.example.zappapp.ui.model.Photo
import kotlinx.android.synthetic.main.recyclerview_saved_photo.view.*

class SavedAdapter(val items: List<Photo>, val context: Context,val itemClickListener:OnItemClicklistener) : RecyclerView.Adapter<ViewHolder>() {


    override fun getItemCount(): Int {
        return items.size
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.tvTitle.setText(items[position].title)
        holder.tvUrl.setText(items[position].url)


        holder.delete.setOnClickListener {
               itemClickListener.onDeleteClick(position,items)

        }
        holder.edit.setOnClickListener {
            itemClickListener.onEditClick(position,items)
        }



    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.recyclerview_saved_photo, parent, false))

    }

    interface OnItemClicklistener {
        fun  onEditClick(position:Int,items: List<Photo>)
        fun onDeleteClick(position: Int,items: List<Photo>)
    }


}

class ViewHolder (view: View) : RecyclerView.ViewHolder(view) {
    val tvTitle=view.tv_title
    val tvUrl=view.tv_url
    val edit=view.iv_edit
    val delete=view.iv_delete



}
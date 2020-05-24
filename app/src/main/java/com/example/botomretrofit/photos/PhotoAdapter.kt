package com.example.botomretrofit.photos

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.botomretrofit.R


class PhotoAdapter(val photoList: List<Photo>) : RecyclerView.Adapter<PhotoAdapter.CustomViewHolder?>() {


    inner class CustomViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        var titleTextView = view.findViewById(R.id.titleTextView) as TextView
        var descriptionTextView = view.findViewById(R.id.descriptionTextView) as TextView
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CustomViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view: View = layoutInflater.inflate(R.layout.photo_viewholder, parent, false)
        return CustomViewHolder(view)
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {

        val photo = photoList[position]
        holder.titleTextView.text = photo.title
        holder.descriptionTextView.text = photo.body

    }


    override fun getItemCount() = photoList.size


}

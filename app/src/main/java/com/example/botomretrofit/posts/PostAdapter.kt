package com.example.botomretrofit.posts

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.botomretrofit.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.postsviewholder.view.*


class PostAdapter(val datalist: List<Post>) : RecyclerView.Adapter<PostAdapter.ViewHolder>() {
    lateinit var context: Context


    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val title = view.texstviewphotostitle
        val video = view.texstviewphotosurl

       val image = view.postsImage
    }

    override fun getItemCount(): Int {
        return datalist.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = datalist[position]
        holder.title.text = data.title
       holder.video.text = data.thumbnailUrl

        Picasso.get().load(data.url).into(holder.image)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.postsviewholder, parent, false)
        return ViewHolder(view)
    }
}
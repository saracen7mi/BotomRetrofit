package com.example.botomretrofit.users


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.botomretrofit.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.usersholderview.view.*


class UsersAdapter(val data:List <DataUsers>) : RecyclerView.Adapter<UsersAdapter.CustomViewHolder?>() {


    inner class CustomViewHolder( view: View) : RecyclerView.ViewHolder(view) {
        var textUser = view.findViewById(R.id.nameTextView) as TextView
        var textBody = view.findViewById(R.id.usernameTextView) as TextView
        var textBodu = view.findViewById(R.id.emailTextView) as TextView
        var image=view.findViewById<ImageView>(R.id.image)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CustomViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view: View = layoutInflater.inflate(R.layout.usersholderview, parent, false)
        return CustomViewHolder(view)
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {

        val data =data[position]
        holder.textUser.text =data.name
        holder.textBody.text = data.username

    }


    override fun getItemCount() =data.size


}

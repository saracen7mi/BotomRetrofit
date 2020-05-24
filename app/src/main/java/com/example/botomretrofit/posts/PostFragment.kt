package com.example.botomretrofit.posts

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.botomretrofit.R
import kotlinx.android.synthetic.main.reciclerviewposts.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class PostFragment : Fragment() {
lateinit var adapter:PostAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view=inflater.inflate(R.layout.reciclerviewposts, container, false)

        var retrofit = Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()


        val apiServis: ApiInterfacee = retrofit.create(
            ApiInterfacee::class.java
        )
        val call = apiServis.getPhotos()
        call.enqueue(object : Callback<List<Post>> {
            override fun onFailure(call: Call<List<Post>>, t: Throwable) {

            }

            override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {
                response.body()?.let { setDataListInRecyclerView(it) }

            }

            private fun setDataListInRecyclerView(datalist: List<Post>) {
                adapter = PostAdapter(datalist)

                val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(context)
                reciclerviewphotos.setLayoutManager(layoutManager)
                reciclerviewphotos.setAdapter(adapter)

            }

        })




        return view
    }}


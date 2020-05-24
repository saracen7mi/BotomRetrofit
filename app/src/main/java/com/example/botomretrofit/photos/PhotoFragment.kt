package com.example.botomretrofit.photos

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.botomretrofit.R
import kotlinx.android.synthetic.main.fragment_photo.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Suppress("UNREACHABLE_CODE")
class PhotoFragment : Fragment() {

    var adapter: PhotoAdapter? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        var retrofit = Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()


        val apiServis: ApiInterface = retrofit.create(
            ApiInterface::class.java
        )
        val call = apiServis.getPosts()
        call.enqueue(object : Callback<List<Photo>> {
            override fun onFailure(call: Call<List<Photo>>, t: Throwable) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onResponse(call: Call<List<Photo>>, response: Response<List<Photo>>) {
                response.body()?.let { setDataListInRecyclerView(it) }

            }

        })

        return inflater.inflate(R.layout.fragment_photo, container, false)
    }

    private fun setDataListInRecyclerView(usersList: List<Photo>) {
        adapter = PhotoAdapter(usersList)
        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(context)
        recyclerView!!.setLayoutManager(layoutManager)
        recyclerView!!.setAdapter(adapter)

    }

}




/*
* TODO
*  RXJava2 instead call.enqueue
*  Retrofit baziran na OKHttp
*  RxJava i Coroutines je za Threading
* */


/*
* TODO
*  1. Convert Rest Api to RxJava2
*  2. Component Builder for Retrofit, etc
*  3. Use Room Db for downloaded data
*
* TODO
*  1. Bottom Navigation
*  2. First page = Posts
*  3. Second page = Users
*  4. Third page = Photos
*  5. Fourth page = Tabs (Fragment 1, Fragment 2, Fragment 3)
* */


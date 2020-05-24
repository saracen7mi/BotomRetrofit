package com.example.botomretrofit.users

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.botomretrofit.R
import kotlinx.android.synthetic.main.usersrecyiclerview.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class UserFragment : Fragment() {

    lateinit var adapter: UsersAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.usersrecyiclerview, container, false)


        var retrofit = Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()


        val apiServis: ApiInterfaceee = retrofit.create(
            ApiInterfaceee::class.java
        )
        val call = apiServis.getUsers()
        call.enqueue(object : Callback<List<DataUsers>> {
            override fun onFailure(call: Call<List<DataUsers>>, t: Throwable) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onResponse(
                call: Call<List<DataUsers>>,
                response: Response<List<DataUsers>>
            ) {
                response.body()?.let { setDataListInRecyclerView(it) }

            }

            private fun setDataListInRecyclerView(data: List<DataUsers>) {
                adapter = UsersAdapter(data)
                val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(context)
                reciclerviewusers!!.setLayoutManager(layoutManager)
                reciclerviewusers!!.setHasFixedSize(true)
                adapter.notifyDataSetChanged()
                reciclerviewusers!!.setAdapter(adapter)

            }
        })
        return view
    }
}

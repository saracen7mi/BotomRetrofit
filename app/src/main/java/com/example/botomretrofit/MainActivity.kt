package com.example.botomretrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentTransaction
import com.example.botomretrofit.photos.PhotoFragment
import com.example.botomretrofit.posts.PostFragment
import com.example.botomretrofit.tab.TabFragment
import com.example.botomretrofit.users.UserFragment
import com.google.android.material.bottomnavigation.BottomNavigationView


class MainActivity : AppCompatActivity() {

    lateinit var photoFragment: PhotoFragment
    lateinit var postsFragment: PostFragment
    lateinit var userFragment: UserFragment
    lateinit var tabFragment: TabFragment


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.bootom)


        val botom_navigation: BottomNavigationView = findViewById(R.id.botom_navigation)
        botom_navigation.setOnNavigationItemSelectedListener { item ->

            when (item.itemId) {
                R.id.photo -> {

                    photoFragment =
                        PhotoFragment()

                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.frame_layout, photoFragment)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit()


                    true
                }
                R.id.posts -> {
                    postsFragment = PostFragment()

                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.frame_layout, postsFragment)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit()


                    true
                }
                R.id.users -> {
                    userFragment = UserFragment()

                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.frame_layout, userFragment)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit()


                    true
                }
                R.id.tabs -> {
                    tabFragment = TabFragment()

                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.frame_layout, tabFragment)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit()


                    true

                }
                else -> false
            }
        }


    }
}

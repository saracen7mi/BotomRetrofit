package com.example.botomretrofit.tab

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager.widget.ViewPager
import com.example.botomretrofit.R
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_tab_fragment.*
import kotlinx.android.synthetic.main.activity_tab_fragment.view.*

class TabFragment:Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view=inflater.inflate(R.layout.activity_tab_fragment, container, false)

        val viewPager = view.findViewById(R.id.pager) as ViewPager


        val adapter = SimpleFragmentPagerAdapter(activity!!.applicationContext,fragmentManager)

        viewPager.setAdapter(adapter)

        val tabLayout = view.findViewById(R.id.tab_layout) as TabLayout
        tabLayout.setupWithViewPager(viewPager)



return view
}}





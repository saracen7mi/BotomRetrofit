package com.example.botomretrofit.tab


import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager

import androidx.fragment.app.FragmentPagerAdapter
import com.example.botomretrofit.R


class SimpleFragmentPagerAdapter(context: Context, fm: FragmentManager?) :
    FragmentPagerAdapter(fm!!) {
    private val mContext: Context

    override fun getItem(position: Int): Fragment {
        return if (position == 0) {
            OneFragment()
        } else if (position == 1) {
            TwoFragment()
        } else if (position == 2) {
            ThreeFragment()
        } else {
            FourFragment()
        }
    }


    override fun getCount(): Int {
        return 4
    }


    override fun getPageTitle(position: Int): CharSequence? {
        return when (position) {
            0 -> mContext.getString(R.string.one)
            1 -> mContext.getString(R.string.two)
            2 -> mContext.getString(R.string.three)
            3 -> mContext.getString(R.string.four)
            else -> null
        }
    }

    init {
        mContext = context
    }
}
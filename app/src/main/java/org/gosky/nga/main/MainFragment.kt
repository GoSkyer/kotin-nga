package org.gosky.nga.main

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentStatePagerAdapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_main.*
import org.gosky.nga.R
import org.gosky.nga.databinding.FragmentMainBinding

class MainFragment : Fragment() {

    private val TAG = "MainFragment";
    private var groups: MutableList<Group> = mutableListOf()

    companion object {
        const val ARGUMENT_GROUPS = "groups"
        fun newInstance(groups: ArrayList<Group>): MainFragment {
            val fragment = MainFragment()
            val args = Bundle()
            args.putParcelableArrayList(ARGUMENT_GROUPS, groups);
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding = DataBindingUtil.inflate<FragmentMainBinding>(inflater, R.layout.fragment_main, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        groups = arguments?.getParcelableArrayList<Group>(ARGUMENT_GROUPS)?.toMutableList()!!
        vp_main.adapter = MainViewPagerAdapter()
        tl_main.setupWithViewPager(vp_main)
    }

    inner class MainViewPagerAdapter : FragmentStatePagerAdapter(childFragmentManager) {
        override fun getItem(position: Int): Fragment {
            return ForumFragment.newInstance(ArrayList(groups[position].forums), "")
        }

        override fun getCount(): Int {
            return groups.size
        }

        override fun getPageTitle(position: Int): CharSequence {
            return groups[position].name
        }

    }
}

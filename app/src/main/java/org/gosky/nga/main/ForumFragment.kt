package org.gosky.nga.main


import android.databinding.ObservableArrayList
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kale.adapter.CommonRcvAdapter
import kale.adapter.item.AdapterItem
import kotlinx.android.synthetic.main.fragment_forum.*
import kotlinx.android.synthetic.main.item_forum.view.*
import org.gosky.nga.R


class ForumFragment : Fragment() {

    private var mParam1: ArrayList<Forum>? = null
    private var mParam2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (arguments != null) {
            mParam1 = arguments.getParcelableArrayList<Forum>(ARG_PARAM1)
            mParam2 = arguments.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        return inflater?.inflate(R.layout.fragment_forum, container, false)
    }


    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rcv_forum.apply {
            layoutManager = GridLayoutManager(context, 3)

            adapter = object : CommonRcvAdapter<Forum>(ObservableArrayList<Forum>()
                    .apply { addAll(mParam1?.toList() ?: return@apply) }) {
                override fun createItem(p0: Any?): AdapterItem<*> {
                    return ForumItem()
                }
            }
        }

    }

    companion object {

        private val ARG_PARAM1 = "param1"
        private val ARG_PARAM2 = "param2"

        fun newInstance(param1: ArrayList<Forum>, param2: String): ForumFragment {
            val fragment = ForumFragment()
            val args = Bundle()
            args.putParcelableArrayList(ARG_PARAM1, param1)
            args.putString(ARG_PARAM2, param2)
            fragment.arguments = args
            return fragment
        }
    }

    class ForumItem : AdapterItem<Forum> {
        private lateinit var view: View
        override fun getLayoutResId(): Int {
            return R.layout.item_forum
        }

        override fun bindViews(p0: View) {
            view = p0
        }

        override fun setViews() {
        }

        override fun handleData(p0: Forum, p1: Int) {
            view.tvNameItemMain.text = p0.name
        }

    }


}

package org.gosky.nga.ui.activity

import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.MenuItem
import kale.adapter.CommonRcvAdapter
import kale.adapter.item.AdapterItem
import kotlinx.android.synthetic.main.activity_second_board.*
import kotlinx.android.synthetic.main.fragment_main.*

import org.gosky.nga.R
import org.gosky.nga.data.entity.BoardBean
import org.gosky.nga.di.component.RepoComponent
import org.gosky.nga.presenter.SecondBoardPresenter
import org.gosky.nga.ui.base.MvpActivity
import org.gosky.nga.ui.item.MainAdapter
import org.gosky.nga.view.SecondBoardView
import org.jetbrains.anko.startActivity
import java.util.*

class SecondBoardActivity : MvpActivity<SecondBoardPresenter>(),SecondBoardView {
    override fun initData() {
     Log.e(TAG,TAG)
    }

    override fun setupActivityComponent(repoComponent: RepoComponent?) {
        repoComponent?.inject(this)
    }

    override fun rootView(): Int {
       return R.layout.activity_second_board
    }

    override fun setupView() {
        setSupportActionBar(toolbar_second_board_activity)
        supportActionBar?.title= intent.extras["name"].toString()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        var list :ArrayList<BoardBean.ResultBean.GroupsBean.ForumsBean> = intent.getSerializableExtra("list") as ArrayList<BoardBean.ResultBean.GroupsBean.ForumsBean>
        Log.e("list","list"+list.toString());
        rcv_second_fragment.layoutManager = GridLayoutManager(mContext, 3, LinearLayoutManager.VERTICAL, false)
        rcv_second_fragment.adapter = object : CommonRcvAdapter<BoardBean.ResultBean.GroupsBean.ForumsBean>(list) {
            override fun createItem(p0: Any?): AdapterItem<*> {
                return MainAdapter(mContext)
            }

            override fun onItemClick(model: BoardBean.ResultBean.GroupsBean.ForumsBean?, position: Int) {
                super.onItemClick(model, position)
                if(model?.is_forumlist!!){
                    startActivity<SecondBoardActivity>("name" to model?.name.toString())
                }else{
                    startActivity<ForumActivity>("forumId" to model?.id.toString(),"name" to model?.name.toString())
                }

            }
        }
        rcv_second_fragment.adapter.notifyDataSetChanged()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> finish()
        }
        return super.onOptionsItemSelected(item)
    }


}

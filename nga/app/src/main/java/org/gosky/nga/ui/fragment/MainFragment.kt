package org.gosky.nga.ui.fragment

import android.annotation.SuppressLint
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.widget.Toast
import kale.adapter.CommonRcvAdapter
import kale.adapter.item.AdapterItem
import kotlinx.android.synthetic.main.fragment_main.*
import org.gosky.nga.R
import org.gosky.nga.data.entity.BoardBean
import org.gosky.nga.di.component.ActivityComponent
import org.gosky.nga.di.component.AppComponent
import org.gosky.nga.di.component.DaggerRepoComponent
import org.gosky.nga.presenter.MainPresenter
import org.gosky.nga.ui.activity.ForumActivity
import org.gosky.nga.ui.activity.SecondBoardActivity
import org.gosky.nga.ui.base.MvpFragment
import org.gosky.nga.ui.item.MainAdapter
import org.gosky.nga.view.MainView
import org.jetbrains.anko.support.v4.startActivity
import java.util.*


@SuppressLint("ValidFragment")
/**
 * @author guozhong
 * @date 2017/6/19
 */
class MainFragment(val list: ArrayList<BoardBean.ResultBean.GroupsBean.ForumsBean>) : MvpFragment<MainPresenter>(), MainView {
    override fun showBoard(mList: MutableList<BoardBean.ResultBean.GroupsBean>?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    override fun setupFragmentComponent(appComponent: AppComponent, activityComponent: ActivityComponent) {
        DaggerRepoComponent
                .builder()
                .appComponent(appComponent)
                .activityComponent(activityComponent)
                .build()
                .inject(this)
    }

    override fun rootView(): Int {
        return R.layout.fragment_main
    }

    @SuppressLint("NewApi")
    override fun setupView() {
        rcv_main_fragment.layoutManager = GridLayoutManager(mContext, 3, LinearLayoutManager.VERTICAL, false);
        rcv_main_fragment.adapter = object : CommonRcvAdapter<BoardBean.ResultBean.GroupsBean.ForumsBean>(list) {
            override fun createItem(p0: Any?): AdapterItem<*> {
                return MainAdapter(mContext)
            }

            override fun onItemClick(model: BoardBean.ResultBean.GroupsBean.ForumsBean?, position: Int) {
                super.onItemClick(model, position)
                if(model?.isIs_forumlist!!){
                    startActivity<SecondBoardActivity>("list" to model?.forums,"name" to model?.name.toString())
                }else{
                    startActivity<ForumActivity>("forumId" to model?.id.toString(),"name" to model?.name.toString())
                }

            }
        }
        rcv_main_fragment.adapter.notifyDataSetChanged()
    }

    override fun initData() {

    }


}


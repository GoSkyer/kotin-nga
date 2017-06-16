package org.gosky.nga.ui.activity;

import android.Manifest;
import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.sdsmdg.tastytoast.TastyToast;
import com.tbruyelle.rxpermissions.RxPermissions;

import org.gosky.nga.R;
import org.gosky.nga.di.component.AppComponent;
import org.gosky.nga.di.component.DaggerRepoComponent;
import org.gosky.nga.presenter.MainPresenter;
import org.gosky.nga.ui.base.MvpActivity;
import org.gosky.nga.ui.fragment.HomeFragment;
import org.gosky.nga.ui.fragment.LoanFragment;
import org.gosky.nga.ui.fragment.MineFragment;
import org.gosky.nga.ui.fragment.RecommendFragment;
import org.gosky.nga.view.MainView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * Created by guozhong on 16/10/24.
 */

public class MainActivity extends MvpActivity<MainPresenter> implements MainView, ViewPager.OnPageChangeListener {
    @Bind(R.id.vp_main)
    ViewPager vpMain;
    @Bind(R.id.iv_home_main)
    ImageView ivHomeMain;
    @Bind(R.id.tv_home_main)
    TextView tvHomeMain;
    @Bind(R.id.ll_home_main)
    LinearLayout llHomeMain;
    @Bind(R.id.iv_loan_main)
    ImageView ivLoanMain;
    @Bind(R.id.tv_loan_main)
    TextView tvLoanMain;
    @Bind(R.id.ll_loan_main)
    LinearLayout llLoanMain;
    @Bind(R.id.iv_recommend_main)
    ImageView ivRecommendMain;
    @Bind(R.id.tv_recommend_main)
    TextView tvRecommendMain;
    @Bind(R.id.ll_recommend_main)
    LinearLayout llRecommendMain;
    @Bind(R.id.iv_mine_main)
    ImageView ivMineMain;
    @Bind(R.id.tv_mine_main)
    TextView tvMineMain;
    @Bind(R.id.ll_mine_main)
    LinearLayout llMineMain;


    @Override
    protected void setupActivityComponent(AppComponent appComponent) {
        DaggerRepoComponent.builder()
                .appComponent(appComponent)
                .build()
                .inject(this);
    }


    @Override
    protected int rootView() {
        return R.layout.activity_main;
    }

    @Override
    protected void setupView() {
        ivHomeMain.setImageResource(R.mipmap.zhuye_n);
        tvHomeMain.setTextColor(Color.parseColor("#267abe"));
        List<Fragment> fragmentList = new ArrayList<Fragment>();
        fragmentList.add(new HomeFragment());
        fragmentList.add(new LoanFragment());
        fragmentList.add(new RecommendFragment());
        fragmentList.add(new MineFragment());
        vpMain.setAdapter(new MainFragmentPagerAdapter(getSupportFragmentManager(), fragmentList));
        vpMain.setOffscreenPageLimit(4);
        vpMain.addOnPageChangeListener(this);
        RxPermissions.getInstance(this)
                .request(Manifest.permission.ACCESS_FINE_LOCATION,
                        Manifest.permission.READ_PHONE_STATE,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE)
                .subscribe(granted -> {
                    if (granted) {
                        // All requested permissions are granted
                    } else {
                        // At least one permission is denied
                        showToast("软件可能无法正常使用", TastyToast.ERROR);
                    }
                });

    }

    @Override
    protected void initData() {

    }

    @Override
    public void showContent(String str) {

    }


    @OnClick({R.id.ll_home_main, R.id.ll_loan_main, R.id.ll_recommend_main, R.id.ll_mine_main})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ll_home_main:
                vpMain.setCurrentItem(0);
                break;
            case R.id.ll_loan_main:
                vpMain.setCurrentItem(1);
                break;
            case R.id.ll_recommend_main:
                vpMain.setCurrentItem(2);
                break;
            case R.id.ll_mine_main:
                vpMain.setCurrentItem(3);
                break;
        }
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        setNormal();
        switch (position) {
            case 0:
                ivHomeMain.setImageResource(R.mipmap.zhuye_n);
                tvHomeMain.setTextColor(Color.parseColor("#267abe"));
                break;
            case 1:
                ivLoanMain.setImageResource(R.mipmap.daikuan_n);
                tvLoanMain.setTextColor(Color.parseColor("#267abe"));
                break;
            case 2:
                ivRecommendMain.setImageResource(R.mipmap.jingzhun_n);
                tvRecommendMain.setTextColor(Color.parseColor("#267abe"));
                break;
            case 3:
                ivMineMain.setImageResource(R.mipmap.wode_n);
                tvMineMain.setTextColor(Color.parseColor("#267abe"));
                break;
        }
    }

    private void setNormal() {
        ivHomeMain.setImageResource(R.mipmap.zhuye_d);
        ivLoanMain.setImageResource(R.mipmap.daikuan_d);
        ivRecommendMain.setImageResource(R.mipmap.jingzhun_d);
        ivMineMain.setImageResource(R.mipmap.wode_d);
        tvHomeMain.setTextColor(Color.parseColor("#929292"));
        tvLoanMain.setTextColor(Color.parseColor("#929292"));
        tvRecommendMain.setTextColor(Color.parseColor("#929292"));
        tvMineMain.setTextColor(Color.parseColor("#929292"));
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    class MainFragmentPagerAdapter extends FragmentPagerAdapter {
        private List<Fragment> mFragmentList;

        public MainFragmentPagerAdapter(FragmentManager fm, List<Fragment> fragmentList) {
            super(fm);
            mFragmentList = fragmentList;
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }
    }

}

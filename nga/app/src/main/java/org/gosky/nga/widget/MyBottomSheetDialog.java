package org.gosky.nga.widget;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomSheetBehavior;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.yqritc.recyclerviewflexibledivider.HorizontalDividerItemDecoration;

import org.gosky.nga.R;

import java.util.ArrayList;
import java.util.List;

import kale.adapter.CommonRcvAdapter;
import kale.adapter.item.AdapterItem;
import me.shaohui.bottomdialog.BaseBottomDialog;

/**
 * Created by guozhong on 16/10/27.
 */

public class MyBottomSheetDialog extends BaseBottomDialog {

    protected RecyclerView rcvBottomSheet;
    private List<String> list;
    private onItemClick onItemClick;
    private BottomSheetBehavior bottomSheetBehavior;

    @Override
    public int getLayoutRes() {
        return R.layout.dialog_my_bottom_sheet;
    }

    @Override
    public void bindView(View v) {
        initView(v);
        rcvBottomSheet.addItemDecoration(new HorizontalDividerItemDecoration.Builder(getContext()).color(0xff999999).size(2).build());
        rcvBottomSheet.setAdapter(new CommonRcvAdapter<String>(list) {
            @NonNull
            @Override
            public AdapterItem createItem(Object o) {
                return new BottomSheetItem();
            }

            @Override
            protected void onItemClick(String model, int position) {
                super.onItemClick(model, position);
                onItemClick.onClick(model);
                dismiss();
            }
        });
    }

    public void setList(List mList) {
        list = new ArrayList<>();
        list.clear();
        list.addAll(mList);
        if (rcvBottomSheet != null)
            ((CommonRcvAdapter) rcvBottomSheet.getAdapter()).setData(list);
    }

    private void initView(View v) {
        rcvBottomSheet = (RecyclerView) v.findViewById(R.id.rcv_bottom_sheet);
        rcvBottomSheet.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    public void setOnItemClick(MyBottomSheetDialog.onItemClick onItemClick) {
        this.onItemClick = onItemClick;
    }

    @Override
    public int getHeight() {
        if (list.size() > 5)
            return 500;
        else
            return -1;
    }

    public void showWith(List mList, MyBottomSheetDialog.onItemClick onItemClick, FragmentManager fragmentManager) {
        setList(mList);
        setOnItemClick(onItemClick);
        super.show(fragmentManager);
    }

    public interface onItemClick {
        void onClick(String arg0);
    }

    class BottomSheetItem implements AdapterItem<String> {

        protected View rootView;
        protected TextView tvItemBottomSheet;

        @Override
        public int getLayoutResId() {
            return R.layout.item_my_bottom_sheet;
        }

        @Override
        public void bindViews(View view) {
            rootView = view;
            initView(view);
        }

        @Override
        public void setViews() {

        }

        @Override
        public void handleData(String s, int i) {
            tvItemBottomSheet.setText(s);
        }

        @Override
        public void OnRootClickListener(String s, int i) {

        }

        private void initView(View rootView) {
            tvItemBottomSheet = (TextView) rootView.findViewById(R.id.tv_item_bottom_sheet);
        }
    }
}

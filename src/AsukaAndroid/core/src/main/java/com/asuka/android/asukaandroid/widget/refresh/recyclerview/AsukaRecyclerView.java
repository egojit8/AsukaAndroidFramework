package com.asuka.android.asukaandroid.widget.refresh.recyclerview;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.ViewGroup;

import com.asuka.android.asukaandroid.comm.utils.LogUtil;
import com.asuka.android.asukaandroid.widget.refresh.IRefreshView;
import com.asuka.android.asukaandroid.widget.refresh.RecyclerRefreshLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by egojit on 16/9/29.
 */
public class AsukaRecyclerView extends RecyclerRefreshLayout implements IRefreshView {

    RecyclerView recyclerView;

    boolean isCanRefresh = true;
    private Refresh onRefresh;

    private List<? extends Object> list;
    private BaseListAdapter adapter;

    private UITableViewDelegate delegate;

    public AsukaRecyclerView(Context context) {
        this(context, null);
    }

    public AsukaRecyclerView(Context context, AttributeSet attrs) {
        super(context, attrs);
        list = new ArrayList();
        recyclerView = new RecyclerView(context);

        LayoutParams layoutParams = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
        addView(recyclerView, layoutParams);
        init();
    }


    private void init() {
        if (isCanRefresh) {
            setNestedScrollingEnabled(true);
            setOnRefreshListener(new RefreshEventDetector());
        } else {
            setEnabled(false);
        }

    }



    @Override
    public void setData(final List<? extends Object> list, final UITableViewDelegate delegate) {
        this.list=list;
        this.delegate=delegate;
        if(adapter==null){
            LinearLayoutManager manager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
            recyclerView.setLayoutManager(manager);
            adapter = new BaseListAdapter(getContext(), this.list);
            recyclerView.setAdapter(adapter);
        }

        adapter.notifyDataSetChanged();
    }

    @Override
    public void setRefreshEnable(boolean isCan) {
        this.isCanRefresh = isCan;
    }

    @Override
    public void stopRefresh() {
        setRefreshing(false);
    }

    @Override
    public void setCellView(CellView cellView) {

    }

    @Override
    public void setOnRefresh(Refresh onRefresh) {
        this.onRefresh = onRefresh;
    }


    public class RefreshEventDetector implements RecyclerRefreshLayout.OnRefreshListener {

        @Override
        public void onRefresh() {
            if (onRefresh != null) {
                onRefresh.onRefresh();
            } else {
                LogUtil.e("请设置刷新回调!");
            }

        }
    }






    //=======================适配器

    /**
     * Auther:egojit
     * Time:2016-1-28
     * QQ:408365330
     * Mark:基础列表适配器
     */
    private class BaseListAdapter<T extends BaseViewHolder> extends android.support.v7.widget.RecyclerView.Adapter {

        private List<?> mList;

        public BaseListAdapter(Context context, List<?> list) {
            this.mList = list;
        }

        @Override
        public int getItemViewType(int position) {
            return position;
        }

        @Override
        public android.support.v7.widget.RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

            if (AsukaRecyclerView.this.delegate != null)
                return AsukaRecyclerView.this.delegate.getItemViewHolder(parent, viewType);
            else {
                LogUtil.e("请给RecyclerView设置delegate");
                return null;
            }
        }

        @Override
        public void onBindViewHolder(android.support.v7.widget.RecyclerView.ViewHolder viewHolder, int position) {
            LogUtil.d("onBindViewHolder, i: " + position + ", viewHolder: " + viewHolder);
            T holder = (T) viewHolder;
            holder.position = position;
            if (AsukaRecyclerView.this.delegate != null)
                AsukaRecyclerView.this.delegate.onBindData(holder, position);
            else {
                LogUtil.e("请给RecyclerView设置delegate");

            }

        }

        @Override
        public int getItemCount() {
            if (mList != null)
                return mList.size();
            return 0;
        }
    }


}

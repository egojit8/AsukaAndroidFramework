package com.asuka.android.asukaandroid.widget.refresh.recyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

/**
 * Auther:egojit
 * Time:2016-1-28
 * QQ:408365330
 * Mark:UITableView 代理
 */
public interface UITableViewDelegate {

    /**
     * @param parent
     * @param viewType
     * @return
     */
    public RecyclerView.ViewHolder getItemViewHolder(ViewGroup parent, int viewType);


    /**
     * 绑定数据
     */
    public void onBindData(BaseViewHolder hoderView, int position);
}

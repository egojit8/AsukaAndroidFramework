package com.asuka.android.asukaandroid.view.listview.adapter;/**
 * Created by egojit on 2016/9/11.
 */

/************************************************************
 * Auther:Egojit
 * Time:2016-07-20
 * Mark:**********
 ***********************************************************/

import android.view.View;

/**
 * Created by Mr.Jude on 2015/8/18.
 */
public interface EventDelegate {
    void addData(int length);
    void clear();

    void stopLoadMore();
    void pauseLoadMore();
    void resumeLoadMore();

    void setMore(View view, RecyclerArrayAdapter.OnLoadMoreListener listener);
    void setNoMore(View view);
    void setErrorMore(View view);
}

package com.asuka.android.asukaandroid.view.listview;

import android.view.View;

import com.alibaba.fastjson.JSONArray;

/**
 * Created by egojit on 16/9/9.
 */
public interface AsukaListView {

    /**
     * 设置数据源
     * @param list
     */
    public void setDataSource(JSONArray list);

    /**
     * 设置空视图
     * @param view
     */
    public void setEmptyView(View view);

    /**
     * 是否可以下拉
     */
    public void setPullToDownEnable(boolean canPull);
}

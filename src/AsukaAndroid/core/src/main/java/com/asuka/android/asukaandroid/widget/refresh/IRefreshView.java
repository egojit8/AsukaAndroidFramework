package com.asuka.android.asukaandroid.widget.refresh;

import android.view.View;

import com.asuka.android.asukaandroid.widget.refresh.recyclerview.AsukaRecyclerView;
import com.asuka.android.asukaandroid.widget.refresh.recyclerview.UITableViewDelegate;

import java.util.List;

/**
 * Created by egojit on 16/9/29.
 */
public interface IRefreshView {


    public void setData(final List<? extends Object> list, final UITableViewDelegate delegate);

    public void setRefreshEnable(boolean isCan);

    public void stopRefresh();




    public void setCellView(CellView cellView);




    public void setOnRefresh(Refresh onRefresh);


    public interface CellView{
        public void onView(View cellView);
    };


    public interface Refresh{
        public void onRefresh();
    }
}

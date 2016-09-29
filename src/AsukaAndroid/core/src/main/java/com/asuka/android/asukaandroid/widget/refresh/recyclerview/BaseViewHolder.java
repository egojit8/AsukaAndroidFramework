package com.asuka.android.asukaandroid.widget.refresh.recyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Auther:egojit
 * Time:2016-1-28
 * QQ:408365330
 * Mark:ViewHolder 基类
 */
public abstract class BaseViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {

    public int position;

    public BaseViewHolder(View itemView) {
        super(itemView);
        itemView.setOnClickListener(this);
        itemView.setOnLongClickListener(this);
    }

    @Override
    public abstract void onClick(View view);

    @Override
    public abstract boolean onLongClick(View view);
}

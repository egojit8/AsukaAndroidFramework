package com.asuka.android.asukaandroid.demo;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.asuka.android.asukaandroid.AsukaActivity;
import com.asuka.android.asukaandroid.demo.model.User;
import com.asuka.android.asukaandroid.orm.query.Select;
import com.asuka.android.asukaandroid.view.annotation.ContentView;
import com.asuka.android.asukaandroid.view.annotation.ViewInject;
import com.asuka.android.asukaandroid.widget.refresh.IRefreshView;
import com.asuka.android.asukaandroid.widget.refresh.recyclerview.AsukaRecyclerView;
import com.asuka.android.asukaandroid.widget.refresh.recyclerview.BaseViewHolder;
import com.asuka.android.asukaandroid.widget.refresh.recyclerview.UITableViewDelegate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@ContentView(R.layout.activity_main)
public class MainActivity extends AsukaActivity {

    @ViewInject(R.id.txtName)
    private TextView txtName;

    @ViewInject(R.id.recyList)
    private AsukaRecyclerView recyList;
    List<User> users=new ArrayList<User>();

    private final Handler mHandler = new Handler(Looper.getMainLooper());
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStatusBarTintResource(R.color.colorPrimary);

        User user=new User();
        user.setName("egojit");
        user.setPwd("pwd");
        user.update();

        recyList.setRefreshEnable(true);
        recyList.setOnRefresh(new IRefreshView.Refresh() {
            @Override
            public void onRefresh() {
                getData();
            }
        });


    }

    private void getData(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                users= new Select().from(User.class).execute();
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        recyList.setData(users, new UITableViewDelegate() {
                            @Override
                            public RecyclerView.ViewHolder getItemViewHolder(ViewGroup parent, int viewType) {

                                ItemViewHolder holder=new ItemViewHolder(LayoutInflater.from(
                                        MainActivity.this).inflate(R.layout.list_item_main, parent,
                                        false));
                                return holder;
                            }

                            @Override
                            public void onBindData(BaseViewHolder hoderView, int position) {
                                ItemViewHolder  itemViewHolder=(ItemViewHolder)hoderView;
                                User u=users.get(position);
                                itemViewHolder.textView.setText(u.getName());
                            }
                        });
                        recyList.stopRefresh();
                    }
                });


            }
        }).start();
    }


    @Override
    protected void onResume() {
        super.onResume();
        List<User> users= new Select().from(User.class).execute();
//        txtName.setText("用户名："+users.get(0).getName()+" 总共"+users.size()+"条数据");
    }

    @Override
    protected void refrehView() {

    }



    private class ItemViewHolder extends BaseViewHolder {

        private TextView textView;

        public ItemViewHolder(View itemView) {
            super(itemView);
            textView=(TextView)itemView.findViewById(R.id.txtName);


        }

        @Override
        public void onClick(View view) {

        }

        @Override
        public boolean onLongClick(View view) {
            return false;
        }


    }


}

package com.asuka.android.asukaandroid.demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.asuka.android.asukaandroid.AsukaActivity;
import com.asuka.android.asukaandroid.AsukaAndroid;
import com.asuka.android.asukaandroid.demo.model.User;
import com.asuka.android.asukaandroid.orm.query.Select;
import com.asuka.android.asukaandroid.view.annotation.ContentView;
import com.asuka.android.asukaandroid.view.annotation.ViewInject;

import java.util.List;

@ContentView(R.layout.activity_main)
public class MainActivity extends AsukaActivity {

    @ViewInject(R.id.txtName)
    private TextView txtName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStatusBarTintResource(R.color.colorPrimary);

        User user=new User();
        user.setName("egojit");
        user.setPwd("pwd");
        user.update();
    }

    @Override
    protected void onResume() {
        super.onResume();
        List<User> users= new Select().from(User.class).execute();
        txtName.setText("用户名："+users.get(0).getName()+" 总共"+users.size()+"条数据");
    }
}

package com.asuka.android.asukaandroid.demo.model;/**
 * Created by egojit on 2016/9/12.
 */

import com.asuka.android.asukaandroid.orm.Model;
import com.asuka.android.asukaandroid.orm.annotation.Column;
import com.asuka.android.asukaandroid.orm.annotation.Table;
import com.asuka.android.asukaandroid.orm.query.Select;

/************************************************************
 * Auther:Egojit
 * Time:2016-07-20
 * Mark:**********
 ***********************************************************/
@Table(name = "user")
public class User extends Model {

    @Column(name = "name")
    private String name;

    @Column(name = "pwd")
    private String pwd;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public void update(){
        User user= new Select().from(User.class).where("name=\""+name+"\" and pwd=\""+pwd+"\"").executeSingle();
        if(user==null){
            save();
        }else {
            user.pwd=pwd;
            user.name=name;
            user.save();
        }
    }
}

package com.example.maniuclass.recyclerview_vm;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

public class ItemBean extends BaseObservable {
    private String uname;
    private String upwd;

    public ItemBean(String uName, String uPwd) {
        this.uname = uName;
        this.upwd = uPwd;
    }

    public ItemBean() {
        this.uname = "";
        this.upwd = "";
    }

    @Bindable
    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    @Bindable
    public String getUpwd() {
        return upwd;
    }

    public void setUpwd(String upwd) {
        this.upwd = upwd;
    }
}
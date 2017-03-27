package com.example.loginmvp.model;

import com.example.loginmvp.bean.User;

/**
 * Created by Administrator on 2017/2/8.
 */

public interface LoginModel {
    void login(String username, String password, RequestCallback<User> requese);
}

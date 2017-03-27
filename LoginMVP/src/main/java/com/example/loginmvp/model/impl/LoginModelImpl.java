package com.example.loginmvp.model.impl;

import com.example.loginmvp.bean.User;
import com.example.loginmvp.model.LoginModel;
import com.example.loginmvp.model.RequestCallback;

/**
 * Created by Administrator on 2017/2/8.
 */

public class LoginModelImpl implements LoginModel {
    @Override
    public void login(final String username, final String password, final RequestCallback<User> callBack) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2 * 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (username.equals("longyu") && password.equals("123456")) {
                    User user = new User();
                    user.setUserName(username);
                    user.setPassword(password);
                    callBack.onSuccess(user);
                } else {
                    callBack.onFailure("登录失败");
                }
            }
        }).start();
    }
}

package com.example.loginmvp.view;

import com.example.loginmvp.bean.User;

/**
 * Created by Administrator on 2017/2/8.
 */

public interface LoginView {

    String getUserName();

    String getPassword();

    void showLoading();

    void hideLoading();

    void toMainActivity(User user);

    void showFailedEerror(String msg);

}

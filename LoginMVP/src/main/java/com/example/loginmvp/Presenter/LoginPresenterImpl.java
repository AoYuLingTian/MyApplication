package com.example.loginmvp.Presenter;

import android.os.Handler;

import com.example.loginmvp.bean.User;
import com.example.loginmvp.model.LoginModel;
import com.example.loginmvp.model.RequestCallback;
import com.example.loginmvp.model.impl.LoginModelImpl;
import com.example.loginmvp.view.LoginView;

/**
 * Created by Administrator on 2017/2/8.
 */

public class LoginPresenterImpl implements LoginPresenter {

    private LoginModel mLoginModel;

    private LoginView mLoginView;

    private Handler mHandler =  new Handler();


    public LoginPresenterImpl(LoginView mLoginView) {
        this.mLoginModel = new LoginModelImpl();
        this.mLoginView = mLoginView;
    }

    @Override
    public void login() {
        mLoginView.showLoading();
        mLoginModel.login(mLoginView.getUserName(), mLoginView.getPassword(), new RequestCallback<User>() {
            @Override
            public void onSuccess(final User data) {
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        mLoginView.toMainActivity(data);
                        mLoginView.hideLoading();
                    }
                });
            }

            @Override
            public void onFailure(final String msg) {
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        mLoginView.showFailedEerror(msg);
                        mLoginView.hideLoading();
                    }
                });
            }
        });
    }
}

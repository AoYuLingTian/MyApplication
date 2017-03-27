package com.example.loginmvp.model;

/**
 * Created by Administrator on 2017/2/8.
 */

public interface RequestCallback<T> {

    void onSuccess(T data);

    void onFailure(String msg);
}

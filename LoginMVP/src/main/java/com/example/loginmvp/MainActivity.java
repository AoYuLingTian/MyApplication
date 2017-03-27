package com.example.loginmvp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.loginmvp.Presenter.LoginPresenterImpl;
import com.example.loginmvp.bean.User;

public class MainActivity extends AppCompatActivity implements com.example.loginmvp.view.LoginView {

    private EditText userName;

    private EditText password;

    private TextView LoginView;

    private LoginPresenterImpl mLoginPresenter = new LoginPresenterImpl(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        userName = (EditText) findViewById(R.id.userName);
        password = (EditText) findViewById(R.id.password);
        LoginView = (TextView) findViewById(R.id.login_text);

        LoginView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mLoginPresenter.login();
            }
        });

    }

    @Override
    public String getUserName() {
        return userName.getText().toString();
    }

    @Override
    public String getPassword() {
        return password.getText().toString();
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void toMainActivity(User user) {
        Toast.makeText(this, user.getUserName(), 0).show();
    }

    @Override
    public void showFailedEerror(String msg) {
        Toast.makeText(this, msg, 0).show();
    }
}

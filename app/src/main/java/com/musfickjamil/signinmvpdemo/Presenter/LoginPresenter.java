package com.musfickjamil.signinmvpdemo.Presenter;

import com.musfickjamil.signinmvpdemo.Model.User;
import com.musfickjamil.signinmvpdemo.View.ILoginView;

public class LoginPresenter implements ILoginPresenter {

    ILoginView mLoginView;

    public LoginPresenter(ILoginView mLoginView) {
        this.mLoginView = mLoginView;
    }

    @Override
    public void onLogin(String email, String password) {

        User user = new User(email,password);
        int isLoginSuccess = user.inValidData();

        if(isLoginSuccess == 0)
        {
            mLoginView.onLoginSuccess("Login Success");
        }
        else
        {
            mLoginView.onLoginError("Please enter email & password");
        }
    }
}

package com.musfickjamil.signinmvpdemo.Model;

import android.text.TextUtils;
import android.util.Patterns;

import java.util.regex.Pattern;

public class User implements IUser {

    private String mEmail;
    private String mPassword;

    public User(String mEmail, String mPassword) {
        this.mEmail = mEmail;
        this.mPassword = mPassword;
    }


    @Override
    public String getEmail() {
        return mEmail;
    }

    @Override
    public String getPassword() {
        return mPassword;
    }

    @Override
    public int inValidData() {

        if(getEmail().equals("abcd@gmail.com") && getPassword().equals("123456"))
        {
            return 0;
        }
        else if(TextUtils.isEmpty(getEmail())||TextUtils.isEmpty(getPassword()))
        {
            return 1;
        }
        else
        {
            return -1;
        }

    }
}

package com.musfickjamil.signinmvpdemo.Activity;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.musfickjamil.signinmvpdemo.Presenter.ILoginPresenter;
import com.musfickjamil.signinmvpdemo.Presenter.LoginPresenter;
import com.musfickjamil.signinmvpdemo.R;
import com.musfickjamil.signinmvpdemo.View.ILoginView;

import es.dmoral.toasty.Toasty;

public class MainActivity extends Activity implements View.OnClickListener, ILoginView {

    private EditText mEmailET;
    private EditText mPasswordET;
    private Button mLoginBTN;
    private ILoginPresenter mLoginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Init View
        mEmailET = (EditText)findViewById(R.id.etemail);
        mPasswordET = (EditText)findViewById(R.id.etPassWord);
        mLoginBTN = (Button)findViewById(R.id.btnlogin);

        //Init
        mLoginBTN.setOnClickListener(this);
        mLoginPresenter = new LoginPresenter(this);
    }

    @Override
    public void onClick(View v) {

        String email = mEmailET.getText().toString();
        String password = mPasswordET.getText().toString();

        //Perform login click
        mLoginPresenter.onLogin(email,password);
    }


    @Override
    public void onLoginSuccess(String message) {
        Toasty.success(this,message,Toasty.LENGTH_SHORT).show();
    }

    @Override
    public void onLoginError(String message) {
        Toasty.error(this,message,Toasty.LENGTH_SHORT).show();
    }
}

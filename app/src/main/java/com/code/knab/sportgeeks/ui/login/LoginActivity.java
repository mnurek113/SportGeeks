package com.code.knab.sportgeeks.ui.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.code.knab.sportgeeks.R;
import com.code.knab.sportgeeks.ui.login.mvp.LoginMVP;
import com.code.knab.sportgeeks.ui.login.mvp.LoginModel;
import com.code.knab.sportgeeks.ui.login.mvp.LoginPresenter;
import com.code.knab.sportgeeks.ui.sign_up.SignUpActivity;
import com.code.knab.sportgeeks.ui.welcome.WelcomeActivity;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

public class LoginActivity extends AppCompatActivity implements LoginMVP.View {

    private LoginPresenter presenter;

    private TextInputEditText emailEditText;
    private TextInputEditText passwordEditText;
    private MaterialButton registerButton;
    private MaterialButton loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        presenter = new LoginPresenter(this, new LoginModel());

        emailEditText = findViewById(R.id.loginEditText);
        passwordEditText = findViewById(R.id.passwEditText);
        registerButton = findViewById(R.id.registerButton);
        loginButton = findViewById(R.id.loginButton);

        registerButton.setOnClickListener(view -> {
            startRegisterActivity();
        });

        loginButton.setOnClickListener(view -> {
            presenter.login(emailEditText.getText().toString(), passwordEditText.getText().toString());
        });
    }

    private void startRegisterActivity() {
        Intent intent = new Intent(this, SignUpActivity.class);
        startActivity(intent);
    }


    @Override
    public void onLoginSuccessful(Long userId) {
        Intent intent = new Intent(this, WelcomeActivity.class);
        intent.putExtra("userId", userId);
        startActivity(intent);
        this.finish();
    }

    @Override
    public void onLoginFailed() {

    }
}

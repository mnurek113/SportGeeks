package com.code.knab.sportgeeks.ui.sign_up;

import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.code.knab.sportgeeks.R;
import com.code.knab.sportgeeks.ui.sign_up.mvp.SignUpMVP;
import com.code.knab.sportgeeks.ui.sign_up.mvp.SignUpModel;
import com.code.knab.sportgeeks.ui.sign_up.mvp.SignUpPresenter;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;

public class SignUpActivity extends AppCompatActivity implements SignUpMVP.View {

    private SignUpPresenter presenter;

    private TextInputEditText nameEditText;
    private TextInputEditText emailEditText;
    private TextInputEditText passwordEditText;
    private TextInputEditText repeatPasswordEditText;
    private MaterialButton signUpButton;
    private RadioGroup sexRadioGroup;
    private RadioButton maleRadioButton;
    private RadioButton femaleRadioButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        presenter = new SignUpPresenter(new SignUpModel(),this);

        nameEditText = findViewById(R.id.nameEditText);
        emailEditText = findViewById(R.id.emailEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        repeatPasswordEditText = findViewById(R.id.repeatPasswordEditText);
        signUpButton = findViewById(R.id.signUpButton);
        maleRadioButton = findViewById(R.id.maleRadioButton);
        femaleRadioButton = findViewById(R.id.femaleRadioButton);


        signUpButton.setOnClickListener(v -> signUp());

    }

    private void signUp() {
        String sex="";
        if(maleRadioButton.isChecked())
            sex = "MALE";
        else if (femaleRadioButton.isChecked())
            sex = "FEMALE";

        presenter.signUp(emailEditText.getText().toString(),
                passwordEditText.getText().toString(),
                repeatPasswordEditText.getText().toString(),
                nameEditText.getText().toString(),
                sex);
    }

    @Override
    public void onSignUpSuccessful(Long userId) {
        Toast.makeText(this, "HELLLLLLOOOO",Toast.LENGTH_SHORT).show();

    }
}

package com.thener.animation.Auth;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

import com.google.firebase.FirebaseException;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;
import com.thener.animation.R;

import java.util.concurrent.TimeUnit;

public class Login extends AppCompatActivity {


    private LinearLayout mPhoneLayout;
    private LinearLayout mCodeLayout;

    private EditText mPhoneText;
    private EditText mCodeText;

    private ProgressBar mPhoneBar;
    private ProgressBar mCodeBar;

    private Button mSendBtn;

    private PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallbacks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mPhoneLayout = findViewById(R.id.phone_layout);
        mCodeLayout = findViewById(R.id.Code_layout);
        mCodeLayout.setVisibility(View.INVISIBLE);

        mPhoneText = findViewById(R.id.PhoneEditText);
        mCodeText = findViewById(R.id.CodeEditText);

        mPhoneBar = findViewById(R.id.PhoneProgress);
        mPhoneBar.setVisibility(View.INVISIBLE);
        mCodeBar = findViewById(R.id.CodeProgress);

        mSendBtn = findViewById(R.id.Send_Verification_Btn);

        mSendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mPhoneBar.setVisibility(View.VISIBLE);
                mPhoneText.setEnabled(false);
                mSendBtn.setEnabled(false);

                String phoneNumber = mPhoneText.getText().toString();

                PhoneAuthProvider.getInstance().verifyPhoneNumber(
                        phoneNumber,
                        60,
                        TimeUnit.SECONDS,
                        Login.this,
                        mCallbacks
                );

            }
        });

        mCallbacks = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
            @Override
            public void onVerificationCompleted(PhoneAuthCredential phoneAuthCredential) {

            }

            @Override
            public void onVerificationFailed(FirebaseException e) {

            }
        };

    }
}

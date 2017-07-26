package com.codevibes.sami.uowsdgpcw2mobileapplicationhotelapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class CreateAccount extends AppCompatActivity implements View.OnClickListener {


    //Declaring view objects
    private Button Register_b;
    private EditText Email_create_acc;
    private EditText Password_create_acc;
    private TextView Login_text;
    private ProgressDialog progressDialog;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);

        progressDialog = new ProgressDialog(this);
        firebaseAuth = FirebaseAuth.getInstance();

        Register_b = (Button) findViewById(R.id.Register_b);
        Email_create_acc = (EditText) findViewById(R.id.Email_create_acc);
        Password_create_acc = (EditText) findViewById(R.id.Password_create_acc);
        Login_text = (TextView) findViewById(R.id.Login_text);
        Register_b.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view == Register_b) {
            createAccount();
        } else if (view == Login_text) {
            startActivity(new Intent(CreateAccount.this, Login.class));
        }
    }

    public void createAccount() {

        String email = Email_create_acc.getText().toString().trim();
        String passsword = Password_create_acc.getText().toString().trim();

        if (TextUtils.isEmpty(email)) {
            // If email address field is empty
            Toast.makeText(this, "Please enter your email address", Toast.LENGTH_SHORT).show();
            return;
        }

        if (TextUtils.isEmpty(passsword)) {
            // password is empty
            Toast.makeText(this, "Please enter a Password", Toast.LENGTH_SHORT).show();
            return;
        }

        progressDialog.setMessage("Creating account...");
        progressDialog.show();

        firebaseAuth.createUserWithEmailAndPassword(email, passsword)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                progressDialog.dismiss();
                                if (task.isSuccessful()) {
                                    finish();
                                    startActivity(new Intent(getApplicationContext(), ProfileSplash.class));
                                }
                            }
                        }
                );

    }

}



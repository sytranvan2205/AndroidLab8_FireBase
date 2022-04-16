package com.example.androidlab8_firebase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class Login_Activity extends AppCompatActivity {
    Button btnLogin;
    EditText Password;
    EditText Email;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        createControl();
        firebaseAuth = FirebaseAuth.getInstance();
        createEvents();
    }

    private void createEvents() {
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = Email.getText().toString().trim();
                String password = Password.getText().toString().trim();

                firebaseAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(Login_Activity.this,"Logied in Successfully",Toast.LENGTH_LONG).show();
                        }
                        else{
                            Toast.makeText(Login_Activity.this, "Error !!!", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
    }

    private void createControl() {
        Email = this.<EditText>findViewById(R.id.edt_email);
        Password = this.<EditText>findViewById(R.id.edtPassword1);
        btnLogin = this.<Button>findViewById(R.id.btnSignIn1);
    }
}
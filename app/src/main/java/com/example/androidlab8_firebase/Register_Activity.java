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
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Register_Activity extends AppCompatActivity {
    Button btn_register;
    EditText edtName;
    EditText edtEmail;
    EditText edtPass;
    EditText edtRePass;
    private FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        createControls();
        createEvents();
    }

    private void createEvents() {
        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = edtName.getText().toString().trim();
                String email = edtEmail.getText().toString().trim();
                String pass = edtPass.getText().toString().trim();
                String rePass = edtRePass.getText().toString().trim();
                if(pass.equals(rePass)){
                    Toast.makeText(Register_Activity.this, "Fail", Toast.LENGTH_SHORT).show();
                    firebaseAuth.createUserWithEmailAndPassword(email,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()) {
                                Toast.makeText(Register_Activity.this, "create success" , Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(Register_Activity.this, "create Fail" , Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
                else{
                    Toast.makeText(Register_Activity.this, "Pass không giống nhau", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void createControls() {
        btn_register = findViewById(R.id.btnRegister2);
        edtName = findViewById(R.id.edt_name2);
        edtEmail = findViewById(R.id.edt_email2);
        edtPass = findViewById(R.id.edt_password2);
        edtRePass = findViewById(R.id.edt_repassword2);
    }
}
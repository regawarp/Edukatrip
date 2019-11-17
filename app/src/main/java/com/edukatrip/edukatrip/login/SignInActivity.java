package com.edukatrip.edukatrip.login;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.edukatrip.edukatrip.Library.PasswordEncrypt;
import com.edukatrip.edukatrip.MainActivity;
import com.edukatrip.edukatrip.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class SignInActivity extends AppCompatActivity {
    Toolbar toolbar;
    EditText email, password;
    Button btnSignIn;
    TextView redirect_to_register;
    FirebaseFirestore db = FirebaseFirestore.getInstance();

    String id = ""; //Digunakan Untuk Menampung Id User
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        toolbar = (Toolbar)findViewById(R.id.sign_in_tb);
        toolbar.setNavigationIcon(getResources().getDrawable(R.drawable.arrow_left_black));
        email = (EditText) findViewById(R.id.sign_in_input_email);
        password = (EditText) findViewById(R.id.sign_in_input_password);
        btnSignIn = (Button)findViewById(R.id.sign_in_button);
        redirect_to_register = (TextView) findViewById(R.id.redirect_to_register);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Get Data From EditText
                String var_email = email.getText().toString();
                String var_password = password.getText().toString();
                if(var_email.equals("")) {
                    Toast.makeText(SignInActivity.this, "Email Harus Diisi", Toast.LENGTH_SHORT).show();
                }else if(var_password.equals("")){
                    Toast.makeText(SignInActivity.this, "Password Harus Diisi", Toast.LENGTH_SHORT).show();
                }else{
                    //Encrypt Text
                    String password_encrypted = PasswordEncrypt.md5(var_password);
                    //Go To Method Auth
                    auth(var_email,password_encrypted);
                }

            }
        });

        redirect_to_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignInActivity.this,SignUpActivity.class);
                startActivity(intent);
            }
        });
    }

    private void auth(String email, String password){
        id = "";

        db.collection("users")
                .whereEqualTo("userEmail",email)
                .whereEqualTo("password",password)
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if(task.isSuccessful()){
                            for(QueryDocumentSnapshot document : task.getResult()){
                                id = document.getId();
                                Log.d("Info",id + "=>" + document.getData());
                            }
                            if(id.equals("")){
                                Log.d("Info Login", "Data Tidak Ditemukan");
                                Toast.makeText(SignInActivity.this, "Email/Password Salah", Toast.LENGTH_SHORT).show();
                            }else{
                                Log.d("Info Login", "Data Ditemukan");
                                Toast.makeText(SignInActivity.this, "Login Berhasil", Toast.LENGTH_SHORT).show();
                                redirectToHome();
                            }
                        }else{
                            Log.w("Error","Error Getting Documents", task.getException());
                        }
                    }
                });
    }

    private void redirectToHome(){
        Intent intent = new Intent(SignInActivity.this, MainActivity.class);
        startActivity(intent);
    }

}

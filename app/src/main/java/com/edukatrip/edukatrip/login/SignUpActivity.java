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
import android.widget.Toast;

import com.edukatrip.edukatrip.Library.PasswordEncrypt;
import com.edukatrip.edukatrip.MainActivity;
import com.edukatrip.edukatrip.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.ListenerRegistration;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SignUpActivity extends AppCompatActivity {
    Toolbar toolbar;
    EditText username, first_name, last_name, email, mobile, password_, repassword;
    Button btnSignUp;

    FirebaseFirestore db = FirebaseFirestore.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        toolbar = (Toolbar)findViewById(R.id.sign_up_tb);
        toolbar.setNavigationIcon(getResources().getDrawable(R.drawable.arrow_left_black));

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        username = (EditText) findViewById(R.id.sign_up_input_username);
        first_name = (EditText) findViewById(R.id.sign_up_input_first_name);
        last_name = (EditText) findViewById(R.id.sign_up_input_last_name);
        email = (EditText) findViewById(R.id.sign_up_input_email);
        mobile = (EditText) findViewById(R.id.sign_up_input_mobile);
        password_ = (EditText) findViewById(R.id.sign_up_input_password);
        repassword = (EditText) findViewById(R.id.sign_up_input_confirm_password);
        btnSignUp = (Button)findViewById(R.id.sign_up_button);


        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Validasi EditText Harus Terisi Semua
                String var_username = username.getText().toString();
                String var_first_name = first_name.getText().toString();
                String var_last_name = last_name.getText().toString();
                String var_email =  email.getText().toString();
                String var_mobile = mobile.getText().toString();
                String var_password = password_.getText().toString();
                String var_repassword = repassword.getText().toString();
                String password_encrypted = "";

                if(var_username.equals("") || var_first_name.equals("") || var_last_name.equals("") || var_email.equals("") || var_mobile.equals("") || var_password.equals("") || var_repassword.equals("")){
                    Toast.makeText(SignUpActivity.this, "Silahkan Lengkapi Form Yang Tersedia", Toast.LENGTH_SHORT).show();
                }else{
                    if(var_password.equals(var_repassword) ){
                        //Encrypt Password MD5
                        password_encrypted = PasswordEncrypt.md5(var_password);
                        Log.d("Password Encrypted : ", password_encrypted);

                        //Insert Ke Collection 'Users'
                        Map<String, Object> user = new HashMap<>();
                        user.put("username", var_username);
                        user.put("password", password_encrypted);
                        user.put("userFirstName", var_first_name);
                        user.put("userLastName", var_last_name);
                        user.put("userEmail", var_email);
                        user.put("userPhone", var_mobile);

                        addUserToCollection(user);
                        //Redirect Ke Halaman Sign In
                        Toast.makeText(SignUpActivity.this, "Registrasi Berhasil\nSilahkan Login Terlebih Dahulu", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(SignUpActivity.this,SignInActivity.class);
                        startActivity(intent);

                    }else{
                        Toast.makeText(SignUpActivity.this, "Password Tidak Sesuai", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }

    private void addUserToCollection(Map<String, Object> data){
        db.collection("users")
                .add(data)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Log.d("Info", "Sukses Disimpan : "+documentReference.getId());
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.d("Info","Gagal Disimpan");
                    }
                });
    }




}

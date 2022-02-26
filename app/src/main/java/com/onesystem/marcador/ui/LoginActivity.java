package com.onesystem.marcador.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputEditText;
import com.onesystem.marcador.MainActivity;
import com.onesystem.marcador.R;
import com.onesystem.marcador.model.User;

public class LoginActivity extends AppCompatActivity {
    private TextInputEditText inputUsername;
    private TextInputEditText inputPassword;
    private Button submit;
    public ProgressDialog progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        progress = new ProgressDialog(LoginActivity.this);
        progress.setTitle("Aguarde");
        progress.setMessage(" Carregando...");
        progress.setCanceledOnTouchOutside(false);

        inputPassword = findViewById(R.id.inputPassword);
        inputUsername = findViewById(R.id.inputUsername);
        submit = findViewById(R.id.submit);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (inputUsername.getText().toString().isEmpty()){
                    inputUsername.setError("Error");
                    return;
                }
                if (inputPassword.getText().toString().isEmpty()){
                    inputPassword.setError("Error");
                    return;
                }
                progress.show();
                User.getInstance().setUsername(inputUsername.getText().toString().trim());
                User.getInstance().setPassword(inputPassword.getText().toString().trim());
                progress.dismiss();

                // TODO validar a entrada com a base de dados
                startActivity(new Intent(LoginActivity.this, MainActivity.class));
                finish();
            }
        });

    }
}
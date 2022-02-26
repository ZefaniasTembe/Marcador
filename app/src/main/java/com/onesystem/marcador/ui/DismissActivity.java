package com.onesystem.marcador.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputEditText;
import com.onesystem.marcador.R;
import com.onesystem.marcador.model.UserDismiss;

import java.util.Date;

public class DismissActivity extends AppCompatActivity {
    private TextInputEditText inputDia;
    private TextInputEditText inputTotalDia;
    private TextInputEditText inputMotivo;
    private Button submitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dismiss);

        inputDia = findViewById(R.id.inputDia);
        inputTotalDia = findViewById(R.id.inputTotalDias);
        inputMotivo = findViewById(R.id.inputMotivoDispensa);
        submitButton = findViewById(R.id.btnSubmitDismiss);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputDia.getText();
                inputTotalDia.getText();
                inputMotivo.getText();

                if (inputDia.getText().toString().isEmpty()) {
                    inputDia.setError("error");
                    return;
                }
                if (inputMotivo.getText().toString().isEmpty()) {
                    inputMotivo.setError("error");
                    return;
                }
                if (inputTotalDia.getText().toString().isEmpty()) {
                    inputTotalDia.setError("error");
                    return;
                }

                int total = Integer.parseInt(inputTotalDia.getText().toString().trim());
                UserDismiss dismiss = new UserDismiss(inputMotivo.getText().toString().trim(), new Date(), total);
            }
        });
    }
}
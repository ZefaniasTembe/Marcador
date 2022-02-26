package com.onesystem.marcador;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.card.MaterialCardView;
import com.onesystem.marcador.model.User;
import com.onesystem.marcador.ui.DismissActivity;
import com.onesystem.marcador.ui.LoginActivity;
import com.onesystem.marcador.ui.MessageActivity;
import com.onesystem.marcador.ui.PresenceActivity;
import com.onesystem.marcador.ui.ReplaceActivity;

public class MainActivity extends AppCompatActivity {
    private MaterialCardView btnPresence, btnMessage, btnReplace,btnDismiss;
    private TextView txtColaborador, txtFaltas, txtAtrasos, txtTurno;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnPresence = findViewById(R.id.btnPresence);
        btnMessage = findViewById(R.id.btnMessages);
        btnReplace = findViewById(R.id.btnReplace);
        btnDismiss = findViewById(R.id.btnDismiss);

        txtColaborador = findViewById(R.id.txtNomeColaborador);
        txtFaltas = findViewById(R.id.txtFaltas);
        txtAtrasos = findViewById(R.id.txtAtrasos);
        txtTurno = findViewById(R.id.txtTurno);

        txtTurno.setText("Manhã");
        txtAtrasos.setText("5");
        txtFaltas.setText("1");
        txtColaborador.setText("Fulano de Tal");

        btnPresence.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, PresenceActivity.class));
            }
        });

        btnMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, MessageActivity.class));
            }
        });

        btnReplace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, ReplaceActivity.class));
            }
        });

        btnDismiss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, DismissActivity.class));
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        if(User.getInstance() == null){
            startActivity(new Intent(getApplicationContext(), LoginActivity.class));
        }
    }
}
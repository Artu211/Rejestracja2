package com.example.rejestracja;


import android.os.Bundle;

import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;


public class MainActivity extends AppCompatActivity {

    private TextView alert;
    private EditText email;
    private EditText pass;
    private EditText name;
    private EditText surname;
    private Button wyslij;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        alert = findViewById(R.id.alert);
        email = findViewById(R.id.email);
        pass = findViewById(R.id.pass);
        name = findViewById(R.id.name);
        surname = findViewById(R.id.surname);
        wyslij = findViewById(R.id.wyslij);

        wyslij.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String imieWartosc = name.getText().toString().trim();
                String nazwiskoWartosc = surname.getText().toString().trim();
                String emailWartosc = email.getText().toString().trim();
                String hasloWartosc = pass.getText().toString().trim();
                if (imieWartosc.isEmpty() || nazwiskoWartosc.isEmpty() || emailWartosc.isEmpty() || hasloWartosc.isEmpty()) {
                    alert.setText("Uzupełnij wszystkie pola");
                    return;
                }
                if (!emailWartosc.contains("@") || !emailWartosc.contains(".")) {
                    alert.setText("Podaj poprawny adres email");
                    return;
                }
                if (hasloWartosc.length() < 8) {
                    alert.setText("Hasło musi mieć co najmniej 8 znaków");
                    return;
                }
                if (!hasloWartosc.matches(".*[a-z].*")) {
                    alert.setText("Hasło musi zawierać małą literę");
                    return;
                }
                if (!hasloWartosc.matches(".*[A-Z].*")) {
                    alert.setText("Hasło musi zawierać wielką literę");
                    return;
                }
                if (!hasloWartosc.matches(".*[!@#$%^&*()].*")) {
                    alert.setText("Hasło musi zawierać znak specjalny");
                    return;
                }

                alert.setText("Dane są poprawne");
            }
        });


    }


}

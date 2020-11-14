package com.example.andr1homework1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText eName;
    private EditText ePassword;
    private Button eLogin;
    private TextView attempts;

    boolean isValid = false;
    private int counter = 3;
    private String Username = "Admin";
    private String Password = "qwerty";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        eName = findViewById(R.id.etName);
        ePassword = findViewById(R.id.etPassword);
        eLogin = findViewById(R.id.btn);
        attempts = findViewById(R.id.attempts);

        eLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String inputName = eName.getText().toString();
                String inputPassword = ePassword.getText().toString();

                if(inputName.isEmpty() || inputPassword.isEmpty()){
                    Toast.makeText(MainActivity.this, "Вы ввели неправильные данные", Toast.LENGTH_SHORT).show();
                } else if (inputPassword.length() > 7) {

                    Toast.makeText(MainActivity.this, "Количество символов пароля превышенна", Toast.LENGTH_SHORT).show();

                } else {

                    isValid = validate(inputName, inputPassword);

                    if (!isValid) {

                        counter--;

                        Toast.makeText(MainActivity.this, "Вы ввели неправильные данные", Toast.LENGTH_SHORT).show();

                        attempts.setText("Количество попыток: " + counter);

                        if (counter == 0) {
                            eLogin.setEnabled(false);
                        }

                    } else {

                        Toast.makeText(MainActivity.this, "Успешно", Toast.LENGTH_SHORT).show();
                    }

                }

            }
        });
    }

    private boolean validate(String name, String password) {

        if(name.equals(Username) && password.equals(Password)){
            return true;
        }
        return false;
    }


}
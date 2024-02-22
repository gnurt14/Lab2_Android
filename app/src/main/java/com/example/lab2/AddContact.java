package com.example.lab2;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class AddContact extends AppCompatActivity {
    private EditText editTextName, editTextPhone;
    private Button btnAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_contact);

        editTextName = findViewById(R.id.txtHotenMoi);
        editTextPhone = findViewById(R.id.txtSDTMoi);
        btnAdd = findViewById(R.id.btnThemMoiMoi);
    }
}

package com.example.fitware;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.fitware.databinding.ActivityCadastroBinding;

import modelDominio.Usuario;

public class CadastroActivity extends AppCompatActivity {
    private AppBarConfiguration appBarConfiguration;
    private ActivityCadastroBinding binding;

    Button bCancelarCadastro, bCadastrarCadastro;
    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCadastroBinding.inflate(getLayoutInflater());
        setContentView(R.layout.activity_cadastro);
        spinner = findViewById(R.id.spinner);
        bCancelarCadastro = findViewById(R.id.bCancelarCadastro);
        bCadastrarCadastro = findViewById(R.id.bCadastrarCadastro);

        bCancelarCadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                VoltaTela();
            }
        });
        String[] listaspinner = getResources().getStringArray(R.array.listaspinner);
        spinner.setAdapter(new ArrayAdapter<String>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, listaspinner));

        bCadastrarCadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int spinnerItem = spinner.getSelectedItemPosition();
                if (spinnerItem != 0){
                    if (spinnerItem == 1){

                    }
                }
            }
        });
    }

    public void VoltaTela(){

        Intent it = new Intent(CadastroActivity.this, LoginActivity.class);
        startActivity(it);
    }





}
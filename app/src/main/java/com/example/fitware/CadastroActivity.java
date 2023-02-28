package com.example.fitware;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.ui.AppBarConfiguration;

import com.example.fitware.databinding.ActivityCadastroBinding;

import controller.ConexaoSocketController;
import modelDominio.Usuario;

public class CadastroActivity extends AppCompatActivity {
    private AppBarConfiguration appBarConfiguration;
    private ActivityCadastroBinding binding;

    Usuario usuario;
    Button bCancelarCadastro, bCadastrarCadastro;
    Spinner spinner;
    EditText edNomeCadastro, edEmailCadastro, edSenhaCadastro;


    InformacoesApp informacoesApp;
    String msg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCadastroBinding.inflate(getLayoutInflater());
        setContentView(R.layout.activity_cadastro);
//        spinner = findViewById(R.id.spinner);
        bCancelarCadastro = findViewById(R.id.bCancelarCadastro);
        bCadastrarCadastro = findViewById(R.id.bCadastrarCadastro);
        edNomeCadastro = findViewById(R.id.edNomeCadastro);
        edSenhaCadastro = findViewById(R.id.edSenhaCadastro);
        edEmailCadastro = findViewById(R.id.edEmailCadastro);

        informacoesApp = (InformacoesApp) getApplicationContext();

        bCadastrarCadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!edNomeCadastro.getText().toString().equals("")){
                    if (!edSenhaCadastro.getText().toString().equals("")){
                        if (!edEmailCadastro.getText().toString().equals("")){
                               String nomeComum = edNomeCadastro.getText().toString();
                               String emailComum = edEmailCadastro.getText().toString();
                               String senhaComum = edSenhaCadastro.getText().toString();
                               int sppinerSelecionado = 0;

                                usuario = new Usuario(nomeComum, emailComum, senhaComum);
                                sppinerSelecionado = spinner.getSelectedItemPosition();
                                Thread thread2 = new Thread(new Runnable() {
                                    @Override
                                    public void run() {
                                        ConexaoSocketController conexaoSocket = new ConexaoSocketController(informacoesApp);
                                        msg = conexaoSocket.UserInserir(usuario);
                                        runOnUiThread(new Runnable() {
                                            @Override
                                            public void run() {
                                                Toast.makeText(informacoesApp, "recebido", Toast.LENGTH_SHORT).show();
                                                Intent it = new Intent(CadastroActivity.this, LoginActivity.class);
                                            }
                                        });


                                    }
                                });
                                thread2.start();

                        } else {
                            edEmailCadastro.setError("Informe sua senha");
                            edEmailCadastro.requestFocus();
                        }
                    } else {
                        edSenhaCadastro.setError("Defina a sua senha");
                        edSenhaCadastro.requestFocus();
                    }
                } else  {
                    edNomeCadastro.setError("Informe a seu nome");
                    edNomeCadastro.requestFocus();
                }
            }
        });




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
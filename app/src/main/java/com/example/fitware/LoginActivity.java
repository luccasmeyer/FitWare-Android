package com.example.fitware;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import controller.ConexaoSocketController;
import modelDominio.Usuario;



public class LoginActivity extends AppCompatActivity {

    Button bEntrarLogin, bCancelarLogin, bCadastrarLogin;
    EditText edNomeLogin, edSenhaLogin;

    Usuario usuario;
    String msgRecebida;

    InformacoesApp informacoesApp;

    Boolean resultadoConexao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        bCadastrarLogin = findViewById(R.id.bCadastrarLogin);
        bCancelarLogin = findViewById(R.id.bCadastrarLogin);
        edNomeLogin = findViewById(R.id.edNomeLogin);
        edSenhaLogin= findViewById(R.id.edSenhaLogin);

        bCadastrarLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TelaCadastro();
            }
        });

        informacoesApp = (InformacoesApp) getApplicationContext();
        Toast.makeText(informacoesApp, "entrou na activity", Toast.LENGTH_SHORT).show();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(informacoesApp, "entrou na thread", Toast.LENGTH_SHORT).show();
                    }
                });
                ConexaoSocketController conexaoSocket = new ConexaoSocketController(informacoesApp);
                resultadoConexao = conexaoSocket.criaConexao();

                if(resultadoConexao == true){
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(informacoesApp, "certooooo", Toast.LENGTH_SHORT).show();
                        }
                    });
                } else{
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(informacoesApp, "eroooo", Toast.LENGTH_SHORT).show();
                        }
                    });
                }

            }
        });
        thread.start();

        bCancelarLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                limpaCampos();
            }
        });
    }

    public void limpaCampos() {
        edNomeLogin.setText("");
        edSenhaLogin.setText("");
    }

    public void TelaCadastro(){
        Intent it = new Intent(LoginActivity.this, CadastroActivity.class);
        startActivity(it);
    }
}



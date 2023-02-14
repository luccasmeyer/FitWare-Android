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

    Button bLoginEntrar, bLoginCancelar;
    EditText etLoginUsuario, etLoginSenha;

    Usuario usuario;
    String msgRecebida;

    InformacoesApp informacoesApp;

    Boolean resultadoConexao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
//        etLoginUsuario = findViewById(R.id.etLoginUsuario);
//        etLoginSenha = findViewById(R.id.etLoginSenha);
//        bLoginEntrar = findViewById(R.id.bLoginEntrar);
//        bLoginCancelar = findViewById(R.id.bLoginCancelar);
//            Toolbar toolbar = findViewById(R.id.toolbar);
////            setSupportActionBar(toolbar);

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

//        bLoginEntrar.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (!etLoginUsuario.getText().toString().equals("")) {
//                    if (!etLoginSenha.getText().toString().equals("")) {
//                        String nomeUsuario = etLoginUsuario.getText().toString();
//                        String senha = etLoginSenha.getText().toString();
//
//                        usuario = new Usuario(nomeUsuario, senha);
//
//                        Thread thread1 = new Thread(new Runnable() {
//                            @Override
//                            public void run() {
//                                ConexaoSocketController conexaoSocket = new ConexaoSocketController(informacoesApp);
//                                usuario = conexaoSocket.autenticaUsuario(usuario);
//
//                                if (usuario != null) {
//                                    informacoesApp.setUsuarioLogado(usuario);
//
//                                    Intent it = new Intent(LoginActivity.this, LoginActivity.class);
//                                    startActivity(it);
//                                } else {
//                                    runOnUiThread(new Runnable() {
//                                        @Override
//                                        public void run() {
//                                            Toast.makeText(informacoesApp, "ATENÇÃO: Usuário e senha não conferem!", Toast.LENGTH_SHORT).show();
//                                            limpaCampos();
//                                        }
//                                    });
//                                }
//
//                            }
//                        });
//                        thread1.start();
//                    } else {
//                        etLoginSenha.setError("Informe a senha!");
//                        etLoginSenha.requestFocus();
//                    }
//                } else {
//                    etLoginUsuario.setError("Informe o usuário!");
//                    etLoginUsuario.requestFocus();
//                }
//            }
//        });

//        bLoginCancelar.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                limpaCampos();
//            }
//        });
    }

    public void limpaCampos() {
        etLoginUsuario.setText("");
        etLoginSenha.setText("");
    }
}



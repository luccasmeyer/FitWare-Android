package com.example.fitware;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import controller.ConexaoSocketController;
import modelDominio.Usuario;



public class LoginActivity extends AppCompatActivity {

    Button bEntrarLogin, bCancelarLogin, bCadastrarLogin;
    EditText edNomeLogin, edSenhaLogin;
    TextView tvCadastro;
    Usuario usuario;
    String msgRecebida;
    CheckBox cMSenhaLogin;

    InformacoesApp informacoesApp;

    Boolean resultadoConexao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        bEntrarLogin = findViewById(R.id.bEntrarLogin);
        bCancelarLogin = findViewById(R.id.bCancelarLogin);
        edNomeLogin = findViewById(R.id.edNomeLogin);
        edSenhaLogin= findViewById(R.id.edSenhaLogin);
        tvCadastro = findViewById(R.id.tvCadastro);
        cMSenhaLogin = findViewById(R.id.cMSenhaLogin);

        informacoesApp = (InformacoesApp) getApplicationContext();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                    }
                });
                ConexaoSocketController conexaoSocket = new ConexaoSocketController(informacoesApp);
                resultadoConexao = conexaoSocket.criaConexao();

            }
        });
        thread.start();

        bEntrarLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!edNomeLogin.getText().toString().equals("")) {
                    if (!edSenhaLogin.getText().toString().equals("")) {
                        String nomeUsuario = edNomeLogin.getText().toString();
                        String senha = edSenhaLogin.getText().toString();

                        usuario = new Usuario(nomeUsuario, senha);

                        Thread thread1 = new Thread(new Runnable() {
                            @Override
                            public void run() {
                                ConexaoSocketController conexaoSocket = new ConexaoSocketController(informacoesApp);
                                Usuario usuarioLogado = conexaoSocket.EfetuarLogin(usuario);

                                if (usuario != null) {
                                    informacoesApp.setUsuarioLogado(usuario);

                                    Intent it = new Intent(LoginActivity.this, CadastroActivity.class);
                                    startActivity(it);
                                } else {
                                    runOnUiThread(new Runnable() {
                                        @Override
                                        public void run() {
                                            Toast.makeText(informacoesApp, "ATEN????O: Usu??rio e senha n??o conferem!", Toast.LENGTH_SHORT).show();
                                            limpaCampos();
                                        }
                                    });
                                }

                            }
                        });
                        thread1.start();
                    } else {
                        edSenhaLogin.setError("Informe a senha!");
                        edSenhaLogin.requestFocus();
                    }
                } else {
                    edNomeLogin.setError("Informe o usu??rio!");
                    edNomeLogin.requestFocus();
                }
            }
        });
        bCancelarLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                limpaCampos();
            }
        });

        tvCadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TelaCadastro();
            }
        });

        cMSenhaLogin.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    edSenhaLogin.setTransformationMethod(null);
                } else {
                    edSenhaLogin.setTransformationMethod(new PasswordTransformationMethod());
                }
            }
        });

    }


    public void limpaCampos() {
        edNomeLogin.setText("");
        edSenhaLogin.setText("");
        edNomeLogin.requestFocus();
    }

    public void TelaCadastro(){
        Intent it = new Intent(LoginActivity.this, CadastroActivity.class);
        startActivity(it);
    }
}

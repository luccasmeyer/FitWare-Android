package com.example.fitware;

import android.app.Application;

import java.io.ObjectInput;
import java.io.ObjectOutputStream;
import java.net.Socket;

import modelDominio.Usuario;

public class InformacoesApp extends Application {
    public Socket socket;
    public ObjectOutputStream out;
    public ObjectInput in;

    private Usuario usuarioLogado;
//    @Override
//    public void onCreate() {
//        super.onCreate();
//
//    }

    public  Usuario getUsuarioLogado(){ return  usuarioLogado; }
    public void setUsuarioLogado(Usuario usuarioLogado) { this.usuarioLogado = usuarioLogado; }
}

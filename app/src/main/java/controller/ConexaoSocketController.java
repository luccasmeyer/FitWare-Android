package controller;

import android.util.Log;

import com.example.fitware.InformacoesApp;
import com.example.fitware.LoginActivity;

import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import modelDominio.Usuario;

public class ConexaoSocketController {
    InformacoesApp informacoesApp;

    public ConexaoSocketController(InformacoesApp informacoesApp) {
        this.informacoesApp = informacoesApp;
    }

    public boolean criaConexao() {
        boolean resultado;
        try {
            informacoesApp.socket = new Socket("10.0.2.2", 12345);
            informacoesApp.out = new ObjectOutputStream(informacoesApp.socket.getOutputStream());
            informacoesApp.in = new ObjectInputStream(informacoesApp.socket.getInputStream());

            resultado = true;

        } catch (IOException ioe){
            ioe.printStackTrace();
            resultado = false;
        }
        return resultado;
    }

    public Usuario EfetuarLogin(Usuario usuario) {
        Usuario usuarioLogado = null;
        try {
            informacoesApp.out.writeObject("EfetuarLogin");
            String msg = (String) informacoesApp.in.readObject();
            Log.i("alguma merda dentro", usuario.toString() );
            if (msg.equals("ok")) {
                Log.i("alguma merda dentro2", msg );
                informacoesApp.out.writeObject(usuario);
                usuarioLogado = (Usuario) informacoesApp.in.readObject();

            }

        } catch (IOException ioe) {
            ioe.printStackTrace();
        } catch (ClassNotFoundException classe) {
            classe.printStackTrace();
        }
        return  usuarioLogado;
    }


}

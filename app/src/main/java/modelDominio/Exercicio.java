/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelDominio;

import java.io.Serializable;

/**
 *
 * @author aluno
 */
public class Exercicio implements Serializable{
    private static final long serialVersionUID = 123L;

    private int codExercicio;
    private String nomeExercicio;
    private String descricao;
    private String series;
    private String repeticoes;
    private byte[] imagem;
    private int tipoexercicio;


    //construtores

    public Exercicio(int codExercicio, String nomeExercicio, String descricao, String series, String repeticoes, byte[] imagem) {
        this.codExercicio = codExercicio;
        this.nomeExercicio = nomeExercicio;
        this.descricao = descricao;
        this.series = series;
        this.repeticoes = repeticoes;
        this.imagem = imagem;
    }

    public Exercicio(int codExercicio, String nomeExercicio) {
        this.codExercicio = codExercicio;
        this.nomeExercicio = nomeExercicio;
    }

    public Exercicio(String nomeExercicio, String descricao, String series, String repeticoes, byte[] imagem) {
        this.nomeExercicio = nomeExercicio;
        this.descricao = descricao;
        this.series = series;
        this.repeticoes = repeticoes;
        this.imagem = imagem;
    }

    public Exercicio(int codExercicio, String nomeExercicio, String series, String repeticoes) {
        this.codExercicio = codExercicio;
        this.nomeExercicio = nomeExercicio;
        this.series = series;
        this.repeticoes = repeticoes;
    }

    public Exercicio(int codExercicio, String nomeExercicio, String descricao, String series, String repeticoes, int tipoexercicio) {
        this.codExercicio = codExercicio;
        this.nomeExercicio = nomeExercicio;
        this.descricao = descricao;
        this.series = series;
        this.repeticoes = repeticoes;
        this.tipoexercicio = tipoexercicio;
    }

    public Exercicio(String nomeExercicio, String descricao, String series, String repeticoes, int tipoexercicio) {
        this.nomeExercicio = nomeExercicio;
        this.descricao = descricao;
        this.series = series;
        this.repeticoes = repeticoes;
        this.tipoexercicio = tipoexercicio;
    }



    public int getCodExercicio() {
        return codExercicio;
    }

    public void setCodExercicio(int codExercicio) {
        this.codExercicio = codExercicio;
    }

    public String getNomeExercicio() {
        return nomeExercicio;
    }

    public void setNomeExercicio(String nomeExercicio) {
        this.nomeExercicio = nomeExercicio;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public byte[] getImagem() {
        return imagem;
    }

    public void setImagem(byte[] imagem) {
        this.imagem = imagem;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public String getRepeticoes() {
        return repeticoes;
    }

    public void setRepeticoes(String repeticoes) {
        this.repeticoes = repeticoes;
    }

    public int getTipoexercicio() {
        return tipoexercicio;
    }

    public void setTipoexercicio(int tipoexercicio) {
        this.tipoexercicio = tipoexercicio;
    }

    @Override
    public String toString() {
        return "Exercicio{" + "codExercicio=" + codExercicio + ", nomeExercicio=" + nomeExercicio + ", descricao=" + descricao + ", series=" + series + ", repeticoes=" + repeticoes + ", imagem=" + imagem + '}';
    }


}

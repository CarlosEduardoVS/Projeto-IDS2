package com.aulabd.bd.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;



public class Obra {

    private int idObra, idCliente;
    private String nomeObra, endereco, nEndereco, bairro, cidade, responsavel, contato, descricao;


    public Obra() { }


    public Obra(int idObra, int idCliente, String nomeObra, String endereco, String nEndereco, String bairro, String cidade, String responsavel, String contato, String descricao) {
    this.idObra = idObra;
    this.idCliente = idCliente;
    this.nomeObra = nomeObra;
    this.endereco = endereco;
    this.nEndereco = nEndereco;
    this.bairro = bairro;
    this.cidade = cidade;
    this.responsavel = responsavel;
    this.contato = contato;
    this.descricao = descricao;
    }
    

    //  -- getters -- 


    public int getIdObra() {
        return idObra;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public String getNomeObra() {
        return nomeObra;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getnEndereco() {
        return nEndereco;
    }

    public String getBairro() {
        return bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public String getContato() {
        return contato;
    }

    public String getDescricao() {
        return descricao;
    }
    

    //  -- setters --


    public void setIdObra(int idObra) {
        this.idObra = idObra;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public void setNomeObra(String nomeObra) {
        this.nomeObra = nomeObra;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setnEndereco(String nEndereco) {
        this.nEndereco = nEndereco;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }


    // conversões


     public static Obra converterUmaObra(Map<String, Object> regObra) {
        int idObra = (Integer) regObra.get("idObra");
        int idCliente = (Integer) regObra.get("idCliente");
        String nomeObra = (String) regObra.get("nomeObra");
        String endereco = (String) regObra.get("endereco");
        String nEndereco = (String) regObra.get("nEndereco");
        String bairro = (String) regObra.get("bairro");
        String cidade = (String) regObra.get("cidade");
        String responsavel = (String) regObra.get("responsavel");
        String contato = (String) regObra.get("contato");
        String descricao = (String) regObra.get("descricao");
        Obra obr = new Obra(idObra, idCliente, nomeObra, endereco, nEndereco, bairro, cidade,responsavel, contato, descricao);
        return obr;
    }

    public static List<Obra> converterTodasObras(List<Map<String,Object>> regObra){
        List<Obra> auxObra = new ArrayList<>();
        for(Map<String,Object> regis : regObra){
            auxObra.add(converterUmaObra(regis));
        }
        return auxObra;
    }
   

}

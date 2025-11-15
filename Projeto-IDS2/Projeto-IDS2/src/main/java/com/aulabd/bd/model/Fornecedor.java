package com.aulabd.bd.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Fornecedor {

    private int idFornecedor;
    private String nomeFornecedor, contato, tipo, endereco;

    public Fornecedor(){
    }
    

    public Fornecedor(String nomeFornecedor, String contato, String tipo, String endereco) {
        this.nomeFornecedor = nomeFornecedor;
        this.contato = contato;
        this.tipo = tipo;
        this.endereco = endereco;
    }
    
    public Fornecedor(int idFornecedor, String nomeFornecedor, String contato, String tipo, String endereco) {
        this.idFornecedor = idFornecedor;
        this.nomeFornecedor = nomeFornecedor;
        this.contato = contato;
        this.tipo = tipo;
        this.endereco = endereco;
    }


    public int getIdFornecedor() {
        return idFornecedor;
    }

    public String getNomeFornecedor() {
        return nomeFornecedor;
    }

    public String getContato() {
        return contato;
    }

    public String getTipo() {
        return tipo;
    }

    public String getEndereco() {
        return endereco;
    }


    public void setIdFornecedor(int idFornecedor) {
        this.idFornecedor = idFornecedor;
    }

    public void setNomeFornecedor(String nomeFornecedor) {
        this.nomeFornecedor = nomeFornecedor;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public static Fornecedor converterUmFornecedor (Map<String,Object> registro){
        int idFornecedor = (Integer) registro.get("idFornecedor");
        String nomeFornecedor = (String) registro.get("nomeFornecedor");
        String contato = (String) registro.get("contato");
        String tipo = (String) registro.get("tipo");
        String endereco = (String) registro.get("endereco");
        Fornecedor forn = new Fornecedor(idFornecedor,nomeFornecedor,contato,tipo,endereco);
        return forn;
    }

    public static List<Fornecedor> converterTodosFornecedores(List<Map<String,Object>> regisForncedor){
        List<Fornecedor> aux = new ArrayList<>();
        for(Map<String,Object> fornec : regisForncedor){
            aux.add(converterUmFornecedor(fornec));
        }
        return aux;
    }

    



}

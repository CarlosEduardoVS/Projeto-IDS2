package com.aulabd.bd.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Cliente {

    private int idCliente;
    private String nomeEmpresa, cnpj, contato;

    //INICIALIZAR FORM
    public Cliente(){
    }

    //id eh auto incremento, INSERIR
    public Cliente(String nomeEmpresa, String cnpj, String contato){
        this.nomeEmpresa = nomeEmpresa;
        this.cnpj = cnpj;
        this.contato = contato;
    }

    //SELECT
    public Cliente(int idCliente, String nomeEmpresa, String cnpj, String contato) {
        this.idCliente = idCliente;
        this.cnpj = cnpj;
        this.nomeEmpresa = nomeEmpresa;
        this.contato = contato;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public String getNomeEmpresa() {
        return nomeEmpresa;
    }

    public String getCnpj() {
        return cnpj;
    }

    public String getContato() {
        return contato;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public void setNomeEmpresa(String nomeEmpresa) {
        this.nomeEmpresa = nomeEmpresa;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    public static Cliente converterUmCliente (Map<String,Object> registro){
        int idCliente = (Integer) registro.get("idCliente");
        String nomeEmpresa = (String) registro.get("nomeEmpresa");
        String cnpj = (String) registro.get("cnpj");
        String contato = (String) registro.get("contato");
        Cliente cli = new Cliente(idCliente,nomeEmpresa,cnpj,contato);
        return cli;
    }

    public static List<Cliente> converternClientes(List<Map<String,Object>> registros){
        List<Cliente> aux = new ArrayList<>();
        for(Map<String,Object> reg : registros){
            aux.add(converterUmCliente(reg));
        }
        return aux;
    }
}

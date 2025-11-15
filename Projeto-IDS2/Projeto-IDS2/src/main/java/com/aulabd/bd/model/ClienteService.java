package com.aulabd.bd.model;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    @Autowired
    ClienteDAO cdao;

    public ClienteService() {
    }

    public ClienteService(ClienteDAO cdao) {
        this.cdao = cdao;
    }

    public void inserirCliente(Cliente cli){
        cdao.inserirCliente(cli);
    }

    public List<Map<String,Object>> puxarTodosClientes(){
        return cdao.puxarTodosClientes();
    }

    public Map<String,Object> puxarCliente(int idCliente){
        return cdao.puxarCliente(idCliente);
    }

    public void atualizarCliente(Cliente cli,int idCliente){
        cdao.atualizarCliente(cli,idCliente);
    }

    public void deletar(int idCliente){
        cdao.deletar(idCliente);
    }

// === obra \/

    public void inserirObra(Obra obr){
        cdao.inserirObra(obr);
    }

    public List<Map<String,Object>> puxarTodasObras(){
        return cdao.puxarTodasObras();
    }

    public Map<String,Object> puxarObra(int idObra){
        return cdao.puxarObra(idObra);
    }

    public void deletarObra(int idObra){
        cdao.deletarObra(idObra);
    }

    public void atualizarObra(Obra obr, int idObra){
        cdao.atualizarObra(obr, idObra);
    }

// === Fornecedor \/

    public void inserirFornecedor(Fornecedor forn){
        cdao.inserirFornecedor(forn);
    }

    public List<Map<String,Object>> puxarTodosFornecedores(){
        return cdao.puxarTodosFornecedores();
    }

    public Map<String,Object> puxarFornecedor(int idFornecedor){
        return cdao.puxarFornecedor(idFornecedor);
    }

    public void atualizarFornecedor(Fornecedor forc, int idFornecedor){
        cdao.atualizarFornecedor(forc,idFornecedor);
    }

    public void deletarFornecedor(int idFornecedor){
        cdao.deletarFornecedor(idFornecedor);
    }

// === JOIN \/

    public List<Map<String, Object>> puxarObrasPorIdCliente(int idCliente) {
        return cdao.puxarObrasPorIdCliente(idCliente);
    }



}

package com.aulabd.bd.model;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ClienteDAO {
	
	@Autowired
	
	JdbcTemplate jdbc;

    public void inserirCliente(Cliente cli){
        String sql = "INSERT INTO cliente(nomeEmpresa, cnpj, contato) VALUES(?,?,?)";
        Object[] parametros = new Object[3];
        parametros[0] = cli.getNomeEmpresa();
        parametros[1] = cli.getCnpj();
        parametros[2] = cli.getContato();
        jdbc.update(sql, parametros);
    }

    public List<Map<String,Object>> puxarTodosClientes(){
        String sql = "SELECT * FROM cliente;";
        return jdbc.queryForList(sql);
    }

    public Map<String,Object> puxarCliente(int idCliente){
        String sql = "SELECT * FROM cliente WHERE idCliente = ?;";
        return jdbc.queryForMap(sql, idCliente);
    }

    public void deletar(int idCliente){
        String sql = "DELETE FROM cliente where idCliente = ?;";
        jdbc.update(sql, idCliente);
    }

    public void atualizarCliente(Cliente cli, int idCliente){
        String sql = "UPDATE cliente SET nomeEmpresa = ?, cnpj = ?, contato = ? WHERE idCliente = ?";
        Object[] parametros = new Object[4];
        parametros[0] = cli.getNomeEmpresa();
        parametros[1] = cli.getCnpj();
        parametros[2] = cli.getContato();
        parametros[3] = idCliente;
        jdbc.update(sql, parametros);
    }


// === obra\/


    public void inserirObra(Obra obr){
        String sql = "INSERT INTO obra(idCliente, nomeObra, endereco, nEndereco, bairro, cidade, responsavel, contato, descricao) VALUES(?,?,?,?,?,?,?,?,?)";
        Object[] parametros = new Object[9];
        parametros[0] = obr.getIdCliente();
        parametros[1] = obr.getNomeObra();
        parametros[2] = obr.getEndereco();
        parametros[3] = obr.getnEndereco();
        parametros[4] = obr.getBairro();
        parametros[5] = obr.getCidade();
        parametros[6] = obr.getResponsavel();
        parametros[7] = obr.getContato();
        parametros[8] = obr.getDescricao();
        jdbc.update(sql, parametros);
    }

    public List<Map<String,Object>> puxarTodasObras(){
        String sql = "SELECT * FROM obra;";
        return jdbc.queryForList(sql);
    }

    public Map<String,Object> puxarObra(int idObra){
        String sql = "SELECT o.*, c.nomeEmpresa FROM obra o JOIN cliente c ON o.idCliente = c.idCliente WHERE o.idObra = ?;";
        return jdbc.queryForMap(sql, idObra);
    }

    public void deletarObra(int idObra){
        String sql = "DELETE FROM obra WHERE idObra = ?;";
        jdbc.update(sql, idObra);
    }

    public void atualizarObra(Obra obr, int idObra){
        String sql = "UPDATE obra SET idCliente = ?, nomeObra = ?, endereco = ?, nEndereco = ?, bairro = ?, cidade = ?, responsavel = ?, contato = ?, descricao = ? WHERE idObra = ?";
        Object[] parametros = new Object[10];
        parametros[0] = obr.getIdCliente();
        parametros[1] = obr.getNomeObra();
        parametros[2] = obr.getEndereco();
        parametros[3] = obr.getnEndereco();
        parametros[4] = obr.getBairro();
        parametros[5] = obr.getCidade();
        parametros[6] = obr.getResponsavel();
        parametros[7] = obr.getContato();
        parametros[8] = obr.getDescricao();
        parametros[9] = idObra;
        jdbc.update(sql, parametros);
    }


    
    // === fornecedores \/
    
public void inserirFornecedor(Fornecedor forn){
        String sql = "INSERT INTO fornecedor(nomeFornecedor, contato, tipo, endereco) VALUES(?,?,?,?)";
        Object[] parametros = new Object[4];
        parametros[0] = forn.getNomeFornecedor();
        parametros[1] = forn.getContato();
        parametros[2] = forn.getTipo();
        parametros[3] = forn.getEndereco();
        jdbc.update(sql, parametros);
    }

    public List<Map<String,Object>> puxarTodosFornecedores(){
        String sql = "SELECT * FROM fornecedor;";
        return jdbc.queryForList(sql);
    }

    public Map<String,Object> puxarFornecedor(int idFornecedor){
        String sql = "SELECT * FROM fornecedor WHERE idFornecedor = ?;";
        return jdbc.queryForMap(sql, idFornecedor);
    }

    public void deletarFornecedor(int idFornecedor){
        String sql = "DELETE FROM fornecedor where idFornecedor = ?;";
        jdbc.update(sql, idFornecedor);
    }

    public void atualizarFornecedor(Fornecedor forn, int idFornecedor){
        String sql = "UPDATE fornecedor SET nomeFornecedor = ?, contato = ?, tipo = ?, endereco = ? WHERE idFornecedor = ?";
        Object[] parametros = new Object[5];
        parametros[0] = forn.getNomeFornecedor();
        parametros[1] = forn.getContato();
        parametros[2] = forn.getTipo();
        parametros[3] = forn.getEndereco();
        parametros[4] = idFornecedor;
        jdbc.update(sql, parametros);
    }



// === JOIN \/
    
        public List<Map<String,Object>> puxarObrasPorIdCliente(int idCliente){
            // Assumindo que idCliente na tabela 'obra' é INT e FOREIGN KEY para 'cliente'
            String sql = "SELECT * FROM obra WHERE idCliente = ?;";
            return jdbc.queryForList(sql, idCliente);
        }
}

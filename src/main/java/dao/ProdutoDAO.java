/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Produto;

/**
 *
 * @author Junior
 */
public class ProdutoDAO {
    
    private final String stmtInserir = "INSERT INTO produto(descricao) VALUES(?)";
    private final String stmtConsultar = "SELECT * FROM produto WHERE id = ?";
    private final String stmtListar = "SELECT * FROM produto";
    private final String stmtAtualizar = "UPDATE produto SET descricao = ? WHERE id = ?";
    private final String stmtExcluir = "DELETE FROM produto WHERE ID = ?";
    private final String stmtQnt = "SELECT COUNT(*) FROM produto";
    
    public void incluirProduto(Produto produto){
        Connection conn = null;
        PreparedStatement stmt = null;
        
        try {
            conn = ConnectionFactory.getConnection();
            stmt = conn.prepareStatement(stmtInserir, Statement.RETURN_GENERATED_KEYS);
            
            stmt.setString(1, produto.getDescricao());
            
            stmt.executeUpdate();
                    
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao inserir um produto no banco de dados: " + ex.getMessage());
        } finally {
            try{stmt.close();}catch(SQLException ex){throw new RuntimeException("Erro ao fechar stmt: " + ex.getMessage());}
            try{conn.close();}catch(SQLException ex){throw new RuntimeException("Erro ao fechar conexao: " + ex.getMessage());}
        }
    }
    
    public Produto consultarProduto(int id) {
    Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;
    Produto produtoLido;
        try{
            conn = ConnectionFactory.getConnection();
            stmt = conn.prepareStatement(stmtConsultar);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            if(rs.next()){
                produtoLido = new Produto(rs.getInt("id"), rs.getString("descricao"));
                
                return produtoLido;
            }else{
                throw new RuntimeException("Não existe produto com este id. ID = " + id);
            }
            
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao consultar um produto no banco de dados. " + ex.getMessage());
        } finally{
            try{rs.close();}catch(SQLException ex){throw new RuntimeException("Erro ao fechar result set: " + ex.getMessage());}
            try{stmt.close();}catch(SQLException ex){throw new RuntimeException("Erro ao fechar stmt: " + ex.getMessage());}
            try{conn.close();}catch(SQLException ex){throw new RuntimeException("Erro ao fechar conexao: " + ex.getMessage());}
        }

    }
    
    public List<Produto> listarProdutos() {
    Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;
    List<Produto> lista = new ArrayList();
        try{
            conn = ConnectionFactory.getConnection();
            stmt = conn.prepareStatement(stmtListar);
            rs = stmt.executeQuery();
            while(rs.next()){
                Produto produto = new Produto(rs.getInt("id"), rs.getString("descricao"));
                produto.setId(rs.getInt("id"));
                lista.add(produto);
            }
            return lista;

        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao listar produtos no banco de dados. " + ex.getMessage());
        } finally{
            try{rs.close();}catch(SQLException ex){throw new RuntimeException("Erro ao fechar result set: " + ex.getMessage());}
            try{stmt.close();}catch(SQLException ex){throw new RuntimeException("Erro ao fechar stmt: " + ex.getMessage());}
            try{conn.close();}catch(SQLException ex){throw new RuntimeException("Erro ao fechar conexao: " + ex.getMessage());}
        }

    }
    
    public int getQuantidadeProdutos() {
    Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;
    int quantidade;
        try{
            conn = ConnectionFactory.getConnection();
            stmt = conn.prepareStatement(stmtQnt);
            rs = stmt.executeQuery();
            rs.next();
            quantidade = rs.getInt(1);
            
            return quantidade;
            
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao consultar quantidade de produtos no banco de dados. " + ex.getMessage());
        } finally{
            try{rs.close();}catch(SQLException ex){throw new RuntimeException("Erro ao fechar result set: " + ex.getMessage());}
            try{stmt.close();}catch(SQLException ex){throw new RuntimeException("Erro ao fechar stmt: " + ex.getMessage());}
            try{conn.close();}catch(SQLException ex){throw new RuntimeException("Erro ao fechar conexao: " + ex.getMessage());}
        }

    }
    
    public void atualizarProduto(Produto produto){
        Connection conn = null;
        PreparedStatement stmt = null;
        
        try {
            conn = ConnectionFactory.getConnection();
            stmt = conn.prepareStatement(stmtAtualizar);
            
            stmt.setString(1, produto.getDescricao());
            stmt.setInt(2, produto.getId());
            
            stmt.executeUpdate();
                    
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao atulizar um produto no banco de dados: " + ex.getMessage());
        } finally {
            try{stmt.close();}catch(SQLException ex){throw new RuntimeException("Erro ao fechar stmt: " + ex.getMessage());}
            try{conn.close();}catch(SQLException ex){throw new RuntimeException("Erro ao fechar conexao: " + ex.getMessage());}
        }
    }
    
    public void excluirProduto(Produto produto){
        Connection conn = null;
        PreparedStatement stmt = null;
        
        try {
            conn = ConnectionFactory.getConnection();
            stmt = conn.prepareStatement(stmtExcluir);
            
            stmt.setInt(1, produto.getId());
            
            stmt.executeUpdate();
                    
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao excluir um produto no banco de dados: " + ex.getMessage());
        } finally {
            try{stmt.close();}catch(SQLException ex){throw new RuntimeException("Erro ao fechar stmt: " + ex.getMessage());}
            try{conn.close();}catch(SQLException ex){throw new RuntimeException("Erro ao fechar conexao: " + ex.getMessage());}
        }
    }
}


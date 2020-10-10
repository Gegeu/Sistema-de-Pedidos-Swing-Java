/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import modelo.Cliente;
import modelo.ItemDoPedido;
import modelo.Pedido;
import modelo.Produto;

/**
 *
 * @author Junior
 */
public class PedidoDAO {
    
    private final String stmtInserir = "INSERT INTO pedido(data, id_cliente) VALUES(?, ?)";
    private final String stmtConsultar = "SELECT * FROM pedido WHERE id = ?";
    private final String stmtConsultarCPF = "SELECT id, data, id_cliente FROM pedido WHERE id_cliente = ?";
    private final String stmtBuscaCPF = "SELECT id FROM cliente WHERE cpf = ?";
    private final String stmtListar = "SELECT * FROM pedido";
    //private final String stmtAtualizar = "UPDATE pedido SET descricao = ? WHERE id = ?";
    private final String stmtExcluir = "DELETE FROM pedido WHERE ID = ?";
    private final String stmtQnt = "SELECT COUNT(*) FROM produto";
    private final String stmtListItens = "SELECT i.id_pedido, i.id_produto, prod.descricao, i.qtdade FROM item_do_pedido AS i INNER JOIN produto AS prod ON i.id_produto = prod.id INNER JOIN pedido as p ON p.id = i.id_pedido WHERE p.id = ?;";
    
    
    public Pedido incluirPedido(Pedido pedido){
        Connection conn = null;
        PreparedStatement stmt = null;
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        
        try {
            conn = ConnectionFactory.getConnection();
            stmt = conn.prepareStatement(stmtInserir, Statement.RETURN_GENERATED_KEYS);
            
            
            stmt.setString(1, pedido.getData().format(fmt));
            stmt.setInt(2, pedido.getCliente().getId());
            
            stmt.executeUpdate();
            
            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            
            int id = rs.getInt(1);
            pedido.setId(id);
            
            return pedido;
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao inserir um pedido no banco de dados: " + ex.getMessage());
        } finally {
            try{stmt.close();}catch(SQLException ex){throw new RuntimeException("Erro ao fechar stmt: " + ex.getMessage());}
            try{conn.close();}catch(SQLException ex){throw new RuntimeException("Erro ao fechar conexao: " + ex.getMessage());}
        }
    }
    
    public List<ItemDoPedido> consultarItensPedido(int id) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<ItemDoPedido> itensPedido = new ArrayList();
            try{
                conn = ConnectionFactory.getConnection();
                stmt = conn.prepareStatement(stmtListItens);
                stmt.setInt(1, id);
                rs = stmt.executeQuery();
                
                while(rs.next()){
                    Produto prod = new Produto(rs.getInt("id_produto"), rs.getString("descricao"));
                    ItemDoPedido itemPed = new ItemDoPedido(rs.getInt("qtdade"), prod);
                    itensPedido.add(itemPed);
                }
                //System.out.println(itensPedido.get(0).getProduto().getDescricao());
                return itensPedido;

            } catch (SQLException ex) {
                throw new RuntimeException("Erro ao consultar um item no banco de dados. " + ex.getMessage());
            } finally{
                try{rs.close();}catch(SQLException ex){throw new RuntimeException("Erro ao fechar result set: " + ex.getMessage());}
                try{stmt.close();}catch(SQLException ex){throw new RuntimeException("Erro ao fechar stmt: " + ex.getMessage());}
                try{conn.close();}catch(SQLException ex){throw new RuntimeException("Erro ao fechar conexao: " + ex.getMessage());}
            }

    }
    
//    public Pedido consultarPedido(Pedido pedido){
//        Connection conn = null;
//        PreparedStatement stmt = null;
//        ResultSet rs = null;
//        
//            try{
//                conn = ConnectionFactory.getConnection();
//                stmt = conn.prepareStatement(stmtConsultar);
//                stmt.setInt(1, pedido.getId());
//                rs = stmt.executeQuery();
//                Pedido pLido;
//                Cliente c;
//                DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
//                
//                if(rs.next()){
//                    pLido = new Pedido(rs.getInt("id"), rs.getDate("data"), c, itens);
////                    pLido.setData(rs.getDate("data"));
////                    pLido.setCliente(pedido.getCliente());
//                    
//                    
//                }
//
//                return pLido;
//
//            } catch (SQLException ex) {
//                throw new RuntimeException("Erro ao consultar um pedido no banco de dados. " + ex.getMessage());
//            } finally{
//                try{rs.close();}catch(SQLException ex){throw new RuntimeException("Erro ao fechar result set: " + ex.getMessage());}
//                try{stmt.close();}catch(SQLException ex){throw new RuntimeException("Erro ao fechar stmt: " + ex.getMessage());}
//                try{conn.close();}catch(SQLException ex){throw new RuntimeException("Erro ao fechar conexao: " + ex.getMessage());}
//            }       
//    }
    
    public List<Produto> listarPedidos() {
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
    
    private int BuscaCPF(String cpf){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

            try{
                conn = ConnectionFactory.getConnection();
                stmt = conn.prepareStatement(stmtBuscaCPF);
                stmt.setString(1, cpf);
                rs = stmt.executeQuery();
                if(rs.next()){
                    int idLido = rs.getInt("id");

                    return idLido;
                }else{
                    throw new RuntimeException("Não existe cliente com este CPF. CPF = " + cpf);
                }

            } catch (SQLException ex) {
                throw new RuntimeException("Erro ao consultar um cliente no banco de dados. " + ex.getMessage());
            } finally{
                try{rs.close();}catch(SQLException ex){throw new RuntimeException("Erro ao fechar result set: " + ex.getMessage());}
                try{stmt.close();}catch(SQLException ex){throw new RuntimeException("Erro ao fechar stmt: " + ex.getMessage());}
                try{conn.close();}catch(SQLException ex){throw new RuntimeException("Erro ao fechar conexao: " + ex.getMessage());}
            }
    }
    
    public List<Pedido> listarCPFPedidos(String cpf) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Pedido> lista = new ArrayList();
        ClienteDAO cd = new ClienteDAO();
        int id = BuscaCPF(cpf);
            try{
                conn = ConnectionFactory.getConnection();
                stmt = conn.prepareStatement(stmtConsultarCPF);
                stmt.setInt(1, id);
                rs = stmt.executeQuery();
                Cliente cli = new Cliente(cd.consultarCliente(id).getId(), cd.consultarCliente(id).getCpf() , cd.consultarCliente(id).getNome(), cd.consultarCliente(id).getSobreNome());
                
                while(rs.next()){
                    LocalDateTime dataped = rs.getTimestamp("data").toLocalDateTime();
                    Pedido pedido = new Pedido(rs.getInt("id"), dataped, cli, null);
                    
                    lista.add(pedido);
                }
                return lista;

            } catch (SQLException ex) {
                throw new RuntimeException("Erro ao listar pedidos no banco de dados. " + ex.getMessage());
            } finally{
                try{rs.close();}catch(SQLException ex){throw new RuntimeException("Erro ao fechar result set: " + ex.getMessage());}
                try{stmt.close();}catch(SQLException ex){throw new RuntimeException("Erro ao fechar stmt: " + ex.getMessage());}
                try{conn.close();}catch(SQLException ex){throw new RuntimeException("Erro ao fechar conexao: " + ex.getMessage());}
            }

    }
    
//    public int getQuantidadeProdutos() {
//    Connection conn = null;
//    PreparedStatement stmt = null;
//    ResultSet rs = null;
//    int quantidade;
//        try{
//            conn = ConnectionFactory.getConnection();
//            stmt = conn.prepareStatement(stmtQnt);
//            rs = stmt.executeQuery();
//            rs.next();
//            quantidade = rs.getInt(1);
//            
//            return quantidade;
//            
//        } catch (SQLException ex) {
//            throw new RuntimeException("Erro ao consultar quantidade de produtos no banco de dados. " + ex.getMessage());
//        } finally{
//            try{rs.close();}catch(SQLException ex){throw new RuntimeException("Erro ao fechar result set: " + ex.getMessage());}
//            try{stmt.close();}catch(SQLException ex){throw new RuntimeException("Erro ao fechar stmt: " + ex.getMessage());}
//            try{conn.close();}catch(SQLException ex){throw new RuntimeException("Erro ao fechar conexao: " + ex.getMessage());}
//        }
//
//    }
//    
//    public void atualizarProduto(Produto produto){
//        Connection conn = null;
//        PreparedStatement stmt = null;
//        
//        try {
//            conn = ConnectionFactory.getConnection();
//            stmt = conn.prepareStatement(stmtAtualizar);
//            
//            stmt.setString(1, produto.getDescricao());
//            stmt.setInt(2, produto.getId());
//            
//            stmt.executeUpdate();
//                    
//        } catch (SQLException ex) {
//            throw new RuntimeException("Erro ao atulizar um produto no banco de dados: " + ex.getMessage());
//        } finally {
//            try{stmt.close();}catch(SQLException ex){throw new RuntimeException("Erro ao fechar stmt: " + ex.getMessage());}
//            try{conn.close();}catch(SQLException ex){throw new RuntimeException("Erro ao fechar conexao: " + ex.getMessage());}
//        }
//    }
//    
    public void excluirPedido(int id){
        Connection conn = null;
        PreparedStatement stmt = null;
        
        try {
            conn = ConnectionFactory.getConnection();
            stmt = conn.prepareStatement(stmtExcluir);
            
            stmt.setInt(1, id);
            
            stmt.executeUpdate();
                    
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao excluir um pedido no banco de dados: " + ex.getMessage());
        } finally {
            try{stmt.close();}catch(SQLException ex){throw new RuntimeException("Erro ao fechar stmt: " + ex.getMessage());}
            try{conn.close();}catch(SQLException ex){throw new RuntimeException("Erro ao fechar conexao: " + ex.getMessage());}
        }
    }
}

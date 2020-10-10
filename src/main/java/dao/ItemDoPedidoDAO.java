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
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import modelo.ItemDoPedido;
import modelo.Pedido;
import modelo.Produto;

/**
 *
 * @author Junior
 */
public class ItemDoPedidoDAO {
    private final String stmtInserir = "INSERT INTO item_do_pedido(id_pedido, id_produto, qtdade) VALUES(?, ?, ?)";
    private final String stmtConsultar = "SELECT * FROM pedido WHERE id = ?";
    private final String stmtListar = "SELECT * FROM pedido";
    //private final String stmtAtualizar = "UPDATE pedido SET descricao = ? WHERE id = ?";
    //private final String stmtExcluir = "DELETE FROM produto WHERE ID = ?";
    private final String stmtQnt = "SELECT COUNT(*) FROM produto";
    
    public void incluirItemDoPedido(ItemDoPedido itemPed, Pedido pedido){
        Connection conn = null;
        PreparedStatement stmt = null;
        
        try {
            conn = ConnectionFactory.getConnection();
            stmt = conn.prepareStatement(stmtInserir, Statement.RETURN_GENERATED_KEYS);
            
            
            stmt.setInt(1, pedido.getId());
            stmt.setInt(2, itemPed.getProduto().getId());
            stmt.setInt(3, itemPed.getQuantidade());
            
            stmt.executeUpdate();
                    
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao inserir um item de pedido no banco de dados: " + ex.getMessage());
        } finally {
            try{stmt.close();}catch(SQLException ex){throw new RuntimeException("Erro ao fechar stmt: " + ex.getMessage());}
            try{conn.close();}catch(SQLException ex){throw new RuntimeException("Erro ao fechar conexao: " + ex.getMessage());}
        }
    }
    
    
}

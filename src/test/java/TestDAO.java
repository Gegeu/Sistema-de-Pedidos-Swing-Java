/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import dao.ClienteDAO;
import dao.PedidoDAO;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import modelo.Cliente;
import modelo.ItemDoPedido;
import modelo.Pedido;
import modelo.Produto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Junior
 */
public class TestDAO {
    
    public TestDAO() {
    }
    
    @BeforeEach
    public void setUp() {
    }
//    @Test
//    public void incluirCliente() {
//     
//        Cliente c = new Cliente(0, "10143255516", "Joao", "Teste");
//        Cliente cr;
//        ClienteDAO cd = new ClienteDAO();
//         
//        cd.incluirCliente(c);
//        cr = cd.consultarAutor(6);
//         
//        assertEquals(cr.getCpf(), c.getCpf());
//    }
    
    @Test
    public void listarUmCliente() {
     
        Cliente c = new Cliente(0, "10143255515", "Joao", "Teste");
        Cliente cr;
        ClienteDAO cd = new ClienteDAO();
         
        cr = cd.consultarCliente(5);
         
        assertEquals(cr.getCpf(), c.getCpf());
    }
    
    @Test
    public void listarClientes() {
     
        ClienteDAO cd = new ClienteDAO();
        int cs;
        int cr;
        
        cr = cd.listarClientes().size();
        cs = cd.getQuantidadeClientes();
         
        assertEquals(cr, cs);
    }
    
    @Test
    public void atualizarClientes() {
     
        ClienteDAO cd = new ClienteDAO();
        Cliente c = new Cliente(6, "10120230345", "Atualizado", "Atualizado");
        
        cd.atualizarCliente(c);
        Cliente cs = cd.consultarCliente(6);
        
         
        assertEquals(c.getCpf(), cs.getCpf());
    }
    
    @Test
    public void excluirClientes() {
     
        ClienteDAO cd = new ClienteDAO();
        Cliente c = new Cliente(3, "10120230345", "Atualizado", "Atualizado");
        
        cd.excluirCliente(c);
        
        try
        {
            cd.consultarCliente(c.getId());
            fail("Deveria exeção");
        } catch (RuntimeException ex){
            assertEquals("Não existe cliente com este id. ID = " + c.getId(), ex.getMessage());
        }
    }
    
//    @Test
//    public void incluirPedido() {
//        ClienteDAO cd = new ClienteDAO();
//        PedidoDAO pd = new PedidoDAO();
//        LocalDateTime dt = LocalDateTime.now();
//        
//        Produto pr = new Produto(0, "cola");
//        ItemDoPedido it = new ItemDoPedido(2, pr);
//        
//        Cliente c = new Cliente(cd.consultarCliente(1).getId(), cd.consultarCliente(1).getCpf(), cd.consultarCliente(1).getNome(), cd.consultarCliente(1).getSobreNome());
//        
//        List<ItemDoPedido> lista = new ArrayList();
//        lista.add(it);
//        
//        Pedido ped = new Pedido(0, dt, c, lista);
//        
//        pd.incluirPedido(ped);
//        
//         
//        assertEquals(""," ");
//    }
    
    
}

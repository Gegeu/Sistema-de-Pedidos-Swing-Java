/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import dao.ClienteDAO;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import modelo.Cliente;

/**
 *
 * @author Junior
 */
public class ModeloTabelaCliente extends AbstractTableModel {
    private String[] colunas = {"ID Cliente","CPF","Nome", "Sobrenome"};
    private List<Cliente> listCli = new ArrayList();
    
    public ModeloTabelaCliente(List<Cliente> cliente){
        this.listCli = cliente;
    }
    
    public ModeloTabelaCliente() {}
    
    @Override
    public int getRowCount() {
        return listCli.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }
    
    @Override
    public String getColumnName(int index) {
        return this.colunas[index];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Cliente c = listCli.get(rowIndex);
        ClienteDAO cd = new ClienteDAO();
        //List<Livro> lv = ad.listarLivrosDeAutor(a.getId());

        
        switch(columnIndex){
            case 0:
                return c.getId();
            case 1:
                return c.getCpf();
            case 2:
                return c.getNome();
            case 3:
                return c.getSobreNome();

            default: 
                return null;
        }
    }

 @Override
    public void setValueAt(Object value, int row, int col) {
        try {
            Cliente customer = listCli.get(row);
            switch (col) {
                case 0:
                    customer.setId((int) value); //if column 0 (code)
                    break;
                case 1:
                    customer.setCpf((String) value);
                    break;
                case 2:
                    customer.setNome((String) value);
                    break;
                case 4:
                    customer.setSobreNome((String) value);
                    break;
                default:
            }
            this.fireTableCellUpdated(row, col);
        } catch (Exception ex) {
            System.out.println("Erro ao popular: " + ex.getMessage());
        }
    }
    
    
    
   public void setClientes(List<Cliente> cliente) {
        this.listCli = cliente;
        this.fireTableDataChanged();
    }
   
   public void adicionaCliente(Cliente cliente) {
       ClienteDAO cDAO = new ClienteDAO();
       
       this.listCli.add(cliente);
       cDAO.incluirCliente(cliente);
       
       this.fireTableRowsInserted(listCli.size()-1, listCli.size()-1);
   }
   
    public void carregaClientes(){
        ClienteDAO cd = new ClienteDAO();

        List<Cliente> cl = cd.listarClientes();

        this.setClientes(cl);
    }
    
    public void excluiCliente(Cliente cliente){
        ClienteDAO cd = new ClienteDAO();
        
        cd.excluirCliente(cliente);
    }
}

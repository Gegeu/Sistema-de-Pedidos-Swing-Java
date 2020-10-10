/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import dao.PedidoDAO;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import modelo.Pedido;

/**
 *
 * @author Junior
 */
public class ModeloTabelaListaPed extends AbstractTableModel {
    private String[] colunas = new String[]{"ID Pedido", "Data", "Nome do Cliente"};
    private List<Pedido> lista = new ArrayList();
    
    public ModeloTabelaListaPed(List<Pedido> lista) {
        this.lista = lista;
    }

    public ModeloTabelaListaPed() {
       
    }

    @Override
    public int getRowCount() {
        return this.lista.size();
    }

    @Override
    public int getColumnCount() {
        return this.colunas.length;
    }

    @Override
    public String getColumnName(int index) {
        return this.colunas[index];
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Pedido pedido = lista.get(rowIndex);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        switch (columnIndex) {
            case 0:
                return pedido.getId();
            case 1:
                return pedido.getData().format(formatter);
            case 2:
                return pedido.getCliente().getNome() + " " + pedido.getCliente().getSobreNome();
            default:
                return null;
        }
    }

//    @Override
//    public void setValueAt(Object value, int row, int col) {
//        Pedido pedido = lista.get(row);
//        switch (col) {
//            case 0:
//                pedido.setData(LocalDateTime.MAX);
//                item.getProduto().setDescricao((String) value); //if column 0 (code)
//                break;
//            case 1:
//                item.setQuantidade((int) value);
//                break;
//            default:
//                
//        }
//        this.fireTableCellUpdated(row, col);
//    }


    public void adicionaPedido(Pedido pedido) {
        this.lista.add(pedido);
        this.fireTableRowsInserted(lista.size() - 1, lista.size() - 1);//update JTable
    }

    public void setListaPedido(List<Pedido> pedido) {
        this.lista = pedido;
        this.fireTableDataChanged();
        
    }
    
    public void buscaPedidos(String cpf){
        PedidoDAO pd = new PedidoDAO();
        List<Pedido> li = pd.listarCPFPedidos(cpf);
        
        this.setListaPedido(li);
    }
    
//    public void carregaProdutos(){
//        PedidoDAO pd = new PedidoDAO();
//
//        List<Pedido> pl = pd.listarPedidos();
//
//        this.setPedidos(pl);
//    }
        
    
    public void limpaTabela() {
        int indice = lista.size() - 1;
        if (indice < 0) {
            indice = 0;
        }
        this.lista = new ArrayList();
        this.fireTableRowsDeleted(0, indice);//update JTable
    }

    public Pedido getPedido(int linha) {
        return lista.get(linha);
    }
    
    
    public void excluiPedido(int row){
        lista.remove(row);
        fireTableRowsDeleted(row, row);
    }
}

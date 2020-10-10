/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import dao.ItemDoPedidoDAO;
import dao.PedidoDAO;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import modelo.ItemDoPedido;
import modelo.Pedido;

/**
 *
 * @author Junior
 */
public class ModeloTabelaItem extends AbstractTableModel{
    private String[] colunas = new String[]{"Descrição", "Quantidade"};
    private List<ItemDoPedido> lista = new ArrayList();
    
    public ModeloTabelaItem(List<ItemDoPedido> lista) {
        this.lista = lista;
    }

    public ModeloTabelaItem() {
       
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
        ItemDoPedido item = lista.get(rowIndex);
        
        switch (columnIndex) {
            case 0:
                return item.getProduto().getDescricao();
            case 1:
                return item.getQuantidade();

            default:
                return null;
        }
    }


    public void adicionaItem(ItemDoPedido item) {
        this.lista.add(item);
        this.fireTableRowsInserted(lista.size() - 1, lista.size() - 1);//update JTable
    }

    public void setListaPedido(List<ItemDoPedido> item) {
        this.lista = item;
        this.fireTableDataChanged();
        
    }
    
    public void carregaLista(int row){
        
        PedidoDAO pd = new PedidoDAO();
        
        List<ItemDoPedido> tlist = pd.consultarItensPedido(row);
        //System.out.println(tlist.get(0).getProduto().getDescricao());
        this.setListaPedido(tlist);
    }
    
//    public void buscaPedidos(String cpf){
//        PedidoDAO pd = new PedidoDAO();
//        List<Pedido> li = pd.listarCPFPedidos(cpf);
//        
//        this.setListaPedido(li);
//    }
        
    
    public void limpaTabela() {
        int indice = lista.size() - 1;
        if (indice < 0) {
            indice = 0;
        }
        this.lista = new ArrayList();
        this.fireTableRowsDeleted(0, indice);//update JTable
    }

    public ItemDoPedido getItem(int linha) {
        return lista.get(linha);
    }
    
    
    public boolean removeItem(ItemDoPedido item) {
        int linha = this.lista.indexOf(item);
        boolean result = this.lista.remove(item);
        
        this.fireTableRowsDeleted(linha, linha);//update JTable
        return result;
    }
}

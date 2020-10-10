/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;


import dao.ProdutoDAO;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import modelo.Produto;

/**
 *
 * @author Junior
 */
public class ModeloTabelaProduto extends AbstractTableModel {
    private String[] colunas = {"ID Produto", "Descrição"};
    private List<Produto> listProdutos = new ArrayList();
    
    public ModeloTabelaProduto(List<Produto> produto){
        this.listProdutos = produto;
    }
    
    public ModeloTabelaProduto() {}
    
    @Override
    public int getRowCount() {
        return listProdutos.size();
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
        Produto p = listProdutos.get(rowIndex);
        ProdutoDAO pd = new ProdutoDAO();
        //List<Livro> lv = ad.listarLivrosDeAutor(a.getId());

        
        switch(columnIndex){
            case 0:
                return p.getId();
            case 1:
                return p.getDescricao();

            default: 
                return null;
        }
    }

 @Override
    public void setValueAt(Object value, int row, int col) {
        try {
            Produto produto = listProdutos.get(row);
            switch (col) {
                case 0:
                    produto.setId((int) value); //if column 0 (code)
                    break;
                case 1:
                    produto.setDescricao((String) value);
                    break;
                default:
            }
            this.fireTableCellUpdated(row, col);
        } catch (Exception ex) {
            System.out.println("Erro ao popular: " + ex.getMessage());
        }
    }
    
    
    
   public void setProdutos(List<Produto> produto) {
        this.listProdutos = produto;
        this.fireTableDataChanged();
    }
   
   public void adicionaProduto(Produto produto) {
       ProdutoDAO pDAO = new ProdutoDAO();
       
       this.listProdutos.add(produto);
       pDAO.incluirProduto(produto);
       
       this.fireTableRowsInserted(listProdutos.size()-1, listProdutos.size()-1);
   }
   
    public void carregaProdutos(){
        ProdutoDAO pd = new ProdutoDAO();

        List<Produto> pl = pd.listarProdutos();

        this.setProdutos(pl);
    }
    
    public void excluiProduto(Produto produto){
        ProdutoDAO pd = new ProdutoDAO();
        
        pd.excluirProduto(produto);
    }
}

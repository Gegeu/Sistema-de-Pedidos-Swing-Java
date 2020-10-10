/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Junior
 */
public class ItemDoPedido extends Produto {
    
    private int quantidade;
    private Produto produto;

    public ItemDoPedido() {
        
    }
    
    public ItemDoPedido(int quantidade, Produto produto) {
        this.quantidade = quantidade;
        this.produto = produto;
    }
    
    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }
    
}

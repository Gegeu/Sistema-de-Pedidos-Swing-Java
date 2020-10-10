/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import dao.ClienteDAO;
import dao.PedidoDAO;
import dao.ProdutoDAO;
import java.util.List;
import javax.swing.JOptionPane;
import modelo.Cliente;
import modelo.Pedido;
import modelo.Produto;

/**
 *
 * @author Junior
 */
public class Tela extends javax.swing.JFrame {

    /**
     * Creates new form Tela
     */
    ModeloTabelaCliente mtc = new ModeloTabelaCliente();
    ModeloTabelaProduto mtp = new ModeloTabelaProduto();
    ModeloTabelaListaPed mtlist = new ModeloTabelaListaPed();
    ModeloTabelaItem mtit = new ModeloTabelaItem();

    public Tela() {
        initComponents();

        mtc.carregaClientes();
        mtp.carregaProdutos();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        aba = new javax.swing.JTabbedPane();
        panelClientes = new javax.swing.JPanel();
        scrollClientes = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnCadastrarCliente = new javax.swing.JButton();
        btnListarClientes = new javax.swing.JButton();
        btnExcluirCliente = new javax.swing.JButton();
        lblCPFCliente = new javax.swing.JLabel();
        txtCPFCliente = new javax.swing.JTextField();
        lblNomeCliente = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        lblSobreNome = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        btnAtualizarCliente = new javax.swing.JButton();
        panelProdutos = new javax.swing.JPanel();
        scrollProdutos = new javax.swing.JScrollPane();
        tbProdutos = new javax.swing.JTable();
        btnCadastrarProduto = new javax.swing.JButton();
        btnListarProdutos = new javax.swing.JButton();
        btnExcluirProduto = new javax.swing.JButton();
        lblDescricaoProduto = new javax.swing.JLabel();
        txtDescricaoProduto = new javax.swing.JTextField();
        btnAtualizarCliente1 = new javax.swing.JButton();
        panelPedidos = new javax.swing.JPanel();
        btnListarPedido = new javax.swing.JButton();
        btnExcluirPedido = new javax.swing.JButton();
        lblCPFPedido = new javax.swing.JLabel();
        txtCPFPedido = new javax.swing.JTextField();
        scrollPedidos = new javax.swing.JScrollPane();
        tbPedidos = new javax.swing.JTable();
        btnBuscarPedido = new javax.swing.JButton();
        btnCadastrarPedido = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(550, 450));

        panelClientes.setPreferredSize(new java.awt.Dimension(550, 500));

        jTable1.setModel(mtc);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        scrollClientes.setViewportView(jTable1);

        btnCadastrarCliente.setText("Cadastrar Cliente ");
        btnCadastrarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarClienteActionPerformed(evt);
            }
        });

        btnListarClientes.setText("Listar Clientes");
        btnListarClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListarClientesActionPerformed(evt);
            }
        });

        btnExcluirCliente.setText("Excluir Cliente");
        btnExcluirCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirClienteActionPerformed(evt);
            }
        });

        lblCPFCliente.setText("CPF");

        lblNomeCliente.setText("NOME");

        lblSobreNome.setText("SOBRENOME");

        btnAtualizarCliente.setText("Atualizar");
        btnAtualizarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtualizarClienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelClientesLayout = new javax.swing.GroupLayout(panelClientes);
        panelClientes.setLayout(panelClientesLayout);
        panelClientesLayout.setHorizontalGroup(
            panelClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelClientesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrollClientes)
                    .addGroup(panelClientesLayout.createSequentialGroup()
                        .addGroup(panelClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblCPFCliente)
                            .addComponent(txtCPFCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addGroup(panelClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNomeCliente)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                        .addGroup(panelClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblSobreNome)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(36, 36, 36))
                    .addGroup(panelClientesLayout.createSequentialGroup()
                        .addComponent(btnAtualizarCliente)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(panelClientesLayout.createSequentialGroup()
                        .addComponent(btnCadastrarCliente)
                        .addGap(77, 77, 77)
                        .addComponent(btnListarClientes)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnExcluirCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        panelClientesLayout.setVerticalGroup(
            panelClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelClientesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrollClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panelClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCPFCliente)
                    .addComponent(lblNomeCliente)
                    .addComponent(lblSobreNome))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCPFCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnAtualizarCliente)
                .addGap(18, 18, 18)
                .addGroup(panelClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCadastrarCliente)
                    .addComponent(btnListarClientes)
                    .addComponent(btnExcluirCliente))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        aba.addTab("Clientes", panelClientes);

        tbProdutos.setModel(mtp);
        tbProdutos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbProdutosMouseClicked(evt);
            }
        });
        scrollProdutos.setViewportView(tbProdutos);

        btnCadastrarProduto.setText("Cadastrar Produto ");
        btnCadastrarProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarProdutoActionPerformed(evt);
            }
        });

        btnListarProdutos.setText("Listar Produtos");
        btnListarProdutos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListarProdutosActionPerformed(evt);
            }
        });

        btnExcluirProduto.setText("Excluir Produto");
        btnExcluirProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirProdutoActionPerformed(evt);
            }
        });

        lblDescricaoProduto.setText("DESCRIÇÃO");

        btnAtualizarCliente1.setText("Atualizar");
        btnAtualizarCliente1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtualizarCliente1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelProdutosLayout = new javax.swing.GroupLayout(panelProdutos);
        panelProdutos.setLayout(panelProdutosLayout);
        panelProdutosLayout.setHorizontalGroup(
            panelProdutosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelProdutosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelProdutosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrollProdutos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 505, Short.MAX_VALUE)
                    .addGroup(panelProdutosLayout.createSequentialGroup()
                        .addComponent(btnCadastrarProduto)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnListarProdutos)
                        .addGap(79, 79, 79)
                        .addComponent(btnExcluirProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelProdutosLayout.createSequentialGroup()
                        .addComponent(lblDescricaoProduto)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(panelProdutosLayout.createSequentialGroup()
                        .addComponent(txtDescricaoProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAtualizarCliente1)))
                .addContainerGap())
        );
        panelProdutosLayout.setVerticalGroup(
            panelProdutosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelProdutosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrollProdutos, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblDescricaoProduto)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelProdutosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDescricaoProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAtualizarCliente1))
                .addGap(57, 57, 57)
                .addGroup(panelProdutosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCadastrarProduto)
                    .addComponent(btnListarProdutos)
                    .addComponent(btnExcluirProduto))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        aba.addTab("Produtos", panelProdutos);

        btnListarPedido.setText("Listar Pedido");
        btnListarPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListarPedidoActionPerformed(evt);
            }
        });

        btnExcluirPedido.setText("Excluir Pedido");
        btnExcluirPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirPedidoActionPerformed(evt);
            }
        });

        lblCPFPedido.setText("CPF DO CLIENTE");

        tbPedidos.setModel(mtlist);
        tbPedidos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbPedidosMouseClicked(evt);
            }
        });
        scrollPedidos.setViewportView(tbPedidos);

        btnBuscarPedido.setText("Buscar");
        btnBuscarPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarPedidoActionPerformed(evt);
            }
        });

        btnCadastrarPedido.setText("Cadastrar Pedido ");
        btnCadastrarPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarPedidoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelPedidosLayout = new javax.swing.GroupLayout(panelPedidos);
        panelPedidos.setLayout(panelPedidosLayout);
        panelPedidosLayout.setHorizontalGroup(
            panelPedidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPedidosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelPedidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrollPedidos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 505, Short.MAX_VALUE)
                    .addGroup(panelPedidosLayout.createSequentialGroup()
                        .addComponent(btnCadastrarPedido)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnExcluirPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelPedidosLayout.createSequentialGroup()
                        .addComponent(lblCPFPedido)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(panelPedidosLayout.createSequentialGroup()
                        .addComponent(txtCPFPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnBuscarPedido)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnListarPedido)))
                .addContainerGap())
        );
        panelPedidosLayout.setVerticalGroup(
            panelPedidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPedidosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrollPedidos, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblCPFPedido)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelPedidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCPFPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscarPedido)
                    .addComponent(btnListarPedido))
                .addGap(57, 57, 57)
                .addGroup(panelPedidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCadastrarPedido)
                    .addComponent(btnExcluirPedido))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        aba.addTab("Pedidos", panelPedidos);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(aba, javax.swing.GroupLayout.DEFAULT_SIZE, 530, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(aba, javax.swing.GroupLayout.DEFAULT_SIZE, 378, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCadastrarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarClienteActionPerformed
        new ClienteNovo().setVisible(true);

    }//GEN-LAST:event_btnCadastrarClienteActionPerformed

    private void btnListarClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListarClientesActionPerformed

        mtc.carregaClientes();
    }//GEN-LAST:event_btnListarClientesActionPerformed

    private void btnExcluirClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirClienteActionPerformed
        
        if(jTable1.getSelectedRow() != -1){
            ClienteDAO cd = new ClienteDAO();
            PedidoDAO pd = new PedidoDAO();
            
           
            Cliente c = cd.consultarCliente((int)jTable1.getValueAt(jTable1.getSelectedRow(), 0));
            List<Pedido> lp = pd.listarCPFPedidos(c.getCpf());
            boolean nPedido = true;
            
            for(int i = 0; i < lp.size(); i++){
                if(lp.get(i).getCliente().getCpf().equals(c.getCpf())){
                    nPedido = false;
                    break;
                } 
            }
            
                     
            if(nPedido){
                cd.excluirCliente(c);
                JOptionPane.showMessageDialog(null, "Cliente excluido!");
                txtCPFCliente.setText("");
                jTextField1.setText("");
                jTextField2.setText("");
                mtc.carregaClientes();
            } else {
                JOptionPane.showMessageDialog(null, "Cliente possui pedidos e não pode ser excluido!");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Você deve selecionar um cliente!");
        }
    }//GEN-LAST:event_btnExcluirClienteActionPerformed

    private void btnAtualizarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtualizarClienteActionPerformed
        if(jTable1.getSelectedRow() != -1){
            Cliente c = new Cliente((int)mtc.getValueAt(jTable1.getSelectedRow(), 0), txtCPFCliente.getText(), jTextField1.getText(), jTextField2.getText());
            ClienteDAO cd = new ClienteDAO();
            
            
            cd.atualizarCliente(c);
            JOptionPane.showMessageDialog(null, "Cliente atualizado!");
            
            mtc.carregaClientes();
            txtCPFCliente.setText("");
            jTextField1.setText("");
            jTextField2.setText("");
            
        } else {
            JOptionPane.showMessageDialog(null, "Você deve selecionar um cliente!");
        }
    }//GEN-LAST:event_btnAtualizarClienteActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        if(jTable1.getSelectedRow() != -1){
            
            txtCPFCliente.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 1).toString());
            jTextField1.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 2).toString());
            jTextField2.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 3).toString());

        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void tbProdutosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbProdutosMouseClicked
        if(tbProdutos.getSelectedRow() != -1){
            
            txtDescricaoProduto.setText(tbProdutos.getValueAt(tbProdutos.getSelectedRow(), 1).toString());

        }
    }//GEN-LAST:event_tbProdutosMouseClicked

    private void btnCadastrarProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarProdutoActionPerformed
        new ProdutoNovo().setVisible(true);
    }//GEN-LAST:event_btnCadastrarProdutoActionPerformed

    private void btnListarProdutosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListarProdutosActionPerformed
        mtp.carregaProdutos();
    }//GEN-LAST:event_btnListarProdutosActionPerformed

    private void btnExcluirProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirProdutoActionPerformed
        if(tbProdutos.getSelectedRow() != -1){
            ProdutoDAO pd = new ProdutoDAO();
            
            Produto p = pd.consultarProduto((int)tbProdutos.getValueAt(tbProdutos.getSelectedRow(), 0));
            
            if(p != null){
                pd.excluirProduto(p);
                JOptionPane.showMessageDialog(null, "Prododuto excluido!");
                mtp.carregaProdutos();
                txtDescricaoProduto.setText("");
            } else {
                JOptionPane.showMessageDialog(null, "Não existe produto com esse ID!");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Você deve selecionar um produto!");
        }
    }//GEN-LAST:event_btnExcluirProdutoActionPerformed

    private void btnAtualizarCliente1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtualizarCliente1ActionPerformed
        if(tbProdutos.getSelectedRow() != -1){
            Produto p = new Produto((int)mtp.getValueAt(tbProdutos.getSelectedRow(), 0), txtDescricaoProduto.getText());
            ProdutoDAO pd = new ProdutoDAO();
            
            
            pd.atualizarProduto(p);
            JOptionPane.showMessageDialog(null, "Produto atualizado!");
            
            mtp.carregaProdutos();
            txtDescricaoProduto.setText("");
            
        } else {
            JOptionPane.showMessageDialog(null, "Você deve selecionar um produto!");
        }
    }//GEN-LAST:event_btnAtualizarCliente1ActionPerformed

    private void btnListarPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListarPedidoActionPerformed
            if(tbPedidos.getSelectedRow() != -1){
                    //new ListaItem().setRow(tbProdutos.getSelectedRow());
                ListaItem lt = new ListaItem();
                //lt.setLinha((int)tbPedidos.getValueAt(tbPedidos.getSelectedRow(), 0));
                //System.out.println((int)tbPedidos.getValueAt(tbPedidos.getSelectedRow(), 0));
                int a = (int)tbPedidos.getValueAt(tbPedidos.getSelectedRow(), 0);
                lt.mti.carregaLista(a);
                lt.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null, "Você deve selecionar um pedido!");
            }

    }//GEN-LAST:event_btnListarPedidoActionPerformed

    private void btnExcluirPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirPedidoActionPerformed
            if(tbPedidos.getSelectedRow() != -1){
            PedidoDAO pd = new PedidoDAO();
            
            int id = (int)tbPedidos.getValueAt(tbPedidos.getSelectedRow(), 0);
            int ix = tbPedidos.getSelectedRow();
            
            if(id != 0){
                pd.excluirPedido(id);
                JOptionPane.showMessageDialog(null, "Pedido excluido!");
                
                mtlist.excluiPedido(ix);
            } else {
                JOptionPane.showMessageDialog(null, "Não existe pedido com esse ID!");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Você deve selecionar um pedido!");
        }
    }//GEN-LAST:event_btnExcluirPedidoActionPerformed

    private void tbPedidosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbPedidosMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tbPedidosMouseClicked

    private void btnBuscarPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarPedidoActionPerformed
        String cpf = txtCPFPedido.getText();
        
        try{
            mtlist.buscaPedidos(cpf);
            
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, "Erro ao listar pedidos! " + e.getLocalizedMessage());
        }
    }//GEN-LAST:event_btnBuscarPedidoActionPerformed

    private void btnCadastrarPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarPedidoActionPerformed
        new PedidoNovo().setVisible(true);
    }//GEN-LAST:event_btnCadastrarPedidoActionPerformed


    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Tela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Tela().setVisible(true);
            }

        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane aba;
    private javax.swing.JButton btnAtualizarCliente;
    private javax.swing.JButton btnAtualizarCliente1;
    private javax.swing.JButton btnBuscarPedido;
    private javax.swing.JButton btnCadastrarCliente;
    private javax.swing.JButton btnCadastrarPedido;
    private javax.swing.JButton btnCadastrarProduto;
    private javax.swing.JButton btnExcluirCliente;
    private javax.swing.JButton btnExcluirPedido;
    private javax.swing.JButton btnExcluirProduto;
    private javax.swing.JButton btnListarClientes;
    private javax.swing.JButton btnListarPedido;
    private javax.swing.JButton btnListarProdutos;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JLabel lblCPFCliente;
    private javax.swing.JLabel lblCPFPedido;
    private javax.swing.JLabel lblDescricaoProduto;
    private javax.swing.JLabel lblNomeCliente;
    private javax.swing.JLabel lblSobreNome;
    private javax.swing.JPanel panelClientes;
    private javax.swing.JPanel panelPedidos;
    private javax.swing.JPanel panelProdutos;
    private javax.swing.JScrollPane scrollClientes;
    private javax.swing.JScrollPane scrollPedidos;
    private javax.swing.JScrollPane scrollProdutos;
    private javax.swing.JTable tbPedidos;
    private javax.swing.JTable tbProdutos;
    private javax.swing.JTextField txtCPFCliente;
    private javax.swing.JTextField txtCPFPedido;
    private javax.swing.JTextField txtDescricaoProduto;
    // End of variables declaration//GEN-END:variables
}
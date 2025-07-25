package ViewLuidgi;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author luidgivarela
 */
import ModelLuidgi.BancoUsuarios;
import ModelLuidgi.UsuarioLogado;
import ModelLuidgi.Usuario;
import ModelLuidgi.Cliente;
import ModelLuidgi.SessaoUsuario;
import ModelLuidgi.Entregador;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.awt.Color;
import java.awt.Window;
import javax.swing.SwingUtilities;
import javax.swing.JFrame;


public class ConsultaHistorico extends javax.swing.JFrame implements UsuarioLogado {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(ConsultaHistorico.class.getName());
    private Usuario clienteLogado; 
    private JFrame telaAnterior;

    
    /**
     * Creates new form ConsultaHistorico
     */
    
    DefaultListModel<String> modeloLista = new DefaultListModel<>();

    String[] pedidosFalsos = {
        "🍕 Pedido 1: Calabresa + Refri – R$39,90",
        "🍕 Pedido 2: Marguerita – R$29,90",
        "🍕 Pedido 3: 2x Mussarela – R$49,00"
    };
    
    private void carregarPedidosFalsos() {
        modeloLista.clear();
        for (String p : pedidosFalsos) {
            modeloLista.addElement(p);
        }
        listaPedidos.setModel(modeloLista); 
    }
    
    private double extrairPreco(String pedido) {
        try {
            String[] partes = pedido.split("R\\$");
            String precoStr = partes[1].replace(",", ".").replaceAll("[^0-9.]", "");
            return Double.parseDouble(precoStr);
        } catch (Exception e) {
            return 0.0;
        }
    }
    
    public ConsultaHistorico() {
        initComponents();
        setLocationRelativeTo(null);    // centraliza na tela
        carregarPedidosFalsos();
        
        campoPesquisa.setText("Pesquise aqui o seu pedido...");
        campoPesquisa.setForeground(Color.GRAY);

        campoPesquisa.addFocusListener(new java.awt.event.FocusAdapter() {
            @Override
            public void focusGained(java.awt.event.FocusEvent evt) {
                if (campoPesquisa.getText().equals("Pesquise aqui o seu pedido...")) {
                    campoPesquisa.setText("");
                    campoPesquisa.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(java.awt.event.FocusEvent evt) {
                if (campoPesquisa.getText().isEmpty()) {
                    campoPesquisa.setForeground(Color.GRAY);
                    campoPesquisa.setText("Pesquise aqui o seu pedido...");
                }
            }
        });
    }

    public ConsultaHistorico(Usuario cliente) {
        this();
        this.clienteLogado = cliente;
        setUsuarioLogado(cliente);
    }
    
    public ConsultaHistorico(JFrame telaAnterior) {
        initComponents();
        this.telaAnterior = telaAnterior;
        setLocationRelativeTo(null);
    }

    
    @Override
    public void setUsuarioLogado(Usuario usuario) {
        String nomeCompleto = usuario.getNome();
        String nomeCurto = nomeCompleto.length() > 18 ? nomeCompleto.substring(0, 18) + "..." : nomeCompleto;

        labelUsuarioLogado.setText("Usuário: " + nomeCurto);
        labelUsuarioLogado.setToolTipText("Usuário: " + nomeCompleto);
    }

    @Override
    public Usuario getUsuarioLogado() {
        return this.clienteLogado;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        listaPedidos = new javax.swing.JList<>();
        campoPesquisa = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        comboFiltro = new javax.swing.JComboBox<>();
        botaoLimpar = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        labelUsuarioLogado = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(255, 248, 220));

        jLabel1.setFont(new java.awt.Font("Herculanum", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Veja aqui os seus últimos pedidos!");

        listaPedidos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(123, 63, 0), 3));
        listaPedidos.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        listaPedidos.setFixedCellHeight(30);
        jScrollPane2.setViewportView(listaPedidos);

        campoPesquisa.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(123, 63, 0), 3));

        jButton2.setBackground(new java.awt.Color(255, 193, 7));
        jButton2.setText("Pesquisar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        comboFiltro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos", "Mais recentes", "Mais antigos", "Maior preço", "Menor preço" }));
        comboFiltro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboFiltroActionPerformed(evt);
            }
        });

        botaoLimpar.setBackground(new java.awt.Color(255, 193, 7));
        botaoLimpar.setText("Limpar Filtros");
        botaoLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoLimparActionPerformed(evt);
            }
        });

        jButton5.setBackground(new java.awt.Color(255, 193, 7));
        jButton5.setText("⬅Voltar");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jButton5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 195, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(374, 374, 374))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(campoPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(comboFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(botaoLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)))
                        .addContainerGap())))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jButton5))
                .addGap(54, 54, 54)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2)
                    .addComponent(comboFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botaoLimpar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 538, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(71, 71, 71))
        );

        jPanel1.setBackground(new java.awt.Color(123, 63, 0));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        jButton1.setBackground(new java.awt.Color(255, 193, 7));
        jButton1.setText("🍕 Início");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(255, 193, 7));
        jButton3.setText("👋 Sair");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton6.setBackground(new java.awt.Color(255, 193, 7));
        jButton6.setText("👤Consulte seu Perfil");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton12.setBackground(new java.awt.Color(255, 193, 7));
        jButton12.setText("🕓Consulte seu Histórico");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        labelUsuarioLogado.setBackground(new java.awt.Color(255, 193, 7));
        labelUsuarioLogado.setText("Usuário:");
        labelUsuarioLogado.setOpaque(true);
        labelUsuarioLogado.setPreferredSize(new java.awt.Dimension(156, 23));

        jButton4.setBackground(new java.awt.Color(255, 0, 0));
        jButton4.setText("Logout");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton12)
                .addGap(18, 18, 18)
                .addComponent(jButton6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(labelUsuarioLogado, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton4)
                .addGap(18, 18, 18)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton3)
                    .addComponent(jButton6)
                    .addComponent(jButton12)
                    .addComponent(labelUsuarioLogado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4))
                .addContainerGap(11, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 659, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        LoginCliente_back telaLogin = new LoginCliente_back();
        telaLogin.setVisible(true);
        this.dispose(); // Fecha a tela atual
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        Usuario u = BancoUsuarios.listaUsuarios.get(0);

        if (u instanceof Cliente) {
            Cliente clienteLogado = (Cliente) u;
            ConsultaPerfilCliente_back telaPerfil = new ConsultaPerfilCliente_back(clienteLogado);
            telaPerfil.setVisible(true);
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(null, "Usuário logado não é um cliente.");
        }

        // Agora cria a tela passando o cliente como parâmetro
        ConsultaPerfilCliente_back telaPerfil = new ConsultaPerfilCliente_back(clienteLogado);
        telaPerfil.setVisible(true);
        dispose(); // fecha a tela atual (opcional)
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        ConsultaHistorico telaHistorico = new ConsultaHistorico();
        telaHistorico.setVisible(true);
        this.dispose(); // Fecha a tela atual
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        String termo = campoPesquisa.getText().toLowerCase();
        modeloLista.clear();

        for (String p : pedidosFalsos) {
            if (p.toLowerCase().contains(termo)) {
                modeloLista.addElement(p);
            }
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void comboFiltroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboFiltroActionPerformed
        String opcao = (String) comboFiltro.getSelectedItem();
        List<String> lista = new ArrayList<>(Arrays.asList(pedidosFalsos));

        switch (opcao) {
            case "Mais recentes":
                // Simula ordenação por data desc (último pedido primeiro)
                Collections.reverse(lista);
                break;

            case "Mais antigos":
                // Simula ordenação por data asc (primeiro pedido primeiro)
                // já está em ordem
                break;

            case "Maior preço":
                lista.sort((a, b) -> {
                    double pa = extrairPreco(b);
                    double pb = extrairPreco(a);
                    return Double.compare(pa, pb);
                });
                break;

            case "Menor preço":
                lista.sort((a, b) -> {
                    double pa = extrairPreco(a);
                    double pb = extrairPreco(b);
                    return Double.compare(pa, pb);
                });
                break;

            default:
                break;
        }

        modeloLista.clear();
        for (String p : lista) {
            modeloLista.addElement(p);
        }
    }//GEN-LAST:event_comboFiltroActionPerformed

    private void botaoLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoLimparActionPerformed
        campoPesquisa.setText(""); // limpa o campo de pesquisa
        comboFiltro.setSelectedIndex(0); // volta para "Todos"
        carregarPedidosFalsos(); // recarrega todos os pedidos
    }//GEN-LAST:event_botaoLimparActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // 1. Pega o usuário da sessão
        Usuario usuario = SessaoUsuario.getInstancia().getUsuarioLogado();

        // 2. Limpa a sessão
        SessaoUsuario.getInstancia().setUsuarioLogado(null);

        // 3. Reabre a tela de login correspondente
        if (usuario instanceof Cliente) {
            new LoginCliente_back().setVisible(true);
        } else if (usuario instanceof Entregador) {
            new LoginEntregador().setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Tipo de usuário desconhecido.");
            return;
        }

        // 4. Fecha a janela atual
        Window janelaAtual = SwingUtilities.getWindowAncestor(jButton4);
        if (janelaAtual != null) {
            janelaAtual.dispose();
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        if (telaAnterior != null) {
            telaAnterior.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_jButton5ActionPerformed

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
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new ConsultaHistorico().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoLimpar;
    private javax.swing.JTextField campoPesquisa;
    private javax.swing.JComboBox<String> comboFiltro;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel labelUsuarioLogado;
    private javax.swing.JList<String> listaPedidos;
    // End of variables declaration//GEN-END:variables
}

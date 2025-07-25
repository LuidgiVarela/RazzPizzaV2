package ViewArthur;

/**
 * @author arthu
 */

import ModelArthur.Dinheiro;
import ModelArthur.Pagamento;

import ViewLuidgi.ConsultaPerfilCliente_back;
import ViewLuidgi.ConsultaHistorico;
import ModelLuidgi.Cliente;
import ModelLuidgi.SessaoUsuario;

import java.awt.event.KeyEvent;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JLabel;



import java.awt.Window;
import javax.swing.SwingUtilities;
import javax.swing.JOptionPane;

import ModelLuidgi.SessaoUsuario;
import ModelLuidgi.Usuario;
import ModelLuidgi.Cliente;
import ModelLuidgi.Entregador;
import ViewLuidgi.LoginCliente_back;
import ViewLuidgi.LoginEntregador;


import ModelNikolle.Pedido;


public class TelaDinheiro extends javax.swing.JFrame {
    private Pedido pedido;
    private Usuario clienteLogado;
    
    /**
     * Creates new form Dinheiro
     */
    public TelaDinheiro(Pedido pedido) {
        this.pedido = pedido;
        initComponents();

        // Aplica o desconto de 10% via classe Dinheiro 
        double valorOriginal = pedido.calcularTotal();
        Dinheiro pagamento = new Dinheiro(valorOriginal);
        double valorComDesconto = pagamento.calcularValorFinal();

        // Mostra na label o valor com desconto
        String texto = String.format("Total a pagar: R$%.2f (10%% de desconto)", valorComDesconto);
        jLabelValor.setText(texto);

        // Configurações do campo de troco 
        jTextFieldTroco.setText("R$ ");
        jTextFieldTroco.setForeground(Color.BLACK);

        jTextFieldTroco.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent e) {
                String text = jTextFieldTroco.getText();
                char c = e.getKeyChar();

                // Impede apagar o "R$ "
                if (jTextFieldTroco.getCaretPosition() <= 3 && c == KeyEvent.VK_BACK_SPACE) {
                    e.consume();
                    return;
                }

                // Impede digitar antes do "R$ "
                if (jTextFieldTroco.getCaretPosition() < 3) {
                    jTextFieldTroco.setCaretPosition(jTextFieldTroco.getText().length());
                }

                // Permite apenas números e vírgula, limita a 10 caracteres totais
                if ((!Character.isDigit(c) && c != ',') || text.length() >= 13) {
                    e.consume();
                }
            }
        });
    }

    // Construtor padrão para testes (sem valor)
 


    public void setUsuarioLogado(Usuario usuario) {
        String nomeCompleto = usuario.getNome();
        String nomeCurto = nomeCompleto.length() > 18 ? nomeCompleto.substring(0, 18) + "..." : nomeCompleto;

        labelUsuarioLogado.setText("Usuário: " + nomeCurto);
        labelUsuarioLogado.setToolTipText("Usuário: " + nomeCompleto);
    }
    
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

        jPanel1 = new javax.swing.JPanel();
        jButtonInicio = new javax.swing.JButton();
        jButtonSair = new javax.swing.JButton();
        jButtonConsultarPerfil = new javax.swing.JButton();
        jButtonConsultarHistorico = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        labelUsuarioLogado = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabelValor = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldTroco = new javax.swing.JTextField();
        jButtonConfirmarPagamento = new javax.swing.JButton();
        jButtonVoltar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(123, 63, 0));

        jButtonInicio.setBackground(new java.awt.Color(255, 193, 7));
        jButtonInicio.setText("🍕 Início");
        jButtonInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonInicioActionPerformed(evt);
            }
        });

        jButtonSair.setBackground(new java.awt.Color(255, 193, 7));
        jButtonSair.setText("👋 Sair");
        jButtonSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSairActionPerformed(evt);
            }
        });

        jButtonConsultarPerfil.setBackground(new java.awt.Color(255, 193, 7));
        jButtonConsultarPerfil.setText("👤Consulte Seu Perfil");
        jButtonConsultarPerfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConsultarPerfilActionPerformed(evt);
            }
        });

        jButtonConsultarHistorico.setBackground(new java.awt.Color(255, 193, 7));
        jButtonConsultarHistorico.setText("🕓 Consulte seu Histórico");
        jButtonConsultarHistorico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConsultarHistoricoActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(255, 0, 0));
        jButton2.setText("Logout");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        labelUsuarioLogado.setBackground(new java.awt.Color(255, 193, 7));
        labelUsuarioLogado.setText("Usuário:");
        labelUsuarioLogado.setOpaque(true);
        labelUsuarioLogado.setPreferredSize(new java.awt.Dimension(156, 23));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButtonInicio)
                .addGap(18, 18, 18)
                .addComponent(jButtonConsultarHistorico)
                .addGap(18, 18, 18)
                .addComponent(jButtonConsultarPerfil)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(labelUsuarioLogado, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addGap(18, 18, 18)
                .addComponent(jButtonSair)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonInicio)
                    .addComponent(jButtonSair)
                    .addComponent(jButtonConsultarPerfil)
                    .addComponent(jButtonConsultarHistorico)
                    .addComponent(jButton2)
                    .addComponent(labelUsuarioLogado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(11, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 248, 220));
        jPanel2.setFont(new java.awt.Font("Segoe UI", 2, 24)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Segoe UI Emoji", 1, 48)); // NOI18N
        jLabel1.setText("          💵 Pagamento em Dinheiro             ");

        jLabelValor.setFont(new java.awt.Font("Segoe UI Emoji", 0, 24)); // NOI18N
        jLabelValor.setText("🧾 Valor total a pagar:");

        jLabel8.setFont(new java.awt.Font("Segoe UI Emoji", 0, 24)); // NOI18N
        jLabel8.setText("💰 Troco para quanto?:");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        jLabel2.setText("(Deixar em branco se não precisar)");

        jTextFieldTroco.setBackground(new java.awt.Color(255, 248, 220));
        jTextFieldTroco.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(123, 63, 0), 3, true));
        jTextFieldTroco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldTrocoActionPerformed(evt);
            }
        });

        jButtonConfirmarPagamento.setBackground(new java.awt.Color(255, 193, 7));
        jButtonConfirmarPagamento.setText("✅ Confirmar Pagamento");
        jButtonConfirmarPagamento.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(123, 63, 0), 3));
        jButtonConfirmarPagamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConfirmarPagamentoActionPerformed(evt);
            }
        });

        jButtonVoltar.setBackground(new java.awt.Color(255, 193, 7));
        jButtonVoltar.setText("↩ Voltar");
        jButtonVoltar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(123, 63, 0), 3));
        jButtonVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVoltarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(88, 88, 88)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 882, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabelValor))
                                .addGap(58, 58, 58)
                                .addComponent(jTextFieldTroco, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jButtonConfirmarPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButtonVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 393, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(72, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(143, 143, 143)
                .addComponent(jLabel1)
                .addGap(119, 119, 119)
                .addComponent(jLabelValor)
                .addGap(46, 46, 46)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jTextFieldTroco, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(167, 167, 167)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonConfirmarPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(109, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonInicioActionPerformed

        /*Codigo botao de inicio
        LoginCliente_back telaLogin = new LoginCliente_back();
        telaLogin.setVisible(true);
        this.dispose(); // Fecha a tela atual 
        */

    }//GEN-LAST:event_jButtonInicioActionPerformed

    private void jButtonSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSairActionPerformed
        // TODO add your handling code here:
          //Código sair:
        System.exit(0);
    }//GEN-LAST:event_jButtonSairActionPerformed

    private void jButtonConsultarPerfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConsultarPerfilActionPerformed
        // TODO add your handling code here:
        
        
         /*código consulte seu perfil:
         ConsultaPerfil_back telaPerfil = new ConsultaPerfil_back();
         telaPerfil.setVisible(true);
         dispose(); // opcional
        */
         
    }//GEN-LAST:event_jButtonConsultarPerfilActionPerformed

    private void jTextFieldTrocoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldTrocoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldTrocoActionPerformed

    private void jButtonConfirmarPagamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConfirmarPagamentoActionPerformed
        // TODO add your handling code here:
        double valorTotal = pedido.calcularTotal();
        Pagamento pagamento = new Dinheiro(valorTotal);
        pagamento.confirmarPagamento();      // Chama o método sobrescrito com JOptionPane
        
        Cliente cliente = (Cliente) SessaoUsuario.getInstancia().getUsuarioLogado();
        TelaAvaliacao avaliacao = new TelaAvaliacao(cliente);
        avaliacao.setVisible(true);
        this.dispose(); // Fecha a tela atual de pagamento

    }//GEN-LAST:event_jButtonConfirmarPagamentoActionPerformed

    private void jButtonVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVoltarActionPerformed
        // TODO add your handling code here:
        TelaPagamento pagamento = new TelaPagamento(pedido);
        pagamento.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButtonVoltarActionPerformed

    private void jButtonConsultarHistoricoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConsultarHistoricoActionPerformed
        // TODO add your handling code here:
        
        ConsultaHistorico telaHistorico = new ConsultaHistorico();
        telaHistorico.setVisible(true);
        this.dispose(); // Fecha a tela atual
       
    }//GEN-LAST:event_jButtonConsultarHistoricoActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // 1. Pega o usuário antes de limpar a sessão
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
        Window janelaAtual = SwingUtilities.getWindowAncestor(jButton2);
        if (janelaAtual != null) {
            janelaAtual.dispose();
        }
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(TelaDinheiro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaDinheiro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaDinheiro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaDinheiro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
    //    java.awt.EventQueue.invokeLater(new Runnable() {
    //        public void run() {
    //            new TelaDinheiro().setVisible(true);
    //        }
    //    });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButtonConfirmarPagamento;
    private javax.swing.JButton jButtonConsultarHistorico;
    private javax.swing.JButton jButtonConsultarPerfil;
    private javax.swing.JButton jButtonInicio;
    private javax.swing.JButton jButtonSair;
    private javax.swing.JButton jButtonVoltar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabelValor;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jTextFieldTroco;
    private javax.swing.JLabel labelUsuarioLogado;
    // End of variables declaration//GEN-END:variables
}

package ViewArthur;

import ViewLuidgi.ConsultaHistorico;
import ViewLuidgi.ConsultaPerfilCliente_back;


/**
 *
 * @author arthu
 */

import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.Font;
import javax.swing.JOptionPane;
import java.awt.Window;
import javax.swing.SwingUtilities;

import ModelLuidgi.SessaoUsuario;
import ModelLuidgi.Usuario;
import ModelLuidgi.Cliente;
import ModelLuidgi.Entregador;
import ViewLuidgi.LoginCliente_back;
import ViewLuidgi.LoginEntregador;


public class TelaReserva extends javax.swing.JFrame {

    private Usuario clienteLogado;
    
    /**
     * Creates new form Reserva
     */
    public TelaReserva() {
        initComponents();
        setSize(900,800);
        Font fonte = new Font("Segoe UI", Font.PLAIN, 18);

        // Placeholder e restrições: campo Data (ex: 12/12/25)
        jTextFieldData.setText("12/12/25");
        jTextFieldData.setForeground(Color.GRAY);
        jTextFieldData.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (jTextFieldData.getText().equals("12/12/25")) {
                    jTextFieldData.setText("");
                    jTextFieldData.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (jTextFieldData.getText().isEmpty()) {
                    jTextFieldData.setText("12/12/25");
                    jTextFieldData.setForeground(Color.GRAY);
                }
            }
        });
        jTextFieldData.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                String text = jTextFieldData.getText().replaceAll("[^0-9]", "");

                if (!Character.isDigit(c) || text.length() >= 6) {
                    e.consume();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                String text = jTextFieldData.getText().replaceAll("[^0-9]", "");
                StringBuilder sb = new StringBuilder();

                for (int i = 0; i < text.length(); i++) {
                    sb.append(text.charAt(i));
                    if (i == 1 || i == 3) sb.append('/');
                }

                jTextFieldData.setText(sb.toString());
            }
        });

        // Placeholder e restrições: campo Horário (ex: 19:30)
        jTextFieldHorario.setText("19:30");
        jTextFieldHorario.setForeground(Color.GRAY);
        jTextFieldHorario.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (jTextFieldHorario.getText().equals("19:30")) {
                    jTextFieldHorario.setText("");
                    jTextFieldHorario.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (jTextFieldHorario.getText().isEmpty()) {
                    jTextFieldHorario.setText("19:30");
                    jTextFieldHorario.setForeground(Color.GRAY);
                }
            }
        });
        jTextFieldHorario.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                String text = jTextFieldHorario.getText().replaceAll("[^0-9]", "");

                if (!Character.isDigit(c) || text.length() >= 4) {
                    e.consume();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                String text = jTextFieldHorario.getText().replaceAll("[^0-9]", "");
                StringBuilder sb = new StringBuilder();

                for (int i = 0; i < text.length(); i++) {
                    sb.append(text.charAt(i));
                    if (i == 1) sb.append(':');
                }

                jTextFieldHorario.setText(sb.toString());
            }
        });

        // Placeholder e restrições: campo Nome
        jTextFieldNome.setText("Seu Nome");
        jTextFieldNome.setForeground(Color.GRAY);
        jTextFieldNome.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (jTextFieldNome.getText().equals("Seu Nome")) {
                    jTextFieldNome.setText("");
                    jTextFieldNome.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (jTextFieldNome.getText().isEmpty()) {
                    jTextFieldNome.setText("Seu Nome");
                    jTextFieldNome.setForeground(Color.GRAY);
                }
            }
        });
        jTextFieldNome.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isLetter(c) && !Character.isWhitespace(c)) {
                    e.consume();
                }
                if (jTextFieldNome.getText().length() >= 30) {
                    e.consume();
                }
            }
        });

        // Placeholder e restrições: campo Número de Pessoas
        jTextFieldNumPessoas.setText("05");
        jTextFieldNumPessoas.setForeground(Color.GRAY);
        jTextFieldNumPessoas.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (jTextFieldNumPessoas.getText().equals("05")) {
                    jTextFieldNumPessoas.setText("");
                    jTextFieldNumPessoas.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (jTextFieldNumPessoas.getText().isEmpty()) {
                    jTextFieldNumPessoas.setText("05");
                    jTextFieldNumPessoas.setForeground(Color.GRAY);
                }
            }
        });
        jTextFieldNumPessoas.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isDigit(c) || jTextFieldNumPessoas.getText().length() >= 2) {
                    e.consume();
                }
            }
        });
    }
    
    // parte de aparecer o usuário no menu marrom
    public TelaReserva(Usuario usuario) {
        this(); // Chama o construtor padrão
        this.clienteLogado = usuario;
        setUsuarioLogado(usuario);
    }
    
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

        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jButtonInicio = new javax.swing.JButton();
        jButtonSair = new javax.swing.JButton();
        jButtonConsultarPerfil = new javax.swing.JButton();
        jButtonConsultarHistorico = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        labelUsuarioLogado = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        jButtonConfirmarReserva = new javax.swing.JButton();
        jTextFieldHorario = new javax.swing.JTextField();
        jTextFieldNome = new javax.swing.JTextField();
        jTextFieldNumPessoas = new javax.swing.JTextField();
        jTextFieldData = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(255, 248, 220));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jPanel3.setBackground(new java.awt.Color(123, 63, 0));

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

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
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
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonInicio)
                    .addComponent(jButtonSair)
                    .addComponent(jButtonConsultarPerfil)
                    .addComponent(jButtonConsultarHistorico)
                    .addComponent(jButton2)
                    .addComponent(labelUsuarioLogado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(11, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Segoe UI Emoji", 0, 18)); // NOI18N
        jLabel1.setText("📅 Data:  ");

        jLabel2.setFont(new java.awt.Font("Segoe UI Emoji", 0, 48)); // NOI18N
        jLabel2.setText(" 🍽️ Agendar Reserva");

        jLabel4.setFont(new java.awt.Font("Segoe UI Emoji", 0, 18)); // NOI18N
        jLabel4.setText("👥 Nº de Pessoas:");

        jLabel5.setFont(new java.awt.Font("Segoe UI Emoji", 0, 18)); // NOI18N
        jLabel5.setText("⏰ Horário:");

        jLabel6.setFont(new java.awt.Font("Segoe UI Emoji", 0, 18)); // NOI18N
        jLabel6.setText("👤 Nome:  ");

        jButton7.setBackground(new java.awt.Color(255, 193, 7));
        jButton7.setText("↩ Voltar");
        jButton7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(123, 63, 0), 3));
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButtonConfirmarReserva.setBackground(new java.awt.Color(255, 193, 7));
        jButtonConfirmarReserva.setText("✅ Confirmar Reserva");
        jButtonConfirmarReserva.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(123, 63, 0), 3));
        jButtonConfirmarReserva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConfirmarReservaActionPerformed(evt);
            }
        });

        jTextFieldHorario.setBackground(new java.awt.Color(255, 248, 220));
        jTextFieldHorario.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(123, 63, 0), 3, true));
        jTextFieldHorario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldHorarioActionPerformed(evt);
            }
        });

        jTextFieldNome.setBackground(new java.awt.Color(255, 248, 220));
        jTextFieldNome.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(123, 63, 0), 3, true));
        jTextFieldNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNomeActionPerformed(evt);
            }
        });

        jTextFieldNumPessoas.setBackground(new java.awt.Color(255, 248, 220));
        jTextFieldNumPessoas.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(123, 63, 0), 3, true));
        jTextFieldNumPessoas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNumPessoasActionPerformed(evt);
            }
        });

        jTextFieldData.setBackground(new java.awt.Color(255, 248, 220));
        jTextFieldData.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(123, 63, 0), 3, true));
        jTextFieldData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldDataActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(88, 88, 88)
                                .addComponent(jLabel3))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(38, 38, 38)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel1)
                                            .addComponent(jLabel6)
                                            .addComponent(jLabel4))
                                        .addGap(7, 7, 7))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addComponent(jLabel5)
                                        .addGap(63, 63, 63)))
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jTextFieldNome, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 293, Short.MAX_VALUE)
                                    .addComponent(jTextFieldData, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextFieldHorario, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextFieldNumPessoas))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 171, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButtonConfirmarReserva, javax.swing.GroupLayout.DEFAULT_SIZE, 241, Short.MAX_VALUE)
                    .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(689, 689, 689))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                    .addContainerGap(330, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 513, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(258, 258, 258)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(296, 296, 296)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextFieldData, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTextFieldHorario, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextFieldNumPessoas, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(82, 82, 82)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addComponent(jButtonConfirmarReserva, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(186, 186, 186)
                    .addComponent(jLabel2)
                    .addContainerGap(563, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 6, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 46, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonConfirmarReservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConfirmarReservaActionPerformed


     // Verificar se todos os campos estão preenchidos corretamente
    String data = jTextFieldData.getText().trim();
    String horario = jTextFieldHorario.getText().trim();
    String nome = jTextFieldNome.getText().trim();
    String pessoas = jTextFieldNumPessoas.getText().trim();

   // Verificar se todos os campos estão preenchidos corretamente
if (
    jTextFieldData.getText().trim().isEmpty() || jTextFieldData.getText().equals("12/12/25") ||
    jTextFieldHorario.getText().trim().isEmpty() || jTextFieldHorario.getText().equals("19:30") ||
    jTextFieldNome.getText().trim().isEmpty() || jTextFieldNome.getText().equals("Seu Nome") ||
    jTextFieldNumPessoas.getText().trim().isEmpty() || jTextFieldNumPessoas.getText().equals("05")
) {
    JOptionPane.showMessageDialog(
        this,
        "Por favor, preencha todos os campos corretamente antes de confirmar a reserva.",
        "Campos obrigatórios",
        JOptionPane.ERROR_MESSAGE
    );
    return; // Impede o prosseguimento
    }

    // Tudo certo, abre a tela de confirmação
    TelaDesejaAgendarPedido agendar = new TelaDesejaAgendarPedido();
    agendar.setVisible(true);
    this.dispose();

    }//GEN-LAST:event_jButtonConfirmarReservaActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        TelaModalidades modalidades = new TelaModalidades(); // Cria a nova tela
        modalidades.setVisible(true);               // Exibe a tela TelaModalidades
        this.dispose();   //fechar tela atual                
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButtonConsultarPerfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConsultarPerfilActionPerformed
        // TODO add your handling code here:
        
         /*código consulte seu perfil:
         ConsultaPerfil_back telaPerfil = new ConsultaPerfil_back();
         telaPerfil.setVisible(true);
         dispose(); // opcional
        */
         
    }//GEN-LAST:event_jButtonConsultarPerfilActionPerformed

    private void jButtonSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSairActionPerformed
        // TODO add your handling code here:
        
         //Código sair:
        System.exit(0);
    }//GEN-LAST:event_jButtonSairActionPerformed

    private void jButtonInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonInicioActionPerformed
        // TODO add your handling code here:
         /*Codigo botao de inicio
        LoginCliente_back telaLogin = new LoginCliente_back();
        telaLogin.setVisible(true);
        this.dispose(); // Fecha a tela atual 
        */

    }//GEN-LAST:event_jButtonInicioActionPerformed

    private void jButtonConsultarHistoricoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConsultarHistoricoActionPerformed
        // TODO add your handling code here:
        
        ConsultaHistorico telaHistorico = new ConsultaHistorico();
        telaHistorico.setVisible(true);
        this.dispose(); // Fecha a tela atual
       
    }//GEN-LAST:event_jButtonConsultarHistoricoActionPerformed

    private void jTextFieldHorarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldHorarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldHorarioActionPerformed

    private void jTextFieldNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldNomeActionPerformed

    private void jTextFieldNumPessoasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNumPessoasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldNumPessoasActionPerformed

    private void jTextFieldDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldDataActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldDataActionPerformed

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
            java.util.logging.Logger.getLogger(TelaReserva.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaReserva.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaReserva.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaReserva.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaReserva().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButtonConfirmarReserva;
    private javax.swing.JButton jButtonConsultarHistorico;
    private javax.swing.JButton jButtonConsultarPerfil;
    private javax.swing.JButton jButtonInicio;
    private javax.swing.JButton jButtonSair;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField jTextFieldData;
    private javax.swing.JTextField jTextFieldHorario;
    private javax.swing.JTextField jTextFieldNome;
    private javax.swing.JTextField jTextFieldNumPessoas;
    private javax.swing.JLabel labelUsuarioLogado;
    // End of variables declaration//GEN-END:variables
}

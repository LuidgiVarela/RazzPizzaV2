/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ViewLuidgi;

import ModelLuidgi.Entregador;
import ModelLuidgi.BancoUsuarios;
import java.awt.Color;
import java.awt.Font;
import java.text.ParseException;
import javax.swing.JOptionPane;
import javax.swing.text.MaskFormatter;
import javax.swing.text.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.SwingUtilities;

/**
 *
 * @author luidgivarela
 */
public class CadastroEntregador extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(CadastroEntregador.class.getName());

    /**
     * Creates new form CadastroEntregador
     */
    public CadastroEntregador() {
        initComponents();
        setLocationRelativeTo(null);

        // formatação para o número de telefone
        try {
            MaskFormatter telefoneFormatter = new MaskFormatter("(##) #####-####");
            telefoneFormatter.setPlaceholderCharacter('_');
            campoTelefone1.setFormatterFactory(
            new javax.swing.text.DefaultFormatterFactory(telefoneFormatter)
        );
        campoTelefone1.setFont(new java.awt.Font("SansSerif", java.awt.Font.PLAIN, 18));
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        
        campoTelefone1.addFocusListener(new FocusAdapter() {
        @Override
        public void focusGained(FocusEvent evt) {
            SwingUtilities.invokeLater(() -> campoTelefone1.setCaretPosition(0));
        }
        });
        
        // formatação para o número da CNH
        try {
            MaskFormatter maskCPF = new MaskFormatter("###.###.###-##");
            maskCPF.setPlaceholderCharacter('_');
            campoCPF.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(maskCPF));
            campoCPF.setFont(new java.awt.Font("SansSerif", java.awt.Font.BOLD, 14));
            campoCPF.setBackground(new java.awt.Color(240, 240, 240));
        } catch (java.text.ParseException e) {
            e.printStackTrace();
        }

        campoCNH.addFocusListener(new FocusAdapter() {
        @Override
        public void focusGained(FocusEvent evt) {
            SwingUtilities.invokeLater(() -> campoCNH.setCaretPosition(0));
        }
        });
        
        //filtro de números
        ((AbstractDocument) campoCNH.getDocument()).setDocumentFilter(new NumerosLimitadosFilter(11));

        
        // placeholder para o nome
        campoNome.setText("Fulano da Silva");
        campoNome.setForeground(Color.GRAY);
        campoNome.setFont(new Font("SansSerif", Font.ITALIC, 12));
        campoNome.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                if (campoNome.getText().equals("Fulano da Silva")) {
                    campoNome.setText("");
                    campoNome.setForeground(Color.BLACK);
                    campoNome.setFont(new Font("SansSerif", Font.PLAIN, 12));
                }
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                if (campoNome.getText().isEmpty()) {
                    campoNome.setText("Fulano da Silva");
                    campoNome.setForeground(Color.GRAY);
                    campoNome.setFont(new Font("SansSerif", Font.ITALIC, 12));
                }
            }
        });        

        // placeholder para o número de telefone
        campoTelefone1.setText("(0)90000-0000");
        campoTelefone.setForeground(Color.GRAY);
        campoTelefone.setFont(new Font("SansSerif", Font.ITALIC, 12));
        campoTelefone.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                if (campoTelefone1.getText().equals("(99)99999-9999")) {
                    campoTelefone1.setText("");
                    campoTelefone.setForeground(Color.BLACK);
                    campoTelefone.setFont(new Font("SansSerif", Font.PLAIN, 12));
                }
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                if (campoTelefone1.getText().isEmpty()) {
                    campoTelefone1.setText("(99)99999-9999");
                    campoTelefone.setForeground(Color.GRAY);
                    campoTelefone.setFont(new Font("SansSerif", Font.ITALIC, 12));
                }
            }
        });        
        
        // placeholder para email
        campoEmail.setText("exemplo@gmail.com");
        campoEmail.setForeground(Color.GRAY);
        campoEmail.setFont(new Font("SansSerif", Font.ITALIC, 12));
        campoEmail.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                if (campoEmail.getText().equals("exemplo@gmail.com")) {
                    campoEmail.setText("");
                    campoEmail.setForeground(Color.BLACK);
                    campoEmail.setFont(new Font("SansSerif", Font.PLAIN, 12));
                }
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                if (campoEmail.getText().isEmpty()) {
                    campoEmail.setText("exemplo@gmail.com");
                    campoEmail.setForeground(Color.GRAY);
                    campoEmail.setFont(new Font("SansSerif", Font.ITALIC, 12));
                }
            }
        });

        // placeholder para CPF
        campoCPF.setText("000.000.000-00");
        campoCPF.setForeground(Color.GRAY);
        campoCPF.setFont(new Font("SansSerif", Font.ITALIC, 12));
        campoCPF.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                if (campoCPF.getText().equals("000.000.000-00")) {
                    campoCPF.setText("");
                    campoCPF.setForeground(Color.BLACK);
                    campoCPF.setFont(new Font("SansSerif", Font.PLAIN, 12));
                }
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                if (campoCPF.getText().isEmpty()) {
                    campoCPF.setText("000.000.000-00");
                    campoCPF.setForeground(Color.GRAY);
                    campoCPF.setFont(new Font("SansSerif", Font.ITALIC, 12));
                }
            }
        });
/*
        // placeholder para o número de CNH
        campoCNH.setText("00000000000");
        campoCNH.setForeground(Color.GRAY);
        campoCNH.setFont(new Font("SansSerif", Font.ITALIC, 12));
        campoCNH.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                if (campoCNH.getText().equals("00000000000")) {
                    campoCNH.setText("");
                    campoCNH.setForeground(Color.BLACK);
                    campoCNH.setFont(new Font("SansSerif", Font.PLAIN, 12));
                }
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                if (campoCNH.getText().isEmpty()) {
                    campoCNH.setText("00000000000");
                    campoCNH.setForeground(Color.GRAY);
                    campoCNH.setFont(new Font("SansSerif", Font.ITALIC, 12));
                }
            }
        });
*/
    }

    public class NumerosLimitadosFilter extends DocumentFilter {
        private int limite;

        public NumerosLimitadosFilter(int limite) {
            this.limite = limite;
        }

        @Override
        public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr)
                throws BadLocationException {
            if (string == null) return;

            // Só permite números e respeita o limite
                if ((fb.getDocument().getLength() + string.length()) <= limite && string.matches("\\d+")) {
                    super.insertString(fb, offset, string, attr);
                }
            }

        @Override
        public void replace(FilterBypass fb, int offset, int length, String string, AttributeSet attrs)
                throws BadLocationException {
            if (string == null) return;

                if ((fb.getDocument().getLength() - length + string.length()) <= limite && string.matches("\\d+")) {
                    super.replace(fb, offset, length, string, attrs);
                }
            }
    }    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        campoTelefone = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        campoNome = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        campoEmail = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        campoSenha = new javax.swing.JPasswordField();
        campoConfirmaSenha = new javax.swing.JPasswordField();
        campoTelefone1 = new javax.swing.JFormattedTextField();
        campoCPF = new javax.swing.JFormattedTextField();
        jLabel6 = new javax.swing.JLabel();
        campoCNH = new javax.swing.JFormattedTextField();
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        campoTelefone.setBackground(new java.awt.Color(123, 63, 0));
        campoTelefone.setForeground(new java.awt.Color(255, 255, 255));

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

        javax.swing.GroupLayout campoTelefoneLayout = new javax.swing.GroupLayout(campoTelefone);
        campoTelefone.setLayout(campoTelefoneLayout);
        campoTelefoneLayout.setHorizontalGroup(
            campoTelefoneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(campoTelefoneLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        campoTelefoneLayout.setVerticalGroup(
            campoTelefoneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(campoTelefoneLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(campoTelefoneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton3))
                .addContainerGap(11, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(255, 248, 220));
        jPanel5.setLayout(new java.awt.GridBagLayout());

        jLabel1.setFont(new java.awt.Font("Herculanum", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Faça o seu Cadastro para ser entregador!");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(57, 339, 0, 103);
        jPanel5.add(jLabel1, gridBagConstraints);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("👤 Digite seu nome:");

        campoNome.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(123, 63, 0), 3));
        campoNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoNomeActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("📞 Digite seu telefone:");

        jLabel4.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        jLabel4.setText("📧 Digite seu email:");

        campoEmail.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(123, 63, 0), 3));
        campoEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoEmailActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        jLabel5.setText("🪪 Digite seu CPF:");

        jLabel9.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        jLabel9.setText("🔐 Crie a sua senha: ");

        jLabel10.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        jLabel10.setText("✅ Confirme a sua senha: ");

        jButton5.setBackground(new java.awt.Color(255, 193, 7));
        jButton5.setText("🟢Finalizar cadastro");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        campoSenha.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(123, 63, 0), 3));
        campoSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoSenhaActionPerformed(evt);
            }
        });

        campoConfirmaSenha.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(123, 63, 0), 3));

        campoTelefone1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(123, 63, 0), 3));
        campoTelefone1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoTelefone1ActionPerformed(evt);
            }
        });

        campoCPF.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(123, 63, 0), 3));

        jLabel6.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        jLabel6.setText("📜 Digite o número de sua CNH:");

        campoCNH.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(123, 63, 0), 3));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(266, 266, 266)
                        .addComponent(jLabel2)
                        .addGap(33, 33, 33)
                        .addComponent(campoNome, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(266, 266, 266)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(campoTelefone1, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(266, 266, 266)
                        .addComponent(jLabel4)
                        .addGap(35, 35, 35)
                        .addComponent(campoEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(266, 266, 266)
                        .addComponent(jLabel5)
                        .addGap(42, 42, 42)
                        .addComponent(campoCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(240, 240, 240)
                        .addComponent(jLabel10)
                        .addGap(18, 18, 18)
                        .addComponent(campoConfirmaSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(825, 825, 825)
                        .addComponent(jButton5))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(266, 266, 266)
                                .addComponent(jLabel9))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(196, 196, 196)
                                .addComponent(jLabel6)))
                        .addGap(24, 24, 24)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(campoSenha)
                            .addComponent(campoCNH, javax.swing.GroupLayout.DEFAULT_SIZE, 257, Short.MAX_VALUE))))
                .addGap(18, 18, 18))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jLabel2))
                    .addComponent(campoNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jLabel3))
                    .addComponent(campoTelefone1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jLabel4))
                    .addComponent(campoEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jLabel5))
                    .addComponent(campoCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(campoCNH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jLabel9))
                    .addComponent(campoSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jLabel10))
                    .addComponent(campoConfirmaSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47)
                .addComponent(jButton5))
        );

        jPanel1.setBackground(new java.awt.Color(255, 248, 220));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 130, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(campoTelefone, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(campoTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void campoNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoNomeActionPerformed

    private void campoEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoEmailActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // 1. Coletar os dados dos campos
        String nome = campoNome.getText();
        String email = campoEmail.getText();
        String cpf = campoCPF.getText();
        String cnh = campoCNH.getText();
        String telefone = campoTelefone1.getText();
        String senha = campoSenha.getText();
        String confirmaSenha = campoConfirmaSenha.getText(); // Certifique-se de ter declarado isso

        // 2. Verificar se algum campo está vazio
        if (nome.trim().isEmpty() || email.trim().isEmpty() || telefone.trim().isEmpty() ||
            senha.trim().isEmpty() || confirmaSenha.trim().isEmpty() || cpf.trim().isEmpty() || cnh.trim().isEmpty()) {

            JOptionPane.showMessageDialog(null, "Por favor, preencha todos os campos!", "Campos obrigatórios", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // 3. Verificar se a senha e a confirmação coincidem
        if (!senha.equals(confirmaSenha)) {
            JOptionPane.showMessageDialog(null, "As senhas não coincidem!", "Erro de senha", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // 4. Verificar se o e-mail já está em uso
        if (BancoUsuarios.buscarPorEmail(email) != null) {
            JOptionPane.showMessageDialog(null, "E-mail indisponível", "Erro", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // 5. Criar e salvar o entregador
        Entregador entregador = new Entregador(nome, email, senha, telefone, cpf, cnh);
        BancoUsuarios.listaUsuarios.add(entregador);

        // 6. Feedback e redirecionamento
        JOptionPane.showMessageDialog(null, "Entregador cadastrado com sucesso!");
        LoginEntregador loginEntregador = new LoginEntregador();
        loginEntregador.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void campoSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoSenhaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoSenhaActionPerformed

    private void campoTelefone1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoTelefone1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoTelefone1ActionPerformed

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
        java.awt.EventQueue.invokeLater(() -> new CadastroEntregador().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFormattedTextField campoCNH;
    private javax.swing.JFormattedTextField campoCPF;
    private javax.swing.JPasswordField campoConfirmaSenha;
    private javax.swing.JTextField campoEmail;
    private javax.swing.JTextField campoNome;
    private javax.swing.JPasswordField campoSenha;
    private javax.swing.JPanel campoTelefone;
    private javax.swing.JFormattedTextField campoTelefone1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    // End of variables declaration//GEN-END:variables
}

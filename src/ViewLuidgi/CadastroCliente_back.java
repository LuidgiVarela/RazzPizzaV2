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
import ModelLuidgi.Cliente;
import java.awt.Color;
import java.awt.Font;
import javax.swing.text.MaskFormatter;
import java.text.ParseException;
import javax.swing.text.*;
import javax.swing.JOptionPane;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.SwingUtilities;

public class CadastroCliente_back extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(CadastroCliente_back.class.getName());

    /**
     * Creates new form CadastroCliente
     */
    public CadastroCliente_back() {
        initComponents();
        jButton1.setBackground(new java.awt.Color(255, 204, 0)); // amarelo
        jButton1.setForeground(java.awt.Color.BLACK); // texto preto
        setLocationRelativeTo(null);    // centraliza na tela
        
        ((AbstractDocument) campoNumResidencia.getDocument()).setDocumentFilter(new NumerosLimitadosFilter(5));
        
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

        // formtação para o CPF
        try {
            MaskFormatter maskCPF = new MaskFormatter("###.###.###-##");
            maskCPF.setPlaceholderCharacter('_'); // Usa underline como caractere de preenchimento

            campoCPF.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(maskCPF));
            campoCPF.setFont(new java.awt.Font("SansSerif", java.awt.Font.BOLD, 14));
            campoCPF.setBackground(new java.awt.Color(240, 240, 240));
        } catch (java.text.ParseException e) {
            e.printStackTrace();
        }
        
        campoCPF.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent evt) {
                SwingUtilities.invokeLater(() -> campoCPF.setCaretPosition(0));
            }
        });

        // formatação para o CEP
        try {
            MaskFormatter maskCEP = new MaskFormatter("#####-###");
            maskCEP.setPlaceholderCharacter('_'); // Define o underline como caractere de preenchimento

            campoCEP.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(maskCEP));
            campoCEP.setFont(new java.awt.Font("SansSerif", java.awt.Font.BOLD, 14));
            campoCEP.setBackground(new java.awt.Color(240, 240, 240));
        } catch (java.text.ParseException e) {
            e.printStackTrace();
        }
        
        campoCEP.addFocusListener(new FocusAdapter() {
        @Override
        public void focusGained(FocusEvent evt) {
            SwingUtilities.invokeLater(() -> campoCEP.setCaretPosition(0));
        }
        });
        
        
        // placeholder nome
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

        // placeholder número de telefone
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

        // placeholder email
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

        // placeholder CPF
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

        // placeholder CEP
        campoCEP.setText("00000-000");
        campoCEP.setForeground(Color.GRAY);
        campoCEP.setFont(new Font("SansSerif", Font.ITALIC, 12));
        campoCEP.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                if (campoCEP.getText().equals("00000-000")) {
                    campoCEP.setText("");
                    campoCEP.setForeground(Color.BLACK);
                    campoCEP.setFont(new Font("SansSerif", Font.PLAIN, 12));
                }
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                if (campoCEP.getText().isEmpty()) {
                    campoCEP.setText("00000-000");
                    campoCEP.setForeground(Color.GRAY);
                    campoCEP.setFont(new Font("SansSerif", Font.ITALIC, 12));
                }
            }
        });     
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

        jButton2 = new javax.swing.JButton();
        jTextField3 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        campoTelefone = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        campoNome = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        campoEmail = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        campoSenha = new javax.swing.JPasswordField();
        campoConfirmaSenha = new javax.swing.JPasswordField();
        campoTelefone1 = new javax.swing.JFormattedTextField();
        campoCPF = new javax.swing.JFormattedTextField();
        campoCEP = new javax.swing.JFormattedTextField();
        campoNumResidencia = new javax.swing.JFormattedTextField();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();

        jButton2.setText("Início");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(255, 193, 7));
        jButton4.setText("👋 Sair");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        campoTelefone.setBackground(new java.awt.Color(123, 63, 0));
        campoTelefone.setForeground(new java.awt.Color(255, 255, 255));
        campoTelefone.setPreferredSize(new java.awt.Dimension(235, 40));

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

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new java.awt.GridBagLayout());

        jLabel2.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("👤 Digite seu nome:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(70, 278, 0, 0);
        jPanel3.add(jLabel2, gridBagConstraints);

        campoNome.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(123, 63, 0), 3));
        campoNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoNomeActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 20;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 192;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(68, 18, 0, 0);
        jPanel3.add(campoNome, gridBagConstraints);

        jLabel3.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("📞 Digite seu telefone:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(33, 278, 0, 0);
        jPanel3.add(jLabel3, gridBagConstraints);

        jLabel4.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        jLabel4.setText("📧 Digite seu email:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(31, 278, 0, 0);
        jPanel3.add(jLabel4, gridBagConstraints);

        campoEmail.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(123, 63, 0), 3));
        campoEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoEmailActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 40;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 193;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(29, 18, 0, 0);
        jPanel3.add(campoEmail, gridBagConstraints);

        jLabel5.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        jLabel5.setText("🪪 Digite seu CPF:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(31, 278, 0, 0);
        jPanel3.add(jLabel5, gridBagConstraints);

        jLabel7.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        jLabel7.setText("📮 Informe seu CEP:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(31, 278, 0, 0);
        jPanel3.add(jLabel7, gridBagConstraints);

        jLabel8.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        jLabel8.setText("🏠 Número de sua residência:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.gridwidth = 13;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(28, 278, 0, 0);
        jPanel3.add(jLabel8, gridBagConstraints);

        jLabel9.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        jLabel9.setText("🔐 Crie a sua senha: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(28, 278, 0, 0);
        jPanel3.add(jLabel9, gridBagConstraints);

        jLabel10.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        jLabel10.setText("✅ Confirme a sua senha: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 14;
        gridBagConstraints.gridwidth = 7;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(31, 278, 0, 0);
        jPanel3.add(jLabel10, gridBagConstraints);

        jButton5.setBackground(new java.awt.Color(255, 193, 7));
        jButton5.setText("🟢Finalizar cadastro");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 46;
        gridBagConstraints.gridy = 15;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(47, 139, 0, 40);
        jPanel3.add(jButton5, gridBagConstraints);

        campoSenha.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(123, 63, 0), 3));
        campoSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoSenhaActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 12;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.gridwidth = 34;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 178;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(26, 7, 0, 0);
        jPanel3.add(campoSenha, gridBagConstraints);

        campoConfirmaSenha.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(123, 63, 0), 3));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 12;
        gridBagConstraints.gridy = 14;
        gridBagConstraints.gridwidth = 14;
        gridBagConstraints.ipadx = 178;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(26, 6, 0, 0);
        jPanel3.add(campoConfirmaSenha, gridBagConstraints);

        campoTelefone1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(123, 63, 0), 3));
        campoTelefone1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoTelefone1ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 20;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 192;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(31, 18, 0, 0);
        jPanel3.add(campoTelefone1, gridBagConstraints);

        campoCPF.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(123, 63, 0), 3));
        campoCPF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoCPFActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 40;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 193;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(29, 18, 0, 0);
        jPanel3.add(campoCPF, gridBagConstraints);

        campoCEP.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(123, 63, 0), 3));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridwidth = 40;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 193;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(29, 18, 0, 0);
        jPanel3.add(campoCEP, gridBagConstraints);

        campoNumResidencia.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(123, 63, 0), 3));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 25;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.gridwidth = 21;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 149;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(26, 12, 0, 0);
        jPanel3.add(campoNumResidencia, gridBagConstraints);

        jPanel5.setBackground(new java.awt.Color(255, 248, 220));
        jPanel5.setLayout(new java.awt.GridBagLayout());

        jLabel1.setFont(new java.awt.Font("Herculanum", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Faça o seu Cadastro!");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(57, 418, 0, 359);
        jPanel5.add(jLabel1, gridBagConstraints);

        jPanel4.setBackground(new java.awt.Color(255, 248, 220));
        jPanel4.setLayout(new java.awt.GridBagLayout());

        jPanel2.setBackground(new java.awt.Color(255, 248, 220));
        jPanel2.setLayout(new java.awt.GridBagLayout());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(campoTelefone, javax.swing.GroupLayout.DEFAULT_SIZE, 1043, Short.MAX_VALUE)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(122, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        LoginCliente_back telaLogin = new LoginCliente_back();
        telaLogin.setVisible(true);
        this.dispose(); // Fecha a tela atual
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void campoNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoNomeActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // 1. Dados preenchidos nos campos
        String nome = campoNome.getText();
        String email = campoEmail.getText();
        String telefone = campoTelefone1.getText();
        String cep = campoCEP.getText();
        String numero = campoNumResidencia.getText();
        String senha = campoSenha.getText();
        String confirmaSenha = campoConfirmaSenha.getText();

        // 2. Verificar campos vazios
        if (nome.trim().isEmpty() || email.trim().isEmpty() || telefone.trim().isEmpty() ||
            cep.trim().isEmpty() || numero.trim().isEmpty() || senha.trim().isEmpty() || confirmaSenha.trim().isEmpty()) {

            JOptionPane.showMessageDialog(null, "Por favor, preencha todos os campos!", "Campos obrigatórios", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // 3. Verificar se senha e confirmação coincidem
        if (!senha.equals(confirmaSenha)) {
            JOptionPane.showMessageDialog(null, "As senhas não coincidem!", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // 4. Verificar se o e-mail já está em uso
        if (BancoUsuarios.buscarPorEmail(email) != null) {
            JOptionPane.showMessageDialog(null, "E-mail indisponível", "Erro", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // 5. Criar e salvar cliente
        Cliente novo = new Cliente(nome, email, telefone, cep, senha, numero);
        BancoUsuarios.listaUsuarios.add(novo);

        // 6. Mensagem e redirecionamento
        JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso!");
        LoginCliente_back telaLogin = new LoginCliente_back();
        telaLogin.setVisible(true);
        this.dispose(); // Fecha a tela de cadastro
    }//GEN-LAST:event_jButton5ActionPerformed

    private void campoEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoEmailActionPerformed

    private void campoSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoSenhaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoSenhaActionPerformed

    private void campoTelefone1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoTelefone1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoTelefone1ActionPerformed

    private void campoCPFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoCPFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoCPFActionPerformed

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
        java.awt.EventQueue.invokeLater(() -> new CadastroCliente_back().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFormattedTextField campoCEP;
    private javax.swing.JFormattedTextField campoCPF;
    private javax.swing.JPasswordField campoConfirmaSenha;
    private javax.swing.JTextField campoEmail;
    private javax.swing.JTextField campoNome;
    private javax.swing.JFormattedTextField campoNumResidencia;
    private javax.swing.JPasswordField campoSenha;
    private javax.swing.JPanel campoTelefone;
    private javax.swing.JFormattedTextField campoTelefone1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField5;
    // End of variables declaration//GEN-END:variables
}

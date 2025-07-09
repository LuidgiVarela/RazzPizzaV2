package ViewArthur;


/**
 * @author arthu
 */

import ModelArthur.Cartao;
import ModelArthur.Pagamento;

import ViewLuidgi.ConsultaHistorico;
import ViewLuidgi.ConsultaPerfilCliente_back;
import ModelLuidgi.Cliente;
import ModelLuidgi.SessaoUsuario;
<<<<<<< HEAD
=======
import ModelLuidgi.Usuario;
import ModelLuidgi.Entregador;
import ViewLuidgi.LoginCliente_back;
import ViewLuidgi.LoginEntregador;
>>>>>>> 5b14b9a3d824ada69c6630eb8ee0ac44425b72e2

import javax.swing.JTextField;
import javax.swing.JOptionPane;
import javax.swing.ButtonGroup;
import java.awt.Color;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.SwingUtilities;
<<<<<<< HEAD




=======
>>>>>>> 5b14b9a3d824ada69c6630eb8ee0ac44425b72e2
import java.awt.Window;


public class TelaCartao extends javax.swing.JFrame {
    
    private Usuario clienteLogado; 
    
    /**
     * Creates new form Cartao
     */
    public TelaCartao() {
        initComponents();
<<<<<<< HEAD

=======
         

        // Agrupamento dos botões "Sim" e "Não"
        ButtonGroup grupoSalvarCartao = new ButtonGroup();
        grupoSalvarCartao.add(jRadioButtonSim);
        grupoSalvarCartao.add(jRadioButtonNao);
        jRadioButtonSim.setSelected(true);

        //chamada do método
        configurarCampos();
        preencherCampos();
    }
    
    private void configurarCampos(){
>>>>>>> 5b14b9a3d824ada69c6630eb8ee0ac44425b72e2
        // Preenchimento automático dos campos se houver um cartão salvo como padrão
    Cartao cartaoSalvo = Cartao.getCartaoPadrao();

    if (cartaoSalvo != null) {
        jTextFieldNumeroCartao.setText(cartaoSalvo.getNumeroCartao());
        jTextFieldValidade.setText(cartaoSalvo.getValidade());
        jTextFieldCVV.setText(cartaoSalvo.getCodigoSeguranca());
        jTextFieldNomeTitular.setText(cartaoSalvo.getNomeTitular());
        jComboBoxTipoCartao.setSelectedItem(cartaoSalvo.getTipo());
    }

<<<<<<< HEAD
    // Configuração Campo Nome Titular
    jTextFieldNomeTitular.setText("Nome do Titular");
    jTextFieldNomeTitular.setForeground(Color.GRAY);
    jTextFieldNomeTitular.setHorizontalAlignment(JTextField.CENTER);
    jTextFieldNomeTitular.addFocusListener(new FocusAdapter() {
        public void focusGained(FocusEvent e) {
            if (jTextFieldNomeTitular.getText().equals("Nome do Titular")) {
                jTextFieldNomeTitular.setText("");
                jTextFieldNomeTitular.setForeground(Color.BLACK);
            }
        }

        public void focusLost(FocusEvent e) {
            if (jTextFieldNomeTitular.getText().isEmpty()) {
                jTextFieldNomeTitular.setForeground(Color.GRAY);
                jTextFieldNomeTitular.setText("Nome do Titular");
            }
        }
    });

    jTextFieldNomeTitular.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyTyped(java.awt.event.KeyEvent evt) {
            char c = evt.getKeyChar();
            if (!Character.isLetter(c) && !Character.isWhitespace(c)) {
                evt.consume(); // bloqueia caracteres não-letras
            } else if (jTextFieldNomeTitular.getText().length() >= 30) {
                evt.consume(); // bloqueia se exceder 30 caracteres
            }
        }
    });

    // Configuração Campo Número do Cartão
    jTextFieldNumeroCartao.setText("1234 5678 9012 3456");
    jTextFieldNumeroCartao.setForeground(Color.GRAY);
    jTextFieldNumeroCartao.setHorizontalAlignment(JTextField.CENTER);
    jTextFieldNumeroCartao.addFocusListener(new FocusAdapter() {
        @Override
        public void focusGained(FocusEvent e) {
            if (jTextFieldNumeroCartao.getText().equals("1234 5678 9012 3456")) {
                jTextFieldNumeroCartao.setText("");
                jTextFieldNumeroCartao.setForeground(Color.BLACK);
            }
        }

        public void focusLost(FocusEvent e) {
            if (jTextFieldNumeroCartao.getText().isEmpty()) {
                jTextFieldNumeroCartao.setForeground(Color.GRAY);
                jTextFieldNumeroCartao.setText("1234 5678 9012 3456");
            }
        }
    });

    jTextFieldNumeroCartao.addKeyListener(new KeyAdapter() {
        @Override
        public void keyTyped(KeyEvent e) {
            String text = jTextFieldNumeroCartao.getText().replace(" ", "");
            char c = e.getKeyChar();

            // Só permite número e impede ultrapassar 16 dígitos
            if (!Character.isDigit(c) || text.length() >= 16) {
                e.consume();
                return;
            }
=======
        if (cartaoSalvo != null) {
            jTextFieldNumeroCartao.setText(cartaoSalvo.getNumeroCartao());
            jTextFieldValidade.setText(cartaoSalvo.getValidade());
            jTextFieldCVV.setText(cartaoSalvo.getCodigoSeguranca());
            jTextFieldNomeTitular.setText(cartaoSalvo.getNomeTitular());
            jComboBoxTipoCartao.setSelectedItem(cartaoSalvo.getTipo());
        }

        // Configuração Campo Nome Titular
        jTextFieldNomeTitular.setText("Nome do Titular");
        jTextFieldNomeTitular.setForeground(Color.GRAY);
        jTextFieldNomeTitular.setHorizontalAlignment(JTextField.CENTER);
        jTextFieldNomeTitular.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent e) {
                if (jTextFieldNomeTitular.getText().equals("Nome do Titular")) {
                    jTextFieldNomeTitular.setText("");
                    jTextFieldNomeTitular.setForeground(Color.BLACK);
                }
            }

            public void focusLost(FocusEvent e) {
                if (jTextFieldNomeTitular.getText().isEmpty()) {
                    jTextFieldNomeTitular.setForeground(Color.GRAY);
                    jTextFieldNomeTitular.setText("Nome do Titular");
                }
            }
        });

        jTextFieldNomeTitular.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                char c = evt.getKeyChar();
                if (!Character.isLetter(c) && !Character.isWhitespace(c)) {
                    evt.consume(); // bloqueia caracteres não-letras
                } else if (jTextFieldNomeTitular.getText().length() >= 30) {
                    evt.consume(); // bloqueia se exceder 30 caracteres
                }
            }
        });

        // Configuração Campo Número do Cartão
        jTextFieldNumeroCartao.setText("1234 5678 9012 3456");
        jTextFieldNumeroCartao.setForeground(Color.GRAY);
        jTextFieldNumeroCartao.setHorizontalAlignment(JTextField.CENTER);
        jTextFieldNumeroCartao.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (jTextFieldNumeroCartao.getText().equals("1234 5678 9012 3456")) {
                    jTextFieldNumeroCartao.setText("");
                    jTextFieldNumeroCartao.setForeground(Color.BLACK);
                }
            }

            public void focusLost(FocusEvent e) {
                if (jTextFieldNumeroCartao.getText().isEmpty()) {
                    jTextFieldNumeroCartao.setForeground(Color.GRAY);
                    jTextFieldNumeroCartao.setText("1234 5678 9012 3456");
                }
            }
        });

        jTextFieldNumeroCartao.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                String text = jTextFieldNumeroCartao.getText().replace(" ", "");
                char c = e.getKeyChar();

                // Só permite número e impede ultrapassar 16 dígitos
                if (!Character.isDigit(c) || text.length() >= 16) {
                    e.consume();
                    return;
                }
>>>>>>> 5b14b9a3d824ada69c6630eb8ee0ac44425b72e2

            // Insere espaços automaticamente
            SwingUtilities.invokeLater(() -> {
                String raw = jTextFieldNumeroCartao.getText().replace(" ", "") + c;
                StringBuilder formatted = new StringBuilder();
                for (int i = 0; i < raw.length(); i++) {
                    if (i > 0 && i % 4 == 0) {
                        formatted.append(" ");
                    }
<<<<<<< HEAD
                    formatted.append(raw.charAt(i));
=======
                    jTextFieldNumeroCartao.setText(formatted.toString());
                });

                e.consume(); // evita digitação duplicada
            }
        });

        // Configuração Campo Validade
        jTextFieldValidade.setText("MM/AA");
        jTextFieldValidade.setForeground(Color.GRAY);
        jTextFieldValidade.setHorizontalAlignment(JTextField.CENTER);
        jTextFieldValidade.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent e) {
                if (jTextFieldValidade.getText().equals("MM/AA")) {
                    jTextFieldValidade.setText("");
                    jTextFieldValidade.setForeground(Color.BLACK);
>>>>>>> 5b14b9a3d824ada69c6630eb8ee0ac44425b72e2
                }
                jTextFieldNumeroCartao.setText(formatted.toString());
            });

            e.consume(); // evita digitação duplicada
        }
    });

    // Configuração Campo Validade
    jTextFieldValidade.setText("MM/AA");
    jTextFieldValidade.setForeground(Color.GRAY);
    jTextFieldValidade.setHorizontalAlignment(JTextField.CENTER);
    jTextFieldValidade.addFocusListener(new FocusAdapter() {
        public void focusGained(FocusEvent e) {
            if (jTextFieldValidade.getText().equals("MM/AA")) {
                jTextFieldValidade.setText("");
                jTextFieldValidade.setForeground(Color.BLACK);
            }
<<<<<<< HEAD
        }

        public void focusLost(FocusEvent e) {
            if (jTextFieldValidade.getText().isEmpty()) {
                jTextFieldValidade.setForeground(Color.GRAY);
                jTextFieldValidade.setText("MM/AA");
            }
        }
    });

    jTextFieldValidade.addKeyListener(new KeyAdapter() {
        @Override
        public void keyTyped(KeyEvent e) {
            String text = jTextFieldValidade.getText().replace("/", "");
            char c = e.getKeyChar();

            // Só aceita número e máximo 4 dígitos
            if (!Character.isDigit(c) || text.length() >= 4) {
=======

            public void focusLost(FocusEvent e) {
                if (jTextFieldValidade.getText().isEmpty()) {
                    jTextFieldValidade.setForeground(Color.GRAY);
                    jTextFieldValidade.setText("MM/AA");
                }
            }
        });

        jTextFieldValidade.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                String text = jTextFieldValidade.getText().replace("/", "");
                char c = e.getKeyChar();

                // Só aceita número e máximo 4 dígitos
                if (!Character.isDigit(c) || text.length() >= 4) {
                    e.consume();
                    return;
                }

                SwingUtilities.invokeLater(() -> {
                    String raw = jTextFieldValidade.getText().replace("/", "") + c;
                    StringBuilder formatted = new StringBuilder();
                    for (int i = 0; i < raw.length(); i++) {
                        if (i == 2) {
                            formatted.append("/");
                        }
                        formatted.append(raw.charAt(i));
                    }
                    jTextFieldValidade.setText(formatted.toString());
                });

>>>>>>> 5b14b9a3d824ada69c6630eb8ee0ac44425b72e2
                e.consume();
                return;
            }
<<<<<<< HEAD

            SwingUtilities.invokeLater(() -> {
                String raw = jTextFieldValidade.getText().replace("/", "") + c;
                StringBuilder formatted = new StringBuilder();
                for (int i = 0; i < raw.length(); i++) {
                    if (i == 2) {
                        formatted.append("/");
                    }
                    formatted.append(raw.charAt(i));
=======
        });

        // Configuração Campo CVV
        jTextFieldCVV.setText("123");
        jTextFieldCVV.setForeground(Color.GRAY);
        jTextFieldCVV.setHorizontalAlignment(JTextField.CENTER);
        jTextFieldCVV.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent e) {
                if (jTextFieldCVV.getText().equals("123")) {
                    jTextFieldCVV.setText("");
                    jTextFieldCVV.setForeground(Color.BLACK);
>>>>>>> 5b14b9a3d824ada69c6630eb8ee0ac44425b72e2
                }
                jTextFieldValidade.setText(formatted.toString());
            });

            e.consume();
        }
    });

    // Configuração Campo CVV
    jTextFieldCVV.setText("123");
    jTextFieldCVV.setForeground(Color.GRAY);
    jTextFieldCVV.setHorizontalAlignment(JTextField.CENTER);
    jTextFieldCVV.addFocusListener(new FocusAdapter() {
        public void focusGained(FocusEvent e) {
            if (jTextFieldCVV.getText().equals("123")) {
                jTextFieldCVV.setText("");
                jTextFieldCVV.setForeground(Color.BLACK);
            }
<<<<<<< HEAD
        }

        public void focusLost(FocusEvent e) {
            if (jTextFieldCVV.getText().isEmpty()) {
                jTextFieldCVV.setForeground(Color.GRAY);
                jTextFieldCVV.setText("123");
            }
        }
    });
=======

            public void focusLost(FocusEvent e) {
                if (jTextFieldCVV.getText().isEmpty()) {
                    jTextFieldCVV.setForeground(Color.GRAY);
                    jTextFieldCVV.setText("123");
                }
            }
        });

        jTextFieldCVV.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                char c = evt.getKeyChar();
                String text = jTextFieldCVV.getText();
>>>>>>> 5b14b9a3d824ada69c6630eb8ee0ac44425b72e2

    jTextFieldCVV.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyTyped(java.awt.event.KeyEvent evt) {
            char c = evt.getKeyChar();
            String text = jTextFieldCVV.getText();

            if (!Character.isDigit(c) || text.length() >= 3) {
                evt.consume(); // só permite números e até 3 dígitos
            }
<<<<<<< HEAD
        }
    });

    // Agrupamento dos botões "Sim" e "Não"
    ButtonGroup grupoSalvarCartao = new ButtonGroup();
    grupoSalvarCartao.add(jRadioButtonSim);
    grupoSalvarCartao.add(jRadioButtonNao);
    jRadioButtonSim.setSelected(true);
    
    //chamada do método
    preencherCampos();

    }
    
    private void preencherCampos() {
        Cartao cartaoSalvo = Cartao.getCartaoPadrao();

        if (cartaoSalvo != null) {
            jTextFieldNumeroCartao.setText(cartaoSalvo.getNumeroCartao());
            jTextFieldValidade.setText(cartaoSalvo.getValidade());
            jTextFieldCVV.setText(cartaoSalvo.getCodigoSeguranca());
            jTextFieldNomeTitular.setText(cartaoSalvo.getNomeTitular());
            jComboBoxTipoCartao.setSelectedItem(cartaoSalvo.getTipo());
        }
    }

   

    public void setUsuarioLogado(Usuario usuario) {
        String nomeCompleto = usuario.getNome();
        String nomeCurto = nomeCompleto.length() > 18 ? nomeCompleto.substring(0, 18) + "..." : nomeCompleto;
=======
        });
    }
    
    
    
    private void preencherCampos() {
        Cartao cartaoSalvo = Cartao.getCartaoPadrao();
>>>>>>> 5b14b9a3d824ada69c6630eb8ee0ac44425b72e2

        if (cartaoSalvo != null) {
            jTextFieldNumeroCartao.setText(cartaoSalvo.getNumeroCartao());
            jTextFieldValidade.setText(cartaoSalvo.getValidade());
            jTextFieldCVV.setText(cartaoSalvo.getCodigoSeguranca());
            jTextFieldNomeTitular.setText(cartaoSalvo.getNomeTitular());
            jComboBoxTipoCartao.setSelectedItem(cartaoSalvo.getTipo());
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
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jButtonConfirmarPagamento = new javax.swing.JButton();
        jButtonVoltar = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jComboBoxTipoCartao = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        jRadioButtonSim = new javax.swing.JRadioButton();
        jRadioButtonNao = new javax.swing.JRadioButton();
        jLabel12 = new javax.swing.JLabel();
        jTextFieldCVV = new javax.swing.JTextField();
        jTextFieldNomeTitular = new javax.swing.JTextField();
        jTextFieldNumeroCartao = new javax.swing.JTextField();
        jTextFieldValidade = new javax.swing.JTextField();

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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 444, Short.MAX_VALUE)
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
        jLabel1.setText("💳 Pagamento com Cartão");

        jLabel7.setFont(new java.awt.Font("Segoe UI Emoji", 0, 24)); // NOI18N
        jLabel7.setText("Número do cartão:");

        jLabel8.setFont(new java.awt.Font("Segoe UI Emoji", 0, 24)); // NOI18N
        jLabel8.setText("Código de Segurança:");

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

        jLabel9.setFont(new java.awt.Font("Segoe UI Emoji", 0, 24)); // NOI18N
        jLabel9.setText(" Validade (MM/AA):");

        jLabel10.setFont(new java.awt.Font("Segoe UI Emoji", 0, 24)); // NOI18N
        jLabel10.setText("Tipo:");

        jComboBoxTipoCartao.setBackground(new java.awt.Color(255, 248, 220));
        jComboBoxTipoCartao.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione...", "Débito\t", "Crédito" }));
        jComboBoxTipoCartao.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(123, 63, 0), 3));
        jComboBoxTipoCartao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxTipoCartaoActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Segoe UI Emoji", 0, 24)); // NOI18N
        jLabel11.setText("Deseja salvar esse cartão como padrão?");

        jRadioButtonSim.setText("Sim");
        jRadioButtonSim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonSimActionPerformed(evt);
            }
        });

        jRadioButtonNao.setText("Não");
        jRadioButtonNao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonNaoActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Segoe UI Emoji", 0, 24)); // NOI18N
        jLabel12.setText("Nome do Titular");

        jTextFieldCVV.setBackground(new java.awt.Color(255, 248, 220));
        jTextFieldCVV.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(123, 63, 0), 3, true));
        jTextFieldCVV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldCVVActionPerformed(evt);
            }
        });

        jTextFieldNomeTitular.setBackground(new java.awt.Color(255, 248, 220));
        jTextFieldNomeTitular.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(123, 63, 0), 3, true));
        jTextFieldNomeTitular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNomeTitularActionPerformed(evt);
            }
        });

        jTextFieldNumeroCartao.setBackground(new java.awt.Color(255, 248, 220));
        jTextFieldNumeroCartao.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(123, 63, 0), 3, true));
        jTextFieldNumeroCartao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNumeroCartaoActionPerformed(evt);
            }
        });

        jTextFieldValidade.setBackground(new java.awt.Color(255, 248, 220));
        jTextFieldValidade.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(123, 63, 0), 3, true));
        jTextFieldValidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldValidadeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(88, 88, 88)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 882, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel8)
                                .addComponent(jLabel7))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addGap(34, 34, 34)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jButtonConfirmarPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButtonVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 393, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel12)
                                    .addComponent(jLabel10))
                                .addGap(97, 97, 97)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jComboBoxTipoCartao, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(jTextFieldCVV)
                                    .addComponent(jTextFieldNomeTitular, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jTextFieldNumeroCartao)
                                    .addComponent(jTextFieldValidade))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel11)
                                        .addGap(23, 23, 23))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(68, 68, 68)
                                        .addComponent(jRadioButtonSim)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jRadioButtonNao)
                                        .addGap(123, 123, 123))))))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jRadioButtonSim)
                            .addComponent(jRadioButtonNao))
                        .addGap(86, 86, 86))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(143, 143, 143)
                        .addComponent(jLabel1)
                        .addGap(73, 73, 73)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(jComboBoxTipoCartao, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(jTextFieldNomeTitular, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(46, 46, 46)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jTextFieldNumeroCartao, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jTextFieldValidade, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jTextFieldCVV, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(69, 69, 69)
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
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
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

    private void jButtonConsultarHistoricoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConsultarHistoricoActionPerformed
        // TODO add your handling code here:
        
        ConsultaHistorico telaHistorico = new ConsultaHistorico();
        telaHistorico.setVisible(true);
        this.dispose(); // Fecha a tela atual
        
    }//GEN-LAST:event_jButtonConsultarHistoricoActionPerformed

    private void jButtonConfirmarPagamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConfirmarPagamentoActionPerformed
<<<<<<< HEAD
        
=======
>>>>>>> 5b14b9a3d824ada69c6630eb8ee0ac44425b72e2
        //Captura os dados dos campos
        String numero = jTextFieldNumeroCartao.getText().replaceAll("[_\\s]", "");
        String validade = jTextFieldValidade.getText().replaceAll("[_\\s]", "");
        String cvv = jTextFieldCVV.getText().replaceAll("[_\\s]", "");
        String nomeTitular = jTextFieldNomeTitular.getText().trim();
        Object tipoSelecionado = jComboBoxTipoCartao.getSelectedItem();

       //️ Validação dos campos
        if (numero.equals("1234 5678 9012 3456") || numero.length() < 16 ||
        validade.equals("MM/AA") || validade.length() < 4 ||
        cvv.equals("123") || cvv.length() < 3 ||
        nomeTitular.equals("Nome do Titular") || nomeTitular.isEmpty() ||
        tipoSelecionado == null || tipoSelecionado.equals("Selecione...")) {
                JOptionPane.showMessageDialog(
                this,
                "Preencha todos os campos do cartão!",
                "Erro",
                JOptionPane.ERROR_MESSAGE
            );
            return;
        }
        


        // Realiza o pagamento fictício
        Pagamento pagamento = new Cartao(100.0); // Valor de exemplo
        pagamento.confirmarPagamento();         // Apenas mostra o JOptionPane
       

        // Se o usuário optou por salvar o cartão como padrão
        if (jRadioButtonSim.isSelected()) {
            Cartao cartao = new Cartao();
            cartao.setNumeroCartao(jTextFieldNumeroCartao.getText());
            cartao.setValidade(jTextFieldValidade.getText());
            cartao.setCodigoSeguranca(jTextFieldCVV.getText());
            cartao.setTipo((String) jComboBoxTipoCartao.getSelectedItem());
            cartao.setNomeTitular(jTextFieldNomeTitular.getText());

            // Salva o cartão no cliente logado
            Cliente clienteLogado = (Cliente) SessaoUsuario.getInstancia().getUsuarioLogado();
            clienteLogado.setCartaoSalvo(cartao);
        }

        //Encaminha para a tela de avaliação
        Cliente cliente = (Cliente) SessaoUsuario.getInstancia().getUsuarioLogado();
        TelaAvaliacao avaliacao = new TelaAvaliacao(cliente);
        avaliacao.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButtonConfirmarPagamentoActionPerformed

    private void jButtonVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVoltarActionPerformed
        // TODO add your handling code here:
        TelaPagamento pagamento = new TelaPagamento();
        pagamento.setVisible(true);
        this.dispose(); // Fecha a tela atual (TelaCartao)

    }//GEN-LAST:event_jButtonVoltarActionPerformed

    private void jComboBoxTipoCartaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxTipoCartaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxTipoCartaoActionPerformed

    private void jRadioButtonSimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonSimActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButtonSimActionPerformed

    private void jTextFieldCVVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldCVVActionPerformed
        // TODO add your handling code here:

        
    }//GEN-LAST:event_jTextFieldCVVActionPerformed

    private void jTextFieldNomeTitularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNomeTitularActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldNomeTitularActionPerformed

    private void jTextFieldNumeroCartaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNumeroCartaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldNumeroCartaoActionPerformed

    private void jTextFieldValidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldValidadeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldValidadeActionPerformed

    private void jRadioButtonNaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonNaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButtonNaoActionPerformed

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
            java.util.logging.Logger.getLogger(TelaCartao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaCartao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaCartao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaCartao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaCartao().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButtonConfirmarPagamento;
    private javax.swing.JButton jButtonConsultarHistorico;
    private javax.swing.JButton jButtonConsultarPerfil;
    private javax.swing.JButton jButtonInicio;
    private javax.swing.JButton jButtonSair;
    private javax.swing.JButton jButtonVoltar;
    private javax.swing.JComboBox<String> jComboBoxTipoCartao;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JRadioButton jRadioButtonNao;
    private javax.swing.JRadioButton jRadioButtonSim;
    private javax.swing.JTextField jTextFieldCVV;
    private javax.swing.JTextField jTextFieldNomeTitular;
    private javax.swing.JTextField jTextFieldNumeroCartao;
    private javax.swing.JTextField jTextFieldValidade;
    private javax.swing.JLabel labelUsuarioLogado;
    // End of variables declaration//GEN-END:variables
}

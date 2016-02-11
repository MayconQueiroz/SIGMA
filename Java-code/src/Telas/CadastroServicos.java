/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Telas;

import Controles.CadastroSControle;
import Entidades.Servico;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

/**
 * 29/11/15 - Juliano Felipe
 * Inserção incial de campos.
 */

/**
 *
 * @author Maycon
 */
public class CadastroServicos extends javax.swing.JFrame {

    public TelaPrincipal telaanterior;
    public int metodo;
    private String title;
    private int serviceId=-1;

    /**
     * 05/12 - Maycon
     * Creates new form TelaServicos
     */
    private CadastroServicos() {
        initComponents();
        initNoicon ();
        
        //Seta janela para o meio da tela, independente da resolução.
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        
        title = this.getTitle(); //Pega o título do frame
    }
    
    /**
    * 12/12/15 - Juliano Felipe
    * Seta icone 1*1px (para "remover" icone default)
    */
    private void initNoicon (){
        Image No_ico = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB_PRE);
        this.setIconImage(No_ico);
    }

    /**
    * 03/02/16 - Juliano Felipe
    * "Pseudo-construtor", chama o construtor padrão, função de reutilização de jFrame e salva
    * a instância do jFrame que chamou este (para poder habilitá-lo quando esta tela é fechada.
    * @param telanterior - Instância da tela anterior. 
    * @param option - Modo que o jFrame será utilizado (1 para Cadastro, 2 para consulta, etc).
    */
    public CadastroServicos(TelaPrincipal telanterior, int option) {
        //Chamar construtor
        this();
        this.telaanterior = telanterior;
        metodo = option;
        IDField.setEditable(false);
        if (option > 1)
            metodosServicos (option);
    }
    
    /**
     * 06/01/16 - Juliano Felipe Define metodos sobre a janela servicos,
     * reutilizando a mesma Variavel op chama o respectivo metodo
     * @param op - Opção de reutilização
     * 1 - Cadastro (esse método não é chamado, devido a condição de chamada no construtor modificado);
     * 2 - Consulta;
     * 3 - Modificação;
     * 4 - Exclusão;
     */
    public void metodosServicos (int op){
        if (op>=2){//Op==2 - Consulta
           this.setTitle("Consulta de serviços"); 
           jFormattedTextField2.setEditable(false);
           KMField.setEditable(false);
           jCheckBox1.setEnabled(false);
           jTextPane1.setEnabled(false);
           ClienteField.setEnabled(false);
           jButton1.setText("Consultar");
        }
        if (op==3){//Op==3 - Modificar
           this.setTitle("Modificação de serviços");       
        }
        if (op==4){//Op==4 - Excluir
           this.setTitle("Exclusão de serviços");       
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

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jFormattedTextField1 = new javax.swing.JFormattedTextField();
        jPanel3 = new javax.swing.JPanel();
        KMField = new javax.swing.JFormattedTextField();
        jPanel4 = new javax.swing.JPanel();
        jFormattedTextField2 = new javax.swing.JFormattedTextField();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        jPanel1 = new javax.swing.JPanel();
        jCheckBox1 = new javax.swing.JCheckBox();
        ClientePanel = new javax.swing.JPanel();
        ClienteField = new javax.swing.JTextField();
        ConsultarCliente = new javax.swing.JButton();
        IDField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de serviços");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jButton1.setText("Salvar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Cancelar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Placa"));

        try {
            jFormattedTextField1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("UUU####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jFormattedTextField1.setToolTipText("");
        jFormattedTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFormattedTextField1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jFormattedTextField1)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jFormattedTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Quilometragem"));

        KMField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,###.000"))));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(KMField, javax.swing.GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(KMField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Modelo"));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jFormattedTextField2, javax.swing.GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jFormattedTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Observações"));

        jScrollPane1.setViewportView(jTextPane1);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Situação"));

        jCheckBox1.setText("Concluído");
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jCheckBox1)
                .addContainerGap(19, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jCheckBox1))
        );

        ClientePanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 51, 51)), "Cliente"));

        ConsultarCliente.setText("Consultar");
        ConsultarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConsultarClienteActionPerformed(evt);
            }
        });

        jLabel1.setText("ID");

        javax.swing.GroupLayout ClientePanelLayout = new javax.swing.GroupLayout(ClientePanel);
        ClientePanel.setLayout(ClientePanelLayout);
        ClientePanelLayout.setHorizontalGroup(
            ClientePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ClientePanelLayout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(IDField, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ClienteField)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ConsultarCliente))
        );
        ClientePanelLayout.setVerticalGroup(
            ClientePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(ClientePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(ConsultarCliente)
                .addComponent(ClienteField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(IDField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel1))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ClientePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ClientePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton1))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jFormattedTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFormattedTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jFormattedTextField1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        //Botão Cancelar pressionado
        this.dispose();
        telaanterior.setEnabled(true);
        telaanterior.requestFocus(); //Traz o foco para tela anterior
    }//GEN-LAST:event_jButton2ActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        /**
         * 05/12 - Maycon
         * Tela fechada
         */
        telaanterior.setEnabled(true);
        telaanterior.requestFocus(); //Traz o foco para tela anterior
    }//GEN-LAST:event_formWindowClosed

    /**
     * 09/02/16 - Juliano Felipe
     * Função para inserção de serviços no banco de dados
     * @param idCliente - Id do cliente para qual o serviço será prestado
     * @param placa do veículo
     * @param modelo do veículo
     * @param km do veículo no momento de início do serviço
     * @param situacao do serviço (Concluído=true; não concluido=false)
     * @param obs a respeito do serviço
     */
    private void insertService(int idCliente, String placa, String modelo, int km, boolean situacao, String obs){
        
    }
    
    /**
     * 09/02/16 - Juliano Felipe
     * Função para consulta de serviços no banco de dados.
     * @param placa do veículo (Consulta por placa).
     * @return id do serviço pesquisado.
     */
    private int selectService (String placa){
        this.setEnabled(false);
        String []columnNames = {"rowid","Placa","Quilometragem","Modelo","Situacao","Nome do Cliente","Idcliente","Obs"};
        MultipleTable MServiceTable = new MultipleTable (this, columnNames, placa);
        MServiceTable.setVisible(true);
        
        //Gets
        //String fullname = MServiceTable.getNomeCliente();
        int rowidService = MServiceTable.getIdservico();
        Object[] selRow = MServiceTable.getRowdata();
        
        MServiceTable.parafechar.dispose();
        
        jFormattedTextField1.setText(selRow[1].toString());
        KMField.setText(selRow[2].toString());
        jFormattedTextField2.setText(selRow[3].toString());
        
        String tmp = selRow[4].toString();
        if (tmp.equals("true")){
            jCheckBox1.setSelected(true);
        } else if (tmp.equals("false")){
            jCheckBox1.setSelected(false);
        }
        
        ClienteField.setText(selRow[5].toString());
        IDField.setText(selRow[6].toString());
        jTextPane1.setText(selRow[7].toString());
        
        
        return rowidService;
    }
    
    /**
     * 09/02/16 - Juliano Felipe
     * Função para atualizar dados do serviço no banco de dados.
     * @param idCliente - Id do cliente para qual o serviço será prestado
     * @param placa do veículo
     * @param modelo do veículo
     * @param km do veículo no momento de início do serviço
     * @param situacao do serviço (Concluído=true; não concluido=false)
     * @param obs a respeito do serviço
     */
    private void updateService (int idCliente, String placa, String modelo, int km, boolean situacao, String obs){
         
        //return;
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        /**
         * 03/02/16 - Juliano
         * Definido a opcao 2 (consultar), altera-se a funcao do botao salvar
         */
        if (metodo == 2) {
            //Id (no retorno) não é necessário.
            selectService (jFormattedTextField1.getText()); //Consulta por PLACA
            return; //Somente consulta, nao necessario salvar dados
        }

        if (metodo == 3) {
            String flag = jButton1.getText();
            //int serviceId=-1; //Is this necessary?
            if (!flag.equals("Modificar")){
                serviceId = selectService (jFormattedTextField1.getText());
                if (serviceId==-1){
                    JOptionPane.showMessageDialog(this, "Erro. Código: 04-04-XX.", title, JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }else{ //Ainda não alterei aqui, apenas alterei o protótipo da função. (Quem fazer, cuidado com os "parseInt" e companhia).             
                int id = Integer.parseInt(IDField.getText());
                int km = Integer.parseInt(KMField.getText());
                updateService (id, jFormattedTextField1.getText(), jFormattedTextField2.getText(), km, jCheckBox1.isSelected(), jTextPane1.getText());
                
                //jButton1.setEnabled(false); //Para não tentar salvar novamente
                metodosServicos(3); //Resetar modificação
                return;
            }
            KMField.setEditable(true); //Todos os fields podem ser alterados novamente
            jFormattedTextField2.setEditable(true);
            jCheckBox1.setEnabled(true);
            ClienteField.setEditable(true);
            jTextPane1.setEnabled(true);
            jButton1.setText("Modificar");
            return;
        }
        
        if (metodo==4){
            //Display de dados
            jFormattedTextField1.setText("ABCDEFG");
            KMField.setText("150000");
            jFormattedTextField2.setText("WOLKSVAGEN GOL");
            jCheckBox1.setSelected(true);
            jTextPane1.setText("Teste");
            jButton1.setText("Excluir"); 
            jFormattedTextField1.setEditable(false);
            return;
        }
        
        /**
         * 04/01 - Maycon
         * Botão salvar pressionado
         * FALTA Colocar área para selecao do cliente selecionado
         */
        //Botão Salvar pressionado
        String placa = jFormattedTextField1.getText();
        String modelo = jFormattedTextField2.getText();
        String KM = KMField.getText();
        String obs = jTextPane1.getText();
        boolean sit = jCheckBox1.isSelected();  //Outro método para que true seja para "checked" no concluído
        String txtId = IDField.getText();
        
        int km=0, idc=-1;
        try {
            km = Integer.parseInt(KM);
            idc = Integer.parseInt(txtId);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro. Código: 04-04-01.", title, JOptionPane.ERROR_MESSAGE);
            System.err.println(e.getClass().getName() + ": " + e.getMessage());            return;
        }
        
        Servico N = new Servico(idc, placa, modelo, km, sit, obs);
        //Chama o controle para cadastrar
        CadastroSControle C = new CadastroSControle();
        if (C.cadastrarservico(N)) {
            JOptionPane.showMessageDialog(this, "Cadastrado com sucesso");
            //insertService(idc, placa, modelo, km, sit, obs);
            this.dispose();
            telaanterior.setEnabled(true);
            telaanterior.requestFocus(); //Traz o foco para tela anterior
        } else {
            JOptionPane.showMessageDialog(this, "Erro. Código: 04-04-02.", title, JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    /**
    * 06/02/16 - Juliano Felipe 
    * Método para alterar a cor do "Painel de Consulta".
    * Coloca uma borda igual a padrão, no entando, altera-se a cor.
    * 
    * @param cor para pintar a borda.
    */
    private void PanelColor (Color cor){
        Border line = BorderFactory.createLineBorder(cor);
        TitledBorder Brdr = BorderFactory.createTitledBorder(line,"Cliente");
        Brdr.setTitleJustification(TitledBorder.LEFT);
        Brdr.setTitlePosition(TitledBorder.TOP);
        ClientePanel.setBorder (Brdr);
    }
    
    private void ConsultarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConsultarClienteActionPerformed
        String fname = ClienteField.getText();
        if (fname.isEmpty() || fname.charAt(0)==' '){ //Vazio ou começa com espaço
            JOptionPane.showMessageDialog(this, "Campo de cliente vazio ou iniciando por espaço. Código: 04-04-03.", title, JOptionPane.WARNING_MESSAGE);
            return;
        }
                
        this.setEnabled(false);
        MultipleEntries multipleEntries = new MultipleEntries(this, fname);
        multipleEntries.setVisible(true);
        
        String nome = multipleEntries.getString();
        int rowid = multipleEntries.getId();
        
        multipleEntries.parafechar.dispose();
        
        IDField.setText("" + rowid); //Gambiarra de transformação de int para String
        ClienteField.setText(nome);
        
        if (rowid>0) //Retornou um id existente
            PanelColor (Color.GREEN);
    }//GEN-LAST:event_ConsultarClienteActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Windows look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Windows (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CadastroServicos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastroServicos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastroServicos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastroServicos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastroServicos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField ClienteField;
    private javax.swing.JPanel ClientePanel;
    private javax.swing.JButton ConsultarCliente;
    private javax.swing.JTextField IDField;
    private javax.swing.JFormattedTextField KMField;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JFormattedTextField jFormattedTextField1;
    private javax.swing.JFormattedTextField jFormattedTextField2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextPane jTextPane1;
    // End of variables declaration//GEN-END:variables
}

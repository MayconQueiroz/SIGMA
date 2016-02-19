/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Telas;

import ConecBD.ConexaoBanco;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.DefaultListModel;
import java.util.ArrayList;
import java.util.List;

/**
 * Tela de multiplas entradas voltada para apresentação de vários nomes de clientes
 * @author Juliano Felipe
 */
public class MultipleEntries extends javax.swing.JDialog {
    public CadastroCliente telaanterior;
    public CadastroServicos anteriorServico;
    public MultipleEntries parafechar;
    int what_close;
    
    String title=null;
    String ret=null;
    int id=-1;
    List<Integer> ids = new ArrayList<>();
    boolean flag=false;
    
    /**
     * Creates new form MultipleEntries
     */
    public MultipleEntries() {
        setModal(true); //Deve ser modal para que o programa "espere a seleção na lista".
        
        initComponents();
        
        //Seta janela para o meio da tela, independente da resolução.
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        
        initNoicon();  //Seta "Logo vazio".
    }
    
    /**
     * 30/01/16 - Juliano Felipe Seta icone 1*1px (para "remover" icone default)
     */
    private void initNoicon() {
        Image No_ico = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB_PRE);
        this.setIconImage(No_ico);
        title = this.getTitle(); //Pega título do frame
    }
    
    /**
     * 30/01/16 - Juliano Felipe 
     * Construtor para ser executado quando chamado do método de clientes
     * @param telanterior Instância de tela para restauração.
     * @param fname Primeiro nome do cliente, a ser pesquisado no banco de dados
     */
    public MultipleEntries(CadastroCliente telanterior, String fname) {
        //Chamar construtor
        this();
        this.telaanterior = telanterior;
        FillList(1, fname); //1 = Cliente
        what_close = 1;
    }
    
    /**
     * 07/02/16 - Juliano Felipe 
     * Construtor para ser executado quando chamado do método de servicos
     * @param telanterior Instância de tela para restauração.
     * @param fname Primeiro nome do cliente, a ser pesquisado no banco de dados
     */
    public MultipleEntries(CadastroServicos telanterior, String fname) {
        //Chamar construtor
        this();
        this.anteriorServico = telanterior;
        FillList(1, fname); //1 = Cliente
        what_close = 2;
    }

    /**
     * 31/01/16 - Juliano Felipe 
     * Função para tornar String selecionada acessível
     * @return ret String selecionada na lista
     */
    public String getString (){
        if (flag)
           return ret;
        else
            return null;
    }
    
    /**
     * 31/01/16 - Juliano Felipe 
     * Função para tornar id acessível
     * @return id Id associado à string selecionada na lista
     */
    public int getId (){
        if (flag)
           return id;
        else
            return -1;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jList = new javax.swing.JList();
        SelectButton = new javax.swing.JButton();
        CancelButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Seleção de múltiplas entradas");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jScrollPane1.setViewportView(jList);

        SelectButton.setText("Selecionar");
        SelectButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SelectButtonActionPerformed(evt);
            }
        });

        CancelButton.setText("Cancelar");
        CancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(SelectButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 200, Short.MAX_VALUE)
                        .addComponent(CancelButton)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SelectButton)
                    .addComponent(CancelButton))
                .addContainerGap())
        );

        getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * 30/01/16 - Juliano Felipe 
     * Função para consultar dados 
     * @param what_is Indica qual banco de dados pesquisar.
     * @param ToFill String para usar na consulta.
     * 1 - Clientes;
     */
    private void FillList (int what_is, String ToFill){      
        String[] splitname = ToFill.split(" ",2);     //split by spaces
        ToFill = splitname[0]; // Para garantir que sempre pega o primeiro nome        
        
        if (what_is==1){
            Connection concliente = ConexaoBanco.concliente();
            try {
                DefaultListModel model = new DefaultListModel(); //create a new list model
                String sql2 = "SELECT rowid, * FROM cliente WHERE nome=?";
                PreparedStatement pst = concliente.prepareStatement(sql2);
                pst.setString(1, ToFill);
                ResultSet rs = pst.executeQuery();
                while (rs.next())
                {
                    ids.add(rs.getInt("rowid")); 
                    String names = ToFill + " " + rs.getString("lname"); //O primeiro nome é o mesmo, então só resgata o "resto" e o concatena.
                    model.addElement(names); //adiciona os itens para o modelo
                }
                jList.setModel(model);

                rs.close();
                pst.close();
                concliente.close();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Erro. Código: 04-06-01.", title, JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    /**
     * 07/02/16 - Juliano Felipe 
     * Método para fechar esta janela e retornar para a anterior, de acordo
     * com qual janela a chamou.
     * @param lastDoubleCode Ultimo parte de dois dígitos para código
     * de erros. Estes últimos dois dígitos indicam de onde foi chamado o método.
     */
    private void Closing (String lastDoubleCode){
        switch (what_close){
            case 1:
                telaanterior.setEnabled(true);
                telaanterior.requestFocus(); //Traz o foco para tela anterior
                break;
            case 2:
                anteriorServico.setEnabled(true);
                anteriorServico.requestFocus(); //Traz o foco para tela anterior
                break;
            default:
                JOptionPane.showMessageDialog(this, "Erro ao fechar e retornar para a janela anterior./nCódigo: 04-06-" + lastDoubleCode + ".", title, JOptionPane.ERROR_MESSAGE);
                //Erro 04-06-02   -   Dispose no botão Cancel
                //Erro 04-06-03   -   Dispose no "formWindowClosed"
                //Erro 04-06-04   -   Dispose no botão Select
        }
    }
    
    private void CancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelButtonActionPerformed
        this.dispose();
        Closing ("02");
    }//GEN-LAST:event_CancelButtonActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        this.dispose();
        Closing ("03");
    }//GEN-LAST:event_formWindowClosed
    
    private void SelectButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SelectButtonActionPerformed
        //Seleciona-se um item da lista
        Object retorno = jList.getSelectedValue(); //Pega o valor selecionado no "jList"
        int index = jList.getSelectedIndex(); //Pega o id da posição selecionada
        ret = retorno.toString(); //Transforma objeto em string
        id = ids.get(index); //Pega o id do cliente conforme o index da "jList"
                
        parafechar=this; //Para salvar a instância desta tela
        this.setVisible(false); //Apenas esconde a tela para acessar as variáveis nas outras telas
        
        Closing ("04");
        
        flag=true; //Seta para verdadeiro para saber que nos métodos "get" é o valor real
    }//GEN-LAST:event_SelectButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Windows look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
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
            java.util.logging.Logger.getLogger(MultipleEntries.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MultipleEntries.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MultipleEntries.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MultipleEntries.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MultipleEntries().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CancelButton;
    private javax.swing.JButton SelectButton;
    private javax.swing.JList jList;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}

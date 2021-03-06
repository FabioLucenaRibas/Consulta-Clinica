/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apresentacao;

import classebasica.Especialidade;
import negocios.NegocioRegistroEspecialidade;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author MegaKingBR
 */
public class RegistroEspecialidade extends javax.swing.JFrame {
Especialidade e = new Especialidade();
NegocioRegistroEspecialidade nre = new NegocioRegistroEspecialidade();
    /**
     * Creates new form RegistroEspecialidade
     */
    public RegistroEspecialidade() {
        initComponents();
        jTextFieldCodEspecialidade.setDocument(new classebasica.NumerosPermitidos());
        jTextFieldNomeEspecialidade.setDocument(new classebasica.LetrasPermitidas());
    }
    private void listar() {
        try {
            // TODO add your handling code here:
            ArrayList<Especialidade> lista = nre.ListarEspecialidade();
            DefaultTableModel modelo = new DefaultTableModel();
            modelo.setColumnIdentifiers(new String[]{"Codigo Especialidade", "Nome Especialidade"});
            for (Especialidade e : lista) {
                modelo.addRow(new String[]{e.getCodEspecialidade() + "", e.getNomeEspecialidade()});
            }
            jTableTabelaEspecialidade.setModel(modelo);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage());
        }
    } 
private void LimparTela() {
          //Botao limpar
        jTextFieldCodEspecialidade.setText("");
        jTextFieldNomeEspecialidade.setText("");
        jTextFieldRemoverEspecialidade.setText("");

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
        jTableTabelaEspecialidade = new javax.swing.JTable();
        jButtonOKEspecialidade = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButtonListarEspecialidade = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jButtonRemoverPlano = new javax.swing.JButton();
        jTextFieldRemoverEspecialidade = new javax.swing.JTextField();
        jTextFieldNomeEspecialidade = new javax.swing.JTextField();
        jTextFieldCodEspecialidade = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Registro Especialidade");

        jTableTabelaEspecialidade.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        listar();
        jScrollPane1.setViewportView(jTableTabelaEspecialidade);

        jButtonOKEspecialidade.setText("OK");
        jButtonOKEspecialidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonOKEspecialidadeActionPerformed(evt);
            }
        });

        jLabel1.setText("Codigo da Especialidade:");

        jLabel2.setText("Nome da Especialidade:");

        jButtonListarEspecialidade.setText("Atualizar Listagem");
        jButtonListarEspecialidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonListarEspecialidadeActionPerformed(evt);
            }
        });

        jLabel3.setText("Para remover o  Especialidade insira o codido:");

        jButtonRemoverPlano.setText("Remover");
        jButtonRemoverPlano.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRemoverPlanoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldRemoverEspecialidade, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonRemoverPlano, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldNomeEspecialidade)
                            .addComponent(jTextFieldCodEspecialidade))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButtonListarEspecialidade, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonOKEspecialidade, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(9, 9, 9))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1)
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(26, 26, 26))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonOKEspecialidade)
                            .addComponent(jTextFieldCodEspecialidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonListarEspecialidade)
                            .addComponent(jTextFieldNomeEspecialidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(29, 29, 29)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonRemoverPlano)
                    .addComponent(jLabel3)
                    .addComponent(jTextFieldRemoverEspecialidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void jButtonListarEspecialidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonListarEspecialidadeActionPerformed
      listar();  // TODO add your handling code here:
    }//GEN-LAST:event_jButtonListarEspecialidadeActionPerformed

    private void jButtonOKEspecialidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonOKEspecialidadeActionPerformed
            try {        
        e.setNomeEspecialidade(jTextFieldNomeEspecialidade.getText());
        e.setCodEspecialidade (jTextFieldCodEspecialidade.getText());
        nre.cadastrar(e); 
        LimparTela();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage());
        }        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonOKEspecialidadeActionPerformed

    private void jButtonRemoverPlanoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRemoverPlanoActionPerformed
        try {
        int resp = JOptionPane.showConfirmDialog(null, "Voce deseja remover a Especialidade?", "Remover Especialidade", JOptionPane.YES_NO_OPTION);
        if (resp == JOptionPane.YES_OPTION) {
        e.setCodEspecialidade (jTextFieldRemoverEspecialidade.getText());
        nre.remover(e);
        LimparTela();
        listar();
        jTextFieldRemoverEspecialidade.setText("");
    }
    } catch (Exception ex) {
        JOptionPane.showMessageDialog(rootPane, ex.getMessage());
    }
    }//GEN-LAST:event_jButtonRemoverPlanoActionPerformed

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
            java.util.logging.Logger.getLogger(RegistroEspecialidade.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistroEspecialidade.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistroEspecialidade.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistroEspecialidade.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegistroEspecialidade().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonListarEspecialidade;
    private javax.swing.JButton jButtonOKEspecialidade;
    private javax.swing.JButton jButtonRemoverPlano;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableTabelaEspecialidade;
    private javax.swing.JTextField jTextFieldCodEspecialidade;
    private javax.swing.JTextField jTextFieldNomeEspecialidade;
    private javax.swing.JTextField jTextFieldRemoverEspecialidade;
    // End of variables declaration//GEN-END:variables
}

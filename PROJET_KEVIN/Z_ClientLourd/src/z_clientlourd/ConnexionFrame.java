/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package z_clientlourd;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author VOCAN
 */
public class ConnexionFrame extends javax.swing.JFrame 
{

    /**
     * Creates new form test
     */
    public ConnexionFrame() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Titre = new javax.swing.JLabel();
        Contenu = new javax.swing.JPanel();
        PanelConnexion = new javax.swing.JPanel();
        btnConnexion = new javax.swing.JButton();
        fieldConnexionPassword = new javax.swing.JPasswordField();
        fieldConnexionUsername = new javax.swing.JTextField();
        PanelCreationCompte = new javax.swing.JPanel();
        btnCreationCompte = new javax.swing.JButton();
        fieldCreationCompteEmail = new javax.swing.JTextField();
        fieldCreationCompteUsername = new javax.swing.JTextField();
        fieldCreationComptePrenom = new javax.swing.JTextField();
        fieldCreationCompteNom = new javax.swing.JTextField();
        fieldCreationComptePassword = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("DOKS");
        setMaximumSize(new java.awt.Dimension(1920, 1080));
        setMinimumSize(new java.awt.Dimension(800, 600));
        setName("FrameDOCKS"); // NOI18N
        setPreferredSize(new java.awt.Dimension(800, 600));

        Titre.setBackground(new java.awt.Color(255, 255, 255));
        Titre.setFont(new java.awt.Font("Arial Black", 0, 48)); // NOI18N
        Titre.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Titre.setText("DOKS");
        Titre.setMaximumSize(new java.awt.Dimension(1920, 200));
        Titre.setMinimumSize(new java.awt.Dimension(1920, 200));
        Titre.setOpaque(true);
        getContentPane().add(Titre, java.awt.BorderLayout.PAGE_START);

        Contenu.setBackground(new java.awt.Color(255, 255, 255));
        Contenu.setPreferredSize(new java.awt.Dimension(800, 600));

        PanelConnexion.setBackground(new java.awt.Color(102, 153, 255));
        PanelConnexion.setMaximumSize(new java.awt.Dimension(500, 900));
        PanelConnexion.setMinimumSize(new java.awt.Dimension(300, 400));
        PanelConnexion.setPreferredSize(new java.awt.Dimension(400, 500));

        btnConnexion.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        btnConnexion.setText("Connexion");
        btnConnexion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConnexionActionPerformed(evt);
            }
        });

        fieldConnexionPassword.setText("jPasswordField1");

        fieldConnexionUsername.setText("Username");
        fieldConnexionUsername.setToolTipText("");
        fieldConnexionUsername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldConnexionUsernameActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelConnexionLayout = new javax.swing.GroupLayout(PanelConnexion);
        PanelConnexion.setLayout(PanelConnexionLayout);
        PanelConnexionLayout.setHorizontalGroup(
            PanelConnexionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelConnexionLayout.createSequentialGroup()
                .addContainerGap(128, Short.MAX_VALUE)
                .addGroup(PanelConnexionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnConnexion, javax.swing.GroupLayout.DEFAULT_SIZE, 315, Short.MAX_VALUE)
                    .addComponent(fieldConnexionPassword)
                    .addComponent(fieldConnexionUsername))
                .addContainerGap(148, Short.MAX_VALUE))
        );
        PanelConnexionLayout.setVerticalGroup(
            PanelConnexionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelConnexionLayout.createSequentialGroup()
                .addContainerGap(71, Short.MAX_VALUE)
                .addComponent(fieldConnexionUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(fieldConnexionPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 242, Short.MAX_VALUE)
                .addComponent(btnConnexion, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50))
        );

        PanelCreationCompte.setBackground(new java.awt.Color(255, 102, 102));
        PanelCreationCompte.setMaximumSize(new java.awt.Dimension(500, 900));
        PanelCreationCompte.setMinimumSize(new java.awt.Dimension(300, 400));
        PanelCreationCompte.setPreferredSize(new java.awt.Dimension(400, 500));

        btnCreationCompte.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        btnCreationCompte.setText("Créer un compte");
        btnCreationCompte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreationCompteActionPerformed(evt);
            }
        });

        fieldCreationCompteEmail.setText("Email");

        fieldCreationCompteUsername.setText("Username");

        fieldCreationComptePrenom.setText("Prénom");

        fieldCreationCompteNom.setText("Nom");
        fieldCreationCompteNom.setToolTipText("");

        fieldCreationComptePassword.setText("jPasswordField2");

        javax.swing.GroupLayout PanelCreationCompteLayout = new javax.swing.GroupLayout(PanelCreationCompte);
        PanelCreationCompte.setLayout(PanelCreationCompteLayout);
        PanelCreationCompteLayout.setHorizontalGroup(
            PanelCreationCompteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelCreationCompteLayout.createSequentialGroup()
                .addContainerGap(117, Short.MAX_VALUE)
                .addGroup(PanelCreationCompteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(fieldCreationComptePassword)
                    .addComponent(fieldCreationCompteNom)
                    .addComponent(fieldCreationComptePrenom)
                    .addComponent(fieldCreationCompteUsername)
                    .addComponent(fieldCreationCompteEmail)
                    .addComponent(btnCreationCompte, javax.swing.GroupLayout.DEFAULT_SIZE, 356, Short.MAX_VALUE))
                .addContainerGap(117, Short.MAX_VALUE))
        );
        PanelCreationCompteLayout.setVerticalGroup(
            PanelCreationCompteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelCreationCompteLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(fieldCreationCompteNom, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(fieldCreationComptePrenom, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(fieldCreationCompteUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(fieldCreationComptePassword, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(fieldCreationCompteEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 123, Short.MAX_VALUE)
                .addComponent(btnCreationCompte, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50))
        );

        fieldCreationCompteNom.getAccessibleContext().setAccessibleName("");

        javax.swing.GroupLayout ContenuLayout = new javax.swing.GroupLayout(Contenu);
        Contenu.setLayout(ContenuLayout);
        ContenuLayout.setHorizontalGroup(
            ContenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ContenuLayout.createSequentialGroup()
                .addContainerGap(240, Short.MAX_VALUE)
                .addComponent(PanelConnexion, javax.swing.GroupLayout.DEFAULT_SIZE, 591, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 259, Short.MAX_VALUE)
                .addComponent(PanelCreationCompte, javax.swing.GroupLayout.DEFAULT_SIZE, 590, Short.MAX_VALUE)
                .addContainerGap(240, Short.MAX_VALUE))
        );
        ContenuLayout.setVerticalGroup(
            ContenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ContenuLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(ContenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PanelCreationCompte, javax.swing.GroupLayout.DEFAULT_SIZE, 561, Short.MAX_VALUE)
                    .addComponent(PanelConnexion, javax.swing.GroupLayout.DEFAULT_SIZE, 561, Short.MAX_VALUE))
                .addGap(39, 39, 39))
        );

        getContentPane().add(Contenu, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnConnexionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConnexionActionPerformed
        if (checkPassword(fieldCreationComptePassword.getText()) && checkUsername(fieldCreationCompteUsername.getText())) 
        {
            try {
                Connexion connexion = new Connexion();
            	if(connexion.connect(fieldCreationCompteUsername.getText(), fieldCreationComptePassword.getText())){
            		setVisible(false);
            		HomeFrame home = new HomeFrame();
            		home.setVisible(true);
            		connexion.c.close();
            	}
                else JOptionPane.showMessageDialog(null, "Username ou mot de passe invalide");
            } catch (SQLException e1) {
            	// TODO Auto-generated catch block
            	e1.printStackTrace();
            } catch (IOException ex) {
                Logger.getLogger(ConnexionFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else JOptionPane.showMessageDialog(null, "CHAMPS INVALIDES");
    }//GEN-LAST:event_btnConnexionActionPerformed

    private void btnCreationCompteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreationCompteActionPerformed
        // Vérifications des champs
        if (checkEmail(fieldCreationCompteEmail.getText()) 
                && checkPassword(fieldCreationComptePassword.getText())
                && checkUsername(fieldCreationCompteUsername.getText())
                && checkEmpty(fieldCreationCompteNom.getText()) 
                && checkEmpty(fieldCreationComptePrenom.getText())) {
            
            try {

                Connexion connexion = new Connexion();
                
                
                connexion.register(fieldCreationCompteNom.getText(),fieldCreationComptePrenom.getText(),fieldCreationCompteUsername.getText(),fieldCreationComptePassword.getText(),fieldCreationCompteEmail.getText());
                setVisible(false);
                HomeFrame home = new HomeFrame();
            	home.setVisible(true);
              
                connexion.c.close();
                
            } catch (SQLException ex) {
                Logger.getLogger(ConnexionFrame.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(ConnexionFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else JOptionPane.showMessageDialog(null, "INFORMATIONS MANQUANTES");					
    }//GEN-LAST:event_btnCreationCompteActionPerformed

    private void fieldConnexionUsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldConnexionUsernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldConnexionUsernameActionPerformed

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
            java.util.logging.Logger.getLogger(ConnexionFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConnexionFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConnexionFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConnexionFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ConnexionFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Contenu;
    private javax.swing.JPanel PanelConnexion;
    private javax.swing.JPanel PanelCreationCompte;
    private javax.swing.JLabel Titre;
    private javax.swing.JButton btnConnexion;
    private javax.swing.JButton btnCreationCompte;
    private javax.swing.JPasswordField fieldConnexionPassword;
    private javax.swing.JTextField fieldConnexionUsername;
    private javax.swing.JTextField fieldCreationCompteEmail;
    private javax.swing.JTextField fieldCreationCompteNom;
    private javax.swing.JPasswordField fieldCreationComptePassword;
    private javax.swing.JTextField fieldCreationComptePrenom;
    private javax.swing.JTextField fieldCreationCompteUsername;
    // End of variables declaration//GEN-END:variables

    private boolean checkEmail(String text) {
        return text != null;
    }

    private boolean checkPassword(String text) {
        return text != null;
    }

    private boolean checkUsername(String text) {
        return text != null;
    }

    private boolean checkEmpty(String text) {
        return text != null;
    }

}

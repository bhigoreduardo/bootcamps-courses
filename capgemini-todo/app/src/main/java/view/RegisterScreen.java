package view;

import model.User;
import controller.UserController;
import javax.swing.JOptionPane;

public class RegisterScreen extends javax.swing.JFrame {

    // Variables
    String user;
    String password;
    String passwordRepeat;

    User userData;
    UserController userController;

    public RegisterScreen() {
        initComponents();

        userController = new UserController();

        hideMessageError();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelContainer = new javax.swing.JPanel();
        jLabelTitle = new javax.swing.JLabel();
        jLabelUser = new javax.swing.JLabel();
        jTextFieldUser = new javax.swing.JTextField();
        jLabelPass = new javax.swing.JLabel();
        jLabelRepeat = new javax.swing.JLabel();
        jButtonRegister = new javax.swing.JButton();
        jLabelMessageUser = new javax.swing.JLabel();
        jLabelMessagePass = new javax.swing.JLabel();
        jLabelMessageRepeat = new javax.swing.JLabel();
        jPasswordFieldPass = new javax.swing.JPasswordField();
        jPasswordFieldRepeat = new javax.swing.JPasswordField();
        jButtonLogin = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(600, 500));

        jPanelContainer.setBackground(new java.awt.Color(52, 58, 64));

        jLabelTitle.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabelTitle.setForeground(new java.awt.Color(255, 255, 255));
        jLabelTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTitle.setText("Cadastrar");

        jLabelUser.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelUser.setForeground(new java.awt.Color(255, 255, 255));
        jLabelUser.setText("Usu??rio");

        jTextFieldUser.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabelPass.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelPass.setForeground(new java.awt.Color(255, 255, 255));
        jLabelPass.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelPass.setText("Senha");

        jLabelRepeat.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelRepeat.setForeground(new java.awt.Color(255, 255, 255));
        jLabelRepeat.setText("Repetir Senha");

        jButtonRegister.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButtonRegister.setText("Cadastrar usu??rio");
        jButtonRegister.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonRegisterMouseClicked(evt);
            }
        });

        jLabelMessageUser.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabelMessageUser.setForeground(new java.awt.Color(255, 51, 51));
        jLabelMessageUser.setText("Usu??rio j?? existente");

        jLabelMessagePass.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabelMessagePass.setForeground(new java.awt.Color(255, 51, 51));
        jLabelMessagePass.setText("Senhas diferentes");

        jLabelMessageRepeat.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabelMessageRepeat.setForeground(new java.awt.Color(255, 51, 51));
        jLabelMessageRepeat.setText("Senhas diferentes");

        jPasswordFieldPass.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jPasswordFieldRepeat.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jButtonLogin.setBackground(new java.awt.Color(0, 123, 255));
        jButtonLogin.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButtonLogin.setForeground(new java.awt.Color(255, 255, 255));
        jButtonLogin.setText("Fazer Login");
        jButtonLogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonLoginMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanelContainerLayout = new javax.swing.GroupLayout(jPanelContainer);
        jPanelContainer.setLayout(jPanelContainerLayout);
        jPanelContainerLayout.setHorizontalGroup(
            jPanelContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelContainerLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelRepeat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelTitle, javax.swing.GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE)
                    .addComponent(jLabelUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextFieldUser)
                    .addComponent(jLabelPass, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelMessageUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelMessagePass, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelMessageRepeat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPasswordFieldPass)
                    .addGroup(jPanelContainerLayout.createSequentialGroup()
                        .addComponent(jButtonRegister)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonLogin))
                    .addComponent(jPasswordFieldRepeat))
                .addContainerGap())
        );
        jPanelContainerLayout.setVerticalGroup(
            jPanelContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelContainerLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabelTitle)
                .addGap(18, 18, 18)
                .addComponent(jLabelUser)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jLabelMessageUser)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelPass)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPasswordFieldPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(jLabelMessagePass)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelRepeat)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPasswordFieldRepeat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelMessageRepeat)
                .addGap(18, 18, 18)
                .addGroup(jPanelContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonRegister)
                    .addComponent(jButtonLogin))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanelContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonLoginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonLoginMouseClicked
        showLoginScreen();
    }//GEN-LAST:event_jButtonLoginMouseClicked

    private void jButtonRegisterMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonRegisterMouseClicked
        this.user = jTextFieldUser.getText();

        this.userData = userController.selectUser(this.user);

        hideMessageError();

        // User found
        if (userFound()) {
            JOptionPane.showMessageDialog(rootPane, "Usu??rio j?? cadastrado");
            jLabelMessageUser.setVisible(true);
        } else {
            // Pass not Check
            this.password = jPasswordFieldPass.getText();
            this.passwordRepeat = jPasswordFieldRepeat.getText();

            if (this.password.equals(this.passwordRepeat)) {
                this.userData = new User(this.user, this.password);

                if (userData.getId() == 0) {
                    userController.insertInto(this.userData);
                    JOptionPane.showMessageDialog(rootPane, "Usu??rio cadastrado");
                }

                showLoginScreen();
            } else {
                JOptionPane.showMessageDialog(rootPane, "Senhas n??o conferem");
                jLabelMessagePass.setVisible(true);
                jLabelMessageRepeat.setVisible(true);
            }
        }

    }//GEN-LAST:event_jButtonRegisterMouseClicked

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
                if ("Java Swing".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(RegisterScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegisterScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegisterScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegisterScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegisterScreen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonLogin;
    private javax.swing.JButton jButtonRegister;
    private javax.swing.JLabel jLabelMessagePass;
    private javax.swing.JLabel jLabelMessageRepeat;
    private javax.swing.JLabel jLabelMessageUser;
    private javax.swing.JLabel jLabelPass;
    private javax.swing.JLabel jLabelRepeat;
    private javax.swing.JLabel jLabelTitle;
    private javax.swing.JLabel jLabelUser;
    private javax.swing.JPanel jPanelContainer;
    private javax.swing.JPasswordField jPasswordFieldPass;
    private javax.swing.JPasswordField jPasswordFieldRepeat;
    private javax.swing.JTextField jTextFieldUser;
    // End of variables declaration//GEN-END:variables

    public void hideMessageError() {
        jLabelMessageUser.setVisible(false);
        jLabelMessagePass.setVisible(false);
        jLabelMessageRepeat.setVisible(false);
    }

    public boolean userFound() {
        if (this.userData == null) {
            return false;
        } else {
            return this.userData.getUser().equals(this.user);
        }
    }

    public void showLoginScreen() {
        LoginScreen loginScreen = new LoginScreen();
        loginScreen.setVisible(true);
        this.dispose();
    }
}

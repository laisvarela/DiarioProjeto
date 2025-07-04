/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/MDIApplication.java to edit this template
 */
package view;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
/**
 *
 * @author LaisV
 */
public class Main extends javax.swing.JFrame {

    /**
     * Creates new form Main
     */
    public Main() {
        initComponents();
        // Centraliza a janela principal
        setLocationRelativeTo(null); 
        // Inicia com o menu para usuário deslogado
        configurarMenuDeslogado();
    }
    /**
     * Configura a barra de menu para quando o usuário NÃO está logado.
     */
    public void configurarMenuDeslogado() {
        menuBar.removeAll(); // Limpa todos os menus existentes

        JMenu sistemaMenu = new JMenu("Sistema");

        JMenuItem loginItem = new JMenuItem("Login");
        loginItem.addActionListener(e -> abrirTelaLogin());
        sistemaMenu.add(loginItem);

        JMenuItem cadastroItem = new JMenuItem("Cadastro");
        cadastroItem.addActionListener(e -> abrirTelaCadastro());
        sistemaMenu.add(cadastroItem);
        
        sistemaMenu.addSeparator(); // Adiciona uma linha separadora

        JMenuItem sairItem = new JMenuItem("Sair");
        sairItem.addActionListener(e -> System.exit(0));
        sistemaMenu.add(sairItem);

        menuBar.add(sistemaMenu);
        
        // Redesenha a barra de menus
        revalidate();
        repaint();
    }

    /**
     * Configura a barra de menu para quando o usuário FAZ o login.
     * @param nomeApelido O nome de apelido do usuário para exibir no menu.
     * @param isAdm       True se o usuário for administrador, para exibir os menus de ADM.
     */
    public void configurarMenuLogado(String nomeApelido, boolean isAdm) {
        menuBar.removeAll();

        JMenu usuarioMenu = new JMenu("Olá, " + nomeApelido);

        JMenuItem diarioItem = new JMenuItem("Meu Diário");
        diarioItem.addActionListener(e -> abrirTelaDiario());
        usuarioMenu.add(diarioItem);
        
        usuarioMenu.addSeparator();

        JMenuItem configItem = new JMenuItem("Configurações da Conta");
        configItem.addActionListener(e -> abrirTelaCadastroParaEdicao());
        usuarioMenu.add(configItem);
        
        JMenuItem deletarContaItem = new JMenuItem("Deletar Minha Conta");
        deletarContaItem.addActionListener(e -> deletarConta());
        usuarioMenu.add(deletarContaItem);

        // Se for administrador, adiciona o menu de administração
        if (isAdm) {
            JMenu admMenu = new JMenu("Administração");
            JMenuItem usuariosItem = new JMenuItem("Gerenciar Usuários");
            usuariosItem.addActionListener(e -> abrirTelaADMUsuarios());
            admMenu.add(usuariosItem);

            JMenuItem tagsItem = new JMenuItem("Gerenciar Tags");
            tagsItem.addActionListener(e -> abrirTelaADMTags());
            admMenu.add(tagsItem);
            
            menuBar.add(admMenu);
        }
        
        menuBar.add(usuarioMenu);
        
        JMenu sistemaMenu = new JMenu("Sistema");
        JMenuItem logoutItem = new JMenuItem("Logout");
        // Ao clicar em logout, volta para o menu deslogado
        logoutItem.addActionListener(e -> {
            desktopPane.removeAll(); // Fecha todas as janelas internas
            desktopPane.repaint();
            configurarMenuDeslogado();
        });
        sistemaMenu.add(logoutItem);
        
        menuBar.add(sistemaMenu);

        // Redesenha a barra de menus
        revalidate();
        repaint();
    }
    
    // MÉTODOS PARA ABRIR AS TELAS INTERNAS

    private void abrirTelaLogin() {
        TelaLogin tela = new TelaLogin();
        desktopPane.add(tela);
        tela.setVisible(true);
    }

    private void abrirTelaCadastro() {
        TelaCadastro tela = new TelaCadastro(false); 
        desktopPane.add(tela);
        tela.setVisible(true);
    }
    
    private void abrirTelaDiario() {
        TelaDiario tela = new TelaDiario();
        desktopPane.add(tela);
        tela.setVisible(true);
    }
    
    private void abrirTelaCadastroParaEdicao() {
        TelaCadastro tela = new TelaCadastro(true); 
        //   chamar um método no controller para pegar os dados do usuário logado
        // e então preencher a tela.
        desktopPane.add(tela);
        tela.setVisible(true);
    }
    
    private void abrirTelaADMUsuarios() {
        TelaADMUsuarios tela = new TelaADMUsuarios();
        desktopPane.add(tela);
        tela.setVisible(true);
    }
    
    private void abrirTelaADMTags() {
        TelaADMTags tela = new TelaADMTags();
        desktopPane.add(tela);
        tela.setVisible(true);
    }

    private void deletarConta() {
        int resposta = JOptionPane.showConfirmDialog(
            this,
            "Tem certeza que deseja deletar sua conta? Esta ação é permanente.",
            "Confirmar Exclusão de Conta",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.WARNING_MESSAGE
        );
        if (resposta == JOptionPane.YES_OPTION) {
            // Chamar o controller para executar a exclusão
            
            JOptionPane.showMessageDialog(this, "Conta deletada com sucesso.");
            configurarMenuDeslogado();
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

        desktopPane = new javax.swing.JDesktopPane();
        menuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        openMenuItem = new javax.swing.JMenuItem();
        saveMenuItem = new javax.swing.JMenuItem();
        saveAsMenuItem = new javax.swing.JMenuItem();
        exitMenuItem = new javax.swing.JMenuItem();
        editMenu = new javax.swing.JMenu();
        cutMenuItem = new javax.swing.JMenuItem();
        copyMenuItem = new javax.swing.JMenuItem();
        pasteMenuItem = new javax.swing.JMenuItem();
        deleteMenuItem = new javax.swing.JMenuItem();
        helpMenu = new javax.swing.JMenu();
        contentMenuItem = new javax.swing.JMenuItem();
        aboutMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        fileMenu.setMnemonic('f');
        fileMenu.setText("File");

        openMenuItem.setMnemonic('o');
        openMenuItem.setText("Open");
        fileMenu.add(openMenuItem);

        saveMenuItem.setMnemonic('s');
        saveMenuItem.setText("Save");
        fileMenu.add(saveMenuItem);

        saveAsMenuItem.setMnemonic('a');
        saveAsMenuItem.setText("Save As ...");
        saveAsMenuItem.setDisplayedMnemonicIndex(5);
        fileMenu.add(saveAsMenuItem);

        exitMenuItem.setMnemonic('x');
        exitMenuItem.setText("Exit");
        exitMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(exitMenuItem);

        menuBar.add(fileMenu);

        editMenu.setMnemonic('e');
        editMenu.setText("Edit");

        cutMenuItem.setMnemonic('t');
        cutMenuItem.setText("Cut");
        editMenu.add(cutMenuItem);

        copyMenuItem.setMnemonic('y');
        copyMenuItem.setText("Copy");
        editMenu.add(copyMenuItem);

        pasteMenuItem.setMnemonic('p');
        pasteMenuItem.setText("Paste");
        editMenu.add(pasteMenuItem);

        deleteMenuItem.setMnemonic('d');
        deleteMenuItem.setText("Delete");
        editMenu.add(deleteMenuItem);

        menuBar.add(editMenu);

        helpMenu.setMnemonic('h');
        helpMenu.setText("Help");

        contentMenuItem.setMnemonic('c');
        contentMenuItem.setText("Contents");
        helpMenu.add(contentMenuItem);

        aboutMenuItem.setMnemonic('a');
        aboutMenuItem.setText("About");
        helpMenu.add(aboutMenuItem);

        menuBar.add(helpMenu);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMenuItemActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitMenuItemActionPerformed

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
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem aboutMenuItem;
    private javax.swing.JMenuItem contentMenuItem;
    private javax.swing.JMenuItem copyMenuItem;
    private javax.swing.JMenuItem cutMenuItem;
    private javax.swing.JMenuItem deleteMenuItem;
    private javax.swing.JDesktopPane desktopPane;
    private javax.swing.JMenu editMenu;
    private javax.swing.JMenuItem exitMenuItem;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JMenu helpMenu;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem openMenuItem;
    private javax.swing.JMenuItem pasteMenuItem;
    private javax.swing.JMenuItem saveAsMenuItem;
    private javax.swing.JMenuItem saveMenuItem;
    // End of variables declaration//GEN-END:variables
   private javax.swing.JDesktopPane desktopPane;
    private javax.swing.JMenuBar menuBar;
}

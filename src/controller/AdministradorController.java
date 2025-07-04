package controller;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Administrador;

/* @author LaisV */
public class AdministradorController {

    public void cadastraADM(Administrador adm) {
        Administrador administador = new Administrador();
        // Validação básica
        if (adm == null || adm.getNome() == null || adm.getUsername() == null
                || adm.getEmail() == null || adm.getSenha() == null || adm.getCodigo() <= 0) {
            JOptionPane.showMessageDialog(null, "Todos os campos obrigatórios devem ser preenchidos!",
                    "Atenção", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (!adm.getEmail().contains("@")) {
            JOptionPane.showMessageDialog(null, "E-mail inválido!", "Atenção", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (administador.buscar(adm.getUsername()) != null) {

        }
        try {
            new Administrador().cadastrar(adm);

            JOptionPane.showMessageDialog(null, "Administrador cadastrado com sucesso!",
                    "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar administrador: " + e.getMessage(),
                    "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public ArrayList<Administrador> listaAdministrador() {
        return null;
    }

    public ArrayList<Administrador> buscaAdministrador(String nome) {
        return null;
    }

    public void editaADM(int id, Administrador novoADM) {
    }

    public void removeADM(int id) {
    }

    public boolean validaCredenciais(String login, String senha) {
        return true;
    }
}

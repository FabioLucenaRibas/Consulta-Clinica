/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocios;

import classebasica.Especialidade;
import dados.DadosRegistroEspecialidade;
import interfaces.InterfaceRegistroEspecialidade;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author MegaKingBR
 */
    public final class NegocioRegistroEspecialidade implements InterfaceRegistroEspecialidade{
    DadosRegistroEspecialidade dre = new DadosRegistroEspecialidade();
    
    @Override
    public void cadastrar(Especialidade e) throws Exception {
        if (e.getCodEspecialidade().trim().equals("") == true) {
            throw new Exception("Informe um codigo valido");
        }
        if (e.getCodEspecialidade() == "0") {
            throw new Exception("Informe um codigo valido");
        }
        if (e.getCodEspecialidade().isEmpty()) {
            throw new Exception("Informe um codigo valido");
        }
        if (e.getCodEspecialidade().trim().equals("") == true) {
            throw new Exception("Informe o codigo da Especialidade a ser removido");
        }
        if (e.getNomeEspecialidade() == null) {
            throw new Exception("Informar o nome da Especialidade");
        }
        if (e.getNomeEspecialidade().isEmpty()) {
            throw new Exception("Informar o nome da Especialidade");
        }
        if (e.getNomeEspecialidade().trim().equals("") == true) {
            throw new Exception("Informar o nome da Especialidade");
        }
        if (e.getNomeEspecialidade().length() >= 16) {
            throw new Exception("O nome da Especialidade esta grande");
        }
        if (dre.verificaExistenciaCodEspecialidade(e) == true) {
            String mensagem = "O codigo da Especialidade informado ja existe.\n";
            mensagem += "Codigo da Especialidade: " + e.getCodEspecialidade();
            throw new Exception(mensagem);
        }
        if (dre.verificaExistencianaNomeEspecialidade(e) == true) {
            String mensagem = "O nome da Especialidade informado ja existe.\n";
            mensagem += "Nome da Especialidade: " + e.getNomeEspecialidade();
            throw new Exception(mensagem);
        }
    dre.cadastrar(e); 
        JOptionPane.showMessageDialog(null, " Especialidade Registrado com sucesso!");
    }
   
    /**
     *
     * @param e
     * @throws Exception
     */
    @Override
    public void atualizar(Especialidade e) throws Exception {
        if (e.getNomeEspecialidade() == null) {
            throw new Exception("Informar o nome da Especialidade");
        }
        if (e.getNomeEspecialidade().isEmpty()) {
            throw new Exception("Informar o nome da Especialidade");
        }
        if (e.getNomeEspecialidade().trim().equals("") == true) {
            throw new Exception("Informar o nome da Especialidade");
        }
        if (e.getNomeEspecialidade().length() >= 16) {
            throw new Exception("O nome da Especialidade esta grande");
        }
        if (dre.verificaExistenciaCodEspecialidade(e) == true) {
            String mensagem = "O codigo da Especialidade informado ja existe.\n";
            mensagem += "Codigo da Especialidade: " + e.getCodEspecialidade();
            throw new Exception(mensagem);
        }
        if (dre.verificaExistencianaNomeEspecialidade(e) == true) {
            String mensagem = "O nome da Especialidade informado ja existe.\n";
            mensagem += "Nome da Especialidade: " + e.getNomeEspecialidade();
            throw new Exception(mensagem);
        }
    dre.atualizar(e); 
        JOptionPane.showMessageDialog(null, " Especialidade Registrado com sucesso!");
    }
    
    
    @Override
        public void remover(Especialidade e) throws Exception {
        if (e.getCodEspecialidade().trim().equals("") == true) {
            throw new Exception("Informe um codigo valido");
        }
        if (e.getCodEspecialidade() == "0") {
            throw new Exception("Informe um codigo valido");
        }
        if (e.getCodEspecialidade().isEmpty()) {
            throw new Exception("Informe um codigo valido");
        }
        if (e.getCodEspecialidade().trim().equals("") == true) {
            throw new Exception("Informe o codigo da Especialidade a ser removido");
        }
        if (dre.verificaExistenciaCodEspecialidade(e) == false) {
            String mensagem = "O codigo da Especialidade informado não existe.\n";
            mensagem += "Codigo da Especialidade: " + e.getCodEspecialidade();
            throw new Exception(mensagem);
        }
        dre.remover(e); 
        JOptionPane.showMessageDialog(null, " Especialidade removida com sucesso!");
    }   
       public ArrayList<Especialidade> ListarEspecialidade() throws Exception {
        return dre.listEspecialidades();
    }  

    @Override
    public ArrayList<Especialidade> listEspecialidades() throws Exception {
      return dre.listEspecialidades();   
    }

    @Override
    public boolean verificaExistenciaCodEspecialidade(Especialidade filtro) throws Exception {
       return dre.verificaExistenciaCodEspecialidade(filtro);  
    }

    @Override
    public boolean verificaExistencianaNomeEspecialidade(Especialidade filtro) throws Exception {
       return dre.verificaExistencianaNomeEspecialidade(filtro);
    }

        }

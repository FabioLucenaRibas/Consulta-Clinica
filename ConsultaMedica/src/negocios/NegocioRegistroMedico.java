package negocios;

import classebasica.Especialidade;
import classebasica.Medico;
import dados.DadosRegistroMedico;
import interfaces.InterfaceRegistroMedico;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author MegaKingBR
 */
public final class NegocioRegistroMedico implements InterfaceRegistroMedico {
        Especialidade e =new Especialidade();
        DadosRegistroMedico drm = new DadosRegistroMedico();
        
        @Override
    public void cadastrar(Medico m) throws Exception {
        if (m.getNome() == null) {
            throw new Exception("Informar o nome do medico");
        }
        if (m.getNome().isEmpty()) {
            throw new Exception("Informar o nome do medico");
        }
        if (m.getNome().trim().equals("") == true) {
            throw new Exception("Informar o nome do medico");
        }
        if (m.getNome().length() <= 15) {
            throw new Exception("O nome do medico esta curto");
        }
        if (m.getNome().length() >= 59) {
            throw new Exception("O nome do medico esta grande");
        }
        if (m.getCrm_Medico() == null) {
            throw new Exception("Informar o CRM do Medico");
        }
        if (m.getCrm_Medico().trim().equals("") == true) {
            throw new Exception("Informar o CRM do Medico");
        }
        if (m.getCrm_Medico().length() <= 3) {
            throw new Exception("O CRM informado esta Invalido. 'o CRM contem apenas 4 digitos' ");
        }
        if (m.getCrm_Medico().length() >= 5) {
            throw new Exception("O CRM informado esta Invalido. 'o CRM contem apenas 4 digitos' ");
        }
        if ((m.getEspecialidade().getCodEspecialidade() != "0" != true) ) {
            throw new Exception("Escolha a Especialidade");
        }
        if ((m.getSexo().getCod_Sexo() != 0 != true) ) {
            throw new Exception("Escolha o sexo");
        }
        if (drm.verificaExistenciaNome(m) == true) {
            String mensagem = "Já existe um Medico cadastrado com o nome informado.\n";
            mensagem += "Nome: " + m.getNome();
            throw new Exception(mensagem);
        }
        if (drm.verificaExistenciaCrm(m) == true) {
            String mensagem = "Já existe um Medico cadastrado com o CRM informado.\n";
            mensagem += "CRM: " + m.getCrm_Medico();
            throw new Exception(mensagem);
        }
        drm.cadastrar(m); 
        JOptionPane.showMessageDialog(null, " Medico registrado com sucesso!");
    }

        @Override
    public void atualizar (Medico m) throws Exception {
        if (m.getNome() == null) {
            throw new Exception("Informar o nome do medico");
        }
        if (m.getNome().isEmpty()) {
            throw new Exception("Informar o nome do medico");
        }
        if (m.getNome().trim().equals("") == true) {
            throw new Exception("Informar o nome do medico");
        }
        if (m.getNome().length() <= 15) {
            throw new Exception("O nome do medico esta curto");
        }
        if (m.getNome().length() >= 59) {
            throw new Exception("O nome do medico esta grande");
        }
        if (m.getCrm_Medico() == null) {
            throw new Exception("Informar o CRM do Medico");
        }
        if (m.getCrm_Medico().trim().equals("") == true) {
            throw new Exception("Informar o CRM do Medico");
        }
        if (m.getCrm_Medico().length() <= 3) {
            throw new Exception("O CRM informado esta Invalido. 'o CRM contem apenas 4 digitos' ");
        }
        if (m.getCrm_Medico().length() >= 5) {
            throw new Exception("O CRM informado esta Invalido. 'o CRM contem apenas 4 digitos' ");
        }
        if ((m.getEspecialidade().getCodEspecialidade() != "0" != true) ) {
            throw new Exception("Escolha a Especialidade");
        }
        if ((m.getSexo().getCod_Sexo() != 0 != true) ) {
            throw new Exception("Escolha o sexo");
        }
        if (m.getDataNasimento() == null) {
            throw new Exception("Informar a Data de Nascimento");
        }
        if (m.getDataNasimento().trim().equals("") == true) {
            throw new Exception("Informar a Data de Nascimento");
        }
        if (drm.verificaExistenciaNome(m) == true) {
            String mensagem = "Já existe um Medico cadastrado com o nome informado.\n";
            mensagem += "Nome: " + m.getNome();
            throw new Exception(mensagem);
        }
        if (drm.verificaExistenciaCrm(m) == true) {
            String mensagem = "Já existe um Medico cadastrado com o CRM informado.\n";
            mensagem += "CRM: " + m.getCrm_Medico();
            throw new Exception(mensagem);
        }
        drm.atualizar(m); 
        JOptionPane.showMessageDialog(null, " Medico registrado com sucesso!");
    }
    
    
        @Override
    public void remover(Medico m) throws Exception {
        if (m.getCrm_Medico() == null) {
            throw new Exception("Informar o CRM do Medico a ser removido");
        }
        if (m.getCrm_Medico().trim().equals("") == true) {
            throw new Exception("Informar o CRM do Medico a ser removido");
        }
        if (m.getCrm_Medico().length() <= 3) {
            throw new Exception("O CRM informado esta Invalido. 'CRM contem apenas 4 digitos' ");
        }
        if (m.getCrm_Medico().length() >= 5) {
            throw new Exception("O CRM informado esta Invalido. 'CRM contem apenas 4 digitos'");
        }
        if (drm.verificaExistenciaCrm(m) == false) {
            String mensagem = "O CRM informado não existe.\n";
            mensagem += "CRM: " + m.getCrm_Medico();
            throw new Exception(mensagem);
        }
        drm.remover(m); 
        JOptionPane.showMessageDialog(null, " Medico removido com sucesso!");
    }
        @Override
       public ArrayList<Medico> listarmedico() throws Exception {
        return drm.listarmedico();
    }
        @Override
       public ArrayList<Medico> listEspecialidades() throws Exception {
        return drm.listEspecialidades();
    } 

    /**
     *
     * @return
     * @throws Exception
     */
    @Override
       public ArrayList<Medico> listarsexo() throws Exception {
        return drm.listarsexo();
    } 

    @Override
    public boolean verificaExistenciaCrm(Medico filtro) throws Exception {
         return drm.verificaExistenciaCrm(filtro);
    }

    @Override
    public boolean verificaExistenciaNome(Medico filtro) throws Exception {
        return drm.verificaExistenciaNome(filtro);
    }
}


    


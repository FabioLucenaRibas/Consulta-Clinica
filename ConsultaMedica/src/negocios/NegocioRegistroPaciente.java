/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocios;

import apresentacao.RegistroPaciente;
import classebasica.Paciente;
import classebasica.PlanodeSaude;
import dados.DadosRegistroPaciente;
import dados.ValidaCPF;
import interfaces.InterfaceRegistroPaciente;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author MegaKingBR
 */
public final class NegocioRegistroPaciente implements InterfaceRegistroPaciente{
        ValidaCPF ValidaCPF = new ValidaCPF();
        PlanodeSaude ps = new PlanodeSaude();
        DadosRegistroPaciente drp = new DadosRegistroPaciente();

    /**
     *
     * @param p
     * @throws Exception
     */
    @Override
      public void cadastrar(Paciente p) throws Exception {
        if (p.getNome() == null) {
            throw new Exception("Informar o nome do paciente");
        }
        if (p.getNome().isEmpty()) {
            throw new Exception("Informar o nome do paciente");
        }
        if (p.getNome().trim().equals("") == true) {
            throw new Exception("Informar o nome do paciente");
        }
        if (p.getNome().length() <= 16) {
            throw new Exception("O nome do paciente esta curto");
        }
        if (p.getNome().length() >= 60) {
            throw new Exception("O nome do paciente esta grande");
        }
        if (p.getCpf_Paciente().trim().equals("") == true) {
            throw new Exception("Informar o CPF do Paciente");
        }
        if (p.getCpf_Paciente() == null) {
            throw new Exception("Informar o CPF do Paciente");
        }
        if (p.getCpf_Paciente().isEmpty()) {
            throw new Exception("Informar o CPF do Paciente");
        }
        if (p.getCpf_Paciente().length() <=10 ) {
            throw new Exception("O CPF informado contem menos que 11 digitos.\n 'O formato padrao do CPF contem 11 digitos'");
        }
        if (p.getCpf_Paciente().length() >=12 ) {
            throw new Exception("O CPF informado contem mais que 11 digitos.\n 'O formato padrao do CPF contem 11 digitos'");
        }
        if (ValidaCPF.isCPF(p.getCpf_Paciente()) == false){
        String mensagem = "Erro, CPF invalido !!!\n";
        mensagem += "Coloque o CPF sem pontuação.";
        throw new Exception(mensagem);
        }
        if (p.getPlanodeSaude().getCodPlano() != "0" != true ) {
            throw new Exception("Escolha o Plano de Saúde");
        }
        if (p.getSexo().getCod_Sexo() != 0 != true ) {
            throw new Exception("Escolha o sexo");
        }
        if (p.getDataNasimento() == null) {
            throw new Exception("Informar a Data de Nascimento");
        }
        if (p.getDataNasimento().trim().equals("") == true) {
            throw new Exception("Informar a Data de Nascimento");
        }
        if (drp.verificaExistenciaNome(p) == true) {
            String mensagem = "Já existe um Paciente cadastrado com o nome informado.\n";
            mensagem += "Nome: " + p.getNome();
            throw new Exception(mensagem);
        }
        if (drp.verificaExistenciaCpf(p) == true) {
            String mensagem = "Já existe um Paciente cadastrado com o CPF informado.\n";
            mensagem += "CPF: " + p.getCpf_Paciente();
            throw new Exception(mensagem);
        }
    drp.cadastrar(p); 
        JOptionPane.showMessageDialog(null, " Paciente Registrado com sucesso!");
    }  
      
        @Override
      public void atualizar(Paciente p) throws Exception {
        if (p.getNome() == null) {
            throw new Exception("Informar o nome do paciente");
        }
        if (p.getNome().isEmpty()) {
            throw new Exception("Informar o nome do paciente");
        }
        if (p.getNome().trim().equals("") == true) {
            throw new Exception("Informar o nome do paciente");
        }
        if (p.getNome().length() <= 16) {
            throw new Exception("O nome do paciente esta curto");
        }
        if (p.getNome().length() >= 60) {
            throw new Exception("O nome do paciente esta grande");
        }
        if (p.getCpf_Paciente().trim().equals("") == true) {
            throw new Exception("Informar o CPF do Paciente");
        }
        if (p.getCpf_Paciente() == null) {
            throw new Exception("Informar o CPF do Paciente");
        }
        if (p.getCpf_Paciente().isEmpty()) {
            throw new Exception("Informar o CPF do Paciente");
        }
        if (p.getCpf_Paciente().length() <=10 ) {
            throw new Exception("O CPF informado contem menos que 11 digitos.\n 'O formato padrao do CPF contem 11 digitos'");
        }
        if (p.getCpf_Paciente().length() >=12 ) {
            throw new Exception("O CPF informado contem mais que 11 digitos.\n 'O formato padrao do CPF contem 11 digitos'");
        }
        if (ValidaCPF.isCPF(p.getCpf_Paciente()) == false){
        String mensagem = "Erro, CPF invalido !!!\n";
        mensagem += "Coloque o CPF sem pontuação.";
        throw new Exception(mensagem);
        }
        if (p.getPlanodeSaude().getCodPlano() != "0" != true ) {
            throw new Exception("Escolha o Plano de Saúde");
        }
        if (p.getSexo().getCod_Sexo() != 0 != true ) {
            throw new Exception("Escolha o sexo");
        }
        if (p.getDataNasimento() == null) {
            throw new Exception("Informar a Data de Nascimento");
        }
        if (p.getDataNasimento().trim().equals("") == true) {
            throw new Exception("Informar a Data de Nascimento");
        }
        if (drp.verificaExistenciaNome(p) == true) {
            String mensagem = "Já existe um Paciente cadastrado com o nome informado.\n";
            mensagem += "Nome: " + p.getNome();
            throw new Exception(mensagem);
        }
        if (drp.verificaExistenciaCpf(p) == true) {
            String mensagem = "Já existe um Paciente cadastrado com o CPF informado.\n";
            mensagem += "CPF: " + p.getCpf_Paciente();
            throw new Exception(mensagem);
        }
    drp.atualizar(p); 
        JOptionPane.showMessageDialog(null, " Paciente Registrado com sucesso!");
    }  
      
        @Override
    public void remover(Paciente p) throws Exception {
        if (p.getCpf_Paciente() == null) {
            throw new Exception("Informar o CPF do Paciente a ser removido");
        }
        if (p.getCpf_Paciente().trim().equals("") == true) {
            throw new Exception("Informar o CPF do Paciente a ser removido");
        }
        if (p.getCpf_Paciente().length() <=10 ) {
            throw new Exception("O CPF informado contem menos que 11 digitos.\n 'O formato padrao do CPF contem 11 digitos'");
        }
        if (p.getCpf_Paciente().length() >=12 ) {
            throw new Exception("O CPF informado contem mais que 11 digitos.\n 'O formato padrao do CPF contem 11 digitos'");
        }
        if (drp.verificaExistenciaCpf(p) == false) {
            String mensagem = "O CPF informado não existe.\n";
            mensagem += "CPF: " + p.getCpf_Paciente();
            throw new Exception(mensagem);
        }
        drp.remover(p); 
        JOptionPane.showMessageDialog(null, " Paciente removido com sucesso!");
    }
       public ArrayList<Paciente> listPlanodeSaude() throws Exception {
        return drp.listPlanodeSaudes();
    } 
        @Override
       public ArrayList<Paciente> listarPaciente() throws Exception {
        return drp.listarPaciente();
    }

    /**
     *
     * @return
     * @throws Exception
     */
    @Override
       public ArrayList<Paciente> listarsexo() throws Exception  {
        return drp.listarsexo();
    }

    @Override
    public boolean verificaExistenciaCpf(Paciente filtro) throws Exception {
        return drp.verificaExistenciaCpf(filtro);
    }

    @Override
    public boolean verificaExistenciaNome(Paciente filtro) throws Exception {
        return drp.verificaExistenciaNome(filtro);
    }

    @Override
    public ArrayList<Paciente> listPlanodeSaudes() throws Exception {
        return drp.listPlanodeSaudes();
    }
}

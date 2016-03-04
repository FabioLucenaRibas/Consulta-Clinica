/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocios;

import classebasica.Consulta;
import dados.DadosTeladeConsulta;
import interfaces.InterfaceTeladeConsulta;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author MegaKingBR
 */
public class NegocioTeladeConsulta implements InterfaceTeladeConsulta{
    DadosTeladeConsulta dtc = new DadosTeladeConsulta();
    @Override
      public void cadastrar(Consulta c) throws Exception {
        if (c.getPaciente().getCpf_Paciente() == null) {
            throw new Exception("Informar o CPF do Paciente");
        }
        if (c.getPaciente().getCpf_Paciente().isEmpty()) {
            throw new Exception("Informar o CPF do Paciente");
        }
        if (c.getMedico().getCrm_Medico() == null) {
            throw new Exception("Informe o CRM do Medico");
        }
        if (c.getMedico().getCrm_Medico().isEmpty()) {
            throw new Exception("Informe o CRM do Medico");
        }
        if (c.getDataConsulta() == null) {
            throw new Exception("Informar a Data da consulta");
        }
        if (c.getDataConsulta().isEmpty()) {
            throw new Exception("Informar a Data da consulta");
        }
        if (c.getDataConsulta().trim().equals("") == true) {
            throw new Exception("Informar a Data da consulta");
        }
        if (c.getHoraInicio() == null) {
            throw new Exception("Informar a hora inicial da consulta");
        }
        if (c.getHoraInicio().isEmpty()) {
            throw new Exception("Informar a hora inicial da consulta");
        }
        if (c.getHoraInicio().trim().equals("") == true) {
            throw new Exception("Informar a hora inicial da consulta");
        }
        if (c.getHoraFinal() == null) {
            throw new Exception("Informar a hora final da consulta");
        }
        if (c.getHoraFinal().isEmpty()) {
            throw new Exception("Informar a hora final da consulta");
        }
        if (c.getHoraFinal().trim().equals("") == true) {
            throw new Exception("Informar a hora final da consulta");
        } 
    dtc.cadastrar(c); 
        JOptionPane.showMessageDialog(null, " Prontúario Registrado com sucesso!");
    }  
      
    @Override
      public void atualizar(Consulta c) throws Exception {
        if (c.getNumeroProntuario() == null) {
            throw new Exception("Coloque o numero do prontúario a esquerda depois pressione ' Mostrar prontuario ' \nAltere o texto e ai sim pressione em ' Atualizar Prontuario '.");
        }
        if (c.getNumeroProntuario().isEmpty()) {
            throw new Exception("Coloque o numero do prontúario a esquerda depois pressione ' Mostrar prontuario ' \nAltere o texto e ai sim pressione em ' Atualizar Prontuario '.");
        }
        if (c.getPaciente().getCpf_Paciente() == null) {
            throw new Exception("Informar o CPF do Paciente");
        }
        if (c.getPaciente().getCpf_Paciente().isEmpty()) {
            throw new Exception("Informar o CPF do Paciente");
        }
        if (c.getMedico().getCrm_Medico() == null) {
            throw new Exception("Informe o CRM do Medico");
        }
        if (c.getMedico().getCrm_Medico().isEmpty()) {
            throw new Exception("Informe o CRM do Medico");
        }
        if (c.getDataConsulta() == null) {
            throw new Exception("Informar a Data da consulta");
        }
        if (c.getDataConsulta().isEmpty()) {
            throw new Exception("Informar a Data da consulta");
        }
        if (c.getDataConsulta().trim().equals("") == true) {
            throw new Exception("Informar a Data da consulta");
        }
        if (c.getHoraInicio() == null) {
            throw new Exception("Informar a hora inicial da consulta");
        }
        if (c.getHoraInicio().isEmpty()) {
            throw new Exception("Informar a hora inicial da consulta");
        }
        if (c.getHoraInicio().trim().equals("") == true) {
            throw new Exception("Informar a hora inicial da consulta");
        }
        if (c.getHoraFinal() == null) {
            throw new Exception("Informar a hora final da consulta");
        }
        if (c.getHoraFinal().isEmpty()) {
            throw new Exception("Informar a hora final da consulta");
        }
        if (c.getHoraFinal().trim().equals("") == true) {
            throw new Exception("Informar a hora final da consulta");
        } 
        if (dtc.verificaExistenciaNumero_Prontuario(c) == false) {
            String mensagem = "Não existe Prontúario cadastrado com o numero informado. \n";
            mensagem += "Numero do prontuario informado: " + c.getNumeroProntuario();
            throw new Exception(mensagem);
        }
    dtc.atualizar(c); 
        JOptionPane.showMessageDialog(null, " Prontúario atualizado com sucesso!");
    }  
    @Override 
    public void remover(Consulta c) throws Exception {
        if (c.getNumeroProntuario() == null) {
            throw new Exception("Informar o numero do prontúario");
        }
        if (c.getNumeroProntuario().isEmpty()) {
            throw new Exception("Informar o numero do prontúario");
        }
        if (c.getNumeroProntuario().trim().equals("") == true) {
            throw new Exception("Informar a hora final da consulta");
        } 
        if (dtc.verificaExistenciaNumero_Prontuario(c) == false) {
            String mensagem = "Não existe Prontúario cadastrado com o numero informado. \n";
            mensagem += "Numero do prontuario informado: " + c.getNumeroProntuario();
            throw new Exception(mensagem);
        }
        dtc.remover(c); 
        JOptionPane.showMessageDialog(null, " Prontúario removido com sucesso!");
    }
    
    /**
     *
     * @param c
     * @throws Exception
     */

    public void ValidacaoCPF(Consulta c) throws Exception {
        if (c.getPaciente().getCpf_Paciente() == null) {
            throw new Exception("Informar o CPF do Paciente");
        }
        if (c.getPaciente().getCpf_Paciente().isEmpty()) {
            throw new Exception("Informar o CPF do Paciente");
        }
        if (c.getPaciente().getCpf_Paciente().length() <=10 ) {
            throw new Exception("O CPF informado contem menos que 11 digitos.\n 'O formato padrao do CPF contem 11 digitos'");
        }
        if (c.getPaciente().getCpf_Paciente().length() >=12 ) {
            throw new Exception("O CPF informado contem mais que 11 digitos.\n 'O formato padrao do CPF contem 11 digitos'");
        }
        if (c.getPaciente().getCpf_Paciente().trim().equals("") == true) {
            throw new Exception("Informar o CPF do Paciente");
        }
        if (dtc.verificaExistenciaCPF(c) == false) {
            String mensagem = "O CPF informado não existe na lista de Pacientes.";
            throw new Exception(mensagem);
        }
    dtc.mostrarPaciente(c);
    }  


    public void ValidacaoCRM(Consulta c) throws Exception {
        if (c.getMedico().getCrm_Medico() == null) {
            throw new Exception("Informe o CRM do Medico");
        }
        if (c.getMedico().getCrm_Medico().isEmpty()) {
            throw new Exception("Informe o CRM do Medico");
        }
        if (c.getMedico().getCrm_Medico().trim().equals("") == true) {
            throw new Exception("Informe o CRM do Medico");
        }
        if (c.getMedico().getCrm_Medico().length() <=3 ) {
            throw new Exception("O CRM informado contem menos que 4 digitos.\n 'O formato padrao do CRM contem 4 digitos'");
        }
        if (c.getMedico().getCrm_Medico().length() >=5 ) {
            throw new Exception("O CRM informado contem mais que 4 digitos.\n 'O formato padrao do CRM contem 4 digitos'");
        }
        if (dtc.verificaExistenciaCRM(c) == false) {
            String mensagem = "O CRM informado não existe na lista de Medicos.";
            throw new Exception(mensagem);
        }
    dtc.mostrarMedico(c);
    } 
    @Override
       public ArrayList<Consulta> listarProntuario() throws Exception {
        return dtc.listarProntuario();
    }
       
    /**
     *
     * @param c
     * @throws Exception
     */
    @Override
    public void MostraProntuario(Consulta c) throws Exception {
        if (c.getNumeroProntuario() == null) {
            throw new Exception("Informe o numero do prontuario");
        }
        if (c.getNumeroProntuario().isEmpty()) {
            throw new Exception("Informe o numero do prontuario");
        }
        if (c.getNumeroProntuario().trim().equals("") == true) {
            throw new Exception("Informe o numero do prontuario");
        }
        if (dtc.verificaExistenciaNumero_Prontuario(c) == false) {
            String mensagem = "Não existe um prontúario com o numero informado.\n";
            mensagem += "Numero informado: " + c.getNumeroProntuario();
            throw new Exception(mensagem);
        }
        dtc.MostraProntuario(c);

    }

    @Override
    public boolean verificaExistenciaNumero_Prontuario(Consulta c) throws Exception {
        return dtc.verificaExistenciaNumero_Prontuario(c);
    }

    @Override
    public boolean verificaExistenciaCPF(Consulta c) throws Exception {
        return dtc.verificaExistenciaCPF(c);
    }

    @Override
    public boolean verificaExistenciaCRM(Consulta c) throws Exception {
        return dtc.verificaExistenciaCRM(c);
    }

    @Override
    public void mostrarMedico(Consulta c) throws Exception {
        dtc.mostrarMedico(c);
    }

    @Override
    public void mostrarPaciente(Consulta c) throws Exception {
        dtc.mostrarPaciente(c);
    }

}



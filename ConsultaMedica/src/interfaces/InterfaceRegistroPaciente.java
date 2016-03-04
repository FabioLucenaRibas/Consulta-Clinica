/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import classebasica.Paciente;
import java.util.ArrayList;

/**
 *
 * @author MegaKingBR
 */
public interface InterfaceRegistroPaciente {
    void cadastrar(Paciente p) throws Exception;

    void atualizar(Paciente p) throws Exception;

    void remover(Paciente p) throws Exception;
    
    ArrayList<Paciente> listarPaciente() throws Exception;
    
    boolean verificaExistenciaCpf(Paciente filtro) throws Exception;
    
    boolean verificaExistenciaNome(Paciente filtro) throws Exception;
    
    ArrayList<Paciente> listPlanodeSaudes() throws Exception;
    
    ArrayList<Paciente> listarsexo() throws Exception;
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import classebasica.Consulta;
import classebasica.Paciente;
import java.util.ArrayList;

/**
 *
 * @author MegaKingBR
 */
public interface InterfaceTeladeConsulta {

    void cadastrar(Consulta c) throws Exception;

    void atualizar(Consulta c) throws Exception;
    
    void remover(Consulta c) throws Exception;
  
    ArrayList<Consulta> listarProntuario() throws Exception;
    
    void MostraProntuario(Consulta c) throws Exception;
    
    boolean verificaExistenciaNumero_Prontuario(Consulta c) throws Exception;
    
    boolean verificaExistenciaCPF(Consulta c) throws Exception;
    
    boolean verificaExistenciaCRM(Consulta c) throws Exception;
    
    void mostrarMedico(Consulta c) throws Exception;
    
    void mostrarPaciente(Consulta c) throws Exception;
     
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import classebasica.Medico;
import java.util.ArrayList;

/**
 *
 * @author MegaKingBR
 */
public interface InterfaceRegistroMedico {
   void cadastrar(Medico m) throws Exception;
   void atualizar(Medico m) throws Exception;
   void remover(Medico m) throws Exception;
   ArrayList<Medico> listarmedico() throws Exception;
   ArrayList<Medico> listEspecialidades() throws Exception;
   boolean verificaExistenciaCrm(Medico filtro) throws Exception;
   boolean verificaExistenciaNome(Medico filtro) throws Exception;
   ArrayList<Medico> listarsexo() throws Exception;
}

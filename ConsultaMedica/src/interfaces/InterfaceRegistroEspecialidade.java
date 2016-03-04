/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import classebasica.Especialidade;
import java.util.ArrayList;

/**
 *
 * @author MegaKingBR
 */
public interface InterfaceRegistroEspecialidade {
  void cadastrar(Especialidade es) throws Exception;
  void atualizar(Especialidade es) throws Exception;
  void remover(Especialidade es) throws Exception;
  ArrayList<Especialidade> listEspecialidades() throws Exception;
  boolean verificaExistenciaCodEspecialidade(Especialidade filtro) throws Exception;
  boolean verificaExistencianaNomeEspecialidade(Especialidade filtro) throws Exception;
  
}

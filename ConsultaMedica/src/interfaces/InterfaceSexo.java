/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import classebasica.Sexo;
import java.util.ArrayList;

/**
 *
 * @author MegaKingBR
 */
public interface InterfaceSexo {
    
    public void cadastrar(Sexo s) throws Exception;
          
    public void atualizar(Sexo s) throws Exception ;

    public void remover(Sexo s); 
    
    ArrayList<Sexo> listSexo() throws Exception;
    
    boolean verificaExistenciaCodSexo(Sexo filtro) throws Exception;
    
    boolean verificaExistencianaNomeSexo(Sexo filtro) throws Exception;
}

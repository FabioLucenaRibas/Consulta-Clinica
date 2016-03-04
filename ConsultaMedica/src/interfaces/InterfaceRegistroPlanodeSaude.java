/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import classebasica.Paciente;
import classebasica.PlanodeSaude;
import java.util.ArrayList;

/**
 *
 * @author MegaKingBR
 */
public interface InterfaceRegistroPlanodeSaude {

    void cadastrar(PlanodeSaude ps) throws Exception;
    
    void atualizar(PlanodeSaude ps) throws Exception;
    
    void remover(PlanodeSaude ps) throws Exception;
    
    ArrayList<PlanodeSaude> listPlanodeSaude() throws Exception;

}

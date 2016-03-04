/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dados;

import classebasica.Paciente;
import classebasica.PlanodeSaude;
import dados.Dados;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author root
 */
public class TestarSistemaOld {

    public static void main(String[] a) {
        try {
            System.out.println("Listagem dos Planos cadastrados");
            ArrayList<PlanodeSaude> lista = new DadosRegistroPlanoSaude().listPlanodeSaude();
            for (PlanodeSaude p : lista) {
                System.out.println(p.getNomePlano());
            }
            System.out.println("\nListagem dos planos de um paciente");
            Paciente p = new Paciente();
            p.setCpf_Paciente("9495248400");
            ArrayList<Paciente> listaPac = new DadosRegistroPaciente().listarPaciente() ;
            for (Paciente p2 : listaPac) {
                System.out.println(p2.getPlanodeSaude().getNomePlano());
            }
            System.out.print("Conectou-se\n");

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TestarSistemaOld.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(TestarSistemaOld.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(TestarSistemaOld.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}

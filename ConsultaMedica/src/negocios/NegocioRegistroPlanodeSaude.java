/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocios;

import classebasica.Paciente;
import classebasica.PlanodeSaude;
import dados.DadosRegistroPlanoSaude;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author MegaKingBR
 */
public class NegocioRegistroPlanodeSaude implements interfaces.InterfaceRegistroPlanodeSaude{
    DadosRegistroPlanoSaude drps = new DadosRegistroPlanoSaude();
    @Override
    public void cadastrar(PlanodeSaude ps) throws Exception {
        if (ps.getCodPlano().trim().equals("") == true) {
            throw new Exception("Informe um codigo valido");
        }
        if (ps.getCodPlano() == "0") {
            throw new Exception("Informe um codigo valido");
        }
        if (ps.getCodPlano().isEmpty()) {
            throw new Exception("Informe um codigo valido");
        }
        if (ps.getCodPlano().trim().equals("") == true) {
            throw new Exception("Informe o codigo da Especialidade a ser removido");
        }
        if (ps.getNomePlano() == null) {
            throw new Exception("Informar o nome do Plano de Saúde");
        }
        if (ps.getNomePlano().isEmpty()) {
            throw new Exception("Informar o nome do Plano de Saúde");
        }
        if (ps.getNomePlano().trim().equals("") == true) {
            throw new Exception("Informar o nome do Plano de Saúde");
        }
        if (ps.getNomePlano().length() >= 16 ) {
            throw new Exception("O nome do Plano de Saúde esta grande");
        }
        if (drps.verificaExistenciaCodPlano(ps) == true) {
            String mensagem = "O codigo da Especialidade informado ja existe.\n";
            mensagem += "Codigo da Especialidade: " + ps.getCodPlano();
            throw new Exception(mensagem);
        }
        if (drps.verificaExistencianaNomePlano(ps) == true) {
            String mensagem = "O nome do Plano de Saúde informado ja existe.\n";
            mensagem += "Nome do Plano de Saúde: " + ps.getNomePlano();
            throw new Exception(mensagem);
        }
    drps.cadastrar(ps); 
        JOptionPane.showMessageDialog(null, " Plano de Saúde Registrado com sucesso!");
    } 
    
    @Override
    public void atualizar(PlanodeSaude ps) throws Exception {
        if (ps.getNomePlano() == null) {
            throw new Exception("Informar o nome do Plano de Saúde");
        }
        if (ps.getNomePlano().isEmpty()) {
            throw new Exception("Informar o nome do Plano de Saúde");
        }
        if (ps.getNomePlano().trim().equals("") == true) {
            throw new Exception("Informar o nome do Plano de Saúde");
        }
        if (ps.getNomePlano().length() >= 16 ) {
            throw new Exception("O nome do Plano de Saúde esta grande");
        }
        if (drps.verificaExistenciaCodPlano(ps) == true) {
            String mensagem = "O codigo do Plano de Saúde informado ja existe.\n";
            mensagem += "Codigo do Plano de Saúde: " + ps.getCodPlano();
            throw new Exception(mensagem);
        }
        if (drps.verificaExistencianaNomePlano(ps) == true) {
            String mensagem = "O nome do Plano de Saúde informado ja existe.\n";
            mensagem += "Nome do Plano de Saúde: " + ps.getNomePlano();
            throw new Exception(mensagem);
        }
         drps.atualizar(ps); 
        JOptionPane.showMessageDialog(null, " Plano de Saúde Registrado com sucesso!");
    }
    
    /**
     *
     * @param ps
     * @throws Exception
     */
    @Override
        public void remover(PlanodeSaude ps) throws Exception {
        if (ps.getCodPlano().trim().equals("") == true) {
            throw new Exception("Informe o codigo do Plano de Saúde a ser removido");
        }
        if (drps.verificaExistenciaCodPlano(ps) == false) {
            String mensagem = "O codigo do Plano de Saúde informado não existe.\n";
            mensagem += "Codigo do plano: " + ps.getCodPlano();
            throw new Exception(mensagem);
        }
        drps.remover(ps); 
        JOptionPane.showMessageDialog(null, " Plano de Saúde removido com sucesso!");
    }

    @Override
    public ArrayList<PlanodeSaude> listPlanodeSaude() throws Exception {
        return drps.listPlanodeSaude();
    }


}

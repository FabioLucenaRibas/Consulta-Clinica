/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dados;


import classebasica.Paciente;
import classebasica.PlanodeSaude;
import interfaces.InterfaceRegistroPlanodeSaude;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author MegaKingBR
 */
public final class DadosRegistroPlanoSaude extends Dados implements InterfaceRegistroPlanodeSaude{
        @Override
        public void cadastrar(PlanodeSaude ps) throws Exception {
        //Abrindo a conexão
        Statement conex = conectar();
        //Instrução sql correspondente a inserção do PLANO
        String sql = "INSERT INTO PLANO_DE_SAUDE (nome_plano, cod_plano)";
        sql += "VALUES ('" + ps.getNomePlano() + "',"
                + ps.getCodPlano() + ")";
        try {
            //executando a instrução sql
            conex.execute(sql);
        } catch (SQLException e) {
            //Caso haja algum erro neste método será levantada esta execeção
            throw new Exception("Erro ao executar inserção: " + e.getMessage());
        }
        //Fechando a conexão com o banco de dados
        desconectar();

    }
        
    /**
    public     *
     * @param ps
     * @throws Exception
     */
    @Override
 public void atualizar(PlanodeSaude ps) throws Exception {
        try {
            //Abrindo a conexão
            Statement conex = conectar();
            //Instrução sql correspondente a atualização da PLANO_DE_SAUDE
            String sql = " UPDATE PLANO_DE_SAUDE SET";
            sql += " nome_plano = '" + ps.getNomePlano() + "', cod_plano = " + ps.getCodPlano() + "";
            sql += " WHERE numero_prontuario = " + ps.getCodPlano() + "";
            //Executando a instrução sql
            conex.execute(sql);
            //Fechando a conexão com o banco de dados
            desconectar();

        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }

        @Override
    public void remover(PlanodeSaude ps) throws Exception {
        try {
         //Abrindo a conexão
         Statement conex = conectar();
         //Instrução sql correspondente a remoção do Plano
         String sql = "DELETE FROM PLANO_DE_SAUDE WHERE cod_plano = '"+ ps.getCodPlano()+"'";
 //Executando a instrução sql
         conex.execute(sql);
         //Fechando a conexão com o banco de dados
         desconectar();
         } catch (Exception ex) {
         JOptionPane.showMessageDialog(null, ex.getMessage());
         }
    }
        @Override
    public ArrayList<PlanodeSaude> listPlanodeSaude() throws Exception {
        ArrayList<PlanodeSaude> retorno = new ArrayList<>();
        //atribuindo as colunas da tabela

        //abrindo a conexão
        Statement conex = conectar();
        //instrução sql correspondente a seleção dos planos
        String sql = "SELECT cod_plano, nome_plano FROM PLANO_DE_SAUDE WHERE cod_plano >= 1 order by nome_plano";

        //executando a instrução sql
        ResultSet rs = conex.executeQuery(sql);
        while (rs.next()) {
            PlanodeSaude ps = new PlanodeSaude();
            ps.setCodPlano(rs.getString("cod_plano"));
            ps.setNomePlano(rs.getString("nome_plano"));
            retorno.add(ps);
        }
        //fechando a conexão com o banco de dados
        desconectar();

        return retorno;
    }
 
       public boolean verificaExistenciaCodPlano(PlanodeSaude filtro) throws Exception {
       boolean retorno = false;
        //atribuindo as colunas da tabela

        //abrindo a conexão
        Statement conex = conectar();
        //instrução sql correspondente a seleção dos Plano
        String sql = "SELECT cod_plano ";
        sql+= "FROM PLANO_DE_SAUDE ";
        sql += " where cod_plano = '" + filtro.getCodPlano()+"'";

        //executando a instrução sql
        ResultSet rs = conex.executeQuery(sql);
        while (rs.next()) {
            retorno = true; 
            break;
        }
        //fechando a conexão com o banco de dados
        desconectar();

        return retorno;
    }

       public boolean verificaExistencianaNomePlano(PlanodeSaude filtro) throws Exception {
       boolean retorno = false;
        //atribuindo as colunas da tabela

        //abrindo a conexão
        Statement conex = conectar();
        //instrução sql correspondente a seleção dos Plano
        String sql = "SELECT nome_plano ";
        sql+= "FROM PLANO_DE_SAUDE ";
        sql+= "WHERE nome_plano = '" + filtro.getNomePlano()+"'";

        //executando a instrução sql
        ResultSet rs = conex.executeQuery(sql);
        while (rs.next()) {
            retorno = true; 
            break;
        }
        //fechando a conexão com o banco de dados
        desconectar();

        return retorno;
    }
  
}

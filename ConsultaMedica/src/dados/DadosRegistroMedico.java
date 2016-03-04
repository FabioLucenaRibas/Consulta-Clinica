/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dados;

import classebasica.Medico;
import interfaces.InterfaceRegistroMedico;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author MegaKingBR
 */
public class DadosRegistroMedico extends Dados implements InterfaceRegistroMedico{

    /**
     *
     * @param m
     * @throws Exception
     */
    @Override
        public void cadastrar(Medico m) throws Exception {
        //Abrindo a conexão
        Statement conex = conectar();
        //Instrução sql correspondente a inserção do MEDICO
        String sql = "INSERT INTO MEDICO (nome_medico, crm_medico, cod_sexo, data_nascimento, cod_especialidade)";
        sql += "VALUES ('" + m.getNome() + "', '"
                + m.getCrm_Medico() + "','" + m.getSexo().getCod_Sexo() + "','" + m.getDataNasimento() + "'," + m.getEspecialidade().getCodEspecialidade() + ")";
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
     *
     * @param m
     * @throws Exception
     */
    @Override
    public void atualizar(Medico m) throws Exception {
        try {
            //Abrindo a conexão
            Statement conex = conectar();
            //Instrução sql correspondente a atualização da MEDICO
            String sql = " UPDATE MEDICO SET";
            sql += " nome_medico = '" + m.getNome() + "', crm_medico = " + m.getCrm_Medico() + ", cod_sexo = "+ m.getSexo().getCod_Sexo() +", data_nascimento ='" + m.getDataNasimento() + "', Cod_Especialidade =" + m.getEspecialidade().getCodEspecialidade() + "";
            sql += " WHERE crm_medico = " + m.getCrm_Medico() + "";
            //Executando a instrução sql
            conex.execute(sql);
            //Fechando a conexão com o banco de dados
            desconectar();

        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }

        @Override
    public void remover(Medico m) throws Exception {
        try {
         //Abrindo a conexão
         Statement conex = conectar();
         //Instrução sql correspondente a remoção do Medico
         String sql = "DELETE FROM MEDICO WHERE crm_medico = '"+ m.getCrm_Medico()+"'";
         //Executando a instrução sql
         conex.execute(sql);
         //Fechando a conexão com o banco de dados
         desconectar();
         } catch (Exception ex) {
         JOptionPane.showMessageDialog(null, ex.getMessage());
         }
    }
        @Override
    public ArrayList<Medico> listarmedico() throws Exception {
        ArrayList<Medico> retorno = new ArrayList<>();
        //Atribuindo as colunas da tabela

        //Abrindo a conexão
        Statement conex = conectar();
        //Instrução sql correspondente a seleção dos medicos
        String sql = "SELECT nome_medico, crm_medico, nome_sexo, TO_CHAR(data_nascimento, 'DD/MM/YYYY'), nome_especialidade FROM MEDICO AS M, ESPECIALIDADE AS E, SEXO AS S WHERE M.Cod_Especialidade = E.Cod_Especialidade AND M.cod_sexo = S.cod_sexo ORDER BY nome_medico";
        //Executando a instrução sql
        ResultSet rs = conex.executeQuery(sql);
        while (rs.next()) {
            Medico m = new Medico();
            m.setCrm_Medico(rs.getString("crm_medico"));
            m.setNome(rs.getString("nome_medico"));
            m.getSexo().setNome_Sexo(rs.getString("nome_sexo"));
            m.setDataNasimento(rs.getString("TO_CHAR"));
            m.getEspecialidade().setNomeEspecialidade(rs.getString("nome_especialidade"));
            retorno.add(m);
        }
        //Fechando a conexão com o banco de dados
        desconectar();

        return retorno;
        
    }

    /**
     *
     * @return
     * @throws Exception
     */
    @Override
        public ArrayList<Medico> listEspecialidades() throws Exception {
        ArrayList<Medico> retorno = new ArrayList<>();
        //atribuindo as colunas da tabela

        //abrindo a conexão
        Statement conex = conectar();
        //instrução sql correspondente a seleção das Especialidades
        String sql = "SELECT cod_especialidade, nome_especialidade FROM especialidade order by nome_especialidade";

        //executando a instrução sql
        ResultSet rs = conex.executeQuery(sql);
        while (rs.next()) {
            Medico m = new Medico();
            m.getEspecialidade().setCodEspecialidade(rs.getString("cod_especialidade"));
            m.getEspecialidade().setNomeEspecialidade(rs.getString("nome_especialidade"));
            retorno.add(m);
        }
        //fechando a conexão com o banco de dados
        desconectar();

        return retorno;
    }   
        @Override
       public boolean verificaExistenciaCrm(Medico filtro) throws Exception {
       boolean retorno = false;
        //atribuindo as colunas da tabela

        //abrindo a conexão
        Statement conex = conectar();
        //instrução sql correspondente a seleção dos alunos
        String sql = "SELECT crm_medico ";
        sql+= "FROM MEDICO ";
        sql += " WHERE crm_medico = " + filtro.getCrm_Medico();

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
        @Override
       public boolean verificaExistenciaNome(Medico filtro) throws Exception {
       boolean retorno = false;
        //atribuindo as colunas da tabela

        //abrindo a conexão
        Statement conex = conectar();
        //instrução sql correspondente a seleção dos alunos
        String sql = "SELECT nome_medico ";
        sql+= "FROM MEDICO ";
        sql += " WHERE nome_medico = '" + filtro.getNome()+"'";

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

    /**
     *
     * @return
     * @throws Exception
     */
    @Override
        public ArrayList<Medico> listarsexo() throws Exception {
        ArrayList<Medico> retorno = new ArrayList<>();
        //Atribuindo as colunas da tabela

        //Abrindo a conexão
        Statement conex = conectar();
        //Instrução sql correspondente a seleção dos sexos
        String sql = "SELECT * FROM sexo ORDER BY nome_sexo";
        //Executando a instrução sql
        ResultSet rs = conex.executeQuery(sql);
        while (rs.next()) {
            Medico m = new Medico();
            m.getSexo().setCod_Sexo(rs.getInt("cod_sexo"));
            m.getSexo().setNome_Sexo(rs.getString("nome_sexo"));
            retorno.add(m);
        }
        //Fechando a conexão com o banco de dados
        desconectar();

        return retorno;
        
    }
}

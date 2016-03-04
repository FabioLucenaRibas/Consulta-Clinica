/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dados;

import classebasica.Paciente;
import interfaces.InterfaceRegistroPaciente;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author MegaKingBR
 */
public final class DadosRegistroPaciente extends Dados implements InterfaceRegistroPaciente{
    @Override
    public void cadastrar(Paciente p) throws Exception {
        //Abrindo a conexão
        Statement conex = conectar();
        //Instrução sql correspondente a inserção do PACIENTE
        String sql = "INSERT INTO PACIENTE (nome_paciente, cpf_paciente, cod_sexo, data_nascimento, cod_plano)";
        sql += "VALUES ('" + p.getNome() + "', '"
                + p.getCpf_Paciente() + "','" + p.getSexo().getCod_Sexo() + "','" + p.getDataNasimento() + "'," + p.getPlanodeSaude().getCodPlano() + ")";
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
 
    @Override
    public void atualizar(Paciente p) throws Exception {
        try {
            //Abrindo a conexão
            Statement conex = conectar();
            //Instrução sql correspondente a atualização da PACIENTE
            String sql = " UPDATE PACIENTE SET";
            sql += " nome_paciente = '" + p.getNome() + "', cpf_paciente = " + p.getCpf_Paciente() + ", cod_sexo = "+ p.getSexo().getCod_Sexo() +", data_nascimento ='" + p.getDataNasimento() + "', cod_plano = " + p.getPlanodeSaude().getCodPlano() + "";
            sql += " WHERE cpf_paciente = " + p.getCpf_Paciente() + "";
            //Executando a instrução sql
            conex.execute(sql);
            //Fechando a conexão com o banco de dados
            desconectar();

        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }
    
    @Override
    public void remover(Paciente p) {
        try {
            //Abrindo a conexão
            Statement conex = conectar();
            //Instrução sql correspondente a remoção do Paciente
            String sql = "DELETE FROM PACIENTE WHERE cpf_paciente = '"+ p.getCpf_Paciente()+"'";
            //Executando a instrução sql
            conex.execute(sql);
            //Fechando a conexão com o banco de dados
            desconectar();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    @Override
    public ArrayList<Paciente> listarPaciente() throws Exception {
        ArrayList<Paciente> retorno = new ArrayList<>();
        //Atribuindo as colunas da tabela

        //Abrindo a conexão
        Statement conex = conectar();
        //Instrução sql correspondente a seleção dos Pacientes
        String sql = "SELECT nome_paciente, cpf_paciente, nome_sexo, TO_CHAR(data_nascimento, 'DD/MM/YYYY'), nome_plano ,PS.cod_plano FROM PACIENTE AS P, PLANO_DE_SAUDE AS PS, SEXO AS S WHERE P.cod_plano = PS.cod_plano AND P.cod_sexo = S.cod_sexo ORDER BY nome_paciente";
        //Executando a instrução sql
        ResultSet rs = conex.executeQuery(sql);
        while (rs.next()) {
            Paciente p = new Paciente();
            p.setNome(rs.getString("nome_paciente"));
            p.setCpf_Paciente(rs.getString("cpf_paciente"));
            p.getSexo().setNome_Sexo(rs.getString("nome_sexo"));
            p.setDataNasimento(rs.getString("TO_CHAR"));
            p.getPlanodeSaude().setNomePlano(rs.getString("nome_plano"));
            p.getPlanodeSaude().setCodPlano(rs.getString("cod_plano"));
            retorno.add(p);
        }
        //Fechando a conexão com o banco de dados
        desconectar();

        return retorno;

    }

    @Override
       public boolean verificaExistenciaCpf(Paciente filtro) throws Exception {
       boolean retorno = false;
        //atribuindo as colunas da tabela

        //abrindo a conexão
        Statement conex = conectar();
        //instrução sql correspondente a seleção dos alunos
        String sql = "SELECT cpf_paciente ";
        sql+= "FROM PACIENTE ";
        sql += " WHERE cpf_paciente = '" + filtro.getCpf_Paciente()+"'";

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
       public boolean verificaExistenciaNome(Paciente filtro) throws Exception {
       boolean retorno = false;
        //atribuindo as colunas da tabela

        //abrindo a conexão
        Statement conex = conectar();
        //instrução sql correspondente a seleção dos alunos
        String sql = "SELECT nome_paciente ";
        sql+= "FROM PACIENTE ";
        sql += " WHERE nome_paciente = '" + filtro.getNome()+"'";

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
    public ArrayList<Paciente> listPlanodeSaudes() throws Exception {
        ArrayList<Paciente> retorno = new ArrayList<>();
        //atribuindo as colunas da tabela

        //abrindo a conexão
        Statement conex = conectar();
        //instrução sql correspondente a seleção dos planos
        String sql = "SELECT cod_plano, nome_plano FROM PLANO_DE_SAUDE order by nome_plano";

        //executando a instrução sql
        ResultSet rs = conex.executeQuery(sql);
        while (rs.next()) {
            Paciente p = new Paciente();
            p.getPlanodeSaude().setCodPlano(rs.getString("cod_plano"));
            p.getPlanodeSaude().setNomePlano(rs.getString("nome_plano"));
            retorno.add(p);
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
        public ArrayList<Paciente> listarsexo() throws Exception {
        ArrayList<Paciente> retorno = new ArrayList<>();
        //Atribuindo as colunas da tabela

        //Abrindo a conexão
        Statement conex = conectar();
        //Instrução sql correspondente a seleção dos sexos
        String sql = "SELECT * FROM sexo ORDER BY nome_sexo";
        //Executando a instrução sql
        ResultSet rs = conex.executeQuery(sql);
        while (rs.next()) {
            Paciente p = new Paciente();
            p.getSexo().setCod_Sexo(rs.getInt("cod_sexo"));
            p.getSexo().setNome_Sexo(rs.getString("nome_sexo"));
            retorno.add(p);
        }
        //Fechando a conexão com o banco de dados
        desconectar();

        return retorno;
        
    }


}

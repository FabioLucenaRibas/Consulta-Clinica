/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dados;

import classebasica.Consulta;
import classebasica.Paciente;
import interfaces.InterfaceTeladeConsulta;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author MegaKingBR
 */
public class DadosTeladeConsulta extends Dados implements InterfaceTeladeConsulta {

    @Override
    public void cadastrar(Consulta c) throws Exception {
        //Abrindo a conexão
        Statement conex = conectar();
        //Instrução sql correspondente a inserção da CONSULTA
        String sql = "INSERT INTO CONSULTA (hora_inicio, hora_final, data_consulta, descricao_consulta, crm_medico, cpf_paciente)";
        sql += "VALUES ('"+ c.getHoraInicio() + "','" + c.getHoraFinal() + "','" + c.getDataConsulta() + "','" + c.getDescricaoConsulta() + "'," + c.getMedico().getCrm_Medico() + ",'" + c.getPaciente().getCpf_Paciente() + "')";
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
     * @param c
     * @throws Exception
     */
    @Override
    public void atualizar(Consulta c) throws Exception {
        try {
            //Abrindo a conexão
            Statement conex = conectar();
            //Instrução sql correspondente a atualização da CONSULTA
            String sql = "UPDATE CONSULTA SET ";
            sql += "hora_inicio = '"+ c.getHoraInicio() +"', hora_final = '"+ c.getHoraFinal() +"', data_consulta = '"+ c.getDataConsulta() +"', descricao_consulta = '"+ c.getDescricaoConsulta() +"', crm_medico ="+ c.getMedico().getCrm_Medico() +", cpf_paciente = '"+ c.getPaciente().getCpf_Paciente() +"' WHERE numero_prontuario =" + c.getNumeroProntuario();
            //Executando a instrução sql
            conex.execute(sql);
            //Fechando a conexão com o banco de dados
            desconectar();

        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }

    @Override
    public void remover(Consulta c) {
        try {
            //Abrindo a conexão
            Statement conex = conectar();
            //Instrução sql correspondente a remoção da CONSULTA
            String sql = "DELETE FROM CONSULTA WHERE numero_prontuario = '" + c.getNumeroProntuario() + "'";
            //Executando a instrução sql
            conex.execute(sql);
            //Fechando a conexão com o banco de dados
            desconectar();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    @Override
    public ArrayList<Consulta> listarProntuario() throws Exception {
        ArrayList<Consulta> retorno = new ArrayList<>();   
        //Abrindo a conexão
        Statement conex = conectar();
        //Instrução sql correspondente a seleção dos medicos
        String sql = "SELECT CONSULTA.numero_prontuario, PACIENTE.cpf_paciente, PACIENTE.nome_paciente, PLANO_DE_SAUDE.nome_plano, MEDICO.nome_medico, ESPECIALIDADE.Nome_Especialidade, TO_CHAR(CONSULTA.Data_Consulta, 'DD/MM/YYYY'), CONSULTA.Hora_Inicio, CONSULTA.Hora_Final ";
        sql += "FROM CONSULTA "
                + "INNER JOIN PACIENTE ON PACIENTE.CPF_paciente = CONSULTA.CPF_paciente "
                + "INNER JOIN MEDICO ON MEDICO.crm_medico = CONSULTA.crm_medico "
                + "INNER JOIN ESPECIALIDADE ON MEDICO.Cod_Especialidade = ESPECIALIDADE.Cod_Especialidade "
                + "INNER JOIN PLANO_DE_SAUDE ON PACIENTE.cod_Plano = PLANO_DE_SAUDE.cod_plano "
                + "ORDER BY PACIENTE.nome_paciente";
        //Executando a instrução sql
        ResultSet rs = conex.executeQuery(sql);
        while (rs.next()) {
            Consulta c = new Consulta(); 
            c.setNumeroProntuario(rs.getString("numero_prontuario"));
            c.getPaciente().setCpf_Paciente(rs.getString("cpf_paciente"));
            c.getPaciente().setNome(rs.getString("nome_paciente"));
            c.getPaciente().getPlanodeSaude().setNomePlano(rs.getString("nome_plano"));
            c.getMedico().setNome(rs.getString("nome_medico"));
            c.getMedico().getEspecialidade().setNomeEspecialidade(rs.getString("Nome_Especialidade"));
            c.setDataConsulta(rs.getString("TO_CHAR"));
            c.setHoraInicio(rs.getString("Hora_Inicio"));
            c.setHoraFinal(rs.getString("Hora_Final"));
            retorno.add(c);
        }
        //Fechando a conexão com o banco de dados
        desconectar();

        return retorno;

    }

    /**
     *
     * @param c
     * @return
     * @throws Exception
     */

    @Override
    public void MostraProntuario(Consulta c) throws Exception {
 
        //Abrindo a conexão
        Statement conex = conectar();
        //Instrução sql correspondente a seleção dos medicos
      String sql = "SELECT CONSULTA.numero_prontuario, CONSULTA.Descricao_Consulta, CONSULTA.Hora_Inicio, CONSULTA.Hora_Final, TO_CHAR(CONSULTA.Data_Consulta, 'DD/MM/YYYY'), PACIENTE.cpf_paciente, PACIENTE.nome_paciente, PLANO_DE_SAUDE.nome_plano, MEDICO.crm_medico, MEDICO.nome_medico, ESPECIALIDADE.Nome_Especialidade ";
        sql += "FROM CONSULTA "
                + "INNER JOIN PACIENTE ON PACIENTE.CPF_paciente = CONSULTA.CPF_paciente "
                + "INNER JOIN MEDICO ON MEDICO.crm_medico = CONSULTA.crm_medico "
                + "INNER JOIN ESPECIALIDADE ON MEDICO.Cod_Especialidade = ESPECIALIDADE.Cod_Especialidade "
                + "INNER JOIN PLANO_DE_SAUDE ON PACIENTE.cod_Plano = PLANO_DE_SAUDE.cod_plano "
                + "WHERE numero_prontuario = "+ c.getNumeroProntuario()+"";
        //Executando a instrução sql
        ResultSet rs = conex.executeQuery(sql);
        while (rs.next()) {
            c.setNumeroProntuario(rs.getString("numero_prontuario"));
            c.setDescricaoConsulta(rs.getString("Descricao_Consulta"));
            c.setHoraInicio(rs.getString("Hora_Inicio"));
            c.setHoraFinal(rs.getString("Hora_Final"));
            c.setDataConsulta(rs.getString("TO_CHAR"));
            c.getPaciente().setCpf_Paciente(rs.getString("cpf_paciente"));
            c.getPaciente().setNome(rs.getString("nome_paciente"));
            c.getPaciente().getPlanodeSaude().setNomePlano(rs.getString("nome_plano"));
            c.getMedico().setCrm_Medico(rs.getString("crm_medico"));
            c.getMedico().setNome(rs.getString("nome_medico"));
            c.getMedico().getEspecialidade().setNomeEspecialidade(rs.getString("Nome_Especialidade"));
        }
        //Fechando a conexão com o banco de dados
        desconectar();


    }


    @Override
    public boolean verificaExistenciaNumero_Prontuario(Consulta c) throws Exception {
        boolean retorno = false;
        //atribuindo as colunas da tabela

        //abrindo a conexão
        Statement conex = conectar();
        //instrução sql correspondente a seleção dos alunos
        String sql = "SELECT numero_prontuario ";
        sql += "FROM CONSULTA ";
        sql += " WHERE numero_prontuario = '" + c.getNumeroProntuario() + "'";

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
     * @param c
     * @return
     * @throws Exception
     */

    @Override
    public boolean verificaExistenciaCPF(Consulta c) throws Exception {
        boolean retorno = false;
        //atribuindo as colunas da tabela

        //abrindo a conexão
        Statement conex = conectar();
        //instrução sql correspondente a existencia do CPF
        String sql = "SELECT cpf_paciente ";
        sql += "FROM PACIENTE ";
        sql += " WHERE cpf_paciente = '" + c.getPaciente().getCpf_Paciente() + "'";

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
    public boolean verificaExistenciaCRM(Consulta c) throws Exception {
        boolean retorno = false;
        //atribuindo as colunas da tabela

        //abrindo a conexão
        Statement conex = conectar();
        //instrução sql correspondente a existencia do CRM
        String sql = "SELECT crm_medico ";
        sql += "FROM MEDICO ";
        sql += " WHERE crm_medico = '" + c.getMedico().getCrm_Medico() + "'";

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
    public void mostrarMedico(Consulta c) throws Exception {
        //Abrindo a conexão
        Statement conex = conectar();
        //Instrução sql correspondente a seleção dos medicos
        String sql = "SELECT nome_medico, nome_especialidade FROM MEDICO AS M, ESPECIALIDADE AS E WHERE M.cod_especialidade = E.cod_especialidade AND crm_medico = '" + c.getMedico().getCrm_Medico() + "'";
        //Executando a instrução sql
        ResultSet rs = conex.executeQuery(sql);
        while (rs.next()) {
            c.getMedico().setNome(rs.getString("nome_medico"));
            c.getMedico().getEspecialidade().setNomeEspecialidade(rs.getString("nome_especialidade"));

        }
    }


    @Override
    public void mostrarPaciente(Consulta c) throws Exception {
        //Abrindo a conexão
        Statement conex = conectar();
        //Instrução sql correspondente a seleção dos medicos
        String sql = "SELECT nome_paciente, nome_plano FROM PACIENTE AS P, PLANO_DE_SAUDE AS PS WHERE P.cod_plano = PS.cod_plano AND cpf_paciente = '" + c.getPaciente().getCpf_Paciente() + "'";
        //Executando a instrução sql
        ResultSet rs = conex.executeQuery(sql);
        while (rs.next()) {
            c.getPaciente().setNome(rs.getString("nome_paciente"));
            c.getPaciente().getPlanodeSaude().setNomePlano(rs.getString("nome_plano"));

        }
    }





}

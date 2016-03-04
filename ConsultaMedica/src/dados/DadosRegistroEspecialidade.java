/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dados;

import classebasica.Especialidade;
import interfaces.InterfaceRegistroEspecialidade;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author MegaKingBR
 */
public final class DadosRegistroEspecialidade extends Dados implements InterfaceRegistroEspecialidade{
    
        @Override
        public void cadastrar(Especialidade es) throws Exception {
        //Abrindo a conexão
        Statement conex = conectar();
        //Instrução sql correspondente a inserção do ESPECIALIDADE
        String sql = "INSERT INTO ESPECIALIDADE (nome_especialidade, cod_especialidade )";
        sql += "VALUES ('" + es.getNomeEspecialidade() + "',"
                + es.getCodEspecialidade() + ")";
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
    public void atualizar(Especialidade es) throws Exception {
        try {
            //Abrindo a conexão
            Statement conex = conectar();
            //Instrução sql correspondente a atualização da ESPECIALIDADE
            String sql = " UPDATE ESPECIALIDADE SET";
            sql += " nome_especialidade = '" + es.getNomeEspecialidade() + "',  cod_especialidade = " + es.getCodEspecialidade() + "";
            sql += " WHERE numero_prontuario = " + es.getCodEspecialidade() + "";
            //Executando a instrução sql
            conex.execute(sql);
            //Fechando a conexão com o banco de dados
            desconectar();

        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }        

        @Override
    public void remover(Especialidade es) throws Exception {
        try {
         //Abrindo a conexão
         Statement conex = conectar();
         //Instrução sql correspondente a remoção do Especialidade
         String sql = "DELETE FROM ESPECIALIDADE WHERE cod_especialidade = '"+ es.getCodEspecialidade()+"'";
         //Executando a instrução sql
         conex.execute(sql);
         //Fechando a conexão com o banco de dados
         desconectar();
         } catch (Exception ex) {
         JOptionPane.showMessageDialog(null, ex.getMessage());
         }
    }
    
        @Override
        public ArrayList<Especialidade> listEspecialidades() throws Exception {
        ArrayList<Especialidade> retorno = new ArrayList<>();
        //atribuindo as colunas da tabela

        //abrindo a conexão
        Statement conex = conectar();
        //instrução sql correspondente a seleção dos alunos
        String sql = "SELECT cod_especialidade, nome_especialidade FROM ESPECIALIDADE WHERE cod_especialidade >= 1 order by nome_especialidade";

        //executando a instrução sql
        ResultSet rs = conex.executeQuery(sql);
        while (rs.next()) {
            Especialidade es = new Especialidade();
            es.setCodEspecialidade(rs.getString("cod_especialidade"));
            es.setNomeEspecialidade(rs.getString("nome_especialidade"));
            retorno.add(es);
        }
        //fechando a conexão com o banco de dados
        desconectar();

        return retorno;
    } 

        @Override
       public boolean verificaExistenciaCodEspecialidade(Especialidade filtro) throws Exception {
       boolean retorno = false;
        //atribuindo as colunas da tabela

        //abrindo a conexão
        Statement conex = conectar();
        //instrução sql correspondente a seleção dos alunos
        String sql = "SELECT cod_especialidade ";
        sql+= "FROM ESPECIALIDADE ";
        sql += " WHERE cod_especialidade = '" + filtro.getCodEspecialidade()+"'";

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
     * @param filtro
     * @return
     * @throws Exception
     */
    @Override
       public boolean verificaExistencianaNomeEspecialidade(Especialidade filtro) throws Exception {
       boolean retorno = false;
        //atribuindo as colunas da tabela

        //abrindo a conexão
        Statement conex = conectar();
        //instrução sql correspondente a seleção dos alunos
        String sql = "SELECT nome_especialidade ";
        sql+= "FROM ESPECIALIDADE ";
        sql += " WHERE nome_especialidade = '" + filtro.getNomeEspecialidade()+"'";

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

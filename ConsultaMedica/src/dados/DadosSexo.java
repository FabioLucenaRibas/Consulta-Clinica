/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dados;

import classebasica.Sexo;
import interfaces.InterfaceSexo;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;


/**
 *
 * @author MegaKingBR
 */
public final class DadosSexo extends Dados implements InterfaceSexo{
        @Override
        public void cadastrar(Sexo s) throws Exception {
        //Abrindo a conexão
        Statement conex = conectar();
        //Instrução sql correspondente a inserção do SEXO
        String sql = "INSERT INTO SEXO( Nome_sexo, cod_sexo )";
        sql += "VALUES ('" + s.getNome_Sexo() + "', '"
                + s.getCod_Sexo() + ")";
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
    public void atualizar(Sexo s) throws Exception {
        try {
            //Abrindo a conexão
            Statement conex = conectar();
            //Instrução sql correspondente a atualização do SEXO
            String sql = "UPDATE SEXO( Nome_sexo, cod_sexo )";
            sql += "VALUES ('" + s.getNome_Sexo() + "', '"
                + s.getCod_Sexo() + ")";
            //Executando a instrução sql
            conex.execute(sql);
            //Fechando a conexão com o banco de dados
            desconectar();

        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }

        @Override
    public void remover(Sexo s) {
        try {
         //Abrindo a conexão
         Statement conex = conectar();
         /*String crmr =  rm.getRemoverSexo();*/
         //Instrução sql correspondente a remoção do Sexo
         String sql = "DELETE FROM SEXO WHERE cod_sexo = ";
         /*+ crmr;*/

         //Executando a instrução sql
         conex.execute(sql);
         //Fechando a conexão com o banco de dados
         desconectar();
         } catch (Exception ex) {
         JOptionPane.showMessageDialog(null, ex.getMessage());
         }
    }
        @Override
    public ArrayList<Sexo> listSexo() throws Exception {
        ArrayList<Sexo> retorno = new ArrayList<>();
        //atribuindo as colunas da tabela

        //abrindo a conexão
        Statement conex = conectar();
        //instrução sql correspondente a seleção dos planos
        String sql = "SELECT cod_sexo, nome_sexo FROM SEXO WHERE cod_sexo >= 1 order by nome_sexo";

        //executando a instrução sql
        ResultSet rs = conex.executeQuery(sql);
        while (rs.next()) {
            Sexo s = new Sexo();
            s.setCod_Sexo(rs.getInt("cod_sexo"));
            s.setNome_Sexo(rs.getString("nome_sexo"));
            retorno.add(s);
        }
        //fechando a conexão com o banco de dados
        desconectar();

        return retorno;
    }
        @Override
       public boolean verificaExistenciaCodSexo(Sexo filtro) throws Exception {
       boolean retorno = false;
        //atribuindo as colunas da tabela

        //abrindo a conexão
        Statement conex = conectar();
        //instrução sql correspondente a seleção dos Plano
        String sql = "SELECT cod_sexo ";
        sql+= "FROM SEXO ";
        sql += " where cod_sexo = '" + filtro.getCod_Sexo()+"'";

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
       public boolean verificaExistencianaNomeSexo(Sexo filtro) throws Exception {
       boolean retorno = false;
        //atribuindo as colunas da tabela

        //abrindo a conexão
        Statement conex = conectar();
        //instrução sql correspondente a seleção dos Plano
        String sql = "SELECT nome_sexo ";
        sql+= "FROM SEXO ";
        sql+= "WHERE nome_sexo = '" + filtro.getNome_Sexo()+"'";

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

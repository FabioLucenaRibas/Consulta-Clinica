/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocios;

import classebasica.Sexo;
import dados.DadosSexo;
import interfaces.InterfaceSexo;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author MegaKingBR
 */
public class NegocioSexo implements InterfaceSexo{
dados.DadosSexo ds = new DadosSexo();
    /**
     *
     * @param s
     * @throws Exception  //REGISTRO SEXO NÃO APLICADO AO PROGRAMA MAIS ESTAR PRONTO PARA COMEÇA A APLICAÇÃO
     */
    @Override
        public void cadastrar(Sexo s) throws Exception {
    ds.cadastrar(s);

    }
        @Override
    public void atualizar(Sexo s) throws Exception {
    ds.atualizar(s);
    }

    @Override
    public void remover(Sexo s) {
    ds.remover(s);

    }
    @Override
    public ArrayList<Sexo> listSexo() throws Exception {
        return ds.listSexo();
    }

    @Override
    public boolean verificaExistenciaCodSexo(Sexo filtro) throws Exception {
        return ds.verificaExistenciaCodSexo(filtro);
    }

    @Override
    public boolean verificaExistencianaNomeSexo(Sexo filtro) throws Exception {
        return ds.verificaExistencianaNomeSexo(filtro);
    }
}

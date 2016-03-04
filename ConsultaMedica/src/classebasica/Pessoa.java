/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classebasica;
/**
 *
 * @author MegaKingBR
 */
public abstract class Pessoa{
    private String nome;
    private String dataNasimento; 

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }
    /**
     * @return the dataNasimento
     */
    public String getDataNasimento() {
        return dataNasimento;
    }

    /**
     * @param dataNasimento the dataNasimento to set
     */
    public void setDataNasimento(String dataNasimento) {
        this.dataNasimento = dataNasimento;
    }



}

    